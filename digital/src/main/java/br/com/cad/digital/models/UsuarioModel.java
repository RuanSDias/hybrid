package br.com.cad.digital.models;

public class UsuarioModel {
    
    private Long id;
    private String nome;
    private String senha;
    private String email;

    public UsuarioModel(Long id, String nome, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioModel [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + "]";
    }
}
