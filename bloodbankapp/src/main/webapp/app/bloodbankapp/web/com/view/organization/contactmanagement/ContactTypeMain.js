Ext.define('Bloodbankapp.bloodbankapp.web.com.view.organization.contactmanagement.ContactTypeMain', {
     "xtype": "contactTypeMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ContactTypeMainController",
     "restURL": "/ContactType",
     "defaults": {
          "split": true
     },
     "requires": ["Bloodbankapp.bloodbankapp.shared.com.model.organization.contactmanagement.ContactTypeModel", "Bloodbankapp.bloodbankapp.web.com.controller.organization.contactmanagement.ContactTypeMainController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.organization.contactmanagement.ContactTypeViewModel"],
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
               "displayName": "Contact Type",
               "name": "ContactTypeTreeContainer",
               "itemId": "ContactTypeTreeContainer",
               "restURL": "/ContactType",
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
                    "itemId": "ContactTypeTree",
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
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type",
                         "fieldId": "7E453E20-405C-4243-BC71-7C1B40A82BC1",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bindable": "contactType"
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
                    "displayName": "Contact Type",
                    "title": "Contact Type",
                    "name": "ContactType",
                    "itemId": "ContactTypeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "contactTypeId",
                         "itemId": "contactTypeId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                         "fieldId": "9A40F431-85C2-4E9C-870C-312A27E8A265",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "contactTypeId"
                    }, {
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7E453E20-405C-4243-BC71-7C1B40A82BC1",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bindable": "contactType",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeDesc",
                         "itemId": "contactTypeDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Contact Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Description",
                         "fieldId": "F956B367-834C-44D3-BAA7-E6BF033ADE11",
                         "bindable": "contactTypeDesc",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeIcon",
                         "itemId": "contactTypeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Icon",
                         "fieldId": "085F0062-F54C-4C81-823D-1C4EBF0035C9",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "contactTypeIcon",
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
                         "fieldId": "31E43BA5-6680-470D-9D75-6F16B10F97EF",
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
                         "customId": 262,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 262,
                              "customId": 563
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 262,
                              "customId": 564,
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
                              "parentId": 262,
                              "customId": 565,
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
                    "displayName": "Contact Type",
                    "title": "Details Grid",
                    "name": "ContactTypeGrid",
                    "itemId": "ContactTypeGrid",
                    "restURL": "/ContactType",
                    "store": [],
                    "columns": [{
                         "header": "Contact Type Id",
                         "dataIndex": "contactTypeId",
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
                         "header": "Contact Type",
                         "dataIndex": "contactType",
                         "flex": 1
                    }, {
                         "header": "Contact Type Description",
                         "dataIndex": "contactTypeDesc",
                         "flex": 1
                    }, {
                         "header": "Contact Type Icon",
                         "dataIndex": "contactTypeIcon",
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
               "displayName": "Contact Type",
               "title": "Contact Type",
               "name": "ContactType",
               "itemId": "ContactTypeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "contactTypeId",
                    "itemId": "contactTypeId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                    "fieldId": "9A40F431-85C2-4E9C-870C-312A27E8A265",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "contactTypeId"
               }, {
                    "name": "contactType",
                    "itemId": "contactType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7E453E20-405C-4243-BC71-7C1B40A82BC1",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter contact type",
                    "bindable": "contactType",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeDesc",
                    "itemId": "contactTypeDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Contact Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Description",
                    "fieldId": "F956B367-834C-44D3-BAA7-E6BF033ADE11",
                    "bindable": "contactTypeDesc",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeIcon",
                    "itemId": "contactTypeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Icon",
                    "fieldId": "085F0062-F54C-4C81-823D-1C4EBF0035C9",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "contactTypeIcon",
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
                    "fieldId": "31E43BA5-6680-470D-9D75-6F16B10F97EF",
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
                    "customId": 262,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 262,
                         "customId": 563
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 262,
                         "customId": 564,
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
                         "parentId": 262,
                         "customId": 565,
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