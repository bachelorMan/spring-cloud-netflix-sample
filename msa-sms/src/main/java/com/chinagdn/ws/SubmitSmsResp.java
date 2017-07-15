package com.chinagdn.ws;

import java.io.Serializable;

public class SubmitSmsResp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private com.chinagdn.ws.Header Header;
    private java.lang.String Body;
    
	public SubmitSmsResp() {
		super();
	}

	public SubmitSmsResp(Header header, String body) {
		super();
		Header = header;
		Body = body;
	}

	public com.chinagdn.ws.Header getHeader() {
		return Header;
	}

	public void setHeader(com.chinagdn.ws.Header header) {
		Header = header;
	}

	public java.lang.String getBody() {
		return Body;
	}

	public void setBody(java.lang.String body) {
		Body = body;
	}
	
}
