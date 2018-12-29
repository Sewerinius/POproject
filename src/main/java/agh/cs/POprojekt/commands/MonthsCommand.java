package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.Calendar;
import java.util.List;

public class MonthsCommand implements ICommand {
    Calendar cal = Calendar.getInstance();

    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] monthCount = new int[12];
        for (Judgment j :
                judgments) {
            cal.setTime(j.getJudgmentDate());
            monthCount[cal.get(Calendar.MONTH)]++;
        }
        for (int i = 0; i < 12; i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(monthCount[i]);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
