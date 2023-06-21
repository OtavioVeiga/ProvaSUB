package Entidades;


public class Contato {
    
    private String id;
    private String nome;
    private String usuario;
    private Integer idade;



    public Contato() {
        
    }

    public Contato(String id, int idade1, String nome) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
       public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
