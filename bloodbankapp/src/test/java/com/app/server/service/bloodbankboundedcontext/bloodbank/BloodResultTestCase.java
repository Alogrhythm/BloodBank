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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodResultRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult;
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
import com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonorVisitRepository;
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
public class BloodResultTestCase extends EntityTestCriteria {

    @Autowired
    private BloodResultRepository<BloodResult> bloodresultRepository;

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

    private BloodResult createBloodResult(Boolean isSave) throws Exception {
        DonorVisit donorvisit = new DonorVisit();
        DonationType donationtype = new DonationType();
        donationtype.setDonationTypes("t831Vee67HwAszrRINLKVbZpJxQwtVsm6ckXH2Y2nhZ2czXTjR");
        DonationType DonationTypeTest = new DonationType();
        if (isSave) {
            DonationTypeTest = donationtypeRepository.save(donationtype);
            map.put("DonationTypePrimaryKey", donationtype._getPrimarykey());
        }
        RegisterACamp registeracamp = new RegisterACamp();
        registeracamp.setReasonForCamp("GVPxg1mogHlr8t9itVnLunvJwX6xqq03kDjLyRCXuUMQ8gjlFJ");
        registeracamp.setNoOfDonorsArrived(2147483647);
        registeracamp.setBloodBankName("UYqCNmnm0hLrcGJFYb4SHqTiG8Shf3TyQw7CcH8n3Z58QZvQxK");
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("Pgm0MigYTHMb9MpXAzne2Pd2qEsxMhjY");
        country.setCountryCode1("iI2");
        country.setCapitalLongitude(2);
        country.setCurrencyName("bfM1K8z8LyuIMcp8GKjukm5hbUhJcYYtCtbd2sHCR1btN0caGD");
        country.setCapital("NlcjVRrSSq971VYSPq8u4V6GLXNbwB0O");
        country.setCountryCode2("oSi");
        country.setIsoNumeric(592);
        country.setCapitalLatitude(2);
        country.setCurrencyCode("MNt");
        country.setCountryFlag("THtiorSXKhils0OXYVhmkZT5HZFuFXTNXUlaRvtNobF8JwzOL5");
        country.setCountryName("lVKojqEZTcB4Rw9lFDTJpkpCcUiDbUGLslqcUEJrfwlkhqRBoo");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("HxpJX6DFYkTLYJnGGW3E0IFDKxAFQMHiYFInZx1ADjOMibxPNp");
        addresstype.setAddressTypeIcon("88WXeeadpkkflV1D8LQEu93KTYQstnukUaBBHMO2J2vDfvgtyZ");
        addresstype.setAddressTypeDesc("c2Qq2b3aQHFM2u3N0DYHwW3Hg32KTUkQyfSsBe1txG2Ok5KXPM");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("TFOOLAgYIQBqjgsVDcP04cuSHdBykLbUdfppQ9t3mKqrKfK5Ca");
        city.setCityCode(3);
        city.setCityCodeChar2("eZuDN8mkBUJGPUhvKcUtx88aLHHrT9FK");
        city.setCityLatitude(9);
        State state = new State();
        state.setStateCodeChar3("WhIYDHabnPNIzxCWf9dcVkPWb1xfoY0r");
        state.setStateCodeChar3("v5eP4J3Z3NYVRarRd4j1fp9W0k2V1xzd");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("OuR5fBKGpIbnaDrpGbOvY1KZO9XRz7p8cqn2ox3VTIZSbeT802");
        state.setStateCapital("gGMlEsW3RLee3wHuXABJgCTIS3403PVezNcUhtRZB8K5F3RXX3");
        state.setStateFlag("8yL0o1TyJo8az908qD2iJpmQhV6eBpsM7B0OCE5l8JWOC3CKsa");
        state.setStateDescription("0KbWzPrianajF7LvHGSwDCEfgOpf2QnrPJzXrakMgpzUtYw5q0");
        state.setStateCapitalLatitude(2);
        state.setStateCapitalLongitude(10);
        state.setStateCode(1);
        state.setStateCodeChar2("FFa5u48INIsyZ2KS7IYSefWdcApZ9a2b");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("v5P9k2jjOuhqYpRnx0OY4QLWIObcQnR12Y9ri2FpoooAVDLLES");
        city.setCityCode(2);
        city.setCityCodeChar2("IFiSJwlFVMGGVepTSuHIpWoovuXJCexY");
        city.setCityLatitude(6);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("TrtiK637kpbqvIOsfQb7x7diBykaILJtnMPGGypMGb5TSSZtR0");
        city.setCityDescription("IGKdz5H59SZ6yLuIHjBv8S8YvrUViWx6fbno4kUFxXnDXCka8f");
        city.setCityLongitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("gf8W4H");
        address.setAddress3("yEH9WYWMUilpYM84iOPZnrHrTeyu0zX761EW48Jo61WIaumITs");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("et3CRkfuSGz9QHT0OdiuHjuubglxStMzqjQme7VUagcV5KRWTG");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("1Cc4fqFORV7");
        address.setLongitude("kVxLiCmMMNXhf0HTCdBdoGr5Quo8mvKQIFQGb0mZI1G4eZnWMM");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("rD4Yinvf0hNH0hLj8KP7nfvoylQnJcm8PkknvcdOwd1sZrYAgO");
        address.setAddress1("81SoARG4ZdA5ARdJ6fGegIi3yogMA8sn84BIPADayqNUOl48ie");
        Address AddressTest = new Address();
        if (isSave) {
            AddressTest = addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        }
        registeracamp.setReasonForCamp("X2l4Q5u2ecuyLgUXKIiS3Pp6f6FhhK86rk7p6FvsA2ljZ67SOX");
        registeracamp.setNoOfDonorsArrived(2147483647);
        registeracamp.setBloodBankName("w9BQ7ZMHLLbIHQC0xrJoN3KO2DPwcwv25HbWuks61Cbebz83tF");
        registeracamp.setAddr((java.lang.String) AddressTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeracamp.setNoOfDonorsThatBled(2147483647);
        registeracamp.setNoOfDonorsExpected(2147483647);
        registeracamp.setToDate(new java.sql.Timestamp(1465382024121l));
        registeracamp.setOrganisationName("il8AXCVV0xVOq0rIs9raEZRh168VRWuYcDRgwdkNrwApvaJnPt");
        registeracamp.setFromDate(new java.sql.Timestamp(1465382024121l));
        registeracamp.setCampTime("lGbmYYyV5EfnSTMkIH2Zdpta6b6gtCxnYAdZeNA9NWtILHgJJV");
        RegisterACamp RegisterACampTest = new RegisterACamp();
        if (isSave) {
            RegisterACampTest = registeracampRepository.save(registeracamp);
            map.put("RegisterACampPrimaryKey", registeracamp._getPrimarykey());
        }
        RegisterADonor registeradonor = new RegisterADonor();
        registeradonor.setDob(new java.sql.Timestamp(1465382024152l));
        BloodGroup bloodgroup = new BloodGroup();
        bloodgroup.setBloodGroups("JDnCKZ6LaXqXuPbyHPgy53pAhf7MKIzsUS6eYE8hzZe0omwvTB");
        BloodGroup BloodGroupTest = new BloodGroup();
        if (isSave) {
            BloodGroupTest = bloodgroupRepository.save(bloodgroup);
            map.put("BloodGroupPrimaryKey", bloodgroup._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("qsyqRqt6sMy6NnDt96uL4bM16XBsVxs9OkKKubP90Nc0a3fRwE");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        registeradonor.setDob(new java.sql.Timestamp(1465382024156l));
        registeradonor.setBg((java.lang.String) BloodGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setPhoneNo("aDiEEdn22FMkNSCpJTsTNtCX4OoYmeuYPAvUHDQ4wIrp8jLQKK");
        registeradonor.setDonorName("KEfRCL998qclZxlZ8ojDZZt5J8TBSAVQeB07xiFVAIPFaxE1c7");
        registeradonor.setHowOftenUDonated(2147483647);
        registeradonor.setEmailId("IzrfUFKRCJmFq9deQz8eBlFjQQ0986nvh7xMvf7RkIDkmX3mko");
        registeradonor.setAddr((java.lang.String) AddressTest._getPrimarykey()); /* ******Adding refrenced table data */
        registeradonor.setLastDonationDate(new java.sql.Timestamp(1465382024197l));
        registeradonor.setGendr((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        RegisterADonor RegisterADonorTest = new RegisterADonor();
        if (isSave) {
            RegisterADonorTest = registeradonorRepository.save(registeradonor);
            map.put("RegisterADonorPrimaryKey", registeradonor._getPrimarykey());
        }
        donorvisit.setdType((java.lang.String) DonationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        donorvisit.setCamp((java.lang.String) RegisterACampTest._getPrimarykey()); /* ******Adding refrenced table data */
        donorvisit.setDonor((java.lang.String) RegisterADonorTest._getPrimarykey()); /* ******Adding refrenced table data */
        donorvisit.setOrgnizerName("BXY98ksxyNbUjEqL177kKwJBwmtPwJ7sgRLNTTRVnD9c7PhBXu");
        ClinicalInfo clinicalinfo = new ClinicalInfo();
        clinicalinfo.setTemprature("oxcmmT6C3Wc8qKvONd9TUiGEPZwISnQehA3qwjWiooa11HOZWz");
        clinicalinfo.setUnitsOfBlood(2147483647);
        clinicalinfo.setPulse("jag6Q8p9NX16jF4JX3xiJ0ToHApCKy4XzBQjpOYKUIOdcDualj");
        clinicalinfo.setBp("HIfWd4G3Ykn7gHDDmIZnBGeKqTfH2rR1x2KnNcQqWJv3ykqQ06");
        clinicalinfo.setHeight("8RuTbmZHIHxgM3Nk8fok7LDQJvNtuT0bCMPLKcpkC3LWF2rv1C");
        clinicalinfo.setTemprature("FYYKtcpxlKW2hnDsCmCgO9t2TOUlLFTg9eYGsoapUIkGtzvO1E");
        clinicalinfo.setUnitsOfBlood(2147483647);
        clinicalinfo.setPulse("RYgfkXG4UYJ0vEQpsPcSwtvz7fSiTxHpcg7QogGL9GnJXVAdpa");
        clinicalinfo.setBp("RwFGa8Mtxt35o18uEPo7Frcb1PTzVDOkBrHzjNDcHyRmd9UlkG");
        clinicalinfo.setHeight("jYbMXxrxFHFnon4gFEO7ND3aNNuVz9ps1scGMCr27HdTNyoutH");
        clinicalinfo.setDonorVisit(donorvisit);
        clinicalinfo.setWeight("GC9wy5xk7WADsZ5yVUCwPNW7Yu2OC80bZugbkcgTBM1CrQLWvw");
        donorvisit.setClinicalInfo(clinicalinfo);
        DonorVisit DonorVisitTest = new DonorVisit();
        if (isSave) {
            DonorVisitTest = donorvisitRepository.save(donorvisit);
            map.put("DonorVisitPrimaryKey", donorvisit._getPrimarykey());
        }
        BloodResult bloodresult = new BloodResult();
        bloodresult.setDonor("lAFrfxQNb3IOTdzEC1wwIts7lEU3Ans4E4fXFSb1IDdN1XKvtw");
        bloodresult.setDonorVisitId((java.lang.String) DonorVisitTest._getPrimarykey());
        bloodresult.setIsTested(true);
        bloodresult.setCollectedDate(new java.sql.Timestamp(1465382024331l));
        bloodresult.setExpiryDate(new java.sql.Timestamp(1465382024331l));
        bloodresult.setNoOfUnits(2147483647);
        bloodresult.setEntityValidator(entityValidator);
        return bloodresult;
    }

    @Test
    public void test1Save() {
        try {
            BloodResult bloodresult = createBloodResult(true);
            bloodresult.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            bloodresult.isValid();
            bloodresultRepository.save(bloodresult);
            map.put("BloodResultPrimaryKey", bloodresult._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DonorVisitRepository<DonorVisit> donorvisitRepository;

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
            org.junit.Assert.assertNotNull(map.get("BloodResultPrimaryKey"));
            BloodResult bloodresult = bloodresultRepository.findById((java.lang.String) map.get("BloodResultPrimaryKey"));
            bloodresult.setDonor("j93DwuEowNKIo0zzfoHxc53avezHt4e1Tq9WPSHyxdWa7Sf5We");
            bloodresult.setCollectedDate(new java.sql.Timestamp(1465382024346l));
            bloodresult.setVersionId(1);
            bloodresult.setExpiryDate(new java.sql.Timestamp(1465382024347l));
            bloodresult.setNoOfUnits(2147483647);
            bloodresult.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            bloodresultRepository.update(bloodresult);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodResultPrimaryKey"));
            bloodresultRepository.findById((java.lang.String) map.get("BloodResultPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydonorVisitId() {
        try {
            java.util.List<BloodResult> listofdonorVisitId = bloodresultRepository.findByDonorVisitId((java.lang.String) map.get("DonorVisitPrimaryKey"));
            if (listofdonorVisitId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("BloodResultPrimaryKey"));
            bloodresultRepository.delete((java.lang.String) map.get("BloodResultPrimaryKey")); /* Deleting refrenced data */
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

    private void validateBloodResult(EntityTestCriteria contraints, BloodResult bloodresult) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            bloodresult.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            bloodresult.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            bloodresult.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            bloodresultRepository.save(bloodresult);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "collectedDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "expiryDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "isTested", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "isTested", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "noOfUnits", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "donor", "4txZ0AtilYPLptjAxcdk3b2fDHAG7eU6CdJlXgwWrmms5m0wXGiLWFWWKSDpKqplOScvz2xjwACX92o4IJWRNQa6D0unenjDZZFUpw8WPnPmb0feeYY8oI1rnbBivX06h1suK8CCFm5dByLErHi4NRskniI3RkyFt31GFYMeb2sBxtjB4zKSRRwoEpF78gyx0Omb0wpEZCpHAtMc6t0MymDzBW6cZRoFMv1nFU0MjwXJquAOdU2MiMMYcmuk82954"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                BloodResult bloodresult = createBloodResult(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = bloodresult.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(bloodresult, null);
                        validateBloodResult(contraints, bloodresult);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(bloodresult, null);
                        validateBloodResult(contraints, bloodresult);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(bloodresult, null);
                        validateBloodResult(contraints, bloodresult);
                        failureCount++;
                        break;
                    case 4:
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(bloodresult, null);
                        validateBloodResult(contraints, bloodresult);
                        failureCount++;
                        break;
                    case 6:
                        bloodresult.setDonor(contraints.getNegativeValue().toString());
                        validateBloodResult(contraints, bloodresult);
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
