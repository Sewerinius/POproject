package agh.cs.POprojekt.commands;

import agh.cs.POprojekt.dataTypes.Judgment;

import java.util.List;

public class Help implements ICommand {
    @Override
    public String run(String command, List<Judgment> judgments) {
        return "rubrum\t\t\twyświetlenie metryki jednego lub wielu orzeczeń, na podstawie sygnatury\n" +
                "content\t\t\twyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa \"UZASADNIENIE\")\n" +
                "judge\t\t\twyświetla liczbę orzeczeń dla wybranego sędziego\n" +
                "judges\t\t\twyświetla 10 sędziów, którzy wydali najwięcej orzeczeń\n" +
                "months\t\t\twyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)\n" +
                "courts\t\t\twyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)\n" +
                "regulations\t\twyświetlał 10 najczęściej przywoływanych ustaw\n" +
                "jury\t\t\twyświetlał liczbę spraw przypadających na określony skład sędziowski (określoną liczbę sędziów)\n";
    }
}
