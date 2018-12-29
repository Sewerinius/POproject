package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.List;

public class Rubrum implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        StringBuilder builder = new StringBuilder();
        String[] sigs = command.split(",\\s*");

        for (String sig :
                sigs) {
            builder.append('\n' + sig + "\n\n");
            for (Judgment j :
                    judgments) {
                if (j.sigEquals(sig)) {
                    builder.append(j.toString());
                }
            }
        }

        return builder.toString();
    }
}

// rubrum II AKa 105/11, V Ca 264/11, III U 961/14