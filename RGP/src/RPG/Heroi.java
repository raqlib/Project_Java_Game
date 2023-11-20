package RGP.src.RPG;

import java.util.ArrayList;
import java.util.Scanner;


abstract class Heroi extends Entidade {
    private int nivel;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;


    /**
     * Método Construtor de Heroi
     *
     * @param nome  Nome do heroi
     * @param vida  Vida do heroi
     * @param forca Força do heroi
     * @param nivel Nível do herói
     * @param ouro  Ouro do herói
     */
    public Heroi(String nome, int vida, int forca, int nivel, int ouro) {
        super(nome, vida, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.inventario = new ArrayList<>();

    }


    /**
     * Método getter do ouro do herói
     *
     * @return ouro
     */
    public int getOuro() {
        return ouro;
    }


    /**
     * Método setter do ouro do herói
     *
     * @param ouro ouro
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }


    /**
     * Método getter do inventário do herói
     *
     * @return inventário
     */
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }


    /**
     * Método Setter do inventário do herói
     *
     * @param inventario inventário
     */
    public void setInventario(ArrayList<Consumivel> inventario) {
        this.inventario = inventario;
    }


    /**
     * Método getter da arma principal
     *
     * @return arma principal
     */
    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    /**
     * Método setter da arma principal
     *
     * @param armaPrincipal arma principal
     */
    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }


    /**
     * Método getter do nível
     *
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método setter do nível
     *
     * @param nivel nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    /**
     * Método para seleccionar o tipo de herói
     *
     * @return
     */
    public String getTipoHeroi() {
        // Transformar RGP.src.RPG.Jogo.src.RPG.Cavaleiro em Cavaleiro

        String linha = this.getClass().getName(); // RGP.src.RPG.Jogo.src.RPG.Cavaleiro

        String[] linhaSeparada = linha.split("\\.");

        return linhaSeparada[3];
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("***********Informações do herói****************");
        super.mostrarDetalhes();
        System.out.println("Arma principal :" + armaPrincipal.getNome());
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("Nome do consumível: " + inventario.get(i).getNome());
        }
    }

    /**
     * Método Usar Poção
     */
    public void usarPocao() {
        Scanner input = new Scanner(System.in);

        //Array auxiliar
        ArrayList<Pocao> arrayAuxPocao = new ArrayList<Pocao>();
        for (int i = 0; i < inventario.size(); i++) {
            if (getInventario().get(i) instanceof Pocao) {
                arrayAuxPocao.add((Pocao) this.getInventario().get(i));
            }
        }

        //Imprimir os detalhes do array auxiliar de poções(só imprime até 3 poções)


        for (int i = 0; i < arrayAuxPocao.size(); i++) {
            System.out.println(" ");
            System.out.println("******Poções existentes no seu inventário********");
            System.out.println("*********Item " + (i + 1) + "**********");
            arrayAuxPocao.get(i).exibirDetalhes();
        }

        //Escolher a poção a utilizar
        if (arrayAuxPocao.size() > 0) {
            do {
                System.out.println("Antes de sair desta sala tem direito a usar poções. Deseja usar poções? 1- Sim, 2- Não");
                int pocao = input.nextInt();
                if (pocao == 1) {
                    System.out.println("Escolha o número da poção desejada: ");
                    int pocaoDesejada = input.nextInt();

                    Pocao pocaoEscolhida = ((Pocao) arrayAuxPocao.get(pocaoDesejada - 1));

                    //Remover a pocao escolhida
                    for (int i = 0; i < arrayAuxPocao.size(); i++) {
                        arrayAuxPocao.remove(pocaoEscolhida);
                    }
                    for (int i = 0; i < inventario.size(); i++) {
                        getInventario().remove(pocaoEscolhida);
                    }

                    for (int i = 0; i < arrayAuxPocao.size(); i++) {
                        System.out.println(" ");
                        System.out.println("******Poções existentes no seu inventário********");
                        System.out.println("*********Item " + (i + 1) + "**********");
                        arrayAuxPocao.get(i).exibirDetalhes();
                    }

                    System.out.println("Poção utilizada!!");
                    this.setVida(this.getVida() + pocaoEscolhida.getVidaCurar());
                    System.out.println("Vida atual: " + this.getVida());
                    this.setForca(this.getForca() + pocaoEscolhida.getAumentoForca());
                    System.out.println("Força atual: " + this.getForca());
                } if (pocao ==2) {
                    System.out.println("Vamos prosseguir sem usar poções!!");
                    break;
                }
            } while (arrayAuxPocao.size() > 0);
        } else {
            System.out.println("Não tem poções a utilizar! Vamos prosseguir!!");
        }

    }


    /**
     * Método atacar
     *
     * @param npc Recebe um inimigo como parâmetro
     */
    void atacar(NPC npc) {
        Scanner input = new Scanner(System.in);

        boolean desistir = false;

        do {
            System.out.println("Insira o ataque que pretende realizar: ");
            System.out.println("1 - Ataque normal");
            System.out.println("2 - Ataque especial");
            System.out.println("3 - Ataque consumível");
            int opcao = input.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("**********Ataque normal**********");
                    this.setVida(this.getVida() - (int) (0.8 * npc.getForca()));
                    System.out.println("Ataque do inimigo!!");
                    if (this.getVida() > 0) {
                        System.out.println("Vida do Herói: " + this.getVida());
                    } else {
                        System.out.println("Vida do Herói: 0");
                        this.setVida(0);
                    }

                    if (this.getVida() > 0) {
                        npc.setVida(npc.getVida() - (this.getForca() + this.getArmaPrincipal().getAtaque()));
                        System.out.println("Ataque do herói!!");
                        if (npc.getVida() > 0) {
                            System.out.println("Vida do Inimigo: " + npc.getVida());
                        } else {
                            System.out.println("Vida do Inimigo: 0");
                            npc.setVida(0);
                        }
                    }
                    desistir = true;
                    break;
                case 2:
                    System.out.println("*************Ataque especial********");
                    System.out.println("Ataque do herói!!");
                    npc.setVida(npc.getVida() - (this.getForca() + this.getArmaPrincipal().getAtaqueEspecial()));
                    if (npc.getVida() > 0) {
                        System.out.println("Vida do Inimigo: " + npc.getVida());
                    } else {
                        System.out.println("Vida do Inimigo: 0");
                        npc.setVida(0);
                    }

                    if (npc.getVida() > 0) {
                        System.out.println("Ataque do inimigo!!");
                        this.setVida(this.getVida() - (int) (0.8 * npc.getForca()));
                        if (this.getVida() > 0) {
                            System.out.println("Vida do Herói: " + this.getVida());
                        } else {
                            System.out.println("Vida do Herói: 0");
                            this.setVida(0);
                        }
                    }
                    desistir = true;
                    break;
                case 3:
                    System.out.println("*********Ataque consumível*********");
                    //Array auxiliar
                    ArrayList<ConsumivelCombate> arrayAux = new ArrayList<ConsumivelCombate>();
                    for (int i = 0; i < getInventario().size(); i++) {
                        if (this.getInventario().get(i) instanceof ConsumivelCombate) {
                            arrayAux.add((ConsumivelCombate) this.getInventario().get(i));

                        }
                    }

                    //Exibir os detalhes do array auxiliar: array de Consumíveis de Combate
                    for (int i = 0; i < arrayAux.size(); i++) {
                        System.out.println("*********Item " + (i + 1) + "**********");
                        arrayAux.get(i).exibirDetalhes();
                    }

                    if (arrayAux.size() > 0) {
                        System.out.println("Quer desistir? 1- Sim, 2- Não");
                        int resposta = input.nextInt();
                        if (resposta == 1) {
                            desistir = true;
                            break;
                        }

                        //Perguntar ao utilizador
                        System.out.println("Escolha o número do consumível que quer utilizar?");
                        int consumivelDesejado = input.nextInt();

                        //Armazenar objeto desejado dentro do consumível escolhido
                        ConsumivelCombate consumivelEscolhido = arrayAux.get(consumivelDesejado - 1);
                        System.out.println("Ataque do herói!!");
                        npc.setVida(npc.getVida() - (this.getForca() + consumivelEscolhido.getAtaqueInstantaneo()));

                        if (npc.getVida() > 0) {
                            System.out.println("Vida do Inimigo: " + npc.getVida());
                        } else {
                            System.out.println("Vida do Inimigo: 0");
                            npc.setVida(0);
                        }
                        if (npc.getVida() > 0) {
                            System.out.println("Ataque do inimigo!!");
                            this.setVida(this.getVida() - (npc.getForca() + (int) (npc.getForca() * 0.1)));
                            if (this.getVida() > 0) {
                                System.out.println("Vida do Herói: " + this.getVida());
                            } else {
                                System.out.println("Vida do Herói: 0");
                                this.setVida(0);
                            }
                        }

                        //remover o consumível do inventário
                        for (int i = 0; i < arrayAux.size(); i++) {
                            this.removerItemHeroi(consumivelEscolhido);
                        }
                        for (int i = 0; i < inventario.size(); i++) {
                            getInventario().remove(consumivelEscolhido);
                        }
                        desistir = false;
                        break;

                    } else {
                        System.out.println("Não tem consumíveis disponíveis!!");
                    }

                    this.getVida();
                    npc.getVida();


            }
        } while ((this.getVida() > 0) && (npc.getVida() > 0));

    }


    /**
     * Método para Verificar Vencedor
     *
     * @param npc inimigo
     */

    void verificarVencedor(NPC npc) {
        Scanner input = new Scanner(System.in);
        boolean perdeu = false;
        if ((npc.getVida() <= 0) || (this.getVida() <= 0)) {

            if (npc.getVida() > 0) {
                System.out.println("***********GAME OVER!!*************");

            }
            //Se o herói ganhar
            if (this.getVida() > 0) {
                System.out.println("******************************");
                System.out.println("**********O herói venceu o inimigo!!*************");
                System.out.println("******************************");
                perdeu = false;
                this.setNivel(getNivel() + 1);
                this.setVida(getVida() + 10);
                this.setForca(getForca() + 1);
                this.setOuro(npc.getOuro());

                System.out.println("Nível: " + this.getNivel());
                System.out.println("Vida do herói: " + this.getVida());
                System.out.println("Força do herói: " + this.getForca());
                System.out.println("Ouro do herói: " + this.getOuro());


                //Acrescentar ao inventário do herói o inventário do npc
                //imprimir o inventário do npc
                for (int i = 0; i < npc.getInventarioNPC().size(); i++) {
                    System.out.println(" ");
                    System.out.println("******Inventário do Inimigo********");
                    System.out.println("*********Item " + (i + 1) + "**********");
                    npc.getInventarioNPC().get(i).exibirDetalhes();
                }

                for (int i = 0; i < npc.getInventarioNPC().size(); i++) {
                    //Se o objeto no inventário do npc for uma arma principal
                    if (npc.getInventarioNPC().get(i) instanceof ArmaPrincipal){


                        for (int h = 0; h < npc.getInventarioNPC().get(i).getHeroisPermitidos().size(); h++) {
                            if (this.getTipoHeroi().equals(npc.getInventarioNPC().get(i).getHeroisPermitidos().get(h))) {


                                System.out.println("Já tem uma arma principal. Quer trocar de arma principal? 1- Sim, 2-Não");
                                boolean trocarArma = false;

                                int escolher = input.nextInt();
                                switch (escolher) {
                                    case 1:
                                        trocarArma = true;
                                        //tinha que ir buscar o objeto
                                        this.setArmaPrincipal((ArmaPrincipal) npc.getInventarioNPC().get(i));
                                        System.out.println("Arma principal trocada!!");
                                        break;

                                    case 2:
                                        trocarArma = false;
                                        break;
                                }
                            }
                        }
                    }
                    if (npc.getInventarioNPC().get(i) instanceof ConsumivelCombate || npc.getInventarioNPC().get(i) instanceof Pocao) {


                        for (int t = 0;  t < npc.getInventarioNPC().get(i).getHeroisPermitidos().size(); t++) {
                            if (this.getTipoHeroi().equals(npc.getInventarioNPC().get(i).getHeroisPermitidos().get(t))) {


                                //Adicionar objeto ao arraylist do herói
                                System.out.println("Quer adicionar os itens do inimigo ao seu inventário? 1- Sim, 2- Não.");
                                int escolheritem = input.nextInt();
                                switch (escolheritem) {
                                    case 1:
                                        if (npc.getInventarioNPC().get(i) instanceof ConsumivelCombate) {
                                            inventario.add((ConsumivelCombate) npc.getInventarioNPC().get(i));
                                        }
                                        if (npc.getInventarioNPC().get(i) instanceof Pocao) {
                                            inventario.add((Pocao) npc.getInventarioNPC().get(i));
                                        }
                                        System.out.println("Item número " + (i + 1) + " adicionado!");
                                        break;

                                    case 2:
                                        System.out.println("O item não foi adicionado!");
                                        break;
                                }
                            }
                        }
                    }

                }
            }
        }
    }


    /**
     * Método para remover o item que o herói utilizou do arraylist original (remove o objeto)
     *
     * @param itemaRemover item a remover
     */
    void removerItemHeroi(ConsumivelCombate itemaRemover) {
        this.inventario.remove(itemaRemover);
    }


}

