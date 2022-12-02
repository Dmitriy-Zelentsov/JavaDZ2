// В файле содержится строка с исходными данными в такой форме: 
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

// Для разбора строки используйте String.split. 
// Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("Ex.txt"));
            String line;
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine()) != null){
                String str = line.replaceAll("[{}]", "");
                String [] parts = str.split(", ");

                for(String part : parts) {
                    String [] keyValue = part.split(":");
                    String key = keyValue[0].replaceAll("\"", "");
                    String value = keyValue[1];
                    String q = "null";

                    if (!value.replaceAll("\"", "").equals(q)){
                        builder.append(String.format(" AND %s = %s",key, value));
                    }
                }
                String res = builder.toString();
                res = res.substring(5);
               System.out.println("SELECT * FROM students WHERE " + res.toString());
            }
        }
        catch(IOException e){
            System.out.print("Erro: "+ e);
        }
        finally{
            br.close();
        }
    }
}