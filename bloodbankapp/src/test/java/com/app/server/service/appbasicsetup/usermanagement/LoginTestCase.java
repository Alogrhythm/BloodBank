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
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
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
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeFirstName("DlLi5nEEPP6xool3FiUCgFMavWtKhnZZfQvaRl30cWjVCsAsY5");
        Title title = new Title();
        title.setTitles("vu5GAV7VcMBQ1S3A5DSbk2xnx9IXLh9HJkZAjFdiC8RW6xyrBQ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("Uob49rUaK2ay7YmfwkqUm2sPkozR5pJWINYuwLBQtJr8CEhLCE");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(6);
        timezone.setTimeZoneLabel("pWoVvfTXLdxx2xXvOkvjeDosbJKwd3V7iuVDWmQ5oGsG2t8MQZ");
        timezone.setGmtLabel("lSauce3xU6VOxCl1e4DiZamBUJZq6wrNG2iwnixreEuDKlUWie");
        timezone.setCities("KKsb5v4bp3xjineYbidEqmv6SoqNoUkqOgFt3FLekQbTbuK8j6");
        timezone.setCountry("aQrCJM9YHv4LXW9qiMJJaE0FCEDVe0U8CIn8dszC1Rg8ySKhdT");
        Language language = new Language();
        language.setLanguage("46mqp265rejO7xtNmPDyE4I6HAau2rcRWlI7Q4WBLL1yHDlDIp");
        language.setAlpha2("nM");
        language.setLanguageType("EI9E4zCQkADBPnhrRZC4L42ro1YzYrCb");
        language.setAlpha4parentid(2);
        language.setAlpha3("Jy0");
        language.setLanguageIcon("NLY0rfhAjWFAnexlUkgpIyvMmNCUnga4SyAN1AKnampiXuRJ2b");
        language.setAlpha4("Jcro");
        language.setLanguageDescription("nYBPwpMP1xqivVUFNlQ9CRBNrPsu77NAVZNiSgHy7ShrWZy6Rg");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        corecontacts.setNativeFirstName("AiBhneGAx7czvtuFUwlC7MLO76fYINoRdUO3seHa15ptEZqPip");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("CYnFgg9GfIZXFeka824CoI26sPd5rYNOczDGnMq2sMp5vWVQFN");
        corecontacts.setEmailId("VHaA8fHxgBTXWAq8VgN6ramhqRmxlQZgeaNpZphWTmMrUhvPja");
        corecontacts.setMiddleName("dBhTzMoC5GB2N646LZG8wXKR7DWKMcTqjm7MTtDp7IHqMV6EUf");
        corecontacts.setPhoneNumber("MKWkHSZ1PnDa1FfyU42g");
        corecontacts.setAge(49);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("YBXpvzSwuxcyJ1hhf5zufB5fREDVdw9WUYK2pP00rtuBYnsEii");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465376430248l));
        corecontacts.setNativeMiddleName("rSaDBqeRzEo0iQdwynvXsdtO1g4wwJAYM7sMlhvj5mm0dDnQ64");
        corecontacts.setLastName("tU75GL4FQd5d2fxOfWW3sRoGSM25QGnQj0D3oTpE4moEc5WtgQ");
        corecontacts.setNativeLastName("8CaUnOVgUL19K58FAojqt6W1nXsSSSdtxOI4m95hXcj8p7e8eC");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465376430248l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("pkkKCfpPmGN5TibxMz5oJQqPEoUhjp0l");
        country.setCountryCode1("TGy");
        country.setCapitalLongitude(2);
        country.setCurrencyName("zIn0KTIcPbhovHvRiaofbsaTYlEomvR9L4k0nTkrgogWUF2FZX");
        country.setCapital("Ko9wR4evhr6TdVqhZzifShByt4EV9Qxu");
        country.setCountryCode2("YvT");
        country.setIsoNumeric(997);
        country.setCapitalLatitude(7);
        country.setCurrencyCode("je0");
        country.setCountryFlag("Or8nNAlxnzn89z9k8ugu8Et9u3e1tE3VivAJssA2BggxUks5on");
        country.setCountryName("iqYWuMhNZM1Xz4Tb7wurmnhZAA9ZRkXQtt20SI8Q6UTXlgaNba");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("dMzkeEZvEZZCryLirjSglu2Wk4LFqPeUCNKqlFNsuGw69PZiPB");
        addresstype.setAddressTypeIcon("VoiCQKuThgxMUPx2xeYRQzvrvXuQNSzcJqrn5Qy2UVGqiXmAkW");
        addresstype.setAddressTypeDesc("Ce9D5pngTeiuuaKkYvCmUw89VesO4ywhy6ucSUilLDLZlCl9qn");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("StFf3u5qWNT2dRvgBgkiwmaHvuKdncXVl5kVK4W4LCjfmFo7ha");
        city.setCityCode(1);
        city.setCityCodeChar2("BPQNbSpxXRDFTk7AisUm6v1OXmcvdOhv");
        city.setCityLatitude(7);
        State state = new State();
        state.setStateCodeChar3("vEJdaBK6G7kSQXBwN7tZXnw6KQT8EucG");
        state.setStateCodeChar3("zMXUm0NuurRy0YmB4QDjqxSs822lMPbv");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("eoYEhsFKYqUSZI9Uxa4NwBPUJ6AqIQP6fVjmKIrIEMUGjK3eHn");
        state.setStateCapital("quPGpPGgXnWjdfxHumxGdttK100rLAg4P8XpkJwzfuMnJCdKYu");
        state.setStateFlag("HXuGB4kkQOEadNERMoYRCQr08fP0SjjQUmcvLeRepa8OsDa62C");
        state.setStateDescription("TORIb3GuC2WtdBwQYtx3q0ZvfxeSXh0T98Uchv05xZ929jzaP2");
        state.setStateCapitalLatitude(2);
        state.setStateCapitalLongitude(5);
        state.setStateCode(2);
        state.setStateCodeChar2("ssGgiSOYPLxWcR3YbWuM4ziJadfmaIfJ");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("ZqrlsOomKfhiZRjdonnUiqeCy0K2lvNWfW502nsYHcgzWhvoPM");
        city.setCityCode(1);
        city.setCityCodeChar2("2qQJDiI0DaQns0kCyu5TD9KhYPMGhCBs");
        city.setCityLatitude(11);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("jNDzj6UuGdXmjz91lfH9jEOvHwAplFPdddiqjYLgcJrBPkUfyd");
        city.setCityDescription("u937g06FbI1UNtnsZMIDJGw6JFj8rV1oXvbTbWcRAVYif6ykS0");
        city.setCityLongitude(4);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("NASQG0");
        address.setAddress3("hNaWMEitKHAb6MLQ90dPj5gqQfzNLyRdLvlgqKiBDCaAP2L1ci");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("AfMMZRnUwVLpI2yef8qjLHaXQpqqJcAfdp2ROncoXyyE6XlaHX");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("ZzlkVawlz6S");
        address.setLongitude("c8cT3vnmibKLZNkMmxqkt37o7COREa7Zm2EQw2YAV2BUgMEbv5");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("GQWumKfUe4XVCP4DKZXGgkENpMi3zriHPg6XrEgEcL1Uunh4bY");
        address.setAddress1("MEAT53ME2UzkoicEC2HT6zcyVna5xnOtTFrPXSGkUtOcylNnQp");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("g9gnMeQWI0Tpg1zpa0tzoay0O5bI4HAsbC5b5qblFLM1av7Z4M");
        communicationgroup.setCommGroupDescription("fjUXmlb9fgOZBbzTWLRMk8oEsc6V0Ad4r3CzpKOI5xPfjwPH9M");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("CI578n2lFB9mMbK8eATNBHCiD9FL207aUbu16PHnbgVX4c0ve3");
        communicationtype.setCommTypeName("G5FY6D2yFs2lVA5hNJATWH8iDXucHRKDR3TuCxKbf1Kjju2Ax9");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("TdbYTrnmlQ");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(4403);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1465376430785l));
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("QKBeOXRGCijbJPImkD8UF5CBwPiJtF9MjzKU2KG0vCA2CZuXxX");
        useraccessdomain.setDomainHelp("pdTTgWsDQnjDHTCsuVWQgVEcNUJQUpbl33BlexZFuoPLHHjg4p");
        useraccessdomain.setDomainName("TrbqyVIf4vrRKv8WMrAz5ZdxYb1HMGqyn1XD3lT2HfkCC8fOGs");
        useraccessdomain.setDomainIcon("GEApha6qmulrjmq5tXpijCUDi4nDSFPDO4c1wPmDBj2Afr7GIa");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("AvYhErlEtoFTQCzGBHoo97cSCgAVndAJ42rEFzZQvwmCDHoMlp");
        useraccesslevel.setLevelDescription("nyH8In5Sjq2861fDsiiYOFB9V8tt0Q89UvBEg1gmeSKzZRQhrF");
        useraccesslevel.setLevelName("4F9OjlZrzX3rb1MwxyDR2RrJ5AZhJvnLIhK9FHjrXlgikr99P3");
        useraccesslevel.setLevelHelp("wngsGBuQPWwpowXeVzBXKySNGbh1vUent9LoKLaIWxJbgSBuvw");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(30992);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1465376430806l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsLocked(1);
        user.setSessionTimeout(2249);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1465376430869l));
        user.setPasswordAlgo("8iEpWSZUVGcq38i2LrfbtnVNwg30RIBOetnY1dnEHMWREJ4tZZ");
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("HuXpzE0IjJAVSgtirIuApTBdAWEF0vXgrA9euyf0jzKfJtvvwP");
        Question question = new Question();
        question.setLevelid(9);
        question.setQuestionDetails("iiqkiKGpQ6");
        question.setQuestion("B8jtkUDxI7h50F5IKoudhHXs60FCVZpmFfWVIBDGGXDxMWhmWP");
        question.setQuestionIcon("M8epI6kwbyrkufYbdbYZgIhIcWRO29tbD9OaKQKzkwuXkIcsI5");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("KK9RMkwDwURAPKFU3mUOB5ITiOYey8y8xQffeYGohxKp8wViqp");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("XAeq2NF7QypCU4wcC0Z9Ow7qVBPuVUspyopYDdRzE11x6Df9Jp");
        userdata.setPassword("z1Q6D12EuccBrL5ZYhMCjcQVaqF0MsYUhg0nfh8QktpgNpZxKS");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1465376431088l));
        userdata.setLast5Passwords("u2Z0dtkM8IrjBYTr5GVrvuMfdH5zDjJqxUkdxAn2h2f09mzWZv");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePassword("AXffyrmqZR8EYewAU7jI9lKAOXi6RwUw");
        user.setUserData(userdata);
        Login login = new Login();
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthImage("vQVA2B2Mtk1Yd2hamnVO8iYux9SeRb7T");
        login.setLoginId("O2vWyCWAFMkBdhgkBbi3K4kjlm8eO7jOwUSolMKfqIbtyU8Yej");
        login.setServerAuthText("ZhKuy8B60XQS1ba0");
        user.setUserId(null);
        login.setUser(user);
        login.setFailedLoginAttempts(8);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("TzlfLxqURqPI8XuUyi5bBG1GA42G2v26");
            login.setLoginId("GnJHQXMVqHQb1K0wwWJq238ikyYRlatAVrqwDg1xOwofyqDmSR");
            login.setVersionId(1);
            login.setServerAuthText("fOZgQvES5G1TPSVv");
            login.setFailedLoginAttempts(3);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "maf43aneYC06fKjn3xuIn7nCz9gHIugO89RHxKwkFOyoD794CAOMJd15jyXt59wcjmx2T7L6G4dvPDUokI6xwOAlWoxuoZt2h2MmkTWr4DzTjeGqgPTDSfw6lAGXnu7Uh7Nmi7F3e70VJm2svN7BMlFQ7OT7hrJA4nT7mc7ag2RL16B5xJylcbokZXBjOn4z3PAqbrqoC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "LVuknUJnoEQSX7s7C2oEk5XniewRhg9wJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "HCGZH14oXgKPjPQt1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
