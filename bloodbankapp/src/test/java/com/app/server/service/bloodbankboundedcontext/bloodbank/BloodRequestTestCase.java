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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodRequestRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodRequest;
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
public class BloodRequestTestCase extends EntityTestCriteria {

    @Autowired
    private BloodRequestRepository<BloodRequest> bloodrequestRepository;

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

    private BloodRequest createBloodRequest(Boolean isSave) throws Exception {
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("oLgKIkyN3V1VnF894VeNnFuSp8hx2kI0OEL9gjW2kbLPPpyg1S");
        BloodGroup BloodGroupTest = new BloodGroup();
        if (isSave) {
            BloodGroupTest = bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        }
        BloodRequest bloodrequest = new BloodRequest();
        bloodrequest.setRequestedByHospital("urB8TluCbylgTLdDBlZCuWphu0LIrA27bj5VitJggMLnbv3XUS");
        bloodrequest.setPatientName("p4D74yx0ARqQ3K8pfWzTYq9qaRePN7iSkHcL2FQne09RRmo6xk");
        bloodrequest.setBldg((java.lang.String) BloodGroupTest._getPrimarykey());
        bloodrequest.setDispatchedToPatientOn(new java.sql.Timestamp(1465378019104l));
        bloodrequest.setNoOfUnits(2147483647);
        bloodrequest.setRequestedByDoctor("qORnIr7gSjdj1rIJtJHz68WYXV2k5tc9tyGk2RotptTXoDTt6o");
        bloodrequest.setDateNeededBy(new java.sql.Timestamp(1465378019104l));
        bloodrequest.setEntityValidator(entityValidator);
        return bloodrequest;
    }

    @Test
    public void test1Save() {
        try {
            BloodRequest bloodrequest = createBloodRequest(true);
            bloodrequest.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            bloodrequest.isValid();
            bloodrequestRepository.save(bloodrequest);
            map.put("BloodRequestPrimaryKey", bloodrequest._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BloodGroupRepository<BloodGroup> bloodgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodRequestPrimaryKey"));
            BloodRequest bloodrequest = bloodrequestRepository.findById((java.lang.String) map.get("BloodRequestPrimaryKey"));
            bloodrequest.setRequestedByHospital("JpWQakFqsoKFSurBWGTLaO1hlwQnVX4TYN4erTfSHx4htyvUFm");
            bloodrequest.setVersionId(1);
            bloodrequest.setPatientName("b6z1CHi6MfW2jJaX4iMYsxzhsluZ7Mw35IlFT2sPL0piLSQNhq");
            bloodrequest.setDispatchedToPatientOn(new java.sql.Timestamp(1465378019121l));
            bloodrequest.setNoOfUnits(2147483647);
            bloodrequest.setRequestedByDoctor("LU6bReSzgSwtVRepbkMBrxKXaDlWtXr2mkzYPoHdYlF6423Opf");
            bloodrequest.setDateNeededBy(new java.sql.Timestamp(1465378019123l));
            bloodrequest.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            bloodrequestRepository.update(bloodrequest);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodRequestPrimaryKey"));
            bloodrequestRepository.findById((java.lang.String) map.get("BloodRequestPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybldg() {
        try {
            java.util.List<BloodRequest> listofbldg = bloodrequestRepository.findByBldg((java.lang.String) map.get("BloodGroupPrimaryKey"));
            if (listofbldg.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodRequestPrimaryKey"));
            bloodrequestRepository.delete((java.lang.String) map.get("BloodRequestPrimaryKey")); /* Deleting refrenced data */
            bloodgroupRepository.delete((java.lang.String) map.get("BloodGroupPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateBloodRequest(EntityTestCriteria contraints, BloodRequest bloodrequest) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            bloodrequest.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            bloodrequest.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            bloodrequest.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            bloodrequestRepository.save(bloodrequest);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "noOfUnits", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "patientName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "patientName", "Dqhk4SNnnzW1TkMJi8nzkqkF8JawFQJe5hYD8y4e7iWLYUooWcqbchSU14DR6ZsEk3Jmg8If8WgXzmpeR2Vym3uhrGCKfUVfzQ4gXa8x4lb1tKQn2EDrFAZkKlXsXw7mzMujySx9A8C5k3hQ7CeUT652E4sP2ZJqIARLx9vFcht97ZuPKhH45v2K7v9ATlNUajZlFHVDecUs7tUjysREkfrXjUqo6HXp4x73MZcQwKqwVkuSTLSOI6jOsWkbGsWMo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "requestedByDoctor", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "requestedByDoctor", "gTpvsmQbjnWUuVdAJTFXFj68axWBnyKW5TRw4uoBQBmEnKGq6tWmpu00eId1AbmUW5kvIHVX19hs0tcVejLH8a0o4BLXNvxim61XiktTgSzTOzjjYfuLGQ5wvsYpJvXIz0Wc1ZWFWpmSnFeX17JTSAn5d61wV6CBjppw8ET8SuemStIlFWIvtjTuz1UY5Xv3zklenrnaqi6j8EUpw2ZYg6i5Vn9JxYkM6HrhQrxPKlzarPN77VS35dRVFAgTSqCmk"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "requestedByHospital", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "requestedByHospital", "mdbeoghj6LeBe6d2X29CzAYcxlxJu6lpdByMutuFTcCR3sVP6Gfkn6E3M6vDUAOC1pJIWvMQot3KdKUpACIIiK4WDveW99Xrl0i3FqzVWVlI89aTfj7Y6ZEt993mYF6PMyjm2qefNsTg5zRtmZ8IIMe3ceL4DTZ648BP9Mfc9feGAxrFeiI5ZqS0sbEL7SsSf24ElUmsc77gXzKPsFmuVaImgsnp3VNCZlbGbTRafe9av0LipYNP3L06A5F3fv7el"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "dateNeededBy", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "dispatchedToPatientOn", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                BloodRequest bloodrequest = createBloodRequest(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = bloodrequest.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 3:
                        bloodrequest.setPatientName(contraints.getNegativeValue().toString());
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 5:
                        bloodrequest.setRequestedByDoctor(contraints.getNegativeValue().toString());
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 7:
                        bloodrequest.setRequestedByHospital(contraints.getNegativeValue().toString());
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(bloodrequest, null);
                        validateBloodRequest(contraints, bloodrequest);
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
