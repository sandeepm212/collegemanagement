var studentFlexigrid;

// Decode Group Filters
var studentFilterInfo = {
	"startIndex": "0",
	"numResults": "15",
	"sortColumn": "first_name",
	"sortOrderAsc": "true"
};

function getStudents (flexigrid) {
	studentFilterInfo.sortColumn = studentFlexigrid.p.sortname; 
	studentFilterInfo.sortOrderAsc = studentFlexigrid.p.sortorder == "asc" ? true : false;
	studentFilterInfo.startIndex = (parseInt(studentFlexigrid.p.newp) - 1) * parseInt(studentFlexigrid.p.rp);
	
	DWRStudentManager.getStudents(null, studentFilterInfo, function (data) {    		
		flexigrid.addData(data);
	});
}

var studentsListCols = [
	{display: 'Name', name : 'studentName.fullName', width : 250, sortable : true, align: 'left'},
	{display: 'Group', name : 'courseGroupName', width : 160, sortable : true, align: 'left'},
	{display: 'Course', name : 'courseName', width : 157, sortable : true, align: 'left'},
	{display: 'Joining Date', name : 'joiningDateStr', width : 80, sortable : true, align: 'left'},
	{display: 'Menu', name : 'EDIT_LINK', width : 80, sortable : true, align: 'left'}
 ];
 
var studentListWidth = getGridWidth(studentsListCols);

$("#studentsList").flexigrid ({
	dwrFunction: function (flexigrid) {
		studentFlexigrid = flexigrid;
		getStudents(flexigrid.grid);	
	},
	dataType: 'json',
	colModel : studentsListCols,
	sortname: "first_name",
	sortorder: "asc",
	usepager: true,
	singleSelect: true,
	useRp: true,
	rp: 15,
	width: studentListWidth,
	resizable: false,
	useRp: false,
	height: "auto",
	onTrClick: function (tr) {
			
	},
	editLink: function () {
		return '<a href="javascript:void(0);" onclick="showStudentEditForm(this);">Edit</a>';	
	},
	onSuccess: function() {
		if ($("#deocdeGroupForm").is(":visible")) {
			$("#decodeGroupsList #row" + $("#decodeGroupId").val()).addClass("trSelected");	
		}
	}
});

function showStudentEditForm(aEle) {
	var selectedTr= $(aEle).parents("tr:first");	
	var studentId = $(selectedTr).attr("id").substring(3);
	this.location.href = "/studentform.html?id=" + studentId;
}


