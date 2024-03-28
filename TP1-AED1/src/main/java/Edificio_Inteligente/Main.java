package Edificio_Inteligente;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int oficinasActivas = contarOficinasActivas();
        System.out.println("Cantidad de oficinas activas: " + oficinasActivas);
        
        Oficina primeraOficinaActiva = encontrarPrimeraOficinaActiva();
        if (primeraOficinaActiva != null) {
            System.out.println("Primera oficina activa: Piso " + primeraOficinaActiva.getPiso() + ", Oficina " + primeraOficinaActiva.getNumero());
        } else {
            System.out.println("No se encontraron oficinas activas.");
        }
    }

    public static int contarOficinasActivas() {
        Random random = new Random();
        int oficinasActivas = 0;

        for (int piso = 1; piso <= 10; piso++) {
            for (int oficina = 1; oficina <= 9; oficina++) {
                if (oficina != 1 && !(oficina == 5 && piso == 5)) { 
                    boolean actividad = random.nextBoolean();
                    if (actividad) {
                        oficinasActivas++;
                    }
                }
            }
        }

        return oficinasActivas;
    }

    public static Oficina encontrarPrimeraOficinaActiva() {
        Random random = new Random();
        int pisoAleatorio = random.nextInt(10) + 1; 
        int oficinaAleatoria;

        do {
            oficinaAleatoria = random.nextInt(8) + 1; 
        } while (oficinaAleatoria == 5); 

        for (int i = 0; i < 10 * 8; i++) { 
            boolean actividad = new Edificio().obtenerSensor(pisoAleatorio, oficinaAleatoria);
            if (actividad) {
                return new Oficina(pisoAleatorio, oficinaAleatoria);
            }
            
            pisoAleatorio = random.nextInt(10) + 1;
            do {
                oficinaAleatoria = random.nextInt(8) + 1; 
            } while (oficinaAleatoria == 5); 
        }
        return null; 
    }
}