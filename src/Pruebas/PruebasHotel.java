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
        GestorHotel g = GestorHotel.getInstancia();
        LocalDate hoy = LocalDate.now();

        System.out.println("== Sesión ==");
        esperaError("login inválido", () -> g.iniciarSesion("recepcion1", "mala"));
        esperaError("reserva sin sesión", () -> g.registrarReserva("1", "101", 1, hoy, hoy.plusDays(1)));
        verdad("login recepcion1", "recepcion1".equals(g.iniciarSesion("recepcion1", "Hotel123").getUsuario()));
        esperaError("segunda sesión simultánea", () -> g.iniciarSesion("recepcion2", "Hotel456"));

        System.out.println("== Huéspedes ==");
        g.registrarHuesped("1", "Ana Torres", "0888-1122", "ana@correo.com");
        igual("teléfono conserva ceros", "0888-1122", g.listarHuespedes().get(0).getTelefono());
        esperaError("identificación duplicada", () -> g.registrarHuesped("1", "Otro", "1", "o@o.com"));
        esperaError("campo en blanco", () -> g.registrarHuesped("2", "   ", "1", "o@o.com"));
        for (String malo : new String[]{"sinarroba", "a@@b.com", "@b.com", "a@", "a@sinpunto", "a@b."}) {
            esperaError("correo inválido " + malo, () -> g.registrarHuesped("9", "X", "1", malo));
        }
        g.registrarHuesped("2", "Luis Soto", "7000", "luis@x.co");

        System.out.println("== Habitaciones / Factory / polimorfismo ==");
        Habitacion i = g.registrarHabitacion("101", TipoHabitacion.INDIVIDUAL);
        Habitacion d = g.registrarHabitacion("102", TipoHabitacion.DOBLE);
        Habitacion f = g.registrarHabitacion("103", TipoHabitacion.FAMILIAR);
        igual("individual", 1 + "/" + 25000, i.getCapacidad() + "/" + i.getTarifaPorNoche());
        igual("doble", 2 + "/" + 40000, d.getCapacidad() + "/" + d.getTarifaPorNoche());
        igual("familiar", 4 + "/" + 65000, f.getCapacidad() + "/" + f.getTarifaPorNoche());
        esperaError("habitación duplicada", () -> g.registrarHabitacion("101", TipoHabitacion.DOBLE));
        esperaError("número vacío", () -> g.registrarHabitacion(" ", TipoHabitacion.DOBLE));
        verdad("factory crea subclase correcta",
                HabitacionFactory.crear("X", TipoHabitacion.DOBLE).getClass().getSimpleName().equals("HabitacionDoble"));

        System.out.println("== Reservas ==");
        Reserva r1 = g.registrarReserva("1", "102", 2, hoy.plusDays(2), hoy.plusDays(5));
        igual("código", "R0001", r1.getCodigo());
        igual("noches", 3L, r1.getNoches());
        igual("importe", 120000L, r1.getImporteTotal());
        verdad("estado inicial Confirmada", r1.getEstado() == EstadoReserva.CONFIRMADA);
        verdad("recepcionista registrado", "recepcion1".equals(r1.getRecepcionista().getUsuario()));
        esperaError("superpuesta", () -> g.registrarReserva("2", "102", 1, hoy.plusDays(4), hoy.plusDays(7)));
        esperaError("superpuesta englobada", () -> g.registrarReserva("2", "102", 1, hoy.plusDays(1), hoy.plusDays(9)));
        g.registrarReserva("2", "102", 1, hoy.plusDays(5), hoy.plusDays(6)); 
        g.registrarReserva("2", "102", 1, hoy.plusDays(1), hoy.plusDays(2)); 
        esperaError("capacidad excedida", () -> g.registrarReserva("1", "101", 2, hoy, hoy.plusDays(1)));
        esperaError("personas cero", () -> g.registrarReserva("1", "101", 0, hoy, hoy.plusDays(1)));
        esperaError("entrada pasada", () -> g.registrarReserva("1", "101", 1, hoy.minusDays(1), hoy.plusDays(1)));
        esperaError("salida no posterior", () -> g.registrarReserva("1", "101", 1, hoy, hoy));
        esperaError("huésped inexistente", () -> g.registrarReserva("zz", "101", 1, hoy, hoy.plusDays(1)));

        System.out.println("== Disponibilidad ==");
        verdad("102 bloqueada día de entrada", !g.consultarDisponibles(hoy.plusDays(2)).contains(d));
        verdad("102 libre día de salida", g.consultarDisponibles(hoy.plusDays(6)).contains(d));
        igual("conteo recursivo = lista", g.consultarDisponibles(hoy.plusDays(3)).size(), g.contarDisponibles(hoy.plusDays(3)));
        int antes = g.listarReservas().size();
        g.consultarDisponibles(hoy);
        igual("consulta no modifica", antes, g.listarReservas().size());

        System.out.println("== Check-in / check-out ==");
        Reserva hoyRes = g.registrarReserva("1", "101", 1, hoy, hoy.plusDays(2));
        esperaError("check-in fuera de fecha", () -> g.realizarCheckIn(r1.getCodigo()));
        g.realizarCheckIn(hoyRes.getCodigo());
        verdad("Hospedado", hoyRes.getEstado() == EstadoReserva.HOSPEDADO);
        esperaError("check-in repetido", () -> g.realizarCheckIn(hoyRes.getCodigo()));
        esperaError("check-out sin check-in", () -> g.realizarCheckOut(r1.getCodigo()));
        Indicadores ind = g.calcularIndicadores();
        igual("ocupadas", 1, ind.ocupadas());
        g.realizarCheckOut(hoyRes.getCodigo());
        verdad("Finalizada", hoyRes.getEstado() == EstadoReserva.FINALIZADA);
        igual("fecha salida real", hoy, hoyRes.getFechaSalidaReal());
        igual("importe intacto", 50000L, hoyRes.getImporteTotal());
        esperaError("check-out repetido", () -> g.realizarCheckOut(hoyRes.getCodigo()));
        verdad("Finalizada libera disponibilidad", Recursividad.estaDisponibleEnPeriodo(i, g.listarReservas(), hoy, hoy.plusDays(2)));

        System.out.println("== Vencimientos ==");
        List<Reserva> sim = g.simularVencidas(hoy.plusDays(10));
        igual("simulación detecta confirmadas", 3, sim.size());
        verdad("simulación no cambia estado", r1.getEstado() == EstadoReserva.CONFIRMADA);
        igual("supervisión real hoy: nada vence", 0, g.actualizarReservasVencidas(hoy));
        igual("supervisión real futura vence 3", 3, g.actualizarReservasVencidas(hoy.plusDays(10)));
        verdad("Vencida", r1.getEstado() == EstadoReserva.VENCIDA);
        verdad("Vencida libera disponibilidad", g.consultarDisponibles(hoy.plusDays(3)).contains(d));
        esperaError("Vencida no puede check-in", () -> g.realizarCheckIn(r1.getCodigo()));

        System.out.println("== Recursividad (0, 1 y varios elementos) ==");
        igual("ingresos vacío", 0L, Recursividad.calcularIngresosEsperados(new ArrayList<>()));
        igual("disponibles vacío", 0, Recursividad.contarHabitacionesDisponibles(new ArrayList<>(), new ArrayList<>(), hoy));
        pruebaEjemplos(hoy);

        System.out.println("== Cambio de usuario conserva datos ==");
        g.cerrarSesion();
        verdad("sin sesión", g.getRecepcionistaActivo() == null);
        g.iniciarSesion("recepcion2", "Hotel456");
        igual("huéspedes persisten", 2, g.listarHuespedes().size());
        igual("reservas persisten", antes + 1, g.listarReservas().size());

        System.out.println("\nResultado: " + ok + " correctas, " + fallos + " fallidas.");
        if (fallos > 0) {
            System.exit(1);
        }
    }

    private static void pruebaEjemplos(LocalDate hoy) throws HotelException {
        GestorHotel g = GestorHotel.getInstancia();
        List<Reserva> todas = g.listarReservas();
        List<Reserva> una = new ArrayList<>(todas.subList(0, 1));
        long esperadaUna = una.get(0).getEstado() == EstadoReserva.CONFIRMADA ? una.get(0).getImporteTotal() : 0;
        igual("ingresos un elemento", esperadaUna, Recursividad.calcularIngresosEsperados(una));
        long manual = 0;
        for (Reserva r : todas) {
            if (r.getEstado() == EstadoReserva.CONFIRMADA) {
                manual += r.getImporteTotal();
            }
        }
        igual("ingresos varios == suma manual", manual, Recursividad.calcularIngresosEsperados(todas));
        igual("un elemento disponible", 1, Recursividad.contarHabitacionesDisponibles(
                new ArrayList<>(g.listarHabitaciones().subList(0, 1)), new ArrayList<>(), hoy));
    }


    private interface Accion {
        void ejecutar() throws Exception;
    }

    private static void esperaError(String nombre, Accion accion) {
        try {
            accion.ejecutar();
            marcar(nombre + " (debía fallar)", false);
        } catch (HotelException ex) {
            marcar(nombre + " → \"" + ex.getMessage() + "\"", true);
        } catch (Exception ex) {
            marcar(nombre + " lanzó " + ex, false);
        }
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
