package RGP.src.RPG;

abstract class Entidade {

    private String nome;
    private int vida;
    private int forca;


    /**
     * Método construtor
     *
     * @param nome  Nome da entidade
     * @param vida  Vida da entidade
     * @param forca Força da entidade
     */
    public Entidade(String nome, int vida, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }

    /**
     * Método para mostrar os detalhes da entidade
     */
    public void mostrarDetalhes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Força: " + this.forca);

    }

    /**
     * Método getter da vida
     *
     * @return vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * Método setter da vida
     *
     * @param vida vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Método getter da força
     *
     * @return forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * Método setter da força
     *
     * @param forca forca
     */
    public void setForca(int forca) {
        this.forca = forca;
    }
}
