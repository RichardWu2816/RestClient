package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by richardwu on 3/6/2017.
 */
public class Call extends SandataMessage {

    public Call() {
    }

    public Call(

            String callExternalID,
            Date callDateTime,
            String callAssignment,
            String callType,
            String procedureCode,
            String patientIdentifierOnCall,
            String mobileLogin,
            BigDecimal callLatitude,
            BigDecimal callLongitude,
            String telephonyPIN,
            String originatingPhoneNumber
    ) {

        setCallExternalID(callExternalID);
        setCallDateTime(callDateTime);
        setCallAssignment(callAssignment);
        setCallType(callType);
        setProcedureCode(procedureCode);
        setPatientIdentifierOnCall(patientIdentifierOnCall);
        setMobileLogin(mobileLogin);
        setCallLatitude(callLatitude);
        setCallLongitude(callLongitude);
        setTelephonyPIN(telephonyPIN);
        setOriginatingPhoneNumber(originatingPhoneNumber);

    }

    @NotNull(message = "{visit.call.CallExternalID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 16, message = "{visit.call.CallExternalID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,16}", message = "{visit.call.CallExternalID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("CallExternalID")
    @Expose
    private String callExternalID;

    @NotNull(message = "{visit.call.CallDateTime.null.msg}", groups = DataChecks.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Past( message = "{visit.call.CallDateTime.past.msg}", groups = DataChecks.class)
    @SerializedName("CallDateTime")
    @Expose
    private Date callDateTime;     //Required

    @NotNull(message = "{visit.call.CallAssignment.null.msg}", groups = DataChecks.class)
    @Size(max = 10, message = "{visit.call.CallAssignment.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "Call In|Call Out|Interim|Call in|Call out|Interim|CallIn|CallOut|Interim|call in|call out|interim|call in|call out|interim|callin|callout|interim|CALL IN|CALL OUT|INTERIM|CALL IN|CALL OUT|INTERIM|CALLIN|CALLOUT|INTERIM", message = "{visit.call.CallAssignment.pattern.msg}", groups = DataChecks.class)
    @SerializedName("CallAssignment")
    @Expose
    private String callAssignment;

    @NotNull(message = "{visit.call.CallType.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 20, message = "{visit.call.CallType.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "Telephony|Mobile|Manual|Other", message = "{visit.call.CallType.pattern.msg}", groups = DataChecks.class)
    @SerializedName("CallType")
    @Expose
    private String callType;

    @Size(min = 5, max = 5, message = "{visit.call.ProcedureCode.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "G0156|G0299|G0300|S5125|T1000|T1001|T1002|T1003|T1019|g0156|g0299|g0300|s5125|t1000|t1001|t1002|t1003|t1019", message = "{visit.call.ProcedureCode.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ProcedureCode")
    @Expose
    private String procedureCode;

    @Size(min = 1, max = 10, message = "{visit.call.PatientIdentifierOnCall.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,10}", message = "{visit.call.PatientIdentifierOnCall.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientIdentifierOnCall")
    @Expose
    private String patientIdentifierOnCall;

    @Size(min = 1, max = 64, message = "{visit.call.MobileLogin.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}", message = "{visit.call.MobileLogin.pattern.msg}", groups = DataChecks.class)
    @SerializedName("MobileLogin")
    @Expose
    private String mobileLogin;

    @DecimalMax(value = "90", message = "{visit.call.CallLatitude.DecimalMax.msg}", groups = DataChecks.class)
    @DecimalMin(value = "-90", message = "{visit.call.CallLatitude.DecimalMin.msg}", groups = DataChecks.class)
    @SerializedName("CallLatitude")
    @Expose
    private BigDecimal callLatitude;

    @DecimalMax(value = "180", message = "{visit.call.CallLongitude.DecimalMax.msg}", groups = DataChecks.class)
    @DecimalMin(value = "-180", message = "{visit.call.CallLongitude.DecimalMin.msg}", groups = DataChecks.class)
    @SerializedName("CallLongitude")
    @Expose
    private BigDecimal callLongitude;

    @Size(min = 1, max = 9, message = "{visit.call.TelephonyPIN.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,9}", message = "{visit.call.TelephonyPIN.pattern.msg}", groups = DataChecks.class)
    @SerializedName("TelephonyPIN")
    @Expose
    private String telephonyPIN;

    @Size(min = 10, max = 10, message = "{visit.call.OriginatingPhoneNumber.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,10}", message = "{visit.call.OriginatingPhoneNumber.pattern.msg}", groups = DataChecks.class)
    @SerializedName("OriginatingPhoneNumber")
    @Expose
    private String originatingPhoneNumber;

    public String getCallExternalID() {
        return callExternalID;
    }

    public void setCallExternalID(String callExternalID) {
        this.callExternalID = ValidateHelper.truncateValue(getClass(), "callExternalID", callExternalID);
    }

    public Date getCallDateTime() {
        return callDateTime;
    }

    public void setCallDateTime(Date callDateTime) {
        this.callDateTime = callDateTime;
    }

    public String getCallAssignment() {
        return callAssignment;
    }

    public void setCallAssignment(String callAssignment) {
        this.callAssignment = ValidateHelper.truncateValue(getClass(), "callAssignment", callAssignment);
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {

        this.callType = ValidateHelper.replaceDefaultValue(getClass(), "callType", callType, "Other");

    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = ValidateHelper.replaceDefaultValue(getClass(), "procedureCode", procedureCode, null);
    }

    public String getPatientIdentifierOnCall() {
        return patientIdentifierOnCall;
    }

    public void setPatientIdentifierOnCall(String patientIdentifierOnCall) {
        this.patientIdentifierOnCall = ValidateHelper.truncateValue(getClass(), "patientIdentifierOnCall", patientIdentifierOnCall);
    }

    public String getMobileLogin() {
        return mobileLogin;
    }

    public void setMobileLogin(String mobileLogin) {

        this.mobileLogin = ValidateHelper.truncateValue(getClass(), "mobileLogin", mobileLogin);
    }

    public BigDecimal getCallLatitude() {
        return callLatitude;
    }

    public void setCallLatitude(BigDecimal callLatitude) {

        this.callLatitude = ValidateHelper.convertBigDecimalInRange(getClass(), "callLatitude", callLatitude,new BigDecimal(0.0));
    }

    public BigDecimal getCallLongitude() {
        return callLongitude;
    }

    public void setCallLongitude(BigDecimal callLongitude) {
        this.callLongitude = ValidateHelper.convertBigDecimalInRange(getClass(), "callLongitude", callLongitude, new BigDecimal(0.0));
    }

    public String getTelephonyPIN() {
        return telephonyPIN;
    }

    public void setTelephonyPIN(String telephonyPIN) {

        this.telephonyPIN = ValidateHelper.truncateValue(getClass(), "telephonyPIN", telephonyPIN);
    }

    public String getOriginatingPhoneNumber() {
        return originatingPhoneNumber;
    }

    public void setOriginatingPhoneNumber(String originatingPhoneNumber) {
        this.originatingPhoneNumber = ValidateHelper.replaceDefaultValue(getClass(), "originatingPhoneNumber", originatingPhoneNumber, null);
    }

    public String toString() {
        String data =
                "Visit.Call["
                        + "callExternalID=" + callExternalID
                        + ",callDateTime=" + callDateTime
                        + ",callAssignment=" + callAssignment
                        + ",callType=" + callType
                        + ",procedureCode=" + procedureCode
                        + ",patientIdentifierOnCall=" + patientIdentifierOnCall
                        + ",mobileLogin=" + mobileLogin
                        + ",callLatitude=" + callLatitude
                        + ",callLongitude" + callLongitude
                        + ",telephonyPIN=" + telephonyPIN
                        + ",originatingPhoneNumber=" + originatingPhoneNumber
                        + "]";

        return data;

    }
}
