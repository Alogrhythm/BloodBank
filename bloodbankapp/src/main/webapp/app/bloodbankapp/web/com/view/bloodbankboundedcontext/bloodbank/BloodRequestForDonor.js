Ext.define('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodRequestForDonor', {
     "xtype": "bloodRequestForDonorView",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "gg",
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "25756F22-FD71-455D-952A-ABCD9D5B2FBF",
               "uiClass": "Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodRequestUi",
               "uiType": 2,
               "url": "secure/RequestDsWS/proRequestDs",
               "serviceId": "A4FF3FFA-AFEE-409A-A47A-6031A9B9A490",
               "serviceType": 3,
               "serviceOperationId": "E99FAC70-7340-4191-A31C-F6F2E67B1E14",
               "operationName": "proRequestDs",
               "operationDisplayName": "proRequestDs",
               "requestMethodType": "POST"
          },
          "padding": 0,
          "margin": 5,
          "dockedItems": [],
          "header": {
               "style": {
                    "background": "#FF99CC"
               }
          },
          "allowModify": true,
          "itemId": "panel_ext_10128"
     }],
     "border": true,
     "autoScroll": true,
     "margin": 5,
     "allowModify": true,
     "dockedItems": [],
     "header": {
          "style": {
               "background": "#FF99CC"
          }
     },
     "itemId": "form_ext_6230",
     "requires": ["Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.BloodRequestUi", "Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.BloodRequestForDonorController", "Bloodbankapp.bloodbankapp.shared.com.viewmodel.bloodbankboundedcontext.bloodbank.BloodRequestForDonorViewModel", "Bloodbankapp.bloodbankapp.shared.com.model.bloodbankboundedcontext.bloodbank.BloodRequestForDonorModel", "Bloodbankapp.view.fw.component.ListViewBaseView"],
     "extend": "Ext.form.Panel",
     "viewModel": "BloodRequestForDonorViewModel",
     "controller": "BloodRequestForDonorController"
});