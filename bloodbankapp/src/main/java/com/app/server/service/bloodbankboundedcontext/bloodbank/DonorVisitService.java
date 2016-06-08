package com.app.server.service.bloodbankboundedcontext.bloodbank;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.bloodbankboundedcontext.bloodbank.DonorVisit;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "39", comments = "Service for DonorVisit Transaction table", complexity = Complexity.MEDIUM)
public abstract class DonorVisitService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(DonorVisit entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<DonorVisit> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(DonorVisit entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<DonorVisit> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByDType(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByDonor(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByCamp(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
