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
public class Turismo extends Vehiculo {

    // Además de los atributos de Vehiculo, esta clase tiene los siguientes
    private int puertas;
    private boolean marchaAutomatica;

    public Turismo(String matricula, String marca, String modelo, String color,
            double tarifa, boolean disponible, int puertas, boolean marchaAutomatica) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }
    
    @Override
    public String toString() {
        // Llamada al método toString() de la clase Vehiculo y
        // concateno los atributos de la superclase con los de la subclase
        return super.toString() + ":" + this.puertas
                + ":" + this.marchaAutomatica;
    }
}
