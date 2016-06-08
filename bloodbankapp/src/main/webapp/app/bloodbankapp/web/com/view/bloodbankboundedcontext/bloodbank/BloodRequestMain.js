Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodRequestMain', {
     "extend": "Ext.tab.Panel",
     "xtype": "bloodRequestMainView",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "BloodRequestMainController",
     "restURL": "/BloodRequest",
     "defaults": {
          "split": true
     },
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodRequestModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.BloodRequestMainController", "Bloodbankapp.view.fw.component.DateTimeField", "Bloodbankapp.view.fw.component.DateTimePicker", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.BloodRequestViewModel"],
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
               "displayName": "Blood Request",
               "name": "BloodRequestTreeContainer",
               "itemId": "BloodRequestTreeContainer",
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
                    "itemId": "BloodRequestTree",
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
                    "items": [{
                         "name": "noOfUnits",
                         "itemId": "noOfUnits",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No Of Units",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No Of Units",
                         "fieldId": "CFE6FC0C-D777-4DD2-8EDF-14700DA543D6",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "noOfUnits"
                    }, {
                         "name": "bldg",
                         "itemId": "bldg",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Blood Group",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel"
                         },
                         "fieldLabel": "Blood Group",
                         "fieldId": "B64D24BB-0246-4241-B923-AF0E5CFCEB1C",
                         "restURL": "BloodGroup",
                         "bindable": "bldg"
                    }]
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
                    "displayName": "Blood Request",
                    "name": "BloodRequest",
                    "itemId": "BloodRequestForm",
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
                                   "name": "bloodRequestId",
                                   "itemId": "bloodRequestId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "BloodRequestId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "BloodRequestId<font color='red'> *<\/font>",
                                   "fieldId": "0E0365F5-77EC-4206-AD08-52BBC948B293",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "bloodRequestId"
                              }, {
                                   "name": "noOfUnits",
                                   "itemId": "noOfUnits",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "No Of Units",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "No Of Units<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CFE6FC0C-D777-4DD2-8EDF-14700DA543D6",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "noOfUnits",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "patientName",
                                   "itemId": "patientName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Patient Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Patient Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "6C54BB5A-3131-4C98-AA0F-3CA179038E85",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "patientName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "requestedByDoctor",
                                   "itemId": "requestedByDoctor",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Requested By Doctor",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Requested By Doctor<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E400353A-AB9C-4AAF-8F6D-4F458BD4D28F",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "requestedByDoctor",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "requestedByHospital",
                                   "itemId": "requestedByHospital",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Requested By Hospital",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Requested By Hospital<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "34B69F94-F9E4-4E58-8AA1-1E75A1574A95",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "requestedByHospital",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateNeededBy",
                                   "itemId": "dateNeededBy",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "customdatetimefield",
                                   "displayName": "Date Needed By",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Date Needed By<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EDB673B1-456A-4EEB-9EE0-A439B67CDE3D",
                                   "bindable": "dateNeededBy",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dispatchedToPatientOn",
                                   "itemId": "dispatchedToPatientOn",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "customdatetimefield",
                                   "displayName": "Dispatched To Patient On DT",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Dispatched To Patient On DT<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B76D244A-C1F3-49F8-A439-91556E85E18E",
                                   "bindable": "dispatchedToPatientOn",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "bldg",
                                   "itemId": "bldg",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Blood Group",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Blood Group<font color='red'> *<\/font>",
                                   "fieldId": "B64D24BB-0246-4241-B923-AF0E5CFCEB1C",
                                   "restURL": "BloodGroup",
                                   "bindable": "bldg",
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
                                   "fieldId": "3D975121-2AC0-4C82-B3F2-B08C9DE70090",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
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
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Blood Request",
                    "title": "Details Grid",
                    "name": "BloodRequestGrid",
                    "itemId": "BloodRequestGrid",
                    "store": [],
                    "requires": [],
                    "columns": [{
                         "header": "BloodRequestId",
                         "dataIndex": "bloodRequestId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "No Of Units",
                         "dataIndex": "noOfUnits",
                         "flex": 1
                    }, {
                         "header": "Patient Name",
                         "dataIndex": "patientName",
                         "flex": 1
                    }, {
                         "header": "Requested By Doctor",
                         "dataIndex": "requestedByDoctor",
                         "flex": 1
                    }, {
                         "header": "Requested By Hospital",
                         "dataIndex": "requestedByHospital",
                         "flex": 1
                    }, {
                         "header": "Date Needed By",
                         "dataIndex": "dateNeededBy",
                         "flex": 1
                    }, {
                         "header": "Dispatched To Patient On DT",
                         "dataIndex": "dispatchedToPatientOn",
                         "flex": 1
                    }, {
                         "header": "Blood Group",
                         "dataIndex": "bldg",
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
               "displayName": "Blood Request",
               "name": "BloodRequest",
               "itemId": "BloodRequestForm",
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
                              "name": "bloodRequestId",
                              "itemId": "bloodRequestId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "BloodRequestId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "BloodRequestId<font color='red'> *<\/font>",
                              "fieldId": "0E0365F5-77EC-4206-AD08-52BBC948B293",
                              "hidden": true,
                              "value": "",
                              "bindable": "bloodRequestId"
                         }, {
                              "name": "noOfUnits",
                              "itemId": "noOfUnits",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "No Of Units",
                              "margin": "5 5 5 5",
                              "fieldLabel": "No Of Units<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "CFE6FC0C-D777-4DD2-8EDF-14700DA543D6",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "noOfUnits",
                              "columnWidth": 0.5
                         }, {
                              "name": "patientName",
                              "itemId": "patientName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Patient Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Patient Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "6C54BB5A-3131-4C98-AA0F-3CA179038E85",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "patientName",
                              "columnWidth": 0.5
                         }, {
                              "name": "requestedByDoctor",
                              "itemId": "requestedByDoctor",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Requested By Doctor",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Requested By Doctor<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E400353A-AB9C-4AAF-8F6D-4F458BD4D28F",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "requestedByDoctor",
                              "columnWidth": 0.5
                         }, {
                              "name": "requestedByHospital",
                              "itemId": "requestedByHospital",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Requested By Hospital",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Requested By Hospital<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "34B69F94-F9E4-4E58-8AA1-1E75A1574A95",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "requestedByHospital",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateNeededBy",
                              "itemId": "dateNeededBy",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "customdatetimefield",
                              "displayName": "Date Needed By",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Date Needed By<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "EDB673B1-456A-4EEB-9EE0-A439B67CDE3D",
                              "bindable": "dateNeededBy",
                              "columnWidth": 0.5
                         }, {
                              "name": "dispatchedToPatientOn",
                              "itemId": "dispatchedToPatientOn",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "customdatetimefield",
                              "displayName": "Dispatched To Patient On DT",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Dispatched To Patient On DT<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B76D244A-C1F3-49F8-A439-91556E85E18E",
                              "bindable": "dispatchedToPatientOn",
                              "columnWidth": 0.5
                         }, {
                              "name": "bldg",
                              "itemId": "bldg",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Blood Group",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Blood Group<font color='red'> *<\/font>",
                              "fieldId": "B64D24BB-0246-4241-B923-AF0E5CFCEB1C",
                              "restURL": "BloodGroup",
                              "bindable": "bldg",
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
                              "fieldId": "3D975121-2AC0-4C82-B3F2-B08C9DE70090",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
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
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});