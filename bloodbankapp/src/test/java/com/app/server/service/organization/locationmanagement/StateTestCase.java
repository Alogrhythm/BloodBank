package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencySymbol("bU8nADnbIzPw5N3Ke7TqxhgPFqoxs3zF");
        country.setCountryCode1("snW");
        country.setCapitalLongitude(8);
        country.setCurrencyName("1lhXBBNRiT45uC2roO0FftpLrFLaqdIFMDVbhGlJWxMNLVIv5r");
        country.setCapital("HcJPMLMTtWEIZoh7IiFQLCQmjxOi2mLd");
        country.setCountryCode2("Wi9");
        country.setIsoNumeric(425);
        country.setCapitalLatitude(9);
        country.setCurrencyCode("fXe");
        country.setCountryFlag("yortOBRX2v805qJL0NbxsLyebt1EeZDipLf6XVkq2gCK0ACcUZ");
        country.setCountryName("nwkSkJPubq9620H1TCKG4CHJgfelrS2uWfbx1CGGJJTyh2mCU1");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCodeChar3("2FP4d2UseOLymSY6vbvHZPkcHJCyLbAN");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateName("NWYVcEh7Fl6oBDzTDgPTcYL01v0sPdPkeqVzz2yjeq1HfBihpd");
        state.setStateCapital("YiwDQ1EPTdlaNks9Be113QvydJdJPDJ0vUWv0thKDremGROTME");
        state.setStateFlag("5w1QF5OmfsjWwUHXK4OzJxJ0tZaQWP1h3jgicSBMcGRPSNkrSV");
        state.setStateDescription("ZDNgLLuRWwOJsFfKQJB9yQ6GJyEVmfzmliiLPKbFWGtB4lfcdF");
        state.setStateCapitalLatitude(3);
        state.setStateCapitalLongitude(7);
        state.setStateCode(2);
        state.setStateCodeChar2("S0rewftzzfkfyYtfRCMP2VLgCOXwF59X");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCodeChar3("ky7K90dxiQLpxKjC8Pg3KMQHy2jlb3Gw");
            state.setVersionId(1);
            state.setStateName("8kL9hSnQ2KZ54WvIUB8EDqfM77pgRX5TxghnGz3wY2Ye4ngqFe");
            state.setStateCapital("YYymjZ6Pa1xCLkGVFEIaoF1G5ICfNroC8L1jWhl0OOZmGRuhMF");
            state.setStateFlag("Ngx7Kto54Qnb7TpUwnQLlorzAt8y0sOEtsScEzDOBWIpxtURzV");
            state.setStateDescription("Y7cZE3vOHqd8B3ebjewvJ3avmKy4ru5KleFcdG6lrzk0mxG7HD");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("bAxtHCGAgVOQQXsB3fRAw8mZzWSsDrPx");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "Sa7QXHPOK8yxRVF6jsgidvXDFyRagOMEu9X2wRgd0HTNQK4qQ10gizKOma1HCL8cTAZ9hTVjAS9jTHjuZJMB9OsJzCfy3h3tA26tOE4TiVnN9ye8Rql7zbaxGTKRIvyLPLxpodriOnwHOhrBpuryiHSemNbsZm4s2kIBfUB0nMguFgR8wvo16jTmrBHA0iH5SvNCHSAodKb6o3sT5HfAxjKyPQpjCCaKnRRiqAsZaXExqxT7lnCPB4zX9zx9l7lhP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "stDwtx1LvfTjQRdUmDaiaYIrdVPojqvXL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "jsbMG7bSkFJR6wtGTpwVqitgrbvTLTqnx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "BTt9qtnOdcVrlwMrRhtMLcPPbK1wALWhWovXJHUUdmaCms65LF8mUdS5y7ZzIlIwDHdmSGhsapbVZl95yN3CcIth0AFf2125vgAVaHissVCs1U9VuP0dZLL4tlrjjCqCuern4Zv7YC0bpRzyd0qKUBxO40SwvqapAxwi2WVfceJ6KiQnBEyGmQzTbySCdIuzE8W9RKmTa0H0Ji9w8SrVpgeQufgDWkuFgPmmjKuSURPwGlhc8oh1WkO8Oen4qL67k"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "5fP1XTPMBTVhjqX1PJvSQUzRRgBShwf7TYlAmfhlHvlngB9M6vEXH6dNnC71XpN7hXFrEpBJXkCzi4rTjvTSpTwkSpth5l6ESzE1K1UtKdrEoXRGG5G4fglY3yD9O8Tdr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "4Q6HhNvYoEtigsCJ87p3pPoN0yQyHMMcwvLlT1XMtESs70zcE8IIGO5gYmj0bNHnFxZKF0OEakqbv9lhWkatW4LTB2GjkCwiVMYDs7mgYeM2SkvaqabJUeoT3Oo4pMuTJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
