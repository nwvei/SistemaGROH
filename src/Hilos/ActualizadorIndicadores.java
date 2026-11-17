/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import modelo.GestorHotel;
import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
public class ActualizadorIndicadores implements Runnable {

    public static final int CICLOS = SupervisorReservas.CICLOS;
    public static final long PAUSA_MS = SupervisorReservas.PAUSA_MS;
    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final GestorHotel gestor = GestorHotel.getInstancia();
    private final Consumer<String> alMensaje;
    private final Consumer<Indicadores> alCalcular;

    public ActualizadorIndicadores(Consumer<String> alMensaje, Consumer<Indicadores> alCalcular) {
        this.alMensaje = alMensaje;
        this.alCalcular = alCalcular;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        publicar(nombre + ": Inicio ejecución (" + CICLOS + " ciclos).");
        for (int ciclo = 1; ciclo <= CICLOS; ciclo++) {
            Indicadores ind = gestor.calcularIndicadores();
            publicar(nombre + ": Ciclo " + ciclo + " de " + CICLOS + " - indicadores actualizados ("
                    + "confirmadas=" + ind.confirmadas() + ", vencidas=" + ind.vencidas()
                    + ", ocupadas=" + ind.ocupadas() + ", ingresos=" + ind.ingresosEsperados() + ").");
            if (alCalcular != null) {
                alCalcular.accept(ind);
            }
            if (ciclo < CICLOS) {
                try {
                    Thread.sleep(PAUSA_MS);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    publicar(nombre + ": Interrumpido en el ciclo " + ciclo + ". Finaliza anticipadamente.");
                    return;
                }
            }
        }
        publicar(nombre + ": Finaliza ejecución.");
    }

    private void publicar(String mensaje) {
        String linea = "[" + LocalTime.now().format(HORA) + "] " + mensaje;
        System.out.println(linea);
        if (alMensaje != null) {
            alMensaje.accept(linea);
        }
    }
}
