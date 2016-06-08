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
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
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

@Table(name = "ast_RegisterACamp_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "14", comments = "RegisterACamp", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "RegisterACamp.DefaultFinders", query = "select e from RegisterACamp e where e.systemInfo.activeStatus=1 and e.bloodBankName LIKE :bloodBankName"), @javax.persistence.NamedQuery(name = "RegisterACamp.findByAddr", query = "select e from RegisterACamp e where e.systemInfo.activeStatus=1 and e.addr=:addr"), @javax.persistence.NamedQuery(name = "RegisterACamp.findById", query = "select e from RegisterACamp e where e.systemInfo.activeStatus=1 and e.campId =:campId") })
public class RegisterACamp implements Serializable, CommonEntityInterface, Comparator<RegisterACamp> {

    @Column(name = "organisationName")
    @JsonProperty("organisationName")
    @NotNull
    @Size(min = 1, max = 256)
    private String organisationName;

    @Column(name = "reasonForCamp")
    @JsonProperty("reasonForCamp")
    @NotNull
    @Size(min = 1, max = 256)
    private String reasonForCamp;

    @Column(name = "bloodBankName")
    @JsonProperty("bloodBankName")
    @NotNull
    @Size(min = 1, max = 256)
    private String bloodBankName;

    @Column(name = "fromDate")
    @JsonProperty("fromDate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp fromDate;

    @Column(name = "toDate")
    @JsonProperty("toDate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp toDate;

    @Column(name = "noOfDonorsExpected")
    @JsonProperty("noOfDonorsExpected")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer noOfDonorsExpected;

    @Column(name = "noOfDonorsArrived")
    @JsonProperty("noOfDonorsArrived")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer noOfDonorsArrived;

    @Column(name = "noOfDonorsThatBled")
    @JsonProperty("noOfDonorsThatBled")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer noOfDonorsThatBled;

    @Column(name = "campTime")
    @JsonProperty("campTime")
    @NotNull
    @Size(min = 1, max = 256)
    private String campTime;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "campId")
    @JsonProperty("campId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String campId;

    @Column(name = "addr")
    @JsonProperty("addr")
    private String addr;

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

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String _organisationName) {
        if (_organisationName != null) {
            this.organisationName = _organisationName;
        }
    }

    public String getReasonForCamp() {
        return reasonForCamp;
    }

    public void setReasonForCamp(String _reasonForCamp) {
        if (_reasonForCamp != null) {
            this.reasonForCamp = _reasonForCamp;
        }
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String _bloodBankName) {
        if (_bloodBankName != null) {
            this.bloodBankName = _bloodBankName;
        }
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp _fromDate) {
        if (_fromDate != null) {
            this.fromDate = _fromDate;
        }
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp _toDate) {
        if (_toDate != null) {
            this.toDate = _toDate;
        }
    }

    public Integer getNoOfDonorsExpected() {
        return noOfDonorsExpected;
    }

    public void setNoOfDonorsExpected(Integer _noOfDonorsExpected) {
        if (_noOfDonorsExpected != null) {
            this.noOfDonorsExpected = _noOfDonorsExpected;
        }
    }

    public Integer getNoOfDonorsArrived() {
        return noOfDonorsArrived;
    }

    public void setNoOfDonorsArrived(Integer _noOfDonorsArrived) {
        if (_noOfDonorsArrived != null) {
            this.noOfDonorsArrived = _noOfDonorsArrived;
        }
    }

    public Integer getNoOfDonorsThatBled() {
        return noOfDonorsThatBled;
    }

    public void setNoOfDonorsThatBled(Integer _noOfDonorsThatBled) {
        if (_noOfDonorsThatBled != null) {
            this.noOfDonorsThatBled = _noOfDonorsThatBled;
        }
    }

    public String getCampTime() {
        return campTime;
    }

    public void setCampTime(String _campTime) {
        if (_campTime != null) {
            this.campTime = _campTime;
        }
    }

    public String getPrimaryKey() {
        return campId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return campId;
    }

    public String getCampId() {
        return campId;
    }

    public void setCampId(String _campId) {
        this.campId = _campId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String _addr) {
        this.addr = _addr;
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
    public int compare(RegisterACamp object1, RegisterACamp object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((organisationName == null ? " " : organisationName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (campId == null) {
            return super.hashCode();
        } else {
            return campId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp other = (com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp) obj;
            if (campId == null) {
                return false;
            } else if (!campId.equals(other.campId)) {
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
