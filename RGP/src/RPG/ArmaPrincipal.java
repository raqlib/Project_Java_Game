package RGP.src.RPG;

public class ArmaPrincipal extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;


    /**
     * Método Construtor da classe ArmaPrincipal
     *
     * @param nome                Nome da arma
     * @param precoemMoedasdeOuro Preço da arma em moedas de ouro
     * @param ataque              Ataque da arma
     * @param ataqueEspecial      Ataque especial da arma
     */
    public ArmaPrincipal(String nome, int precoemMoedasdeOuro, int ataque, int ataqueEspecial) {
        super(nome, precoemMoedasdeOuro);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }


    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço em moedas de ouro: " + this.getPrecoemMoedasdeOuro());
        System.out.println("Heróis permitidos: " + this.getHeroisPermitidos());
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Ataque Especial: " + this.ataqueEspecial);
    }


    /**
     * Método getter do ataque
     *
     * @return ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método getter do ataque especial
     *
     * @return ataque especial
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
