package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/java/org/example/data.json");
        UpdateService updateService = new UpdateService();

        try {
            JsonNode node = mapper.readTree(new File("src/main/java/org/example/data.json"));

            //update method
            updateService.updateNameFields(node,"new");

            //writing updated value to Json
            mapper.writeValue(file,node);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}