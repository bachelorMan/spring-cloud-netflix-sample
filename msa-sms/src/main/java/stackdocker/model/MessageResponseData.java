package stackdocker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.*;

@Data
@ApiModel(description="Structure returned by sendMessage method")
public class MessageResponseData {

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "Message ID", required = true)
    public String id;

    @JsonProperty(required = false)
    @ApiModelProperty(notes = "SMS ID", required = false)
    public String smsId;
}
