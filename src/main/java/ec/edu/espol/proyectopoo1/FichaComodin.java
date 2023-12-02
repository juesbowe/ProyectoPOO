/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

/**
 *
 * @author jose-
 */
//Definicion de la clase FichaCOmodin que hereda de la clase Ficha
public class FichaComodin extends Ficha{
    
    // Constructor de la clase FichaComodin que inicializa los lados con valores de (-1,-1)
    public FichaComodin(int lado1, int lado2) {
        super(-1, -1);
    }

    // Metodo para establecer el valor del lado1 del comodin
    public void setLado1(int lado1){
        super.lado1=lado1;
    }
    
    // Metodo para establecer el valor del lado2 del comodin
    public void setLado2(int lado2){
        super.lado2=lado2;
    }
    
    // Metodo toString que devuelve una representacion en cadena del comodin, con asteriscos al inicio y al final
    @Override
    public String toString(){
        return "*"+super.toString()+"*";
    }
    
}
