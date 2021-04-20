/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.awt.Color;

/**
 *
 * @author aleja
 */
public class Deportivo extends Vehiculo {

    // Además de los atributos de Vehiculo, esta clase tiene los siguientes
    private int cilindrada;

    public Deportivo(String matricula, String marca, String modelo, String color,
            double tarifa, boolean disponible, int cilindrada) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        // Llamada al método toString() de la clase Vehiculo y
        // concateno los atributos de la superclase con los de la subclase
        return super.toString() + ":" + this.cilindrada;
    }
}
