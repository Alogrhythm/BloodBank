package com.app.shared.bloodbankboundedcontext;
import com.athena.server.dataengine.bizService.DTOMapperInterface;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RequestQ implements DTOMapperInterface {

    private String bloodGroups;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dateNeededBy;

    private Integer noOfUnits;

    private String requestedByDoctor;

    public RequestQ(Object[] aryObject) {
        if (aryObject != null) {
            bloodGroups = (java.lang.String) aryObject[0];
            dateNeededBy = (java.sql.Timestamp) aryObject[1];
            noOfUnits = (aryObject[2] == null ? null : new Integer(aryObject[2].toString()));
            requestedByDoctor = (java.lang.String) aryObject[3];
        } else {
            bloodGroups = null;
            dateNeededBy = null;
            noOfUnits = null;
            requestedByDoctor = null;
        }
    }

    public String getBloodGroups() {
        return bloodGroups;
    }

    public Timestamp getDateNeededBy() {
        return dateNeededBy;
    }

    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public String getRequestedByDoctor() {
        return requestedByDoctor;
    }
}
