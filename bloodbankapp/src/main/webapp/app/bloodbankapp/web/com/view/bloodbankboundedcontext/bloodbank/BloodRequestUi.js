Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodRequestUi', {
     "xtype": "bloodRequestUiView",
     "items": [{
          "xtype": "displayfield",
          "fieldLabel": "Require BG",
          "margin": 5,
          "bindable": "bloodGroups",
          "style": "word-break: break-word; word-wrap: break-word;",
          "name": "bloodGroups",
          "allowModify": true,
          "itemId": "displayfield_ext_6258"
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Requested By Dr.",
          "margin": 5,
          "bindable": "requestedByDoctor",
          "style": "word-break: break-word; word-wrap: break-word;",
          "name": "requestedByDoctor",
          "allowModify": true,
          "itemId": "displayfield_ext_6268"
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Date Needed By",
          "margin": 5,
          "bindable": "dateNeededBy",
          "style": "word-break: break-word; word-wrap: break-word;",
          "name": "dateNeededBy",
          "allowModify": true,
          "itemId": "displayfield_ext_6281"
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Units Of Blood",
          "margin": 5,
          "bindable": "noOfUnits",
          "style": "word-break: break-word; word-wrap: break-word;",
          "name": "noOfUnits",
          "allowModify": true,
          "itemId": "displayfield_ext_6295"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Blood Request",
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
               "itemId": "tbfill_ext_8638"
          }, {
               "xtype": "button",
               "name": "Accept",
               "text": "Accept",
               "margin": 5,
               "allowModify": true,
               "style": {
                    "background": "#800080"
               },
               "itemId": "button_ext_8594",
               "listeners": {
                    "click": "onAcceptClick"
               }
          }],
          "dockedItems": [],
          "allowModify": true,
          "style": {
               "background": "#FF99CC"
          },
          "itemId": "toolbar_ext_8575"
     }],
     "allowModify": true,
     "itemId": "form_ext_6248",
     "extend": "Ext.form.Panel",
     "requires": ["Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.BloodRequestUiController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.BloodRequestUiViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodRequestUiModel"],
     "viewModel": "BloodRequestUiViewModel",
     "controller": "BloodRequestUiController"
});