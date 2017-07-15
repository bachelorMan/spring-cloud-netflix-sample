package stackdocker.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.chinagdn.ws.TestWS;
import hello.wsdl.SubmitSms;
import hello.wsdl.SubmitSmsReq;
import hello.wsdl.SubmitSmsResp;
import stackdocker.model.ErrorResult;
import stackdocker.model.Health;
import stackdocker.model.MessageResponseData;
import stackdocker.sms.SubmitClient;

import java.time.*;
import java.time.temporal.ChronoUnit;

@Slf4j
@Controller()
@Api(value="Message Controller microservice", description="Message Controller microservice API (MSA-SMS)")
@RequestMapping("/v1")
class MessageController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageController.class);

    private static final String X_MY_PROCESS_TIME = "X-MyProcessTime";
    private static final String X_MY_TIMESTAMP = "X-MyTimestampt";

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private SubmitClient submitClient;

	@ApiOperation(tags = {"sample"},
        value = "Sending message operation",
        notes = "Asynchronous sending message",
        response = MessageResponseData.class,
		responseHeaders = {
			@ResponseHeader(name = X_MY_PROCESS_TIME, description = "Hotelbeds audit data: process time (in ms)", response = Integer.class),
			@ResponseHeader(name = X_MY_TIMESTAMP, description = "Hotelbeds audit data: timestamp", response = LocalDateTime.class),
		})
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response"),
        @ApiResponse(code = 500, message = "Unexpected error",  response = ErrorResult.class) })
	@RequestMapping(value="/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> sendMessage() {
        LocalDateTime timestamp = LocalDateTime.now();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(X_MY_TIMESTAMP, timestamp.toString());

        SubmitSmsResp response = submitClient.send(TestWS.sample());
		System.err.println(response);

		String body;
		try {
		    body = TestWS.decode(response.getBody().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			ErrorResult er = new ErrorResult();
			er.setCode(2000);
			er.setError("Failed to invoke SMS WS, error: " + e.toString());
           httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
			return new ResponseEntity<ErrorResult>(er, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(body);
			
		MessageResponseData result = new MessageResponseData();
		result.setId(response.getHeader().getValue().getTransationID().getValue());		
		result.setSmsId("fake id");
		
        LOGGER.info("ReST response");
        httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
		return new ResponseEntity<MessageResponseData>(result, httpHeaders, HttpStatus.OK);
    }

	@ApiOperation(tags = {"sample"},
        value = "health",
        notes = "echo",
        response = Health.class,
		responseHeaders = {
			@ResponseHeader(name = X_MY_PROCESS_TIME, description = "Hotelbeds audit data: process time (in ms)", response = Integer.class),
			@ResponseHeader(name = X_MY_TIMESTAMP, description = "Hotelbeds audit data: timestamp", response = LocalDateTime.class),
		})
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response"),
        @ApiResponse(code = 500, message = "Unexpected error",  response = ErrorResult.class) })
	@RequestMapping(value="/health", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> echo(@PathVariable String info) {
        LocalDateTime timestamp = LocalDateTime.now();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(X_MY_TIMESTAMP, timestamp.toString());

		/* Simulate some computing time */
		try {
			Thread.sleep((int) (Math.random() * 250) + 25);
		} catch (InterruptedException e) {
			// do nothing
		}

		/* Fail sometimes ...  */
		if (Math.random() > 0.95) {
            ErrorResult error = new ErrorResult();
            error.setCode(1);
            error.setError("Just decided to fail to make life more interesting");
            httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
            return new ResponseEntity<ErrorResult>(error, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

		/* Simulate latency spikes % of the time */
		if (Math.random() > 0.95) {
			LOGGER.info("random latency spike !!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
                // ???
			}
		}

		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		Health result = new Health();
		result.setHost(localInstance.getHost());
		result.setPort(localInstance.getPort());
		result.setServiceId(localInstance.getServiceId());
		result.setDate(LocalDate.now());
		result.setDateTime(LocalDateTime.now());
		result.setTime(LocalTime.now());
		result.setOffsetDateTime(OffsetDateTime.now());
		result.setOffsetTime(OffsetTime.now());
		result.setResult(info);
        LOGGER.info("echo health");
        httpHeaders.set(X_MY_PROCESS_TIME, Long.toString(ChronoUnit.MILLIS.between(timestamp, LocalDateTime.now())));
		return new ResponseEntity<Health>(result, httpHeaders, HttpStatus.OK);
	}
}
