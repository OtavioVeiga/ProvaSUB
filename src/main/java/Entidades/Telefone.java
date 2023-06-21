package Entidades;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Telefone {
    private String id;
    private String contato;

    public Telefone() {
        
    }

    public Telefone(String id, String contato) {
        this.id = id;
        this.contato = contato;
    }

    public String getId() {
        return id;
    }

    public String getContato() {
        return contato;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
}