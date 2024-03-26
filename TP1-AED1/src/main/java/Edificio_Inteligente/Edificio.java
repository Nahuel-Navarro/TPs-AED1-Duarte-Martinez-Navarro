package Edificio_Inteligente;

import java.util.Random;

class Edificio {
    private boolean[][] sensores; // Matriz para representar los sensores en cada piso

    public Edificio() {
        // Inicializar la matriz de sensores para los 10 pisos y 9 oficinas por piso
        sensores = new boolean[10][9];
        
        // Asignar valores aleatorios a los sensores
        Random random = new Random();
        for (int piso = 0; piso < 10; piso++) {
            for (int oficina = 0; oficina < 9; oficina++) {
                sensores[piso][oficina] = random.nextBoolean();
            }
        }
        
        // Desactivar sensores específicos según la consigna
        for (int piso = 0; piso < 10; piso++) {
            sensores[piso][0] = false; // Desactivar la primera oficina en cada piso
            if (piso != 4) {
                sensores[piso][4] = false; // Desactivar el hall de ascensores en cada piso, excepto el 5to
            }
        }
    }

    public boolean obtenerSensor(int piso, int oficina) {
        return sensores[piso - 1][oficina - 1];
    }

    public int cantidadOficinasActivas() {
        int contador = 0;
        for (int piso = 0; piso < 10; piso++) {
            for (int oficina = 0; oficina < 9; oficina++) {
                if (sensores[piso][oficina]) {
                    contador++;
                }
            }
        }
        return contador;
    }
}