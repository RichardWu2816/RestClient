package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by richardwu on 3/6/2017.
 */
public class VisitChange extends SandataMessage {

    public VisitChange() {}

    public VisitChange(
            String sequenceID,
            String changeMadeByEmail,
            Date changeDateTime,
            String reasonCode,
            String changeReasonMemo,
            String resolutionCode
    ) {

        setSequenceID(sequenceID);
        setChangeMadeByEmail(changeMadeByEmail);
        setChangeDateTime(changeDateTime);
        setReasonCode(reasonCode);
        setChangeReasonMemo(changeReasonMemo);
        setResolutionCode(resolutionCode);

    }


    @NotNull(message = "{visit.visitchange.SequenceID.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=16, message = "{visit.visitchange.SequenceID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,16}", message = "{visit.visitchange.SequenceID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("SequenceID")
    @Expose
    private String sequenceID;

    @NotNull(message = "{visit.visitchange.ChangeMadeByEmail.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{visit.visitchange.ChangeMadeByEmail.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^(?=.{1,64}$)[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,4})$", message = "{visit.visitchange.ChangeMadeByEmail.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ChangeMadeByEmail")
    @Expose
    private String changeMadeByEmail;

    @NotNull(message = "{visit.visitchange.ChangeDateTime.null.msg}", groups = DataChecks.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Past( message = "{visit.visitchange.ChangeDateTime.past.msg}", groups = DataChecks.class)
    @SerializedName("ChangeDateTime")
    @Expose
    private Date changeDateTime;     //Required

    @NotNull(message = "{visit.visitchange.ReasonCode.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 4, message = "{visit.visitchange.ReasonCode.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,4}", message = "{visit.visitchange.ReasonCode.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ReasonCode")
    @Expose
    private String reasonCode;

    @Size(min = 1, max = 256, message = "{visit.visitchange.ChangeReasonMemo.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\s*(?:\\S\\s*){1,256}$", message = "{visit.visitchange.ChangeReasonMemo.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ChangeReasonMemo")
    @Expose
    private String changeReasonMemo;

    @NotNull(message = "{visit.visitchange.ResolutionCode.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 4, message = "{visit.visitchange.ResolutionCode.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "A|a", message = "{visit.visitchange.ResolutionCode.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ResolutionCode")
    @Expose
    private String resolutionCode;

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {

        this.sequenceID = ValidateHelper.truncateValue(getClass(), "sequenceID", sequenceID);

    }

    public String getChangeMadeByEmail() {
        return changeMadeByEmail;
    }

    public void setChangeMadeByEmail(String changeMadeByEmail) {

        this.changeMadeByEmail = ValidateHelper.truncateValue(getClass(), "changeMadeByEmail", changeMadeByEmail);

    }

    public Date getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(Date changeDateTime) {
        this.changeDateTime = changeDateTime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {

        this.reasonCode = ValidateHelper.truncateValue(getClass(), "reasonCode", reasonCode);
    }

    public String getChangeReasonMemo() {
        return changeReasonMemo;
    }

    public void setChangeReasonMemo(String changeReasonMemo) {
        this.changeReasonMemo = ValidateHelper.truncateValue(getClass(), "changeReasonMemo", changeReasonMemo);
    }

    public String getResolutionCode() {
        return resolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {

        this.resolutionCode = ValidateHelper.truncateValue(getClass(), "resolutionCode", resolutionCode);
    }

    public String toString() {
        String data =
                "Visit.VisitChange["
                        + "sequenceID=" + sequenceID
                        + ",changeMadeByEmail=" + changeMadeByEmail
                        + ",changeDateTime=" + changeDateTime
                        + ",reasonCode=" + reasonCode
                        + ",changeReasonMemo=" + changeReasonMemo
                        + ",resolutionCode=" + resolutionCode
                        + "]";

        return data;

    }

}

