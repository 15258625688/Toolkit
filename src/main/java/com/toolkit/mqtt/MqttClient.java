package com.toolkit.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MqttClient {

    private final static int DEFAULT_CONNECTION_TIMEOUT = 10;

    private final static int DEFAULT_KEEP_ALIVE_INTERVAL = 20;

    private String host;

    private String username;

    private String password;

    private String clientId;

    private org.eclipse.paho.client.mqttv3.MqttClient client;

    private MqttConnectOptions options;

    public MqttClient(String host, String username, String password, String clientId) {
	this.host = host;
	this.username = username;
	this.password = password;
	this.clientId = clientId;
	initMqttClient();
    }

    private void initMqttClient() {
	try {
	    client = new org.eclipse.paho.client.mqttv3.MqttClient(host, clientId);
	    options = initDefaultMqttConnectOptions(username, password);
	    client.setCallback(new AbstractMqttCallBack());
	} catch (MqttException e) {
	    e.printStackTrace();
	}
    }

    public void subscribe(String topicFilter) throws MqttException {
	client.subscribe(topicFilter);
    }

    public void subscribe(String[] topicFilters) throws MqttException {
	client.subscribe(topicFilters);
    }

    public void connect() throws MqttSecurityException, MqttException {
	client.connect(options);
    }

    public void disconnect() throws MqttException {
	client.disconnect();
    }

    public void close() throws MqttException {
	client.close();
    }

    private static MqttConnectOptions initDefaultMqttConnectOptions(String username, String password) {
	MqttConnectOptions options = new MqttConnectOptions();
	options.setCleanSession(false);
	options.setUserName(username);
	options.setPassword(password.toCharArray());
	options.setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
	options.setKeepAliveInterval(DEFAULT_KEEP_ALIVE_INTERVAL);
	return options;
    }
}
