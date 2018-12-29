package agh.cs.POprojekt.dataTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("unused")
public class Judgment {
    private int id;
    private CourtType courtType;
    private CourtCase[] courtCases; //TODO ***** tablice bierzemy pierwszego
    private JudgmentType judgmentType;
    private Judge[] judges;
    private Source source;
    private String[] courtReporters;
    private String decision;
    private String summary;
    private String textContent;
    private String[] legalBases;
    private Regulation[] referencedRegulations;
    private String[] keywords;
    private CourtCase[] referencedCourtCases;
    private Date receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private String[] lowerCourtJudgments;
    private PersonelType personelType;
    private Date judgmentDate;

    public Judgment(String signature, Judge[] judges, CourtType courtType, Regulation[] referencedRegulations, String textContent, Date judgmentDate) {
        this.courtCases = new CourtCase[] {new CourtCase(signature)};
        this.judges = judges;
        this.courtType = courtType;
        this.referencedRegulations = referencedRegulations;
        this.textContent = textContent;
        this.judgmentDate = judgmentDate;
    }

    public boolean sigEquals(String sig) {
        for (CourtCase cc :
                courtCases) {
            if (cc.caseNumber.equals(sig)) return true;
        }
        return false;
    }

    public boolean hasJudge(String judgeName) {
        for (Judge judge : judges) {
            if (judge.getName().equals(judgeName)) return true;
        }
        return false;
    }

    public Regulation[] getReferencedRegulations() {
        return referencedRegulations;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public Judge[] getJudges() {
        return judges;
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public String toString() {
        return "Judgment{\n" +
                "courtType=" + courtType +
                ",\ncourtCases=" + Arrays.toString(courtCases) +
                ",\njudges=" + Arrays.toString(judges) +
                ",\njudgmentDate=" + judgmentDate +
                "}\n";
    }
}
