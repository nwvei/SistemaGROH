/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.TransicionNoPermitidaException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Aaron
 */
public final class Reserva {

    private final String codigo;
    private final Huesped huesped;
    private final Habitacion habitacion;
    private final int personas;
    private final LocalDate fechaEntrada;
    private final LocalDate fechaSalida;
    private final long noches;
    private final long importeTotal;
    private final Recepcionista recepcionista;

    private LocalDate fechaSalidaReal;
    private EstadoReserva estado;

    Reserva(String codigo, Huesped huesped, Habitacion habitacion, int personas,
            LocalDate fechaEntrada, LocalDate fechaSalida, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.personas = personas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.noches = calcularNoches(fechaEntrada, fechaSalida);
        this.importeTotal = noches * habitacion.getTarifaPorNoche();
        this.recepcionista = recepcionista;
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public static long calcularNoches(LocalDate entrada, LocalDate salida) {
        return ChronoUnit.DAYS.between(entrada, salida);
    }

    public String getCodigo() {
        return codigo;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getPersonas() {
        return personas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaSalidaReal() {
        return fechaSalidaReal;
    }

    public long getNoches() {
        return noches;
    }

    public long getImporteTotal() {
        return importeTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public boolean incluyeFecha(LocalDate fecha) {
        return !fecha.isBefore(fechaEntrada) && fecha.isBefore(fechaSalida);
    }

    public boolean seSolapaCon(LocalDate nuevaEntrada, LocalDate nuevaSalida) {
        return nuevaEntrada.isBefore(fechaSalida) && nuevaSalida.isAfter(fechaEntrada);
    }

    void cambiarEstado(EstadoReserva nuevo) throws TransicionNoPermitidaException {
        if (!estado.puedePasarA(nuevo)) {
            throw new TransicionNoPermitidaException(
                    "Transición no permitida: " + estado + " → " + nuevo + ".");
        }
        estado = nuevo;
    }

    void registrarSalidaReal(LocalDate fecha) {
        this.fechaSalidaReal = fecha;
    }

    @Override
    public String toString() {
        return codigo + " [" + estado + "]";
    }
}
