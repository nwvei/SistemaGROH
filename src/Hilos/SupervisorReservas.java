/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import modelo.GestorHotel;

/**
 *
 * @author Aaron
 */
public class SupervisorReservas implements Runnable {

    public static final int CICLOS = 5;
    public static final long PAUSA_MS = 1000L;
    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final GestorHotel gestor = GestorHotel.getInstancia();
    private final Consumer<String> alMensaje;

    public SupervisorReservas(Consumer<String> alMensaje) {
        this.alMensaje = alMensaje;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        publicar(nombre + ": Inicio ejecución (" + CICLOS + " ciclos).");
        for (int ciclo = 1; ciclo <= CICLOS; ciclo++) {
            int vencidas = gestor.actualizarReservasVencidas(LocalDate.now());
            publicar(nombre + ": Ciclo " + ciclo + " de " + CICLOS + " - "
                    + (vencidas > 0 ? "Reserva(s) actualizada(s) a Vencida: " + vencidas + "."
                            : "sin reservas por vencer."));
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
