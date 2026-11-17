/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import modelo.GestorHotel;
import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
public class ActualizadorIndicadores implements Runnable {

    public static final int CICLOS = SupervisorReservas.CICLOS;
    public static final long PAUSA_MS = SupervisorReservas.PAUSA_MS;

    private final GestorHotel gestor = GestorHotel.getInstancia();
    private final Notificador notificador;
    private boolean detenido = false;

    public ActualizadorIndicadores(Notificador notificador) {
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
            Indicadores indicadores = gestor.calcularIndicadores();
            publicar(nombre + ": Ciclo " + ciclo + " de " + CICLOS + " - indicadores actualizados ("
                    + "confirmadas=" + indicadores.getConfirmadas() + ", vencidas=" + indicadores.getVencidas()
                    + ", ocupadas=" + indicadores.getOcupadas() + ", ingresos=" + indicadores.getIngresosEsperados() + ").");
            if (notificador != null) {
                notificador.mostrarIndicadores(indicadores);
            }
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

    private void publicar(String mensaje) {
        String linea = "[" + SupervisorReservas.horaActual() + "] " + mensaje;
        System.out.println(linea);
        if (notificador != null) {
            notificador.mostrarMensaje(linea);
        }
    }
}
