package Cuma;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class log {
    private static String MY_PATH = "C:\\Users\\TCTGURELI\\Desktop\\message\\logtest.txt";
    private static File file = new File(MY_PATH);
    public static void message(String message) throws IOException {

        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss", locale);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MY_PATH, true))) {
            bufferedWriter.write(dateFormat.format(new Date()) + " " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String createdDate() {
        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss", locale);
        return dateFormat.format(new Date());
    }

}
