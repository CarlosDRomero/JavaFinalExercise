package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Class>  classes = new ArrayList<>();

    public static void addStudent(Student s) {
        students.add(s);
    }
    public static void addStudent(String name, String id, int age) {
        Student student = new Student(name, id, age);
        addStudent(student);
    }
    public static void removeStudent(Student student) {
        students.remove(student);
    }
    public static void removeStudent(String id){
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
            }
        }
    }
    public static void addTeacher(Teacher t) {
        teachers.add(t);
    }
    public static void addTeacher(String name, float baseSalary, float other, boolean fullTime) {
        Teacher teacher;
        if  (fullTime) {
            teacher = new FullTimeTeacher(name, baseSalary, other);
        }else{
            teacher = new PartTimeTeacher(name, baseSalary, other);
        }
        addTeacher(teacher);
    }
    public static void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }
    public static void addClass(Class c){
        classes.add(c);
    }
    public static void addClass(String name, String classRoom) {
        Class c = new Class(name, classRoom);
        addClass(c);
    }
    public static void removeClass(Class c) {
        classes.remove(c);
    }
    public static Student getStudent(int index){
        return index >= 0 ? students.get(index) : null;
    }
    public static Student getStudent(String id){
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public static Teacher getTeacher(int index){
        return index >= 0 ? teachers.get(index) : null;
    }
    public static Class getClass(int index){
        return index >= 0 ? classes.get(index) : null;
    }


}
