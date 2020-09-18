package com.toolkit.entity;

import java.util.List;
import java.util.Map;

public class DeviceAlter {
    private int typeId;
    private int version;
    private List<Alter> alters;

    public int getTypeId() {
	return typeId;
    }

    public void setTypeId(int typeId) {
	this.typeId = typeId;
    }

    public int getVersion() {
	return version;
    }

    public void setVersion(int version) {
	this.version = version;
    }

    public List<Alter> getAlters() {
	return alters;
    }

    public void setAlters(List<Alter> alters) {
	this.alters = alters;
    }

    @Override
    public String toString() {
	return "DeviceAlter [typeId=" + typeId + ", version=" + version + ", alters=" + alters + "]";
    }

    public static class Alter {
	private String cmd;
	private List<AlterParam> alterParams;

	public String getCmd() {
	    return cmd;
	}

	public void setCmd(String cmd) {
	    this.cmd = cmd;
	}

	public List<AlterParam> getAlterParams() {
	    return alterParams;
	}

	public void setAlterParams(List<AlterParam> alterParams) {
	    this.alterParams = alterParams;
	}

	@Override
	public String toString() {
	    return "Alter [cmd=" + cmd + ", alterParams=" + alterParams + "]";
	}
	
    }

    public static class AlterParam {
	private String paramName;
	private String paramType;
	private int max;
	private int min;
	private Map<String, Integer> enums;
	private Object value;

	public String getParamName() {
	    return paramName;
	}

	public void setParamName(String paramName) {
	    this.paramName = paramName;
	}

	public String getParamType() {
	    return paramType;
	}

	public void setParamType(String paramType) {
	    this.paramType = paramType;
	}

	public int getMax() {
	    return max;
	}

	public void setMax(int max) {
	    this.max = max;
	}

	public int getMin() {
	    return min;
	}

	public void setMin(int min) {
	    this.min = min;
	}

	public Map<String, Integer> getEnums() {
	    return enums;
	}

	public void setEnums(Map<String, Integer> enums) {
	    this.enums = enums;
	}

	public Object getValue() {
	    return value;
	}

	public void setValue(Object value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return "AlterParam [paramName=" + paramName + ", paramType=" + paramType + ", max=" + max + ", min=" + min
		    + ", enums=" + enums + ", value=" + value + "]";
	}
    }
}
