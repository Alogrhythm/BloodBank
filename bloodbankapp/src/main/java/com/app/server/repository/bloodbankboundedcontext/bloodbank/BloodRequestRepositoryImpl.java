package com.app.server.repository.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest;
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
import java.util.Map;

@Repository
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "13", comments = "Repository for BloodRequest Transaction table", complexity = Complexity.MEDIUM)
public class BloodRequestRepositoryImpl extends SearchInterfaceImpl implements BloodRequestRepository<BloodRequest> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<BloodRequest> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest> query = emanager.createQuery("select u from BloodRequest u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public BloodRequest save(BloodRequest entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("BBBBB322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<BloodRequest> save(List<BloodRequest> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("BBBBB322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest s = emanager.find(com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest.class, id);
        emanager.remove(s);
        Log.out.println("BBBBB328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(BloodRequest entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("BBBBB321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<BloodRequest> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("BBBBB321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public List<Object> search(String finderName, Map<String, Object> fields, Map<String, String> fieldMetaData) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery(finderName);
        java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
        Map<String, String> metaData = new java.util.HashMap<String, String>();
        metaData = fieldMetaData;
        String inputStr = "01-01-1850 00:00:00 UTC";
        java.util.Date date = setFormattedDate(inputStr);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        for (Map.Entry<String, String> entry : metaData.entrySet()) {
            boolean matched = false;
            for (Map.Entry<String, Object> entry1 : fields.entrySet()) {
                if (entry.getKey() == entry1.getKey()) {
                    if (entry.getValue().equalsIgnoreCase("integer") || entry.getValue().equalsIgnoreCase("double") || entry.getValue().equalsIgnoreCase("float") || entry.getValue().equalsIgnoreCase("long")) {
                        map.put("min" + entry1.getKey(), entry1.getValue());
                        map.put("max" + entry1.getKey(), entry1.getValue());
                    } else if (entry.getValue().equalsIgnoreCase("String")) {
                        map.put(entry1.getKey(), "%" + entry1.getValue() + "%");
                    } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DateTime")) {
                        java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                        map.put(entry1.getKey(), dateValue);
                    } else if (entry.getValue().equalsIgnoreCase("TimeStamp")) {
                        java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                        map.put(entry1.getKey(), new java.sql.Timestamp(dateValue.getTime()));
                    } else {
                        map.put(entry1.getKey(), entry1.getValue());
                    }
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                if (entry.getValue().equalsIgnoreCase("String")) {
                    map.put(entry.getKey(), "%");
                } else if (entry.getValue().equalsIgnoreCase("integer")) {
                    map.put("min" + entry.getKey(), Integer.MIN_VALUE);
                    map.put("max" + entry.getKey(), Integer.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("double")) {
                    map.put("min" + entry.getKey(), java.lang.Double.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Double.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("long")) {
                    map.put("min" + entry.getKey(), java.lang.Long.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Long.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("float")) {
                    map.put("min" + entry.getKey(), java.lang.Float.MIN_VALUE);
                    map.put("max" + entry.getKey(), java.lang.Float.MAX_VALUE);
                } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DATETIME")) {
                    map.put(entry.getKey(), date);
                } else if (entry.getValue().equalsIgnoreCase("TINYINT")) {
                    map.put(entry.getKey(), 1);
                } else if (entry.getValue().equalsIgnoreCase("timestamp")) {
                    map.put(entry.getKey(), timestamp);
                } else if (entry.getValue().equalsIgnoreCase("integer_userAccesCode")) {
                    map.put(entry.getKey(), runtimeLogInfoHelper.getUserAccessCode());
                }
            }
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        java.util.List<Object> list = query.getResultList();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "search", "Total Records Fetched = " + list.size());
        return list;
    }

    @Transactional
    public List<BloodRequest> findByBldg(String bldg) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("BloodRequest.findByBldg");
        query.setParameter("bldg", bldg);
        java.util.List<com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest> listOfBloodRequest = query.getResultList();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "findByBldg", "Total Records Fetched = " + listOfBloodRequest.size());
        return listOfBloodRequest;
    }

    @Transactional
    public BloodRequest findById(String bloodRequestId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("BloodRequest.findById");
        query.setParameter("bloodRequestId", bloodRequestId);
        com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest listOfBloodRequest = (com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest) query.getSingleResult();
        Log.out.println("BBBBB324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "BloodRequestRepositoryImpl", "findById", "Total Records Fetched = " + listOfBloodRequest);
        return listOfBloodRequest;
    }
}
