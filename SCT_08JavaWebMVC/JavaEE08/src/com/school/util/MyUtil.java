package com.school.util;

import com.school.domain.Course;
import com.school.domain.Student;
import com.school.domain.Teacher;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;

import static java.lang.Integer.parseInt;

public class MyUtil {
   /**
     * ��ȡ���ݿ����ӳض���
     * @return
     */
    public static QueryRunner getDB(){
        DataSource ds = new ComboPooledDataSource();
        QueryRunner qr = new QueryRunner(ds);
        return qr;
    }

    public static int toInt(String str){
        return parseInt(str);
    }

    //ͨ��ѧ�Ż�ȡѧ����Ϣ
    public static Student getStudent(int sid) throws Exception{
        QueryRunner qr = MyUtil.getDB();
        String sql = "select * from student where sid=?";
        Student student = qr.query(sql,new BeanHandler<>(Student.class),sid);
        if(student!=null){
            return student;
        }else {
            return null;
        }
    }

    //ͨ�����Ż�ȡ��ʦ��Ϣ
    public static Teacher getTeacher(int tid) throws Exception{
        QueryRunner qr = MyUtil.getDB();
        String sql = "select * from teacher where tid=?";
        Teacher t = qr.query(sql,new BeanHandler<>(Teacher.class),tid);
        String tname = t.getTname();
        String ps = t.getPassword();
        int p = t.getPermissions();
        Teacher teacher = new Teacher(tid,tname,ps,p);
        if(teacher!=null){
            return teacher;
        }else {
            return null;
        }
    }

  //ͨ���γ̱�Ż�ȡ�γ���Ϣ
    public static Course getCourse (int cid) throws Exception{
        QueryRunner qr = MyUtil.getDB();
        String sql = "select * from course where cid=?";
        Course course = qr.query(sql,new BeanHandler<>(Course.class),cid);
        if(course!=null){
            return course;
        }else {
            return null;
        }

    }

    //ͨ���γ̱�Ż�ȡ�ον�ʦ����
    public static String getTeacherName(Course course) throws Exception{
        QueryRunner qr = MyUtil.getDB();
        String sql = "select * from teacher where tid=?";
        Teacher teacher = qr.query(sql, new BeanHandler<>(Teacher.class),course.getCourse_teacher());
        if(teacher!=null){
            return teacher.getTname();
        }else {
            return null;
        }

    }
}
