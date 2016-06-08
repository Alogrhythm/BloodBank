Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterADonorModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "donorId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "donorName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "dob",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "phoneNo",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "emailId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastDonationDate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "howOftenUDonated",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "gendr",
          "reference": "Gender",
          "defaultValue": ""
     }, {
          "name": "bg",
          "reference": "BloodGroup",
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