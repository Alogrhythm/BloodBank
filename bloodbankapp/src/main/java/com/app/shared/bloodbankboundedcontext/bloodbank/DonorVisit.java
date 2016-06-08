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
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_DonorVisit_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "42", comments = "DonorVisit", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "donorVisitId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "DonorVisit.DefaultFinders", query = "select e from DonorVisit e where e.systemInfo.activeStatus=1 and e.dType LIKE :dType"), @javax.persistence.NamedQuery(name = "DonorVisit.findByDType", query = "select e from DonorVisit e where e.systemInfo.activeStatus=1 and e.dType=:dType"), @javax.persistence.NamedQuery(name = "DonorVisit.findByDonor", query = "select e from DonorVisit e where e.systemInfo.activeStatus=1 and e.donor=:donor"), @javax.persistence.NamedQuery(name = "DonorVisit.findByCamp", query = "select e from DonorVisit e where e.systemInfo.activeStatus=1 and e.camp=:camp"), @javax.persistence.NamedQuery(name = "DonorVisit.findById", query = "select e from DonorVisit e where e.systemInfo.activeStatus=1 and e.donorVisitId =:donorVisitId") })
public class DonorVisit implements Serializable, CommonEntityInterface, Comparator<DonorVisit> {

    @Column(name = "orgnizerName")
    @JsonProperty("orgnizerName")
    @NotNull
    @Size(min = 1, max = 256)
    private String orgnizerName;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "donorVisitId")
    @JsonProperty("donorVisitId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String donorVisitId;

    @Column(name = "dType")
    @JsonProperty("dType")
    private String dType;

    @Column(name = "donor")
    @JsonProperty("donor")
    private String donor;

    @Column(name = "camp")
    @JsonProperty("camp")
    private String camp;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "donorVisit")
    private ClinicalInfo clinicalInfo;

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

    public String getOrgnizerName() {
        return orgnizerName;
    }

    public void setOrgnizerName(String _orgnizerName) {
        if (_orgnizerName != null) {
            this.orgnizerName = _orgnizerName;
        }
    }

    public String getPrimaryKey() {
        return donorVisitId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return donorVisitId;
    }

    public String getDonorVisitId() {
        return donorVisitId;
    }

    public void setDonorVisitId(String _donorVisitId) {
        this.donorVisitId = _donorVisitId;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String _dType) {
        this.dType = _dType;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String _donor) {
        this.donor = _donor;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String _camp) {
        this.camp = _camp;
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

    public ClinicalInfo getClinicalInfo() {
        return clinicalInfo;
    }

    public void setClinicalInfo(ClinicalInfo _clinicalInfo) {
        if (_clinicalInfo.getDonorVisit() == null) {
            _clinicalInfo.setDonorVisit(this);
        }
        this.clinicalInfo = _clinicalInfo;
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
        if (this.clinicalInfo != null) {
            clinicalInfo.setEntityAudit(customerId, userId, recordType);
            clinicalInfo.setSystemInformation(recordType);
        }
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
        if (this.clinicalInfo != null) {
            clinicalInfo.setEntityAudit(customerId, userId);
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
            this.systemInfo.setActiveStatus(-1);
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
    public int compare(DonorVisit object1, DonorVisit object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((orgnizerName == null ? " " : orgnizerName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (donorVisitId == null) {
            return super.hashCode();
        } else {
            return donorVisitId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit other = (com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit) obj;
            if (donorVisitId == null) {
                return false;
            } else if (!donorVisitId.equals(other.donorVisitId)) {
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
