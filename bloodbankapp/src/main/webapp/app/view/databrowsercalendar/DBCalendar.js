Ext.define('Bloodbankapp.view.databrowsercalendar.DBCalendar', {
	extend : 'Bloodbankapp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Bloodbankapp.view.databrowsercalendar.DBCalendarController',
	             'Bloodbankapp.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
