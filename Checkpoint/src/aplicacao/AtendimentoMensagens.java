package aplicacao;

// Heloísa Santos de Sousa - RM: 550256
// Lívia Tiemi Paulino Ogawa - RM: 550856

import entidades.Mensagem;
import fila.FilaMensagens;

import java.util.Scanner;

public class AtendimentoMensagens {
    static Scanner e = new Scanner(System.in);

    public static void main(String[] args) {
        String mensagem = null;

        FilaMensagens filaReclamacao = new FilaMensagens();
        filaReclamacao.init();
        FilaMensagens filaSugestao = new FilaMensagens();
        filaSugestao.init();
        FilaMensagens filaResolucao = new FilaMensagens();
        filaResolucao.init();

        int opcao = 9;
        Mensagem m = null;
        do {
            System.out.println(" ------------ MENU ------------ ");
            System.out.println("0 - Encerra programa");
            System.out.println("1 - Recebe mensagem");
            System.out.println("2 - Atendimento de mensagem");
            System.out.println("3 - Recebimento e encaminhamento de resolução");
            opcao = e.nextInt();

            switch (opcao) {
                case 1:
                    mensagem = cadastraMensagem(filaSugestao, filaReclamacao);
                    break;
                case 2:
                    int tipoAtendimento = 0;
                    System.out.println("Deseja atender fila Sugestão (1) ou fila Reclamação (2)? ");
                    tipoAtendimento = e.nextInt();

                    if (tipoAtendimento == 1 && !filaSugestao.isEmpty()) {
                        m = filaSugestao.first();
                        System.out.println("Mensagem: " + m.getMensagem()); // Print the message from 'm'
                        filaSugestao.verificaDisponibilidade(filaResolucao, m);
                        filaSugestao.dequeue();
                    } else if (tipoAtendimento == 2 && !filaReclamacao.isEmpty()) {
                        m = filaReclamacao.first();
                        System.out.println("Mensagem: " + m.getMensagem()); // Print the message from 'm'
                        filaReclamacao.verificaDisponibilidade(filaResolucao, m);
                        filaReclamacao.dequeue();
                    } else if (filaSugestao.isEmpty() || filaReclamacao.isEmpty()) {
                        System.out.println("Não existem solicitações!");
                    } else {
                        System.out.println("Inválido!");
                    }
                    break;

                case 3:
                    if (filaResolucao.isEmpty()) {
                        System.out.println("Fila vazia");
                    } else {
                        filaResolucao.dequeue();
                        System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida pelo setor " +
                                "responsável. Obrigado!!!");
                    }
            }
        } while (opcao != 0);
    }

    public static String cadastraMensagem(FilaMensagens filaSugestao, FilaMensagens filaReclamacao) {
        String nome, contato, mensagem;
        int motivo;

        System.out.println("Nome: ");
        nome = e.next();

        System.out.println("Contato (E-mail/telefone): ");
        contato = e.next();

        System.out.println("Motivo (1 - Sugestão/ 2 - Reclamação):");
        motivo = e.nextInt();

        //verificar se o motivo é válido
        while (motivo != 1 && motivo != 2) {
            System.out.println("Inválido!");
            System.out.println("Motivo (1 - Sugestão/ 2 - Reclamação):");
            motivo = e.nextInt();
        }

        System.out.println("Mensagem:");
        mensagem = e.next();

        Mensagem m = new Mensagem(nome, contato, motivo, mensagem);

        if (motivo == 1) {
            filaSugestao.enqueue(m);
        } else if (motivo == 2) {
            filaReclamacao.enqueue(m);
        } else {
            System.out.println("Inválido!");
        }

        return mensagem;
    }


}
