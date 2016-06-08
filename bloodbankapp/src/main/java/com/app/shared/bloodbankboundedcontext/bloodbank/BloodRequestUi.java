package com.app.shared.bloodbankboundedcontext.bloodbank;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BloodRequestUi implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    @Min(1)
    @Max(65535)
    private String bloodGroups;

    @Min(1)
    @Max(65535)
    private String requestedByDoctor;

    @Min(1)
    @Max(65535)
    private String dateNeededBy;

    @Min(1)
    @Max(65535)
    private String noOfUnits;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getBloodGroups() {
        return bloodGroups;
    }

    public void setBloodGroups(String _bloodGroups) {
        this.bloodGroups = _bloodGroups;
    }

    public String getRequestedByDoctor() {
        return requestedByDoctor;
    }

    public void setRequestedByDoctor(String _requestedByDoctor) {
        this.requestedByDoctor = _requestedByDoctor;
    }

    public String getDateNeededBy() {
        return dateNeededBy;
    }

    public void setDateNeededBy(String _dateNeededBy) {
        this.dateNeededBy = _dateNeededBy;
    }

    public String getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(String _noOfUnits) {
        this.noOfUnits = _noOfUnits;
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
