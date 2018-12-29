package agh.cs.POprojekt.dataTypes;

import java.util.Objects;

public class Regulation {
    private String journalTitle;
    private int journalYear;
    private int journalNo; //Ignore
    private int journalEntry;
    private String text;

    public Regulation(String journalTitle, int journalYear, int journalNo, int journalEntry) {
        this.journalTitle = journalTitle;
        this.journalYear = journalYear;
        this.journalNo = journalNo;
        this.journalEntry = journalEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regulation that = (Regulation) o;
        return journalYear == that.journalYear &&
                journalEntry == that.journalEntry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(journalYear, journalEntry);
    }

    public String getTitle() {
        return journalTitle;
    }
}
