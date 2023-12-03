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
          Scanner scanner = new Scanner(System.in);
        
        juego.agregarJugador("Jugador 0");
        juego.agregarJugador("Maquina");
 
        
        boolean jugando = true;
        while(jugando == true){
            ArrayList<Jugador> jugadoresEliminados = new ArrayList<>();
            
            for (Jugador jugador : juego.getJugadores()) {
                
                System.out.print(jugador.getNombre() + ": Mano -> ");jugador.imprimirMano();
                System.out.print("Línea de Juego -> ");juego.mostrarLinea();
                
                boolean validar = false;
                
                if (jugador.getNombre().equalsIgnoreCase("Maquina")){
                    validar = juego.jugarMaquina(jugador);  
                    if(validar==true){
                        System.out.println("Movimiento valido.");
                    }
                }
                else{
                    boolean validarMovimientos = juego.validarMovimientos(jugador);
                    if(validarMovimientos == true){
                        while(validar==false){
                            System.out.print("Índice de ficha para jugar (0 es el primero): ");
                            int pos = scanner.nextInt();
                            Ficha ficha = jugador.getFicha(pos);
                            validar = juego.agregarFichaLinea(ficha, jugador);
                            if (validar == true){
                                System.out.println("Movimiento valido."); 
                            }else if(validar == false){
                                System.out.println("Ficha tenía "+ ficha +" No puedo jugar esa ficha, inténtalo de nuevo");
                            }
                        }
                    }
                }
                
                if (validar == true){
                    System.out.print("Nueva Línea de Juego -> ");juego.mostrarLinea();System.out.println("");
                } else if(validar == false && jugador.getMano().isEmpty()) {
                    jugando = false;
                    System.out.println("EL JUGADOR: "+jugador+" HA GANADO!!");
                } else if(validar == false){
                    jugadoresEliminados.add(jugador);
                    System.out.println("El JUGADOR: "+jugador.getNombre()+" NO TIENE FICHAS JUGABLES, POR LO TANTO HA SIDO ELIMINADO");
                    System.out.println("");
                }
                if (juego.getJugadores().size()-jugadoresEliminados.size() == 1){
                    break;
                }

            }
            for(Jugador jugador : jugadoresEliminados ){
                juego.getJugadores().remove(jugador);
            }
            if(juego.getJugadores().size()==1){
                System.out.println("EL GANADOR ES EL JUGADOR: "+juego.getJugadores().get(0).getNombre());
                jugando =false;
            } 
            
        }
    }
}
}


