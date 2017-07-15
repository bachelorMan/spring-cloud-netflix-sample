package com.chinagdn.ws;

import java.io.Serializable;

public class Header implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private java.lang.String MsgType;
	private java.lang.String ServiceID;
	private java.lang.String TransationID;
	private java.lang.String TimeStamp;
	private java.lang.String Version;
	
	public Header() {

	}

	public Header(String msgType, String serviceID, String transationID,
			String timeStamp, String version) {
		super();
		MsgType = msgType;
		ServiceID = serviceID;
		TransationID = transationID;
		TimeStamp = timeStamp;
		Version = version;
	}

	public java.lang.String getMsgType() {
		return MsgType;
	}

	public void setMsgType(java.lang.String msgType) {
		MsgType = msgType;
	}

	public java.lang.String getServiceID() {
		return ServiceID;
	}

	public void setServiceID(java.lang.String serviceID) {
		ServiceID = serviceID;
	}

	public java.lang.String getTransationID() {
		return TransationID;
	}

	public void setTransationID(java.lang.String transationID) {
		TransationID = transationID;
	}

	public java.lang.String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(java.lang.String timeStamp) {
		TimeStamp = timeStamp;
	}

	public java.lang.String getVersion() {
		return Version;
	}

	public void setVersion(java.lang.String version) {
		Version = version;
	}
	
}
