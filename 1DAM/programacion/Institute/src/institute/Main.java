package institute;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static Student createStudent(){
        System.out.println("Introduzca el nombre del alumno...");
        String name = scan.next();
        System.out.println("Introduzca el primer apellido del alumno...");
        String surname1 = scan.next();
        System.out.println("Introduzca el segundo apellido del alumno...");
        String surname2 = scan.next();
        System.out.println("Introduzca el codigo postal...");
        int postCode = scan.nextInt();
        return new Student(name, surname1, surname2, postCode);
    }
    static Student[] createStudents(){
        System.out.println("Introduzca cuantos alumnos hay en el grupo...");
        int amount = scan.nextInt();
        while (amount < 1){
            System.out.println("Tiene que haber al menos un estudiante en el grupo. Por favor introduzca cuantos alumnos hay en el grupo...");
            amount = scan.nextInt();
        }
        Student[] students = new Student[amount];
        for (int i = 0; i < amount; i++) {
            students[i] = createStudent();
        }
        return students;
    }
    static Group createGroup(){
        System.out.println("Introduzca el nombre del grupo...");
        String name = scan.next();
        System.out.println("Introduzca el numero de aula en la que da clase el grupo...");
        int classroom = scan.nextInt();
        while (classroom < 0){
            System.out.println("El numero de aula no puede ser un numero negativo. Por favor introduzca el numero de aula en la que da clase el grupo...");
            classroom = scan.nextInt();
        }
        return new Group(name, classroom,createStudents());
    }
    static Group[] createGroups(){
        System.out.println("Indique cuantos grupos existen en el instituto...");
        int amount = scan.nextInt();
        while (amount < 1){
            System.out.println("Tiene que existir al menos un grupo en el instituto. Por favor introduzca cuantos grupos existen en el instituto...");
            amount = scan.nextInt();
        }
        Group[] groups = new Group[amount];
        for (int i = 0; i < amount; i++) {
            groups[i] = createGroup();
        }
        return groups;
    }
    static Institute creatInstitute(){
        System.out.println("Indique el nombre del instituto....");
        String name = scan.nextLine();
        return new Institute(name, createGroups());
    }

    public static void main(String[] args) {
        Institute institute = creatInstitute();
        institute.instituteInfo();
    }
}
