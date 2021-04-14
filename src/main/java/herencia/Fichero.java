/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Fichero {

    public static void main(String[] args) throws IOException {

        ArrayList<Vehiculo> ListaVehiculos = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            ListaVehiculos.add(new Turismo(2, true, "seat", "toledo", "rojo", 34324.4, true));

        }

        for (int i = 0; i < 30; i++) {

            ListaVehiculos.add(new Deportivo(344, "porsche", "911", "verde", 234241.5, true));
        }

        String ruta = "Vehiculos.csv";
        File f = new File(ruta);
        FileOutputStream fw = new FileOutputStream(f);
        try ( ObjectOutputStream escritura = new ObjectOutputStream(fw)) {
            for (int i = 0; i < ListaVehiculos.size(); i++) {

                if (ListaVehiculos.get(i) instanceof Turismo) {
                    escritura.writeObject(  ListaVehiculos.get(i).toString());
                }

                if (ListaVehiculos.get(i) instanceof Deportivo) {
                    escritura.writeObject( ListaVehiculos.get(i).toString());
                }

            }
        }

    }
}
