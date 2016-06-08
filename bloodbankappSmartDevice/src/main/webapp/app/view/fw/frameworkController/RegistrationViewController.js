Ext.define('Bloodbankapp.view.fw.frameworkController.RegistrationViewController', {
     extend: 'Bloodbankapp.view.fw.frameworkController.FrameworkViewController',
     /*********************Main Controller Functions*********************************/
     
     //To add server calls in communication array
     addCommunicationLog: function(response, success, compRef) {
          try {
               if (success) {
                    var responseData = Ext.JSON.decode(response.responseText);
               }
               if (compRef == null) {
                    responseObj = {
                         name: '',
                         status: response.status,
                         statusText: response.statusText,
                         success: success,
                         message: success ? responseData.response.message : 'Failed'
                    };
               } else {
                    responseObj = {
                         name: (compRef.fieldLabel != null) ? compRef.fieldLabel : compRef.title,
                         status: response.status,
                         statusText: response.statusText,
                         success: success,
                         message: success ? responseData.response.message : 'Failed'
                    };
               }
               this.view.communicationLog.push(responseObj);
          } catch (addCommunicationLogException) {}
     },

     //To create the final json to save
     createFinalJson : function(data){
     	if (data.id != null) {
               delete data.id;
          }
          var jsonData = {};
          for (key in data) {
               if (data[key] != null) {
                    jsonData[key] = data[key];
               }
          }
          this.modifyData(jsonData);
          return jsonData;
     },
     
     //To remove the unwanted code from final json creation
     modifyData: function(config) {
          if (!config) {
               return null;
          }
          for (i in config) {
               if (config[i]) {
                    config[i] = config[i].valueOf();
                    if (typeof config[i] == 'object') {
                         this.modifyData(config[i]);
                    }
               }
          }
     },
     
     /********************************Form Controller Functions***********************************/

     //To add the store to combo 
     assignComboData: function(component, data) {
    	 var decodedData = Ext.JSON.decode(data);
    	 var storeData = decodedData.response.data;
    	 var componentStore = Ext.create('Ext.data.Store', {
    		 fields: [],
    		 data: storeData,
    		 autoLoad: true
    	 });
    	 component.setValue();
    	 component.setStore(componentStore);
    	 component.getStore().sort('primaryDisplay', 'ASC');
     },
     
     //To find all the combos from container and assign the data to each 
     assignAllComboData: function(container, itemId, data) {
          var allForms = container.up().query('form');
          for (var ind = 0; ind < allForms.length; ind++) {
               if (allForms[ind].down('#' + itemId) != null) {
                    container.controller.assignComboData(allForms[ind].down('#' + itemId), data);
               }
          }
     },
     
     //To show the window with the server call log
     onConsoleClick: function() {
          var window = Ext.create('Bloodbankapp.view.console.ConsoleWindow');
          var store = window.down('grid').store;
          store.loadData(this.view.communicationLog);
          window.show();
     },
     
     //To delete the record from the grid in froms
     onDeleteActionColumnClick: function(grid, rowIndex) {
          grid.store.removeAt(rowIndex);
     },
     
     //To find the records from store
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
     },

     //To remove the id from the data 
     removeId: function(data) {
          for (var i = 0; i < data.length; i++) {
               delete data[i]['id'];
          }
     },

     //Crated the json object by the bindLevel setted to the components
     createObject: function(data, dataLevel, assignValue) {
          this.removeId(assignValue);
          var dataLevels = dataLevel.split('.');
          var currentObject = data;
          for (var iterable_element in dataLevels) {
               var element = dataLevels[iterable_element];
               var elementValue = currentObject[element];
               if (currentObject[element]) {
                    currentObject = elementValue;
               } else {
                    currentObject[element] = assignValue;
                    return currentObject;
               }
          }
          return data;
     },
     
     //To display the date in form
     modifyFormValues: function(values, form) {
          for (var key in values) {
               if (form.down('#' + key).dataType == 'DATE' || form.down('#' + key).dataType == 'DATETIME') {
                    if (form.down('#' + key).getValue() != null) {
                         values[key] = form.down('#' + key).getValue().getTime();
                    }
               }
               if (typeof values[key] === 'object') {
                    values[key] = this.modifyFormValues(values[key], form);
               }
          }
          return values;
     },
     
      //To show the next card in aggregate form
     showNextCard: function(btn) {
          var form = btn.up('form');
          var grid = form.layout.getActiveItem().down('grid');
          if (!form.layout.getActiveItem().isValid()) {
               if (grid == null || grid.store.getCount() == 0) return;
          }
          form.layout.setActiveItem(form.layout.getNext());
          prevBut = btn.up().down('#cardPrev');
          prevBut.setDisabled(false);
          if (!form.layout.getNext()) {
               btn.setDisabled(true);
               form.down('#saveFormButton').setDisabled(false);
          }
     },
     
     //To show the prevous card in aggregate form
     showPreviousCard: function(btn) {
          var form = btn.up('form');
          form.layout.setActiveItem(form.layout.getPrev());
          nextBut = btn.up().down('#cardNext');
          nextBut.setDisabled(false);
          if (!form.layout.getPrev()) {
               btn.setDisabled(true);
          }
     },
     
     //To show the first card in aggregate form 
     showFirstCard: function(form) {
          form.layout.setActiveItem(0);
          nextBut = form.down('#cardNext');
          nextBut.setDisabled(false);
          prevBut = form.down('#cardPrev');
          prevBut.setDisabled(true);
     },
     
     //To show the provide card in aggregate form
     showCard: function(form, item) {
          form.layout.setActiveItem(item);
          if (!form.layout.getPrev()) {
               prevBut = form.down('#cardPrev');
               prevBut.setDisabled(true);
          } else {
               prevBut = form.down('#cardPrev');
               prevBut.setDisabled(false);
          }
          if (!form.layout.getNext()) {
               nextBut = form.down('#cardNext');
               nextBut.setDisabled(true);
          } else {
               nextBut = form.down('#cardNext');
               nextBut.setDisabled(false);
          }
     }
});