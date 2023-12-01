/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jose-
 */
public class Juego {

    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;

    public Juego() {
        this.lineaJuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombre) {
        Jugador p = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(p);

    }

    public int obtenerValorInicioLinea() {
        Ficha ficha = lineaJuego.get(0);
        int a = ficha.getLado1();
        return a;
    }

    public int obtenerValorFinalLinea() {
        int i = lineaJuego.size() - 1;
        Ficha ficha2 = lineaJuego.get(i);
        int valorFin = ficha2.getLado2();
        return valorFin;
    }

    public void mostrarLinea() {
        for (Ficha ficha : lineaJuego) {
            System.out.print(ficha + " - ");
        }
        System.out.println();

    }

    public boolean agregarFichaLinea(Ficha f, Jugador j) {
       if (!(f instanceof FichaComodin)) {
            if (lineaJuego.isEmpty() || (f.getLado2() == obtenerValorInicioLinea()) || f.getLado1() == obtenerValorFinalLinea()) {
                if (!lineaJuego.isEmpty()) {
                    if (f.getLado2() == obtenerValorInicioLinea()) {
                        lineaJuego.add(0,f);
                        j.removerFicha(f);
                        return true;
                    } else if (f.getLado1() == obtenerValorFinalLinea()) {
                        lineaJuego.add(f);
                        j.removerFicha(f);
                        return true;
                    }else { 
                        System.out.println("Movimiento no válido. Intenta de nuevo.");
                        return false;
                    }
                }else {
                return lineaJuego.add(f);
                
                }
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            if (!lineaJuego.isEmpty()) {
                System.out.print("Ingrese la posición (Inicio/Fin): ");
                String posicion = scanner.nextLine();
                if ("Inicio".equalsIgnoreCase(posicion)) {
                    lineaJuego.add(0, f);
                    System.out.print("Ingrese el valor del lado1: ");
                    FichaComodin f1= (FichaComodin)f;
                    f1.setLado1(scanner.nextInt());
                    return true;
                    
                } else if ("Fin".equalsIgnoreCase(posicion)) {
                    lineaJuego.add(f);
                    System.out.print("Ingrese el valor del lado2: ");
                    FichaComodin f2= (FichaComodin)f;
                    f2.setLado2(scanner.nextInt());
                    return true;
                }
            } else {
                lineaJuego.add(f);
                FichaComodin f1= (FichaComodin)f;
                System.out.print("Ingrese el valor del lado1: ");
                f1.setLado1(scanner.nextInt());
                FichaComodin f2= (FichaComodin)f;
                System.out.print("Ingrese el valor del lado2: ");
                f2.setLado2(scanner.nextInt());
                return true;
            }
        return false;
        }
        return false;
        
    }
    public void turnoMaquina() {
        Jugador maquina = jugadores.get(1); // Suponiendo que la máquina es el segundo jugador
        Ficha ficha = null;

        for (Ficha manoFicha : maquina.getMano()) {
            if (lineaJuego.isEmpty() || manoFicha.getLado2() == obtenerValorInicioLinea() ||
                manoFicha.getLado1() == obtenerValorFinalLinea()) {
                ficha = manoFicha;
                break;
            }
        }

        if (ficha != null) {
            System.out.println(maquina.getNombre() + ": Mano -> " + maquina.getNombre());
            maquina.imprimirMano();
            System.out.println("Línea de Juego -> ");
            mostrarLinea();
            System.out.println(maquina.getNombre() + " juega ficha: " + ficha);
            agregarFichaLinea(ficha, maquina);
        } else {
            System.out.println(maquina.getNombre() + " no puede jugar ninguna ficha.");
        }
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    
}
