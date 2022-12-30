package Controlador;

import Modelo.Carro;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Operaciones implements Serializable {

    public static Operaciones general = null;

    static {
        iniciarDatos();
    }

    public static void iniciarDatos() {
        Operaciones tmpGeneral = SerializarObjeto.deserializarObjeto("EstadoProductos.dat", Operaciones.class);
        if (tmpGeneral == null) {
            System.out.println("Creando los Datos Iniciales");
            Operaciones.general = new Operaciones();
        } else {
            System.out.println("Cargando Datos del Archivo");
            Operaciones.general = tmpGeneral;
        }
    }

    private List<Carro> carro = new LinkedList<>();
    int numero = 0;

    public void guardar() {
        String marca = null;
        int nroSerie = 0;
        String color = null;

        Carro[] carro = new Carro[this.carro.size()];

        for (int i = 0; i < this.carro.size(); i++) {
            marca = this.carro.get(i).getMarca();
            nroSerie = this.carro.get(i).getNro_serie();
            color = this.carro.get(i).getColor();
            carro[i] = new Carro(marca, nroSerie, color);
        }

        Arrays.sort(carro);

        for (int i = 0; i < this.carro.size(); i++) {
            this.carro.get(i).setMarca(carro[i].getMarca());
            this.carro.get(i).setNro_serie(carro[i].getNro_serie());
            this.carro.get(i).setColor(carro[i].getColor());

        }

        SerializarObjeto.serializarObjeto("EstadoProductos.dat", this);

    }

    int[] numSerie = new int[carro.size()];

    public List<Carro> getPersonas() {
        return carro;
    }

    public void setPersonas(List<Carro> personas) {
        this.carro = personas;
    }

    public static int Fecha(String f) {
        int fe;

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate fechaRegistro = LocalDate.parse(String.valueOf(f), date);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaRegistro, fechaActual);
        fe = periodo.getYears();

        return fe;
    }

    public static int busBinaria(int[] edades, int dato) {
        int inicio = 0;
        int fin = edades.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (edades[pos] == dato) {
                return pos;
            } else if (edades[pos] < dato) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return -1;
    }

    public int buscarLineal(int busqueda, int[] edades) {

        for (int i = 0; i < edades.length; i++) {

            if (edades[i] == busqueda) {

                return i;
            }
        }

        return -1;

    }

    public int buscarBinaria(int[] edades, int busqueda) {
        int res = busBinaria(edades, busqueda);

        return res;

    }

    public int buscar(int[] edades, int dato, String seleccion) {
        int num;
        if (seleccion == "Lineal") {
            num = buscarLineal(dato, edades);

        } else {
            num = buscarBinaria(edades, dato);

        }

        return num;
    }

    public void botonBuscar(int dato, String seleccion) {

        System.out.println(numSerie.length);
        buscar(numSerie, dato, seleccion);

    }

}
