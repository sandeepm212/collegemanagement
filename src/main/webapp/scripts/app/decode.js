var dgFlexigrid;
var dvFlexigrid;
var dgFormValidator;
var dvFormValidator;
var decodeValuesParent;

// Decode Group Filters
var dgFilterInfo = {
	"startIndex": "0",
	"numResults": "5",
	"sortColumn": "name",
	"sortOrderAsc": "true"
};

function saveDecodeGroup () {    		
   	var dg = {
   		"id": $("#decodeGroupId").val(),
   		"name": $("#name").val(),
   		"code": $("#code").val(),
   		"description": $("#description").val(),
   		"enabled": $("#enabled").attr("checked")
  	}
    	
   	DWRDecodeGroupManager.saveDecodeGroup(dg, function (data) {
    	dgFlexigrid.grid.populate();
    	$("#dgFormDelete").show();
    	// Set the id for the Newly added Decode Group
    	$("#decodeGroupId").val(data.id)
   	});
}

function saveDecodeValue () {    		
   	var dv = {
   		"id": $("#decodeValueId").val(),
   		"value": $("#value").val(),
   		"shortCode": $("#shortCode").val(),
   		"description": $("#dvDescription").val(),
   		"enabled": $("#dvEnabled").attr("checked"),
   		"displayOrder": $("#dvDisplayOrder").val()
  	}
    	
   	DWRDecodeGroupManager.saveDecodeValue(decodeValuesParent, dv, function (data) {
    	dvFlexigrid.grid.populate();
    	// Set the id for the Newly added Decode Group
    	$("#decodeValueId").val(data.id)
   	});
}

function removeDecodeGroup (element) {    	
   	var dgId = $("#decodeGroupId").val();
   	if (confirm("Do you want to delete Drop Down Group and its child Values?")) {
   		DWRDecodeGroupManager.removeDecodeGroup(dgId, function () {
       		dgFlexigrid.grid.populate();
            	
       		// Show the edit form
           	$(element).dialog("close");
       	});	
   	}    	
}

function removeDecodeValue (element) {    	
   	var dvId = $("#deocdeValueForm #decodeValueId").val();
   	if (confirm("Do you want to delete Drop Down Value?")) {
   		DWRDecodeGroupManager.removeDecodeValue(decodeValuesParent, dvId, function () {
       		dvFlexigrid.grid.populate();
            	
       		// Show the edit form
           	$(element).dialog("close");
       	});	
   	}    	
}

var groupsDialogOptions = {
   	autoOpen: true,
   	width: 500,
   	show: 'slide',
   	title: 'Drop Down Group',
   	buttons: [
   	          {
   	        	  text: "Save",
    	          click: function() {
    	        	  if($("#deocdeGroupForm").valid()) {
    	        		  saveDecodeGroup();
    	        	  }    	            	   
    	          }
    	      },
    	      {
    	    	  text: "Delete",
   	              click: function() { removeDecodeGroup (this); }
    	      },
    	      {
    	    	  text: "Cancel",
    	          click: function() { 
    	        	  	$(this).dialog("close");
   	        	  		dgFormValidator.resetForm();
    	          }
			  }
		]
};

var valueDialogOptions = {
	autoOpen: true,
    width: 500,
    show: 'slide',
    title: 'Drop Down Value',
    buttons: [
              {
             	 text: "Save",
                  click: function() {
                  	  if($("#deocdeValueForm").valid()) {
                  		  saveDecodeValue();  
                  	  }    	            	   
                  }
              },
              {
             	 text: "Delete",
                  click: function() { removeDecodeValue (this); }
              },
              {
             	 text: "Cancel",
           	     click: function() { 
           	    	$(this).dialog("close");
           	         	dvFormValidator.resetForm();
           	     	}
           	  }
         ] 
};

function getDecodeGroups (flexigrid) {
	dgFilterInfo.sortColumn = dgFlexigrid.p.sortname; 
	dgFilterInfo.sortOrderAsc = dgFlexigrid.p.sortorder == "asc" ? true : false;
	dgFilterInfo.startIndex = (parseInt(dgFlexigrid.p.newp) - 1) * parseInt(dgFlexigrid.p.rp);
	
	DWRDecodeGroupManager.getDecodeGroups(null, dgFilterInfo, function (data) {    		
		flexigrid.addData(data);
	});
}

function dvGridButtonPress (com, grid) {
	if (com == 'Add') {
		$("#jDecodeValueform").dialog(valueDialogOptions);
		//addDecodeValue();
	}
}

function getDecodeValues (aEle) {
	var groupId = $(aEle).parents("tr:first").attr("id").substring(3);
	decodeValuesParent = groupId; 
	DWRDecodeGroupManager.getDecodeValues(groupId, false, function (data) {    		
		dvFlexigrid.grid.addData(data);
	});
}

var dvListCols = [
      	            {display: 'Value', name : 'value', width : 157, sortable : true, align: 'left'},
    	            {display: 'Short Code', name : 'shortCode', width : 65, sortable : true, align: 'left'},
    	            {display: 'Description', name : 'description', width : 197, sortable : true, align: 'left'},
    	            {display: 'Menu', name : 'EDIT_LINK', width : 80, sortable : true, align: 'left'}
    	            ];
var dvCoListWidth = getGridWidth(dvListCols);

function showDecodeValues(aEle) {
	$("#dvListHolder").show();
	$("#dgListHolder").hide();
	
	var selectedTr = $(aEle).parents("tr:first");
	$("#decodeGroupsList tr.trSelected").removeClass("trSelected");
	selectedTr.addClass("trSelected");
	
	var dvListTitle = 'Drop Down Group - ' + $(selectedTr).find("td:first div:first").html();
		
	if (dvFlexigrid) {
		getDecodeValues(aEle);
		$("#dvListHolder div.ftitle").html(dvListTitle);		
		dvFlexigrid.p.title = dvListTitle; 
	} else {
		$("#decodeValuesList").flexigrid ({
        	dwrFunction: function (flexigrid) {
        		dvFlexigrid = flexigrid;
        		getDecodeValues(aEle);
        	},
        	colModel : dvListCols,
        	sortname: "value",
        	sortorder: "asc",
        	dataType: 'json',
        	title: dvListTitle,
        	usepager: false,
        	singleSelect: true,
        	useRp: true,
        	rp: 15,
        	width: dvCoListWidth,
        	resizable: false,
        	useRp: false,
        	height: "auto",
        	onTrClick: function (tr) {        			
        	},
        	editLink: function () {
        		return '<a href="javascript:void(0);" onclick="showDVEditForm(this);">Edit</a>';	
        	},
        	onSuccess: function() {    		
        	},
        	buttons : [
        	           {name: 'Add', bclass: 'add', onpress : dvGridButtonPress},
        	           {separator: true}
        	           ]        	
        });   			
	}   	
}

function addDecodeGroup () {
   	$("#decodeGroupId").val("");
	$("#name").val("");
	$("#code").val("");
	$("#description").val("");
	$("#enabled").attr("checked", false);
		
	$("#dgFormDelete").hide();
		
   	// Show the edit form
   	$("#deocdeGroupForm").show();
}

function dgGridButtonPress (com, grid) {
   	if (com == 'Add') {
   		$("#jDecodeGroupform").dialog(groupsDialogOptions);
		addDecodeGroup();
	}
}

function showDGEditForm (aEle) {	
	var selectedTr = $(aEle).parents("tr:first");
	$("#decodeGroupsList tr.trSelected").removeClass("trSelected");
	selectedTr.addClass("trSelected");
		
	var groupId = $(selectedTr).attr("id").substring(3);
   	DWRDecodeGroupManager.getDecodeGroup(groupId, function (data) {
 		$("#dgFormDelete").show();
    		
   		// Show the edit form
   		$("#deocdeGroupForm").show();
    		
   		$("#decodeGroupId").val(data.id);
   		$("#name").val(data.name);
   		$("#code").val(data.code);
   		$("#description").val(data.description);
   		$("#enabled").attr("checked", data.enabled);
    		
   		//showDecodeValues (data.decodeValues);
   	});
	
	$("#jDecodeGroupform").dialog(groupsDialogOptions);
	//$(aEle).parents("tr:first").addClass("trSelected");	
}
   		    
function showDVEditForm (aEle) {
	var selectedTr= $(aEle).parents("tr:first");	
	$("#decodeValuesList tr.trSelected").removeClass("trSelected");
	selectedTr.addClass("trSelected");
	
	var valueId = $(selectedTr).attr("id").substring(3);   	
   	DWRDecodeGroupManager.getDecodeValue(valueId, function (data) {
 		//$("#dvDecodeGroupId").val(data.id);
   		$("#decodeValueId").val(data.id);
   		$("#value").val(data.value);
   		$("#shortCode").val(data.shortCode);
   		$("#dvDescription").val(data.description);
   		$("#dvEnabled").attr("checked", data.enabled);
   		$("#dvDisplayOrder").val(data.displayOrder);
   	});
   	
	$("#jDecodeValueform").dialog(valueDialogOptions);
}

function showDecodeValue (selectedTr) {
   	
}

var dgListCols = [
	            {display: 'Name', name : 'name', width : 157, sortable : true, align: 'left'},
	            {display: 'Description', name : 'description', width : 197, sortable : true, align: 'left'},
	            {display: 'Menu', name : 'EDIT_LINK', width : 150, sortable : true, align: 'left'}
	            ];

var dgCoListWidth = getGridWidth(dgListCols);

$("#decodeGroupsList").flexigrid ({
	dwrFunction: function (flexigrid) {
		dgFlexigrid = flexigrid;
		getDecodeGroups(flexigrid.grid);	
	},
	dataType: 'json',
	colModel : dgListCols,
	sortname: "name",
	sortorder: "asc",
	usepager: true,
	singleSelect: true,
	useRp: true,
	rp: 5,
	width: dgCoListWidth,
	resizable: false,
	useRp: false,
	height: "auto",
	onTrClick: function (tr) {
			
	},
	editLink: function () {
		return '<a href="javascript:void(0);" onclick="showDecodeValues(this);">Show Group Values</a>';	
	},
	onSuccess: function() {
		if ($("#deocdeGroupForm").is(":visible")) {
			$("#decodeGroupsList #row" + $("#decodeGroupId").val()).addClass("trSelected");	
		}
	},
	buttons : [
	           {name: 'Add', bclass: 'add', onpress : dgGridButtonPress},
	           {separator: true}
	           ]
});

$(document).ready(function(){
	dgFormValidator = $("#deocdeGroupForm").validate({
		rules: {
			name: "required",
			code: "required"				
		},
		messages: {
			name: "Please enter Name.",
			code: "Please enter Code."				
		},
		submitHandler: function(form) {
			saveDecodeGroup();
	    }
	});
	
	dvFormValidator = $("#deocdeValueForm").validate({
        rules: {
        	value: "required",
        	shortCode: "required",
        	enabled: "required",
        	dvDisplayOrder: "number"
        },
        submitHandler: function(form) {
        	saveDecodeValue();
        }
    });
	
	$('#showDDGroups').click (function () {
		$("#dvListHolder").hide();
		$("#dgListHolder").show();
	});
});
