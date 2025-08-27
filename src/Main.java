import university.*;
import university.Class;

import java.util.Scanner;

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
        Teacher partTime1 = new PartTimeTeacher("Paola", 70000, 25f);
        Teacher partTime2 = new PartTimeTeacher("Andrés", 95000, 30f);
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
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("Bienvenido al sistema de la universidad");
        do{
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Mostrar profesores");
            System.out.println("2. Ver clases");
            System.out.println("3. Crear y agregar estudiante a clase");
            System.out.println("4. Crear clase");
            System.out.println("5. Listar clases por estudiante");
            System.out.println("6. Salir");
            System.out.print("Digite una opción: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Listado de profesores");
                    for (int i = 0; i<University.getTeachersCount(); i++) {
                        Teacher t = University.getTeacher(i);
                        System.out.println((i+1)+". " + t);
                    }
                    break;
                case 2: {
                    int option2;
                    Class selectedClass = null;
                    do{
                        System.out.println("Seleccione una clase para ver más información");
                        int classesCount = University.getClassesCount();
                        for (int i = 0; i<classesCount; i++) {
                            Class c = University.getClass(i);
                            System.out.println((i+1)+". " + c);
                        }
                        System.out.println(University.getClassesCount()+1 + ". Volver");
                        System.out.print("Seleccione al estudiante según la numeración de la izquierda: ");
                        option2 = sc.nextInt();
                        if(option2>=1 && option2 <= classesCount){
                            selectedClass = University.getClass(option2 - 1);
                        }else if (option2 == classesCount + 1) break;
                        else System.out.println("Opcion no válida");
                    }while(selectedClass==null);
                    if (selectedClass != null) System.out.println(selectedClass.extraInfo());
                    break;
                }
                case 3:{
                    String id, name;
                    int age;

                    System.out.print("Introduce el ID del estudiante: ");
                    id = sc.nextLine();
                    if (id.isEmpty() || University.getStudent(id) != null) {
                        System.out.println("La ID ingresada no es válida");
                        break;
                    }
                    System.out.print("Introduce el nombre del estudiante: ");
                    name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío");
                        break;
                    }
                    System.out.print("Introduce el edad del estudiante: ");
                    age = sc.nextInt();
                    if (age<1 || age>100) {
                        System.out.println("La edad ingresada no es válida");
                        break;
                    }
                    Student newStudent = new Student(id, name, age);
                    University.addStudent(newStudent);


                    int option2;
                    Class selectedClass = null;
                    do{
                        int classesCount = University.getClassesCount();
                        System.out.println("Seleccione una clase para agregar al estudiante");
                        for (int i = 0; i<classesCount; i++) {
                            Class c = University.getClass(i);
                            System.out.println((i+1)+". " + c);
                        }
                        System.out.println(University.getClassesCount()+1 + ". Volver");
                        System.out.print("Seleccione la clase según la numeración de la izquierda: ");
                        option2 = sc.nextInt();
                        if(option2>=1 && option2 <= classesCount){
                            selectedClass = University.getClass(option2 - 1);
                        }else if (option2 == classesCount + 1) break;
                        else System.out.println("Opcion no válida");
                    }while(selectedClass==null);
                    if (selectedClass != null) {
                        selectedClass.addStudent(newStudent);
                        System.out.println("Estudiante agregado a la clase " +  selectedClass.getName());
                    }
                }
                case 4:{
                    String name, classRoom;
                    System.out.print("Introduce el nombre de la clase: ");
                    name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío");
                        break;
                    }
                    System.out.println("Introduce el nombre del salón de clase: ");
                    classRoom = sc.nextLine();
                    if (classRoom.isEmpty()) {
                        System.out.println("El nombre del salón no puede estar vacío");
                        break;
                    }
                    Class newClass = new Class(name, classRoom);
                    University.addClass(newClass);
                    System.out.println("Clase creada: " +  newClass);
                    int option2;
                    Teacher selectedTeacher = null;
                    do{
                        int count = University.getTeachersCount();
                        System.out.println("Seleccione un profesor para asignar a la clase");
                        for (int i = 0; i<count; i++) {
                            Teacher t = University.getTeacher(i);
                            System.out.println((i+1)+". " + t);
                        }
                        System.out.println(University.getTeachersCount()+1 + ". Omitir");
                        System.out.print("Seleccione al profesor según la numeración de la izquierda: ");
                        option2 = sc.nextInt();
                        if(option2>=1 && option2 <= count){
                            selectedTeacher = University.getTeacher(option2 - 1);
                        }else if (option2 == count + 1) break;
                        else System.out.println("Opcion no válida");
                    }while(selectedTeacher==null);
                    if (selectedTeacher != null) {
                        newClass.setTeacher(selectedTeacher);
                        System.out.println("Se asignó el profesor: " +  selectedTeacher.getName());
                    }
                    int studentCount = University.getStudentsCount();
                    do{
                        System.out.println("Seleccione un estudiante para asignar a la clase");
                        for (int i = 0; i<studentCount; i++) {
                            Student s = University.getStudent(i);
                            if (newClass.getStudent(s.getId()) == null)
                                System.out.println((i+1)+". " + s);
                        }
                        System.out.println(University.getStudentsCount()+1 + ". Omitir");
                        System.out.print("Seleccione al estudiante según la numeración de la izquierda: ");
                        option2 = sc.nextInt();
                        boolean invalidOption = option2 <= 0 || option2 >= studentCount + 1;
                        if (!invalidOption && option2 <= studentCount){
                            Student s = University.getStudent(option2 - 1);
                            if (newClass.getStudent(s.getId()) == null) {
                                newClass.addStudent(s);
                                System.out.println("Estudiante asignado a la clase: " +  s.getName());
                                continue;
                            }
                            invalidOption = true;
                        }
                        if (invalidOption) System.out.println("Opcion no válida");

                    }while(option2!= studentCount + 1);
                }
                case 5:{
                    int option2;
                    int studentCount = University.getStudentsCount();
                    do{
                        System.out.println("Seleccione un estudiante para ver sus clases");
                        for (int i = 0; i<studentCount; i++) {
                            Student s = University.getStudent(i);
                            System.out.println((i+1)+". " + s);
                        }
                        System.out.println(University.getStudentsCount()+1 + ". Omitir");
                        System.out.print("Seleccione al estudiante según la numeración de la izquierda: ");
                        option2 = sc.nextInt();
                        boolean invalidOption = option2 <= 0 || option2 >= studentCount + 1;
                        if (invalidOption) System.out.println("Opcion no válida");
                        else if (option2 <= studentCount){
                            Student s = University.getStudent(option2 - 1);
                            System.out.println("Clases de " + s.getName());
                            int i = 1;
                            for (Class c : University.getClasses()) {
                                if (c.getStudent(s.getId()) != null){
                                    // Aquí aprovecho para enumerar las clases, usando el valor de i, e incrementandolo de una vez para la siguiente iteración si vuelve a cumplirse esta condición
                                    System.out.println((i++)+". " + c);
                                }
                            }
                        }

                    }while(option2!= studentCount + 1);
                }
                default:
                    System.out.println("Opción inválida");
            }
        }while(option != 6);

    }
}
