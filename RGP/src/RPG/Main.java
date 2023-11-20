package RGP.src.RPG;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Início do jogo
        System.out.println("*********************************************************************");
        System.out.println("Bem-vindo a esta aventura mágica!! Vamos construir a sua personagem!!");

        System.out.println(" ");

        //Instanciar o jogo
        Jogo jogo = new Jogo();


        //Chamar o método para criar a personagem
        Heroi heroiEscolhido = jogo.criarPersonagem();


        //Chamar o método aventura mágica
        jogo.aventuraMagica(heroiEscolhido);
        System.out.println("******************FIM DO JOGO******************");


        //Ciclo com opções a realizar no final do jogo
        Scanner input = new Scanner(System.in);

        int opcaojogo=0;

        do {
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 -Jogar novamente com a mesma personagem, 2 - Criar uma nova personagem, 3- Fechar o programa");
            opcaojogo = input.nextInt();
            switch (opcaojogo) {
                case 1:
                    jogo.aventuraMagica(heroiEscolhido);
                    System.out.println("******************FIM DO JOGO******************");
                    break;

                case 2:
                    jogo.criarPersonagem();
                    jogo.aventuraMagica(heroiEscolhido);
                    System.out.println("******************FIM DO JOGO******************");
                    break;

                case 3:
                    System.out.println("Jogo terminado!");
                    break;
            }

        } while (opcaojogo != 3);
    }

}

