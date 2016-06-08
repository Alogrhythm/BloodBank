Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.DonorVisitMain', {
     "xtype": "DonorVisit",
     "displayName": "Donor Visit",
     "name": "DonorVisit",
     "itemId": "DonorVisitForm",
     "bodyPadding": 10,
     "items": [{
          "xtype": "form",
          "itemId": "form0",
          "header": {
               "hidden": true
          },
          "items": [{
               "layout": "column",
               "header": {
                    "hidden": true
               },
               "xtype": "panel",
               "items": [{
                    "name": "donorVisitId",
                    "itemId": "donorVisitId",
                    "xtype": "textfield",
                    "displayName": "donorVisitId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "donorVisitId<font color='red'> *<\/font>",
                    "hidden": true,
                    "value": "",
                    "bindable": "donorVisitId"
               }, {
                    "name": "orgnizerName",
                    "itemId": "orgnizerName",
                    "xtype": "textfield",
                    "displayName": "Orgnizer Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Orgnizer Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "orgnizerName",
                    "columnWidth": 0.5
               }, {
                    "name": "dType",
                    "itemId": "dType",
                    "xtype": "combo",
                    "displayName": "Donation Type",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonationTypeModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Donation Type<font color='red'> *<\/font>",
                    "restURL": "DonationType",
                    "bindable": "dType",
                    "columnWidth": 0.5
               }, {
                    "name": "donor",
                    "itemId": "donor",
                    "xtype": "combo",
                    "displayName": "Donor",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterADonorModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Donor<font color='red'> *<\/font>",
                    "restURL": "RegisterADonor",
                    "bindable": "donor",
                    "columnWidth": 0.5
               }, {
                    "name": "camp",
                    "itemId": "camp",
                    "xtype": "combo",
                    "displayName": "Camp",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterACampModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Camp<font color='red'> *<\/font>",
                    "restURL": "RegisterACamp",
                    "bindable": "camp",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "bindable": "versionId",
                    "hidden": true
               }]
          }]
     }, {
          "xtype": "form",
          "displayName": "Clinical Info",
          "title": "Clinical Info",
          "name": "ClinicalInfo",
          "itemId": "ClinicalInfoForm",
          "bodyPadding": 10,
          "items": [{
               "xtype": "form",
               "itemId": "form1",
               "header": {
                    "hidden": true
               },
               "items": [{
                    "layout": "column",
                    "header": {
                         "hidden": true
                    },
                    "xtype": "panel",
                    "items": [{
                         "name": "clinicalInfoId",
                         "itemId": "clinicalInfoId",
                         "xtype": "textfield",
                         "displayName": "clinicalInfoId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "clinicalInfoId<font color='red'> *<\/font>",
                         "hidden": true,
                         "value": "",
                         "bindable": "clinicalInfo.clinicalInfoId"
                    }, {
                         "name": "height",
                         "itemId": "height",
                         "xtype": "textfield",
                         "displayName": "Height",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Height<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "clinicalInfo.height",
                         "columnWidth": 0.5
                    }, {
                         "name": "weight",
                         "itemId": "weight",
                         "xtype": "textfield",
                         "displayName": "Weight",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Weight<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "clinicalInfo.weight",
                         "columnWidth": 0.5
                    }, {
                         "name": "pulse",
                         "itemId": "pulse",
                         "xtype": "textfield",
                         "displayName": "Pulse",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Pulse<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "clinicalInfo.pulse",
                         "columnWidth": 0.5
                    }, {
                         "name": "bp",
                         "itemId": "bp",
                         "xtype": "textfield",
                         "displayName": "BP",
                         "margin": "5 5 5 5",
                         "fieldLabel": "BP<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "clinicalInfo.bp",
                         "columnWidth": 0.5
                    }, {
                         "name": "temprature",
                         "itemId": "temprature",
                         "xtype": "textfield",
                         "displayName": "Temprature",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Temprature<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "clinicalInfo.temprature",
                         "columnWidth": 0.5
                    }, {
                         "name": "unitsOfBlood",
                         "itemId": "unitsOfBlood",
                         "xtype": "numberfield",
                         "displayName": "unitsOfBlood",
                         "margin": "5 5 5 5",
                         "fieldLabel": "unitsOfBlood<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "clinicalInfo.unitsOfBlood",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "bindable": "clinicalInfo.versionId",
                         "hidden": true
                    }]
               }]
          }]
     }],
     "requires": ["Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.DonorVisitMainController", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonationTypeModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterADonorModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterACampModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.DonorVisitMainController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.DonorVisitViewModel"],
     "tools": [{
          "type": "help",
          "tooltip": "Get Console",
          "handler": "onConsoleClick"
     }, {
          "type": "refresh",
          "tooltip": "Refresh Tab",
          "handler": "init"
     }],
     "tbar": ["->", {
          "itemId": "cardPrev",
          "text": "&laquo; Previous",
          "handler": "showPreviousCard",
          "disabled": true
     }, {
          "itemId": "cardNext",
          "text": "Next &raquo;",
          "handler": "showNextCard"
     }],
     "layout": "card",
     "defaults": {
          "autoScroll": true
     },
     "autoScroll": true,
     "dockedItems": [{
          "xtype ": "toolbar",
          "customWidgetType": "vdBBar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "parentId": 1,
          "customId": 358,
          "items": [{
               "xtype": "tbfill",
               "customWidgetType": "vdTbFill",
               "parentId": 358,
               "customId": 394
          }, {
               "customWidgetType": "vdButton",
               "xtype": "button",
               "name": "saveFormButton",
               "margin": 5,
               "text": "Save",
               "hiddenName": "button",
               "canHaveParent": false,
               "itemId": "saveFormButton",
               "parentId": 358,
               "customId": 395,
               "listeners": {
                    "click": "saveForm"
               }
          }, {
               "customWidgetType": "vdButton",
               "xtype": "button",
               "name": "resetFormButton",
               "margin": 5,
               "text": "Reset",
               "hiddenName": "button",
               "canHaveParent": false,
               "itemId": "resetFormButton",
               "parentId": 358,
               "customId": 396,
               "listeners": {
                    "click": "resetForm"
               }
          }]
     }],
     "controller": "DonorVisitMainController",
     "restURL": "/DonorVisit",
     "listeners": {
          "afterrender": "afterFormRender",
          "scope": "controller"
     },
     "extend": "Ext.form.Panel"
});