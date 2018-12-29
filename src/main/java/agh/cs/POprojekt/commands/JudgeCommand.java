package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.List;

public class JudgeCommand implements ICommand {

    @Override
    public String run(String command, List<Judgment> judgments) {
        int count = 0;
        for (Judgment judgment :
                judgments) {
            if (judgment.hasJudge(command)) count++;
        }
        return Integer.toString(count);
    }
}
