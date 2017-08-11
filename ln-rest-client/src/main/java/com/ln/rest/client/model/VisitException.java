package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class VisitException extends SandataMessage {

    public VisitException() {}

    public VisitException(
            String exceptionID,
            Boolean exceptionAcknowledged
    ) {
        setExceptionID(exceptionID);
        setExceptionAcknowledged(exceptionAcknowledged);

    }


    @NotNull(message = "{visit.visitexception.ExceptionID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 2, message = "{visit.visitexception.ExceptionID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "15|25|28|39", message = "{visit.visitexception.ExceptionID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ExceptionID")
    @Expose
    private String exceptionID;


    @NotNull(message = "{visit.visitexception.ExceptionAcknowledged.null.msg}", groups = DataChecks.class)
    @SerializedName("ExceptionAcknowledged")
    @Expose
    private Boolean exceptionAcknowledged;

    public String getExceptionID() {
        return exceptionID;
    }

    public void setExceptionID(String exceptionID) {
        this.exceptionID = ValidateHelper.truncateValue(getClass(), "exceptionID", exceptionID);
    }

    public Boolean getExceptionAcknowledged() {
        return exceptionAcknowledged;
    }

    public void setExceptionAcknowledged(Boolean exceptionAcknowledged) {
        this.exceptionAcknowledged = exceptionAcknowledged==null? false: exceptionAcknowledged;
    }

    public String toString() {
        String data =
                "Visit.VisitException["
                        + "exceptionID=" + exceptionID
                        + ",exceptionAcknowledged=" + exceptionAcknowledged
                        + "]";

        return data;

    }

}
