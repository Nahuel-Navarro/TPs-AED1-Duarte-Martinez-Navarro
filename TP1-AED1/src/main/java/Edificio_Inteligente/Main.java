package Edificio_Inteligente;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int totalOficinas = 10 * 9; // 10 pisos con 9 oficinas cada uno
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
                if (oficina != 1 && !(oficina == 5 && piso == 5)) { // Ignorar la primera oficina de cada piso y el hall de ascensores en el piso 5
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
        int pisoAleatorio = random.nextInt(10) + 1; // Seleccionar aleatoriamente un piso entre 1 y 10
        int oficinaAleatoria;

        do {
            oficinaAleatoria = random.nextInt(8) + 1; // Seleccionar aleatoriamente una oficina entre 1 y 9, excluyendo el 5
        } while (oficinaAleatoria == 5); // Repetir el proceso si se selecciona la oficina número 5

        for (int i = 0; i < 10 * 8; i++) { // Iterar a lo sumo sobre todas las oficinas (10 pisos * 8 oficinas)
            boolean actividad = new Edificio().obtenerSensor(pisoAleatorio, oficinaAleatoria);
            if (actividad) {
                return new Oficina(pisoAleatorio, oficinaAleatoria);
            }
            // Generar nuevas oficinas aleatorias si no se encuentra ninguna activa en la actual
            pisoAleatorio = random.nextInt(10) + 1;
            do {
                oficinaAleatoria = random.nextInt(8) + 1; // Seleccionar aleatoriamente una oficina entre 1 y 9, excluyendo el 5
            } while (oficinaAleatoria == 5); // Repetir el proceso si se selecciona la oficina número 5
        }
        return null; // Si no se encuentra ninguna oficina activa en el edificio
    }
}