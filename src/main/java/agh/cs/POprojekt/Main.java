package agh.cs.POprojekt;

import agh.cs.POprojekt.commands.*;
import agh.cs.POprojekt.dataTypes.Judgment;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ICommand> commandMap = new HashMap<String, ICommand>();
        commandMap.put("help", new Help());
        commandMap.put("rubrum", new Rubrum());
        commandMap.put("content", new Content());
        commandMap.put("judge", new JudgeCommand());
        commandMap.put("judges", new Judges());
        commandMap.put("months", new Help());
        commandMap.put("courts", new Courts());
        commandMap.put("regulations", new Regulations());
        commandMap.put("jury", new Jury());

        try {
            Terminal terminal = TerminalBuilder.terminal();
            LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();
            PrintWriter writer = terminal.writer();

            File file;
            if(args.length == 0) file = new File(reader.readLine(System.getProperty("user.dir") + "> "));
            else file = new File(args[0]);

            while (!file.isDirectory()) {
                writer.println("Invalid directory");
                file = new File(reader.readLine(System.getProperty("user.dir") + "> "));
            }

            List<Judgment> judgments = new Loader().load(file);

            while (true) {
                String[] commandStr = reader.readLine("command> ").split("\\s", 2);
                ICommand command = commandMap.get(commandStr[0].toLowerCase());
                if (command == null) {
                    writer.println("Unknown command, type 'help' for help");
                    continue;
                }
                if (commandStr.length < 2) writer.println(command.run("", judgments));
                else writer.println(command.run(commandStr[1], judgments));
            }
//            System.out.println(commandMap.get("help").run("", judgments));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
