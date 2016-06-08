Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.TestBlood', {
     "xtype": "testBloodView",
     "items": [{
          "xtype": "customdatetimefield",
          "fieldLabel": "Collected Date",
          "name": "collectedDate",
          "bindable": "collectedDate",
          "margin": 5,
          "text": "Collected Date",
          "fieldName": "collectedDate",
          "displayName": "Collected Date",
          "widget": "customdatetimefield",
          "isField": true,
          "itemId": "customdatetimefield_ext_6763",
          "readOnly": true,
          "submitFormat": "d-m-Y H:m:s"
     }, {
          "xtype": "customdatetimefield",
          "fieldLabel": "Expiry Date",
          "name": "expiryDate",
          "bindable": "expiryDate",
          "margin": 5,
          "text": "Expiry Date",
          "fieldName": "expiryDate",
          "displayName": "Expiry Date",
          "widget": "customdatetimefield",
          "isField": true,
          "itemId": "customdatetimefield_ext_6769",
          "readOnly": true,
          "submitFormat": "d-m-Y H:m:s"
     }, {
          "xtype": "checkbox",
          "fieldLabel": "IsTested",
          "name": "isTested",
          "bindable": "isTested",
          "margin": 5,
          "text": "IsTested",
          "fieldName": "isTested",
          "displayName": "IsTested",
          "widget": "checkbox",
          "min": "0",
          "max": "1",
          "isField": true,
          "itemId": "checkbox_ext_6777",
          "readOnly": true
     }, {
          "xtype": "numberfield",
          "fieldLabel": "noOfUnits",
          "name": "noOfUnits",
          "margin": 5,
          "bindable": "noOfUnits",
          "text": "noOfUnits",
          "fieldName": "noOfUnits",
          "displayName": "noOfUnits",
          "widget": "numberfield",
          "min": "-2147483648",
          "max": "2147483647",
          "isField": true,
          "itemId": "numberfield_ext_6787",
          "readOnly": true
     }, {
          "xtype": "combo",
          "name": "donorVisitId",
          "margin": 5,
          "bindable": "donorVisitId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Donor Visit",
          "displayField": "orgnizerName",
          "valueField": "donorVisitId",
          "text": "Donor Visit",
          "fieldName": "donorVisitId",
          "displayName": "Donor Visit",
          "widget": "combo",
          "min": "1",
          "max": "256",
          "isField": true,
          "itemId": "combo_ext_6799",
          "readOnly": true,
          "store": {
               "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonorVisitModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "orgnizerName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/DonorVisit/findAll",
                    "serviceId": "4F93DB3C-282D-4A20-A476-A7066B17B64D",
                    "serviceType": 1,
                    "serviceOperationId": "1CEE2AC6-A54C-4B3F-B16B-BE3FFFA832E5",
                    "operationName": "findAll",
                    "operationDisplayName": "findAll",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "fileupload",
          "name": "donor",
          "border": 2,
          "margin": 5,
          "fieldLabel": "Donor",
          "bindable": "donor",
          "text": "Donor",
          "fieldName": "donor",
          "displayName": "Donor",
          "widget": "fileupload",
          "min": "1",
          "max": "256",
          "isField": true,
          "itemId": "fileupload_ext_6814",
          "title": "Donor"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "versionId",
          "name": "versionId",
          "margin": 5,
          "bindable": "versionId",
          "text": "versionId",
          "fieldName": "versionId",
          "displayName": "versionId",
          "widget": "numberfield",
          "isField": true,
          "itemId": "numberfield_ext_6831",
          "hidden": true
     }],
     "border": true,
     "autoScroll": true,
     "margin": 5,
     "itemId": "form_ext_6743",
     "dockedItems": [],
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonorVisitModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.TestBloodController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.TestBloodViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.TestBloodModel", "Bloodbankapp.view.fw.component.DateTimeField", "Bloodbankapp.view.fw.component.DateTimePicker", "Bloodbankapp.view.fw.component.FileUploadComponent"],
     "extend": "Ext.form.Panel",
     "viewModel": "TestBloodViewModel",
     "controller": "TestBloodController"
});