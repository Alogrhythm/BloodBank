package com.app.server.businessservice.bloodbankboundedcontext.bloodbank;
import com.app.server.businessservice.bloodbankboundedcontext.RequestQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.bloodbankboundedcontext.RequestQ;
import java.util.List;

@Component
public class RequestDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private RequestQBzService requestQBzService;

    public List<RequestQ> proRequestDs() throws Exception {
        java.util.List<com.app.shared.bloodbankboundedcontext.RequestQ> requestQList = requestQBzService.executeQueryRequestQ();
        return requestQList;
    }
}
