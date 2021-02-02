package institute;

import java.util.Arrays;
import java.util.Objects;

public class Group {
    private String name;
    private int classroom;
    private Student[] students;

    public Group(String name, int classroom, Student[] students) {
        this.name = name;
        this.classroom = classroom;
        this.students = students;
    }

    public void groupInfo(){
        System.out.println("Grupo: " + name + "; Aula: " + classroom);
        System.out.println("Alumnos:");
        for (Student student:students) {
            student.studentInfo();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return classroom == group.classroom && Objects.equals(name, group.name) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, classroom);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
