/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class LeerFichero {

    public static void main(String[] args) {
        // Fichero a leer con datos de ejemplo
        String idFichero = "Vehiculos.csv";
        ArrayList<Vehiculo> listaVehiculos= new ArrayList<>();

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
           
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                Vehiculo tur= new Turismo();
                Vehiculo dep= new Deportivo();
                for (String string : tokens) {
                   // System.out.print(string + "\t");
                   if(tokens[0]=="0"){
                       tur.setColor(tokens[7]);
                       tur.setDisponible(Boolean.parseBoolean(tokens[9]));
                       tur.setMarca(tokens[5]);
                       tur.setMatricula(tokens[4]);
                       tur.setModelo(tokens[6]);
                       tur.setPrecio(Double.parseDouble(tokens[8]));
                       
                   }
                   
                   if(tokens[0]=="1"){
                       dep.setColor(tokens[6]);
                       dep.setDisponible(Boolean.parseBoolean(tokens[8]));
                       dep.setMarca(tokens[4]);
                       dep.setMatricula(tokens[3]);
                       dep.setModelo(tokens[5]);
                       dep.setPrecio(Double.parseDouble(tokens[7]));
                       
                   }
                }
                //System.out.println();
                listaVehiculos.add(dep);
                listaVehiculos.add(tur);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
         Collections.sort(listaVehiculos);
         
        for (Vehiculo o: listaVehiculos ){
            System.out.println(o);
        }
    }
}
