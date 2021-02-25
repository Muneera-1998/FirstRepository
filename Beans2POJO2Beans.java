package Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Beans2POJO2Beans {
    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("EmployeeData.csv"));
        CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                .withType(Employee.class)
                .withSeparator(',')
                .build();

        Iterator<Employee> itr = csv.iterator();

        List<Employee> l1 = new LinkedList<Employee>();
        while (itr.hasNext()) {
            l1.add(itr.next());
        }

        for (Employee x : l1) {
            System.out.println(Json.Seralize.writeObjToString(x));
        }
    }
            private static String writeObjToString(Employee x) throws JsonProcessingException {
                return new ObjectMapper().writeValueAsString(x);
            }
        }




