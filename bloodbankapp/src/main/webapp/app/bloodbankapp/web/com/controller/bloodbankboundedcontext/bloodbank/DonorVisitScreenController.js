Ext.define('Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.DonorVisitScreenController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.DonorVisitScreenController',
     onSaveClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_34139'), this.view.down('#textfield_ext_34181'), this.view.down('#textfield_ext_34225'), this.view.down('#textfield_ext_34271'), this.view.down('#textfield_ext_34319'), this.view.down('#numberfield_ext_34369'), this.view.down('#hiddenfield_ext_3042')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.height = this.view.down('#textfield_ext_34139').getValue();
          jsonData.weight = this.view.down('#textfield_ext_34181').getValue();
          jsonData.pulse = this.view.down('#textfield_ext_34225').getValue();
          jsonData.bp = this.view.down('#textfield_ext_34271').getValue();
          jsonData.temp = this.view.down('#textfield_ext_34319').getValue();
          jsonData.noOfUnits = this.view.down('#numberfield_ext_34369').getValue();
          jsonData.dvid = this.view.down('#hiddenfield_ext_3042').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/StockUpdateWS/proStockUpdate',
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
                         Ext.Msg.alert('Server Response', 'Blood stock updated successfully....!');
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
     onNextClick: function(me, e, eOpts) {
          var panel_ext_33765 = this.view.down('#panel_ext_33765');
          var jj = this.view.down('#tabpanel_ext_33722');
          jj.setActiveTab(panel_ext_33765);
          var componentArray = [this.view.down('#textfield_ext_33945'), this.view.down('#combo_ext_33979'), this.view.down('#combo_ext_34015'), this.view.down('#combo_ext_34053')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.orgnizerName = this.view.down('#textfield_ext_33945').getValue();
          jsonData.dType = this.view.down('#combo_ext_33979').getValue();
          jsonData.donor = this.view.down('#combo_ext_34015').getValue();
          jsonData.camp = this.view.down('#combo_ext_34053').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/DonorVisit/',
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
                         var responseData = responseText.response.data;
                         scope.sender.down('#hiddenfield_ext_3042').setValue(responseData.donorVisitId);
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