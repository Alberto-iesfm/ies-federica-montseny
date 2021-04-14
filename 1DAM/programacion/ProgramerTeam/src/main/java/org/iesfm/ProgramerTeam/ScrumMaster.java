package org.iesfm.ProgramerTeam;

import java.util.Objects;
import java.util.Set;

public final class ScrumMaster extends Employee{
    private Set<String> teams;

    public ScrumMaster(int idEmployee, String name, int workedHours, Set<String> teams) {
        super(idEmployee, name, workedHours);
        this.teams = teams;
    }

    @Override
    public void infoEmployee() {

    }

    public Set<String> getTeams() {
        return teams;
    }

    public void setTeams(Set<String> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScrumMaster that = (ScrumMaster) o;
        return Objects.equals(teams, that.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teams);
    }

    @Override
    public String toString() {
        return "ScrumMaster{" +
                "teams=" + teams +
                '}';
    }
}
