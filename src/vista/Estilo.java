/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.EstadoReserva;

final class Estilo {
    static final Color AZUL = new Color(21, 83, 163);
    static final Color AZUL_CLARO = new Color(226, 238, 252);
    static final Color VERDE = new Color(40, 150, 85);
    static final Color VERDE_CLARO = new Color(220, 245, 228);
    static final Color ROJO = new Color(197, 48, 48);
    static final Color ROJO_CLARO = new Color(253, 228, 228);
    static final Color GRIS = new Color(108, 117, 134);
    static final Color TEXTO = new Color(30, 41, 64);

    static final Font FUENTE = new Font("Segoe UI", Font.PLAIN, 14);
    static final Font FUENTE_NEGRITA = new Font("Segoe UI", Font.BOLD, 14);

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Estilo() {
    }

    static String colones(long monto) {
        return "₡" + String.format("%,d", monto).replace(',', '.');
    }

    static String fecha(LocalDate fecha) {
        return fecha == null ? "—" : fecha.format(FORMATO_FECHA);
    }

    static void prepararFecha(JSpinner selector, LocalDate inicial) {
        selector.setModel(new SpinnerDateModel(aDate(inicial), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(selector, "dd/MM/yyyy");
        editor.getTextField().setFont(FUENTE);
        selector.setEditor(editor);
    }

    static LocalDate leerFecha(JSpinner selector) {
        if (!(selector.getValue() instanceof Date valor)) {
            return null;
        }
        return valor.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    static void escribirFecha(JSpinner selector, LocalDate fecha) {
        selector.setValue(aDate(fecha));
    }

    private static Date aDate(LocalDate f) {
        return Date.from(f.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    static void estilizarTabla(JTable tabla) {
        tabla.setFont(FUENTE);
        tabla.setRowHeight(28);
        tabla.setGridColor(new Color(228, 234, 244));
        tabla.setSelectionBackground(AZUL_CLARO);
        tabla.setSelectionForeground(TEXTO);
        tabla.setShowVerticalLines(false);
        tabla.setFillsViewportHeight(true);
        tabla.setAutoCreateRowSorter(true);
        JTableHeader h = tabla.getTableHeader();
        h.setFont(FUENTE_NEGRITA);
        h.setBackground(AZUL);
        h.setForeground(Color.WHITE);
        h.setReorderingAllowed(false);
        h.setPreferredSize(new Dimension(h.getPreferredSize().width, 32));
        DefaultTableCellRenderer cabecera = new DefaultTableCellRenderer();
        cabecera.setHorizontalAlignment(SwingConstants.LEFT);
        cabecera.setBackground(AZUL);
        cabecera.setForeground(Color.WHITE);
        cabecera.setFont(FUENTE_NEGRITA);
        cabecera.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        h.setDefaultRenderer(cabecera);
    }

    static void renderizarEstado(JTable tabla, int columna) {
        tabla.getColumnModel().getColumn(columna).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object valor, boolean sel,
                    boolean foco, int fila, int col) {
                JLabel l = (JLabel) super.getTableCellRendererComponent(t, valor, sel, foco, fila, col);
                l.setHorizontalAlignment(SwingConstants.CENTER);
                String s = String.valueOf(valor);
                Color fondo = Color.WHITE;
                Color letra = TEXTO;
                if (s.equals(EstadoReserva.CONFIRMADA.toString())) {
                    fondo = AZUL_CLARO;
                    letra = AZUL;
                } else if (s.equals(EstadoReserva.HOSPEDADO.toString())) {
                    fondo = VERDE_CLARO;
                    letra = VERDE;
                } else if (s.equals(EstadoReserva.VENCIDA.toString())) {
                    fondo = ROJO_CLARO;
                    letra = ROJO;
                } else if (s.equals(EstadoReserva.FINALIZADA.toString())) {
                    fondo = new Color(232, 234, 238);
                    letra = GRIS;
                }
                l.setBackground(fondo);
                l.setForeground(letra);
                l.setFont(FUENTE_NEGRITA);
                return l;
            }
        });
    }

    static void alinearDerecha(JTable tabla, int columna) {
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(columna).setCellRenderer(r);
    }
}
