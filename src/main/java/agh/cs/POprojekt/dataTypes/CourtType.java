package agh.cs.POprojekt.dataTypes;

public enum CourtType {
    COMMON, SUPREME, ADMINISTRATIVE, CONSTITUTIONAL_TRIBUNAL, NATIONAL_APPEAL_CHAMBER;

    public static CourtType fromString(String s) {
        switch (s) {
            case "Naczelny":
                return SUPREME;
            case "Wojewódzki":
                return ADMINISTRATIVE;
            default:
                System.out.print("Unknown CourtType string: '");
                System.out.print(s);
                System.out.println("'");
                return null;
        }
    }
}
