package com.toolkit.mqtt;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.toolkit.util.LoggerUtil;

public class AbstractMqttCallBack implements MqttCallback {

    private Logger logger = LoggerUtil.getLogger(this.getClass().getName());

    public void connectionLost(Throwable cause) {
	logger.error(cause.getMessage(), cause);
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
	logger.info(topic);
	logger.info(message.getQos());
	logger.info(message);
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
	logger.info(token);
    }

}
