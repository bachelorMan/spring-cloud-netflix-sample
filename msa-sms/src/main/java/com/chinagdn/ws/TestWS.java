package com.chinagdn.ws;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.chinagdn.util.secr.Crypto4ADC;

public class TestWS {

    //WEBSERVICE
    private static EndpointReference targetEPR = new EndpointReference("http://101.201.41.112:9000/ctc-ema70/webServices/MasInterfaceForService?wsdl");
    private static String namespace = "http://ws.chinagdn.com";
    private static int count = 1;
	
    private static RPCServiceClient  client = null;
	static {
	    try{   
            client = new RPCServiceClient();
        }catch(Exception e){   
            e.printStackTrace();   
        }   
    }   
    
	public static void main(String[] args) {

		Date now = new Date();
		System.out.println(now+":***************** send ******************");
		for (int i=0;i<count;i++){
			try {
	            Options options = client.getOptions();   
	            options.setTo(targetEPR);   
	            options.setTransportInProtocol(Constants.TRANSPORT_HTTP);   
	            
				SubmitSmsReq req = new SubmitSmsReq();
	
				Header h = new Header();
				h.setMsgType("SubmitSmsReq");
				String serviceID = "999999";
				h.setServiceID(serviceID);
				h.setTimeStamp(genenalTimestamp());
				h.setTransationID(genenalSid());
				h.setVersion("V1.0.1");
				req.setHeader(h);
				StringBuffer sb = new StringBuffer();
	
				sb.append("<Body>")
				  .append("<ServiceNumber>").append(serviceID).append("</ServiceNumber>")
				  .append("<UserNumberList>")
				  .append("<RecPhone>13824455752</RecPhone>")
				  .append("</UserNumberList>")
				  .append("<SmsContent>hello world!"+i).append("</SmsContent>")
				  .append("<Priority>1</Priority>")
				  .append("<SmsFmt>15</SmsFmt>")
				  .append("<AtTime></AtTime>")
				  .append("<ValidTime></ValidTime>")
				  .append("<ServiceCode>01</ServiceCode>")
				  .append("<ReportFlag>0</ReportFlag>")
				  .append("<Reserve></Reserve>")
				  .append("</Body>");
	
				req.setBody(encode(sb.toString()));
				//req.setBody(sb.toString());
	            Object[] arg = new Object[]{req};               
	            Class[] classes = new Class[]{SubmitSmsResp.class};
	            QName opName = new QName(namespace,"submitSms");   
				SubmitSmsResp result = (SubmitSmsResp)client.invokeBlocking(opName,arg,classes)[0];
				if (result != null)
					System.out.println(toString(result));
			} catch (AxisFault e) {
				System.out.println("=========");
				e.printStackTrace();
			}
		}
		System.out.println(new Date()+":***************** end ******************");
	}
	
	final static String MIYAO = "100C0769EF6DE126";
	final static String VERSION = "V1.0";
	final static String TBLSENDTASK_SERVICEID = "GWWS";	
	
	public static hello.wsdl.SubmitSmsReq sample() {
		hello.wsdl.ObjectFactory of = new hello.wsdl.ObjectFactory();
		
		hello.wsdl.SubmitSmsReq req = of.createSubmitSmsReq();
		hello.wsdl.Header h = of.createHeader();
		
		h.setMsgType(of.createHeaderMsgType("SubmitSmsReq"));
		String serviceID = "999999";
		h.setServiceID(of.createHeaderServiceID(serviceID));
		h.setTimeStamp(of.createHeaderTimeStamp(genenalTimestamp()));
		h.setTransationID(of.createHeaderTransationID(genenalSid()));
		h.setVersion(of.createHeaderVersion("V1.0.1"));
		req.setHeader(of.createSubmitSmsReqHeader(h));
		StringBuffer sb = new StringBuffer();

		sb.append("<Body>")
		  .append("<ServiceNumber>").append(serviceID).append("</ServiceNumber>")
		  .append("<UserNumberList>")
		  .append("<RecPhone>13824455752</RecPhone>")
		  .append("</UserNumberList>")
		  .append("<SmsContent>hello world!</SmsContent>")
		  .append("<Priority>1</Priority>")
		  .append("<SmsFmt>15</SmsFmt>")
		  .append("<AtTime></AtTime>")
		  .append("<ValidTime></ValidTime>")
		  .append("<ServiceCode>01</ServiceCode>")
		  .append("<ReportFlag>0</ReportFlag>")
		  .append("<Reserve></Reserve>")
		  .append("</Body>");

		req.setBody(of.createSubmitSmsRespBody(encode(sb.toString())));

		return req;
	}
	
	//SID
	static String genenalSid(){
		String sid = "";
		sid = System.currentTimeMillis() + "";
		int len = sid.length()-16;
		if (len > 0){
			sid = sid.substring(len,len+16);
		}else if (len < 0){
			for (int i=0;i<Math.abs(len);i++){
				sid = "0"+sid;
			}
		}
		return sid;
	}
	
	static String genenalTimestamp(){
		String t = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		t = sdf.format(new Date());
		return t;
	}
	
	static String encode(String s){
		if (s == null || s.trim().length()==0){
			return null;
		}
		s = s.trim();
		try{
			s = Crypto4ADC.encode(MIYAO, s);
		}catch(Exception e ){
			System.out.println(" "+e.toString());
			e.printStackTrace();
		}
		return s;
	}

    public static String decode(String s) throws UnsupportedEncodingException, GeneralSecurityException,Exception{
		if (s == null || s.trim().length()==0){
			return null;
		}
		s = s.trim();
		s = Crypto4ADC.decode(MIYAO, s);
		return s;		
	}
	
	static String toString(SubmitSmsResp result){
		Header h = result.getHeader();
		String body = result.getBody();
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version = \"1.0\" encoding=\"UTF-8\"?>\n")
		.append("<"+h.getMsgType()+">\n")
		.append("<Header>\n")
		.append("<MsgType>"+h.getMsgType()+"</MsgType>\n")
		.append("<ServiceID>"+h.getServiceID()+"</ServiceID>\n")
		.append("<TransationID>"+h.getTransationID()+"</TransationID>\n")
		.append("<TimeStamp>"+h.getTimeStamp()+"</TimeStamp>\n")
		.append("<Version>"+h.getVersion()+"</Version>\n")
		.append("</Header>\n");

		try{
			sb.append(decode(body));
		}catch(Exception e){
			
		}
		sb.append("\n</"+h.getMsgType()+">\n");	
		return sb.toString();
	}
}

