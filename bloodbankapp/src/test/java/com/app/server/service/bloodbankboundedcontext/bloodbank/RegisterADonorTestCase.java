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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterADonorRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor;
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
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RegisterADonorTestCase extends EntityTestCriteria {

    @Autowired
    private RegisterADonorRepository<RegisterADonor> registeradonorRepository;

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

    private RegisterADonor createRegisterADonor(Boolean isSave) throws Exception {
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("sSwmD6KGjpyOqyEeebvSjozjjq4dkra2TwKjDRI7BNXUv6F3d1");
        BloodGroup BloodGroupTest = new BloodGroup();
        if (isSave) {
            BloodGroupTest = bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        }
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("Vqw5FoXjlJoHTCtsV13fGGDtuXlZpTnC");
        country.setCountryCode1("eqZ");
        country.setCapitalLongitude(7);
        country.setCurrencyName("fqh0n3RbONX2eskRkOvheKsitfcEFjEjLOGRTPrkbaMF2NDpXD");
        country.setCapital("tjBELdvx1OW2kWQJlqJfyvlF6bHJsCO8");
        country.setCountryCode2("Pbb");
        country.setIsoNumeric(608);
        country.setCapitalLatitude(3);
        country.setCurrencyCode("sN7");
        country.setCountryFlag("cUZ1XJsof3S15BM0uqpg38nseBa7cBsJat70aG01mBQUb40RW2");
        country.setCountryName("Arc2aoypnbOiWokeOLGpAVDRnVtioNeIZntGrYae70IWByRU7W");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("hvWvIatQnEF8GYB2U1el7txbQqDLycjliKcWbj2nKQO5UFqxXP");
        addresstype.setAddressTypeIcon("SYKFWREf7ZlNhGMD58r2RXSe3y3P1tVHyAW2U3UILPXbDR0wX8");
        addresstype.setAddressTypeDesc("u9PmdSD8uIhbZCh8BmfHFH6yDrQQbWgqBRz22zZ3oLl1ognpAb");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("9OMH4SER2ox37LyUNAUm6jqdbj08O00BphwEytl7KhfcSWX6a7");
        city.setCityCode(2);
        city.setCityCodeChar2("92ZgLgYcVA4LS9IA1yf7fSuKupBE8XWD");
        city.setCityLatitude(8);
        State state = new State();
        state.setStateCodeChar3("SZ5z1tHk4pQrszThHDN870zyFrOFUaPA");
        state.setStateCodeChar3("o25iUaBuDeP5CBP2G70uXqn2DdLut2xc");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("YNzjSNUEIk5ulee6YyHQgQP8xYH6wWaZYXo6D4q5T56Zgi4jNg");
        state.setStateCapital("Zo4H35P6nPGIQXR5Ig71RPkEPTxFSH13xaoTfVPgOSGy1ByCYA");
        state.setStateFlag("DNPPwo4aUWIxgAa0XQ7Aa6dkHwXMT22bbIGNLfKTF5dnYvhC1O");
        state.setStateDescription("p6bqbnOv5ggx5eZNSDyoV21Y7ywwWAIlZANVwu44hJy0wBZShA");
        state.setStateCapitalLatitude(2);
        state.setStateCapitalLongitude(3);
        state.setStateCode(2);
        state.setStateCodeChar2("i4y0zXu1ArclYsNKk2jLQ5UycCupHne1");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("3f2gJRhMr43cub357XwoKan6clIWeLiPagygnNXHtDL4xBtLK9");
        city.setCityCode(2);
        city.setCityCodeChar2("VTP9TH6zRwzoIbO5VVnu5RZS8KhXNEYx");
        city.setCityLatitude(7);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("VHcE1bB7roDPGTzksyK2FiOTeOWu5qAsLWehE0GLuTscUoFVAc");
        city.setCityDescription("qYsR2EdcT6yzz8BaB7WqMLpAEk6U2sCEPBTYAO5zYaaL28snOb");
        city.setCityLongitude(8);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("t9YdRz");
        address.setAddress3("N9R7wp3EHKjkaUWpDQ5AcITcjbjKAzBTpiR3GhBKoCiQZ9Jfwr");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("4VP0AJTuJSF9mfRrkDXDBKGl4F25bPCGwBQJ10B8WMmmumInAr");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("hqyOuZ72ArC");
        address.setLongitude("Rx3eWTQS11Mi2p47togwZ8WkJMUS2e1wmkaJcE2WkaPipk99ii");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("IW3xxQcmD7bkdLl9LNiumYbSPxShIym3UNzRzkWMyssn8Br90U");
        address.setAddress1("Bka8H2PGtydZPlKkzGAgBD0my1r1bCKbH6IWbCEa2ZVouMtoCk");
        Address AddressTest = new Address();
        if (isSave) {
            AddressTest = addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("uekuZcqOcYDxx1zPIMFKuUgkgjLZI9Q8PstljNce0ybUTb1WFc");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        RegisterADonor registeradonor = new RegisterADonor();
        registeradonor.setDob(new java.sql.Timestamp(1465376434352l));
        registeradonor.setBg((java.lang.String) BloodGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setPhoneNo("T2rIm1Z9WQwFjufRfghkAGVSy3Tw84KomhZecwMtuN8tbR5cj8");
        registeradonor.setDonorName("lOeMFnI0uTF1racDAx1XsPLTeaqg0NPz9RYyj2K9QQbwgi24xA");
        registeradonor.setHowOftenUDonated(2147483647);
        registeradonor.setEmailId("ChzJopwAKglOYWe8HYlarHQ0zUMpg53SGqs0BfyZNpAflwz5xS");
        registeradonor.setAddr((java.lang.String) AddressTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setLastDonationDate(new java.sql.Timestamp(1465376434580l));
        registeradonor.setGendr((java.lang.String) GenderTest._getPrimarykey());
        registeradonor.setEntityValidator(entityValidator);
        return registeradonor;
    }

    @Test
    public void test1Save() {
        try {
            RegisterADonor registeradonor = createRegisterADonor(true);
            registeradonor.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            registeradonor.isValid();
            registeradonorRepository.save(registeradonor);
            map.put("RegisterADonorPrimaryKey", registeradonor._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BloodGroupRepository<BloodGroup> bloodgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterADonorPrimaryKey"));
            RegisterADonor registeradonor = registeradonorRepository.findById((java.lang.String) map.get("RegisterADonorPrimaryKey"));
            registeradonor.setDob(new java.sql.Timestamp(1465376434622l));
            registeradonor.setPhoneNo("wTekxHAE8DfgZrs6kL5M9SHB7QyeLBZ0mwepLh1T5abZBdY2ey");
            registeradonor.setDonorName("6u5R0VAKyfHqcur71QmMEYgPj4OazHDGgqGhDG1K9jxRRLZZsc");
            registeradonor.setHowOftenUDonated(2147483647);
            registeradonor.setEmailId("aK3nhnRUrXy80jylLvGCwrt1QpqaQVVRnBkahyoROywptDdg2D");
            registeradonor.setLastDonationDate(new java.sql.Timestamp(1465376434628l));
            registeradonor.setVersionId(1);
            registeradonor.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            registeradonorRepository.update(registeradonor);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterADonorPrimaryKey"));
            registeradonorRepository.findById((java.lang.String) map.get("RegisterADonorPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybg() {
        try {
            java.util.List<RegisterADonor> listofbg = registeradonorRepository.findByBg((java.lang.String) map.get("BloodGroupPrimaryKey"));
            if (listofbg.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddr() {
        try {
            java.util.List<RegisterADonor> listofaddr = registeradonorRepository.findByAddr((java.lang.String) map.get("AddressPrimaryKey"));
            if (listofaddr.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygendr() {
        try {
            java.util.List<RegisterADonor> listofgendr = registeradonorRepository.findByGendr((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgendr.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterADonorPrimaryKey"));
            registeradonorRepository.delete((java.lang.String) map.get("RegisterADonorPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            bloodgroupRepository.delete((java.lang.String) map.get("BloodGroupPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRegisterADonor(EntityTestCriteria contraints, RegisterADonor registeradonor) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            registeradonor.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            registeradonor.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            registeradonor.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            registeradonorRepository.save(registeradonor);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "donorName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "donorName", "SXTP2qEtZF5FQwYYmZLMxl952TpqSnSJ1kXgWiBVpF0ctXPYDShuArk1KW7JAUya1IUjny9x4oicyt27vQZviq9d47VwhUSXkvPNLikT0MIbJLpAZlSRY16jykUAlDewtiNbOp1860FTQggVdGkjO9MpRqLUdKPb54CJudMfsMOKVD0kDzmVjzvGsdjAUYZbVDDHNZru6lZUsbfsubdJaoTxu3tBvT0IjeCuuJE9dh7M5j3wK65RnxAOzy3ypuEkS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "dob", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "phoneNo", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "phoneNo", "BLbfRVn14vJSbSMlJLD5XgTKCwVYv3upwuv0qTJ4Am0HsK6XXnl3EAGivO6ZZDLItNAi5aNrdtphgtnPuZ7Ip6oTBbaCTQRNKH2EfRDsTqqoAUdkI8d5Uc6DUB6yktSiryIjnL9XVwf04bEfXp7qGiY2OUM6BAv7WlrBIDIwFMFyFG78LC07R6sAaRaKNBmz9lrP7mvt6N5N1TFkcKIXK3gEaMp8Fv5Y8lw6oYC924W2giMcIAYHaZFu7isSpMFdB"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "emailId", "Efkh691T5nZba46efXSEi8H90gEod38cSDWzqxDm7kwofvKDwNl7IhXThTu0e3DfAw9RO4tp1R9pFCm7CeW2fkIrC7mAHhrFlZmOLIzH4Q5BUiavrTdOw8R8pH0iSyamL1lqbBz7Z2C7KDrwIZ1G7CQX10cBCq4TRqG2xTkHn6ZwwxsEkw7LxO5oLkI9LoHeHO8Va2dEErsnol5s2xcGPW87b907MqSakiQwfu0L3DWgSKAoDlJO8SyIIDKnt2DBI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "lastDonationDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "howOftenUDonated", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                RegisterADonor registeradonor = createRegisterADonor(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = registeradonor.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 2:
                        registeradonor.setDonorName(contraints.getNegativeValue().toString());
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 5:
                        registeradonor.setPhoneNo(contraints.getNegativeValue().toString());
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 7:
                        registeradonor.setEmailId(contraints.getNegativeValue().toString());
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(registeradonor, null);
                        validateRegisterADonor(contraints, registeradonor);
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
