/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class HabitacionIndividual extends Habitacion {

    HabitacionIndividual(String numero) {
        super(numero);
    }

    @Override
    public TipoHabitacion getTipo() {
        return TipoHabitacion.INDIVIDUAL;
    }

    @Override
    public int getCapacidad() {
        return 1;
    }

    @Override
    public long getTarifaPorNoche() {
        return 25_000L;
    }
}
