Ext.define('Bloodbankapp.bloodbankapp.web.com.view.organization.contactmanagement.CoreContactsMain', {
     "extend": "Ext.tab.Panel",
     "xtype": "coreContactsMainView",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CoreContactsMainController",
     "restURL": "/CoreContacts",
     "defaults": {
          "split": true
     },
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CoreContactsModel", "Bloodbankapp.bloodbankapp.web.com.controller.organization.contactmanagement.CoreContactsMainController", "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.TitleModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.LanguageModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.GenderModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.TimezoneModel", "Bloodbankapp.view.fw.component.Grids", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel", "Bloodbankapp.view.fw.component.Grids", "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationGroupModel", "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationTypeModel", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.organization.contactmanagement.CoreContactsViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Core Contacts",
               "name": "CoreContactsTreeContainer",
               "itemId": "CoreContactsTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CoreContactsTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Core Contacts",
                    "name": "CoreContacts",
                    "itemId": "CoreContactsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Contact Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "B70DB7FE-AB49-4D4D-ADBA-EF4A2E5B5DC7",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "contactId"
                              }, {
                                   "name": "titleId",
                                   "itemId": "titleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.TitleModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Title<font color='red'> *<\/font>",
                                   "fieldId": "0B307B99-59EA-4842-9B04-62033836DC55",
                                   "errorMessage": "Please enter title",
                                   "restURL": "Title",
                                   "bindable": "titleId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "firstName",
                                   "itemId": "firstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "First Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "15FFC34B-2C26-4217-9B34-2A10E05DC95C",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter First Name",
                                   "bindable": "firstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "middleName",
                                   "itemId": "middleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Middle Name",
                                   "fieldId": "39C8D0DA-6BC0-44F9-9296-B994D687B22D",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "middleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "lastName",
                                   "itemId": "lastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Last Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Last Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B82693CA-2950-4673-8FFA-1B56BC879F5D",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Last Name",
                                   "bindable": "lastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLanguageCode",
                                   "itemId": "nativeLanguageCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Language Code",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.LanguageModel"
                                   },
                                   "fieldLabel": "Native Language Code",
                                   "fieldId": "E805F58D-495E-40B1-A108-264C87D6D5CB",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Language",
                                   "bindable": "nativeLanguageCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeTitle",
                                   "itemId": "nativeTitle",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Title",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "fieldLabel": "Native Title",
                                   "fieldId": "6BC13506-69A9-432C-8F58-7121455177AF",
                                   "bindable": "nativeTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeFirstName",
                                   "itemId": "nativeFirstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native First Name",
                                   "fieldId": "069D5C85-02C5-4A7B-B943-5A7EFEE8E319",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeFirstName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeMiddleName",
                                   "itemId": "nativeMiddleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Middle Name",
                                   "fieldId": "7B602089-B8A4-4AD7-BC77-01DF50BEF3F8",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeMiddleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nativeLastName",
                                   "itemId": "nativeLastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native LastName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native LastName",
                                   "fieldId": "C50C386C-E056-47A7-8F63-A84F420DD8D1",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeLastName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "genderId",
                                   "itemId": "genderId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Gender",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.GenderModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Gender<font color='red'> *<\/font>",
                                   "fieldId": "6AF1513B-1349-49AC-8DC4-77AE66DDAD84",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Gender",
                                   "bindable": "genderId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateofbirth",
                                   "itemId": "dateofbirth",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "DOB",
                                   "fieldId": "7618DD58-EDFA-4D81-B612-A40E8D74615A",
                                   "errorMessage": "Please enter Date of birth",
                                   "bindable": "dateofbirth",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "age",
                                   "itemId": "age",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Age",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Age",
                                   "fieldId": "4758DCC2-AD9F-412E-BB61-9037F6C0B07E",
                                   "minValue": "0",
                                   "maxValue": "125",
                                   "bindable": "age",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "approximateDOB",
                                   "itemId": "approximateDOB",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Approx DOB",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Approx DOB",
                                   "fieldId": "C8EDE79B-4F5F-4CCA-8F6D-F25DC72098CD",
                                   "bindable": "approximateDOB",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "emailId",
                                   "itemId": "emailId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Email ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Email ID<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "1F2B918D-A5D4-476C-9C8C-81B7DFA95684",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Email ID",
                                   "bindable": "emailId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "phoneNumber",
                                   "itemId": "phoneNumber",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Phone Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "45CD3FE6-229B-4C4F-8312-0CB0F70F05C2",
                                   "minLength": "0",
                                   "maxLength": "20",
                                   "errorMessage": "Please enter Phone Number",
                                   "bindable": "phoneNumber",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "7EB9BEEF-A5AC-43F1-AE26-63E0C03740F0",
                                   "bindable": "versionId",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "Timezone",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "timezone.timeZoneId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Timezone<font color='red'> *<\/font>",
                                   "title": "Timezone",
                                   "itemId": "timezone",
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.TimezoneModel"
                                   }
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Address",
                         "title": "Address",
                         "name": "Address",
                         "itemId": "AddressForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "addressId",
                                        "itemId": "addressId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Id",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                        "fieldId": "EDC252FB-C286-4CAF-9691-A2C6251D02AE",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "address.addressId"
                                   }, {
                                        "name": "addressTypeId",
                                        "itemId": "addressTypeId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Address Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                        "fieldId": "76AE13E0-586D-4D7D-B8CC-B2F0FEB2EA95",
                                        "errorMessage": "Please enter valid Address type",
                                        "restURL": "AddressType",
                                        "bindable": "address.addressTypeId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "addressLabel",
                                        "itemId": "addressLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Label",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Label",
                                        "fieldId": "BA81B194-2AFF-4807-B291-0AAFF05D87F8",
                                        "minLength": "0",
                                        "maxLength": "11",
                                        "bindable": "address.addressLabel",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address1",
                                        "itemId": "address1",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address1",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address1",
                                        "fieldId": "F79D714E-0717-49D1-A7C9-06EE3EAD7A16",
                                        "bindable": "address.address1",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address2",
                                        "itemId": "address2",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address2",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address2",
                                        "fieldId": "E9D1CA04-3EF6-4FEC-A0FF-09D43757E51F",
                                        "bindable": "address.address2",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address3",
                                        "itemId": "address3",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address3",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address3",
                                        "fieldId": "4D01C889-0A9C-404F-8BD6-7EA9F725AEA1",
                                        "bindable": "address.address3",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "countryId",
                                        "itemId": "countryId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Country<font color='red'> *<\/font>",
                                        "fieldId": "237A83E7-524E-4917-BC96-01FF8077D48A",
                                        "errorMessage": "Please enter Country",
                                        "restURL": "Country",
                                        "bindable": "address.countryId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCountryIdChange"
                                        }
                                   }, {
                                        "name": "stateId",
                                        "itemId": "stateId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "State",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "State<font color='red'> *<\/font>",
                                        "fieldId": "D5513459-5AFE-41AD-BF79-3BA2CC6E4D89",
                                        "errorMessage": "Please enter State",
                                        "restURL": "State",
                                        "bindable": "address.stateId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onStateIdChange"
                                        }
                                   }, {
                                        "name": "cityId",
                                        "itemId": "cityId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "City<font color='red'> *<\/font>",
                                        "fieldId": "B77E9469-1D3D-4CF8-9385-5DB4D7F8F3D7",
                                        "errorMessage": "Please enter City",
                                        "restURL": "City",
                                        "bindable": "address.cityId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "zipcode",
                                        "itemId": "zipcode",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Postal Code",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "3D44A719-F556-4C52-A8B3-6C2CE0407B3C",
                                        "minLength": "0",
                                        "maxLength": "6",
                                        "errorMessage": "Please enter postal code",
                                        "bindable": "address.zipcode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "latitude",
                                        "itemId": "latitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Latitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Latitude",
                                        "fieldId": "83DF0DE2-9E9A-4EA2-A73A-3B1E9BBC4E83",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.latitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "longitude",
                                        "itemId": "longitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Longitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Longitude",
                                        "fieldId": "D08979D5-BC8A-48E8-BC82-C2314E0A6E33",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.longitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "versionId",
                                        "itemId": "versionId",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "versionId",
                                        "margin": "5 5 5 5",
                                        "value": "-1",
                                        "fieldLabel": "versionId",
                                        "fieldId": "7230D548-56E0-42B4-B95D-3E7F8A146185",
                                        "bindable": "address.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "margin": 5,
                              "customWidgetType": "vdButton",
                              "maxWidth": 132,
                              "text": "Add Address",
                              "handler": "addAddress"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "Address",
                              "columnWidth": 1,
                              "itemId": "AddressGrid",
                              "fieldLabel": "List",
                              "bindLevel": "address",
                              "bindable": "address",
                              "listeners": {
                                   "select": "onAddressGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Address Id",
                                   "text": "Address Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Address Type",
                                   "text": "Address Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressTypeId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Address Label",
                                   "text": "Address Label",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressLabel",
                                   "flex": 1
                              }, {
                                   "header": "Address1",
                                   "text": "Address1",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address1",
                                   "flex": 1
                              }, {
                                   "header": "Address2",
                                   "text": "Address2",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address2",
                                   "flex": 1
                              }, {
                                   "header": "Address3",
                                   "text": "Address3",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address3",
                                   "flex": 1
                              }, {
                                   "header": "Country",
                                   "text": "Country",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "countryId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "State",
                                   "text": "State",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "stateId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "City",
                                   "text": "City",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "cityId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Postal Code",
                                   "text": "Postal Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "zipcode",
                                   "flex": 1
                              }, {
                                   "header": "Latitude",
                                   "text": "Latitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "latitude",
                                   "flex": 1
                              }, {
                                   "header": "Longitude",
                                   "text": "Longitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "longitude",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "txnAccessCode",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "xtype": "actioncolumn",
                                   "customWidgetType": "vdActionColumn",
                                   "width": 30,
                                   "sortable": false,
                                   "menuDisable": true,
                                   "items": [{
                                        "icon": "images/delete.gif",
                                        "tooltip": "Delete Record",
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Communication Data",
                         "title": "Communication Data",
                         "name": "CommunicationData",
                         "itemId": "CommunicationDataForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "commDataId",
                                        "itemId": "commDataId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "commType",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "commType<font color='red'> *<\/font>",
                                        "fieldId": "5EF82D16-D8B6-4B4F-8093-45E288CC3558",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "communicationData.commDataId"
                                   }, {
                                        "name": "commGroupId",
                                        "itemId": "commGroupId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Group",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationGroupModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                        "fieldId": "7E216B26-A92A-4CED-B456-835B5E604EB2",
                                        "restURL": "CommunicationGroup",
                                        "bindable": "communicationData.commGroupId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCommGroupIdChange"
                                        }
                                   }, {
                                        "name": "commType",
                                        "itemId": "commType",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Type",
                                        "margin": "5 5 5 5",
                                        "valueField": "primaryKey",
                                        "displayField": "primaryDisplay",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                        "fieldId": "1D28478F-0806-4B5D-9189-517B10153B5D",
                                        "restURL": "CommunicationType",
                                        "bindable": "communicationData.commType",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "commData",
                                        "itemId": "commData",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Communication Data",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "68A0E30F-7D66-4192-8CAA-6528C6734833",
                                        "minLength": "10",
                                        "errorMessage": "please enter communication details",
                                        "bindable": "communicationData.commData",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "versionId",
                                        "itemId": "versionId",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "versionId",
                                        "margin": "5 5 5 5",
                                        "value": "-1",
                                        "fieldLabel": "versionId",
                                        "fieldId": "76EAE2F3-3F26-4851-8049-E97A4E2CBCAE",
                                        "bindable": "communicationData.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "margin": 5,
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add CommunicationData",
                              "handler": "addCommunicationData"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "CommunicationData",
                              "columnWidth": 1,
                              "itemId": "CommunicationDataGrid",
                              "fieldLabel": "List",
                              "bindLevel": "communicationData",
                              "bindable": "communicationData",
                              "listeners": {
                                   "select": "onCommunicationDataGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "commType",
                                   "text": "commType",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commDataId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Communication Group",
                                   "text": "Communication Group",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commGroupId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Type",
                                   "text": "Communication Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commType",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Data",
                                   "text": "Communication Data",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commData",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "txnAccessCode",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "xtype": "actioncolumn",
                                   "customWidgetType": "vdActionColumn",
                                   "width": 30,
                                   "sortable": false,
                                   "menuDisable": true,
                                   "items": [{
                                        "icon": "images/delete.gif",
                                        "tooltip": "Delete Record",
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
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
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": 5,
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Core Contacts",
                    "title": "Details Grid",
                    "name": "CoreContactsGrid",
                    "itemId": "CoreContactsGrid",
                    "store": [],
                    "requires": [],
                    "columns": [{
                         "header": "Contact Id",
                         "dataIndex": "contactId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Title",
                         "dataIndex": "titleId",
                         "flex": 1
                    }, {
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "Middle Name",
                         "dataIndex": "middleName",
                         "flex": 1
                    }, {
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Native Language Code",
                         "dataIndex": "nativeLanguageCode",
                         "flex": 1
                    }, {
                         "header": "Native Title",
                         "dataIndex": "nativeTitle",
                         "flex": 1
                    }, {
                         "header": "Native First Name",
                         "dataIndex": "nativeFirstName",
                         "flex": 1
                    }, {
                         "header": "Native Middle Name",
                         "dataIndex": "nativeMiddleName",
                         "flex": 1
                    }, {
                         "header": "Native LastName",
                         "dataIndex": "nativeLastName",
                         "flex": 1
                    }, {
                         "header": "Gender",
                         "dataIndex": "genderId",
                         "flex": 1
                    }, {
                         "header": "DOB",
                         "dataIndex": "dateofbirth",
                         "flex": 1
                    }, {
                         "header": "Age",
                         "dataIndex": "age",
                         "flex": 1
                    }, {
                         "header": "Approx DOB",
                         "dataIndex": "approximateDOB",
                         "flex": 1
                    }, {
                         "header": "Email ID",
                         "dataIndex": "emailId",
                         "flex": 1
                    }, {
                         "header": "Phone Number",
                         "dataIndex": "phoneNumber",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Core Contacts",
               "name": "CoreContacts",
               "itemId": "CoreContactsForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "contactId",
                              "itemId": "contactId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Contact Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                              "fieldId": "B70DB7FE-AB49-4D4D-ADBA-EF4A2E5B5DC7",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "contactId"
                         }, {
                              "name": "titleId",
                              "itemId": "titleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.TitleModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Title<font color='red'> *<\/font>",
                              "fieldId": "0B307B99-59EA-4842-9B04-62033836DC55",
                              "errorMessage": "Please enter title",
                              "restURL": "Title",
                              "bindable": "titleId",
                              "columnWidth": 0.5
                         }, {
                              "name": "firstName",
                              "itemId": "firstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "First Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "15FFC34B-2C26-4217-9B34-2A10E05DC95C",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter First Name",
                              "bindable": "firstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "middleName",
                              "itemId": "middleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Middle Name",
                              "fieldId": "39C8D0DA-6BC0-44F9-9296-B994D687B22D",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "middleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "lastName",
                              "itemId": "lastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Last Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Last Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B82693CA-2950-4673-8FFA-1B56BC879F5D",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Last Name",
                              "bindable": "lastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLanguageCode",
                              "itemId": "nativeLanguageCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Language Code",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.LanguageModel"
                              },
                              "fieldLabel": "Native Language Code",
                              "fieldId": "E805F58D-495E-40B1-A108-264C87D6D5CB",
                              "errorMessage": "Please enter gender",
                              "restURL": "Language",
                              "bindable": "nativeLanguageCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeTitle",
                              "itemId": "nativeTitle",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Title",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "fieldLabel": "Native Title",
                              "fieldId": "6BC13506-69A9-432C-8F58-7121455177AF",
                              "bindable": "nativeTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeFirstName",
                              "itemId": "nativeFirstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native First Name",
                              "fieldId": "069D5C85-02C5-4A7B-B943-5A7EFEE8E319",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeFirstName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeMiddleName",
                              "itemId": "nativeMiddleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Middle Name",
                              "fieldId": "7B602089-B8A4-4AD7-BC77-01DF50BEF3F8",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeMiddleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "nativeLastName",
                              "itemId": "nativeLastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native LastName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native LastName",
                              "fieldId": "C50C386C-E056-47A7-8F63-A84F420DD8D1",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeLastName",
                              "columnWidth": 0.5
                         }, {
                              "name": "genderId",
                              "itemId": "genderId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Gender",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.GenderModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Gender<font color='red'> *<\/font>",
                              "fieldId": "6AF1513B-1349-49AC-8DC4-77AE66DDAD84",
                              "errorMessage": "Please enter gender",
                              "restURL": "Gender",
                              "bindable": "genderId",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateofbirth",
                              "itemId": "dateofbirth",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "DOB",
                              "fieldId": "7618DD58-EDFA-4D81-B612-A40E8D74615A",
                              "errorMessage": "Please enter Date of birth",
                              "bindable": "dateofbirth",
                              "columnWidth": 0.5
                         }, {
                              "name": "age",
                              "itemId": "age",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Age",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Age",
                              "fieldId": "4758DCC2-AD9F-412E-BB61-9037F6C0B07E",
                              "minValue": "0",
                              "maxValue": "125",
                              "bindable": "age",
                              "columnWidth": 0.5
                         }, {
                              "name": "approximateDOB",
                              "itemId": "approximateDOB",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Approx DOB",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Approx DOB",
                              "fieldId": "C8EDE79B-4F5F-4CCA-8F6D-F25DC72098CD",
                              "bindable": "approximateDOB",
                              "columnWidth": 0.5
                         }, {
                              "name": "emailId",
                              "itemId": "emailId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Email ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Email ID<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "1F2B918D-A5D4-476C-9C8C-81B7DFA95684",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Email ID",
                              "bindable": "emailId",
                              "columnWidth": 0.5
                         }, {
                              "name": "phoneNumber",
                              "itemId": "phoneNumber",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Phone Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "45CD3FE6-229B-4C4F-8312-0CB0F70F05C2",
                              "minLength": "0",
                              "maxLength": "20",
                              "errorMessage": "Please enter Phone Number",
                              "bindable": "phoneNumber",
                              "columnWidth": 0.5
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "7EB9BEEF-A5AC-43F1-AE26-63E0C03740F0",
                              "bindable": "versionId",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "Timezone",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "timezone.timeZoneId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Timezone<font color='red'> *<\/font>",
                              "title": "Timezone",
                              "itemId": "timezone",
                              "store": {
                                   "data": [],
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.TimezoneModel"
                              }
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Address",
                    "title": "Address",
                    "name": "Address",
                    "itemId": "AddressForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "addressId",
                                   "itemId": "addressId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Id<font color='red'> *<\/font>",
                                   "fieldId": "EDC252FB-C286-4CAF-9691-A2C6251D02AE",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "address.addressId"
                              }, {
                                   "name": "addressTypeId",
                                   "itemId": "addressTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Address Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.AddressTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                   "fieldId": "76AE13E0-586D-4D7D-B8CC-B2F0FEB2EA95",
                                   "errorMessage": "Please enter valid Address type",
                                   "restURL": "AddressType",
                                   "bindable": "address.addressTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "addressLabel",
                                   "itemId": "addressLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Label",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Label",
                                   "fieldId": "BA81B194-2AFF-4807-B291-0AAFF05D87F8",
                                   "minLength": "0",
                                   "maxLength": "11",
                                   "bindable": "address.addressLabel",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address1",
                                   "itemId": "address1",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address1",
                                   "fieldId": "F79D714E-0717-49D1-A7C9-06EE3EAD7A16",
                                   "bindable": "address.address1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address2",
                                   "itemId": "address2",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address2",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address2",
                                   "fieldId": "E9D1CA04-3EF6-4FEC-A0FF-09D43757E51F",
                                   "bindable": "address.address2",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address3",
                                   "itemId": "address3",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address3",
                                   "fieldId": "4D01C889-0A9C-404F-8BD6-7EA9F725AEA1",
                                   "bindable": "address.address3",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "countryId",
                                   "itemId": "countryId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CountryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Country<font color='red'> *<\/font>",
                                   "fieldId": "237A83E7-524E-4917-BC96-01FF8077D48A",
                                   "errorMessage": "Please enter Country",
                                   "restURL": "Country",
                                   "bindable": "address.countryId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCountryIdChange"
                                   }
                              }, {
                                   "name": "stateId",
                                   "itemId": "stateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "State",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.StateModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "State<font color='red'> *<\/font>",
                                   "fieldId": "D5513459-5AFE-41AD-BF79-3BA2CC6E4D89",
                                   "errorMessage": "Please enter State",
                                   "restURL": "State",
                                   "bindable": "address.stateId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "name": "cityId",
                                   "itemId": "cityId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.locationmanagement.CityModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "City<font color='red'> *<\/font>",
                                   "fieldId": "B77E9469-1D3D-4CF8-9385-5DB4D7F8F3D7",
                                   "errorMessage": "Please enter City",
                                   "restURL": "City",
                                   "bindable": "address.cityId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "zipcode",
                                   "itemId": "zipcode",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Postal Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "3D44A719-F556-4C52-A8B3-6C2CE0407B3C",
                                   "minLength": "0",
                                   "maxLength": "6",
                                   "errorMessage": "Please enter postal code",
                                   "bindable": "address.zipcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "latitude",
                                   "itemId": "latitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Latitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Latitude",
                                   "fieldId": "83DF0DE2-9E9A-4EA2-A73A-3B1E9BBC4E83",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.latitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "longitude",
                                   "itemId": "longitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Longitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Longitude",
                                   "fieldId": "D08979D5-BC8A-48E8-BC82-C2314E0A6E33",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.longitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "7230D548-56E0-42B4-B95D-3E7F8A146185",
                                   "bindable": "address.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "margin": 5,
                         "customWidgetType": "vdButton",
                         "maxWidth": 132,
                         "text": "Add Address",
                         "handler": "addAddress"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "Address",
                         "columnWidth": 1,
                         "itemId": "AddressGrid",
                         "fieldLabel": "List",
                         "bindLevel": "address",
                         "bindable": "address",
                         "listeners": {
                              "select": "onAddressGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Address Id",
                              "text": "Address Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Address Type",
                              "text": "Address Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressTypeId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Address Label",
                              "text": "Address Label",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressLabel",
                              "flex": 1
                         }, {
                              "header": "Address1",
                              "text": "Address1",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address1",
                              "flex": 1
                         }, {
                              "header": "Address2",
                              "text": "Address2",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address2",
                              "flex": 1
                         }, {
                              "header": "Address3",
                              "text": "Address3",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address3",
                              "flex": 1
                         }, {
                              "header": "Country",
                              "text": "Country",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "countryId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "State",
                              "text": "State",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "stateId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "City",
                              "text": "City",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "cityId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "zipcode",
                              "flex": 1
                         }, {
                              "header": "Latitude",
                              "text": "Latitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "latitude",
                              "flex": 1
                         }, {
                              "header": "Longitude",
                              "text": "Longitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "longitude",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "txnAccessCode",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "xtype": "actioncolumn",
                              "customWidgetType": "vdActionColumn",
                              "width": 30,
                              "sortable": false,
                              "menuDisable": true,
                              "items": [{
                                   "icon": "images/delete.gif",
                                   "tooltip": "Delete Record",
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Communication Data",
                    "title": "Communication Data",
                    "name": "CommunicationData",
                    "itemId": "CommunicationDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "commDataId",
                                   "itemId": "commDataId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "commType",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "commType<font color='red'> *<\/font>",
                                   "fieldId": "5EF82D16-D8B6-4B4F-8093-45E288CC3558",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "communicationData.commDataId"
                              }, {
                                   "name": "commGroupId",
                                   "itemId": "commGroupId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Group",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationGroupModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                   "fieldId": "7E216B26-A92A-4CED-B456-835B5E604EB2",
                                   "restURL": "CommunicationGroup",
                                   "bindable": "communicationData.commGroupId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCommGroupIdChange"
                                   }
                              }, {
                                   "name": "commType",
                                   "itemId": "commType",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.CommunicationTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                   "fieldId": "1D28478F-0806-4B5D-9189-517B10153B5D",
                                   "restURL": "CommunicationType",
                                   "bindable": "communicationData.commType",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "commData",
                                   "itemId": "commData",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Communication Data",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "68A0E30F-7D66-4192-8CAA-6528C6734833",
                                   "minLength": "10",
                                   "errorMessage": "please enter communication details",
                                   "bindable": "communicationData.commData",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "76EAE2F3-3F26-4851-8049-E97A4E2CBCAE",
                                   "bindable": "communicationData.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "margin": 5,
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add CommunicationData",
                         "handler": "addCommunicationData"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "CommunicationData",
                         "columnWidth": 1,
                         "itemId": "CommunicationDataGrid",
                         "fieldLabel": "List",
                         "bindLevel": "communicationData",
                         "bindable": "communicationData",
                         "listeners": {
                              "select": "onCommunicationDataGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "commType",
                              "text": "commType",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commDataId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commGroupId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commType",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commData",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "txnAccessCode",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "xtype": "actioncolumn",
                              "customWidgetType": "vdActionColumn",
                              "width": 30,
                              "sortable": false,
                              "menuDisable": true,
                              "items": [{
                                   "icon": "images/delete.gif",
                                   "tooltip": "Delete Record",
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
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
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": 5,
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});