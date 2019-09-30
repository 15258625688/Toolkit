package com.toolkit.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Device {
	@XmlAttribute(name = "Id")
	private String id;
	@XmlAttribute(name = "RId")
	private String rId;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", rId=" + rId + "]";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}
}
