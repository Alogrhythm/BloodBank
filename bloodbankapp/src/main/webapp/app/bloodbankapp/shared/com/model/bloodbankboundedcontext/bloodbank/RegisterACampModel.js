Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterACampModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "campId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "organisationName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "reasonForCamp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "bloodBankName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "fromDate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "toDate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "noOfDonorsExpected",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "noOfDonorsArrived",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "noOfDonorsThatBled",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "campTime",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addr",
          "reference": "Address",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});