/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import controlador.ControladorProcesos;
import modelo.GestorHotel;
import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
public class CoordinadorProcesos implements Runnable {

    private final Thread supervisor;
    private final Thread actualizador;
    private final Notificador notificador;
    private final ControladorProcesos controlador;

    public CoordinadorProcesos(Thread supervisor, Thread actualizador, Notificador notificador,
            ControladorProcesos controlador) {
        this.supervisor = supervisor;
        this.actualizador = actualizador;
        this.notificador = notificador;
        this.controlador = controlador;
    }

    @Override
    public void run() {
        while (supervisor.isAlive() || actualizador.isAlive()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
                System.out.println("CoordinadorProcesos: espera interrumpida.");
            }
        }
        Indicadores finales = GestorHotel.getInstancia().calcularIndicadores();
        System.out.println("CoordinadorProcesos: ambos hilos terminaron; indicadores finales calculados.");
        notificador.mostrarMensaje("Procesos finalizados. Indicadores finales actualizados.");
        notificador.mostrarIndicadores(finales);
        controlador.terminarEjecucion();
        notificador.procesosTerminados();
    }
}
