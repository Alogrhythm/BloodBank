package com.app.server.businessservice.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterACampRepository;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp;
import com.app.shared.organization.locationmanagement.Address;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegCampInfo;

@Component
public class RegCampDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RegisterACampRepository<RegisterACamp> registerACampRepository;

    public void proRegCampDs(RegCampInfo ss) throws Exception {
        com.app.shared.organization.locationmanagement.Address address = new com.app.shared.organization.locationmanagement.Address();
        address.setAddressTypeId(ss.getAddressType());
        address.setCityId(ss.getCity());
        address.setCountryId(ss.getCountry());
        address.setStateId(ss.getState());
        address.setZipcode(ss.getPostalCode());
        com.app.shared.organization.locationmanagement.Address address1 = addressRepository.save(address);
        com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp registerACamp = new com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp();
        registerACamp.setAddr(address1.getAddressId());
        registerACamp.setBloodBankName(ss.getBloodBankName());
        registerACamp.setCampTime(ss.getCampTime());
        registerACamp.setFromDate(ss.getFromDate());
        registerACamp.setNoOfDonorsArrived(ss.getNoOfDonorsArrived());
        registerACamp.setNoOfDonorsExpected(ss.getNoOfDonorsExpected());
        registerACamp.setNoOfDonorsThatBled(ss.getNoOfDonorsThatBled());
        registerACamp.setOrganisationName(ss.getOrganisationName());
        registerACamp.setReasonForCamp(ss.getReasonForCamp());
        registerACamp.setToDate(ss.getToDate());
        com.app.shared.bloodbankboundedcontext.bloodbank.RegisterACamp registerACamp1 = registerACampRepository.save(registerACamp);
    }
}
