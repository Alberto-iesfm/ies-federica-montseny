package org.iesfm.ProgramerTeam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class EmployeeTest {
    List<Employee> employees = new ArrayList<>();

    @Before
    public void setUp(){
        List<String> programer1Languages = new LinkedList<>();
        programer1Languages.add("Java");
        programer1Languages.add("CSS");
        programer1Languages.add("SQL");

        List<String> programer2Languages = new LinkedList<>();
        programer2Languages.add("CSS");
        programer2Languages.add("SQL");
        programer2Languages.add("HTML");

        Set<String> scrumMaster1Teams = new HashSet<>();
        scrumMaster1Teams.add("Desarollo Web");

        Set<String> scrumMaster2Teams = new HashSet<>();
        scrumMaster2Teams.add("Desarollo Web");
        scrumMaster2Teams.add("Programacion");

        Set<String> teamManager1Projects = new HashSet<>();
        teamManager1Projects.add("Base de datos web");
        teamManager1Projects.add("Pagina web");

        Set<String> teamManager2Projects = new HashSet<>();
        teamManager2Projects.add("Aplicacion interna");
        teamManager2Projects.add("Aplicacion de clientes");

        employees.add(new Programer(12, "Juan Perez", 25, programer1Languages, "Programacion"));
        employees.add(new Programer(25, "Pedro Lopez", 17, programer2Languages, "Desarollo web"));
        employees.add(new ScrumMaster(12, "Juan Gil", 50, scrumMaster1Teams));
        employees.add(new ScrumMaster(10, "Sofia Diaz", 42, scrumMaster2Teams));
        employees.add(new TeamManager(2, "Sergio Mata", 35, "Desarollo web", teamManager1Projects));
        employees.add(new TeamManager(6, "Julia Hernan", 38, "Programacion", teamManager2Projects));
    }

    @Test
    public void logWorkTest(){
        Employee result = employees.get(2);
        result.logWork(8);

        Assert.assertEquals(58, result.getWorkedHours());
    }

    @Test
    public void infoTest(){
        employees.get(2).infoEmployee();
    }

    @Test
    public void joinTeamTest(){
        Set<String> expected = new HashSet<>();
        expected.add("Desarollo Web");
        expected.add("Programacion");

        ScrumMaster scrumMaster = (ScrumMaster) employees.get(2);
        scrumMaster.joinTeam("Programacion");

        Assert.assertEquals(expected, scrumMaster.getTeams());
    }

    @Test (expected = ClassCastException.class)
    public void notScrumMasterJoinTeamTest(){
        ScrumMaster scrumMaster = (ScrumMaster) employees.get(1);
    }
}
