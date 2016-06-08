package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuLabel("v7Y02jzzUeXcJYOfj243YWuCKLx1ROHp9UygVOLHedITJwP93o");
        appmenus.setRefObjectId("pDOsvo1Xo1n6eGCSgGQZAUx47z4CUKsTER6Mo6it8PFTMH4Z6n");
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAccessRights(1);
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("44gkF839QkL7Ub8jSrpIzMc81P5oBo6akApX0OF9w4fg8l9ZQR");
        appmenus.setAppId("M8c9Xh3rAVPieRGZzTRABMsdhPg7wBfn5EIokQFpzbzHTG9hq9");
        appmenus.setAppType(2);
        appmenus.setMenuCommands("2QETo9JXOfZ0Xhn7hFhkZU8WcowT5BncHoVEyMTm7jnr6ema9e");
        appmenus.setUiType("bIf");
        appmenus.setMenuTreeId("dOcgE5w7m6beG8C5Rkb1IKKULFV15NMvzj0lJq1uZ5FqqYqeU8");
        appmenus.setMenuAction("agOjZPTBC9d4Dc53i9dNPwbMzN6Q6AkXLMUnazMGKL5nLa2iUW");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuLabel("KpjZVxlNbbuZ1vd4wAxQp84yZI47lEAnSlZJqS7h6aFQw4xUHb");
            appmenus.setRefObjectId("mO3qqMG8nI9Nu7JVXeNFwFxAXe9uNujPKHVceVP2bYbhQxNnfC");
            appmenus.setMenuAccessRights(10);
            appmenus.setVersionId(1);
            appmenus.setMenuIcon("9ZHapI1xDOj1XXhpzkkOQTjWdHgXzQPjIm4ksWec7KERV0Qgfm");
            appmenus.setAppId("fvs03ao181qQntbCjhQRK4sIUUFcucEuCCxptzi7eDGuaKCYFJ");
            appmenus.setAppType(2);
            appmenus.setMenuCommands("oeAvjaXNhYnX7m3NrVIMI5AGAfiNimAWkrGctaakYeGxfBw9MN");
            appmenus.setUiType("xR6");
            appmenus.setMenuTreeId("tUbmJmsVK8vtNjmZt2peq8WlP6YVWm37oNh3Nn1Q2MG3wovYnj");
            appmenus.setMenuAction("fOeBrnMRYUDknRGNQBc7rhQhoefbo3kXwL4vVXXzqUtMQQHCIJ");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "XHFYQLDQeoaHwR8L5lESRgOnvsQdHjnN1VHOkWTjNuJBBvBJNWLN6KQBXgtSyZAjLmu9dZH7vU0nbXGQjaS91tzxobod5MpFyRVP96dG4yUyd2OmaB0Q6RtfVOdx8KaRwyNtmUlQxdfYDrsdFGoP7YKUCzEDPwM9IfASuXzv2sOulek1Melk2AvGWC5XmaRDNlHQJJUc9h2ClV5EqlgQ4rK102xTVSxZqRNlYJavxaMfpPC7PelvVbLBZSfmZTwLP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "LQQds5BweRgWyXh7QY4zBVVWbUsECJj5qJ32a2QFwf8sXygy5sK4jIV4lg389NRColifBZLGIaGDjMjDsOsw5miSqGKfmh06QnimUQ667NnpHU9kzh7MIlDa7X1b2LmdxnVqj6moqlsE4gKJUQgw5dAJlLrMXkus5TOTqz6UHX03tOBn7r4S8QqwsB4HGDgJ4C1FI3c1cmoM9YcFo72mNa8u6S1g7OxhDmeksbAkUWxpzyCvVVBUUOuEXtKlWlDcR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "hO6wPkuE0eSAcPNR5PM2duGLY4WONOq2jxCcvqyoeZjeeMAbFlUqoAL65QFstG4dBlIR98TeVHh4VFo5m3B6BMaFA39UW8iFOzs9KK4tAoKIpmTFwkZm0NgRY8s87bvQtYWaGn1ydJkKHnmtzi0bJqe8FEQFfVrswtc9b8nQHE5d9m5DLEBISBy63khFfSziMFG1gZ5xnoXs7FLvoyujw9J7Pv5hhLcR2GvyPJ93YXgjbaKuICn4lHeBmwZ7FBihs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "zJIZZMJU7qUHBD8xXUhXnMi3HP9gCkL5y4kKp4ketQUGJbIjdnPn0ChWxYa4CfZuw"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "W90YvlRscLNS2Js4QL5gYn4WDwcBOQ7ULh5ADw7twH61tzgpXzKllmkfBWkEy7LRUwdbofHb9njghLdj6D0q4aaUuBwXQufFdlr59PYJ5s2CvuWriAb9Gr1SZZxqGjyl2YvKktAAkMDb2ytyd6iToz8Dw8ryjRCSBd6zk1wiKhLELhcMzRX6RysnAcqvghdnOBCs6fvpZ86sjMqCFO6GSFvvK6Mi6ZF3fmJ3j0SSz99ZOwwat2nFNgbS6tBzMkxH3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "sYcE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "xBAYIQ7VPo7VxYzRiNDnduS6MXuYpPsfE806JPgd7Jrr5QfD4PnoIM1rg3BWpIjv4xi2oHGSruBLNwFH4xXbkAiKBgNXI3X12BVFuqTv8WpfaViyh9CeklFETx5fHHK8ISK0caxoym0l0za7ZMuFf2WyrXuRQKUXwGOvNN2l64Sy3APtGhD4vahtTRN3X6e4z2HFsDMlN8aKq6iZajiqes8J9dBDGg2s29VsPlQt5jxF1sdiR2GfJY67xF0Z4eRPv"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "MJ8SwFhzhIS8vBpZH4Dx69yF0BJEAyZ7gIraGvwPmCwGs1aXVEwUFGXlN6WGvvgk9zHp9FZNGMLWl3qA2FxSztvmzi2XnL0brLXFxMVBEBcgycoxDrwVKT8TfRd1CbInnMl3KIVRROlSf55Q3Cp4b01ifEhILhwEACkltkajGiq4XM4ZgjMWM79VgIYpAbF3JsF5GWq6pXOdKv9RbmRh7Br4BeFT5L6OFDxplIqnHitYiMzSp9c9Zkcfwaa4W5dXm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
