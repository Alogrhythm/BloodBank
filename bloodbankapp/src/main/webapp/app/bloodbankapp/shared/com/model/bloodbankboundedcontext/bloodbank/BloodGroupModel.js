Ext.define('Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "bloodGroupId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "bloodGroups",
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