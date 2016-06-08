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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonorVisitRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit;
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
import com.app.shared.bloodbankboundedcontext.bloodbank.DonationType;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonationTypeRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterACampRepository;
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
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterADonorRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodGroup;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodGroupRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.ClinicalInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DonorVisitTestCase extends EntityTestCriteria {

    @Autowired
    private DonorVisitRepository<DonorVisit> donorvisitRepository;

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

    private DonorVisit createDonorVisit(Boolean isSave) throws Exception {
        DonationType donationtype = new DonationType();
        donationtype.setDonationTypes("4Na9X4MKsS53RZN2aegbUQYgp9HQoTmVT4U7NnsHYq6fl1D9dz");
        DonationType DonationTypeTest = new DonationType();
        if (isSave) {
            DonationTypeTest = donationtypeRepository.save(donationtype);
            map.put("DonationTypePrimaryKey", donationtype._getPrimarykey());
        }
        RegisterACamp registeracamp = new RegisterACamp();
        registeracamp.setReasonForCamp("ZYYkN2nmsHqabdlWoHncwJhIewQDBr744mLkPL4BQu9pp8oSBF");
        registeracamp.setNoOfDonorsArrived(2147483647);
        registeracamp.setBloodBankName("wAVvdborehsa5abgnrJ2NE5bCRqhuYLQqsNwnWY84wnNQsIce2");
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("WT9iyfJssbDg6Ey79fdYeiYLL4Ic0P1q");
        country.setCountryCode1("zXc");
        country.setCapitalLongitude(9);
        country.setCurrencyName("w6qPNHYs8UiD318s80HkzqL701AV2HLyfQ0hDAUCI3kz3yFwYI");
        country.setCapital("Vj9Sk3SYj4pwdtnHunHbJ2Bt6o1Szemg");
        country.setCountryCode2("Bes");
        country.setIsoNumeric(70);
        country.setCapitalLatitude(5);
        country.setCurrencyCode("gIH");
        country.setCountryFlag("aVEr0wiG8YYoeNFESQpNWRUyebonkncSFlBWyjRwQUq1uuxYLm");
        country.setCountryName("CyjZXaKHsZiP0AS9Mm6JMcrKpefv48RQ3eDthLILLxr9j9viQ3");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("AckBqtZupn5KmMTqEMKAUssuixRflUTlcMbt0u7UDlJDWETBiC");
        addresstype.setAddressTypeIcon("C3Y07kf3UWvJA8jM7yTdGjCNrQwybilmAqXKFcLyuxDyPIc9Cg");
        addresstype.setAddressTypeDesc("kbCNMK4OI64x6iajBqwGAKL9sUFEUVMkfg9l4qKda9OPu0eGmH");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("ml6cnks0AxXXToEaxq9xvRvOJCGiQ0nBf6wm1KECSRQ1lUGbz8");
        city.setCityCode(1);
        city.setCityCodeChar2("tsVN62WTJ8QtCiMxbqvLEGlUk1SAldoq");
        city.setCityLatitude(7);
        State state = new State();
        state.setStateCodeChar3("TqRdGI1QEEfdQId1DUtxMVqNmalVoNZu");
        state.setStateCodeChar3("VYSLAgt5napd3gZ2cMkiWT9V2YEb75iv");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("iUyeupznlqybMve9JZ6oUU9SiOIwaSN0EqjuzITacByQe5lq9w");
        state.setStateCapital("zhv4r1Gjis8iKhgE5ldyCZveTnTKS5y3bGb9KFHTfaB5XiCzd5");
        state.setStateFlag("NxFPiSn4VMPof53uQ7y36jf3ntRSGMwz1A4CssiK2FXQV5s7PR");
        state.setStateDescription("X5nEaDtuwDF7MYgsYSeB7UuE7wOge6tHONvTetf3p2VM5pMXXJ");
        state.setStateCapitalLatitude(5);
        state.setStateCapitalLongitude(2);
        state.setStateCode(2);
        state.setStateCodeChar2("G1BFwnXM55MeoLX59zSaAU2ztFMKgHRH");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("2OaOFR5SQvYY7ckIn7ZRafsadva13oiUn0qCuSG5jAx5oa0l5N");
        city.setCityCode(1);
        city.setCityCodeChar2("bXadH95mxE8tk2MUtSyOOGE0nxoLVmfm");
        city.setCityLatitude(2);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("a1UVVU5bSrf4rHjKtpyqH17W6Bg7AW5tMmAQyRQehbDmwuQmLn");
        city.setCityDescription("ruVyjxY1Z9UYqvY2C38ECEcboJeyynP4KnNJR8UTwCRG0qYLFh");
        city.setCityLongitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("B1nwvV");
        address.setAddress3("eWQb34MIPso7SnYAwv6d5mHtqMuDLWFh0sbF5NH7GmQb6MrGO4");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("X3fJV8oWFAmoap7ktDMR9jEuA7Git4wYhjjD9WaXVnRVY8o2Jy");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("eq4rxUTUSwM");
        address.setLongitude("wtXZSg3LAHjCIsU5A4igPAd0BWXDxhFRzqVmVDUzM1AzJ4oupD");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("xjghR4oZMEXjYhknDYEHyAOMQTVasHs2xEAryNd2zVJ3W80UV0");
        address.setAddress1("rz5GMUNh0E7SLZXMMmugHlFRLeNFDOYIBC3zKfYsCKDOgtUudN");
        Address AddressTest = new Address();
        if (isSave) {
            AddressTest = addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        }
        registeracamp.setReasonForCamp("MLBekagmlgu1yZD23GcGmnyWgl7qjphXDwUmLo4Jz7FhoQgWAn");
        registeracamp.setNoOfDonorsArrived(2147483647);
        registeracamp.setBloodBankName("xiGds8bACISMxeaFhFU1bpnC4DZlFSt11wyabyjqAJH0rbKBHI");
        registeracamp.setAddr((java.lang.String) AddressTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeracamp.setNoOfDonorsThatBled(2147483647);
        registeracamp.setNoOfDonorsExpected(2147483647);
        registeracamp.setToDate(new java.sql.Timestamp(1465376439445l));
        registeracamp.setOrganisationName("htBu4cC7IunabnctbyciX8DTZUzzqU1CtMz5QM7QX0hknWSmHs");
        registeracamp.setFromDate(new java.sql.Timestamp(1465376439446l));
        registeracamp.setCampTime("jkdL5SsO2ncaTZ38IkVusp4Tb1zdUvkvrZewEeXC6WeFgBLzrP");
        RegisterACamp RegisterACampTest = new RegisterACamp();
        if (isSave) {
            RegisterACampTest = registeracampRepository.save(registeracamp);
            map.put("RegisterACampPrimaryKey", registeracamp._getPrimarykey());
        }
        RegisterADonor registeradonor = new RegisterADonor();
        registeradonor.setDob(new java.sql.Timestamp(1465376439484l));
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("ezKvLnpJiqzr7N3i5AeRJaMWuaeJhN83FzwnP5JgAs6UtDBGxA");
        BloodGroup BloodGroupTest = new BloodGroup();
        if (isSave) {
            BloodGroupTest = bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("DqfwKLtRygVlYYHsnw4uixJBCFNZA0kcWmfqgJgg9xd5z02iqL");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        registeradonor.setDob(new java.sql.Timestamp(1465376439493l));
        registeradonor.setBg((java.lang.String) BloodGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setPhoneNo("9MWbQX69WCazJGbBQy0VcZ62MRtqBdaYOBjEK9T5T5aYefZXlv");
        registeradonor.setDonorName("L28czmjf1vSil2MZ4TKnrrfZ86FCOCY0XFtC5Ir2w9RBc4xqlU");
        registeradonor.setHowOftenUDonated(2147483647);
        registeradonor.setEmailId("g7G95ZOP5SCj39voqHi7jHYZ5GTeWLQAzgf96TIukreazz09nL");
        registeradonor.setAddr((java.lang.String) AddressTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setLastDonationDate(new java.sql.Timestamp(1465376439544l));
        registeradonor.setGendr((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        RegisterADonor RegisterADonorTest = new RegisterADonor();
        if (isSave) {
            RegisterADonorTest = registeradonorRepository.save(registeradonor);
            map.put("RegisterADonorPrimaryKey", registeradonor._getPrimarykey());
        }
        DonorVisit donorvisit = new DonorVisit();
        donorvisit.setdType((java.lang.String) DonationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        donorvisit.setCamp((java.lang.String) RegisterACampTest._getPrimarykey()); /* ******Adding refrenced table data */
        donorvisit.setDonor((java.lang.String) RegisterADonorTest._getPrimarykey());
        donorvisit.setOrgnizerName("8uVGWgeHOg80m8GllIrxtqxfdg72zEsxDaz0nbNXde6AP8GpQx");
        ClinicalInfo clinicalinfo = new ClinicalInfo();
        clinicalinfo.setTemprature("05VLotKnSoM9pekANy9LapWuqQfYn5PU3BlrPOGHqbMDssrNII");
        clinicalinfo.setUnitsOfBlood(2147483647);
        clinicalinfo.setPulse("oxT8xmB6HZFejmC7XiVGYjsa3Eo4NXZC0INy9KVCzRXFOwfg3B");
        clinicalinfo.setBp("JLnsIpFQ3K7lkVVabSV9t9fEcUlwyeX4OyRH9YuElR11MJ3TYT");
        clinicalinfo.setHeight("AJwmfrHVH1ELUlSelNGSgEDAc6hnjjVd7aY56If7EZPwVOuSIu");
        clinicalinfo.setTemprature("WUoxffNbzoCLPE893Dxa0t997Kl1VeTV6e9OShKpgNowYrR5W2");
        clinicalinfo.setUnitsOfBlood(2147483647);
        clinicalinfo.setPulse("fYVtPdaTEfZa6ioAdbBHSbktfCLTtJTAIy3FCSRXGu3jvKHkuz");
        clinicalinfo.setBp("WXg4DTXAdeAAUWxRBqjSASNHpc1xJBGdA7IJigicZRQNbE5wsj");
        clinicalinfo.setHeight("vGgD0cGT8w42pT0O5C9ZdYcdfnA5uzfCOcWbNouMGmLp09rZym");
        clinicalinfo.setDonorVisit(donorvisit);
        clinicalinfo.setWeight("YFeN8A2gtXuMcAXB9iubS5dSn0B56IK1weLPeQcL3y6ROAL4yy");
        donorvisit.setClinicalInfo(clinicalinfo);
        donorvisit.setEntityValidator(entityValidator);
        return donorvisit;
    }

    @Test
    public void test1Save() {
        try {
            DonorVisit donorvisit = createDonorVisit(true);
            donorvisit.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            donorvisit.isValid();
            donorvisitRepository.save(donorvisit);
            map.put("DonorVisitPrimaryKey", donorvisit._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DonationTypeRepository<DonationType> donationtypeRepository;

    @Autowired
    private RegisterACampRepository<RegisterACamp> registeracampRepository;

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
    private RegisterADonorRepository<RegisterADonor> registeradonorRepository;

    @Autowired
    private BloodGroupRepository<BloodGroup> bloodgroupRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonorVisitPrimaryKey"));
            DonorVisit donorvisit = donorvisitRepository.findById((java.lang.String) map.get("DonorVisitPrimaryKey"));
            donorvisit.setOrgnizerName("CvXkIZ0dvB5ep6YV3HvSucCddUQ2HA7iZGBv4GxjwTLzl0a4AH");
            donorvisit.setVersionId(1);
            donorvisit.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            donorvisitRepository.update(donorvisit);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydType() {
        try {
            java.util.List<DonorVisit> listofdType = donorvisitRepository.findByDType((java.lang.String) map.get("DonationTypePrimaryKey"));
            if (listofdType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycamp() {
        try {
            java.util.List<DonorVisit> listofcamp = donorvisitRepository.findByCamp((java.lang.String) map.get("RegisterACampPrimaryKey"));
            if (listofcamp.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydonor() {
        try {
            java.util.List<DonorVisit> listofdonor = donorvisitRepository.findByDonor((java.lang.String) map.get("RegisterADonorPrimaryKey"));
            if (listofdonor.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonorVisitPrimaryKey"));
            donorvisitRepository.findById((java.lang.String) map.get("DonorVisitPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("DonorVisitPrimaryKey"));
            donorvisitRepository.delete((java.lang.String) map.get("DonorVisitPrimaryKey")); /* Deleting refrenced data */
            registeradonorRepository.delete((java.lang.String) map.get("RegisterADonorPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            bloodgroupRepository.delete((java.lang.String) map.get("BloodGroupPrimaryKey")); /* Deleting refrenced data */
            registeracampRepository.delete((java.lang.String) map.get("RegisterACampPrimaryKey")); /* Deleting refrenced data */
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            donationtypeRepository.delete((java.lang.String) map.get("DonationTypePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDonorVisit(EntityTestCriteria contraints, DonorVisit donorvisit) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            donorvisit.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            donorvisit.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            donorvisit.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            donorvisitRepository.save(donorvisit);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "orgnizerName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "orgnizerName", "AvGqfzDw1qZCLRXY7b02uXwfgd9kxjDd4Lb9jUWycZd7cafjOVKOrL8YsSBmLN2DnfUglosG9OLiguBP1ZZ3RycHOqf7jjlboW3BlmZhJ5ySCmF2zVgQQEUaj3Pm5TdkjWXC5OZGsb6IIKomIU3MMjekjhnY6Bp66FjoBf0BAXD8L30JNDLHDqWdVYhQn82O7cjt9ft5ldKj4PdJJldf77NIMorJo45k6O2FjKSCdPElNKfdf65dmPc1HQvI9WNC4"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                DonorVisit donorvisit = createDonorVisit(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = donorvisit.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(donorvisit, null);
                        validateDonorVisit(contraints, donorvisit);
                        failureCount++;
                        break;
                    case 2:
                        donorvisit.setOrgnizerName(contraints.getNegativeValue().toString());
                        validateDonorVisit(contraints, donorvisit);
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
