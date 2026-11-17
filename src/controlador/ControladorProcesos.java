/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepciones.SesionException;
import Hilos.ActualizadorIndicadores;
import Hilos.SupervisorReservas;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;
import modelo.GestorHotel;
import modelo.Indicadores;

public class ControladorProcesos {
    private final AtomicBoolean enEjecucion = new AtomicBoolean(false);
    private volatile Thread hiloSupervisor;
    private volatile Thread hiloActualizador;
    private volatile Thread hiloCoordinador;

    public boolean estaEnEjecucion() {
        return enEjecucion.get();
    }

    public void iniciar(Consumer<String> alMensaje, Consumer<Indicadores> alIndicadores,
            Runnable alTerminar) throws SesionException {
        if (!enEjecucion.compareAndSet(false, true)) {
            throw new SesionException("Los procesos de supervisión ya están en ejecución.");
        }
        Consumer<String> mensajeEdt = m -> SwingUtilities.invokeLater(() -> alMensaje.accept(m));
        Consumer<Indicadores> indicadoresEdt = i -> SwingUtilities.invokeLater(() -> alIndicadores.accept(i));

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
            enEjecucion.set(false);
            SwingUtilities.invokeLater(alTerminar);
        }
    }

    public void detener() {
        for (Thread t : new Thread[]{hiloSupervisor, hiloActualizador, hiloCoordinador}) {
            if (t != null) {
                t.interrupt();
            }
        }
    }
}
