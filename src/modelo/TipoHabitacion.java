/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public enum TipoHabitacion {
    INDIVIDUAL("Individual"),
    DOBLE("Doble"),
    FAMILIAR("Familiar");

    private final String texto;

    TipoHabitacion(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
