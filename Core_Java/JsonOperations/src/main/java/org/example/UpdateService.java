package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.Map;

public class UpdateService {
    public void updateNameFields(JsonNode node, String newName) {
        if (node.isObject()) {
            ObjectNode objNode = (ObjectNode) node;

            Iterator<Map.Entry<String, JsonNode>> fields = objNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();

                if (key.equals("name")) {
                    objNode.put(key, newName);
                } else {
                    updateNameFields(value, newName);
                }
            }
        }else if(node.isArray()){
            for (JsonNode item:node){
                updateNameFields(item,newName);
            }
        }
    }
}
