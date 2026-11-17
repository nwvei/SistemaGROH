/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.CredencialesInvalidasException;
import Excepciones.DatosInvalidosException;
import Excepciones.HabitacionNoDisponibleException;
import Excepciones.HotelException;
import Excepciones.NoEncontradoException;
import Excepciones.RegistroDuplicadoException;
import Excepciones.SesionException;
import Excepciones.TransicionNoPermitidaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aaron
 */
public final class GestorHotel {

    private static final GestorHotel INSTANCIA = new GestorHotel();

    private final List<Recepcionista> recepcionistas = List.of(
            new Recepcionista("recepcion1", "Hotel123"),
            new Recepcionista("recepcion2", "Hotel456"));

    private final Map<String, Huesped> huespedes = new LinkedHashMap<>();
    private final Map<String, Habitacion> habitaciones = new LinkedHashMap<>();
    private final List<Reserva> reservas = new ArrayList<>();

    private Recepcionista activo;
    private int consecutivoReservas = 0;

    private GestorHotel() {
    }

    public static GestorHotel getInstancia() {
        return INSTANCIA;
    }


    public synchronized Recepcionista iniciarSesion(String usuario, String contrasena)
            throws HotelException {
        if (activo != null) {
            throw new SesionException("Ya existe una sesión activa (" + activo.getUsuario() + ").");
        }
        if (esVacio(usuario) || contrasena == null || contrasena.isEmpty()) {
            throw new CredencialesInvalidasException("Ingrese el usuario y la contraseña.");
        }
        for (Recepcionista r : recepcionistas) {
            if (r.validar(usuario.trim(), contrasena)) {
                activo = r;
                return r;
            }
        }
        throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
    }

    public synchronized void cerrarSesion() {
        activo = null;
    }

    public synchronized Recepcionista getRecepcionistaActivo() {
        return activo;
    }

    public synchronized Huesped registrarHuesped(String identificacion, String nombre,
            String telefono, String correo) throws HotelException {
        if (esVacio(identificacion) || esVacio(nombre) || esVacio(telefono) || esVacio(correo)) {
            throw new DatosInvalidosException("Todos los campos del huésped son obligatorios.");
        }
        identificacion = identificacion.trim();
        nombre = nombre.trim();
        telefono = telefono.trim();
        correo = correo.trim();
        if (!correoValido(correo)) {
            throw new DatosInvalidosException(
                    "Correo inválido: debe tener un único @, texto antes y un punto después de @.");
        }
        if (huespedes.containsKey(identificacion)) {
            throw new RegistroDuplicadoException(
                    "Ya existe un huésped con la identificación " + identificacion + ".");
        }
        Huesped h = new Huesped(identificacion, nombre, telefono, correo);
        huespedes.put(identificacion, h);
        return h;
    }

    public synchronized List<Huesped> listarHuespedes() {
        return new ArrayList<>(huespedes.values());
    }

    static boolean correoValido(String correo) {
        int arroba = correo.indexOf('@');
        if (arroba <= 0 || arroba != correo.lastIndexOf('@') || arroba == correo.length() - 1) {
            return false;
        }
        String dominio = correo.substring(arroba + 1);
        int punto = dominio.indexOf('.');
        return punto > 0 && !dominio.endsWith(".") && !correo.contains(" ");
    }

    public synchronized Habitacion registrarHabitacion(String numero, TipoHabitacion tipo)
            throws HotelException {
        if (esVacio(numero)) {
            throw new DatosInvalidosException("El número de habitación es obligatorio.");
        }
        if (tipo == null) {
            throw new DatosInvalidosException("Seleccione el tipo de habitación.");
        }
        numero = numero.trim();
        if (habitaciones.containsKey(numero)) {
            throw new RegistroDuplicadoException("La habitación " + numero + " ya existe.");
        }
        Habitacion h = HabitacionFactory.crear(numero, tipo);
        habitaciones.put(numero, h);
        return h;
    }

    public synchronized List<Habitacion> listarHabitaciones() {
        return new ArrayList<>(habitaciones.values());
    }

    public synchronized String proximoCodigo() {
        return String.format("R%04d", consecutivoReservas + 1);
    }

    public synchronized Reserva registrarReserva(String idHuesped, String numeroHabitacion,
            int personas, LocalDate entrada, LocalDate salida, LocalDate hoy) throws HotelException {
        if (activo == null) {
            throw new SesionException("Debe iniciar sesión para registrar reservas.");
        }
        Huesped huesped = huespedes.get(idHuesped == null ? "" : idHuesped.trim());
        if (huesped == null) {
            throw new NoEncontradoException("Seleccione un huésped registrado.");
        }
        Habitacion habitacion = habitaciones.get(numeroHabitacion == null ? "" : numeroHabitacion.trim());
        if (habitacion == null) {
            throw new NoEncontradoException("Seleccione una habitación registrada.");
        }
        if (entrada == null || salida == null) {
            throw new DatosInvalidosException("Las fechas de entrada y salida son obligatorias.");
        }
        if (entrada.isBefore(hoy)) {
            throw new DatosInvalidosException("La fecha de entrada no puede ser anterior a hoy.");
        }
        if (!salida.isAfter(entrada)) {
            throw new DatosInvalidosException("La fecha de salida debe ser posterior a la de entrada.");
        }
        if (personas <= 0) {
            throw new DatosInvalidosException("La cantidad de personas debe ser mayor que cero.");
        }
        if (personas > habitacion.getCapacidad()) {
            throw new DatosInvalidosException("La habitación " + habitacion.getNumero()
                    + " admite máximo " + habitacion.getCapacidad() + " persona(s).");
        }
        if (!Recursividad.estaDisponibleEnPeriodo(habitacion, reservas, entrada, salida)) {
            throw new HabitacionNoDisponibleException("La habitación " + habitacion.getNumero()
                    + " ya tiene una reserva Confirmada u Hospedado que se superpone con ese período.");
        }
        consecutivoReservas++;
        Reserva r = new Reserva(String.format("R%04d", consecutivoReservas), huesped, habitacion,
                personas, entrada, salida, activo);
        reservas.add(r);
        return r;
    }

    public synchronized Reserva registrarReserva(String idHuesped, String numeroHabitacion,
            int personas, LocalDate entrada, LocalDate salida) throws HotelException {
        return registrarReserva(idHuesped, numeroHabitacion, personas, entrada, salida, LocalDate.now());
    }

    public synchronized List<Reserva> listarReservas() {
        return new ArrayList<>(reservas);
    }

    public synchronized Reserva buscarReserva(String codigo) throws HotelException {
        if (esVacio(codigo)) {
            throw new DatosInvalidosException("Ingrese el código de la reserva.");
        }
        for (Reserva r : reservas) {
            if (r.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return r;
            }
        }
        throw new NoEncontradoException("No existe la reserva " + codigo.trim() + ".");
    }

    public synchronized List<Habitacion> consultarDisponibles(LocalDate fecha) {
        List<Habitacion> libres = new ArrayList<>();
        for (Habitacion h : habitaciones.values()) {
            if (Recursividad.estaDisponibleEnFecha(h, reservas, fecha)) {
                libres.add(h);
            }
        }
        return libres;
    }

    public synchronized int contarDisponibles(LocalDate fecha) {
        return Recursividad.contarHabitacionesDisponibles(
                new ArrayList<>(habitaciones.values()), reservas, fecha);
    }

    public synchronized Reserva realizarCheckIn(String codigo, LocalDate hoy) throws HotelException {
        Reserva r = buscarReserva(codigo);
        if (r.getEstado() != EstadoReserva.CONFIRMADA) {
            throw new TransicionNoPermitidaException("No se puede hacer check-in: la reserva está "
                    + r.getEstado() + ".");
        }
        if (!hoy.equals(r.getFechaEntrada())) {
            throw new DatosInvalidosException("El check-in solo se permite en la fecha de entrada ("
                    + r.getFechaEntrada() + ").");
        }
        r.cambiarEstado(EstadoReserva.HOSPEDADO);
        return r;
    }

    public synchronized Reserva realizarCheckIn(String codigo) throws HotelException {
        return realizarCheckIn(codigo, LocalDate.now());
    }

    public synchronized Reserva realizarCheckOut(String codigo, LocalDate hoy) throws HotelException {
        Reserva r = buscarReserva(codigo);
        if (r.getEstado() != EstadoReserva.HOSPEDADO) {
            throw new TransicionNoPermitidaException("No se puede hacer check-out: la reserva está "
                    + r.getEstado() + ".");
        }
        r.cambiarEstado(EstadoReserva.FINALIZADA);
        r.registrarSalidaReal(hoy);
        return r;
    }

    public synchronized Reserva realizarCheckOut(String codigo) throws HotelException {
        return realizarCheckOut(codigo, LocalDate.now());
    }

    public synchronized int actualizarReservasVencidas(LocalDate hoy) {
        int cambiadas = 0;
        for (Reserva r : reservas) {
            if (r.getEstado() == EstadoReserva.CONFIRMADA && r.getFechaEntrada().isBefore(hoy)) {
                try {
                    r.cambiarEstado(EstadoReserva.VENCIDA);
                    cambiadas++;
                } catch (TransicionNoPermitidaException ex) {
                    throw new IllegalStateException(ex); // Confirmada→Vencida siempre es válida
                }
            }
        }
        return cambiadas;
    }

    public synchronized List<Reserva> simularVencidas(LocalDate fechaReferencia) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            boolean yaVencida = r.getEstado() == EstadoReserva.VENCIDA;
            boolean vencera = r.getEstado() == EstadoReserva.CONFIRMADA
                    && r.getFechaEntrada().isBefore(fechaReferencia);
            if (yaVencida || vencera) {
                resultado.add(r);
            }
        }
        return resultado;
    }


    public synchronized Indicadores calcularIndicadores() {
        int ocupadas = 0;
        for (Habitacion h : habitaciones.values()) {
            if (tieneHuespedAlojado(h)) {
                ocupadas++;
            }
        }
        int confirmadas = 0;
        int vencidas = 0;
        for (Reserva r : reservas) {
            if (r.getEstado() == EstadoReserva.CONFIRMADA) {
                confirmadas++;
            } else if (r.getEstado() == EstadoReserva.VENCIDA) {
                vencidas++;
            }
        }
        int total = habitaciones.size();
        return new Indicadores(total, ocupadas, total - ocupadas, confirmadas, vencidas,
                Recursividad.calcularIngresosEsperados(reservas));
    }

    private boolean tieneHuespedAlojado(Habitacion h) {
        for (Reserva r : reservas) {
            if (r.getEstado() == EstadoReserva.HOSPEDADO
                    && r.getHabitacion().getNumero().equals(h.getNumero())) {
                return true;
            }
        }
        return false;
    }


    public synchronized void cargarDatosDemo(LocalDate hoy) throws HotelException {
        if (!huespedes.isEmpty() || !habitaciones.isEmpty() || !reservas.isEmpty()) {
            throw new DatosInvalidosException("Los datos de ejemplo solo se cargan con el sistema vacío.");
        }
        if (activo == null) {
            throw new SesionException("Debe iniciar sesión.");
        }
        registrarHuesped("118260123", "Ana Torres Jiménez", "8888-1122", "ana.torres@correo.com");
        registrarHuesped("118260456", "Carlos Vega Mora", "8999-3344", "cvega@correo.com");
        registrarHuesped("305550789", "Luis Soto Rojas", "7001-0099", "luis.soto@correo.com");
        registrarHuesped("402220321", "Marta Ríos Campos", "6123-4455", "marta.rios@correo.com");
        String[][] cuartos = {{"101", "D"}, {"102", "I"}, {"103", "F"}, {"104", "D"}, {"105", "I"},
            {"201", "D"}, {"202", "F"}, {"203", "I"}};
        for (String[] c : cuartos) {
            TipoHabitacion t = switch (c[1]) {
                case "I" -> TipoHabitacion.INDIVIDUAL;
                case "D" -> TipoHabitacion.DOBLE;
                default -> TipoHabitacion.FAMILIAR;
            };
            registrarHabitacion(c[0], t);
        }
      
        registrarReserva("118260123", "101", 2, hoy.plusDays(3), hoy.plusDays(5), hoy);
        registrarReserva("118260456", "102", 1, hoy, hoy.plusDays(2), hoy);
        agregarHistorica("305550789", "103", 3, hoy.minusDays(1), hoy.plusDays(2), EstadoReserva.HOSPEDADO, null);
        agregarHistorica("402220321", "104", 2, hoy.minusDays(3), hoy.minusDays(1), EstadoReserva.CONFIRMADA, null);
        agregarHistorica("118260123", "105", 1, hoy.minusDays(6), hoy.minusDays(4), EstadoReserva.HOSPEDADO,
                hoy.minusDays(4));
    }

   
    private void agregarHistorica(String idHuesped, String numero, int personas, LocalDate entrada,
            LocalDate salida, EstadoReserva destino, LocalDate salidaReal) throws HotelException {
        consecutivoReservas++;
        Reserva r = new Reserva(String.format("R%04d", consecutivoReservas), huespedes.get(idHuesped),
                habitaciones.get(numero), personas, entrada, salida, activo);
        if (destino == EstadoReserva.HOSPEDADO) {
            r.cambiarEstado(EstadoReserva.HOSPEDADO);
            if (salidaReal != null) {
                r.cambiarEstado(EstadoReserva.FINALIZADA);
                r.registrarSalidaReal(salidaReal);
            }
        }
        reservas.add(r);
    }

    private static boolean esVacio(String texto) {
        return texto == null || texto.isBlank();
    }
}
