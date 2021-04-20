/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aleja
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        final String marcaDeportivo = "Bugatti", modeloDeportivo = "veyron";
        final String colorDeportivo = "AZUL";
        final double tarifaDeportivo = 1200000;
        final int cilindradasDeportivos = 2984;
        final boolean disponibleDeportivo = true, marchaDeportivo = false;

        final String marcaTurismo = "Grotti", modeloTurismo = "Turismo R";
        final String colorTurismo = "ROJO";
        final double tarifaTurismo = 871663;
        final int puertasTurismo = 2, cilindradasTurismo = 1871;
        final boolean disponibleTurismo = true, marchaTurismo = false;

        final String marcaFurgoneta = "Volkswagen", modeloFurgoneta = "California";
        final String colorFurgoneta = "GRIS";
        final double tarifaFurgoneta = 59400;       
        final int cargaFurgoneta = 3500, volumenFurgoneta = 75;
        final boolean disponibleFurgoneta = true;

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            listaVehiculos.add(new Turismo(generarMatricula(listaVehiculos), marcaTurismo, modeloTurismo, colorTurismo, tarifaTurismo, disponibleTurismo, puertasTurismo, marchaTurismo));
        }

        for (int i = 0; i < 30; i++) {
            listaVehiculos.add(new Deportivo(generarMatricula(listaVehiculos), marcaDeportivo, modeloDeportivo, colorDeportivo, tarifaDeportivo, disponibleDeportivo, cilindradasDeportivos));
        }

        for (int i = 0; i < 30; i++) {
            listaVehiculos.add(new Furgoneta(generarMatricula(listaVehiculos), marcaFurgoneta, modeloFurgoneta, colorFurgoneta, tarifaFurgoneta, disponibleFurgoneta, cargaFurgoneta, volumenFurgoneta));
        }

        escribirEnFichero(listaVehiculos);
    }

    private static String generarMatricula(ArrayList<Vehiculo> listaVehiculos) {

        Random random = new Random();

        //creamos uyn boolean para controlar el hecho de que no se creen 
        //matriculas repetidas
        boolean matriculaValida = true;

        //declaramos las variabels que vamsoa a necesitar
        String matricula = null, letras, numeros;

        do {

            //inicializamos las letras y numeros a 0 antes de nada
            letras = "";
            numeros = "";

            for (int i = 0; i < 7; i++) {
                //del 0 al 3 crearemos los numeros y luego las 3 letras que forman una matricula
                if (i >= 0 && i < 4) {

                    numeros += String.valueOf(random.nextInt(10));
                } else {
                    letras += String.valueOf((char) (random.nextInt(26) + 'A'));
                }
            }

            //montamos las matricula
            matricula = numeros + letras;

            /**
             * Y aqui comprobamos que no se repitan las matricuals. Primero de
             * todo, si no existe ningun coche en la lista, no hara falta una
             * comprobacion de dicha matricula ya que no existe ninguna
             * matricual en la lista, por lo tanto todas son validas. Luego, una
             * vez hay matriculas en la lista miraremos si existe dicha
             * matricula en la lista.
             */
            if (!listaVehiculos.isEmpty()) {

                //recorremos toda la lista
                for (int i = 0; i < listaVehiculos.size(); i++) {

                    //si alguna matricula es igual que la creada, la matricula 
                    //no sera valida
                    if (listaVehiculos.get(i).getMatricula().equals(matricula)) {
                        matriculaValida = false;
                    }
                }
            }

        } while (!matriculaValida);

        //una vez este comprobado que es valida, devolvemos la matricula
        return matricula;
    }

    private static void escribirEnFichero(ArrayList<Vehiculo> listaVehiculos) {

        String idFichero = "vehiculos.csv";
        String tmp;

        final String TURISMO = "0:", DEPORTIVO = "1:", FURGONETA = "2:";

        //  0=TURISMO
        //  1=DEPORTIVO
        //  2=FIRGONETA
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("TIPOS DE VEHICULOS : MATRICULA : MARCA : MODELO : COLOR : TARIFA : DISPONIBLE");
           
            flujo.newLine();
            
            for (int i = 0; i < listaVehiculos.size(); i++) {

                if (listaVehiculos.get(i) instanceof Turismo) {
                    flujo.write(TURISMO + ((Turismo)listaVehiculos.get(i)).toString());
                }
                if (listaVehiculos.get(i) instanceof Deportivo) {
                    flujo.write(DEPORTIVO + ((Deportivo)listaVehiculos.get(i)).toString());
                }
                if (listaVehiculos.get(i) instanceof Furgoneta) {
                    flujo.write(FURGONETA + ((Furgoneta)listaVehiculos.get(i)).toString());
                }

                flujo.newLine();
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
