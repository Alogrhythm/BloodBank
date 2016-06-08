package com.app.shared.bloodbankboundedcontext.bloodbank;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegCampInfo implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private String campTime;

    private String organisationName;

    private String reasonForCamp;

    private String bloodBankName;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp fromDate;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp toDate;

    private Integer noOfDonorsExpected;

    private Integer noOfDonorsArrived;

    private Integer noOfDonorsThatBled;

    private String addressType;

    private String country;

    private String state;

    private String city;

    private String postalCode;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getCampTime() {
        return campTime;
    }

    public void setCampTime(String _campTime) {
        this.campTime = _campTime;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String _organisationName) {
        this.organisationName = _organisationName;
    }

    public String getReasonForCamp() {
        return reasonForCamp;
    }

    public void setReasonForCamp(String _reasonForCamp) {
        this.reasonForCamp = _reasonForCamp;
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String _bloodBankName) {
        this.bloodBankName = _bloodBankName;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp _fromDate) {
        this.fromDate = _fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp _toDate) {
        this.toDate = _toDate;
    }

    public Integer getNoOfDonorsExpected() {
        return noOfDonorsExpected;
    }

    public void setNoOfDonorsExpected(Integer _noOfDonorsExpected) {
        this.noOfDonorsExpected = _noOfDonorsExpected;
    }

    public Integer getNoOfDonorsArrived() {
        return noOfDonorsArrived;
    }

    public void setNoOfDonorsArrived(Integer _noOfDonorsArrived) {
        this.noOfDonorsArrived = _noOfDonorsArrived;
    }

    public Integer getNoOfDonorsThatBled() {
        return noOfDonorsThatBled;
    }

    public void setNoOfDonorsThatBled(Integer _noOfDonorsThatBled) {
        this.noOfDonorsThatBled = _noOfDonorsThatBled;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String _addressType) {
        this.addressType = _addressType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String _country) {
        this.country = _country;
    }

    public String getState() {
        return state;
    }

    public void setState(String _state) {
        this.state = _state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String _city) {
        this.city = _city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String _postalCode) {
        this.postalCode = _postalCode;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.dtoValidator = _validateFactory;
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.dtoValidator != null) {
            isValid = this.dtoValidator.validateEntity(this);
            this.isDtoValidated = true;
        } else {
            throw new SecurityException();
        }
        return isValid;
    }
}
