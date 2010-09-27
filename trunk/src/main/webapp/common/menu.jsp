<%@ include file="/common/taglibs.jsp"%>


	<div id="smoothmenu">	
		<ul id="menunav">
			<li><a title="Home" href="/mainMenu.html">Home</a></li>
			<li><a title="Student List" href="/students.html">Student List</a></li>
			<li><a title="Administration" href="/admin/users.html">Administration</a>
				<ul>
					<li><a title="View Users" href="/admin/users.html">View Users</a></li>
					<li><a title="Current Users" href="/admin/activeUsers.html">Current Users</a></li>
					<li><a title="DecodeGroup List" href="/decodeGroups.html">DecodeGroup List</a></li>
					<li><a title="Course List" href="/courses.html">Course List</a></li>
				</ul>
			</li>   
		</ul>				
	</div>	


<script type="text/javascript">
<!--

ddsmoothmenu.init({
	mainmenuid: "smoothmenu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'grid_32 menuHolder ddsmoothmenu', //class added to menu's outer DIV
	customtheme: ["#1C390B", "#699C4D"]
	})

//-->
</script>
