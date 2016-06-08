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
public class RegInfoDto implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private String donorName;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dob;

    private String phoneNo;

    private String emailId;

    private String gender;

    private String bg;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp lastDonationDate;

    private Integer howOftenUDonated;

    private String countryId;

    private String state;

    private String city;

    private String addressType;

    private String postalCode;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String _donorName) {
        this.donorName = _donorName;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp _dob) {
        this.dob = _dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String _phoneNo) {
        this.phoneNo = _phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String _emailId) {
        this.emailId = _emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String _gender) {
        this.gender = _gender;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String _bg) {
        this.bg = _bg;
    }

    public Timestamp getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Timestamp _lastDonationDate) {
        this.lastDonationDate = _lastDonationDate;
    }

    public Integer getHowOftenUDonated() {
        return howOftenUDonated;
    }

    public void setHowOftenUDonated(Integer _howOftenUDonated) {
        this.howOftenUDonated = _howOftenUDonated;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String _countryId) {
        this.countryId = _countryId;
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

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String _addressType) {
        this.addressType = _addressType;
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
