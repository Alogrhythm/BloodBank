Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.RequestQModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "bloodGroups",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "dateNeededBy",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "noOfUnits",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "requestedByDoctor",
          "type": "string",
          "defaultValue": ""
     }]
});