package com.app.server.service.bloodbankboundedcontext.bloodbank;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodStockRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodStock;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodGroup;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class BloodStockTestCase extends EntityTestCriteria {

    @Autowired
    private BloodStockRepository<BloodStock> bloodstockRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private BloodStock createBloodStock(Boolean isSave) throws Exception {
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("qEwdCot9PqCiplzurA8A4wV2p5chCSe7povPOP2C25D64ypuja");
        BloodGroup BloodGroupTest = new BloodGroup();
        if (isSave) {
            BloodGroupTest = bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        }
        BloodStock bloodstock = new BloodStock();
        bloodstock.setNoOfUnits(2147483647);
        bloodstock.setBloodg((java.lang.String) BloodGroupTest._getPrimarykey());
        bloodstock.setEntityValidator(entityValidator);
        return bloodstock;
    }

    @Test
    public void test1Save() {
        try {
            BloodStock bloodstock = createBloodStock(true);
            bloodstock.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            bloodstock.isValid();
            bloodstockRepository.save(bloodstock);
            map.put("BloodStockPrimaryKey", bloodstock._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BloodGroupRepository<BloodGroup> bloodgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodStockPrimaryKey"));
            BloodStock bloodstock = bloodstockRepository.findById((java.lang.String) map.get("BloodStockPrimaryKey"));
            bloodstock.setNoOfUnits(2147483647);
            bloodstock.setVersionId(1);
            bloodstock.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            bloodstockRepository.update(bloodstock);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybloodg() {
        try {
            java.util.List<BloodStock> listofbloodg = bloodstockRepository.findByBloodg((java.lang.String) map.get("BloodGroupPrimaryKey"));
            if (listofbloodg.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodStockPrimaryKey"));
            bloodstockRepository.findById((java.lang.String) map.get("BloodStockPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodStockPrimaryKey"));
            bloodstockRepository.delete((java.lang.String) map.get("BloodStockPrimaryKey")); /* Deleting refrenced data */
            bloodgroupRepository.delete((java.lang.String) map.get("BloodGroupPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateBloodStock(EntityTestCriteria contraints, BloodStock bloodstock) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            bloodstock.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            bloodstock.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            bloodstock.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            bloodstockRepository.save(bloodstock);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "noOfUnits", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                BloodStock bloodstock = createBloodStock(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = bloodstock.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(bloodstock, null);
                        validateBloodStock(contraints, bloodstock);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
