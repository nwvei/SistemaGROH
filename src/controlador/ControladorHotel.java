/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepciones.DatosInvalidosException;
import Excepciones.HotelException;
import java.time.LocalDate;
import java.util.List;
import modelo.GestorHotel;
import modelo.Habitacion;
import modelo.HabitacionFactory;
import modelo.Huesped;
import modelo.Indicadores;
import modelo.Recepcionista;
import modelo.Reserva;
import modelo.TipoHabitacion;

public class ControladorHotel {
    private final GestorHotel gestor = GestorHotel.getInstancia();

    public Recepcionista getRecepcionistaActivo() {
        return gestor.getRecepcionistaActivo();
    }

    public Huesped registrarHuesped(String identificacion, String nombre, String telefono,
            String correo) throws HotelException {
        return gestor.registrarHuesped(identificacion, nombre, telefono, correo);
    }

    public List<Huesped> listarHuespedes() {
        return gestor.listarHuespedes();
    }

    public Habitacion registrarHabitacion(String numero, TipoHabitacion tipo) throws HotelException {
        return gestor.registrarHabitacion(numero, tipo);
    }

    public List<Habitacion> listarHabitaciones() {
        return gestor.listarHabitaciones();
    }

    public TipoHabitacion[] getTiposHabitacion() {
        return TipoHabitacion.values();
    }

    public Habitacion vistaPreviaTipo(TipoHabitacion tipo) {
        return HabitacionFactory.crear("-", tipo);
    }

    public String proximoCodigoReserva() {
        return gestor.proximoCodigo();
    }

    public Reserva registrarReserva(String idHuesped, String numeroHabitacion, String personasTexto,
            LocalDate entrada, LocalDate salida) throws HotelException {
        int personas;
        try {
            personas = Integer.parseInt(personasTexto == null ? "" : personasTexto.trim());
        } catch (NumberFormatException ex) {
            throw new DatosInvalidosException("La cantidad de personas debe ser un número entero.");
        }
        return gestor.registrarReserva(idHuesped, numeroHabitacion, personas, entrada, salida);
    }

    public List<Reserva> listarReservas() {
        return gestor.listarReservas();
    }

    public long[] calcularNochesEImporte(Habitacion habitacion, LocalDate entrada, LocalDate salida) {
        long noches = Math.max(0, Reserva.calcularNoches(entrada, salida));
        long tarifa = habitacion == null ? 0L : habitacion.getTarifaPorNoche();
        return new long[]{noches, noches * tarifa};
    }

    public ResultadoDisponibilidad consultarDisponibilidad(LocalDate fecha) throws HotelException {
        if (fecha == null) {
            throw new DatosInvalidosException("Seleccione una fecha.");
        }
        return new ResultadoDisponibilidad(fecha, gestor.contarDisponibles(fecha),
                gestor.consultarDisponibles(fecha));
    }

    public Reserva buscarReserva(String codigo) throws HotelException {
        return gestor.buscarReserva(codigo);
    }

    public Reserva realizarCheckIn(String codigo) throws HotelException {
        return gestor.realizarCheckIn(codigo);
    }

    public Reserva realizarCheckOut(String codigo) throws HotelException {
        return gestor.realizarCheckOut(codigo);
    }

    public int revisarVencimientos() {
        return gestor.actualizarReservasVencidas(LocalDate.now());
    }

    public List<Reserva> simularVencimientos(LocalDate fechaReferencia) throws HotelException {
        if (fechaReferencia == null) {
            throw new DatosInvalidosException("Seleccione la fecha de referencia.");
        }
        return gestor.simularVencidas(fechaReferencia);
    }

    public Indicadores calcularIndicadores() {
        return gestor.calcularIndicadores();
    }

    public void cargarDatosDeEjemplo() throws HotelException {
        gestor.cargarDatosDemo(LocalDate.now());
    }
}
