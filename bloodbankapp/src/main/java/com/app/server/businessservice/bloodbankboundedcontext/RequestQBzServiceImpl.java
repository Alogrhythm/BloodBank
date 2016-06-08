package com.app.server.businessservice.bloodbankboundedcontext;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.bloodbankboundedcontext.RequestQ;
import java.lang.Override;
import java.util.List;

@Component
public class RequestQBzServiceImpl implements RequestQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<RequestQ> executeQueryRequestQ() throws Exception {
        java.util.List<com.app.shared.bloodbankboundedcontext.RequestQ> listDtoInterface = new java.util.ArrayList<com.app.shared.bloodbankboundedcontext.RequestQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "F19C26E6-5E2A-4C90-AA8C-DEC37141560C");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.bloodbankboundedcontext.RequestQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
