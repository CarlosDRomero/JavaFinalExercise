import university.*;
import university.Class;

public class Main {
    public static void main(String[] args) {
        /*Inicialización de profesores*/
//        // También se pueden añadir directamente pasando parametros a University.addTeacher, Cuando fullTime es true, other representa los años de experiencia
//        University.addTeacher("José", 1423000f, 3f, true);
//        University.addTeacher("María", 1800000, 5f, true);
        // Cuando fullTime es false, other representa las horas que trabaja a la semana
//        University.addTeacher("Paola", 1423000f, 25f, false);
//        University.addTeacher("Andrés", 1720000, 30f, false);
        // Esta vez decido instanciarlos por separado, ya que me sirve para tener las referencias y asignar estudiantes y profesores a clases
        Teacher fullTime1 = new FullTimeTeacher("José", 1423000f, 3f);
        Teacher fullTime2 = new FullTimeTeacher("María", 1800000, 5f);
        Teacher partTime1 = new PartTimeTeacher("Paola", 1423000f, 25f);
        Teacher partTime2 = new PartTimeTeacher("Andrés", 1720000, 30f);
        University.addTeacher(fullTime1);
        University.addTeacher(fullTime2);
        University.addTeacher(partTime1);
        University.addTeacher(partTime2);
        /*Inicialización de estudiantes*/
        Student student1 = new Student("Manuel Sanchez", "808081", 18);
        University.addStudent(student1);

        Student student2 = new Student("María Garzón", "707071", 23);
        University.addStudent(student2);

        Student student3 = new Student("Antonio Bernal", "807091", 19);
        University.addStudent(student3);

        Student student4 = new Student("Lucía Fernández", "909101", 21);
        University.addStudent(student4);

        Student student5 = new Student("Jorge Ramírez", "606061", 20);
        University.addStudent(student5);

        Student student6 = new Student("Camila Ortega", "505051", 22);
        University.addStudent(student6);

        Student student7 = new Student("Joaquín Restrepo", "101020", 25);
        University.addStudent(student7);

        /*Inicialización de clases (Class)*/
        Class class1 = new Class("Matemáticas 1", "Aula pregrado 201");
        class1.setTeacher(fullTime1);
        class1.addStudent(student1);
        class1.addStudent(student3);
        class1.addStudent(student7);

        University.addClass(class1);

        Class class2 = new Class("Diseño orientado a objetos", "Lab. Informática 315");
        class2.setTeacher(partTime1);
        class2.addStudent(student2);
        class2.addStudent(student3);
        class2.addStudent(student5);

        University.addClass(class2);

        Class class3 = new Class("Aspectos Económicos", "Aula pregrado 203");
        class3.setTeacher(partTime2);
        class3.addStudent(student1);
        class3.addStudent(student4);
        class3.addStudent(student7);

        University.addClass(class3);

        Class class4 = new Class("Metodología de investigación", "Aula pregrado 301");
        class4.setTeacher(fullTime2);
        class4.addStudent(student6);
        class4.addStudent(student7);

        University.addClass(class4);

        

    }
}
