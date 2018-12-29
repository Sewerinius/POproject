package agh.cs.POprojekt;

import agh.cs.POprojekt.dataTypes.CourtType;
import agh.cs.POprojekt.dataTypes.Judge;
import agh.cs.POprojekt.dataTypes.Judgment;
import agh.cs.POprojekt.dataTypes.Regulation;
import agh.cs.POprojekt.deserializers.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Loader {
    private Gson gson;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public Loader() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        gson = gsonBuilder.create();
    }

    public List<Judgment> load(File dir) {
        List<Judgment> data = new ArrayList<Judgment>();
        for (File f :
                Objects.requireNonNull(dir.listFiles())) {
            if (f.isDirectory()) {
//                System.out.println(f.getAbsolutePath());
                data.addAll(load(f));
            } else {
                switch (FilenameUtils.getExtension(f.getName())) {
                    case "json":
                        List<Judgment> judgments = loadJSON(f);
                        if (judgments != null)
                            data.addAll(judgments);
                        break;
                    case "html":
                        Judgment judgment = loadHTML(f);
                        if (judgment != null)
                            data.add(judgment);
                        break;
                }
            }
        }
        return data;
    }

    private List<Judgment> loadJSON(File f) {
        try {
//            System.out.println(f.getName());
            BufferedReader reader = new BufferedReader(new FileReader(f));
            JsonObject jsonObject = gson.fromJson(reader, JsonElement.class).getAsJsonObject();
            return gson.fromJson(jsonObject.get("items"), new TypeToken<List<Judgment>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Judgment loadHTML(File f) {
        String signature;
        Date judgmentDate = null;
        ArrayList<Judge> judges = new ArrayList<>();
        CourtType courtType = null;
        ArrayList<Regulation> referencedRegulations = new ArrayList<>();

        StringBuilder content = new StringBuilder();

        try {
            Element body = Jsoup.parse(f, "UTF-8", "").body();
            Elements elements = body.select(".niezaznaczona");

            signature = body.select(".war_header").html().split("-")[0].trim();

            for (Element element :
                    elements) {
                switch (element.select(".lista-label").html()) {
                    case "Data orzeczenia":
                        try {
                            judgmentDate = df.parse(element.select(".info-list-value td").get(0).html());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
//                        System.out.println(judgmentDate);
                        break;
                    case "Sędziowie":
                        String[] judgeStrings = element.select(".info-list-value").html().split("<br>");
                        for (String judgeString :
                                judgeStrings) {
                            String[] judgeValues = judgeString.split("/");
                            if (judgeValues.length > 1)
                                judges.add(new Judge(judgeValues[0], judgeValues[1]));
                            else
                                judges.add(new Judge(judgeValues[0], ""));
                        }
                        break;
                    case "Sąd":
                        courtType = CourtType.fromString(element.select(".info-list-value").html().split(" ")[0]);
                        break;
                    case "Powołane przepisy":
                        Elements regulationLinkElements = element.select(".info-list-value a");
                        Elements regulationTextElements = element.select(".info-list-value span");
                        for (int i = 0; i < regulationLinkElements.size(); i++) {
                            String[] regulationIdentification = regulationLinkElements.get(i).html().split(" ");
                            referencedRegulations.add(new Regulation(regulationTextElements.get(i).html(),
                                    parseInt(regulationIdentification[1]),
                                    parseInt(regulationIdentification[3]),
                                    parseInt(regulationIdentification[5])));
                        }
                        break;
                    case "Sentencja":
                        content.append("Sentencja\n");
                        content.append(element.select(".info-list-value-uzasadnienie").html());
                        content.append('\n');
                        break;
                    case "Uzasadnienie":
                        content.append("Uzasadnienie\n");
                        content.append(element.select(".info-list-value-uzasadnienie").html());
                        content.append('\n');
                        break;
                    default:
//                        System.out.println(element.select(".lista-label").html());
                        break;
                }
//                System.out.println(element.html());
//                System.out.println();
            }
//            System.exit(0);
            return new Judgment(signature,
                    judges.toArray(new Judge[0]),
                    courtType,
                    referencedRegulations.toArray(new Regulation[0]),
                    content.toString(),
                    judgmentDate);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
