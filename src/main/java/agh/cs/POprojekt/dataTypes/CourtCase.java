package agh.cs.POprojekt.dataTypes;

public class CourtCase {
    String caseNumber;
    int[] judgmentIds;
    boolean generated;

    public CourtCase(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public String toString() {
        return "CourtCase{" +
                "caseNumber='" + caseNumber + '\'' +
                '}';
    }
}
