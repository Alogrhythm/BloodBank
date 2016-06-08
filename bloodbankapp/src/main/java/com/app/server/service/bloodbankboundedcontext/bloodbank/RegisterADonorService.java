package com.app.server.service.bloodbankboundedcontext.bloodbank;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.bloodbankboundedcontext.bloodbank.RegisterADonor;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "38", comments = "Service for RegisterADonor Transaction table", complexity = Complexity.MEDIUM)
public abstract class RegisterADonorService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(RegisterADonor entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<RegisterADonor> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(RegisterADonor entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<RegisterADonor> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByGendr(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByBg(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByAddr(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
