/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Habitacion;

public record ResultadoDisponibilidad(LocalDate fecha, int total, List<Habitacion> habitaciones) {
}
