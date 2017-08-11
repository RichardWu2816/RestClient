package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Visit extends SandataMessage {

    public Visit() {
    }

    public Visit(
            String businessEntityID,
            String businessEntityMedicaidIdentifier,
            String visitOtherID,
            String sequenceID,
            String staffOtherID,
            String patientOtherID,
            String patientMedicaidID,
            Boolean visitCancelledIndicator,
            String payer,
            String payerID,
            String payerProgram,
            String procedureCode,
            String timeZone,
            Date adjInDateTime,
            Date adjOutDateTime,
            Boolean billVisit,
            BigDecimal hoursToBill,
            String visitMemo,
            Boolean memberVerifiedTimes,
            Boolean memberVerifiedService,
            Boolean memberSignatureAvailable,
            Boolean memberVoiceRecording

    ) {

        setBusinessEntityID(businessEntityID);
        setBusinessEntityMedicaidIdentifier(businessEntityMedicaidIdentifier);
        setVisitOtherID(visitOtherID);
        setSequenceID(sequenceID);
        setStaffOtherID(staffOtherID);
        setPatientOtherID(patientOtherID);
        setPatientMedicaidID(patientMedicaidID);
        setVisitCancelledIndicator(visitCancelledIndicator);
        setPayer(payer);
        setPayerID(payerID);
        setPayerProgram(payerProgram);
        setProcedureCode(procedureCode);
        setTimeZone(timeZone);
        setAdjInDateTime(adjInDateTime);
        setAdjOutDateTime(adjOutDateTime);
        setBillVisit(billVisit);
        setHoursToBill(hoursToBill);
        setVisitMemo(visitMemo);
        setMemberVerifiedTimes(memberVerifiedTimes);
        setMemberVerifiedService(memberVerifiedService);
        setMemberSignatureAvailable(memberSignatureAvailable);
        setMemberVoiceRecording(memberVoiceRecording);

    }

    // control the same visit could be in both valid and invalid list.
    private String controlID;

    @NotNull(message = "{visit.BusinessEntityID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 10, message = "{visit.BusinessEntityID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,10}$", message = "{visit.BusinessEntityID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityID")
    @Expose
    private String businessEntityID;

    @NotNull(message = "{visit.BusinessEntityMedicaidIdentifier.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 9, message = "{visit.BusinessEntityMedicaidIdentifier.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,7}$", message = "{visit.BusinessEntityMedicaidIdentifier.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityMedicaidIdentifier")
    @Expose
    private String businessEntityMedicaidIdentifier;

    @NotNull(message = "{visit.VisitOtherID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 50, message = "{visit.VisitOtherID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,50}$", message = "{visit.VisitOtherID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("VisitOtherID")
    @Expose
    private String visitOtherID;

    @NotNull(message = "{visit.SequenceID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 16, message = "{visit.SequenceID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,16}", message = "{visit.SequenceID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("SequenceID")
    @Expose
    private String sequenceID;

    @NotNull(message = "{visit.StaffOtherID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{visit.StaffOtherID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}$", message = "{visit.StaffOtherID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffOtherID")
    @Expose
    private String staffOtherID;

    @NotNull(message = "{visit.PatientOtherID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{visit.PatientOtherID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}$", message = "{visit.PatientOtherID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientOtherID")
    @Expose
    private String patientOtherID;

    @NotNull(message = "{visit.PatientMedicaidID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 15, message = "{visit.PatientMedicaidID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,15}$", message = "{visit.PatientMedicaidID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientMedicaidID")
    private String patientMedicaidID;

    @NotNull(message = "{visit.VisitCancelledIndicator.null.msg}", groups = DataChecks.class)
    @SerializedName("VisitCancelledIndicator")
    @Expose
    private Boolean visitCancelledIndicator;

    @NotNull(message = "{visit.Payer.null.msg}", groups = DataChecks.class)
    @Size(max = 128, message = "{visit.Payer.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\s*(?:\\S\\s*){1,128}$", message = "{visit.Payer.pattern.msg}", groups = DataChecks.class)
    @SerializedName("Payer")
    @Expose
    private String payer;

    @NotNull(message = "{visit.PayerID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{visit.PayerID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\s*(?:\\S\\s*){1,64}$", message = "{visit.PayerID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PayerID")
    @Expose
    private String payerID;

    @NotNull(message = "{visit.PayerProgram.null.msg}", groups = DataChecks.class)
    @Size(max = 64, message = "{visit.PayerProgram.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "State Plan Home Health|State Plan Private Duty Nursing|Ohio Home Care Waiver, State Plan|Ohio Home Care Waiver|state plan home health|state plan private duty nursing|ohio home care waiver, state plan|ohio home care waiver|STATE PLAN HOME HEALTH|STATE PLAN PRIVATE DUTY NURSING|OHIO HOME CARE WAIVER, STATE PLAN|OHIO HOME CARE WAIVER|State plan home health|State plan private duty nursing|Ohio home care waiver, state plan|Ohio home care waiver", message = "{visit.PayerProgram.pattern.msg}", groups = DataChecks.class) //TFS# 71571 Interface: 3P Visits - PayerProgram field  having Too Long or Wrong Value should be Rejected.
    @SerializedName("PayerProgram")
    @Expose
    private String payerProgram;

    @NotNull(message = "{visit.ProcedureCode.null.msg}", groups = DataChecks.class)
    @Size(min = 5, max = 5, message = "{visit.ProcedureCode.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "G0156|G0299|G0300|S5125|T1000|T1001|T1002|T1003|T1019|g0156|g0299|g0300|s5125|t1000|t1001|t1002|t1003|t1019", message = "{visit.ProcedureCode.pattern.msg}", groups = DataChecks.class)
    @SerializedName("ProcedureCode")
    @Expose
    private String procedureCode;

    @NotNull(message = "{visit.TimeZone.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{visit.TimeZone.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w /\\-]{1,64}", message = "{visit.TimeZone.pattern.msg}", groups = DataChecks.class)
    @SerializedName("TimeZone")
    @Expose
    private String timeZone;

//    @NotNull(message = "{visit.AdjInDateTime.null.msg}", groups = DataChecks.class) yyyy.MM.dd G 'at' HH:mm:ss z
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Past( message = "{visit.AdjInDateTime.past.msg}", groups = DataChecks.class)
    @SerializedName("AdjInDateTime")
    @Expose
    private Date adjInDateTime;     //Required

//    @NotNull(message = "{visit.AdjOutDateTime.null.msg}", groups = DataChecks.class) yyyy.MM.dd G 'at' HH:mm:ss z
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Past( message = "{visit.AdjOutDateTime.past.msg}", groups = DataChecks.class)
    @SerializedName("AdjOutDateTime")
    @Expose
    private Date adjOutDateTime;     //Required


    @NotNull(message = "{visit.BillVisit.null.msg}", groups = DataChecks.class)
    @SerializedName("BillVisit")
    @Expose
    private Boolean billVisit;

    //TFS# 71841 Interface - 3P - Visit - HoursToBill field is validating as hours for max of '25', value should be in minutes
    @DecimalMax(value = "1500", message = "{visit.HoursToBill.DecimalMax.msg}", groups = DataChecks.class)
    @DecimalMin(value = "0", message = "{visit.HoursToBill.DecimalMin.msg}", groups = DataChecks.class)
    @SerializedName("HoursToBill")
    @Expose
    private BigDecimal hoursToBill;

    @Size(min = 1, max = 1024, message = "{visit.VisitMemo.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\s*(?:\\S\\s*){1,1024}$", message = "{visit.VisitMemo.pattern.msg}", groups = DataChecks.class)
    @SerializedName("VisitMemo")
    @Expose
    private String visitMemo;

    @NotNull(message = "{visit.MemberVerifiedTimes.null.msg}", groups = DataChecks.class)
    @SerializedName("MemberVerifiedTimes")
    @Expose
    private Boolean memberVerifiedTimes;

    @NotNull(message = "{visit.MemberVerifiedService.null.msg}", groups = DataChecks.class)
    @SerializedName("MemberVerifiedService")
    @Expose
    private Boolean memberVerifiedService;

    @NotNull(message = "{visit.MemberSignatureAvailable.null.msg}", groups = DataChecks.class)
    @SerializedName("MemberSignatureAvailable")
    @Expose
    private Boolean memberSignatureAvailable;

    @NotNull(message = "{visit.MemberVoiceRecording.null.msg}", groups = DataChecks.class)
    @SerializedName("MemberVoiceRecording")
    @Expose
    private Boolean memberVoiceRecording;

    @SerializedName("Calls")
    @Expose
    private List<Call> calls = new ArrayList<>();

    @SerializedName("VisitException")
    @Expose
    private List<VisitException> visitExceptions = new ArrayList<>();

    @SerializedName("VisitChanges")
    @Expose
    private List<VisitChange> visitChanges = new ArrayList<>();

    public String getControlID() {
        return controlID;
    }

    public void setControlID(String controlID) {
        this.controlID = controlID;
    }

    public String getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        this.businessEntityID = ValidateHelper.truncateValue(getClass(), "businessEntityID", businessEntityID);
    }

    public String getBusinessEntityMedicaidIdentifier() {
        return businessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        this.businessEntityMedicaidIdentifier = ValidateHelper.truncateValue(getClass(), "businessEntityMedicaidIdentifier", businessEntityMedicaidIdentifier);
    }

    public String getVisitOtherID() {
        return visitOtherID;
    }

    public void setVisitOtherID(String visitOtherID) {
        this.visitOtherID = ValidateHelper.truncateValue(getClass(), "visitOtherID", visitOtherID);
        this.setOtherID(visitOtherID);
    }

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {
        this.sequenceID = ValidateHelper.truncateValue(getClass(), "sequenceID", sequenceID);
    }

    public String getStaffOtherID() {
        return staffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {

        this.staffOtherID = ValidateHelper.truncateValue(getClass(), "staffOtherID", staffOtherID);
    }

    public String getPatientOtherID() {
        return patientOtherID;
    }

    public void setPatientOtherID(String patientOtherID) {
        this.patientOtherID = ValidateHelper.replaceDefaultValue(getClass(), "patientOtherID", patientOtherID, null);
    }

    public String getPatientMedicaidID() {
        return patientMedicaidID;
    }

    public void setPatientMedicaidID(String patientMedicaidID) {
        this.patientMedicaidID = ValidateHelper.truncateValue(getClass(), "patientMedicaidID", patientMedicaidID);

    }

    public Boolean getVisitCancelledIndicator() {
        return visitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(Boolean visitCancelledIndicator) {
        this.visitCancelledIndicator = visitCancelledIndicator == null ? false : visitCancelledIndicator;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = ValidateHelper.truncateValue(getClass(), "payer", payer);

    }

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = ValidateHelper.truncateValue(getClass(), "payerID", payerID);
    }

    public String getPayerProgram() {
        return payerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        this.payerProgram = ValidateHelper.truncateValue(getClass(), "payerProgram", payerProgram);
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = ValidateHelper.truncateValue(getClass(), "procedureCode", procedureCode);
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {

        this.timeZone = ValidateHelper.replaceDefaultValue(getClass(), "timeZone", timeZone, "US/Eastern");
    }

    public Date getAdjInDateTime() {
        return adjInDateTime;
    }

    public void setAdjInDateTime(Date adjInDateTime) {
        this.adjInDateTime = adjInDateTime;
    }

    public Date getAdjOutDateTime() {
        return adjOutDateTime;
    }

    public void setAdjOutDateTime(Date adjOutDateTime) {
        this.adjOutDateTime = adjOutDateTime;
    }

    public Boolean getBillVisit() {
        return billVisit;
    }

    public void setBillVisit(Boolean billVisit) {
        this.billVisit = billVisit == null ? true : billVisit;
    }

    public BigDecimal getHoursToBill() {
        return hoursToBill;
    }

    public void setHoursToBill(BigDecimal hoursToBill) {

        this.hoursToBill = ValidateHelper.convertBigDecimalInRange(getClass(), "hoursToBill", hoursToBill, null);
    }

    public String getVisitMemo() {
        return visitMemo;
    }

    public void setVisitMemo(String visitMemo) {

        this.visitMemo = ValidateHelper.truncateValue(getClass(), "visitMemo", visitMemo);
    }

    public Boolean getMemberVerifiedTimes() {
        return memberVerifiedTimes;
    }

    public void setMemberVerifiedTimes(Boolean memberVerifiedTimes) {
        this.memberVerifiedTimes = memberVerifiedTimes == null ? false : memberVerifiedTimes;
    }

    public Boolean getMemberVerifiedService() {
        return memberVerifiedService;
    }

    public void setMemberVerifiedService(Boolean memberVerifiedService) {
        this.memberVerifiedService = memberVerifiedService == null ? false : memberVerifiedService;
    }

    public Boolean getMemberSignatureAvailable() {
        return memberSignatureAvailable;
    }

    public void setMemberSignatureAvailable(Boolean memberSignatureAvailable) {
        this.memberSignatureAvailable = memberSignatureAvailable == null ? false : memberSignatureAvailable;
    }

    public Boolean getMemberVoiceRecording() {
        return memberVoiceRecording;
    }

    public void setMemberVoiceRecording(Boolean memberVoiceRecording) {
        this.memberVoiceRecording = memberVoiceRecording == null ? false : memberVoiceRecording;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public List<VisitException> getVisitExceptions() {
        return visitExceptions;
    }

    public void setVisitExceptions(List<VisitException> visitExceptions) {
        this.visitExceptions = visitExceptions;
    }

    public List<VisitChange> getVisitChanges() {
        return visitChanges;
    }

    public void setVisitChanges(List<VisitChange> visitChanges) {
        this.visitChanges = visitChanges;
    }


    public String toString() {
        String data =
                "Visit["
                        + "businessEntityID=" + businessEntityID
                        + ",businessEntityMedicaidIdentifier=" + businessEntityMedicaidIdentifier
                        + ",visitOtherID=" + visitOtherID
                        + ",sequenceID=" + sequenceID
                        + ",staffOtherID=" + staffOtherID
                        + ",patientOtherID=" + patientOtherID
                        + ",patientMedicaidID=" + patientMedicaidID
                        + ",visitCancelledIndicator=" + visitCancelledIndicator
                        + ",payer=" + payer
                        + ",payerID=" + payerID
                        + ",payerProgram=" + payerProgram
                        + ",procedureCode=" + procedureCode
                        + ",timeZone=" + timeZone
                        + ",adjInDateTime=" + adjInDateTime
                        + ",adjOutDateTime=" + adjOutDateTime
                        + ",billVisit=" + billVisit
                        + ",hoursToBill=" + hoursToBill
                        + ",visitMemo=" + visitMemo
                        + ",memberVerifiedTimes=" + memberVerifiedTimes
                        + ",memberVerifiedService=" + memberVerifiedService
                        + ",memberSignatureAvailable=" + memberSignatureAvailable
                        + ",memberVoiceRecording=" + memberVoiceRecording
                        + "]";

        return data;

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Visit) {
            Visit p = (Visit) o;
            return (
                    ((this.businessEntityID == null && p.getBusinessEntityID() == null) || this.businessEntityID.equalsIgnoreCase(p.getBusinessEntityID()))
                    && ((this.businessEntityMedicaidIdentifier == null && p.getBusinessEntityMedicaidIdentifier() == null) || this.businessEntityMedicaidIdentifier.equalsIgnoreCase(p.getBusinessEntityMedicaidIdentifier()))
                    && ((this.visitOtherID == null && p.getVisitOtherID() == null) || this.visitOtherID.equalsIgnoreCase(p.getVisitOtherID()))
                    && ((this.sequenceID == null && p.getSequenceID() == null) || this.sequenceID.equalsIgnoreCase(p.getSequenceID()))
                    && ((this.staffOtherID == null && p.getStaffOtherID() == null) || this.staffOtherID.equalsIgnoreCase(p.getStaffOtherID()))
                    && ((this.patientOtherID == null && p.getPatientOtherID() == null) || this.patientOtherID.equalsIgnoreCase(p.getPatientOtherID())))
                    || (this.controlID != null && this.controlID.equals(p.getControlID()));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if (controlID != null) {
            return Objects.hash(controlID);
        } else {
            return Objects.hash(businessEntityID, businessEntityMedicaidIdentifier, visitOtherID, sequenceID,
                    staffOtherID, patientOtherID, patientMedicaidID, payer, payerID, payerProgram);
        }
    }

}
