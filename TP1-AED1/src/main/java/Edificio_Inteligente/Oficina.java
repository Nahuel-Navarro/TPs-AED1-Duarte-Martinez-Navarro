package Edificio_Inteligente;

class Oficina {
    private int piso;
    private int numero;

    public Oficina(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumero() {
        return numero;
    }
}