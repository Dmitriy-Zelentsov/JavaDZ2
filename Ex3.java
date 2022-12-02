// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и,
//  используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Ex3.txt"));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                line = line.substring(1, line.length() - 1);
                line = line.replaceAll("\\{", "");
                line = line.replaceAll("\\}", "");

                String [] dn = line.split(", ");

                for (int i = 0; i < dn.length; i++) {
                    String[] dn1 = dn[i].split(",");

                    for (int j = 0; j < dn1.length; j++) {
                        String[] dn2 = dn1[j].split(":");

                        String key = dn2[0];
                        key = key.substring(1, key.length() - 1);
                        String value = dn2[1];
                        value = value.substring(1, value.length() - 1);
                        builder.append(value);
                        builder.append(" ");
                    }
                }
            }

            String[] strArray = builder.toString().split(" ");

            for (int i = 0; i < strArray.length; i += 3) {

                System.out.println("Студент " + strArray[i] + " получил " + strArray[i + 1] + " по предмету "
                        + strArray[i + 2] + ".");

            }

        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}