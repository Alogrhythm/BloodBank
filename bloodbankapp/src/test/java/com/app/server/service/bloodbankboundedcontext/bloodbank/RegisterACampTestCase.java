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
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterACampRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RegisterACampTestCase extends EntityTestCriteria {

    @Autowired
    private RegisterACampRepository<RegisterACamp> registeracampRepository;

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

    private RegisterACamp createRegisterACamp(Boolean isSave) throws Exception {
        Address address = new Address();
        Country country = new Country();
        country.setCurrencySymbol("EFsPyT01CjwcnvSKOSGvjL70bimiNvyv");
        country.setCountryCode1("5hy");
        country.setCapitalLongitude(5);
        country.setCurrencyName("uoxI0Yj7stuj83WvSrpnXcKU310Cummrkyufb0MjTLFjQGV1Mi");
        country.setCapital("yfdlkIvbqaHazIvHgqSRxuMFNXBvg5l1");
        country.setCountryCode2("6to");
        country.setIsoNumeric(848);
        country.setCapitalLatitude(7);
        country.setCurrencyCode("iPK");
        country.setCountryFlag("XmlLxUvwgvp9XnPngL2tB77ErumNqtNvgyV9qjiFoSAK6VMBFn");
        country.setCountryName("idNVixNs0bo5yGDZsGfE6GaKNcxspWaLQnFC3oemQfBmFoBe7X");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("lz4KuqdVe1dwV5CcnGtVyer9UJ2GUmzi5ZjH9x2mEkIQIF57GL");
        addresstype.setAddressTypeIcon("eDFn2TNJ8DgrKA9ChEDUQfCBKXPh3Qqnp2tixMsmfUEUMsFeOl");
        addresstype.setAddressTypeDesc("GtPhsEJ4iNeXtbWjRkmW9N1uhzVvsgcoX1kpCOh45X2rfaP0Hh");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("up0UbgSiSkQlkzTMXyKX51c2KIDpVXJNPChEKnoprVNSnBoQxD");
        city.setCityCode(2);
        city.setCityCodeChar2("Mn4XWCCqhEwZXhQtW6lJFQLOQqUgi6rg");
        city.setCityLatitude(1);
        State state = new State();
        state.setStateCodeChar3("hIWjSS8prCSvS6uzccJxXV0s95KQzZ6T");
        state.setStateCodeChar3("CUaEVEi3IewD0N4r9UtTp4ag7Nry4QZH");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("QSkkhOzfGylYzA05AUmrlwRTl1g5SaxFeXKKvb9gyZLzbvlhQQ");
        state.setStateCapital("BIEtYlwUEgXOA6KGMEuufNG3vIaZXPefhJ08Fv5Ono9bqyrJVi");
        state.setStateFlag("QGYi5JV5L6cHxLQvCOWbJdb2wgpDqpXrIx8y53rsuDltQcAGLp");
        state.setStateDescription("NTmnlyCYpIu2ad6ak2tqwumgn3P2QGLyoEdiPgfynEl5p4qkiq");
        state.setStateCapitalLatitude(2);
        state.setStateCapitalLongitude(5);
        state.setStateCode(1);
        state.setStateCodeChar2("IgEWXfK5zzQIBdDpoJN8ROZCFmjbwLWb");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("7rVGmwqGOkxX7YHZhV4q6k2eGfN3P2mkG3c6MmbZK5pbVDvVwH");
        city.setCityCode(3);
        city.setCityCodeChar2("vRUfwhrlFh5ebCtJ0gYntoTxMzU9ca6G");
        city.setCityLatitude(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("9yhfWPCs4KSYaSwm8gUs8ZYZZiCSYguEB3bxLIf8x9pUcrfguX");
        city.setCityDescription("1N4CFF60wR49QaVDuM1FBbEVu1bSo8TU4ibpyFh8eZmY2Y8CM0");
        city.setCityLongitude(9);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("CF0Icl");
        address.setAddress3("6nl1RT1FMVA1zOf2LyvhbEhhjUahXFz5pTmfYxTW6aVZ747fmz");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("oJ2UIHo4oJk1KmGC7XUGpWVcWYIQcEPsjsdEEHjuLo0CZfYgyF");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("YCcc0LdcXcg");
        address.setLongitude("ft7t7bjgs5Iiw6NhK53WUaFDYrgSWE1ZuNnBU7dXuO6awiAYOR");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("qK9phTH6dGMUyu5UCQ71svIwQbH4GanIHOoagosRqHPPg8YTV6");
        address.setAddress1("EwB4DS7gQElHyCY7bdxwQ3easUabcVP0iExyJjTF04IhywnPSt");
        Address AddressTest = new Address();
        if (isSave) {
            AddressTest = addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        }
        RegisterACamp registeracamp = new RegisterACamp();
        registeracamp.setReasonForCamp("G4w9ShKiYnbGu8PWY0GlVUkMf5ehv3KM4b9H9TA54vK5CQnBUg");
        registeracamp.setNoOfDonorsArrived(2147483647);
        registeracamp.setBloodBankName("5vqdT2DnGbRbtUsHSqU5T18vtupOrS9B76KRmwTb2UELC6U78O");
        registeracamp.setAddr((java.lang.String) AddressTest._getPrimarykey());
        registeracamp.setNoOfDonorsThatBled(2147483647);
        registeracamp.setNoOfDonorsExpected(2147483647);
        registeracamp.setToDate(new java.sql.Timestamp(1465376435840l));
        registeracamp.setOrganisationName("25aDrfwwRNhTvJh49NNeaAaBOD6cyKJoklrI5kn3RrP4pxJkXd");
        registeracamp.setFromDate(new java.sql.Timestamp(1465376435840l));
        registeracamp.setCampTime("U1ckIliz8iL74nkw9JjpZ6HS4hsWLzsc41m1kLlAvMJNWSiB9h");
        registeracamp.setEntityValidator(entityValidator);
        return registeracamp;
    }

    @Test
    public void test1Save() {
        try {
            RegisterACamp registeracamp = createRegisterACamp(true);
            registeracamp.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            registeracamp.isValid();
            registeracampRepository.save(registeracamp);
            map.put("RegisterACampPrimaryKey", registeracamp._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterACampPrimaryKey"));
            RegisterACamp registeracamp = registeracampRepository.findById((java.lang.String) map.get("RegisterACampPrimaryKey"));
            registeracamp.setReasonForCamp("hw8tw0Nzch7cBqmXaw8jNZPdsUinlEHjKqkqnK9dI2vr3QJgLj");
            registeracamp.setVersionId(1);
            registeracamp.setNoOfDonorsArrived(2147483647);
            registeracamp.setBloodBankName("ZOv8FTMIR6myuHZmoI9NdsDGAYv8zs0IE6y2gsusDxkUnx83wj");
            registeracamp.setNoOfDonorsThatBled(2147483647);
            registeracamp.setNoOfDonorsExpected(2147483647);
            registeracamp.setToDate(new java.sql.Timestamp(1465376435860l));
            registeracamp.setOrganisationName("8dVppFodVb3amusYxR2DEnCycWM2dT08J8SrfxXUMHwmQmfdFw");
            registeracamp.setFromDate(new java.sql.Timestamp(1465376435861l));
            registeracamp.setCampTime("d59LiPBH8EFXj39f3A4ZCnFtU1YijfwX9H1wqkcKOR6jJ4hZG9");
            registeracamp.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            registeracampRepository.update(registeracamp);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddr() {
        try {
            java.util.List<RegisterACamp> listofaddr = registeracampRepository.findByAddr((java.lang.String) map.get("AddressPrimaryKey"));
            if (listofaddr.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterACampPrimaryKey"));
            registeracampRepository.findById((java.lang.String) map.get("RegisterACampPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegisterACampPrimaryKey"));
            registeracampRepository.delete((java.lang.String) map.get("RegisterACampPrimaryKey")); /* Deleting refrenced data */
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRegisterACamp(EntityTestCriteria contraints, RegisterACamp registeracamp) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            registeracamp.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            registeracamp.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            registeracamp.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            registeracampRepository.save(registeracamp);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "organisationName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "organisationName", "QIv6jKYIrCEwbZISS7T5vtfmu5HrmmxAPQu0lC5g3zQaBrHPwMAL3UZplUZkYRpIkDIsToIOkbon5zLZ6PzZxqVfxvBfgpGn0g1IgoWk7xWncqBzYZwxPsa90GDiXisGXbtBlFxji3uyJ8FA5R9cSEYadLFDI6OC29LJT59Re13BeLC0Vl7c00syEP792WxGtsZljhVr6gfDuWB8qb4Otjjpn0zOoPJz9OLrXCQeQ0344QzQzT0cxeTsiy61DJN8Q"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "reasonForCamp", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "reasonForCamp", "4BU80NPGm1R5oS1A6aNkHZy5whafDDaFpCghKnyLJNiCwSXG3aZBNGlTLGYlJaqZrM5ZmqmRJ04Ty9ZPiUC0rqHgRVHGLZ1UAJbRuqgokilXw0hLbKKuXEhWoFmQBaOCHcSMxmnoqZuLQvbuft5STbezNCeopEgMolo1OTXJEtBMq8SJ72V9M9xBYnbRzufSBQ96cayjGE4hVC0e5aCgTbomrUgSrraVpMJQpY3MzNFhBuVGv30jQUI1hbkGPTpzF"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "bloodBankName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "bloodBankName", "nyShNfB6Z8ANIG8P3Pl0dZarLXo7Xf2vXucDsvis2tbQFQFGgvNGaKfzSJj60u2J5rxWQmfCKaduOzl7PLuuLfAVuxTSmhyqx2IlviZx9Rc5qFhCxl5CsTz2VMFScVTitBG0yX697eRu0dxrlYSjCNP2Iw2Zbv3v2JUJWkRSnFSG0XnjRUgmnogmvlNVPpGyI6dZvUGTZDhhRp5dh8JtxtSjw3F63NWuhvmXAQrjFu5y1SbHTcpnPPp9kVc7g6prU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "fromDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "toDate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "noOfDonorsExpected", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "noOfDonorsArrived", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "noOfDonorsThatBled", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 12, "campTime", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "campTime", "IVxOy4sApxstaGPFD8LqXtOvXL1mFm5hQVfzZiqsUhHOYYBic4DfmzwrqPSEwDTOoZaoUZXmarECuZilFQLbVXYoil31ZMXxwS5oCQw2LbHw6TlbOE4mlN2RIQdmDzmeKtwvfp2OQW0XjWoK7JNNj1ob26gl78myMaoQLmFSeTbOJRHWM4SsMBjZ8CerCkJ2aMIWRGJsJeYnwatLXnayt6CnqB43crW2qAODRj9ldjp1bBUkK57sCUavuidpeb0kw"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                RegisterACamp registeracamp = createRegisterACamp(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = registeracamp.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 2:
                        registeracamp.setOrganisationName(contraints.getNegativeValue().toString());
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 4:
                        registeracamp.setReasonForCamp(contraints.getNegativeValue().toString());
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 6:
                        registeracamp.setBloodBankName(contraints.getNegativeValue().toString());
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 12:
                        field.setAccessible(true);
                        field.set(registeracamp, null);
                        validateRegisterACamp(contraints, registeracamp);
                        failureCount++;
                        break;
                    case 13:
                        registeracamp.setCampTime(contraints.getNegativeValue().toString());
                        validateRegisterACamp(contraints, registeracamp);
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
