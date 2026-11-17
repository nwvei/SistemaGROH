/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class HabitacionFamiliar extends Habitacion {

    HabitacionFamiliar(String numero) {
        super(numero);
    }

    @Override
    public TipoHabitacion getTipo() {
        return TipoHabitacion.FAMILIAR;
    }

    @Override
    public int getCapacidad() {
        return 4;
    }

    @Override
    public long getTarifaPorNoche() {
        return 65_000L;
    }
}
