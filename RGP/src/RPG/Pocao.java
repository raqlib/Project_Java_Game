package RGP.src.RPG;

import java.util.ArrayList;

public class Pocao extends Consumivel {

    private int vidaCurar;
    private int aumentoForca;


    /**
     * Método Construtor RGP.src.RPG.Jogo.src.RPG.Pocao
     *
     * @param nome                Nome da pocao
     * @param precoemMoedasdeOuro Preço em moedas de ouro da pocao
     * @param vidaCurar           Vida a curar pela RGP.src.RPG.Jogo.src.RPG.Pocao
     * @param aumentoForca        Aumento de força proporcionado pela pocao
     */
    public Pocao(String nome, int precoemMoedasdeOuro, int vidaCurar, int aumentoForca) {
        super(nome, precoemMoedasdeOuro);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço em moedas de ouro: " + this.getPrecoemMoedasdeOuro());
        System.out.println("Heróis permitidos: " + this.getHeroisPermitidos());
        System.out.println("Vida a curar: " + this.vidaCurar);
        System.out.println("Aumento de força: " + aumentoForca);
    }


    /**
     * Método getter VidaCurar
     *
     * @return vida a curar
     */
    public int getVidaCurar() {
        return vidaCurar;
    }


    /**
     * Método getter Aumento Força
     *
     * @return aumento de força
     */

    public int getAumentoForca() {
        return aumentoForca;
    }

}
