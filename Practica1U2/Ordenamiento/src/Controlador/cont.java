package Controlador;

public class cont {

    int tamaño;

    private static int particion(double arreglo[], int izquierda, int derecha, String orden) {
        double pivote = arreglo[izquierda];

        while (true) {
            if (orden == "Ascendente") {
                while (arreglo[izquierda] < pivote) {
                    izquierda++;
                }
                while (arreglo[derecha] > pivote) {
                    derecha--;
                }
            } else {
                while (arreglo[izquierda] > pivote) {
                    izquierda++;
                }
                while (arreglo[derecha] < pivote) {
                    derecha--;
                }
            }

            if (izquierda >= derecha) {
                return derecha;
            } else {
                double temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
        }
    }

    private static void quicksort(double arreglo[], int izquierda, int derecha, String orden) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha, orden);
            quicksort(arreglo, izquierda, indiceParticion, orden);
            quicksort(arreglo, indiceParticion + 1, derecha, orden);
        }
    }

    public static int busquedaBinariaRecursiva(double[] arreglo, int busqueda, int izquierda, int derecha) {

        // Si izquierda es mayor que derecha significa que no encontramos nada
        if (izquierda > derecha) {
            return -1;
        }

        // Calculamos las mitades...
        int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
        double elementoDelMedio = arreglo[indiceDelElementoDelMedio];

        // Ver si está en la mitad
        if (elementoDelMedio == busqueda) {
            return indiceDelElementoDelMedio;
        }
        // Si no, entonces vemos si está a la izquierda o derecha

        if (busqueda < elementoDelMedio) {
            derecha = indiceDelElementoDelMedio - 1;
            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
        } else {
            izquierda = indiceDelElementoDelMedio + 1;
            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
        }
    }

    public static Integer Secuencial(double[] data, int valor) {
        Integer pos = null;
        for (int i = 0; i < data.length; i++) {
            if (valor == data[i]) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void shell(double A[], String orden) {

        int salto, i;
        double aux;
        boolean cambios;

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if (orden == "Ascendente") {
                        if (A[i - salto] > A[i]) {       // y si están desordenados
                            aux = A[i];                  // se reordenan
                            A[i] = A[i - salto];
                            A[i - salto] = aux;
                            cambios = true;
                        }             // y se marca como cambio.                                   
                    } else if (orden == "Descendente") {
                        if (A[i - salto] < A[i]) {       // y si están desordenados
                            aux = A[i];                  // se reordenan
                            A[i] = A[i - salto];
                            A[i - salto] = aux;
                            cambios = true;
                        }

                    }

                }
            }
        }
    }

    public void ejec(double precios[], String metodo, String orden) {

        int n = precios.length;

        if (metodo == "quicksort") {
            quicksort(precios, 0, n - 1, orden);
        } else {
            if (metodo == "shell") {
                shell(precios, orden);
            }

        }

        //Carro ob = new Carro();
//        int busqueda = 0.25f;
//        int indiceDelElementoBuscado = busquedaBinariaRecursiva(precios, busqueda, 0, precios.length - 1);
//        System.out.println("[Binaria] -- El elemento buscado (" + String.valueOf(busqueda) + ") se encuentra en el index " + indiceDelElementoBuscado);
//        
//        
//        int secuencial= Carro.Secuencial(precios, busqueda);
//        System.out.println("[Secuencial] -- El elemento buscado (" + String.valueOf(busqueda) + ") se encuentra en el index " + secuencial);
//        System.out.println(listaAutos.get(secuencial));
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
