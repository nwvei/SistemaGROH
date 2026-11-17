/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepciones.SesionException;
import Hilos.ActualizadorIndicadores;
import Hilos.SupervisorReservas;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;
import modelo.GestorHotel;
import modelo.Indicadores;

public class ControladorProcesos {
    private boolean enEjecucion = false;
    private Thread hiloSupervisor;
    private Thread hiloActualizador;
    private Thread hiloCoordinador;

    public synchronized boolean estaEnEjecucion() {
        return enEjecucion;
    }

    private synchronized void terminarEjecucion() {
        enEjecucion = false;
    }

    public synchronized void iniciar(Consumer<String> alMensaje, Consumer<Indicadores> alIndicadores,
            Runnable alTerminar) throws SesionException {
        if (enEjecucion) {
            throw new SesionException("Los procesos de supervisión ya están en ejecución.");
        }
        enEjecucion = true;
        Consumer<String> mensajeEdt = mensaje -> SwingUtilities.invokeLater(() -> alMensaje.accept(mensaje));
        Consumer<Indicadores> indicadoresEdt = indicadores -> SwingUtilities.invokeLater(() -> alIndicadores.accept(indicadores));

        Thread supervisor = new Thread(new SupervisorReservas(mensajeEdt), "SupervisorReservas");
        Thread actualizador = new Thread(new ActualizadorIndicadores(mensajeEdt, indicadoresEdt),
                "ActualizadorIndicadores");
        Thread coordinador = new Thread(() -> esperarYActualizar(supervisor, actualizador,
                mensajeEdt, indicadoresEdt, alTerminar), "CoordinadorProcesos");
        hiloSupervisor = supervisor;
        hiloActualizador = actualizador;
        hiloCoordinador = coordinador;

        supervisor.start();
        actualizador.start();
        coordinador.start();
    }

    private void esperarYActualizar(Thread supervisor, Thread actualizador,
            Consumer<String> mensajeEdt, Consumer<Indicadores> indicadoresEdt, Runnable alTerminar) {
        try {
            supervisor.join();
            actualizador.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            supervisor.interrupt();
            actualizador.interrupt();
        } finally {
            Indicadores finales = GestorHotel.getInstancia().calcularIndicadores();
            System.out.println("CoordinadorProcesos: ambos hilos terminaron; indicadores finales calculados.");
            mensajeEdt.accept("Procesos finalizados. Indicadores finales actualizados.");
            indicadoresEdt.accept(finales);
            terminarEjecucion();
            SwingUtilities.invokeLater(alTerminar);
        }
    }

    public void detener() {
        for (Thread hilo : new Thread[]{hiloSupervisor, hiloActualizador, hiloCoordinador}) {
            if (hilo != null) {
                hilo.interrupt();
            }
        }
    }
}
