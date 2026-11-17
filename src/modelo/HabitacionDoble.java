/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class HabitacionDoble extends Habitacion {

    HabitacionDoble(String numero) {
        super(numero);
    }

    @Override
    public TipoHabitacion getTipo() {
        return TipoHabitacion.DOBLE;
    }

    @Override
    public int getCapacidad() {
        return 2;
    }

    @Override
    public long getTarifaPorNoche() {
        return 40_000L;
    }
}
