/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Excepciones.HotelException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.EstadoReserva;
import modelo.GestorHotel;
import modelo.Habitacion;
import modelo.HabitacionFactory;
import modelo.Indicadores;
import modelo.Recursividad;
import modelo.Reserva;
import modelo.TipoHabitacion;

/**
 *
 * @author Aaron
 */
public class PruebasHotel {

    private static int ok = 0;
    private static int fallos = 0;

    public static void main(String[] args) throws Exception {
        GestorHotel gestor = GestorHotel.getInstancia();
        LocalDate hoy = LocalDate.now();

        System.out.println("== Sesión ==");
        try {
            gestor.iniciarSesion("recepcion1", "mala");
            marcar("login inválido" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("login inválido" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("1", "101", 1, hoy, hoy.plusDays(1));
            marcar("reserva sin sesión" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("reserva sin sesión" + " → \"" + ex.getMessage() + "\"", true);
        }
        verdad("login recepcion1", "recepcion1".equals(gestor.iniciarSesion("recepcion1", "Hotel123").getUsuario()));
        try {
            gestor.iniciarSesion("recepcion2", "Hotel456");
            marcar("segunda sesión simultánea" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("segunda sesión simultánea" + " → \"" + ex.getMessage() + "\"", true);
        }

        System.out.println("== Huéspedes ==");
        gestor.agregarHuesped("1", "Ana Torres", "0888-1122", "ana@correo.com");
        igual("teléfono conserva ceros", "0888-1122", gestor.listarHuespedes().get(0).getTelefono());
        try {
            gestor.agregarHuesped("1", "Otro", "1", "o@o.com");
            marcar("identificación duplicada" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("identificación duplicada" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarHuesped("2", "   ", "1", "o@o.com");
            marcar("campo en blanco" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("campo en blanco" + " → \"" + ex.getMessage() + "\"", true);
        }
        for (String malo : new String[]{"sinarroba", "a@@b.com", "@b.com", "a@", "a@sinpunto", "a@b."}) {
            try {
                gestor.agregarHuesped("9", "X", "1", malo);
                marcar("correo inválido " + malo + " (debía fallar)", false);
            } catch (HotelException ex) {
                marcar("correo inválido " + malo + " → \"" + ex.getMessage() + "\"", true);
            }
        }
        gestor.agregarHuesped("2", "Luis Soto", "7000", "luis@x.co");

        System.out.println("== Habitaciones / Factory / polimorfismo ==");
        Habitacion individual = gestor.agregarHabitacion("101", TipoHabitacion.INDIVIDUAL);
        Habitacion doble = gestor.agregarHabitacion("102", TipoHabitacion.DOBLE);
        Habitacion familiar = gestor.agregarHabitacion("103", TipoHabitacion.FAMILIAR);
        igual("individual", 1 + "/" + 25000, individual.getCapacidad() + "/" + individual.getTarifaPorNoche());
        igual("doble", 2 + "/" + 40000, doble.getCapacidad() + "/" + doble.getTarifaPorNoche());
        igual("familiar", 4 + "/" + 65000, familiar.getCapacidad() + "/" + familiar.getTarifaPorNoche());
        try {
            gestor.agregarHabitacion("101", TipoHabitacion.DOBLE);
            marcar("habitación duplicada" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("habitación duplicada" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarHabitacion(" ", TipoHabitacion.DOBLE);
            marcar("número vacío" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("número vacío" + " → \"" + ex.getMessage() + "\"", true);
        }
        verdad("factory crea subclase correcta",
                HabitacionFactory.crear("X", TipoHabitacion.DOBLE).getClass().getSimpleName().equals("HabitacionDoble"));

        System.out.println("== Reservas ==");
        Reserva r1 = gestor.agregarReserva("1", "102", 2, hoy.plusDays(2), hoy.plusDays(5));
        igual("código", "R0001", r1.getCodigo());
        igual("noches", 3L, r1.getNoches());
        igual("importe", 120000L, r1.getImporteTotal());
        verdad("estado inicial Confirmada", r1.getEstado() == EstadoReserva.CONFIRMADA);
        verdad("recepcionista registrado", "recepcion1".equals(r1.getRecepcionista().getUsuario()));
        try {
            gestor.agregarReserva("2", "102", 1, hoy.plusDays(4), hoy.plusDays(7));
            marcar("superpuesta" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("superpuesta" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("2", "102", 1, hoy.plusDays(1), hoy.plusDays(9));
            marcar("superpuesta englobada" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("superpuesta englobada" + " → \"" + ex.getMessage() + "\"", true);
        }
        gestor.agregarReserva("2", "102", 1, hoy.plusDays(5), hoy.plusDays(6)); 
        gestor.agregarReserva("2", "102", 1, hoy.plusDays(1), hoy.plusDays(2)); 
        try {
            gestor.agregarReserva("1", "101", 2, hoy, hoy.plusDays(1));
            marcar("capacidad excedida" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("capacidad excedida" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("1", "101", 0, hoy, hoy.plusDays(1));
            marcar("personas cero" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("personas cero" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("1", "101", 1, hoy.minusDays(1), hoy.plusDays(1));
            marcar("entrada pasada" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("entrada pasada" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("1", "101", 1, hoy, hoy);
            marcar("salida no posterior" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("salida no posterior" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.agregarReserva("zz", "101", 1, hoy, hoy.plusDays(1));
            marcar("huésped inexistente" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("huésped inexistente" + " → \"" + ex.getMessage() + "\"", true);
        }

        System.out.println("== Disponibilidad ==");
        verdad("102 bloqueada día de entrada", !gestor.buscarHabitacionesDisponibles(hoy.plusDays(2)).contains(doble));
        verdad("102 libre día de salida", gestor.buscarHabitacionesDisponibles(hoy.plusDays(6)).contains(doble));
        igual("conteo recursivo = lista", gestor.buscarHabitacionesDisponibles(hoy.plusDays(3)).size(), gestor.contarDisponibles(hoy.plusDays(3)));
        int antes = gestor.listarReservas().size();
        gestor.buscarHabitacionesDisponibles(hoy);
        igual("consulta no modifica", antes, gestor.listarReservas().size());

        System.out.println("== Check-in / check-out ==");
        Reserva hoyRes = gestor.agregarReserva("1", "101", 1, hoy, hoy.plusDays(2));
        try {
            gestor.realizarCheckIn(r1.getCodigo());
            marcar("check-in fuera de fecha" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("check-in fuera de fecha" + " → \"" + ex.getMessage() + "\"", true);
        }
        gestor.realizarCheckIn(hoyRes.getCodigo());
        verdad("Hospedado", hoyRes.getEstado() == EstadoReserva.HOSPEDADO);
        try {
            gestor.realizarCheckIn(hoyRes.getCodigo());
            marcar("check-in repetido" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("check-in repetido" + " → \"" + ex.getMessage() + "\"", true);
        }
        try {
            gestor.realizarCheckOut(r1.getCodigo());
            marcar("check-out sin check-in" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("check-out sin check-in" + " → \"" + ex.getMessage() + "\"", true);
        }
        Indicadores ind = gestor.calcularIndicadores();
        igual("ocupadas", 1, ind.getOcupadas());
        gestor.realizarCheckOut(hoyRes.getCodigo());
        verdad("Finalizada", hoyRes.getEstado() == EstadoReserva.FINALIZADA);
        igual("fecha salida real", hoy, hoyRes.getFechaSalidaReal());
        igual("importe intacto", 50000L, hoyRes.getImporteTotal());
        try {
            gestor.realizarCheckOut(hoyRes.getCodigo());
            marcar("check-out repetido" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("check-out repetido" + " → \"" + ex.getMessage() + "\"", true);
        }
        verdad("Finalizada libera disponibilidad", Recursividad.estaDisponibleEnPeriodo(individual, gestor.listarReservas(), hoy, hoy.plusDays(2)));

        System.out.println("== Vencimientos ==");
        List<Reserva> sim = gestor.simularVencidas(hoy.plusDays(10));
        igual("simulación detecta confirmadas", 3, sim.size());
        verdad("simulación no cambia estado", r1.getEstado() == EstadoReserva.CONFIRMADA);
        igual("supervisión real hoy: nada vence", 0, gestor.actualizarReservasVencidas(hoy));
        igual("supervisión real futura vence 3", 3, gestor.actualizarReservasVencidas(hoy.plusDays(10)));
        verdad("Vencida", r1.getEstado() == EstadoReserva.VENCIDA);
        verdad("Vencida libera disponibilidad", gestor.buscarHabitacionesDisponibles(hoy.plusDays(3)).contains(doble));
        try {
            gestor.realizarCheckIn(r1.getCodigo());
            marcar("Vencida no puede check-in" + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar("Vencida no puede check-in" + " → \"" + ex.getMessage() + "\"", true);
        }

        System.out.println("== Recursividad (0, 1 y varios elementos) ==");
        igual("ingresos vacío", 0L, Recursividad.calcularIngresosEsperados(new ArrayList<>()));
        igual("disponibles vacío", 0, Recursividad.contarHabitacionesDisponibles(new ArrayList<>(), new ArrayList<>(), hoy));
        pruebaEjemplos(hoy);

        System.out.println("== Cambio de usuario conserva datos ==");
        gestor.cerrarSesion();
        verdad("sin sesión", gestor.getRecepcionistaActivo() == null);
        gestor.iniciarSesion("recepcion2", "Hotel456");
        igual("huéspedes persisten", 2, gestor.listarHuespedes().size());
        igual("reservas persisten", antes + 1, gestor.listarReservas().size());

        System.out.println("\nResultado: " + ok + " correctas, " + fallos + " fallidas.");
        if (fallos > 0) {
            System.exit(1);
        }
    }

    private static void pruebaEjemplos(LocalDate hoy) throws HotelException {
        GestorHotel gestor = GestorHotel.getInstancia();
        List<Reserva> todas = gestor.listarReservas();
        List<Reserva> una = new ArrayList<>(todas.subList(0, 1));
        long esperadaUna = una.get(0).getEstado() == EstadoReserva.CONFIRMADA ? una.get(0).getImporteTotal() : 0;
        igual("ingresos un elemento", esperadaUna, Recursividad.calcularIngresosEsperados(una));
        long manual = 0;
        for (Reserva reserva : todas) {
            if (reserva.getEstado() == EstadoReserva.CONFIRMADA) {
                manual += reserva.getImporteTotal();
            }
        }
        igual("ingresos varios == suma manual", manual, Recursividad.calcularIngresosEsperados(todas));
        igual("un elemento disponible", 1, Recursividad.contarHabitacionesDisponibles(
                new ArrayList<>(gestor.listarHabitaciones().subList(0, 1)), new ArrayList<>(), hoy));
    }


    private static void verdad(String nombre, boolean condicion) {
        marcar(nombre, condicion);
    }

    private static void igual(String nombre, Object esperado, Object real) {
        boolean bien = esperado.equals(real);
        marcar(bien ? nombre : nombre + " (esperado " + esperado + ", real " + real + ")", bien);
    }

    private static void marcar(String texto, boolean bien) {
        if (bien) {
            ok++;
        } else {
            fallos++;
        }
        System.out.println((bien ? "  OK    " : "  FALLA ") + texto);
    }
}
