package com.app.server.repository.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonationType;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "12", comments = "Repository for DonationType Master table Entity", complexity = Complexity.LOW)
public class DonationTypeRepositoryImpl extends SearchInterfaceImpl implements DonationTypeRepository<DonationType> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<DonationType> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.bloodbankboundedcontext.bloodbank.DonationType> query = emanager.createQuery("select u from DonationType u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public DonationType save(DonationType entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("BBBBB322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<DonationType> save(List<DonationType> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.bloodbankboundedcontext.bloodbank.DonationType obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("BBBBB322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.bloodbankboundedcontext.bloodbank.DonationType s = emanager.find(com.app.shared.bloodbankboundedcontext.bloodbank.DonationType.class, id);
        emanager.remove(s);
        Log.out.println("BBBBB328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(DonationType entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("BBBBB321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<DonationType> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.bloodbankboundedcontext.bloodbank.DonationType obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("BBBBB321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public DonationType findById(String donationTypeId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("DonationType.findById");
        query.setParameter("donationTypeId", donationTypeId);
        com.app.shared.bloodbankboundedcontext.bloodbank.DonationType listOfDonationType = (com.app.shared.bloodbankboundedcontext.bloodbank.DonationType) query.getSingleResult();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonationTypeRepositoryImpl", "findById", "Total Records Fetched = " + listOfDonationType);
        return listOfDonationType;
    }
}
