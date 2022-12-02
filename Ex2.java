import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.
public class Ex2 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(Ex2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        int[] array = new int[] { 84, 45, 372, 955, 10, 56, 6, 43 };
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                    logger.addHandler(fh);
                    SimpleFormatter sF = new SimpleFormatter();
                    fh.setFormatter(sF);
                    logger.info(Arrays.toString(array));
                }

            }
        }
        System.out.print(Arrays.toString(array));
    }
}
