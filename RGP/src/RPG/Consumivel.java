package RGP.src.RPG;

abstract class Consumivel extends ItemHeroi {


    /**
     * Método Construtor de Consumível
     *
     * @param nome Nome do Consumível
     * @param precoemMoedasdeOuro Preço em moedas de ouro do consumível
     */
    public Consumivel(String nome, int precoemMoedasdeOuro) {
        super(nome, precoemMoedasdeOuro);
    }


}
