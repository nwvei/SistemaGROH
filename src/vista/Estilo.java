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

    private Estilo() {
    }

    static String colones(long monto) {
        String digitos = String.valueOf(monto);
        String resultado = "";
        int contador = 0;
        for (int i = digitos.length() - 1; i >= 0; i--) {
            resultado = digitos.charAt(i) + resultado;
            contador++;
            if (contador % 3 == 0 && i > 0 && digitos.charAt(i - 1) != '-') {
                resultado = "." + resultado;
            }
        }
        return "₡" + resultado;
    }

    static String fecha(LocalDate fecha) {
        if (fecha == null) {
            return "—";
        }
        return dosDigitos(fecha.getDayOfMonth()) + "/" + dosDigitos(fecha.getMonthValue()) + "/" + fecha.getYear();
    }

    private static String dosDigitos(int numero) {
        if (numero < 10) {
            return "0" + numero;
        }
        return String.valueOf(numero);
    }

    static void prepararFecha(JSpinner selector, LocalDate inicial) {
        selector.setModel(new SpinnerDateModel(aDate(inicial), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(selector, "dd/MM/yyyy");
        editor.getTextField().setFont(FUENTE);
        selector.setEditor(editor);
    }

    static LocalDate leerFecha(JSpinner selector) {
        Object contenido = selector.getValue();
        if (!(contenido instanceof Date)) {
            return null;
        }
        Date valor = (Date) contenido;
        return valor.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    static void escribirFecha(JSpinner selector, LocalDate fecha) {
        selector.setValue(aDate(fecha));
    }

    private static Date aDate(LocalDate fecha) {
        return Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
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
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setFont(FUENTE_NEGRITA);
        encabezado.setBackground(AZUL);
        encabezado.setForeground(Color.WHITE);
        encabezado.setReorderingAllowed(false);
        encabezado.setPreferredSize(new Dimension(encabezado.getPreferredSize().width, 32));
        DefaultTableCellRenderer cabecera = new DefaultTableCellRenderer();
        cabecera.setHorizontalAlignment(SwingConstants.LEFT);
        cabecera.setBackground(AZUL);
        cabecera.setForeground(Color.WHITE);
        cabecera.setFont(FUENTE_NEGRITA);
        cabecera.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        encabezado.setDefaultRenderer(cabecera);
    }

    static void renderizarEstado(JTable tabla, int columna) {
        tabla.getColumnModel().getColumn(columna).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tablaCelda, Object valor, boolean seleccionada,
                    boolean foco, int fila, int col) {
                JLabel etiqueta = (JLabel) super.getTableCellRendererComponent(tablaCelda, valor, seleccionada, foco, fila, col);
                etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                String texto = String.valueOf(valor);
                Color fondo = Color.WHITE;
                Color letra = TEXTO;
                if (texto.equals(EstadoReserva.CONFIRMADA.toString())) {
                    fondo = AZUL_CLARO;
                    letra = AZUL;
                } else if (texto.equals(EstadoReserva.HOSPEDADO.toString())) {
                    fondo = VERDE_CLARO;
                    letra = VERDE;
                } else if (texto.equals(EstadoReserva.VENCIDA.toString())) {
                    fondo = ROJO_CLARO;
                    letra = ROJO;
                } else if (texto.equals(EstadoReserva.FINALIZADA.toString())) {
                    fondo = new Color(232, 234, 238);
                    letra = GRIS;
                }
                etiqueta.setBackground(fondo);
                etiqueta.setForeground(letra);
                etiqueta.setFont(FUENTE_NEGRITA);
                return etiqueta;
            }
        });
    }

    static void alinearDerecha(JTable tabla, int columna) {
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();
        renderizador.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(columna).setCellRenderer(renderizador);
    }
}
