package Conexão;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Conexao {

    public static void main() {
        
        try{
        FileInputStream serviceAccount = new FileInputStream("provasub.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://provasub-725eb-default-rtdb.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(options);
        
        System.out.println("Firebase inicializado com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de chave não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de chave: " + e.getMessage());
        }

    }

    public DatabaseReference getDatabaseReference() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}