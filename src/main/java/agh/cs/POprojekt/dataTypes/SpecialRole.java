package agh.cs.POprojekt.dataTypes;

public enum SpecialRole {
    PRESIDING_JUDGE, REPORTING_JUDGE, REASONS_FOR_JUDGMENT_AUTHOR;

    public static SpecialRole fromString(String s) {
        switch (s) {
            case "przewodniczący":
                return PRESIDING_JUDGE;
            case "sprawozdawca":
                return REPORTING_JUDGE;
            default:
                System.out.print("Unknown SpecialRole string: '");
                System.out.print(s);
                System.out.println("'");
                return null;
        }
    }
}
