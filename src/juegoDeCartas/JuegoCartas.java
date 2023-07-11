package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoCartas {
    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        jugadores.add(new Jugador("Jugador 3"));
        jugadores.add(new Jugador("Jugador 4"));

        List<Carta> mazo = generarMazo();
        repartirCartas(jugadores, mazo, 3);

        System.out.println("Cartas repartidas:");

        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }

        Jugador ganador = determinarGanador(jugadores);

        if (ganador != null) {
            System.out.println("\nEl ganador es: " + ganador.getNombre());
            System.out.println("Puntos: " + ganador.calcularPuntos());
        } else {
            System.out.println("\nNo hay ganador");
        }
    }

    private static List<Carta> generarMazo() {
        List<Carta> mazo = new ArrayList<>();

        String[] figuras = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (String figura : figuras) {
            for (int valor : valores) {
                Carta carta = new Carta(figura, valor);
                mazo.add(carta);
            }
        }

        Collections.shuffle(mazo); // Mezcla el mazo de cartas

        return mazo;
    }

    private static void repartirCartas(List<Jugador> jugadores, List<Carta> mazo, int cantidadCartas) {
        int jugadorActual = 0;

        for (int i = 0; i < cantidadCartas; i++) {
            for (Jugador jugador : jugadores) {
                Carta carta = mazo.remove(0);
                jugador.setCarta(carta);
                
            }
        }
    }

    private static Jugador determinarGanador(List<Jugador> jugadores) {
        Jugador ganador = null;
        int maxPuntos = 0;

        for (Jugador jugador : jugadores) {
            int puntos = jugador.calcularPuntos();

            if (puntos > maxPuntos) {
                ganador = jugador;
                maxPuntos = puntos;
            }
        }

        return ganador;
    }
}