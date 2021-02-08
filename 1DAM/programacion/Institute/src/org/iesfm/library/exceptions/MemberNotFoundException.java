package org.iesfm.library.exceptions;

import java.util.Objects;

public class MemberNotFoundException extends Exception{

    private String nif;

    public MemberNotFoundException(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberNotFoundException that = (MemberNotFoundException) o;
        return Objects.equals(nif, that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }
}
