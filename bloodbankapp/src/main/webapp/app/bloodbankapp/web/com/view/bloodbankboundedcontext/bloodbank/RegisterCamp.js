Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.RegisterCamp', {
     "xtype": "registerCampView",
     "items": [{
          "xtype": "panel",
          "name": "ff",
          "items": [{
               "xtype": "panel",
               "items": [{
                    "xtype": "form",
                    "items": [{
                         "xtype": "panel",
                         "items": [{
                              "xtype": "textfield",
                              "fieldLabel": "Organisation Name",
                              "margin": 5,
                              "bindable": "organisationName",
                              "name": "organisationName",
                              "text": "Organisation Name",
                              "fieldName": "organisationName",
                              "displayName": "Organisation Name",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_16689"
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "Reason For Camp",
                              "margin": 5,
                              "bindable": "reasonForCamp",
                              "name": "reasonForCamp",
                              "text": "Reason For Camp",
                              "fieldName": "reasonForCamp",
                              "displayName": "Reason For Camp",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_16731"
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "Blood Bank Name",
                              "margin": 5,
                              "bindable": "bloodBankName",
                              "name": "bloodBankName",
                              "text": "Blood Bank Name",
                              "fieldName": "bloodBankName",
                              "displayName": "Blood Bank Name",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_16775"
                         }, {
                              "xtype": "customdatetimefield",
                              "fieldLabel": "From Date",
                              "name": "fromDate",
                              "bindable": "fromDate",
                              "margin": 5,
                              "text": "From Date",
                              "fieldName": "fromDate",
                              "displayName": "From Date",
                              "widget": "customdatetimefield",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "customdatetimefield_ext_16821",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "xtype": "numberfield",
                              "fieldLabel": "No Of Donors Expected",
                              "name": "noOfDonorsExpected",
                              "margin": 5,
                              "bindable": "noOfDonorsExpected",
                              "text": "No Of Donors Expected",
                              "fieldName": "noOfDonorsExpected",
                              "displayName": "No Of Donors Expected",
                              "widget": "numberfield",
                              "min": "-2147483648",
                              "max": "2147483647",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "numberfield_ext_16919"
                         }, {
                              "xtype": "customdatetimefield",
                              "fieldLabel": "To Date",
                              "name": "toDate",
                              "bindable": "toDate",
                              "margin": 5,
                              "text": "To Date",
                              "fieldName": "toDate",
                              "displayName": "To Date",
                              "widget": "customdatetimefield",
                              "isField": true,
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "itemId": "customdatetimefield_ext_16869",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "xtype": "numberfield",
                              "fieldLabel": "No Of Donors Arrived",
                              "name": "noOfDonorsArrived",
                              "margin": 5,
                              "bindable": "noOfDonorsArrived",
                              "text": "No Of Donors Arrived",
                              "fieldName": "noOfDonorsArrived",
                              "displayName": "No Of Donors Arrived",
                              "widget": "numberfield",
                              "min": "-2147483648",
                              "max": "2147483647",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "numberfield_ext_17074"
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "Camp Time",
                              "margin": 5,
                              "bindable": "campTime",
                              "name": "campTime",
                              "text": "Camp Time",
                              "fieldName": "campTime",
                              "displayName": "Camp Time",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_17128"
                         }, {
                              "xtype": "numberfield",
                              "fieldLabel": "No Of Donors That Bled",
                              "name": "noOfDonorsThatBled",
                              "margin": 5,
                              "bindable": "noOfDonorsThatBled",
                              "text": "No Of Donors That Bled",
                              "fieldName": "noOfDonorsThatBled",
                              "displayName": "No Of Donors That Bled",
                              "widget": "numberfield",
                              "min": "-2147483648",
                              "max": "2147483647",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "numberfield_ext_17184"
                         }],
                         "layout": {
                              "type": "table",
                              "columns": 2,
                              "tableAttrs": {
                                   "style": {
                                        "width": "100%"
                                   }
                              }
                         },
                         "border": true,
                         "margin": 5,
                         "dockedItems": [],
                         "allowModify": true,
                         "header": {
                              "style": {
                                   "background": "#99CCFF"
                              },
                              "hidden": true
                         },
                         "itemId": "panel_ext_16559"
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
                              "itemId": "tbfill_ext_17377"
                         }, {
                              "xtype": "button",
                              "name": "goAdd",
                              "text": "Go to Adress",
                              "margin": 5,
                              "isNavigationBtn": true,
                              "allowModify": true,
                              "style": {
                                   "background": "#800080"
                              },
                              "itemId": "button_ext_17313",
                              "listeners": {
                                   "click": "onGoAddClick"
                              }
                         }, {
                              "xtype": "tbfill",
                              "allowModify": true,
                              "itemId": "tbfill_ext_17443"
                         }],
                         "dockedItems": [],
                         "allowModify": true,
                         "style": {
                              "background": "#FF99CC"
                         },
                         "itemId": "toolbar_ext_17249"
                    }],
                    "allowModify": true,
                    "header": {
                         "style": {
                              "background": "#99CCFF"
                         },
                         "hidden": true
                    },
                    "itemId": "form_ext_16318"
               }],
               "border": 0,
               "title": "Camp Info",
               "frame": false,
               "split": true,
               "isAccordionPane": true,
               "isAccordionLayoutItem": true,
               "collapsed": false,
               "dockedItems": [],
               "allowModify": true,
               "header": {
                    "style": {
                         "background": "#99CCFF"
                    }
               },
               "itemId": "panel_ext_16205"
          }, {
               "xtype": "panel",
               "name": "addtess",
               "items": [{
                    "xtype": "form",
                    "items": [{
                         "xtype": "panel",
                         "items": [{
                              "xtype": "textfield",
                              "fieldLabel": "Address",
                              "margin": 5,
                              "bindable": "Address",
                              "name": "Address",
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_18130"
                         }, {
                              "xtype": "combo",
                              "name": "Country",
                              "margin": 5,
                              "bindable": "Country",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Country",
                              "displayField": "countryName",
                              "valueField": "countryId",
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "itemId": "combo_ext_18272",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "countryName",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/Country/findAll",
                                        "serviceId": "833ED4DF-35C0-491C-BBB2-3F4CB8F011A3",
                                        "serviceType": 1,
                                        "serviceOperationId": "5D7BBEB6-8F72-461A-9323-83D8C96A7EA2",
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
                              },
                              "listeners": {
                                   "change": "onCountryChange"
                              }
                         }, {
                              "xtype": "combo",
                              "name": "AddressType",
                              "margin": 5,
                              "bindable": "AddressType",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "AddressType",
                              "displayField": "addressType",
                              "valueField": "addressTypeId",
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "itemId": "combo_ext_18429",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "addressType",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/AddressType/findAll",
                                        "serviceId": "2EA2C0F4-1A4A-4FE3-AFB4-D4F593147010",
                                        "serviceType": 1,
                                        "serviceOperationId": "D6CE00C3-F690-48D6-9318-07DDD5C10B9A",
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
                              "name": "State",
                              "margin": 5,
                              "bindable": "State",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "State",
                              "displayField": "stateName",
                              "valueField": "stateId",
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "isRelatedWith": "gfmihkbdi",
                              "itemId": "combo_ext_18352",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "stateName",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/State/findAll",
                                        "serviceId": "9A460693-4393-410C-90D9-64D84D8D7952",
                                        "serviceType": 1,
                                        "serviceOperationId": "FD316B95-62CF-482E-9385-54FB453CA9C0",
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
                              },
                              "listeners": {
                                   "change": "onStateChange"
                              }
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "PostalCode",
                              "margin": 5,
                              "bindable": "PostalCode",
                              "name": "PostalCode",
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_18200"
                         }, {
                              "xtype": "combo",
                              "name": "City",
                              "margin": 5,
                              "bindable": "City",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "City",
                              "displayField": "cityName",
                              "valueField": "cityId",
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "isRelatedWith": "gammmkgbi",
                              "itemId": "combo_ext_18507",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "cityName",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/City/findAll",
                                        "serviceId": "48DED56F-9243-4766-B193-8B1E27C32B19",
                                        "serviceType": 1,
                                        "serviceOperationId": "B87DD128-66CB-42AD-BCE6-A7003784AA28",
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
                         "layout": {
                              "type": "table",
                              "columns": 2,
                              "tableAttrs": {
                                   "style": {
                                        "width": "100%"
                                   }
                              }
                         },
                         "border": true,
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
                                   "itemId": "tbfill_ext_21434"
                              }, {
                                   "xtype": "button",
                                   "name": "Register",
                                   "text": "Register",
                                   "margin": 5,
                                   "allowModify": true,
                                   "style": {
                                        "background": "#800080"
                                   },
                                   "itemId": "button_ext_21182",
                                   "listeners": {
                                        "click": "onRegisterClick"
                                   }
                              }, {
                                   "xtype": "button",
                                   "name": "Reset",
                                   "text": "Reset",
                                   "margin": 5,
                                   "isResetButton": true,
                                   "style": {
                                        "background": "#800080"
                                   },
                                   "allowModify": true,
                                   "itemId": "button_ext_10483",
                                   "listeners": {
                                        "click": "onResetClick"
                                   }
                              }, {
                                   "xtype": "tbfill",
                                   "allowModify": true,
                                   "itemId": "tbfill_ext_21521"
                              }],
                              "rowspan": 0,
                              "colspan": 0,
                              "dockedItems": [],
                              "allowModify": true,
                              "style": {
                                   "background": "#FF99CC"
                              },
                              "itemId": "toolbar_ext_21099"
                         }],
                         "allowModify": true,
                         "header": {
                              "style": {
                                   "background": "#99CCFF"
                              },
                              "hidden": true
                         },
                         "itemId": "panel_ext_17925"
                    }],
                    "border": true,
                    "autoScroll": true,
                    "margin": 5,
                    "dockedItems": [],
                    "allowModify": true,
                    "header": {
                         "style": {
                              "background": "#99CCFF"
                         },
                         "hidden": true
                    },
                    "itemId": "form_ext_16354"
               }],
               "border": 0,
               "title": "Address",
               "frame": false,
               "split": true,
               "isAccordionPane": true,
               "isAccordionLayoutItem": true,
               "dockedItems": [],
               "collapsed": false,
               "allowModify": true,
               "header": {
                    "style": {
                         "background": "#99CCFF"
                    }
               },
               "titleCollapse": true,
               "collapsible": true,
               "itemId": "panel_ext_16228"
          }],
          "autoScroll": false,
          "layout": {
               "type": "accordion",
               "multi": true
          },
          "border": true,
          "enableSplitters": true,
          "padding": 0,
          "margin": 5,
          "splitterResize": true,
          "dockedItems": [],
          "allowModify": true,
          "header": {
               "style": {
                    "background": "#99CCFF"
               }
          },
          "itemId": "panel_ext_16190"
     }],
     "border": true,
     "autoScroll": true,
     "margin": 5,
     "dockedItems": [],
     "allowModify": true,
     "header": {
          "style": {
               "background": "#99CCFF"
          },
          "hidden": true
     },
     "itemId": "form_ext_16182",
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.RegisterCampController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.RegisterCampViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterCampModel", "Bloodbankapp.view.fw.component.DateTimeField", "Bloodbankapp.view.fw.component.DateTimePicker"],
     "extend": "Ext.form.Panel",
     "viewModel": "RegisterCampViewModel",
     "controller": "RegisterCampController"
});