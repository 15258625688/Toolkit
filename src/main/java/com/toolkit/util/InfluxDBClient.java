package com.toolkit.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.dto.Point.Builder;
import org.influxdb.impl.TimeUtil;

public class InfluxDBClient {
    // 用户名
    private String username;
    // 密码
    private String password;
    // 连接地址
    private String openurl;
    // 数据库
    private String database;
    // 保留策略
    private String retentionPolicy;

    private InfluxDB influxDB;

    public InfluxDBClient(String username, String password, String openurl, String database) {
	this(username, password, openurl, database, null);
    }

    public InfluxDBClient(String username, String password, String openurl, String database, String retentionPolicy) {
	this.username = username;
	this.password = password;
	this.openurl = openurl;
	this.database = database;
	this.retentionPolicy = retentionPolicy == null ? "autogen" : retentionPolicy;
	influxDbBuild();
    }

    private int pingFailureCount = 0;

    public boolean ping() {
	Pong pong = influxDB.ping();
	if (pong == null) {
	    pingFailureCount++;
	    if (pingFailureCount > 3) {
		pingFailureCount = 0;
		throw new InfluxDBException("connection influxdb failure");
	    }
	    return false;
	}
	pingFailureCount = 0;
	return true;
    }

    public InfluxDB influxDbBuild() {
	if (influxDB == null) {
	    influxDB = InfluxDBFactory.connect(openurl, username, password);
	}
	influxDB.setRetentionPolicy(retentionPolicy);
	influxDB.setLogLevel(InfluxDB.LogLevel.NONE);
	return influxDB;
    }

    public QueryResult query(String command) throws Exception {
	if (influxDB != null && ping())
	    return influxDB.query(new Query(command, database));
	influxDbBuild();
	return query(command);
    }

    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields, String time) {
	if (influxDB != null && ping()) {
	    Builder builder = Point.measurement(measurement);
	    builder.tag(tags);
	    builder.fields(fields);
	    if (time != null)
		builder.time(TimeUtil.fromInfluxDBTimeFormat(time), TimeUnit.MILLISECONDS);
	    influxDB.write(database, retentionPolicy, builder.build());
	    return;
	}
	influxDbBuild();
	insert(measurement, tags, fields, time);
    }

    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields, long timeStamp) {
	if (influxDB != null && ping()) {
	    Builder builder = Point.measurement(measurement);
	    builder.tag(tags);
	    builder.fields(fields);
	    builder.time(timeStamp, TimeUnit.MILLISECONDS);
	    influxDB.write(database, retentionPolicy, builder.build());
	    return;
	}
	influxDbBuild();
	insert(measurement, tags, fields, timeStamp);
    }

    public void close() {
	if (influxDB != null)
	    influxDB.close();
    }

    public static void main(String[] args) throws Exception {
	InfluxDBClient client = new InfluxDBClient("makepower", "makepower", "http://172.28.88.168:8086",
		"datacenterplatform");
	QueryResult r = client.query(
		"select * from fsuhisdata202006 where time>'2020-06-20T00:00:00Z' and suID='5E-2E-BA-4E-D3-69' and deviceID='000003' and spID='130821140010'");
	System.out.println(r);
    }
}
