package org.iesfm.ProgramerTeam;

import java.util.List;
import java.util.Objects;

public final class Programer extends Employee{
    private List<String> languages;
    private String team;

    public Programer(int idEmployee, String name, int workedHours, List<String> languages, String team) {
        super(idEmployee, name, workedHours);
        this.languages = languages;
        this.team = team;
    }

    @Override
    public void infoEmployee() {

    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programer programer = (Programer) o;
        return Objects.equals(languages, programer.languages) && Objects.equals(team, programer.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languages, team);
    }

    @Override
    public String toString() {
        return "Programer{" +
                "languages=" + languages +
                ", team='" + team + '\'' +
                '}';
    }
}
