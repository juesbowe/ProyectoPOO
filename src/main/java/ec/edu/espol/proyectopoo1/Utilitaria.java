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
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador() {
        ArrayList<Ficha> mano = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            mano.add(new Ficha(random.nextInt(6) + 1, random.nextInt(6) + 1));
        }
        
        mano.add(new FichaComodin(-1,-1));

        return mano;
    }
    
    
}
