package RGP.src.RPG;

import java.util.ArrayList;

public class NPC extends Entidade {

    private ArrayList<ItemHeroi> inventarioNPC;
    private int ouro;

    private ArrayList<ConsumivelCombate> arrayAuxinventarioNPC;

    /**
     * Método Construtor
     *
     * @param nome  Nome do RGP.src.RPG.Jogo.src.RPG.NPC
     * @param vida  Vida do RGP.src.RPG.Jogo.src.RPG.NPC
     * @param forca Força do RGP.src.RPG.Jogo.src.RPG.NPC
     * @param ouro  Ouro do RGP.src.RPG.Jogo.src.RPG.NPC
     */
    public NPC(String nome, int vida, int forca, int ouro) {
        super(nome, vida, forca);
        this.inventarioNPC = new ArrayList<>();
        this.ouro = ouro;
        this.arrayAuxinventarioNPC = new ArrayList<>();

    }

    public ArrayList<ItemHeroi> getInventarioNPC() {
        return inventarioNPC;
    }

    public void setInventarioNPC(ArrayList<ItemHeroi> inventarioNPC) {
        this.inventarioNPC = inventarioNPC;
    }

    public int getOuro() {
        return ouro;
    }


    /**
     * Método para preencher inventário npc
     *
     * @param novoitem
     */
    public void preencherInventarioNPC(ItemHeroi novoitem) {

        inventarioNPC.add(novoitem);

    }

    public ArrayList<ConsumivelCombate> getArrayAuxinventarioNPC() {
        return arrayAuxinventarioNPC;
    }

    public void imprimirinventarioNPc() {
        System.out.println(" ");
        System.out.println("**********Inventário NPC**********");
        for (int i = 0; i < inventarioNPC.size(); i++) {
            //Imprimir itens
            System.out.println("********Item número: " + (i + 1) + "***********");


            inventarioNPC.get(i).exibirDetalhes();
            System.out.println(" ");
        }
    }

}


