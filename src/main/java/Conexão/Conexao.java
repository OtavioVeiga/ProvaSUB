package Conexão;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;


public class Conexao {

    public static void main(String[] args) throws IOException {
        FileInputStream refreshToken = new FileInputStream("provasub.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(refreshToken))
  .setDatabaseUrl("https://provasub-725eb-default-rtdb.firebaseio.com")
  .build();

FirebaseApp.initializeApp(options);
    }
}