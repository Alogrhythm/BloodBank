package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
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
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("znFJmjqBBsl4usB9gN2QltHe4S5U2tj7Dpddmd3WBd4p5F2CjY");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("ZN7qlABkgOgVcuyuwKS7vEgKlNaZDjnY0ZFnDY4HCZo3QX4p17");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(2);
        timezone.setTimeZoneLabel("JJt4oawsV4C8jwdJzZwTnUjPfVpFEVm9ySFCc0SelMyhreH9gK");
        timezone.setGmtLabel("WEAQNCsbaqJTNHo1reSY3VOvLbLnM7tx2kOInPvSufo6yX0tK1");
        timezone.setCities("iNnZ2Sjr7SUvbAzkfDBqQr41CZXYiBAKupfI0f6N8ELcDgECTU");
        timezone.setCountry("JheHGQ7WV1FV46CGqIJS0FeR7hRCNMHzUaL4xHchLUk4vDd3xv");
        Language language = new Language();
        language.setLanguage("xPp0DVEUOUiDZ8aViwoZnYMiijWNQfQWNAtRPTLwu1pYYyf24u");
        language.setAlpha2("DT");
        language.setLanguageType("QqMjcGEV3wzgsHQfY7nlHTUELrjClbn3");
        language.setAlpha4parentid(7);
        language.setAlpha3("LwR");
        language.setLanguageIcon("fQVbV48Y7V1YIMevBH2l4B9MXe1LLJeZndbRw9Wm4vKTPtR4aW");
        language.setAlpha4("Uo9h");
        language.setLanguageDescription("f5ImgZz0MXlcL1KQpKpZ57Ey5W3p3BQD4jPoJeFLfm0oLGGIij");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeFirstName("sNtfw7MylxLVbPqDuJoFA6mORjr9y1ySQPJlBPIzGVywb67JDq");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("b7bTeNbEpU8V1Jr2GSkow6OJTSxFtohCiXgzkjKRPMrzMu5hx0");
        corecontacts.setEmailId("dFDgq6gXK49zQQVu9mmRp0siNN9TdZwCi23vJMOxsCQ8JKbemW");
        corecontacts.setMiddleName("tJwoHLTREGgNGIookpY2NOtZ2ojEMMQtatPq2MhrePbIKzHVtj");
        corecontacts.setPhoneNumber("8kSdgSdFoVEwNUq24cG5");
        corecontacts.setAge(83);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("ndpw5f9Nu0OjIaeEO4HUlM930yTa5T5w4GsYtyd3pBL71Nt0Jo");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465376429317l));
        corecontacts.setNativeMiddleName("ARvZcjuh2OH3CHQcN97Hn3S5cVboL6CCdVcdo97lZ0TbCjCy9y");
        corecontacts.setLastName("1AlLoZ3wRLwNeNQtYrwdYSfSrJaQi5TX9t4t8F6aVO3dHZnwUZ");
        corecontacts.setNativeLastName("GNAkB112GVaJ1cGxwFwI4PBQhDtMtDb9YbsRMJrMAY6O0Wy11H");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465376429317l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("pjNCq7V76Q1syS0nNXbJEplvsIcDmfSt");
        country.setCountryCode1("WM0");
        country.setCapitalLongitude(10);
        country.setCurrencyName("vJ0iXSuDra25Zg8pmlRiwhxgr7FqGzJHy2S2WtwC6jHu7WaTKb");
        country.setCapital("czjxAEgUcugIZZ5ofTqlnCD6zh95hXaj");
        country.setCountryCode2("KZE");
        country.setIsoNumeric(539);
        country.setCapitalLatitude(11);
        country.setCurrencyCode("c7P");
        country.setCountryFlag("f4KwmfhWlUIVrMo3zZZoASSARgiY1ibRjGYW2OX65nkj8VRbwL");
        country.setCountryName("xKp0sf0ma4XfLzSz2giJCuAa5yXQF604x6px5pjYYmnQzv6MQE");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("NvH68KEPyirc1XXr8jbVgMaNne0WyXPCZ2dzWvDvq7w7DLjkD8");
        addresstype.setAddressTypeIcon("Gz3M5NgOA9RhMf7yvq6mXeimwtJ8VN9F4qgZyVrtUhMU6IqEGY");
        addresstype.setAddressTypeDesc("uNgHKH4SkfVJvk9O7sQ82LMoLxD58ojEmnelGd9hHyn508pnbU");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("rbwyTWuqgsMHF1f73YGsUakYJF4r2ExjREtc9MWs9aGx8qL4I6");
        city.setCityCode(1);
        city.setCityCodeChar2("AvVYJFvEfyqC347wcCJL3XKwWsUcbz3K");
        city.setCityLatitude(4);
        State state = new State();
        state.setStateCodeChar3("0QVVUUBkbfsVEE7ovYwIb0d9m0ONC1to");
        state.setStateCodeChar3("k5e5bI5oq54EredTT0i1tVKYpVSejN5e");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("ihTpPmFG0FbpzKvLyZl3Ombu5ftxMw6JObv7mpGqR9B1yMJJFW");
        state.setStateCapital("xAkkIJsc13Vu5KPCw9i6pRM8O9H8NoqcPEK0w5dwAlaaF22zLw");
        state.setStateFlag("AB988sqfBUMGyex5XOwqRwQzx1gz9Fl5b3hXVBoHIkfb88hHwj");
        state.setStateDescription("hydrWw1ddcrqYOV3DSCqk4uAGQEK5cpvwkuoiaEJK49LWtSH4g");
        state.setStateCapitalLatitude(7);
        state.setStateCapitalLongitude(4);
        state.setStateCode(1);
        state.setStateCodeChar2("ANuOPiDGbt3rSqtpYL2pZUfFhc004Al6");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("3hgfStIHUoEWzsH3cPOHEqRWz38ik5j83kdUZqW0zhsfB19l83");
        city.setCityCode(1);
        city.setCityCodeChar2("xRG9AMwuiMhAG4JQHXXlBHNdxRzPnqpb");
        city.setCityLatitude(4);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("PuEcLdhlm4TQNdjP7PxBqoWrCaTyjc5IUSImhJQdhWan1ypuae");
        city.setCityDescription("cHViln7FZS2J0DKuB2ebXfxYGKxYS9crrc9UpUBEjY0jZ2xIpv");
        city.setCityLongitude(11);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("vYhbsM");
        address.setAddress3("LjKEhUMrPAI3EweV14LlWfyUs01DZXEATbqba6B4nKC8N4GGl7");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("tF4nrH4HMX7V6uqsdGteG9CRf9my0rAAQD7BUjSfpYayIbC9TI");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("czxYTApUEZr");
        address.setLongitude("16ERIfR6iiXDe9CSjYLAd3o8b4MVi8XBnRSm24ft98cerBa9WE");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("tYlzK1YkN6US2rtfSg0jR5aJa8ag5UkNJ7Zg3w1P2jDxmHF9X2");
        address.setAddress1("ylPgg29cBEpIyUaXF9tH3dGyJxXY8lsGVZtZe3Zz2eGPdirhnI");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("KDZ3PDmyXBZwqXNALOEWrjdoa2XuITBTaJa9y2TwboIbm6ZF5r");
        communicationgroup.setCommGroupDescription("g4YY1EvJyGUfkL11WJ3HeDtG923KHwNvDAiHbTRT1WG4B89IJ0");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("FpyoE8FBoWxtfLAz3QlPNjCothZOuhSDC02F65FWeoRSFFncix");
        communicationtype.setCommTypeName("9wh5A3ry3ywzyzT5d1HUkhqjP5n6g934oxC02tw6bclBFLbxkK");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("yoaD4rSaed");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

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
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeFirstName("5WwhwYkjgKnlNkymrFlF6gtOHrH0nDw1SWEGPZ8RdlyT4laqDr");
            corecontacts.setFirstName("2Q5oVsQqpWjtGJ9qlPvH4HunRT8f96A2JGzyRDA1VUMWMuHdQT");
            corecontacts.setEmailId("AOmBPRKXp88hWmfg84v2meFaFsLEpgfI8YuMU8TywztEUVFSuA");
            corecontacts.setMiddleName("TowBUvPulsgnOiuchls61XjyKSxZud5OfMkqFk9uPJ6xyGYkmH");
            corecontacts.setPhoneNumber("cQosG1l1j1KpTd1Aq7p0");
            corecontacts.setAge(52);
            corecontacts.setNativeTitle("CGyMBZlhyOwhomqXz1P8kmWpBKzvTkKonrAYVXtZWgoQ5PcduU");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1465376429849l));
            corecontacts.setNativeMiddleName("YA5XIYfPFmm9qYz37l3WHxJ9UFjCWAnQryvOnIT0hGuv4FtSnu");
            corecontacts.setVersionId(1);
            corecontacts.setLastName("0h2lCUcauptq0jcbQC7lIR9aMw9NK50x7CFYTsAkOuNhKm1HZk");
            corecontacts.setNativeLastName("55y2oU6eXw4WIwoatqJT7sBPvxmdM7nMpM72jpCaEwqRXTrKIq");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1465376429903l));
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "8wsqtkv4rSWrcRnvIUyOiZ9CgpHyqAjjEgvfygCp6WzLEeKUWFCkdoVk2umWvNKRctn9eOzUCHMPop4vI1ryijl6ZkzVyGcsCHkohRf7zLVtvVZpH6SeShNUILtkYDmbxiA8uFr4ODwUnHWozYlvFf2uVaIe81vDlSADb5wPBB4gOjwXcGDI5RqzKbTZc55qmKwKRgxlYdXObGMJitcs0wwrc0SCuRtRjVjVdR5uWwSj9T1wfugOoL4ipUFYfuOTx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "BBXJGRiDWuVRBRcel3NbpZI7TZYABJC2x29JpPB0NtvROV6vu5OWMMNF0iJMjV546AeAWHVY58qNpDPc10LLGEnATh8Dop62LDdFDaKTB0LM5898y8fRUOowyWEzODMUkBMYrW1Bk1rpi0roEFrDyrlPJzxn1DH5xtyOn9GIb9ZBlQuIkxhFce8VgUsSchz9kJSeXnN1w8OqEa6AOP0w4Q95qDU4JxnGosT2s1IS2sIo49A70xoUd6FQ5QRNACNRb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "Y04A15Xmh4i51nlo4Bgcrd8sMmiqB7H1lknaR1y6nNnNJfWUIj3o8JvxrRUKBZOXIDCNYU5OTg3QWuVZKQdb7aqGkoZVcZ2R1wlO3IGiWw8BJgPbKz8Cri4O7g8gNj0dh6NaDdaukDzVvxAkH8xGSwLt82IH6SmI7HHXNjzh2epfFksjUwFjLC5jmSH5KYqKpnjH21XWycWFALSSB46K0hvADGRv789RArTnJ3FR4cJpnmUMKTdyWK5T48dr6B28d"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "jyGrt7lDHBc3rdhRUEsi7xmIleleU3TWSRVDBfnz7GOy2kxknmi36mXriwKM9MUJV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "ePVlZC9V4ZKi2U9ZuIEoaNGZEgCZyRx2Vmo61SpumTGp8ggXIQSnkqi0hPSmdxxUTXk2z9BD5vwZDclE4JMWFoxCnlLYVbZ8j3iNADVVV0DG2Um353h5ZABZuowfMgTF2QC18vt87paqyBuqMeaa2gKJNcBw2QnYer3atuNnOsv44fauXDibm0QUN7MXiAaidJm2h1Z10AXSwikgPbuFOlQzWN6vv5YSOsMFJAvDPy40jHhrJLZPJv3wvKAEQzGoY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "cj0aoGAMQdaDILCjzqdF4B23qB4Wimfy6ZpQm0fYdxCG7RjxXRz089CAX10RCPYKWB6oMq6lkboJGDjaRvb5wgRWhFK1XF0gNcAo3swJM83ZsewFyCLeCinAy7HVecsXVHfASNuB9ZXQfSYEk3CTSkPRCa5rkOE3CtvrerZ8dl6iNfpHU2SrBC5t864vfHHdPAUY3pEjAuYqZnvLcSvr5ORM6wg2mluilIetT2TC9sJKLkfLTWpdgIvDUtSq08G4E"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "qFSn0vRW8oe66bualqZf1VXZG3D2Iks97bqrOPZHCVhCTiSfcVog7grs2TX6dGmzgBRrbohLSigwxbxJCAtJVoZkUiEaHzdoj9x6x3UdtDZ9gMmvE3A1RO3n32AOywprd596alWG3QkEhwuuJ2jEkdQGknwDAQvRzZs9R0t4vaahaxiI0D7gOIpSKSc7GIIZARYH1xG8yN3Oa56giVIvEOe3VbIis0UwCWxYoRGpBbz6lKaN4Ccq8XBKtkY9hTQwF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 225));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "0HnmMVfFGvXACL9As0QCw2WZHLcLWCdITljfLftbeEJ78UrNv8cC6ztncuDHa0yYTKSmiPcy2mpxu36t7oKcE6uLi5nDkTs4mwMB4AnTC99P1OM5wCgX7cUaJZMms6k1JxVNF007SGDTGMCBleAx9MrabycnNEh3QCBkhEUFqPZLCWPEwuHLJ9kwIAeg2x3aAu71Fxb6UpbLqcb9lD4WcNID82CP6lw9kdpoHdKNQqQ3Gp1pIlkgdowgEDwgu4pF7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "pn7SOuxKIzhLAupxsllxQ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
