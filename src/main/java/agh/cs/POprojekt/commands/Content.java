package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.List;

public class Content implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        for (Judgment j : judgments) {
            if (j.sigEquals(command))
                return j.getTextContent();
        }
        return "Signature '" + command + "' not found";
    }
}
