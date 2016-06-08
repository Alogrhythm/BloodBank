Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.DonorVisitScreen', {
     "xtype": "donorVisitScreenView",
     "items": [{
          "xtype": "tabpanel",
          "name": "jj",
          "items": [{
               "xtype": "panel",
               "items": [{
                    "xtype": "form",
                    "items": [{
                         "xtype": "textfield",
                         "fieldLabel": "orgnizerName",
                         "margin": 5,
                         "bindable": "orgnizerName",
                         "name": "orgnizerName",
                         "text": "orgnizerName",
                         "fieldName": "orgnizerName",
                         "displayName": "orgnizerName",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_33945"
                    }, {
                         "xtype": "combo",
                         "name": "donnationType",
                         "margin": 5,
                         "bindable": "donnationType",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Donnation Type",
                         "displayField": "donationTypes",
                         "valueField": "donationTypeId",
                         "text": "donnationType",
                         "fieldName": "donnationType",
                         "displayName": "donnationType",
                         "fieldType": "java.lang.String",
                         "widget": "combo",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "combo_ext_33979",
                         "store": {
                              "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonationTypeModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "donationTypes",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/DonationType/findAll",
                                   "serviceId": "7E6A0015-4839-4FC7-BFAE-E0D39C1647CB",
                                   "serviceType": 1,
                                   "serviceOperationId": "648674ED-18AF-4688-973E-AED908AAD374",
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
                         "xtype": "combo",
                         "name": "donor",
                         "margin": 5,
                         "bindable": "donor",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Donor",
                         "displayField": "donorName",
                         "valueField": "donorId",
                         "text": "donor",
                         "fieldName": "donor",
                         "displayName": "donor",
                         "fieldType": "java.lang.String",
                         "widget": "combo",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "combo_ext_34015",
                         "store": {
                              "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterADonorModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "donorName",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/RegisterADonor/findAll",
                                   "serviceId": "FC5CFE77-6A46-4234-A8C1-8B5334F3024C",
                                   "serviceType": 1,
                                   "serviceOperationId": "FA27C6F4-A74B-4058-9DD5-A7B320E7D17F",
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
                         "xtype": "combo",
                         "name": "camp",
                         "margin": 5,
                         "bindable": "camp",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Camp",
                         "displayField": "organisationName",
                         "valueField": "campId",
                         "text": "camp",
                         "fieldName": "camp",
                         "displayName": "camp",
                         "fieldType": "java.lang.String",
                         "widget": "combo",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "combo_ext_34053",
                         "store": {
                              "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterACampModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "organisationName",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/RegisterACamp/findAll",
                                   "serviceId": "BBE3E0A2-D0F9-4085-B636-F6294B7621C1",
                                   "serviceType": 1,
                                   "serviceOperationId": "BB892D7A-074C-4900-83D6-AF0B230135BE",
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
                    }],
                    "border": true,
                    "autoScroll": true,
                    "margin": 5,
                    "dockedItems": [{
                         "xtype": "toolbar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isToolBar": true,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "allowModify": true,
                              "itemId": "tbfill_ext_34548"
                         }, {
                              "xtype": "button",
                              "name": "Next",
                              "text": "Next",
                              "margin": 5,
                              "isNavigationBtn": true,
                              "allowModify": true,
                              "itemId": "button_ext_34490",
                              "listeners": {
                                   "click": "onNextClick"
                              }
                         }],
                         "dockedItems": [],
                         "allowModify": true,
                         "itemId": "toolbar_ext_34433"
                    }],
                    "allowModify": true,
                    "itemId": "form_ext_33795"
               }],
               "layout": "fit",
               "bodyBorder": true,
               "bodyPadding": 0,
               "border": true,
               "title": "DonorVisit",
               "tabId": 1,
               "isTabLayoutItem": true,
               "dockedItems": [],
               "allowModify": true,
               "itemId": "panel_ext_33741"
          }, {
               "xtype": "panel",
               "items": [{
                    "xtype": "form",
                    "items": [{
                         "xtype": "textfield",
                         "fieldLabel": "Height",
                         "margin": 5,
                         "bindable": "height",
                         "name": "height",
                         "text": "height",
                         "fieldName": "height",
                         "displayName": "height",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_34139"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Weight",
                         "margin": 5,
                         "bindable": "weight",
                         "name": "weight",
                         "text": "weight",
                         "fieldName": "weight",
                         "displayName": "weight",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_34181"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Pulse",
                         "margin": 5,
                         "bindable": "pulse",
                         "name": "pulse",
                         "text": "pulse",
                         "fieldName": "pulse",
                         "displayName": "pulse",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_34225"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Blood Pressure",
                         "margin": 5,
                         "bindable": "bp",
                         "name": "bp",
                         "text": "bp",
                         "fieldName": "bp",
                         "displayName": "bp",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_34271"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Temprature",
                         "margin": 5,
                         "bindable": "temp",
                         "name": "temp",
                         "text": "temp",
                         "fieldName": "temp",
                         "displayName": "temp",
                         "fieldType": "java.lang.String",
                         "widget": "textfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "textfield_ext_34319"
                    }, {
                         "xtype": "numberfield",
                         "fieldLabel": "No Of Units",
                         "name": "noOfUnits",
                         "margin": 5,
                         "bindable": "noOfUnits",
                         "text": "noOfUnits",
                         "fieldName": "noOfUnits",
                         "displayName": "noOfUnits",
                         "fieldType": "java.lang.Integer",
                         "widget": "numberfield",
                         "isField": true,
                         "allowModify": true,
                         "itemId": "numberfield_ext_34369"
                    }, {
                         "xtype": "hiddenfield",
                         "fieldLabel": "dvid",
                         "bindable": "dvid",
                         "margin": 5,
                         "name": "dvid",
                         "allowModify": true,
                         "itemId": "hiddenfield_ext_3042"
                    }],
                    "border": true,
                    "autoScroll": true,
                    "margin": 5,
                    "dockedItems": [{
                         "xtype": "toolbar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isToolBar": true,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "button",
                              "name": "Save",
                              "text": "DonateBlood",
                              "margin": 5,
                              "allowModify": true,
                              "itemId": "button_ext_35625",
                              "listeners": {
                                   "click": "onSaveClick"
                              }
                         }],
                         "dockedItems": [],
                         "allowModify": true,
                         "itemId": "toolbar_ext_35564"
                    }],
                    "allowModify": true,
                    "itemId": "form_ext_33829"
               }],
               "layout": "fit",
               "bodyBorder": true,
               "bodyPadding": 0,
               "border": true,
               "title": "Clinical Info",
               "tabId": 2,
               "isTabLayoutItem": true,
               "dockedItems": [],
               "allowModify": true,
               "itemId": "panel_ext_33765"
          }],
          "autoScroll": true,
          "activeItem": 0,
          "activeTab": 0,
          "margin": 5,
          "dockedItems": [],
          "allowModify": true,
          "itemId": "tabpanel_ext_33722"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "dockedItems": [],
     "allowModify": true,
     "itemId": "form_ext_33711",
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonationTypeModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterADonorModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterACampModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.DonorVisitScreenController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.DonorVisitScreenViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.DonorVisitScreenModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "DonorVisitScreenViewModel",
     "controller": "DonorVisitScreenController"
});