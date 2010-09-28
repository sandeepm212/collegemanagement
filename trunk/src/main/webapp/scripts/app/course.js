var courseFlexigrid;
var courseFormValidator;

// Course Filters
var courseFilterInfo = {
	"startIndex": "0",
	"numResults": "2",
	"sortColumn": "name",
	"sortOrderAsc": "true"
};

function getCourses (flexigrid) {
	courseFilterInfo.sortColumn = courseFlexigrid.p.sortname; 
	courseFilterInfo.sortOrderAsc = courseFlexigrid.p.sortorder == "asc" ? true : false;
	courseFilterInfo.startIndex = (parseInt(courseFlexigrid.p.newp) - 1) * parseInt(courseFlexigrid.p.rp);
	
	DWRCourseManager.getCourses(null, courseFilterInfo, function (data) {    		
		flexigrid.addData(data);
	});
}

function removeCourse (element) {
	/*
	var selectedTr = $(aEle).parents("tr:first");
	$("#decodeGroupsList tr.trSelected").removeClass("trSelected");
	selectedTr.addClass("trSelected");
	*/
   	var courseId = $("#courseId").val();
   	if (confirm("Do you want to delete Course?")) {
   		DWRCourseManager.removeCourse(courseId, function () {
       		courseFlexigrid.grid.populate();
       	});	
   	}    	
}
  
function courseGridButtonPress (com, grid) {
	if (com == 'Add') {
   		$('#jCourseform').dialog(courseDialogOptions);
   		courseFormValidator.resetForm();
   		$('#courseForm')[0].reset();
   		$('#courseId').val('');
   		$('.ui-dialog-buttonpane button:eq(1)').addClass('hidden');
		//addCourse();
	}
}

var courseListColumns = [
     	            {display: 'Group', name : 'group.value', width : 157, sortable : true, align: 'left'},
    	            {display: 'Name', name : 'name', width : 200, sortable : true, align: 'left'},
    	            {display: 'Code', name : 'code', width : 57, sortable : true, align: 'left'},
    	            {display: 'Duration', name : 'duration', width : 57, sortable : true, align: 'left'},
    	            {display: 'Intake', name : 'intake', width : 57, sortable : true, align: 'left'},
    	            {display: 'Menu', name : 'EDIT_LINK', width : 80, sortable : true, align: 'left'}
    	            ];

var coursesListWidth = getGridWidth(courseListColumns);

$("#coursesList").flexigrid ({
	dwrFunction: function (flexigrid) {
		courseFlexigrid = flexigrid;
		getCourses(flexigrid.grid);	
	},
	dataType: 'json',
	colModel : courseListColumns,
	sortname: "name",
	sortorder: "asc",
	usepager: true,
	singleSelect: true,
	useRp: true,
	rp: 2,
	width: coursesListWidth,
	resizable: false,
	useRp: false,
	height: "auto",
	onTrClick: function (tr) {
			
	},
	editLink: function () {
		return '<a href="javascript:void(0);" onclick="showCourseEditForm(this);">Edit</a> | <a href="javascript:void(0);" onclick="removeCourse(this);">Delete</a>';	
	},
	onSuccess: function() {
		
	},
	buttons : [
	           {name: 'Add', bclass: 'add', onpress : courseGridButtonPress},
	           {separator: true}
	           ]
});

function saveCourse () {
	var courseGroup = {
			"id": $("#group").val()
	};
	
   	var course = {
   		"id": $("#courseId").val(),
   		"group": courseGroup,
   		"name": $("#name").val(),
   		"code": $("#code").val(),
   		"duration": $("#duration").val(),
   		"intake": $("#intake").val(),
   		"description": $("#description").val()
  	};
    	
   	DWRCourseManager.saveCourse(course, function (data) {
    	courseFlexigrid.grid.populate();
    	// Set the id for the Newly added Course
    	$("#courseId").val(data.id)
    	$("#successMsg").html("Course has been saved successfully.").show().fadeOut(5000);
   	});
}


var courseDialogOptions = {
	   	autoOpen: true,
	   	width: 500,
	   	show: 'slide',
	   	title: 'Course',
	   	buttons: [
	   	          {
	   	        	  text: "Save",
	    	          click: function() {
	    	        	  if($("#courseForm").valid()) {
	    	        		  saveCourse();
	    	        	  }    	            	   
	    	          }
	    	      },
	    	      {
	    	    	  text: "Delete",
	   	              click: function() { removeCourse (this); }
	    	      },
	    	      {
	    	    	  text: "Cancel",
	    	          click: function() { 
	    	        	  	$(this).dialog("close");
	    	        	  	courseFormValidator.resetForm();
	    	          }
				  }
			]
	};

function showCourseEditForm(aEle) {
	var selectedTr = $(aEle).parents("tr:first");
	$("#coursesList tr.trSelected").removeClass("trSelected");
	selectedTr.addClass("trSelected");
	
	$('.ui-dialog-buttonpane button:eq(1)').addClass('hidden');
		
	var courseId = $(selectedTr).attr("id").substring(3);
   	DWRCourseManager.getCourse(courseId, function (data) {
 			
   		$("#courseId").val(data.id);
   		$("#group").val(data.group.id);
   		$("#name").val(data.name);
   		$("#code").val(data.code);
   		$("#description").val(data.description);
   		$("#duration").val(data.duration);
   		$("#intake").val(data.intake);
    	
   	});
	
	$("#jCourseform").dialog(courseDialogOptions);
}

$(document).ready(function() {
	courseFormValidator = $("#courseForm").validate({
		rules: {
			name: "required",
			code: "required",
			duration: "required number",
			intake: "number"
		},
		submitHandler: function(form) {
			//saveCourse();
	    }
	});
});

