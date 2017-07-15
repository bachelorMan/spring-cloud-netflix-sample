
package stackdocker.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

import hello.wsdl.ObjectFactory;
import hello.wsdl.SubmitSms;
import hello.wsdl.SubmitSmsReq;
import hello.wsdl.SubmitSmsResp;

@Component
public class SubmitClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(SubmitClient.class);

	public SubmitSmsResp send(SubmitSmsReq req) {

		SubmitSms request = new SubmitSms();
		
		ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<SubmitSmsReq> value = objectFactory.createSubmitSmsSubmitSmsReq(req);
		request.setSubmitSmsReq(value);

		log.info("Requesting message for " + req);

		SubmitSmsResp response = (SubmitSmsResp) getWebServiceTemplate()
				.marshalSendAndReceive("http://ws.chinagdn.com/submitSms",
						request,
						new SoapActionCallback("http://ecp2.sgcc.com.cn/submitsms"));

		return response;
	}

}
