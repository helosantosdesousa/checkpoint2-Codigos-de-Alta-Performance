package entidades;

public class Mensagem {
    String nome, contato;
    int motivo;
    String mensagem;

    public Mensagem(String nome, String contato, int motivo, String mensagem) {
        this.nome = nome;
        this.contato = contato;
        this.motivo = motivo;
        this.mensagem = mensagem;
    }


    public void setContato(String contato){
        this.contato = contato;
    }
    public String getContato(){
        return contato;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
