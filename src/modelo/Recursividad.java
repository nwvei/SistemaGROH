/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Aaron
 */
public final class Recursividad {

    private Recursividad() {
    }

    public static long calcularIngresosEsperados(List<Reserva> reservas) {
        return sumarConfirmadas(reservas, 0);
    }

    private static long sumarConfirmadas(List<Reserva> reservas, int posicion) {
        if (posicion >= reservas.size()) {
            return 0L; 
        }
        Reserva actual = reservas.get(posicion);
        long aporte = actual.getEstado() == EstadoReserva.CONFIRMADA ? actual.getImporteTotal() : 0L;
        return aporte + sumarConfirmadas(reservas, posicion + 1);
    }

    public static int contarHabitacionesDisponibles(List<Habitacion> habitaciones,
            List<Reserva> reservas, LocalDate fecha) {
        return contarDesde(habitaciones, reservas, fecha, 0);
    }

    private static int contarDesde(List<Habitacion> habitaciones, List<Reserva> reservas,
            LocalDate fecha, int posicion) {
        if (posicion >= habitaciones.size()) {
            return 0; 
        }
        int actual = estaDisponibleEnFecha(habitaciones.get(posicion), reservas, fecha) ? 1 : 0;
        return actual + contarDesde(habitaciones, reservas, fecha, posicion + 1);
    }

    public static boolean estaDisponibleEnFecha(Habitacion habitacion, List<Reserva> reservas,
            LocalDate fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero().equals(habitacion.getNumero())
                    && reserva.getEstado().bloqueaDisponibilidad()
                    && reserva.incluyeFecha(fecha)) {
                return false;
            }
        }
        return true;
    }

    public static boolean estaDisponibleEnPeriodo(Habitacion habitacion, List<Reserva> reservas,
            LocalDate entrada, LocalDate salida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero().equals(habitacion.getNumero())
                    && reserva.getEstado().bloqueaDisponibilidad()
                    && reserva.seSolapaCon(entrada, salida)) {
                return false;
            }
        }
        return true;
    }
}

