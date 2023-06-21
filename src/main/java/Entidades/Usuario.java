package Entidades;

public class Usuario {
    private String id;
    private String nome;
    private String login;
    private int idade;

    public Usuario() {
       
    }

    public Usuario(String id, String nome, String login, int idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}