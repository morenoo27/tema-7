/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Ejercicio7 {

    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        String idFichero = "vehiculos.csv", linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                Vehiculo tmp = null;
                linea = datosFichero.nextLine();

                tokens = linea.split(":");

//                MANERA OPTIMA DE REALIZAR EL TRABAJO, YA QUE SI LO HACEMOS EN 
//                EL CONSTRUCTOIR TENDREMOS UN CONSTRUCTOR KILOMETRICO Y NO QUEREMOS ESO 
//                tmp.setMatricula();
//                tmp.setMarca(linea);
//                tmp.setModelo(linea);
//                tmp.setColor(linea);
//                tmp.setTarifa(0);
//                tmp.setDisponible(true);

                switch (tokens[0]) {
                    case "0":
                        tmp = new Turismo(tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Boolean.valueOf(tokens[6]), Integer.parseInt(tokens[7]), Boolean.valueOf(tokens[8]));
                        break;
                    case "1":
                        tmp = new Deportivo(tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Boolean.valueOf(tokens[6]), Integer.parseInt(tokens[7]));
                        break;
                    case "2":
                        tmp = new Furgoneta(tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Boolean.valueOf(tokens[6]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[10]));
                        break;
                }
                listaVehiculos.add(tmp);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("------------------------VEHICULOS-------------------");
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Turismo) {
                System.out.println("TURISMO");
                System.out.println(((Turismo) vehiculo).toString());
            }
            if (vehiculo instanceof Deportivo) {
                System.out.println("DEPORTIVO");
                System.out.println(((Deportivo) vehiculo).toString());
            }
            if (vehiculo instanceof Furgoneta) {
                System.out.println("FURGONETA");
                System.out.println(((Furgoneta) vehiculo).toString());
            }
        }

        System.out.println("-----------------------------ORDENADOS------------------");
        Collections.sort(listaVehiculos, (c1, c2) -> c1.getMarca().compareTo(c2.getMarca()));

        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo.toString());
        }

    }
}
