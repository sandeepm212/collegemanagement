package com.management.college.dao.hibernate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

import com.management.college.dao.StudentDao;
import com.management.college.model.DecodeGroup;
import com.management.college.model.PersonName;
import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.view.StudentView;

public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long>
		implements StudentDao {

	public StudentDaoHibernate() {
		super(Student.class);
	}

	private static final String STUDENTS_LIST_COLUMNS = "s.id AS student_id, pn.title, pn.first_name, pn.middle_name, pn.last_name, pn.suffix, "
			+ "pn.display_name, pn.person_type, s.admission_number AS admission_number, s.blood_group AS blood_group, "
			+ "s.current_year AS current_year, s.gender AS gender, s.identification_marks AS identification_marks, "
			+ "s.joining_date AS joining_date, DATE_FORMAT(s.joining_date, '%m/%d/%Y') AS joining_date_str, s.nationality AS nationality, s.registration_number AS registration_number, "
			+ "s.religion AS religion, s.student_id AS student_id, s.course_id AS course_id, dv.value AS course_name ";

	private static final String STUDENTS_LIST_COUNT = "SELECT count(s.id) as count "
			+ "FROM mgmt_student s "
			+ "LEFT JOIN mgmt_person_name pn ON pn.owner_entity_id = s.id AND pn.owner_entity_type = 3 AND pn.person_type = 0 "
			+ "LEFT JOIN mgmt_decode_value dv ON dv.id = s.course_id WHERE 1 = 1 ";

	private static final String STUDENTS_LIST = "SELECT "
			+ STUDENTS_LIST_COLUMNS
			+ "FROM mgmt_student s "
			+ "LEFT JOIN mgmt_person_name pn ON pn.owner_entity_id = s.id AND pn.owner_entity_type = 3 AND pn.person_type = 0 "
			+ "LEFT JOIN mgmt_decode_value dv ON dv.id = s.course_id WHERE 1 = 1 ";

	public ListWrapper<StudentView> getStudents(Map filters,
			FilterInfo filterInfo) {
		
        final ListWrapper<StudentView> studentListWrapper = new ListWrapper<StudentView>();
		
		StringBuilder sqlQuery = new StringBuilder(1024);
		sqlQuery.append(STUDENTS_LIST_COUNT);
		
		final StringBuffer filterQuery = new StringBuffer(256);
		if (filters != null) {

		}
		
		final SQLQuery countQuery = getSession().createSQLQuery(sqlQuery.toString());
        countQuery.addScalar("COUNT", Hibernate.INTEGER);
        final Integer totalCount = (Integer) countQuery.uniqueResult();
        if (totalCount > 0) {
        	studentListWrapper.setTotalResultsCount(totalCount);
        	
            // Clear the text.
            sqlQuery.setLength(0);
            sqlQuery.append(STUDENTS_LIST);
            sqlQuery.append(filterQuery.toString());
        	
        	if (filterInfo != null) {
        		if (StringUtils.isNotBlank(filterInfo.getSortColumn())) {
        			sqlQuery.append(" ORDER BY pn.").append(filterInfo.getSortColumn());
        		} else {
        			sqlQuery.append(" ORDER BY pn.first_name ");
        		}
        		sqlQuery.append(" LIMIT ").append(filterInfo.getStartIndex())
				.append(',').append(filterInfo.getNumResults());
    		}
        	
        	SQLQuery query = getSession().createSQLQuery(sqlQuery.toString());
        	
        	query.addScalar("student_id", Hibernate.LONG);
            query.addScalar("title", Hibernate.LONG);
            query.addScalar("first_name", Hibernate.STRING);
            query.addScalar("middle_name", Hibernate.STRING);
            query.addScalar("last_name", Hibernate.STRING);
            query.addScalar("suffix", Hibernate.STRING);
            query.addScalar("display_name", Hibernate.STRING);
            query.addScalar("person_type", Hibernate.INTEGER);
            query.addScalar("admission_number", Hibernate.STRING);
            query.addScalar("blood_group", Hibernate.LONG);
            query.addScalar("current_year", Hibernate.INTEGER);
            query.addScalar("gender", Hibernate.STRING);
            query.addScalar("identification_marks", Hibernate.STRING);
            query.addScalar("joining_date", Hibernate.TIMESTAMP);
            query.addScalar("joining_date_str", Hibernate.STRING);
            query.addScalar("nationality", Hibernate.LONG);
            query.addScalar("registration_number", Hibernate.STRING);
            query.addScalar("religion", Hibernate.LONG);
            query.addScalar("course_id", Hibernate.LONG);
            query.addScalar("course_name", Hibernate.STRING);
            
            List<Object[]> list = (List<Object[]>) query.list();
            if (list != null && !list.isEmpty()) {
                List<StudentView> studentList = new ArrayList<StudentView>(list.size());
                int i = 0;
                for (Object[] object : list) {
                	i = 0;
                	PersonName studentName = new PersonName();
                	
                	StudentView student = new StudentView();
                	student.setStudentId((Long) object[i]);i++;
                	studentName.setTitle((Long) object[i]);i++;
                	studentName.setFirstName((String) object[i]);i++;
                	studentName.setMiddleName((String) object[i]);i++;
                	studentName.setLastName((String) object[i]);i++;
                	studentName.setSuffix((String) object[i]);i++;
                	studentName.setDisplayName((String) object[i]);i++;
                	studentName.setPersonType((Integer) object[i]);i++;
                	
                	student.setAdmissionNumber((String) object[i]);i++;
                    student.setBloodGroup((Long) object[i]);i++;
                    student.setCurrentYear((Integer) object[i]);i++;
                    student.setGender((String) object[i]);i++;
                    student.setIdentificationMarks((String) object[i]);i++;
                    student.setJoiningDate((Date) object[i]);i++;
                    student.setJoiningDateStr((String) object[i]);i++;
                    
                    student.setNationality((Long) object[i]);i++;
                    student.setRegistrationNumber((String) object[i]);i++;
                    student.setReligion((Long) object[i]);i++;
                    student.setCourseId((Long) object[i]);i++;
                    student.setCourseName((String) object[i]);i++;
                    
                    student.setStudentName(studentName);
                    
                    studentList.add(student);
                }
                studentListWrapper.setList(studentList);
                studentListWrapper.setFilteredListCount(studentList.size());
            }
            
        } else {
        	List<StudentView>  emptyStudents = Collections.emptyList();
            studentListWrapper.setList(emptyStudents);
        }
		
		return studentListWrapper;
	}
}
