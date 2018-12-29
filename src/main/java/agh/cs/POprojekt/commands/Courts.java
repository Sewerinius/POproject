package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.CourtCase;
import agh.cs.POprojekt.dataTypes.CourtType;
import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.HashMap;
import java.util.List;

public class Courts implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder builder = new StringBuilder();

        HashMap<CourtType, Integer> courtTypeIntegerHashMap = new HashMap<>();

        for (CourtType courtType :
                CourtType.values()) {
            courtTypeIntegerHashMap.put(courtType, 0);
        }
        for (Judgment judgment : judgments) {
            courtTypeIntegerHashMap.replace(judgment.getCourtType(), courtTypeIntegerHashMap.get(judgment.getCourtType()) + 1);
        }
        for (CourtType courtType :
                CourtType.values()) {
            builder.append(courtType).append(' ')
                    .append(courtTypeIntegerHashMap.get(courtType)).append('\n');
        }
        return builder.toString();
    }
}
