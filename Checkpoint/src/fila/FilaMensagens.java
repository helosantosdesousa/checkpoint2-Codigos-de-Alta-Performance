package fila;

import entidades.Mensagem;


public class FilaMensagens {
Mensagem m;
    public final int N = 15; //criar o tamanho do vetor
    Mensagem dados[] = new Mensagem[N];
    int ini, fim, cont;

    public void init() {
        ini = fim = cont = 0; //inicilizar, tudo fica 0
    }
    public boolean isEmpty() {
        return (cont==0); //se a fila estiver vazia, retorna 0
    }
    public boolean isFull() {
        return (cont==N); //se a fila estiver cheia, retorna a qtd de elementos
    }
    public void enqueue(Mensagem m) { //adicionar um elemento elem a fila
        if (isFull())
            System.out.println("Fila cheia"); //se estiver cheia printa fila cheia
        else {
            dados[fim] = m; //adicionar elem no fim
            fim = (fim+1) % N;
            cont++;
        }
    }
    public Mensagem dequeue() {
       Mensagem m = dados[ini];
        ini = (ini+1) % N;
        cont--;
        return m;
    }
    public Mensagem first() {
        return (dados[ini]); //printar o primeiro da fila
    }



}
