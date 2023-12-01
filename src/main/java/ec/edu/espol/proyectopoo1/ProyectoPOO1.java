/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo1;

import java.util.Scanner;

/**
 *
 * @author jose-
 */
public class ProyectoPOO1 {

    public static void main(String[] args) {
       Juego juego = new Juego();

        juego.agregarJugador("Jugador 0");
        juego.agregarJugador("Máquina");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < juego.getJugadores().size() - 1; i++) {
                // Turno del jugador humano
                Jugador jugador = juego.getJugadores().get(i);
                System.out.println(jugador.getNombre() + ": Mano -> " + jugador.getNombre());
                jugador.imprimirMano();

                System.out.println("Línea de Juego -> ");
                juego.mostrarLinea();

                Ficha ficha;
                do {
                    System.out.print("Índice de ficha para jugar (0 es el primero): ");
                    int indice = scanner.nextInt();
                    ficha = jugador.getFicha(indice);
                    if (ficha == null) {
                        System.out.println("Índice no válido. Intenta de nuevo.");
                    }
                } while (ficha == null);

                boolean movimientoValido = juego.agregarFichaLinea(ficha, jugador);

                while (!movimientoValido) {
                    System.out.print("Índice de ficha para jugar (0 es el primero): ");
                    int indice = scanner.nextInt();
                    ficha = jugador.getFicha(indice);
                    movimientoValido = juego.agregarFichaLinea(ficha, jugador);
                }
            }

            // Turno de la máquina
            juego.turnoMaquina();
        }
    
    }
}
