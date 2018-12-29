package agh.cs.POprojekt.dataTypes;

import java.util.ArrayList;
import java.util.Arrays;

public class Judge {
    private String name;
    private String function;
    private SpecialRole[] specialRoles;

    public Judge(String name, String specialRoles) {
        this.name = name;
        ArrayList<SpecialRole> specialRoleArrayList = new ArrayList<>();
        if (!specialRoles.equals("")) {
            for (String specialRole :
                    specialRoles.split(" ")) {
                specialRoleArrayList.add(SpecialRole.fromString(specialRole));
            }
            this.specialRoles = specialRoleArrayList.toArray(new SpecialRole[0]);
        } else {
            this.specialRoles = new SpecialRole[0];
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nJudge{" +
                "name='" + name + '\'' +
                ((function != null) ? ", function='" + function + '\'' : "") +
                ", specialRoles=" + Arrays.toString(specialRoles) +
                "}";
    }
}
