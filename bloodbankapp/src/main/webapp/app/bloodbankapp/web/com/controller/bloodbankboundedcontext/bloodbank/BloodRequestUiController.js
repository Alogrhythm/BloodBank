Ext.define('Bloodbankapp.bloodbankapp.web.com.controller.bloodbankboundedcontext.bloodbank.BloodRequestUiController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.BloodRequestUiController',
     onAcceptClick: function(me, e, eOpts) {
          var formComponent = new Ext.create('Bloodbankapp.bloodbankapp.web.com.view.bloodbankboundedcontext.bloodbank.DonorVisitScreen');
          formComponent.title = 'DonorVisitScreen';
          formComponent.closable = true;
          var tabs = Ext.getCmp('appMainTabPanel');
          tabs.add(formComponent);
          tabs.setActiveTab(formComponent);
     }
});