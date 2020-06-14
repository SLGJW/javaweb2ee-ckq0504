package com.school.dao;

import com.school.domain.Course;
import com.school.domain.Student;
import com.school.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    
    public Map<Course,Teacher> findCandT(Student student) throws Exception;
   
    public Student doLogin(Student student) throws Exception;
    
    public boolean chooseCourse(int sid,int cid) throws Exception;
   
    public boolean cancelCourse(int sid,int cid) throws Exception;

    public List<Object[]> findNot(int sid) throws Exception;
}
