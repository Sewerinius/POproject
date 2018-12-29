package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;
import agh.cs.POprojekt.dataTypes.Regulation;

import java.util.*;

public class Regulations implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder builder = new StringBuilder();

        HashMap<Regulation, Integer> regulationsCount = new HashMap<>();
        for (Judgment judgment : judgments) {
            for (Regulation regulation : judgment.getReferencedRegulations()) {
                if (regulationsCount.containsKey(regulation))
                    regulationsCount.replace(regulation, regulationsCount.get(regulation) + 1);
                else
                    regulationsCount.put(regulation, 1);
            }
        }
        List<Map.Entry<Regulation, Integer>> sortedEntries = new ArrayList<>(regulationsCount.entrySet());
        sortedEntries.sort(Comparator.comparing(Map.Entry::getValue));
        for (int i = 0; i < 10; i++) {
            builder.append(i + 1).append('\t')
                    .append(sortedEntries.get(sortedEntries.size() - i - 1).getValue()).append('\t')
                    .append(sortedEntries.get(sortedEntries.size() - i - 1).getKey().getTitle()).append('\n');
        }
        return builder.toString();
    }
}
