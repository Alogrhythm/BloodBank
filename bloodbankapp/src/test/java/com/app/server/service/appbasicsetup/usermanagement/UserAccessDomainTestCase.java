package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("FNeT9E7YlgzWBvnMc4xiAxXz6nSx5n6aqarqXBsQr3LdZ7sm1f");
        useraccessdomain.setDomainHelp("CY4WPdjn17ae5QvTiXpc7IDgm6Rni9HSDoe23OLVmxktaqxCeZ");
        useraccessdomain.setDomainName("5Lln61Ws74u19ykCMaBTuyxKnO7Jjb8qcP0wAHo3XpPAzfPck3");
        useraccessdomain.setDomainIcon("PK8II83kBTMeCYnUK62Sbg3HFo1NvuIcQ2xhmi0V1iZHoCGKfh");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainDescription("Aux3PSn1jG64ofbjGX70aMVwOu0KQhj6ffIWZd6N2Sq5TXC8K6");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("eATYLx9GdIMb6qvEXajT8myY17XV8w8VB3vNC3lpsYEf0NK53R");
            useraccessdomain.setDomainName("3Zza1snaZaA0H0qFpEBSDbdmjpnWfjZlnKqjkEw7TdoSamIeaI");
            useraccessdomain.setDomainIcon("RocmIrPiXUnJcC1H4RUuLkwGUFNoju8koPS8VQrdxR3DR0f1pa");
            useraccessdomain.setUserAccessDomain(94941);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 135469));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "ufO8e8bELZGG63koykfPrZVegXqyQ6GozFDRFrmLYcCBKZSrAizM6x6A3yxDa5nYc64rXHt9TlTeb1x45ON7CzdJ5shkAB1Gm0aRkkZtGfH5dNZq1IzyPIEMMvL5dyz4FT8X9S4eMcelTtRabQcs1hLGMVecxHtHloqxRWvy4v59dK7sqrdt0VjXaurlXT5UF21Ddm3jZKdZLBZZXNo9Grv0Tb1bC9kdfPDhinCYw8ej7OBk5lhrtXtwYiKZ0WXDd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "gMCoiK7OOuzJofqXUwl9G60De6cNn63MMzt3bAUmkftVMrU4B8YdfZafi48xNmoODCv77LnHKuiLrmSbxUyzPmkl1thY8bBg6oaE6LR6QkSVSXYt28tel5mkI9nDd4oNwOosIfVgulW5o1PtBKmWFDRqvaL5zqnC5FPQ8dMohX6vvyIK49IQ0Lb5Bl7S1PHCbOagVww89JGhi2sqf2UQh7ccO2Ph6X7QIYIxXDwfueDg88o4vGhDjI1aIrqH2jyfS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "dgHtPF99ykqirhuKG2s0WIt3w9bq7NjRflQ4blMUDDb8sq0mwezh4wQDC44CS5VePVZG3ZJdWhS9HoxrbgTDl2dF2XLoaUfdNhz6MgYInblaGgp972lCZxWJD6BvUjnN2vReArVrKMFUPK2rNm8ioyfoadVj66iiSZRXsZslL2xvLuweXw6wfmEEiejYda8EJhy6ZF9NWYpMQZI4MAtTTwayzToxWAYGYLdVIcpbozJiIc0xoGKmR6dqtgDX1VLtL"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
