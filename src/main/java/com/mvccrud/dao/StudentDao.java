/**
 * Created By Krishna Shinde
 * Date : 13-05-2023
 * Time : 21:55
 * Project: SpringMvcCRUDOperatn
 **/

package com.mvccrud.dao;

import com.mvccrud.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<Student> getAllStudents() {
        List<Student> lst = template.query("select * from Student", new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student(resultSet.getInt("rno"), resultSet.getString("name"), resultSet.getString("qualification"), resultSet.getInt("percentage"));
                return student;
            }
        });
        return lst;
    }

    public Student getStudentByRno(int rno) {
        List<Student> lst = template.query("select rno,name,qualification,percentage from Student where rno=" + rno, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student(resultSet.getInt("rno"), resultSet.getString("name"), resultSet.getString("qualification"), resultSet.getInt("percentage"));
                return student;
            }
        });
        return lst.get(0);
    }

    public int nextRollNo() {
        List<Student> lst = template.query("select max(rno) max from Student", new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student(resultSet.getInt("max"), "", "", 0);
                return student;
            }
        });
        int maxrno = lst.get(0).getRno();
        if (maxrno == 0) {
            maxrno = 1;
        } else {
            maxrno++;
        }
        return maxrno;
    }

    public void addStudent(Student student) {
        template.execute("insert into Student values(" + student.getRno() + ",'" + student.getName() + "','" + student.getQualification() + "'," + student.getPercentage() + ")");
    }

    public void updateStudent(Student student) {
        template.execute("update Student set name='" + student.getName() + "',qualification='" + student.getQualification() + "',percentage=" + student.getPercentage() + " where rno=" + student.getRno());
    }

    public void deleteStudent(int rno) {
        template.execute("delete from Student where rno=" + rno);
    }

}


