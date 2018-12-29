package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.*;

public class Jury implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder builder = new StringBuilder();
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (Judgment j :
                judgments) {
            if(counts.get(j.getJudges().length) == null)
                counts.put(j.getJudges().length, 1);
            else
                counts.put(j.getJudges().length, counts.get(j.getJudges().length) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry:
             entrySet) {
            builder.append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
        }
        return builder.toString();
    }
}
