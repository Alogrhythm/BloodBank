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

@Table(name = "ast_RegisterADonor_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "39", comments = "RegisterADonor", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "RegisterADonor.DefaultFinders", query = "select e from RegisterADonor e where e.systemInfo.activeStatus=1 and e.donorName LIKE :donorName and e.gendr LIKE :gendr and e.bg LIKE :bg"), @javax.persistence.NamedQuery(name = "RegisterADonor.findByGendr", query = "select e from RegisterADonor e where e.systemInfo.activeStatus=1 and e.gendr=:gendr"), @javax.persistence.NamedQuery(name = "RegisterADonor.findByBg", query = "select e from RegisterADonor e where e.systemInfo.activeStatus=1 and e.bg=:bg"), @javax.persistence.NamedQuery(name = "RegisterADonor.findByAddr", query = "select e from RegisterADonor e where e.systemInfo.activeStatus=1 and e.addr=:addr"), @javax.persistence.NamedQuery(name = "RegisterADonor.findById", query = "select e from RegisterADonor e where e.systemInfo.activeStatus=1 and e.donorId =:donorId") })
public class RegisterADonor implements Serializable, CommonEntityInterface, Comparator<RegisterADonor> {

    @Column(name = "donorName")
    @JsonProperty("donorName")
    @NotNull
    @Size(min = 1, max = 256)
    private String donorName;

    @Column(name = "dob")
    @JsonProperty("dob")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dob;

    @Column(name = "phoneNo")
    @JsonProperty("phoneNo")
    @NotNull
    @Size(min = 1, max = 256)
    private String phoneNo;

    @Column(name = "emailId")
    @JsonProperty("emailId")
    @NotNull
    @Size(min = 1, max = 256)
    private String emailId;

    @Column(name = "lastDonationDate")
    @JsonProperty("lastDonationDate")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp lastDonationDate;

    @Column(name = "howOftenUDonated")
    @JsonProperty("howOftenUDonated")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer howOftenUDonated;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "donorId")
    @JsonProperty("donorId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String donorId;

    @Column(name = "gendr")
    @JsonProperty("gendr")
    private String gendr;

    @Column(name = "bg")
    @JsonProperty("bg")
    private String bg;

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

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String _donorName) {
        if (_donorName != null) {
            this.donorName = _donorName;
        }
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp _dob) {
        if (_dob != null) {
            this.dob = _dob;
        }
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String _phoneNo) {
        if (_phoneNo != null) {
            this.phoneNo = _phoneNo;
        }
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String _emailId) {
        if (_emailId != null) {
            this.emailId = _emailId;
        }
    }

    public Timestamp getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Timestamp _lastDonationDate) {
        if (_lastDonationDate != null) {
            this.lastDonationDate = _lastDonationDate;
        }
    }

    public Integer getHowOftenUDonated() {
        return howOftenUDonated;
    }

    public void setHowOftenUDonated(Integer _howOftenUDonated) {
        if (_howOftenUDonated != null) {
            this.howOftenUDonated = _howOftenUDonated;
        }
    }

    public String getPrimaryKey() {
        return donorId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return donorId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String _donorId) {
        this.donorId = _donorId;
    }

    public String getGendr() {
        return gendr;
    }

    public void setGendr(String _gendr) {
        this.gendr = _gendr;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String _bg) {
        this.bg = _bg;
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
    public int compare(RegisterADonor object1, RegisterADonor object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((donorName == null ? " " : donorName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (donorId == null) {
            return super.hashCode();
        } else {
            return donorId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor other = (com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor) obj;
            if (donorId == null) {
                return false;
            } else if (!donorId.equals(other.donorId)) {
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
