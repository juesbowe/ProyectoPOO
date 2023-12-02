/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

/**
 *
 * @author jose-
 */
//Definicion de la clase Ficha
public class Ficha {
    // Atributos protegidos que representan los lados de la ficha
    protected int lado1;
    protected int lado2;

    // Constructor de la clase que recibe dos valores enteros para inicializar los lados de la ficha
    public Ficha(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    // Método para obtener el valor del lado1
    public int getLado1() {
        return lado1;
    }

    // Método para obtener el valor del lado2
    public int getLado2() {
        return lado2;
    }
    
    // Método toString que devuelve una representación en cadena de la ficha
    @Override
    public String toString(){
        return this.lado1+":"+this.lado2;
    }
  
    
}
