package agh.cs.POprojekt;

import agh.cs.POprojekt.dataTypes.Judgment;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));



        List<Judgment> judgments = new Loader().load("json/test.json");

        System.out.println(judgments.toString());
    }


}
