package com.app.server.service.bloodbankboundedcontext.bloodbank;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.bloodbankboundedcontext.bloodbank.BloodGroup;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "48", comments = "Service for BloodGroup Master table Entity", complexity = Complexity.LOW)
public abstract class BloodGroupService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(BloodGroup entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<BloodGroup> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(BloodGroup entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<BloodGroup> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> FindByBG(String bloodGroups) throws Exception {
        return null;
    }
}
