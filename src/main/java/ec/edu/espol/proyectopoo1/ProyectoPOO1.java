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
            for (int i = 0; i < juego.getJugadores().size(); i++) {
                // Turno del jugador o de la máquina
                if (i == 1) {
                    juego.turnoMaquina();
                } else {
                    Jugador jugador = juego.getJugadores().get(i);
                    System.out.println(jugador.getNombre() + ": Mano -> " + jugador.getNombre());
                    jugador.imprimirMano();

                    System.out.println("Línea de Juego -> ");
                    juego.mostrarLinea();

                    int indice;
                    do {
                        System.out.print("Índice de ficha para jugar (0 es pasar turno): ");
                        indice = scanner.nextInt();
                        if (indice == 0) {
                            System.out.println(jugador.getNombre() + " ha pasado su turno.");
                            break;
                        }
                        if (indice < 0 || indice-1 > jugador.getMano().size()) {
                            System.out.println("Índice no válido. Intenta de nuevo.");
                        }
                    } while (indice < 0 || indice-1 > jugador.getMano().size());

                    if (indice != 0) {
                        Ficha ficha = jugador.getFicha(indice-1);
                        boolean movimientoValido = juego.agregarFichaLinea(ficha, jugador);

                        while (!movimientoValido) {
                            do {
                                System.out.print("Índice de ficha para jugar (0 es pasar turno): ");
                                indice = scanner.nextInt();
                                if (indice == 0) {
                                    System.out.println(jugador.getNombre() + " ha pasado su turno.");
                                    break;
                                }
                                if (indice-1 < 0 || indice >= jugador.getMano().size()) {
                                    System.out.println("Índice no válido. Intenta de nuevo.");
                                }
                            } while (indice < 0 || indice-1 >= jugador.getMano().size());

                            if (indice != 0) {
                                ficha = jugador.getFicha(indice-1);
                                movimientoValido = juego.agregarFichaLinea(ficha, jugador);
                            }
                        }
                    }
                }
            }
        }
    }
}

