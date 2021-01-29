package institute;

import java.util.Objects;

public class Student {
    private String name;
    private String surname1;
    private String surname2;
    private int postCode;

    public Student(String name, String surname1, String surname2, int postCode) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.postCode = postCode;
    }

    public void studentInfo() {
        System.out.println("Nombre: " + name + "; Apellidos: " + surname1 + " " + surname2 + "; Codigo postal: " + postCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return postCode == student.postCode && Objects.equals(name, student.name) && Objects.equals(surname1, student.surname1) && Objects.equals(surname2, student.surname2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname1, surname2, postCode);
    }
}
