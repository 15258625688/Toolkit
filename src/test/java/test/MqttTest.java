package test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.junit.Test;

import com.toolkit.mqtt.MqttClient;

public class MqttTest {
    @Test
    public void test1() throws MqttSecurityException, MqttException {
	MqttClient client = new MqttClient("tcp://172.28.88.162:1883", "iotuser", "password", "test");
	client.connect();
	List<String> tops = new ArrayList<String>();
	tops.add("test-+");
	String[] arr = tops.toArray(new String[tops.size()]);
	client.subscribe(arr);
	while (true) {

	}
    }
}
