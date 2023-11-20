package RGP.src.RPG;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

    private ArrayList<Sala> salas;
    private ArrayList<Integer> idSalaConectada;

    /**
     * Método construtor
     */
    public Jogo() {
        this.salas = new ArrayList<>();
        this.idSalaConectada = new ArrayList<>();
    }

    /**
     * Método getter das salas
     *
     * @return salas
     */
    public ArrayList<Sala> getSalas() {
        return salas;
    }

    /**
     * Método para criar a personagem
     *
     * @return
     */
    public Heroi criarPersonagem() {
        Scanner input = new Scanner(System.in);
        Heroi heroiEscolhido = null;

        System.out.println("Qual o tipo de herói com que deseja jogar? Arqueiro, Cavaleiro ou Feiticeiro");
        String tipoHeroi = input.next();
        do {
            if (tipoHeroi.equalsIgnoreCase("Arqueiro") || tipoHeroi.equalsIgnoreCase("Cavaleiro") || tipoHeroi.equalsIgnoreCase("Feiticeiro")) {
                break;
            } else {
                System.out.println("Escolha um herói válido!!");
                System.out.println("Qual o tipo de herói com que deseja jogar? Arqueiro, Cavaleiro ou Feiticeiro");
                tipoHeroi = input.next();
            }
        } while ((!"Arqueiro".equalsIgnoreCase(tipoHeroi)) || (!"Cavaleiro".equalsIgnoreCase(tipoHeroi)) || (!"Feiticeiro".equalsIgnoreCase(tipoHeroi)));


        System.out.println("Qual o nome do seu herói?");
        String nome = input.next();

        System.out.println("Dificuldade do jogo: 1- Fácil, 2 - Difícil");
        int op;
        int pontosForcaFinais = 0;
        int pontosVidaFinais = 0;
        int moedasOuro = 0;
        do {
            System.out.println("Insira uma opção válida:");
            op = input.nextInt();
        } while (op != 1 && op != 2);

        if (op == 1 || op == 2) {
            switch (op) {

                case 1://Fácil
                    int pontosMaxFacil = 300;
                    System.out.println("Tem um total de " + pontosMaxFacil + " pontos para distribuir.");
                    do {
                        //Pontos de força
                        System.out.println("Quantos pontos de força quer: (Cada ponto de força equivale a 5 pontos por distribuir)");
                        int pontosForcaFacil = input.nextInt();
                        if (pontosMaxFacil >= 0 && pontosForcaFacil <= pontosMaxFacil) {
                            pontosMaxFacil = pontosMaxFacil - (5 * pontosForcaFacil);
                            pontosForcaFinais = pontosForcaFinais + pontosForcaFacil;
                            if (pontosMaxFacil > 0) {
                                System.out.println("Pontos por distribuir :" + pontosMaxFacil);
                            } else {
                                System.out.println("Já não tem pontos por distribuir!!");
                            }
                        } else {
                            System.out.println("Pontos inválidos! Insira pontos dentro do limite!!");
                        }

                        //Pontos de vida
                        System.out.println("Quantos pontos de vida quer: ");
                        int pontosVidaFacil = input.nextInt();
                        if (pontosMaxFacil >= 0 && pontosVidaFacil <= pontosMaxFacil) {
                            pontosMaxFacil = pontosMaxFacil - pontosVidaFacil;
                            pontosVidaFinais = pontosVidaFinais + pontosVidaFacil;
                            if (pontosMaxFacil > 0) {
                                System.out.println("Pontos por distribuir :" + pontosMaxFacil);
                            } else {
                                System.out.println("Já não tem pontos por distribuir!!");
                            }
                        } else {
                            System.out.println("Pontos inválidos! Insira pontos dentro do limite!!");
                        }

                    } while (pontosMaxFacil > 0 && pontosMaxFacil <= 300);

                    moedasOuro = 15;
                    break;

                case 2://Difícil
                    int pontosMaxDificil = 220;

                    System.out.println("Tem um total de " + pontosMaxDificil + " pontos para distribuir.");
                    do {
                        //Pontos de força
                        System.out.println("Quantos pontos de força quer: (Cada ponto de força equivale a 5 pontos por distribuir)");
                        int pontosForcaDificil = input.nextInt();
                        if (pontosMaxDificil >= 0 && pontosForcaDificil <= pontosMaxDificil) {
                            pontosMaxDificil = pontosMaxDificil - (5 * pontosForcaDificil);
                            pontosForcaFinais = pontosForcaFinais + pontosForcaDificil;
                            if (pontosMaxDificil > 0) {
                                System.out.println("Pontos por distribuir:" + pontosMaxDificil);
                            } else {
                                System.out.println("Já não tem pontos por distribuir!!");
                            }
                        } else {
                            System.out.println("Pontos inválidos! Insira pontos dentro do limite!!");
                        }
                        //Pontos de vida
                        System.out.println("Quantos pontos de vida quer: ");
                        int pontosVidaDificil = input.nextInt();
                        if (pontosMaxDificil >= 0 && pontosVidaDificil <= pontosMaxDificil) {
                            pontosMaxDificil = pontosMaxDificil - pontosVidaDificil;
                            pontosVidaFinais = pontosVidaFinais + pontosVidaDificil;
                            if (pontosMaxDificil > 0) {
                                System.out.println("Pontos por distribuir:" + pontosMaxDificil);
                            } else {
                                System.out.println("Já não tem pontos por distribuir!!");
                                break;
                            }
                        } else {
                            System.out.println("Pontos inválidos! Insira pontos dentro do limite!!");
                        }

                    } while (pontosMaxDificil > 0 && pontosMaxDificil <= 220);

                    moedasOuro = 20;
                    break;


            }
        }


        if (tipoHeroi.equalsIgnoreCase("Arqueiro")) {
            //O heroiEscolhido é uma instância de Arqueiro
            heroiEscolhido = new Arqueiro(nome, pontosVidaFinais, pontosForcaFinais, 1, moedasOuro);

        }

        if (tipoHeroi.equalsIgnoreCase("Cavaleiro")) {
            //O heroiEscolhido é uma instância de Cavaleiro
            heroiEscolhido = new Cavaleiro(nome, pontosVidaFinais, pontosForcaFinais, 1, moedasOuro);

        }
        if (tipoHeroi.equalsIgnoreCase("Feiticeiro")) {
            //O heroiEscolhido é uma instância de Feiticeiro
            heroiEscolhido = new Feiticeiro(nome, pontosVidaFinais, pontosForcaFinais, 1, moedasOuro);

        }

        System.out.println(" ");
        System.out.println("***********Herói criado***********");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de herói: " + tipoHeroi);
        System.out.println("Vida: " + pontosVidaFinais);
        System.out.println("Força: " + pontosForcaFinais);
        System.out.println("Moedas: " + moedasOuro);

        return heroiEscolhido;
    }


    /**
     * Método para adicionar salas ao Array List Sala
     *
     * @param novaSala novaSala
     */
    public void adicionarSala(Sala novaSala) {
        salas.add(novaSala);
    }

    //


    /**
     * Método para imprimir salas
     */

    public void imprimirSalas() {
        System.out.println(" ");
        System.out.println("**********Salas**********");
        for (int i = 0; i < salas.size(); i++) {
            //Imprimir salas
            System.out.println("********Sala número: " + (i + 1) + "***********");
            System.out.println("Nome da sala: " + salas.get(i).getNome());

        }
    }


    /**
     * Método nome do jogo
     *
     * @param heroiEscolhido herói escolhido
     */
    public void aventuraMagica(Heroi heroiEscolhido) {


        //Instanciar os inimigos
        NPC npc1 = new NPC("Inimigo 1", 100, 60, 100);
        NPC npc2 = new NPC("Inimigo 2", 60, 70, 200);
        NPC npc3 = new NPC("Inimigo 3", 70, 80, 150);
        NPC npc4 = new NPC("Inimigo 4", 60, 90, 90);
        NPC npc5 = new NPC("Inimigo 5", 50, 100, 180);
        NPC npc6 = new NPC("Inimigo 6", 40, 110, 110);
        NPC npc7 = new NPC("Inimigo 7", 40, 120, 120);


        //Instanciar o vendedor
        Vendedor vendedor = new Vendedor();


        //Instanciar as armas principais
        ArmaPrincipal arcoeFlecha = new ArmaPrincipal("Arco e flecha", 2, 4, 8);
        arcoeFlecha.adicionarHeroisPermitidos("Arqueiro");
        arcoeFlecha.adicionarHeroisPermitidos("Cavaleiro");

        ArmaPrincipal besta = new ArmaPrincipal("Besta", 4, 5, 10);
        besta.adicionarHeroisPermitidos("Arqueiro");
        besta.adicionarHeroisPermitidos("Cavaleiro");

        ArmaPrincipal espada = new ArmaPrincipal("Espada", 3, 6, 12);
        espada.adicionarHeroisPermitidos("Cavaleiro");
        espada.adicionarHeroisPermitidos("Feiticeiro");


        ArmaPrincipal machado = new ArmaPrincipal("Machado", 3, 7, 14);
        machado.adicionarHeroisPermitidos("Cavaleiro");
        machado.adicionarHeroisPermitidos("Arqueiro");

        ArmaPrincipal sabre = new ArmaPrincipal("Sabre", 2, 8, 16);
        sabre.adicionarHeroisPermitidos("Feiticeiro");

        ArmaPrincipal boladecristal = new ArmaPrincipal("Bola de cristal", 2, 6, 12);
        boladecristal.adicionarHeroisPermitidos("Feiticeiro");


        //Instanciar os consumíveis de combate
        ConsumivelCombate bombaGrande = new ConsumivelCombate("Bomba Grande", 3, 8);
        bombaGrande.adicionarHeroisPermitidos("Arqueiro");
        bombaGrande.adicionarHeroisPermitidos("Cavaleiro");

        ConsumivelCombate armadilha = new ConsumivelCombate("Armadilha", 2, 6);
        armadilha.adicionarHeroisPermitidos("Feiticeiro");
        armadilha.adicionarHeroisPermitidos("Arqueiro");

        ConsumivelCombate arremesivel = new ConsumivelCombate("Arremessível", 1, 7);
        arremesivel.adicionarHeroisPermitidos("Arqueiro");

        ConsumivelCombate gasPimenta = new ConsumivelCombate("Gás Pimenta", 1, 7);
        gasPimenta.adicionarHeroisPermitidos("Cavaleiro");

        ConsumivelCombate corda = new ConsumivelCombate("Corda", 2, 3);
        corda.adicionarHeroisPermitidos("Arqueiro");
        corda.adicionarHeroisPermitidos("Cavaleiro");
        corda.adicionarHeroisPermitidos("Feiticeiro");

        ConsumivelCombate bombaPequena = new ConsumivelCombate("Bomba Pequena", 2, 5);
        bombaPequena.adicionarHeroisPermitidos("Feiticeiro");

        //Instanciar a poção de vida
        Pocao vida = new Pocao("Poção de vida", 2, 25, 0);
        vida.adicionarHeroisPermitidos("Feiticeiro");
        vida.adicionarHeroisPermitidos("Cavaleiro");
        vida.adicionarHeroisPermitidos("Arqueiro");


        //Instanciar a poção aumento de força
        Pocao aumentoForca = new Pocao("Poção de aumento de força", 1, 0, 10);
        aumentoForca.adicionarHeroisPermitidos("Arqueiro");
        aumentoForca.adicionarHeroisPermitidos("Cavaleiro");
        aumentoForca.adicionarHeroisPermitidos("Feiticeiro");

        //Adicionar itens ao inventario do NPC
        npc1.preencherInventarioNPC(arcoeFlecha);
        npc1.preencherInventarioNPC(bombaGrande);
        npc1.preencherInventarioNPC(vida);
        npc1.preencherInventarioNPC(arremesivel);
        npc1.preencherInventarioNPC(bombaGrande);
        npc2.preencherInventarioNPC(aumentoForca);
        npc2.preencherInventarioNPC(machado);
        npc2.preencherInventarioNPC(vida);
        npc2.preencherInventarioNPC(bombaPequena);
        npc3.preencherInventarioNPC(sabre);
        npc3.preencherInventarioNPC(aumentoForca);
        npc3.preencherInventarioNPC(gasPimenta);
        npc4.preencherInventarioNPC(boladecristal);
        npc4.preencherInventarioNPC(bombaGrande);
        npc4.preencherInventarioNPC(vida);
        npc4.preencherInventarioNPC(corda);
        npc5.preencherInventarioNPC(armadilha);
        npc5.preencherInventarioNPC(aumentoForca);
        npc5.preencherInventarioNPC(espada);
        npc5.preencherInventarioNPC(arremesivel);
        npc6.preencherInventarioNPC(gasPimenta);
        npc6.preencherInventarioNPC(sabre);
        npc6.preencherInventarioNPC(bombaGrande);
        npc5.preencherInventarioNPC(vida);
        npc7.preencherInventarioNPC(besta);
        npc7.preencherInventarioNPC(corda);
        npc7.preencherInventarioNPC(aumentoForca);
        npc7.preencherInventarioNPC(bombaPequena);

        //Chamar o método para adicionar itens à loja
        vendedor.adicionarItensLoja(arcoeFlecha);
        vendedor.adicionarItensLoja(besta);
        vendedor.adicionarItensLoja(espada);
        vendedor.adicionarItensLoja(machado);
        vendedor.adicionarItensLoja(sabre);
        vendedor.adicionarItensLoja(boladecristal);
        vendedor.adicionarItensLoja(bombaGrande);
        vendedor.adicionarItensLoja(armadilha);
        vendedor.adicionarItensLoja(arremesivel);
        vendedor.adicionarItensLoja(gasPimenta);
        vendedor.adicionarItensLoja(corda);
        vendedor.adicionarItensLoja(bombaPequena);
        vendedor.adicionarItensLoja(vida);
        vendedor.adicionarItensLoja(aumentoForca);


        //Adicionar armas principais aos heróis
        if (heroiEscolhido.getTipoHeroi().equalsIgnoreCase("Arqueiro")) {
            heroiEscolhido.setArmaPrincipal(arcoeFlecha);
        }
        if (heroiEscolhido.getTipoHeroi().equalsIgnoreCase("Cavaleiro")) {
            heroiEscolhido.setArmaPrincipal(besta);
        }
        if (heroiEscolhido.getTipoHeroi().equalsIgnoreCase("Feiticeiro")) {
            heroiEscolhido.setArmaPrincipal(boladecristal);
        }


        //Instanciar as salas
        Sala rio = new Sala("Rio", 1, null, 0, 0);
        //adicionar um inimigo
        rio.adicionarInimigos(npc1);


        Sala casebre = new Sala("Casebre", 3, null, 0, 0);
        //adicionar um item perdido: poção vida
        casebre.adicionarItemPerdido(vida);


        Sala margem = new Sala("Margem", 4, vendedor, 0, 0);


        Sala rapidos = new Sala("Rápidos", 5, null, 0, 0);
        //adicionar um inimigo
        rapidos.adicionarInimigos(npc2);

        Sala tenda = new Sala("Tenda", 6, null, 0, 50);


        Sala encosta = new Sala("Encosta", 7, vendedor, 0, 0);


        Sala pantano = new Sala("Pântano", 8, null, 0, 0);
        //adicionar um inimigo
        pantano.adicionarInimigos(npc3);

        Sala floresta = new Sala("Floresta", 2, null, 0, 0);
        //adicionar um inimigo
        floresta.adicionarInimigos(npc4);


        Sala casa = new Sala("Casa", 9, null, 0, 0);
        //adicionar um itemPerdido: poção de força
        casa.adicionarItemPerdido(aumentoForca);


        Sala ribanceira = new Sala("Ribanceira", 10, vendedor, 0, 0);

        Sala troncomagico = new Sala("Tronco mágico", 11, null, 0, 0);
        //adicionar um item perdido: poção vida
        troncomagico.adicionarItemPerdido(gasPimenta);

        Sala caminhodasbagas = new Sala("Caminho das bagas", 12, null, 20, 0);

        Sala caminhodasaromaticas = new Sala("Caminho das aromaticas", 13, null, 0, 30);

        Sala cogumelomagico = new Sala("Cogumelo Mágico", 14, null, 0, 0);
        //adicionar um inimigo
        cogumelomagico.adicionarInimigos(npc5);

        Sala tempestade = new Sala("Tempestade", 15, null, 0, 0);
        //adicionar um inimigo
        tempestade.adicionarInimigos(npc6);

        Sala arcoiris = new Sala("Arco-íris", 16, null, 0, 0);
        //adicionar um inimigo
        arcoiris.adicionarInimigos(npc7);


        //Chamar o método para adicionar salas ao arrayList de Sala
        this.adicionarSala(rio);
        this.adicionarSala(casebre);
        this.adicionarSala(margem);
        this.adicionarSala(rapidos);
        this.adicionarSala(tenda);
        this.adicionarSala(encosta);
        this.adicionarSala(pantano);
        this.adicionarSala(floresta);
        this.adicionarSala(casa);
        this.adicionarSala(ribanceira);
        this.adicionarSala(troncomagico);
        this.adicionarSala(caminhodasbagas);
        this.adicionarSala(caminhodasaromaticas);
        this.adicionarSala(cogumelomagico);
        this.adicionarSala(tempestade);
        this.adicionarSala(arcoiris);


        //Começo do jogo
        System.out.println(" ");
        System.out.println("***********Vamos começar************");
        System.out.println("O herói irá embarcar numa aventura mágica onde terá que enfrentar diversos desafios escondidos em diferentes salas e sobreviver!! O objetivo será chegar ao fim desta aventura mágica com vida!!");
        System.out.println("***********Vamos às compras!*********");

        //Chamar o método para imprimir os itens presentes na loja
        ArrayList<ItemHeroi> bancaAtual = vendedor.criararray();

        vendedor.imprimirLoja(bancaAtual);

        //Chamar o método para vender itens da loja
        vendedor.vender(heroiEscolhido, bancaAtual);


        //Para verificar se já foi retirado o item da loja
        // vendedor.imprimirLoja(bancaAtual);

        //Ciclos para percorrer o mapa e passar de sala em sala
        Scanner input = new Scanner(System.in);


        System.out.println("Qual a sala para que pretende ir? 1- Rio, 2 - Floresta");
        int proximaSala = input.nextInt();


        if (proximaSala == 1) {
            Sala salaEscolhida = this.getSalas().get(0); //Sala Rio
            System.out.println("********Sala Rio********");
            this.boasVindas();
            System.out.println("Cuidado com o inimigo!!");
            heroiEscolhido.atacar(npc1);
            heroiEscolhido.verificarVencedor(npc1);
            heroiEscolhido.usarPocao();

            if (heroiEscolhido.getVida() > 0) {

                System.out.println("Qual a sala para que pretende ir? 1- Casebre, 2 - Tenda");
                int proximaSala1 = input.nextInt();


                if (proximaSala1 == 1) {

                    Sala salaEscolhida1 = this.getSalas().get(1); //Sala casebre

                    this.saida(salaEscolhida1);
                    System.out.println("********Sala Casebre********");
                    this.boasVindas();
                    heroiEscolhido.setVida(heroiEscolhido.getVida() + vida.getVidaCurar());
                    System.out.println("Encontrou uma poção de vida!!");
                    System.out.println("Vida atual: " + heroiEscolhido.getVida());
                    heroiEscolhido.usarPocao();

                    System.out.println("Seguir para a próxima sala? 1- Margem");
                    int proximaSala2 = input.nextInt();

                    if (proximaSala2 == 1) {
                        Sala salaEscolhida2 = this.getSalas().get(2); //sala margem
                        this.saida(salaEscolhida2);
                        System.out.println("********Sala Margem********");
                        this.boasVindas();
                        System.out.println("Na margem encontrou o vendedor!!");
                        vendedor.imprimirLoja(bancaAtual);
                        vendedor.vender(heroiEscolhido, bancaAtual);
                        heroiEscolhido.usarPocao();

                    }
                    System.out.println("Seguir para a próxima sala? 1- Rápidos");
                    int proximaSala3 = input.nextInt();


                    if (proximaSala3 == 1) {
                        Sala salaEscolhida3 = this.getSalas().get(3); //sala rápidos
                        this.saida(salaEscolhida3);
                        System.out.println("********Sala Rápidos********");
                        this.boasVindas();
                        System.out.println("***************************************");
                        System.out.println("ULTIMA PROVA!! Cuidado com o inimigo!!");
                        heroiEscolhido.atacar(npc2);
                        heroiEscolhido.verificarVencedor(npc2);
                        heroiEscolhido.usarPocao();

                    }
                }


                if (proximaSala1 == 2) {
                    Sala salaEscolhida4 = this.getSalas().get(4);// Sala tenda
                    this.saida(salaEscolhida4);
                    System.out.println("********Sala Tenda********");
                    this.boasVindas();
                    heroiEscolhido.setOuro(heroiEscolhido.getOuro() + salaEscolhida4.getOuroPerdido());
                    System.out.println("Encontrou ouro perdido!!");
                    System.out.println("Ouro do herói: " + heroiEscolhido.getOuro());
                    heroiEscolhido.usarPocao();


                    System.out.println("Seguir para a próxima sala? 1- Encosta");
                    int proximaSala5 = input.nextInt();

                    if (proximaSala5 == 1) {
                        Sala salaEscolhida5 = this.getSalas().get(5);// Sala encosta
                        this.saida(salaEscolhida5);
                        System.out.println("********Sala Encosta********");
                        this.boasVindas();
                        System.out.println("Encontro o vendedor!!");
                        vendedor.imprimirLoja(bancaAtual);
                        vendedor.vender(heroiEscolhido, bancaAtual);
                        heroiEscolhido.usarPocao();

                    }

                    System.out.println("Seguir para a próxima sala? 1- Pântano");

                    int proximaSala6 = input.nextInt();
                    if (proximaSala6 == 1) {
                        Sala salaEscolhida6 = this.getSalas().get(6);// Sala pântano
                        this.saida(salaEscolhida6);
                        System.out.println("********Sala Pântano********");
                        this.boasVindas();
                        System.out.println("**************************************");
                        System.out.println("ULTIMA PROVA!! Cuidado com o inimigo!!");
                        heroiEscolhido.atacar(npc3);
                        heroiEscolhido.verificarVencedor(npc3);


                    }


                }
            }
        }
        if (proximaSala == 2) {
            Sala salaEscolhida = this.getSalas().get(7);//Sala Floresta
            this.saida(salaEscolhida);
            System.out.println("********Sala Floresta********");
            this.boasVindas();
            System.out.println("Cuidado com o inimigo!!");
            heroiEscolhido.atacar(npc4);
            heroiEscolhido.verificarVencedor(npc4);
            heroiEscolhido.usarPocao();

            if (heroiEscolhido.getVida() > 0) {
                System.out.println("Qual a sala para que pretende ir? 1- Casa, 2 - Ribanceira, 3 - Tronco Mágico");
                int proximaSala7 = input.nextInt();
                if (proximaSala7 == 1) {
                    Sala salaEscolhida7 = this.getSalas().get(8);// Sala casa
                    this.saida(salaEscolhida7);
                    System.out.println("********Sala Casa********");
                    this.boasVindas();
                    System.out.println("Encontrou uma poção de aumento de força!!");
                    heroiEscolhido.setForca(heroiEscolhido.getForca() + aumentoForca.getAumentoForca());
                    System.out.println("Força atual: " + heroiEscolhido.getForca());
                    heroiEscolhido.usarPocao();


                    System.out.println("Seguir para a próxima sala? 1- Caminhos das bagas");

                    int proximaSala10 = input.nextInt();

                    if (proximaSala10 == 1) {
                        Sala salaEscolhida10 = this.getSalas().get(11);// Sala caminhos das bagas
                        this.saida(salaEscolhida10);
                        System.out.println("********Sala Caminho das bagas********");
                        this.boasVindas();
                        System.out.println("Armadilha!!");
                        heroiEscolhido.setVida(heroiEscolhido.getVida() - armadilha.getAtaqueInstantaneo());
                        System.out.println("Vida do herói: " + heroiEscolhido.getVida());
                        heroiEscolhido.usarPocao();


                    }
                    if (heroiEscolhido.getVida() > 0) {
                        System.out.println("Seguir para a próxima sala? 1- Tempestade");

                        int proximaSala11 = input.nextInt();

                        if (proximaSala11 == 1) {
                            Sala salaEscolhida11 = this.getSalas().get(11);// Sala tempestade
                            this.saida(salaEscolhida11);
                            System.out.println("********Sala Temprestade********");
                            this.boasVindas();
                            System.out.println("*************************************");
                            System.out.println("ULTIMA PROVA!! Cuidado com o inimigo!!");
                            heroiEscolhido.atacar(npc6);
                            heroiEscolhido.verificarVencedor(npc6);


                        }

                    }
                }


                if (proximaSala7 == 2) {
                    Sala salaEscolhida8 = this.getSalas().get(9);// Sala ribanceira
                    this.saida(salaEscolhida8);
                    System.out.println("********Sala Ribanceira********");
                    this.boasVindas();
                    System.out.println("Encontrou o vendedor!!");
                    vendedor.imprimirLoja(bancaAtual);
                    vendedor.vender(heroiEscolhido, bancaAtual);
                    heroiEscolhido.usarPocao();


                    System.out.println("Seguir para a próxima sala? 1- Caminho das aromáticas");

                    int proximaSala12 = input.nextInt();

                    if (proximaSala12 == 1) {
                        Sala salaEscolhida12 = this.getSalas().get(12);// Sala caminho das aromáticas
                        this.saida(salaEscolhida12);
                        System.out.println("********Sala Caminho das Aromáticas********");
                        this.boasVindas();
                        System.out.println("Encontrou ouro perdido!!");
                        heroiEscolhido.setOuro(heroiEscolhido.getOuro() + salaEscolhida12.getOuroPerdido());
                        System.out.println("Ouro atual: " + heroiEscolhido.getOuro());
                        heroiEscolhido.usarPocao();


                    }
                    System.out.println("Seguir para a próxima sala? 1- Cogumelo mágico");

                    int proximaSala13 = input.nextInt();

                    if (proximaSala13 == 1) {
                        Sala salaEscolhida13 = this.getSalas().get(13);// Sala cogumelo mágico
                        this.saida(salaEscolhida13);
                        System.out.println("********Sala Cogumelo Mágico********");
                        this.boasVindas();
                        System.out.println("**************************************");
                        System.out.println("ULTIMA PROVA!! Cuidado com o inimigo!!");
                        heroiEscolhido.atacar(npc5);
                        heroiEscolhido.verificarVencedor(npc5);


                    }

                }
                if (proximaSala7 == 3) {
                    Sala salaEscolhida9 = this.getSalas().get(10);// Sala tronco mágico
                    this.saida(salaEscolhida9);
                    System.out.println("********Sala Tronco Mágico********");
                    this.boasVindas();
                    System.out.println("Armadilha!!");
                    heroiEscolhido.setVida(heroiEscolhido.getVida() - gasPimenta.getAtaqueInstantaneo());
                    System.out.println("Vida do herói: " + heroiEscolhido.getVida());
                    heroiEscolhido.usarPocao();

                    if (heroiEscolhido.getVida() > 0) {
                        System.out.println("Seguir para a próxima sala? 1- Arco-íris");

                        int proximaSala14 = input.nextInt();

                        if (proximaSala14 == 1) {
                            Sala salaEscolhida14 = this.getSalas().get(15);// Sala arco-íris
                            this.saida(salaEscolhida14);
                            System.out.println("********Sala Arco-íris********");
                            this.boasVindas();
                            System.out.println("**************************************");
                            System.out.println("ULTIMA PROVA!! Cuidado com o inimigo!!");
                            heroiEscolhido.atacar(npc7);
                            heroiEscolhido.verificarVencedor(npc7);
                        }

                    }
                }
            }
        }


    }

    public void boasVindas() {
        System.out.println("Seja bem-vindo a esta sala!!");
    }

    public void saida(Sala salaEscolhida) {

        System.out.println("Depois desta etapa ultrapassada, o herói segue agora o seu caminho nesta aventura para a sala " + salaEscolhida.getNome() + "!");


    }

}




