/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Habitacion;

public class ResultadoDisponibilidad {

    private final LocalDate fecha;
    private final int total;
    private final List<Habitacion> habitaciones;

    public ResultadoDisponibilidad(LocalDate fecha, int total, List<Habitacion> habitaciones) {
        this.fecha = fecha;
        this.total = total;
        this.habitaciones = habitaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getTotal() {
        return total;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
