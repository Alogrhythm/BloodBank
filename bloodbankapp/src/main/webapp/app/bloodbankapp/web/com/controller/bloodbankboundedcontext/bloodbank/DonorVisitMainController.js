Ext.define('Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.DonorVisitMainController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.RegistrationViewController',
     alias: 'controller.DonorVisitMainController',
     init: function() {
          this.donorLoad();
          this.dTypeLoad();
          this.campLoad();
     },
     donorLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/RegisterADonor/findAll',
               method: 'GET',
               async: false,
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#donor');
                    var storedata = Ext.JSON.decode(response.responseText);
                    storedata = storedata.response.data;
                    var myStore = Ext.create('Ext.data.Store', {
                         fields: [],
                         data: storedata,
                         autoLoad: true
                    });
                    compRef.setStore(myStore);
                    compRef.getStore().sort('primaryDisplay', 'ASC');
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#donor');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     dTypeLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/DonationType/findAll',
               method: 'GET',
               async: false,
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#dType');
                    var storedata = Ext.JSON.decode(response.responseText);
                    storedata = storedata.response.data;
                    var myStore = Ext.create('Ext.data.Store', {
                         fields: [],
                         data: storedata,
                         autoLoad: true
                    });
                    compRef.setStore(myStore);
                    compRef.getStore().sort('primaryDisplay', 'ASC');
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#dType');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     campLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/RegisterACamp/findAll',
               method: 'GET',
               async: false,
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#camp');
                    var storedata = Ext.JSON.decode(response.responseText);
                    storedata = storedata.response.data;
                    var myStore = Ext.create('Ext.data.Store', {
                         fields: [],
                         data: storedata,
                         autoLoad: true
                    });
                    compRef.setStore(myStore);
                    compRef.getStore().sort('primaryDisplay', 'ASC');
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#camp');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     afterFormRender: function(view) {
          if (view.primaryKey != null) {
               this.findById(view.primaryKey);
          }
     },
     resetForm: function(but) {
          if (!but) {
               but = this.view.down('#resetFormButton');
          }
          var form = but.up('form');
          form.down('#saveFormButton').setText('Save');
          form.reset();
     },
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               maskEnable: true,
               maskEle: me.view,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         me.loadData(responseText);
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, opts) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
     loadData: function(responseData) {
          var formPanel = this.getView().up().down('#DonorVisitForm');
          this.modifyComponents(responseData, formPanel);
     },
     onDeleteActionColumnClick: function(grid, rowIndex) {
          grid.store.removeAt(rowIndex);
     },
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          var firstCard = form.down('#form0');
          if (!firstCard.getForm().isValid()) {
               this.showCard(form, firstCard);
               return;
          }
          var ClinicalInfoForm = form.down('#ClinicalInfoForm');
          if (!ClinicalInfoForm.isValid()) {
               this.showCard(form, ClinicalInfoForm);
          }
          var jsonData = this.getData(form);
          var method;
          if (but.text == 'Save') {
               method = 'POST'
          } else if (but.text == 'Update') {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               jsonData: jsonData,
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         me.resetForm();
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    me.addCommunicationLog(response, false);
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
});