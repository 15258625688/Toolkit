package com.toolkit.obj.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestObjectPoolClass {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public TestObjectPoolClass() {
	this.newObjectTime = FORMAT.format(new Date());
	this.uuid = UUID.randomUUID().toString();
    }

    private String newObjectTime;

    private String uuid;

    public String getNewObjectTime() {
	return newObjectTime;
    }

    public void setNewObjectTime(String newObjectTime) {
	this.newObjectTime = newObjectTime;
    }

    @Override
    public String toString() {
	return "TestObjectPoolClass [newObjectTime=" + newObjectTime + ", uuid=" + uuid + "]";
    }

}
