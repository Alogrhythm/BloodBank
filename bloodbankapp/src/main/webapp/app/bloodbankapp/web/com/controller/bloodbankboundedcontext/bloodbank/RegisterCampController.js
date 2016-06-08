Ext.define('Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.RegisterCampController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.RegisterCampController',
     onGoAddClick: function(me, e, eOpts) {
          var panel_ext_16228 = this.view.down('#panel_ext_16228');
          panel_ext_16228.expand();
     },
     onStateChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_18352').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/City/findByStateId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_18507 = scope.sender.down('#combo_ext_18507');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_18507, 'cityName', 'cityId');
                    } else if (!sessionTimeOutFlag) {
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         scope.sender.controller.responseHandler(responseText);
                    }
               }
          }, scope);
     },
     onResetClick: function(me, e, eOpts) {
          this.view.down('#textfield_ext_16689').reset();
          this.view.down('#textfield_ext_16731').reset();
          this.view.down('#textfield_ext_16775').reset();
          this.view.down('#customdatetimefield_ext_16821').reset();
          this.view.down('#numberfield_ext_16919').reset();
          this.view.down('#customdatetimefield_ext_16869').reset();
          this.view.down('#numberfield_ext_17074').reset();
          this.view.down('#textfield_ext_17128').reset();
          this.view.down('#numberfield_ext_17184').reset();
          this.view.down('#textfield_ext_18130').reset();
          this.view.down('#combo_ext_18272').reset();
          this.view.down('#combo_ext_18429').reset();
          this.view.down('#combo_ext_18352').reset();
          this.view.down('#textfield_ext_18200').reset();
          this.view.down('#combo_ext_18507').reset();
     },
     onCountryChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_18272').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/State/findByCountryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_18352 = scope.sender.down('#combo_ext_18352');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_18352, 'stateName', 'stateId');
                    } else if (!sessionTimeOutFlag) {
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         scope.sender.controller.responseHandler(responseText);
                    }
               }
          }, scope);
     },
     onRegisterClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_17128'), this.view.down('#textfield_ext_16689'), this.view.down('#textfield_ext_16731'), this.view.down('#textfield_ext_16775'), this.view.down('#customdatetimefield_ext_16821'), this.view.down('#customdatetimefield_ext_16869'), this.view.down('#numberfield_ext_16919'), this.view.down('#numberfield_ext_17074'), this.view.down('#numberfield_ext_17184'), this.view.down('#combo_ext_18429'), this.view.down('#combo_ext_18272'), this.view.down('#combo_ext_18352'), this.view.down('#combo_ext_18507'), this.view.down('#textfield_ext_18200')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.campTime = this.view.down('#textfield_ext_17128').getValue();
          jsonData.organisationName = this.view.down('#textfield_ext_16689').getValue();
          jsonData.reasonForCamp = this.view.down('#textfield_ext_16731').getValue();
          jsonData.bloodBankName = this.view.down('#textfield_ext_16775').getValue();
          jsonData.fromDate = this.view.down('#customdatetimefield_ext_16821').getValues();
          jsonData.toDate = this.view.down('#customdatetimefield_ext_16869').getValues();
          jsonData.noOfDonorsExpected = this.view.down('#numberfield_ext_16919').getValue();
          jsonData.noOfDonorsArrived = this.view.down('#numberfield_ext_17074').getValue();
          jsonData.noOfDonorsThatBled = this.view.down('#numberfield_ext_17184').getValue();
          jsonData.addressType = this.view.down('#combo_ext_18429').getValue();
          jsonData.country = this.view.down('#combo_ext_18272').getValue();
          jsonData.state = this.view.down('#combo_ext_18352').getValue();
          jsonData.city = this.view.down('#combo_ext_18507').getValue();
          jsonData.postalCode = this.view.down('#textfield_ext_18200').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/RegCampDsWS/proRegCampDs',
               async: false,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', 'Camp Registered Successfuly');
                    } else if (!sessionTimeOutFlag) {
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         scope.sender.controller.responseHandler(responseText);
                    }
               }
          }, scope);
     }
});