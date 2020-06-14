package com.school.dao;

import com.school.domain.Course;
import com.school.domain.Student;
import com.school.domain.Teacher;
import com.school.domain.User;

import java.util.List;

public interface UserDao {
 
    public User doLogin(User user) throws Exception;
   
    public boolean insertStudent(Student student) throws Exception;
    public boolean deleteStudent(Student student) throws Exception;
    public boolean updateStudent(Student student) throws Exception;
    public List<Student> selectStudent() throws Exception;
  
    public boolean insertTeacher(Teacher teacher) throws Exception;
    public boolean deleteTeacher(Teacher teacher) throws Exception;
    public boolean updateTeacher(Teacher teacher) throws Exception;
    public List<Teacher> selectTeacher() throws Exception;
  
    public boolean insertCourse(Course coursen) throws Exception;
    public boolean deleteCourse(Course course) throws Exception;
    public boolean updateCourse(Course course,int oldcid) throws Exception;
    public List<Course> selectCourse() throws Exception;
}
