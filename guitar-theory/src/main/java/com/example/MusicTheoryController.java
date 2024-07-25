package com.example;

import java.util.ArrayList;
import java.util.List;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class MusicTheoryController {
    public static void main(String[] args) {
        Spark.staticFiles.location("/public");

        Spark.post("/submit", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String genre = request.queryParams("genre");
                String key = request.queryParams("key");

                List<String> imageNames = getImageNames(genre, key);
                if (!imageNames.isEmpty()) {
                    return String.join(",", imageNames);
                } else {
                    return "File not found";
                }
            }
        });
    }

    private static List<String> getImageNames(String genre, String key) {
        List<String> imageNames = new ArrayList<>();
        if ("rock".equalsIgnoreCase(genre)) {
            if ("a".equalsIgnoreCase(key)) {
                imageNames.add("a_minor_pentatonic.png");
                imageNames.add("a_major_pentatonic.png");
                imageNames.add("a_harmonic_minor.png");
                imageNames.add("a_blues.png");
            }
            // Add more conditions here for other scales and keys
        }
        return imageNames;
    }
}


//http://localhost:4567
//mvn clean install
//mvn exec:java
