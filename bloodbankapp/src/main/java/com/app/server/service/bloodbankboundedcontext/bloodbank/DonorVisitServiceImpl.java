package com.app.server.service.bloodbankboundedcontext.bloodbank;
import org.springframework.web.bind.annotation.RestController;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import org.springframework.http.HttpStatus;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.app.server.repository.bloodbankboundedcontext.bloodbank.DonorVisitRepository;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import java.lang.Override;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@RestController
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "39", comments = "Service for DonorVisit Transaction table", complexity = Complexity.MEDIUM)
@RequestMapping("/DonorVisit")
public class DonorVisitServiceImpl extends DonorVisitService {

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private DonorVisitRepository<DonorVisit> donorVisitrepo;

    @RequestMapping(value = "/findAll", consumes = "application/json", method = RequestMethod.GET)
    @Override
    public HttpEntity<ResponseBean> findAll() throws Exception {
        java.util.List<com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit> lstdonorvisit = donorVisitrepo.findAll();
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "findAll", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> save(@RequestBody DonorVisit entity) throws Exception {
        donorVisitrepo.save(entity);
        AppAlarm appAlarm = Log.getAlarm("BBBBB122100201");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", entity);
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", headers = { "isArray" }, method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> save(@RequestBody List<DonorVisit> entity, @RequestHeader("isArray") boolean request) throws Exception {
        donorVisitrepo.save(entity);
        AppAlarm appAlarm = Log.getAlarm("BBBBB122100201");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/{cid}", consumes = "application/json", method = RequestMethod.DELETE)
    @Override
    public HttpEntity<ResponseBean> delete(@PathVariable("cid") String entity) throws Exception {
        donorVisitrepo.delete(entity);
        AppAlarm appAlarm = Log.getAlarm("BBBBB128100200");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "delete", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    @Override
    public HttpEntity<ResponseBean> update(@RequestBody DonorVisit entity) throws Exception {
        donorVisitrepo.update(entity);
        AppAlarm appAlarm = Log.getAlarm("BBBBB123100200");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", entity._getPrimarykey());
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "update", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(consumes = "application/json", headers = { "isArray" }, method = RequestMethod.PUT)
    @Override
    public HttpEntity<ResponseBean> update(@RequestBody List<DonorVisit> entity, @RequestHeader("isArray") boolean request) throws Exception {
        donorVisitrepo.update(entity);
        AppAlarm appAlarm = Log.getAlarm("BBBBB123100200");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "update", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/search", consumes = "application/json", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> search(@RequestBody Map<String, Object> fieldData) throws Exception {
        List<java.lang.Object> lstdonorvisit = donorVisitrepo.search("DonorVisit.DefaultFinders", fieldData, getFieldMetaData());
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println(appAlarm.getAlarmID(), runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "search", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    private Map<String, String> getFieldMetaData() {
        java.util.Map<java.lang.String, java.lang.String> fieldMetaData = new java.util.HashMap<java.lang.String, java.lang.String>();
        fieldMetaData.put("dType", "String");
        return fieldMetaData;
    }

    @RequestMapping(value = "/findByDType", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> findByDType(@RequestBody FindByBean findByBean) throws Exception {
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        List<com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit> lstdonorvisit = donorVisitrepo.findByDType((java.lang.String) findByBean.getFindKey());
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println("BBBBB124100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/findByDonor", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> findByDonor(@RequestBody FindByBean findByBean) throws Exception {
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        List<com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit> lstdonorvisit = donorVisitrepo.findByDonor((java.lang.String) findByBean.getFindKey());
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println("BBBBB124100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/findByCamp", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> findByCamp(@RequestBody FindByBean findByBean) throws Exception {
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        List<com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit> lstdonorvisit = donorVisitrepo.findByCamp((java.lang.String) findByBean.getFindKey());
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println("BBBBB124100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @Override
    public HttpEntity<ResponseBean> findById(@RequestBody FindByBean findByBean) throws Exception {
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit lstdonorvisit = donorVisitrepo.findById((java.lang.String) findByBean.getFindKey());
        AppAlarm appAlarm = Log.getAlarm("BBBBB124100200");
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new ResponseBean(appAlarm);
        responseBean.add("message", String.format(appAlarm.getMessage(), "DonorVisit"));
        responseBean.add("data", lstdonorvisit);
        Log.out.println("BBBBB124100200", runtimeLogInfoHelper.getRequestHeaderBean(), "DonorVisitServiceImpl", "save", "DonorVisit");
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, HttpStatus.valueOf(appAlarm.getAlarmStatus()));
    }
}
