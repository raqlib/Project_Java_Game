package RGP.src.RPG;

public class ConsumivelCombate extends Consumivel {

    private int ataqueInstantaneo;


    /**
     * Método Construtor dos Consumíveis de Combate
     *
     * @param nome                Nome do consumível
     * @param precoemMoedasdeOuro Preço do consumível em moedas de ouro
     * @param ataqueInstantaneo   Ataque Instantâneo do Consumível
     */
    public ConsumivelCombate(String nome, int precoemMoedasdeOuro, int ataqueInstantaneo) {
        super(nome, precoemMoedasdeOuro);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    @Override
    public void exibirDetalhes() {

        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço em moedas de ouro: " + this.getPrecoemMoedasdeOuro());
        System.out.println("Heróis permitidos: " + this.getHeroisPermitidos());
        System.out.println("Ataque instantâneo: " + this.ataqueInstantaneo);
    }


    /**
     * Método getter do ataque instantaneo
     *
     * @return ataqueinstantaneo
     */
    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }
}
