package university;

import java.util.ArrayList;
import java.util.List;

public class Class {
    String name;
    String classRoom;
    Teacher teacher;
    List<Student>  students;

    public Class(String name, String classRoom) {
        this.name = name;
        this.classRoom = classRoom;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        this.students.remove(student);
    }
    public void removeStudent(String id){
        for(Student student : students){
            if(student.getId().equals(id)){
                students.remove(student);
            }
        }
    }
    public String toString() {
        return "Nombre: " + name + ", class room: " + classRoom;
    }
    public String extraInfo() {
        StringBuilder extraInfo = new StringBuilder("Profesor - " + teacher + "\nEstudiantes:\n");
        for (int i = 0; i < students.size(); i++) {
            String line = (i+1) + ". " + students.get(i) + "\n";
            extraInfo.append(line);
        }
        return extraInfo.toString();
    }
}
