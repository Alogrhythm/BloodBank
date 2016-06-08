Ext.define('Bloodbankapp.view.usermanagement.admin.AddUserDetailsViewModel',
{
	extend : 'Ext.app.ViewModel',
	
	alias : 'viewmodel.addUserModel',

	model: "AddUserDataModel",
	 
	requires:['Bloodbankapp.model.AddUserDataModel'],

});