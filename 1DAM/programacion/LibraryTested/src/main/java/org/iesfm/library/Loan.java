package org.iesfm.library;

import java.util.Objects;

public class Loan {
    private int ibsn;
    private String dateLoan;
    private String nifMember;
    private String dateReturn;

    public Loan(int ibsn, String dateLoan, String nifMember, String dateReturn) {
        this.ibsn = ibsn;
        this.dateLoan = dateLoan;
        this.nifMember = nifMember;
        this.dateReturn = dateReturn;
    }

    public int getIbsn() {
        return ibsn;
    }

    public void setIbsn(int ibsn) {
        this.ibsn = ibsn;
    }

    public String getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(String dateLoan) {
        this.dateLoan = dateLoan;
    }

    public String getNifMember() {
        return nifMember;
    }

    public void setNifMember(String nifMember) {
        this.nifMember = nifMember;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return ibsn == loan.ibsn && Objects.equals(dateLoan, loan.dateLoan) && Objects.equals(nifMember, loan.nifMember) && Objects.equals(dateReturn, loan.dateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ibsn, dateLoan, nifMember, dateReturn);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ibsn=" + ibsn +
                ", dateLoan='" + dateLoan + '\'' +
                ", nifMember='" + nifMember + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                '}';
    }

}
