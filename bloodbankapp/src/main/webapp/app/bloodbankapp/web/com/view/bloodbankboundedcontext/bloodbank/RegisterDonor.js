Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.RegisterDonor', {
     "xtype": "registerDonorView",
     "items": [{
          "xtype": "panel",
          "name": "aa",
          "items": [{
               "xtype": "panel",
               "items": [{
                    "xtype": "form",
                    "items": [{
                         "xtype": "panel",
                         "items": [{
                              "xtype": "textfield",
                              "fieldLabel": "Donor Name",
                              "margin": 5,
                              "bindable": "donorName",
                              "name": "donorName",
                              "text": "Donor Name",
                              "fieldName": "donorName",
                              "displayName": "Donor Name",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_7765"
                         }, {
                              "xtype": "customdatetimefield",
                              "fieldLabel": "Date Of Birth",
                              "name": "dob",
                              "bindable": "dob",
                              "margin": 5,
                              "text": "Date Of Birth",
                              "fieldName": "dob",
                              "displayName": "Date Of Birth",
                              "widget": "customdatetimefield",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "customdatetimefield_ext_7807",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "Phone No.",
                              "margin": 5,
                              "bindable": "phoneNo",
                              "name": "phoneNo",
                              "text": "Phone No.",
                              "fieldName": "phoneNo",
                              "displayName": "Phone No.",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_7851"
                         }, {
                              "xtype": "textfield",
                              "fieldLabel": "Email Id",
                              "margin": 5,
                              "bindable": "emailId",
                              "name": "emailId",
                              "text": "Email Id",
                              "fieldName": "emailId",
                              "displayName": "Email Id",
                              "widget": "textfield",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_7897"
                         }, {
                              "xtype": "combo",
                              "name": "gendr",
                              "margin": 5,
                              "bindable": "gendr",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Gender",
                              "displayField": "gender",
                              "valueField": "genderId",
                              "text": "Gender",
                              "fieldName": "gendr",
                              "displayName": "Gender",
                              "widget": "combo",
                              "min": "0",
                              "max": "64",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "combo_ext_8047",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.GenderModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "gender",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/Gender/findAll",
                                        "serviceId": "66793CC9-C92F-4A5C-83C4-9650AC531B77",
                                        "serviceType": 1,
                                        "serviceOperationId": "5A091622-57B3-4F0E-97F8-10F474A337FC",
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
                              "xtype": "numberfield",
                              "fieldLabel": "How often you have donated in past",
                              "name": "howOftenUDonated",
                              "margin": 5,
                              "bindable": "howOftenUDonated",
                              "text": "How often you have donated in past",
                              "fieldName": "howOftenUDonated",
                              "displayName": "How often you have donated in past",
                              "widget": "numberfield",
                              "min": "-2147483648",
                              "max": "2147483647",
                              "isField": true,
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "itemId": "numberfield_ext_7995"
                         }, {
                              "xtype": "combo",
                              "name": "bg",
                              "margin": 5,
                              "bindable": "bg",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Blood Group",
                              "displayField": "bloodGroups",
                              "valueField": "bloodGroupId",
                              "text": "Blood Group",
                              "fieldName": "bg",
                              "displayName": "Blood Group",
                              "widget": "combo",
                              "min": "1",
                              "max": "256",
                              "isField": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "combo_ext_8101",
                              "store": {
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel",
                                   "autoLoad": true,
                                   "autoSync": true,
                                   "sorters": [{
                                        "property": "bloodGroups",
                                        "direction": "ASC"
                                   }],
                                   "proxy": {
                                        "type": "ajax",
                                        "url": "secure/BloodGroup/findAll",
                                        "serviceId": "290894C9-5A73-4525-ACC3-DD4685E50641",
                                        "serviceType": 1,
                                        "serviceOperationId": "E2E3CC78-2683-4A56-8599-B006E2BF2A14",
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
                              "xtype": "customdatetimefield",
                              "fieldLabel": "Last Donation Date",
                              "name": "lastDonationDate",
                              "bindable": "lastDonationDate",
                              "margin": 5,
                              "text": "Last Donation Date",
                              "fieldName": "lastDonationDate",
                              "displayName": "Last Donation Date",
                              "widget": "customdatetimefield",
                              "isField": true,
                              "allowModify": true,
                              "rowspan": 0,
                              "colspan": 0,
                              "itemId": "customdatetimefield_ext_7945",
                              "submitFormat": "d-m-Y H:m:s"
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
                                   "itemId": "tbfill_ext_11617"
                              }, {
                                   "xtype": "button",
                                   "name": "goAdd",
                                   "text": "Go To Address",
                                   "margin": 5,
                                   "isNavigationBtn": true,
                                   "allowModify": true,
                                   "style": {
                                        "background": "#800080"
                                   },
                                   "itemId": "button_ext_11540",
                                   "listeners": {
                                        "click": "onGoAddClick"
                                   }
                              }, {
                                   "xtype": "tbfill",
                                   "allowModify": true,
                                   "itemId": "tbfill_ext_11695"
                              }],
                              "rowspan": 0,
                              "colspan": 0,
                              "dockedItems": [],
                              "allowModify": true,
                              "style": {
                                   "background": "#FF99CC"
                              },
                              "itemId": "toolbar_ext_11464"
                         }],
                         "allowModify": true,
                         "header": {
                              "style": {
                                   "background": "#99CCFF"
                              },
                              "hidden": true
                         },
                         "itemId": "panel_ext_7634"
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
                    "itemId": "form_ext_7366"
               }],
               "border": 0,
               "title": "Donor Info",
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
               "itemId": "panel_ext_7310"
          }, {
               "xtype": "panel",
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
                              "itemId": "textfield_ext_8622"
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
                              "itemId": "combo_ext_8742",
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
                              "xtype": "textfield",
                              "fieldLabel": "PostalCode",
                              "margin": 5,
                              "bindable": "PostalCode",
                              "name": "PostalCode",
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "textfield_ext_8681"
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
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "isRelatedWith": "lkhgdbhji",
                              "itemId": "combo_ext_8805",
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
                              "rowspan": 0,
                              "colspan": 0,
                              "allowModify": true,
                              "itemId": "combo_ext_8870",
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
                              "isRelatedWith": "dmmphhhdi",
                              "itemId": "combo_ext_8937",
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
                                   "itemId": "tbfill_ext_13034"
                              }, {
                                   "xtype": "button",
                                   "name": "Register",
                                   "text": "Register",
                                   "margin": 5,
                                   "allowModify": true,
                                   "style": {
                                        "background": "#800080"
                                   },
                                   "itemId": "button_ext_12784",
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
                                   "itemId": "button_ext_8039",
                                   "listeners": {
                                        "click": "onResetClick"
                                   }
                              }, {
                                   "xtype": "tbfill",
                                   "allowModify": true,
                                   "itemId": "tbfill_ext_13119"
                              }],
                              "rowspan": 0,
                              "colspan": 0,
                              "dockedItems": [],
                              "allowModify": true,
                              "style": {
                                   "background": "#FF99CC"
                              },
                              "itemId": "toolbar_ext_12703"
                         }],
                         "allowModify": true,
                         "header": {
                              "style": {
                                   "background": "#99CCFF"
                              },
                              "hidden": true
                         },
                         "itemId": "panel_ext_8445"
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
                    "itemId": "form_ext_7471"
               }],
               "border": 0,
               "title": "Address",
               "frame": false,
               "split": true,
               "isAccordionPane": true,
               "isAccordionLayoutItem": true,
               "dockedItems": [],
               "collapsed": true,
               "allowModify": true,
               "collapsible": true,
               "titleCollapse": true,
               "header": {
                    "style": {
                         "background": "#99CCFF"
                    }
               },
               "itemId": "panel_ext_7333"
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
          "itemId": "panel_ext_7295"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "dockedItems": [],
     "allowModify": true,
     "header": {
          "style": {
               "background": "#99CCFF"
          },
          "hidden": true
     },
     "itemId": "form_ext_7287",
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.GenderModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.RegisterDonorController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.RegisterDonorViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.RegisterDonorModel", "Bloodbankapp.view.fw.component.DateTimeField", "Bloodbankapp.view.fw.component.DateTimePicker"],
     "extend": "Ext.form.Panel",
     "viewModel": "RegisterDonorViewModel",
     "controller": "RegisterDonorController"
});