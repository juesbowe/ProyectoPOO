/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jose-
 */
// Definicion de la clase Utilitaria
public class Utilitaria {
    // Metodo estatico que crea y devuelve manojugador como un ArrayList de Ficha 
    public static ArrayList<Ficha> crearManoJugador() {
        ArrayList<Ficha> mano = new ArrayList<>();
        Random random = new Random();

        // Bucle para crear 5 fichas con valores aleatorios entre 1 y 6 y agregarlas a la mano
        for (int i = 0; i < 5; i++) {
            mano.add(new Ficha(random.nextInt(6) + 1, random.nextInt(6) + 1));
        }
        // Agrega una ficha comodín a la mano con valores (-1, -1)
        mano.add(new FichaComodin(-1,-1));

         // Devuelve la mano de jugador creada
        return mano;
    }
    
    
}
