package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    public List<Employee> loadEmployee(String inputFile) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values =line.split(",");
                int empId = Integer.parseInt(values[0].trim());
                String name = values[1];
                LocalDate date = LocalDate.parse(values[2]);
                int hours = Integer.parseInt(values[3].trim());

                employees.add(new Employee(date,empId,hours,name));
            }
        }
        return employees;
    }

    public void saveEmployee(String outputFile,List<Employee> employees) throws IOException {
        try(BufferedWriter brw = new BufferedWriter(new FileWriter(outputFile))){
            for(Employee emp: employees){
                brw.write(String.valueOf(emp));
            }
        }
    }
}
