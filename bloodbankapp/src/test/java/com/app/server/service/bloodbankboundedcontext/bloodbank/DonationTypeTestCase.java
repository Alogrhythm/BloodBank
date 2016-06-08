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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonationTypeRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonationType;
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
public class DonationTypeTestCase extends EntityTestCriteria {

    @Autowired
    private DonationTypeRepository<DonationType> donationtypeRepository;

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

    private DonationType createDonationType(Boolean isSave) throws Exception {
        DonationType donationtype = new DonationType();
        donationtype.setDonationTypes("HNlge6hGy62j7OeCoe0FDOGReV4Vba9pT37tf6IuiMBrdPhZ66");
        donationtype.setEntityValidator(entityValidator);
        return donationtype;
    }

    @Test
    public void test1Save() {
        try {
            DonationType donationtype = createDonationType(true);
            donationtype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            donationtype.isValid();
            donationtypeRepository.save(donationtype);
            map.put("DonationTypePrimaryKey", donationtype._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonationTypePrimaryKey"));
            DonationType donationtype = donationtypeRepository.findById((java.lang.String) map.get("DonationTypePrimaryKey"));
            donationtype.setVersionId(1);
            donationtype.setDonationTypes("w81YXNns0Z5NkMN1NosHHEEBsX3OkJ2T4SzMqTwER1J15wI7nC");
            donationtype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            donationtypeRepository.update(donationtype);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonationTypePrimaryKey"));
            donationtypeRepository.findById((java.lang.String) map.get("DonationTypePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonationTypePrimaryKey"));
            donationtypeRepository.delete((java.lang.String) map.get("DonationTypePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDonationType(EntityTestCriteria contraints, DonationType donationtype) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            donationtype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            donationtype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            donationtype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            donationtypeRepository.save(donationtype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "donationTypes", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "donationTypes", "sGAZRw3S87MOsgV3berMjoObX5CR2w50P0JbeThlMLt19Lb4KFNCZlwKhVZfAg5UNlVDGeHnrqnyeLID6J0kgTD0rJ3CPCPPw3WWZrwJbstAvg3H9C0Yr2l2rgImoB5LWOeaKWeEaEN3V8krPv7SrBWXpN6xc3Th3tncTNe0ZbFRRHHCsHdOan1sW4MF0dAgPfyjOi1cqdSLW34NrarOtFOEC74UgRuTlI35gXfuL8Mxx8WP2s4qsHHynaqw5Ef0H"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                DonationType donationtype = createDonationType(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = donationtype.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(donationtype, null);
                        validateDonationType(contraints, donationtype);
                        failureCount++;
                        break;
                    case 2:
                        donationtype.setDonationTypes(contraints.getNegativeValue().toString());
                        validateDonationType(contraints, donationtype);
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
