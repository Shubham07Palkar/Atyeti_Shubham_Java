package org.shubham.fileHandler;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shubham.entity.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileHandler {
    private static ObjectMapper mapper = new ObjectMapper();
    private static String JSON_FILE_PATH = "src/main/java/org/shubham/data/students.json";

    public List<Student> loadStudents(){
        File file = new File(JSON_FILE_PATH);
        try {
            if (file.exists() && file.length()>0){
               return mapper.readValue(file, new TypeReference<List<Student>>() {
                });
            }
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void saveStudent(List<Student> Student){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE_PATH),Student);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
