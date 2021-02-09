package org.iesfm.library;

import java.util.Objects;

public class Member {
    private String nif;
    private String name;
    private String surnames;
    private int numberMember;
    private int postCode;

    public Member(String nif, String name, String surnames, int numberMember, int postCode) {
        this.nif = nif;
        this.name = name;
        this.surnames = surnames;
        this.numberMember = numberMember;
        this.postCode = postCode;
    }

    public void info() {
        System.out.println("DNI: " + nif + ". Nombre: " + name + ". Apellidos: " + surnames + ". Numero de socio: " + numberMember + ". CP: " + postCode);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
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
        Member member = (Member) o;
        return numberMember == member.numberMember && postCode == member.postCode && Objects.equals(nif, member.nif) && Objects.equals(name, member.name) && Objects.equals(surnames, member.surnames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surnames, numberMember, postCode);
    }

    @Override
    public String toString() {
        return "Member{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", numberMember=" + numberMember +
                ", postCode=" + postCode +
                '}';
    }
}
