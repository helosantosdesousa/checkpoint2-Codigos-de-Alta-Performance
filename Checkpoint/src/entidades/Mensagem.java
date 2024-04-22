package entidades;

public class Mensagem {
    String nome, email, telefone;
    int contato;
   String mensagem;

    public Mensagem() {
        this.nome = nome;
        this.email =  email;
        this.telefone = telefone;
        this.contato = contato;
        this.mensagem = mensagem;
    }
    
    //getters e setters
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
