package org.iesfm.ProgramerTeam;

import java.util.Objects;
import java.util.Set;

public final class TeamManager extends Employee{
    private String team;
    private Set<String> projects;

    public TeamManager(int idEmployee, String name, int workedHours, String team, Set<String> projects) {
        super(idEmployee, name, workedHours);
        this.team = team;
        this.projects = projects;
    }

    @Override
    public void infoEmployee() {

    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Set<String> getProjects() {
        return projects;
    }

    public void setProjects(Set<String> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamManager that = (TeamManager) o;
        return Objects.equals(team, that.team) && Objects.equals(projects, that.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), team, projects);
    }

    @Override
    public String toString() {
        return "TeamManager{" +
                "team='" + team + '\'' +
                ", projects=" + projects +
                '}';
    }
}
