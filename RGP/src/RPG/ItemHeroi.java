package RGP.src.RPG;

import java.util.ArrayList;


abstract class ItemHeroi {

    private String nome;
    private int precoemMoedasdeOuro;
    private ArrayList<String> heroisPermitidos;


    /**
     * Método construtor do item heroi
     *
     * @param nome                Nome do item Heroi
     * @param precoemMoedasdeOuro Preço em moedas de ouro do item heroi
     */
    public ItemHeroi(String nome, int precoemMoedasdeOuro) {
        this.nome = nome;
        this.precoemMoedasdeOuro = precoemMoedasdeOuro;
        this.heroisPermitidos = new ArrayList<>();
    }


    /**
     * Método para adicionar Heróis permitidos ao Array
     *
     * @param novoHeroi
     */
    public void adicionarHeroisPermitidos(String novoHeroi) {
        heroisPermitidos.add(novoHeroi);
    }


    /**
     * Método para exibir detalhes dos ItemHeroi
     */
    abstract void exibirDetalhes();

    /**
     * Método getter herois permitidos
     *
     * @return herois permitidos
     */
    public ArrayList<String> getHeroisPermitidos() {
        return heroisPermitidos;
    }

    /**
     * Método getter preço em moedas de ouro
     *
     * @return preço em moedas de ouro
     */
    public int getPrecoemMoedasdeOuro() {
        return precoemMoedasdeOuro;
    }

    /**
     * Método getter do nome do item
     *
     * @return nome do item
     */
    public String getNome() {
        return nome;
    }
}

