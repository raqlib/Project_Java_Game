package RGP.src.RPG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vendedor {

    private ArrayList<ItemHeroi> loja;


    /**
     * Método construtor
     */

    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Método para adicionar novos itens à loja
     *
     * @param novoItem
     */
    public void adicionarItensLoja(ItemHeroi novoItem) {
        loja.add(novoItem);
    }


    /**
     * Método com arrayAuxiliar para colocar 10 itens aleatórios da loja
     *
     * @return
     */
    public ArrayList<ItemHeroi> criararray() {
        //Criar array auxiliar com 10 itens aleatórios da loja
        ArrayList<ItemHeroi> arrayAux = new ArrayList<ItemHeroi>();

        Random random = new Random();

        for (int i = 0; arrayAux.size() < 10; i++) {

            int itemaleatorio = random.nextInt(loja.size());

            //Não pode sair um  item repetido
            if (arrayAux.contains(loja.get(itemaleatorio))) {
                //System.out.println("Consumível já foi adicionado ao ArrayList auxiliar!!");

            } else {
                arrayAux.add(loja.get(itemaleatorio));
            }
        }

        return arrayAux;
    }

    /**
     * Método para imprimir 10 itens da loja
     */
    public void imprimirLoja(ArrayList<ItemHeroi> arrayAux) {
        System.out.println(" ");
        System.out.println("**********Loja**********");
        for (int i = 0; i < arrayAux.size(); i++) {
            //Imprimir itens
            System.out.println("********Item número: " + (i + 1) + "***********");
            arrayAux.get(i).exibirDetalhes();
            System.out.println(" ");
        }
    }

    /**
     * Método de vender
     *
     * @param heroi recebe como parâmetro o herói
     */
    public void vender(Heroi heroi, ArrayList<ItemHeroi> arrayAux) {
        Scanner input = new Scanner(System.in);

        boolean comprarmais = false;
        boolean podecomprar = false;

        System.out.println("Deseja comprar alguma coisa? 1-Sim, 2-Não");
        int desejaComprar = input.nextInt();

        if (desejaComprar == 1) {
            do {
                System.out.println("Qual o número do item que deseja comprar?");
                int compraDesejada = input.nextInt();

                ItemHeroi itemEscolhido = arrayAux.get(compraDesejada - 1);

                System.out.println(heroi.getTipoHeroi() + " vai tentar comprar: " + compraDesejada);

                // Perceber se tem ouro para comprar
                if (heroi.getOuro() >= itemEscolhido.getPrecoemMoedasdeOuro()) {
                    // Avaliar se sabe usar o item
                    for (int i = 0; i < itemEscolhido.getHeroisPermitidos().size(); i++) {


                        if (heroi.getTipoHeroi().equals(itemEscolhido.getHeroisPermitidos().get(i))) {
                            podecomprar = true;
                            break;
                        }

                    }
                    if (podecomprar) {
                        //Se for arma principal substitui
                        if (itemEscolhido instanceof ArmaPrincipal) {
                            heroi.setArmaPrincipal((ArmaPrincipal) itemEscolhido);
                            heroi.setOuro(heroi.getOuro() - itemEscolhido.getPrecoemMoedasdeOuro());
                            System.out.println("A sua Arma principal foi substituída!");
                            System.out.println("Ouro atual: " + heroi.getOuro() + ".");
                            this.removerItemLoja(itemEscolhido);

                            System.out.println("Quer comprar mais itens? 1- Sim, 2- Não");
                            int comprarmaisItens = input.nextInt();
                            if (comprarmaisItens == 1) {
                                comprarmais = true;
                            }
                            if (comprarmaisItens == 2) {
                                comprarmais = false;
                                System.out.println("A sair da loja...");
                            }
                        }
                        //Se for consumível acrescenta o itemEscolhido ao arrayList inventario
                        else if (itemEscolhido instanceof Consumivel) {
                            heroi.getInventario().add((Consumivel) itemEscolhido);
                            heroi.setOuro(heroi.getOuro() - itemEscolhido.getPrecoemMoedasdeOuro());
                            System.out.println("Compra realizada! Adquiriu " + itemEscolhido.getNome() + ".");
                            System.out.println("Ouro atual: " + heroi.getOuro());
                            this.removerItemLoja(itemEscolhido);

                            System.out.println("Quer comprar mais itens? 1- Sim, 2- Não");
                            int comprarmaisItens = input.nextInt();
                            if (comprarmaisItens == 1) {
                                comprarmais = true;
                            }
                            if (comprarmaisItens == 2) {
                                System.out.println("A sair da loja...");
                                comprarmais = false;
                            }
                        }

                    } else {
                        System.out.println("Não é do tipo permitido! Compra não efetuada!");
                        System.out.println("Quer comprar mais itens? 1- Sim, 2- Não");
                        int comprarmaisItens = input.nextInt();
                        if (comprarmaisItens == 1) {
                            comprarmais = true;
                        }
                        if (comprarmaisItens == 2) {
                            comprarmais = false;
                            System.out.println("A sair da loja...");
                        }
                    }
                }

            } while (comprarmais && heroi.getOuro() > 0);

        } else {
            System.out.println("Vai prosseguir o jogo sem comprar nada!");
        }
    }

    /**
     * Método para remover o item do array da loja: arrayAux
     *
     * @param itemEscolhido Item escolhido
     */
    void removerItemLoja(ItemHeroi itemEscolhido) {
        loja.remove(itemEscolhido);

    }

}

