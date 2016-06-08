Ext.define('Bloodbankapp.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Bloodbankapp.view.appreportui.ReportViewController',
	            'Bloodbankapp.view.appreportui.datagrid.DataGridPanel',
	            'Bloodbankapp.view.appreportui.datagrid.DataGridView',
	            'Bloodbankapp.view.appreportui.querycriteria.QueryCriteriaView',
	            'Bloodbankapp.view.appreportui.chart.ChartView',
	            'Bloodbankapp.view.appreportui.datapoint.DataPointView',
	            'Bloodbankapp.view.googlemaps.map.MapPanel',
	            'Bloodbankapp.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData',
		added:'onReportAdded'
	}
});
