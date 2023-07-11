package juegoDeCartas;


import java.util.ArrayList;
import java.util.List;

	class Jugador {
		private String nombre;
		private List<Carta> cartas;
	
	    public Jugador(String nombre) {
	        this.nombre = nombre;
	        this.cartas = new ArrayList<>();
	    }
	
	    public String getNombre() {
	        return nombre;
	    }
	
	    public List<Carta> getCartas() {
	        return cartas;
	    }
	
	    public void setCarta(Carta carta) {
	        cartas.add(carta);
	    }
	
	    public int calcularPuntos() {
	        int puntos = 0;
	        String figura = null;
	
	        for (Carta carta : cartas) {
	            if (figura == null) {
	                figura = carta.getFigura();
	            } else if (!figura.equals(carta.getFigura())) {
	                return 0; // Las cartas no son de la misma figura, no hay puntos
	            }
	
	            puntos += carta.getValor();
	        }
	
	        return puntos;
    }
}