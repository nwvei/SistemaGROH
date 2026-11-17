/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public final class HabitacionFactory {

    private HabitacionFactory() {
    }

    public static Habitacion crear(String numero, TipoHabitacion tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de habitación es obligatorio.");
        }
        return switch (tipo) {
            case INDIVIDUAL -> new HabitacionIndividual(numero);
            case DOBLE -> new HabitacionDoble(numero);
            case FAMILIAR -> new HabitacionFamiliar(numero);
        };
    }
}
