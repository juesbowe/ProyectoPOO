/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

import java.util.ArrayList;

/**
 *
 * @author jose-
 */
// Definicion de la clase Jugador
public class Jugador {
    // Atributos privados que representan el nombre del jugador y su mano
    private String nombre;
    private ArrayList<Ficha> mano;

    // Constructor de la clase Jugador que recibe un nombre y una mano
    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la mano del jugador
    public ArrayList<Ficha> getMano() {
        return mano;
    }

    // Método para obtener una ficha específica de la mano
    public Ficha getFicha(int i) {
        // Verifica que el índice esté dentro de los límites de la mano
        if (i >= 0 && i < mano.size()) {
            return mano.get(i);
        }
        return null;
    }
    
     // Método para imprimir la mano de fichas del jugador
    public void imprimirMano(){
          for(int i=0; i<mano.size();i++){
            Ficha f = mano.get(i);
            if(i!=mano.size()-1){
                System.out.print(f.toString()+" - ");
            }
            else
                System.out.println(f.toString());
        }
    }
        
    // Método para remover una ficha específica de la mano
    public void removerFicha(Ficha f){
        mano.remove(f);
    }
    
}
