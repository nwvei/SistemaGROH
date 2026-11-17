/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public record Indicadores(int totalHabitaciones, int ocupadas, int noOcupadas,
        int confirmadas, int vencidas, long ingresosEsperados) {

    public static final Indicadores VACIOS = new Indicadores(0, 0, 0, 0, 0, 0L);
}
