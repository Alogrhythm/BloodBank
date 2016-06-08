Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonationTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "donationTypeId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "donationTypes",
          "type": "string",
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