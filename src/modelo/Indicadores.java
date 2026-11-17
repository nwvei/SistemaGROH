/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class Indicadores {

    public static final Indicadores VACIOS = new Indicadores(0, 0, 0, 0, 0, 0L);

    private final int totalHabitaciones;
    private final int ocupadas;
    private final int noOcupadas;
    private final int confirmadas;
    private final int vencidas;
    private final long ingresosEsperados;

    public Indicadores(int totalHabitaciones, int ocupadas, int noOcupadas,
            int confirmadas, int vencidas, long ingresosEsperados) {
        this.totalHabitaciones = totalHabitaciones;
        this.ocupadas = ocupadas;
        this.noOcupadas = noOcupadas;
        this.confirmadas = confirmadas;
        this.vencidas = vencidas;
        this.ingresosEsperados = ingresosEsperados;
    }

    public int getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public int getNoOcupadas() {
        return noOcupadas;
    }

    public int getConfirmadas() {
        return confirmadas;
    }

    public int getVencidas() {
        return vencidas;
    }

    public long getIngresosEsperados() {
        return ingresosEsperados;
    }
}
