package org.iesfm.Employees;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EployeesTest {

    private Team team = new Team("", new HashSet<Employee>());

    @Before
    public void setUp(){
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee(1, "Juan Diaz", 30, team.PROGRAMER));
        employees.add(new Employee(2, "Sara Perez", 38, team.PROGRAMER));
        employees.add(new Employee(5, "Sergio Trujillo", 52, team.SCRUMMASTER));
        employees.add(new Employee(17, "Julian Lopez", 47, team.TEAMMANAGER));

        team = new Team("Team 1", employees);
    }

    @Test
    public void showEmployeesInfoTest(){
        team.showEmployeesInfo();
    }
}
