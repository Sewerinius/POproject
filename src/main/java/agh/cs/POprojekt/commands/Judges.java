package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judge;
import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.*;
import java.util.stream.Collectors;

public class Judges implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder builder = new StringBuilder();

        HashMap<String, Integer> judgesCount = new HashMap<>();
        for (Judgment judgment : judgments) {
            for (Judge judge : judgment.getJudges()) {
                if (judgesCount.containsKey(judge.getName()))
                    judgesCount.replace(judge.getName(), judgesCount.get(judge.getName()) + 1);
                else
                    judgesCount.put(judge.getName(), 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(judgesCount.entrySet());
        sortedEntries.sort(Comparator.comparing(Map.Entry::getValue));
        for (int i = 0; i < 10; i++) {
            builder.append(i + 1).append(' ')
                    .append(sortedEntries.get(sortedEntries.size() - i - 1).getKey()).append(' ')
                    .append(sortedEntries.get(sortedEntries.size() - i - 1).getValue()).append('\n');
        }
        return builder.toString();
    }
}
