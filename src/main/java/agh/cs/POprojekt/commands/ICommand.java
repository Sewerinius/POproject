package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.List;

public interface ICommand {
    public String run(String command, List<Judgment> judgments);
}
