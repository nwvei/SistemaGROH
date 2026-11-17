/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepciones.SesionException;
import Hilos.ActualizadorIndicadores;
import Hilos.CoordinadorProcesos;
import Hilos.Notificador;
import Hilos.SupervisorReservas;

public class ControladorProcesos {
    private boolean enEjecucion = false;
    private SupervisorReservas supervisor;
    private ActualizadorIndicadores actualizador;

    public synchronized boolean estaEnEjecucion() {
        return enEjecucion;
    }

    public synchronized void terminarEjecucion() {
        enEjecucion = false;
    }

    public synchronized void iniciar(Notificador notificador) throws SesionException {
        if (enEjecucion) {
            throw new SesionException("Los procesos de supervisión ya están en ejecución.");
        }
        enEjecucion = true;
        supervisor = new SupervisorReservas(notificador);
        actualizador = new ActualizadorIndicadores(notificador);

        Thread hiloSupervisor = new Thread(supervisor, "SupervisorReservas");
        Thread hiloActualizador = new Thread(actualizador, "ActualizadorIndicadores");
        Thread hiloCoordinador = new Thread(
                new CoordinadorProcesos(hiloSupervisor, hiloActualizador, notificador, this),
                "CoordinadorProcesos");

        hiloSupervisor.start();
        hiloActualizador.start();
        hiloCoordinador.start();
    }

    public synchronized void detener() {
        if (supervisor != null) {
            supervisor.detener();
        }
        if (actualizador != null) {
            actualizador.detener();
        }
    }
}
