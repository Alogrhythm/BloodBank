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
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("3VMv9PoFU8V8J8PqGa2prg51W5fkC90j8rgIuszueA2Es52hRT");
        useraccesslevel.setLevelDescription("VFxg7DcJvsWSyYz5WkMmDtUSM2SlKo85Xs3b82oKSGwaP7vc56");
        useraccesslevel.setLevelName("FCWUuo6Z6jgtRQqWj6yc15mlqLwZ6I3gGrMpZdkdrPFLKtwzqd");
        useraccesslevel.setLevelHelp("1gxXZ9F0weqkO9rbSdZ6Djf2t2vlI7g4rOp9WRvjj6lpxmDQMg");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setUserAccessLevel(6930);
            useraccesslevel.setLevelIcon("d4RsqlwuMGLsD7gAHfjcS8pPWYFFVpjElscepluc6vbSM5pGSo");
            useraccesslevel.setLevelDescription("tppZLeamVnozZw2nO2ZhuyZRX5a0HfCrbVaCRNXdz3u0cw2cRh");
            useraccesslevel.setLevelName("1p1McxJX9o7pRpZO64vw8U9te1LCXPT9esTrLYd3lrmYVt6Iu9");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("sWDdEKdUZ4TvNxaOebFfJc5hffmkNkVjXfOknJ4C2LezcE5d0c");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 133905));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "EHrAbxI2O4ySxWwsJnnP6lQGAE7ugPkumAt4xmmQB8FcAYBFu0IbIKK65L4SMzTIn7b8Gy37LFn0j69MD0ixf2opdOZJgJXw1ptFSw9KuS31lUz9w5A7kzh3UYtgq1JMoujmiWPacCrO3K7I7wrwCTjCs6aIfxRXSz8qu7v4bxtoGMjCw0hFgxAJUjgFURVZzKEwDHIQY8cVSQ8drg8trFRXQ8xt4sCvdd8ar5GiXmZIdpUCA35e4VHJpzovTPgfY"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "qtYTCZXfaN0qDB5TJxFwPifd1JWneIVIb3nI25v0ZE9uamso5y7d5atxhSHhcqpSvS8Xz2URMsw0yniXwdIAJ6JTspsQekZJWjan4vRyxMie3e95DF5FLoTk1L0te70TNtQRpZgqzjZpZdjKva1D6cWFbfCj5mRHrQ48I9v4f5OHrCGjgxBY8zvShOuMYpin7zLfNAkgCQK4rzVSH8JNZcJjB0XW5Kk1AFy9SQpkfYN9DNkkpdyh6Bu2wnkkgiwty"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "hBEy0Im0kLwDI0fTAhFpgQm8kCzBdA80daOVCqwkM7OZsrG4BMyTRntgU5SeRk3Wtqdq4wYiLbNbhv3XHTT6WeZXcAOcZGAjTW1umcjY0JH8kcrnbrsicTDn6Cr850UBmwa3UxC1OdcGj04WlZZEgyCqyN3GWSBVJzYB0AXEC3QRxt8bk4G1sEVIkLsa1mYGwvuhBDbL2KZhFHwb7gFJ0uFTqZWG3EgcAJuXVlnh90B74CMe4KJy6QdeFRAwKUIBo"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
