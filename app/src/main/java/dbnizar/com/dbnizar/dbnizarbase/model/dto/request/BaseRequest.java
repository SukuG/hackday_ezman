package dbnizar.com.dbnizar.dbnizarbase.model.dto.request;

import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class BaseRequest {

    private int status;
    private String message;

    public BaseRequest() {
    }

    public BaseRequest(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
