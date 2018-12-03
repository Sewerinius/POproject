package agh.cs.POprojekt.dataTypes;

import java.util.Arrays;
import java.util.Date;

public class Judgment {
    public int id;
    CourtType courtType;
    CourtCase[] courtCases;
    JudgmentType judgmentType;
    Judge[] judges;
    public Source source;
    String[] courtReporters;
    String decision;
    String summary;
    String textContent;
    String[] legalBases;
    Regulation[] referencedRegulations;
    String[] keywords;
    CourtCase[] referencedCourtCases;
    Date receiptDate;
    String meansOfAppeal;
    String judgmentResult;
    String[] lowerCourtJudgments;
    PersonelType personelType;


    @Override
    public String toString() {
        return "Judgment{" +
                "id=" + id +
                ", courtType=" + courtType +
                ", courtCases=" + Arrays.toString(courtCases) +
                ", judgmentType=" + judgmentType +
                ", judges=" + Arrays.toString(judges) +
                ", source=" + source +
                ", courtReporters=" + Arrays.toString(courtReporters) +
                ", decision='" + decision + '\'' +
                ", summary='" + summary + '\'' +
                ", textContent='" + textContent + '\'' +
                ", legalBases=" + Arrays.toString(legalBases) +
                ", referencedRegulations=" + Arrays.toString(referencedRegulations) +
                ", keywords=" + Arrays.toString(keywords) +
                ", referencedCourtCases=" + Arrays.toString(referencedCourtCases) +
                ", receiptDate=" + receiptDate +
                ", meansOfAppeal='" + meansOfAppeal + '\'' +
                ", judgmentResult='" + judgmentResult + '\'' +
                ", lowerCourtJudgments=" + Arrays.toString(lowerCourtJudgments) +
                '}';
    }
}
