package com.app.server.businessservice.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterADonorRepository;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor;
import com.app.shared.organization.locationmanagement.Address;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegInfoDto;

@Component
public class RegDonorDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RegisterADonorRepository<RegisterADonor> registerADonorRepository;

    public void proRegDonorDs(RegInfoDto dd) throws Exception {
        com.app.shared.organization.locationmanagement.Address address = new com.app.shared.organization.locationmanagement.Address();
        address.setAddressTypeId(dd.getAddressType());
        address.setCityId(dd.getCity());
        address.setCountryId(dd.getCountryId());
        address.setStateId(dd.getState());
        address.setZipcode(dd.getPostalCode());
        com.app.shared.organization.locationmanagement.Address address1 = addressRepository.save(address);
        com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor registerADonor = new com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor();
        registerADonor.setAddr(address1.getAddressId());
        registerADonor.setBg(dd.getBg());
        registerADonor.setDob(dd.getDob());
        registerADonor.setDonorName(dd.getDonorName());
        registerADonor.setEmailId(dd.getEmailId());
        registerADonor.setGendr(dd.getGender());
        registerADonor.setHowOftenUDonated(dd.getHowOftenUDonated());
        registerADonor.setLastDonationDate(dd.getLastDonationDate());
        registerADonor.setPhoneNo(dd.getPhoneNo());
        com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor registerADonor1 = registerADonorRepository.save(registerADonor);
    }
}
