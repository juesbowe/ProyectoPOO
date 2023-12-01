/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1;

/**
 *
 * @author jose-
 */
public class FichaComodin extends Ficha{
    
    public FichaComodin(int lado1, int lado2) {
        super(-1, -1);
    }
    
    public void setLado1(int lado1){
        super.lado1=lado1;
    }
    
    public void setLado2(int lado2){
        super.lado2=lado2;
    }
    
    @Override
    public String toString(){
        return "*"+super.toString()+"*";
    }
    
}
