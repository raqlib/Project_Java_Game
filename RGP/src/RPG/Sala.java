package RGP.src.RPG;

import java.util.ArrayList;
import java.util.Scanner;

public class Sala {

    private String nome;
    private int id;
    private ArrayList<Integer> idSalaConectada;

    private ArrayList<NPC> inimigosNaSala;
    private Vendedor vendedorPresente;
    private ArrayList<ItemHeroi> itemPerdido;
    private int danoArmadilha;
    private int ouroPerdido;

    public Sala(String nome, int id, Vendedor vendedorPresente, int danoArmadilha, int ouroPerdido) {
        this.nome = nome;
        this.id = id;
        this.vendedorPresente = vendedorPresente;
        this.danoArmadilha = danoArmadilha;
        this.ouroPerdido = ouroPerdido;
        this.idSalaConectada = new ArrayList<Integer>();
        this.itemPerdido = new ArrayList<>();
        this.inimigosNaSala = new ArrayList<>();

    }


    /**
     * Método para adicionar inimigos ao array inimigosNaSala
     *
     * @param novoInimigo novo inimigo
     */
    public void adicionarInimigos(NPC novoInimigo) {
        inimigosNaSala.add(novoInimigo);
    }

    /**
     * Método para adicionar itens ao arrayList ItemPerdido
     *
     * @param novoItem novo item
     */
    public void adicionarItemPerdido(ItemHeroi novoItem) {
        itemPerdido.add(novoItem);
    }

    /**
     * Método getter nome
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getter id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Método getter ouro perdido
     *
     * @return ouro perdido
     */
    public int getOuroPerdido() {
        return ouroPerdido;
    }

    /**
     * Método para escolher a sala
     */
    public void escolherSala() {
        Scanner input = new Scanner(System.in);
        int salaEscolhida = input.nextInt();
    }


}

