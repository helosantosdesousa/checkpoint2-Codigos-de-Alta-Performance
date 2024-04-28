package fila;

import entidades.Mensagem;

import java.util.Scanner;

public class FilaMensagens {
    Scanner e = new Scanner(System.in);
    Mensagem m;
    public final int N = 15;
    Mensagem dados[] = new Mensagem[N];
    int ini, fim, cont;

    public void init() {
        ini = fim = cont = 0;
    }

    public boolean isEmpty() {
        return (cont == 0);
    }

    public boolean isFull() {
        return (cont == N);
    }

    public void enqueue(Mensagem m) {
        if (isFull())
            System.out.println("Fila cheia");
        else {
            dados[fim] = m;
            fim = (fim + 1) % N;
            cont++;
        }
    }

    public Mensagem dequeue() {
        Mensagem m = dados[ini];
        ini = (ini + 1) % N;
        cont--;
        return m;
    }

    public Mensagem first() {
        return (dados[ini]);
    }

    public void verificaDisponibilidade(FilaMensagens filaResolucao, Mensagem m) {
        char resposta;

        System.out.println("Assunto pode ser resolvido agora? s/n");
        resposta = e.next().charAt(0);
        if (resposta == 's') {
            System.out.println("Enviada resposta para cliente: Sua solicitação já foi resolvida. Obrigado!");

        } else {
            filaResolucao.enqueue(m);
            System.out.println("Sua solicitação será enviada para o setor responsável");
        }
    }



}
