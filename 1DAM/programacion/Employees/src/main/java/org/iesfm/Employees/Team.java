package org.iesfm.Employees;

import java.util.Objects;
import java.util.Set;

public class Team {
    public final String PROGRAMER = "Programer";
    public final String SCRUMMASTER = "Scrum Master";
    public final String TEAMMANAGER = "Team Manager";

    private String name;
    private Set<Employee> employees;

    public Team(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public void showEmployeesInfo(){
        for (Employee employee:employees){
            employee.info();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(employees, team.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employees);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
