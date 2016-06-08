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
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
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

@Table(name = "ast_BloodResult_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "20", comments = "BloodResult", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "BloodResult.DefaultFinders", query = "select e from BloodResult e where e.systemInfo.activeStatus=1 and e.donorVisitId LIKE :donorVisitId"), @javax.persistence.NamedQuery(name = "BloodResult.findByDonorVisitId", query = "select e from BloodResult e where e.systemInfo.activeStatus=1 and e.donorVisitId=:donorVisitId"), @javax.persistence.NamedQuery(name = "BloodResult.findById", query = "select e from BloodResult e where e.systemInfo.activeStatus=1 and e.bloodResultId =:bloodResultId") })
public class BloodResult implements Serializable, CommonEntityInterface, Comparator<BloodResult> {

    @Column(name = "collectedDate")
    @JsonProperty("collectedDate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp collectedDate;

    @Column(name = "expiryDate")
    @JsonProperty("expiryDate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp expiryDate;

    @Column(name = "isTested")
    @JsonProperty("isTested")
    @NotNull
    private Boolean isTested = true;

    @Column(name = "noOfUnits")
    @JsonProperty("noOfUnits")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer noOfUnits;

    @Column(name = "donor")
    @JsonProperty("donor")
    @Size(min = 1, max = 256)
    private String donor;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "bloodResultId")
    @JsonProperty("bloodResultId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String bloodResultId;

    @Column(name = "donorVisitId")
    @JsonProperty("donorVisitId")
    private String donorVisitId;

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

    public Timestamp getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Timestamp _collectedDate) {
        if (_collectedDate != null) {
            this.collectedDate = _collectedDate;
        }
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp _expiryDate) {
        if (_expiryDate != null) {
            this.expiryDate = _expiryDate;
        }
    }

    public Boolean getIsTested() {
        return isTested;
    }

    public void setIsTested(Boolean _isTested) {
        if (_isTested != null) {
            this.isTested = _isTested;
        }
    }

    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(Integer _noOfUnits) {
        if (_noOfUnits != null) {
            this.noOfUnits = _noOfUnits;
        }
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String _donor) {
        this.donor = _donor;
    }

    public String getPrimaryKey() {
        return bloodResultId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return bloodResultId;
    }

    public String getBloodResultId() {
        return bloodResultId;
    }

    public void setBloodResultId(String _bloodResultId) {
        this.bloodResultId = _bloodResultId;
    }

    public String getDonorVisitId() {
        return donorVisitId;
    }

    public void setDonorVisitId(String _donorVisitId) {
        this.donorVisitId = _donorVisitId;
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
    public int compare(BloodResult object1, BloodResult object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((isTested == null ? " " : isTested) + ",");
        sb.append((donorVisitId.toString() == null ? " " : donorVisitId.toString()));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (bloodResultId == null) {
            return super.hashCode();
        } else {
            return bloodResultId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult other = (com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult) obj;
            if (bloodResultId == null) {
                return false;
            } else if (!bloodResultId.equals(other.bloodResultId)) {
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
