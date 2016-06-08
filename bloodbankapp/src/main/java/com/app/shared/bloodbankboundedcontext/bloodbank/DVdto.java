package com.app.shared.bloodbankboundedcontext.bloodbank;
import com.athena.server.pluggable.interfaces.EntityValidatorInterface;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Transient;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DVdto implements EntityValidatorInterface {

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> dtoValidator;

    private String height;

    private String weight;

    private String pulse;

    private String bp;

    private String temp;

    private Integer noOfUnits;

    private String dvid;

    @Transient
    @JsonIgnore
    private boolean isDtoValidated = false;

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return isDtoValidated;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String _height) {
        this.height = _height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String _weight) {
        this.weight = _weight;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String _pulse) {
        this.pulse = _pulse;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String _bp) {
        this.bp = _bp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String _temp) {
        this.temp = _temp;
    }

    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(Integer _noOfUnits) {
        this.noOfUnits = _noOfUnits;
    }

    public String getDvid() {
        return dvid;
    }

    public void setDvid(String _dvid) {
        this.dvid = _dvid;
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
