/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.GestorHotel;

/**
 *
 * @author Aaron
 */
public class SupervisorReservas implements Runnable {

    public static final int CICLOS = 5;
    public static final long PAUSA_MS = 1000L;

    private final GestorHotel gestor = GestorHotel.getInstancia();
    private final Notificador notificador;
    private boolean detenido = false;

    public SupervisorReservas(Notificador notificador) {
        this.notificador = notificador;
    }

    public synchronized void detener() {
        detenido = true;
    }

    private synchronized boolean estaDetenido() {
        return detenido;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        publicar(nombre + ": Inicio ejecución (" + CICLOS + " ciclos).");
        for (int ciclo = 1; ciclo <= CICLOS; ciclo++) {
            if (estaDetenido()) {
                publicar(nombre + ": Detenido en el ciclo " + ciclo + ". Finaliza anticipadamente.");
                return;
            }
            int vencidas = gestor.actualizarReservasVencidas(LocalDate.now());
            publicar(nombre + ": Ciclo " + ciclo + " de " + CICLOS + " - "
                    + (vencidas > 0 ? "Reserva(s) actualizada(s) a Vencida: " + vencidas + "."
                            : "sin reservas por vencer."));
            if (ciclo < CICLOS) {
                try {
                    Thread.sleep(PAUSA_MS);
                } catch (InterruptedException ex) {
                    publicar(nombre + ": Interrumpido en el ciclo " + ciclo + ". Finaliza anticipadamente.");
                    return;
                }
            }
        }
        publicar(nombre + ": Finaliza ejecución.");
    }

    public static String horaActual() {
        LocalTime ahora = LocalTime.now();
        return dosDigitos(ahora.getHour()) + ":" + dosDigitos(ahora.getMinute()) + ":" + dosDigitos(ahora.getSecond());
    }

    private static String dosDigitos(int numero) {
        if (numero < 10) {
            return "0" + numero;
        }
        return String.valueOf(numero);
    }

    private void publicar(String mensaje) {
        String linea = "[" + horaActual() + "] " + mensaje;
        System.out.println(linea);
        if (notificador != null) {
            notificador.mostrarMensaje(linea);
        }
    }
}
