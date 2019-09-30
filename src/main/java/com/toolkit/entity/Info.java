package com.toolkit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Info {
	@XmlElement(name = "UserName")
	private String userName;
	@XmlElement(name = "PassWord")
	private String passWord;
	@XmlElement(name = "SUId")
	private String suId;
	@XmlElement(name = "SURId")
	private String suRId;
	@XmlElement(name = "SUIP")
	private String suIP;
	@XmlElement(name = "SUPort")
	private String suPort;
	@XmlElement(name = "SUVendor")
	private String suVendor;
	@XmlElement(name = "SUModel")
	private String suModel;
	@XmlElement(name = "SUHardVer")
	private String suHardVer;
	@XmlElement(name = "SUConfigTime")
	private String suConfigTime;
	@XmlElement(name = "DeviceList")
	private List<Device> deviceList;
	@XmlElement(name = "SUVer")
	private String suVer;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSuId() {
		return suId;
	}

	public void setSuId(String suId) {
		this.suId = suId;
	}

	public String getSuRId() {
		return suRId;
	}

	public void setSuRId(String suRId) {
		this.suRId = suRId;
	}

	public String getSuIP() {
		return suIP;
	}

	public void setSuIP(String suIP) {
		this.suIP = suIP;
	}

	public String getSuPort() {
		return suPort;
	}

	public void setSuPort(String suPort) {
		this.suPort = suPort;
	}

	public String getSuVendor() {
		return suVendor;
	}

	public void setSuVendor(String suVendor) {
		this.suVendor = suVendor;
	}

	public String getSuModel() {
		return suModel;
	}

	public void setSuModel(String suModel) {
		this.suModel = suModel;
	}

	public String getSuHardVer() {
		return suHardVer;
	}

	public void setSuHardVer(String suHardVer) {
		this.suHardVer = suHardVer;
	}

	public String getSuConfigTime() {
		return suConfigTime;
	}

	public void setSuConfigTime(String suConfigTime) {
		this.suConfigTime = suConfigTime;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public String getSuVer() {
		return suVer;
	}

	public void setSuVer(String suVer) {
		this.suVer = suVer;
	}

	@Override
	public String toString() {
		return "Info [userName=" + userName + ", passWord=" + passWord + ", suId=" + suId + ", suRId=" + suRId
				+ ", suIP=" + suIP + ", suPort=" + suPort + ", suVendor=" + suVendor + ", suModel=" + suModel
				+ ", suHardVer=" + suHardVer + ", suConfigTime=" + suConfigTime + ", deviceList=" + deviceList
				+ ", suVer=" + suVer + "]";
	}
}
