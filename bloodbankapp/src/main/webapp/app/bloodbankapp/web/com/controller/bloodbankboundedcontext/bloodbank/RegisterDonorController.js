Ext.define('Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.RegisterDonorController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.RegisterDonorController',
     onGoAddClick: function(me, e, eOpts) {
          var panel_ext_7333 = this.view.down('#panel_ext_7333');
          panel_ext_7333.expand();
     },
     onStateChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_8805').getValue();
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
                         var combo_ext_8937 = scope.sender.down('#combo_ext_8937');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_8937, 'cityName', 'cityId');
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
          this.view.down('#textfield_ext_7765').reset();
          this.view.down('#customdatetimefield_ext_7807').reset();
          this.view.down('#textfield_ext_7851').reset();
          this.view.down('#textfield_ext_7897').reset();
          this.view.down('#combo_ext_8047').reset();
          this.view.down('#numberfield_ext_7995').reset();
          this.view.down('#combo_ext_8101').reset();
          this.view.down('#customdatetimefield_ext_7945').reset();
          this.view.down('#textfield_ext_8622').reset();
          this.view.down('#combo_ext_8742').reset();
          this.view.down('#textfield_ext_8681').reset();
          this.view.down('#combo_ext_8805').reset();
          this.view.down('#combo_ext_8870').reset();
          this.view.down('#combo_ext_8937').reset();
     },
     onCountryChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_8742').getValue();
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
                         var combo_ext_8805 = scope.sender.down('#combo_ext_8805');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_8805, 'stateName', 'stateId');
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
          var componentArray = [this.view.down('#textfield_ext_7765'), this.view.down('#customdatetimefield_ext_7807'), this.view.down('#textfield_ext_7851'), this.view.down('#textfield_ext_7897'), this.view.down('#combo_ext_8047'), this.view.down('#combo_ext_8101'), this.view.down('#customdatetimefield_ext_7945'), this.view.down('#numberfield_ext_7995'), this.view.down('#combo_ext_8742'), this.view.down('#combo_ext_8805'), this.view.down('#combo_ext_8937'), this.view.down('#combo_ext_8870'), this.view.down('#textfield_ext_8681')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.donorName = this.view.down('#textfield_ext_7765').getValue();
          jsonData.dob = this.view.down('#customdatetimefield_ext_7807').getValues();
          jsonData.phoneNo = this.view.down('#textfield_ext_7851').getValue();
          jsonData.emailId = this.view.down('#textfield_ext_7897').getValue();
          jsonData.gender = this.view.down('#combo_ext_8047').getValue();
          jsonData.bg = this.view.down('#combo_ext_8101').getValue();
          jsonData.lastDonationDate = this.view.down('#customdatetimefield_ext_7945').getValues();
          jsonData.howOftenUDonated = this.view.down('#numberfield_ext_7995').getValue();
          jsonData.countryId = this.view.down('#combo_ext_8742').getValue();
          jsonData.state = this.view.down('#combo_ext_8805').getValue();
          jsonData.city = this.view.down('#combo_ext_8937').getValue();
          jsonData.addressType = this.view.down('#combo_ext_8870').getValue();
          jsonData.postalCode = this.view.down('#textfield_ext_8681').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/RegDonorDsWS/proRegDonorDs',
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
                         Ext.Msg.alert('Server Response', 'Donor Registered Successfuly');
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