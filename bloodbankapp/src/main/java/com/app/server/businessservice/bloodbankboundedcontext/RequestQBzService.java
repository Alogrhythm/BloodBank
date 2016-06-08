package com.app.server.businessservice.bloodbankboundedcontext;
import com.app.shared.bloodbankboundedcontext.RequestQ;
import java.util.List;

public interface RequestQBzService {

    public List<RequestQ> executeQueryRequestQ() throws Exception;
}
