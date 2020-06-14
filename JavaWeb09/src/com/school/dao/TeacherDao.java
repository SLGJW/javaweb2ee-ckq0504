package com.school.dao;

import com.school.domain.Course;
import com.school.domain.Student;
import com.school.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {

    public Teacher doLogin(Teacher teacher) throws Exception;

    public List<Course> findTeachCourses(Teacher teacher) throws Exception;

    public Map<Course,List<Student>> findTeachStudents(Teacher teacher) throws Exception;
}
