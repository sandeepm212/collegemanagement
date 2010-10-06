package com.management.college.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.context.ServletContextAware;

import com.management.college.DecodeConstants;
import com.management.college.dao.CourseDao;
import com.management.college.dao.DecodeGroupDao;
import com.management.college.model.Course;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.service.CourseManager;

@WebService(serviceName = "CourseService", endpointInterface = "com.management.college.service.CourseManager")
public class CourseManagerImpl extends GenericManagerImpl<Course, Long>
		implements CourseManager, ServletContextAware {
	CourseDao courseDao;
	DecodeGroupDao decodeGroupDao;
	ServletContext servletContext;

	public CourseManagerImpl(CourseDao courseDao) {
		super(courseDao);
		this.courseDao = courseDao;
	}

	public ListWrapper<Course> getCourses(Course course, FilterInfo filterInfo) {
		return getFilteredList(course, filterInfo);
	}

	public Course getCourse(Long id) {
		return get(id);
	}

	public Course saveCourse(Course course) {
		Long id = course.getId();
		Course courseTemp = null;
		Date currDate = new Date();
		if (id != null) {
			courseTemp = get(id);
		} else {
			courseTemp = new Course();
			courseTemp.setCreatedOn(currDate);
		}
		if (course.getGroup() == null) {
			return null;
		}
		DecodeValue courseGroup =  getCourseGroupDecodeValue(course.getGroup().getId());
		courseTemp.setGroup(courseGroup);
		courseTemp.setName(course.getName());
		courseTemp.setCode(course.getCode());
		courseTemp.setDescription(course.getDescription());
		courseTemp.setIntake(course.getIntake());
		courseTemp.setDuration(course.getDuration());
		courseTemp.setUpdatedOn(currDate);

		courseTemp = save(courseTemp);

		return courseTemp;
	}

	public void removeCourse(Long id) {
		if (id != null) {
			remove(id);
		}
	}
	
	private DecodeValue getCourseGroupDecodeValue (Long decodeValueId) {
		List<DecodeValue> decodeValues =  (List<DecodeValue>)servletContext.getAttribute(DecodeConstants.CTX_DG_COURSE_GROUP);
		if (decodeValues != null && !decodeValues.isEmpty()) {
			for (DecodeValue dv : decodeValues) {
				if (dv.getId().equals(decodeValueId)) {
					return dv;
				}
			}
		}
		return null;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	

	public void setJSONDecodeGroups () {
		List<DecodeValue> courseGroupValues = decodeGroupDao
		.getDecodeValuesByGroup(DecodeConstants.DG_CODE_COURSE_GROUP);
		
		JSONArray groupsJsonArray = new JSONArray();
		JSONArray coursesJsonArray = new JSONArray();
		for (DecodeValue dv : courseGroupValues) {
			JSONObject jo = new JSONObject();
			jo.put("id", dv.getId());
			jo.put("value", dv.getValue());
			groupsJsonArray.add(jo);
			
			JSONArray coursesArray = new JSONArray();
			List<Course> courses = courseDao.getCoursesByGroup(dv.getId());
			if (courses != null) {
				for (Course c : courses) {
					JSONObject cjo = new JSONObject();
					cjo.put("id", c.getId());
					cjo.put("name", c.getName());
					coursesArray.add(cjo);
				}
				JSONObject c1 = new JSONObject();
				c1.put("group", dv.getId());
				c1.put("courses", coursesArray);
				coursesJsonArray.add(c1);
			}
		}
		servletContext.setAttribute("course_groups_json", groupsJsonArray);
		servletContext.setAttribute("courses_json", coursesJsonArray);
	}

	public void setDecodeGroupDao(DecodeGroupDao decodeGroupDao) {
		this.decodeGroupDao = decodeGroupDao;
	}
	
}