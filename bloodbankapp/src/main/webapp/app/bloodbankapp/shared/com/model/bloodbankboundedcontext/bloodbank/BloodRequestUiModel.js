Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodRequestUiModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "bloodGroups",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "requestedByDoctor",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "dateNeededBy",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "noOfUnits",
          "type": "string",
          "defaultValue": ""
     }]
});