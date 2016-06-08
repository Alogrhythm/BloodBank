Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodGroupMain', {
     "xtype": "bloodGroupMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "BloodGroupMainController",
     "restURL": "/BloodGroup",
     "defaults": {
          "split": true
     },
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodGroupModel", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.BloodGroupMainController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.BloodGroupViewModel"],
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
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Blood Group",
               "name": "BloodGroupTreeContainer",
               "itemId": "BloodGroupTreeContainer",
               "restURL": "/BloodGroup",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "BloodGroupTree",
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
                         "name": "bloodGroups",
                         "itemId": "bloodGroups",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Blood Group",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Blood Group",
                         "fieldId": "62946C82-0FA8-43AD-B30B-9107DD0945D5",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "bloodGroups"
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
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Blood Group",
                    "title": "Blood Group",
                    "name": "BloodGroup",
                    "itemId": "BloodGroupForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "bloodGroupId",
                         "itemId": "bloodGroupId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "bloodGroupId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "bloodGroupId<font color='red'> *<\/font>",
                         "fieldId": "0B49FA29-649B-42F7-AA96-7D7C1CF9F6A7",
                         "hidden": true,
                         "value": "",
                         "bindable": "bloodGroupId"
                    }, {
                         "name": "bloodGroups",
                         "itemId": "bloodGroups",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Blood Group",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Blood Group<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "62946C82-0FA8-43AD-B30B-9107DD0945D5",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "bloodGroups",
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
                         "fieldId": "85791AD4-D75B-44E4-89E5-1183E1EBEA02",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
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
                         "customId": 381,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 381,
                              "customId": 328
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 381,
                              "customId": 329,
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
                              "parentId": 381,
                              "customId": 330,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Blood Group",
                    "title": "Details Grid",
                    "name": "BloodGroupGrid",
                    "itemId": "BloodGroupGrid",
                    "restURL": "/BloodGroup",
                    "store": [],
                    "columns": [{
                         "header": "bloodGroupId",
                         "dataIndex": "bloodGroupId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Blood Group",
                         "dataIndex": "bloodGroups",
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
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Blood Group",
               "title": "Blood Group",
               "name": "BloodGroup",
               "itemId": "BloodGroupForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "bloodGroupId",
                    "itemId": "bloodGroupId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "bloodGroupId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "bloodGroupId<font color='red'> *<\/font>",
                    "fieldId": "0B49FA29-649B-42F7-AA96-7D7C1CF9F6A7",
                    "hidden": true,
                    "value": "",
                    "bindable": "bloodGroupId"
               }, {
                    "name": "bloodGroups",
                    "itemId": "bloodGroups",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Blood Group",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Blood Group<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "62946C82-0FA8-43AD-B30B-9107DD0945D5",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "bloodGroups",
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
                    "fieldId": "85791AD4-D75B-44E4-89E5-1183E1EBEA02",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
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
                    "customId": 381,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 381,
                         "customId": 328
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 381,
                         "customId": 329,
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
                         "parentId": 381,
                         "customId": 330,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});