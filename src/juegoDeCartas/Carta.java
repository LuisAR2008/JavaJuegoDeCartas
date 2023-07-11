package juegoDeCartas;


class Carta {
    private String figura;
    private int valor;

    public Carta(String figura, int valor) {
        this.figura = figura;
        this.valor = valor;
    }

    public String getFigura() {
        return this.figura;
    }

    public int getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return this.figura + " " + this.valor;
    }
}


