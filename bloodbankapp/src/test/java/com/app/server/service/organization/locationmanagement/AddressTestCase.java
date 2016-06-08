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
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
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
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencySymbol("kGAZEpsmu0PvnuQm4ABNf218Kfsb6WIc");
        country.setCountryCode1("bd1");
        country.setCapitalLongitude(9);
        country.setCurrencyName("Iqz7Deez5VDeVw22BgYcATRHvMhq1QseDP92HHfuNIay3iu5DL");
        country.setCapital("R9JZ4LBdlB1hEUqgfDCDuzSrFo2keA7j");
        country.setCountryCode2("IYg");
        country.setIsoNumeric(200);
        country.setCapitalLatitude(2);
        country.setCurrencyCode("8Lr");
        country.setCountryFlag("xKIB4IoJSJPOtzh1ZlIeVUb7zJ9qt37yms99vPzeakLu8xeg2C");
        country.setCountryName("3jneFlzSsryhFUpqMscSULWUffRLHKfBziTAcSMDyzumY2uFcJ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("DlYzlO4fTT2AgtteLH1hOx7ordMISAtrjVjqoWmP5qlAXtVoY1");
        addresstype.setAddressTypeIcon("lJl03ItWaNlvEftaaPgrtvHMgn2eOSxhExfnv84XQ2SB7FTged");
        addresstype.setAddressTypeDesc("ZiEMZwtK8pI8D5Aw0TZC8zqW4bp9oDeQ3uIR901PJZVmz9aDG0");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("SBWqwubfx1fGfd9atKTKZwBfrUU2X5xZLEkO9d8KrQDbUhZbBu");
        city.setCityCode(3);
        city.setCityCodeChar2("r5wkNfp4lk4LTA0ij7k5ShXS41A6Cq2t");
        city.setCityLatitude(1);
        State state = new State();
        state.setStateCodeChar3("A1QSiZNRWKnTByeyAdZfwXuGeMNvDZNx");
        state.setStateCodeChar3("G1EOZ5ZMfluGwVOuUr7wMPSJ6HDM0Yvb");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("vdPUAsaTyEVcoDWLw4IyGrNzDmNBs8rlwh9Eke6H3GsFAmlZub");
        state.setStateCapital("VFSRaQSyuGcblbwetNIVvTHF5BlmaMr9AJ2BzBQiZm4iwcUa9u");
        state.setStateFlag("llT2VkSotZgHWBTfOlYnUh3NrlXWM0xJlCp8qv10yngFvWCJLV");
        state.setStateDescription("Gw8QaP5NP9Sgl4eaE9RnD9bQg56LRnPFORQwNjiKt3QRPgq51I");
        state.setStateCapitalLatitude(1);
        state.setStateCapitalLongitude(4);
        state.setStateCode(2);
        state.setStateCodeChar2("s2ADHb5tt8BoNlum5Z8Sm2Mjxm2tkvjT");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("daBiLjlKASpt4unyrpCpbrPMzBUFGewrEFdrA2LY6543oCAQBA");
        city.setCityCode(1);
        city.setCityCodeChar2("lSnyHx5GcxjVMgnIL5wYURL1SGjBPPwd");
        city.setCityLatitude(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("JBejIs6nQqabbC6HECL0JAYtBYKKuUBr5ZlnfEqUKPKeFuGA2X");
        city.setCityDescription("sTCugRIWlYgJCLlvb57mvt0MfPUSglSFJyMFP3FtrGH0c3i4Le");
        city.setCityLongitude(5);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("C1GOpp");
        address.setAddress3("euB71apUiDMo75DTj7fJ4ZvG3pJCI0612B8lP3G28UTA3bw5mT");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("tUDRqvOavpozK9EG909fsdqH8pwr1IrrrToVdQFt7lbpNyUfpb");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("rwagZYZ1Eyk");
        address.setLongitude("C4iFbNATwHoo71I6ifrDzhLNNkFGKfgHmGh06FXQlzgxcO1Vqq");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress2("3EotKOdRCLr9jpqH0eKM4j7wWeYs2uykDdpL39PE34w37bgPad");
        address.setAddress1("Oy584wLok2Lsduu5mIMvXl2plzDykervWe6Q2iGC1xu1TsaX0k");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setZipcode("1aiqUY");
            address.setAddress3("xzAnoySZg6RI9RkBj2xM6XttKDs3LP4rjqmDE0EvlXWkPbc1RZ");
            address.setVersionId(1);
            address.setLatitude("fmrSyOqwTQSQfzXmfLw1YxplFfkWI734Q0XZVoWxILhSsmbzLX");
            address.setAddressLabel("hazZi82dtdT");
            address.setLongitude("RHTh386MHpEiJNBSQYcAGOXGzZD5EkySyOd68DOrqciQ8Jh81O");
            address.setAddress2("RmnlRUvzEwS4jeJXBSnSVJydfuL7dL9AOVYuduxCRgXCobW0en");
            address.setAddress1("l2RcL0bpiACW8ASZxTRXiEqD4OgioDEMvooo0zlknpvDLmDi5E");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "8hAqD8LGwxYt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "jj5YuwhPt1eUQhCvR1ApHHrBV15TNPQeBkf5gZHH5fIvca15i1NZJvEtB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "jRsttQkMfK52siDRQfVKj7rHAdWwmbQJYKgNaNSJ9iMKKrrou4NEC7M0D"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "udiSiTNWvD6N8dfKgF7otQY3OrrafqVOJ19QXupzeldGFZ2p3dAZk6bPY"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "oSRoJXD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "baVXoVhlMjMlTM0xdTJJsJuqiwawEF88xbRy1HUcq4ZBgRDarR7OGEd87JZbJdWwY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "ZybYkC2dAAqTiLNbB95aymx9jlNGlSrh62Uwm3V2h9AWj3jbyymezEhKBnnjKOSvE"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
