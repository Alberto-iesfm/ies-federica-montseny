package org.iesfm.company;

import java.util.Arrays;
import java.util.Objects;

public class Company implements ICompany{

    private String name;
    private String cif;
    private Employee[] employees;
    private Department[] departments;

    public Company(String name, String cif, Employee[] employees, Department[] departments) {
        this.name = name;
        this.cif = cif;
        this.employees = employees;
        this.departments = departments;
    }

    @Override
    public void printDepartmentNames() {
        System.out.println("La empresa tiene los siguientes departamentos:");
        for (Department department : departments){
            System.out.println(department.getName() + ".");
        }
    }

    private Department findDepartment(String depName){
        Department depSearched = null;
        for (Department department : departments){
            if (department.getName().equals(depName)){
                depSearched = department;
            }
        }
        return depSearched;
    }

    @Override
    public Employee[] getDepartmentEmployees(String depName) {
        Employee[] depEmployees = null;
        Department department = findDepartment(depName);
        if (department != null){
            depEmployees = department.getEmployees();
        } else {
            System.out.println("¡No existe este departamento!");
        }
        return depEmployees;
    }

    @Override
    public void printDepartmentEmployees(String depName) {
        Employee[] depEmployees = getDepartmentEmployees(depName);
        if (depEmployees != null) {
            System.out.println("Empleados del departamento de " + depName + " :");
            for (Employee employee : depEmployees){
                employee.info();
            }
        } else {
            System.out.println("¡No existen empleados en el departamento de" + depName + "!");
        }
    }

    @Override
    public void printEmployees() {
        System.out.println("Empleados:");
        for (Department department : departments){
            printDepartmentEmployees(department.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(cif, company.cif) && Arrays.equals(employees, company.employees) && Arrays.equals(departments, company.departments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, cif);
        result = 31 * result + Arrays.hashCode(employees);
        result = 31 * result + Arrays.hashCode(departments);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", cif='" + cif + '\'' +
                ", employees=" + Arrays.toString(employees) +
                ", departments=" + Arrays.toString(departments) +
                '}';
    }
}
