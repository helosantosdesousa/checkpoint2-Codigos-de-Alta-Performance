package aplicacao;
// Heloísa Santos de Sousa - RM: 550256
// Lívia Tiemi Paulino Ogawa - RM: 550856

import entidades.Mensagem;
import fila.FilaMensagens;

import java.util.Scanner;

public class AtendimentoMensagem{
    static Scanner e = new Scanner(System.in);

    public static void main(String[] args) {

        FilaMensagens filaReclamacao = new FilaMensagens();
        filaReclamacao.init();
        FilaMensagens filaSugestao = new FilaMensagens();
        filaSugestao.init();
        FilaMensagens filaResolucao = new FilaMensagens();
        filaResolucao.init();



        int opcao=9;
        do {
            System.out.println(" ------------ MENU ------------ ");
            System.out.println("0 - Encerra programa");
            System.out.println("1 - Recebe mensagem");
            System.out.println("2 - Atendimento de mensagem");
            System.out.println("3 - Recebimento e encaminhamento de resolução");
            opcao = e.nextInt();

            switch (opcao){

                case 1:
                    cadastraMensagem(filaSugestao, filaReclamacao);
                    break;
                case 2:
                    int tipoAtendimento=0;
                    System.out.println("Deseja atender fila Sugestão (1) ou fila Reclamação (2)? ");
                    tipoAtendimento = e.nextInt();

                    if (tipoAtendimento==1){
                        filaSugestao.dequeue();
                    } else if (tipoAtendimento==2){
                        filaReclamacao.dequeue();
                    } else{
                        System.out.println("Inválido!");
                    }

                    System.out.println("Enviada resposta para cliente: Sua solicitação já foi resolvida. Obrigado!");
                    break;
                case 3:

            }
        } while (opcao!=0);



    }
   public static void cadastraMensagem(FilaMensagens filaSugestao, FilaMensagens filaReclamacao){


       String nome, contato, mensagem;
        int motivo;


       System.out.println("Nome: ");
       nome = e.next();

       System.out.println("Contato (E-mail/telefone): ");
       contato = e.next();

       System.out.println("Motivo (1 - Reclamação/ 2 - Sugestão):");
       motivo = e.nextInt();
       //verificar se o motivo é válido
        while (motivo!=1 && motivo!=2){
            System.out.println("Inválido!");
            System.out.println("Motivo (1 - Reclamação/ 2 - Sugestão):");
            motivo = e.nextInt();
        }



       System.out.println("Mensagem:");
       mensagem = e.next();


       Mensagem m = new Mensagem(nome, contato, motivo, mensagem);

       if(motivo==1){
           filaReclamacao.enqueue(m);
       } else if (motivo == 2){
           filaSugestao.enqueue(m);
       } else {
           System.out.println("Inválido!");
       }


    }







}

//só falta a case 2, pra ver se pode ser pontamente respondido ou nao

