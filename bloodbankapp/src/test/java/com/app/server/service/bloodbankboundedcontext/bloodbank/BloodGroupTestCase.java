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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodGroupRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodGroup;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class BloodGroupTestCase extends EntityTestCriteria {

    @Autowired
    private BloodGroupRepository<BloodGroup> bloodgroupRepository;

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

    private BloodGroup createBloodGroup(Boolean isSave) throws Exception {
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("DORBlJIowvHmjbbQPqoTfVRzSbnWBSV0GoTSU01VEUYcWGSMuz");
        bloodgroup.setEntityValidator(entityValidator);
        return bloodgroup;
    }

    @Test
    public void test1Save() {
        try {
            BloodGroup bloodgroup = createBloodGroup(true);
            bloodgroup.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            bloodgroup.isValid();
            bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodGroupPrimaryKey"));
            BloodGroup bloodgroup = bloodgroupRepository.findById((java.lang.String) map.get("BloodGroupPrimaryKey"));
            bloodgroup.setBloodGroups("PK0NuEKpZn0XcJBC00WyJYgXLFK80TmNAQr0CrMJgFltIpM6jC");
            bloodgroup.setVersionId(1);
            bloodgroup.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            bloodgroupRepository.update(bloodgroup);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodGroupPrimaryKey"));
            bloodgroupRepository.findById((java.lang.String) map.get("BloodGroupPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindByBG() {
        try {
            bloodgroupRepository.FindByBG("ab");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodGroupPrimaryKey"));
            bloodgroupRepository.delete((java.lang.String) map.get("BloodGroupPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateBloodGroup(EntityTestCriteria contraints, BloodGroup bloodgroup) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            bloodgroup.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            bloodgroup.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            bloodgroup.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            bloodgroupRepository.save(bloodgroup);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "bloodGroups", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "bloodGroups", "m8EAgDwXcKfDK9GjQzBKln4ejpFQHnNFcJIbBITTJ7fX5jl2noZwt2LdwNc4Veb4noV9bDw8QwRmB6VSO8knIgIfsUmhOJurWC0KeW8ybeR5MNcwZ51ASQVzFYvpis4Qbm5Zz0WQ0c1GMIciY7CxS7Mos6j40vqCbHH8s163GBZy6Dq2tdVqoXCmU3wAYSdEDAVTZY2v1mwm9mqd33wCQ1GHA8ytIT6sc9QtppEe7aG7i5xNK3pUvmQFEaSdYqMFu"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                BloodGroup bloodgroup = createBloodGroup(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = bloodgroup.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(bloodgroup, null);
                        validateBloodGroup(contraints, bloodgroup);
                        failureCount++;
                        break;
                    case 2:
                        bloodgroup.setBloodGroups(contraints.getNegativeValue().toString());
                        validateBloodGroup(contraints, bloodgroup);
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
