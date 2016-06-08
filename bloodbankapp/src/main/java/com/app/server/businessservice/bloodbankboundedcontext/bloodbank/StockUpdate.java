package com.app.server.businessservice.bloodbankboundedcontext.bloodbank;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodResultRepository;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.BloodStockRepository;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonorVisitRepository;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.RegisterADonorRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodStock;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.bloodbankboundedcontext.bloodbank.DVdto;

@Component
public class StockUpdate {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private BloodStockRepository<BloodStock> bloodStockRepository;

    @Autowired
    private DonorVisitRepository<DonorVisit> donorVisitRepository;

    @Autowired
    private BloodResultRepository<BloodResult> bloodResultRepository;

    @Autowired
    private RegisterADonorRepository<RegisterADonor> registerADonorRepository;

    public void proStockUpdate(DVdto dd) throws Exception {
        com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit donorVisit2 = donorVisitRepository.findById(dd.getDvid());
        com.app.shared.bloodbankboundedcontext.bloodbank.ClinicalInfo clinicalInfo1 = new com.app.shared.bloodbankboundedcontext.bloodbank.ClinicalInfo();
        clinicalInfo1.setBp(dd.getBp());
        clinicalInfo1.setHeight(dd.getHeight());
        clinicalInfo1.setPulse(dd.getPulse());
        clinicalInfo1.setTemprature(dd.getTemp());
        clinicalInfo1.setUnitsOfBlood(dd.getNoOfUnits());
        clinicalInfo1.setWeight(dd.getWeight());
        donorVisit2.setClinicalInfo(clinicalInfo1);
        donorVisitRepository.update(donorVisit2);
        com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor registerADonor1 = registerADonorRepository.findById(donorVisit2.getDonor());
        java.util.List<com.app.shared.bloodbankboundedcontext.bloodbank.BloodStock> bloodStockList4 = bloodStockRepository.findByBloodg(registerADonor1.getBg());
        for (com.app.shared.bloodbankboundedcontext.bloodbank.BloodStock bloodStockList4Element : bloodStockList4) {
            bloodStockList4Element.setNoOfUnits(bloodStockList4Element.getNoOfUnits() + clinicalInfo1.getUnitsOfBlood());
            bloodStockRepository.update(bloodStockList4Element);
        }
        com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult bloodResult = new com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult();
        bloodResult.setCollectedDate(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
        bloodResult.setDonorVisitId(donorVisit2.getDonorVisitId());
        bloodResult.setExpiryDate(new java.sql.Timestamp(java.lang.System.currentTimeMillis() + 864000000));
        bloodResult.setIsTested(true);
        bloodResult.setNoOfUnits(clinicalInfo1.getUnitsOfBlood());
        com.app.shared.bloodbankboundedcontext.bloodbank.BloodResult bloodResult1 = bloodResultRepository.save(bloodResult);
    }
}
