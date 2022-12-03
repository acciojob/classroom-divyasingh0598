package com.driver;


import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository
{
    Map<String,Student> map_students;

    Map<String, Teacher> map_teacher;
    Map<String, String> map_pair;


    public StudentRepository()
    {
        map_students =  new HashMap<>();
        map_teacher =  new HashMap<>();
        map_pair = new HashMap<>();
    }


    public void addStudent( Student student)
    {
        map_students.put(student.getName(),student);
    }

    public void addTeacher( Teacher teacher)
    {
        map_teacher.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair( String student, String teacher)
    {
        map_pair.put(student,teacher);
    }

    public Student getStudentByName( String name)
    {
        return map_students.get(name);
    }

    public Teacher getTeacherByName( String name)
    {
        return map_teacher.get(name);
    }

    public List<String> getStudentsByTeacherName( String teacher)
    {
        List<String> ans = new ArrayList<>();
        for(String student_name : map_pair.keySet())
        {
            if(map_pair.get(student_name).equalsIgnoreCase(teacher)) ans.add(student_name);
        }
        return ans;
    }

    public List<String> getAllStudents()
    {
        List<String> ans = new ArrayList<>(map_students.keySet());
        return ans;
    }

    public void deleteTeacherByName( String teacher)
    {
        map_teacher.remove(teacher);

        List<String> temp = new ArrayList<>(map_pair.keySet());

        for(String student : temp)
        {
            if(map_pair.get(student).equalsIgnoreCase(teacher))
            {
                map_students.remove(student);
                map_pair.remove(student);
            }
        }
    }

    public void deleteAllTeachers()
    {
        for(String student : map_pair.keySet())
        {
            map_students.remove(student);
        }
        map_teacher = new HashMap<>();
        map_pair = new HashMap<>();
    }





}
