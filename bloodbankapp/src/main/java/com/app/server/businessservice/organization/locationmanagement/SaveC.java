package com.app.server.businessservice.organization.locationmanagement;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveC {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CountryRepository<Country> countryRepository;

    public void proSaveC(Country entity) throws Exception {
        entity.setCountryName("New");
        countryRepository.update(entity);
    }
}
