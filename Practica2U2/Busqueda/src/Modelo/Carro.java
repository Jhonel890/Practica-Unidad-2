package Modelo;

import java.io.Serializable;
/**
 *
 */
public class Carro implements Serializable,Comparable<Carro>{
    
    private String marca;
    private int nro_serie;
    private String color;

    public Carro() {
    }

    public Carro(String marca, int nro_serie, String color) {
        this.marca = marca;
        this.nro_serie = nro_serie;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(int nro_serie) {
        this.nro_serie = nro_serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", nro_serie=" + nro_serie + ", color=" + color + '}';
    }
    
    @Override
    public int compareTo(Carro o) {
        if (this.nro_serie != o.getNro_serie()) {
            return this.nro_serie - o.getNro_serie();
        }
        return this.marca.compareTo(o.getMarca());
    }
   
}
