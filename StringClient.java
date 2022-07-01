package Cuma;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

// Two Way (Clint -Server String examples)
// Client Kullanýcýdan aldýðý veriyi Servera göndersin
// Client -Server yazýþmasýný File Yazdýrsýn.

// Unutma:
// 1-)öncelikle Server'ý çalýþtýrmalýsýn. Sonra Client'i çalýþtýrýyoruz.
// 2-) PSVM ==> Serverda olur.
// 3-) java.net kütüphanesini import ediyoruz

public class StringClient {

    public static void main(String[] args) {
        String receiveMessage;// mesaj almak
        String sendMessage; // mesa j göndersin

        try {
            Socket socket = new Socket("localhost", 8585);

            // Client veri gönderecek
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            // serverdan gelen veriyi almak
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Client: Lütfen mesaj yazýnýz ");

            while (true) {
                // clientten veri almak
                sendMessage = bufferedReader.readLine();
                printWriter.println(sendMessage);
                printWriter.flush();

                if ((receiveMessage = bufferedReader2.readLine()) != null) {
                    System.out.println("SERVER: " + receiveMessage);
                    //log.message = log.message + "SERVER: " + receiveMessage +",";

                    log.message("SERVER: " + receiveMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}