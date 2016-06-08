package com.app.shared.bloodbankboundedcontext.bloodbank;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_BloodRequest_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "13", comments = "BloodRequest", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "BloodRequest.DefaultFinders", query = "select e from BloodRequest e where e.systemInfo.activeStatus=1 and e.noOfUnits BETWEEN :minnoOfUnits AND :maxnoOfUnits and e.bldg LIKE :bldg"), @javax.persistence.NamedQuery(name = "BloodRequest.findByBldg", query = "select e from BloodRequest e where e.systemInfo.activeStatus=1 and e.bldg=:bldg"), @javax.persistence.NamedQuery(name = "BloodRequest.findById", query = "select e from BloodRequest e where e.systemInfo.activeStatus=1 and e.bloodRequestId =:bloodRequestId") })
public class BloodRequest implements Serializable, CommonEntityInterface, Comparator<BloodRequest> {

    @Column(name = "noOfUnits")
    @JsonProperty("noOfUnits")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer noOfUnits;

    @Column(name = "patientName")
    @JsonProperty("patientName")
    @NotNull
    @Size(min = 1, max = 256)
    private String patientName;

    @Column(name = "requestedByDoctor")
    @JsonProperty("requestedByDoctor")
    @NotNull
    @Size(min = 1, max = 256)
    private String requestedByDoctor;

    @Column(name = "requestedByHospital")
    @JsonProperty("requestedByHospital")
    @NotNull
    @Size(min = 1, max = 256)
    private String requestedByHospital;

    @Column(name = "dateNeededBy")
    @JsonProperty("dateNeededBy")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dateNeededBy;

    @Column(name = "dispatchedToPatientOn")
    @JsonProperty("dispatchedToPatientOn")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dispatchedToPatientOn;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "bloodRequestId")
    @JsonProperty("bloodRequestId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String bloodRequestId;

    @Column(name = "bldg")
    @JsonProperty("bldg")
    private String bldg;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(Integer _noOfUnits) {
        if (_noOfUnits != null) {
            this.noOfUnits = _noOfUnits;
        }
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String _patientName) {
        if (_patientName != null) {
            this.patientName = _patientName;
        }
    }

    public String getRequestedByDoctor() {
        return requestedByDoctor;
    }

    public void setRequestedByDoctor(String _requestedByDoctor) {
        if (_requestedByDoctor != null) {
            this.requestedByDoctor = _requestedByDoctor;
        }
    }

    public String getRequestedByHospital() {
        return requestedByHospital;
    }

    public void setRequestedByHospital(String _requestedByHospital) {
        if (_requestedByHospital != null) {
            this.requestedByHospital = _requestedByHospital;
        }
    }

    public Timestamp getDateNeededBy() {
        return dateNeededBy;
    }

    public void setDateNeededBy(Timestamp _dateNeededBy) {
        if (_dateNeededBy != null) {
            this.dateNeededBy = _dateNeededBy;
        }
    }

    public Timestamp getDispatchedToPatientOn() {
        return dispatchedToPatientOn;
    }

    public void setDispatchedToPatientOn(Timestamp _dispatchedToPatientOn) {
        if (_dispatchedToPatientOn != null) {
            this.dispatchedToPatientOn = _dispatchedToPatientOn;
        }
    }

    public String getPrimaryKey() {
        return bloodRequestId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return bloodRequestId;
    }

    public String getBloodRequestId() {
        return bloodRequestId;
    }

    public void setBloodRequestId(String _bloodRequestId) {
        this.bloodRequestId = _bloodRequestId;
    }

    public String getBldg() {
        return bldg;
    }

    public void setBldg(String _bldg) {
        this.bldg = _bldg;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new java.lang.SecurityException();
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(BloodRequest object1, BloodRequest object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((patientName == null ? " " : patientName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (bloodRequestId == null) {
            return super.hashCode();
        } else {
            return bloodRequestId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest other = (com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest) obj;
            if (bloodRequestId == null) {
                return false;
            } else if (!bloodRequestId.equals(other.bloodRequestId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
