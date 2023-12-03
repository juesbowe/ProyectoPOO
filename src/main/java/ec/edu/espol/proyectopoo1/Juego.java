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
// Definicion de la clase Juego
public class Juego {

    // Atributos privadps que representan la linea de juego y los jugadores
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;

    // Constructor de la clase Juego que inicializa las listas de la linea de juego y jugadores
    public Juego() {
        this.lineaJuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    // Metodo para agregar un jugador al juego con un nombre y una mano de fichas generada aleatoriamente
    public void agregarJugador(String nombre) {
        Jugador p = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(p);

    }

    // Metodo para obtener el valor del lado1 de la primera ficha en la linea de juego
    public int obtenerValorInicioLinea() {
        return lineaJuego.get(0).getLado1();
    }

    // Método para obtener el valor del lado2 de la última ficha en la linea de juego
    public int obtenerValorFinalLinea() {
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea() {
       if(this.lineaJuego.isEmpty()){
            System.out.println("");
        }
        for(int i=0; i<this.lineaJuego.size();i++){
            Ficha f = this.lineaJuego.get(i);
            if(i!=this.lineaJuego.size()-1){
                System.out.print(f.toString()+" - ");
            }
            else
                System.out.println(f.toString());
        }
    }
    
    public boolean agregarFichaLinea(Ficha ficha, Jugador j){
        Scanner scanner = new Scanner(System.in);
        //caso ficha es comodin
        if (ficha instanceof FichaComodin){
            //si no hay fichas en linea de juego
            if(lineaJuego.isEmpty()){
                lineaJuego.add(ficha);
                System.out.print("Digite valores para lado1 ");
                int lado1 = scanner.nextInt();
                ((FichaComodin)ficha).setLado1(lado1);
                System.out.print("Digite valores para lado2 ");
                int lado2 = scanner.nextInt();
                ((FichaComodin)ficha).setLado2(lado2);
            }
            //si hay fichas en linea de juego
            else{
                //a
                System.out.print("Digite donde quiere agregar la ficha en la linea 'Inicio' o 'Fin': ");
                String posicion = scanner.next();
                //b
                if(posicion.equalsIgnoreCase("Inicio")){
                    System.out.print("Digite valores para lado1 ");
                    int lado1 = scanner.nextInt();
                    ((FichaComodin)ficha).setLado1(lado1);
                    lineaJuego.add(0,ficha);
                }
                //c
                else if(posicion.equalsIgnoreCase("Fin")){
                    System.out.print("Digite valores para lado2 ");
                    int lado2 = scanner.nextInt();
                    ((FichaComodin)ficha).setLado2(lado2);
                    lineaJuego.add(ficha);
                }
            }
            j.removerFicha(ficha);
            return true;
        }
        //caso ficha no es comodin
        else if(ficha instanceof Ficha){
            //si no hay fichas en linea de juego
            if(lineaJuego.isEmpty()){
                lineaJuego.add(ficha);
                j.removerFicha(ficha);
                return true;
            }
            //si hay fichas en linea de juego
            else{
                if(ficha.getLado2()== obtenerValorInicioLinea()){
                    lineaJuego.add(0,ficha);
                    j.removerFicha(ficha);
                    return true;
                }
                else if(ficha.getLado1() == obtenerValorFinLinea()){
                    lineaJuego.add(ficha);
                    j.removerFicha(ficha);
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public boolean jugarMaquina(Jugador jugador){
        boolean validar=false;
        Random random = new Random();
        for(int i=0 ; i<jugador.getMano().size(); i++ ){
            Ficha ficha = jugador.getMano().get(i);
            if(!(ficha instanceof FichaComodin)){
                validar = agregarFichaLinea(ficha,jugador);
                if (validar==true){
                    System.out.println("Índice de ficha para jugar (0 es el primero): "+i);
                    break;
                } 
            }else if(ficha instanceof FichaComodin){
                int pos = random.nextInt(1)+1;
                System.out.println("Índice de ficha para jugar (0 es el primero): "+i);
                validar = true;
                if(pos == 1){//se agrega al inicio
                    int lado1 = random.nextInt(6) + 1;
                    System.out.println("Digite valores para lado1 " +lado1);
                    ((FichaComodin)ficha).setLado1(lado1);
                    lineaJuego.add(0,ficha);
                }else{//se agrega al final  
                    int lado2 = random.nextInt(6) + 1;
                    System.out.println("Digite valores para lado1 " +lado2);
                    ((FichaComodin)ficha).setLado2(lado2);
                    lineaJuego.add(ficha);
                }  
                jugador.removerFicha(ficha);
            }     
        }
        return validar;
    }
    
    public boolean validarMovimientos(Jugador jugador){
        boolean validar=false;
        for(Ficha ficha : jugador.getMano()){
            //valida si se puede jugar alguna ficha
            if (lineaJuego.isEmpty() || 
                ficha.getLado2()== obtenerValorInicioLinea() || 
                ficha.getLado1() == obtenerValorFinLinea() ||
                ficha instanceof FichaComodin){
                validar = true;
                break;
            } 
        }
        return validar;
    }
    
    public void removerJugador(Jugador jugador){
        jugadores.remove(jugador);
    }

}
