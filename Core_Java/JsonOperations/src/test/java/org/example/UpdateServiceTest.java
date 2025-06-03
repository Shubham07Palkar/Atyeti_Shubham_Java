package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UpdateServiceTest {

    private UpdateService updateService;
    private ObjectMapper mapper;

    @BeforeEach
    void setUpdateService(){
        updateService=new UpdateService();
        mapper = new ObjectMapper();
    }

    @org.junit.jupiter.api.Test
    void updateNameFields() throws IOException {
        String inputJson = "src/main/resources/sample.json";

        JsonNode node = mapper.readTree(new File(inputJson));
        String originalJson = node.toString();

        updateService.updateNameFields(node, "updated");

        assertEquals(originalJson,node.toString());
    }

    @Test
    void testEmptyJsonObject() throws JsonProcessingException {
        JsonNode node = mapper.readTree("{}");

        updateService.updateNameFields(node, "new");

        assertEquals(0,node.size());
    }

    @Test
    void testCase_Sensitive() throws IOException {
        String inputJson = "src/main/resources/sample.json";
        JsonNode node = mapper.readTree(new File(inputJson));

        updateService.updateNameFields(node,"Capitalized");

        mapper.writeValue(new File(inputJson),node);

        assertEquals("Capitalized", node.get("name"));
//        assertEquals("capital",node.get("Name"));

    }
}