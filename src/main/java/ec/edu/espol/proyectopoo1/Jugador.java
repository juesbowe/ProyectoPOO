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
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
    
    public Ficha getFicha(int i) {
        if (i >= 0 && i < mano.size()) {
            return mano.get(i);
        }
        return null;
    }
    public void imprimirMano(){
          for (Ficha ficha : mano) {
            System.out.print(ficha + " - ");
        }
        System.out.println();
    }
        
    
    
    public void removerFicha(Ficha f){
        mano.remove(f);
    }
    
}
