/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.EstadoReserva;

/**
 *
 * @author Aaron
 */
class RenderizadorEstado extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tablaCelda, Object valor, boolean seleccionada,
            boolean foco, int fila, int col) {
        JLabel etiqueta = (JLabel) super.getTableCellRendererComponent(tablaCelda, valor, seleccionada, foco, fila, col);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        String texto = String.valueOf(valor);
        Color fondo = Color.WHITE;
        Color letra = Estilo.TEXTO;
        if (texto.equals(EstadoReserva.CONFIRMADA.toString())) {
            fondo = Estilo.AZUL_CLARO;
            letra = Estilo.AZUL;
        } else if (texto.equals(EstadoReserva.HOSPEDADO.toString())) {
            fondo = Estilo.VERDE_CLARO;
            letra = Estilo.VERDE;
        } else if (texto.equals(EstadoReserva.VENCIDA.toString())) {
            fondo = Estilo.ROJO_CLARO;
            letra = Estilo.ROJO;
        } else if (texto.equals(EstadoReserva.FINALIZADA.toString())) {
            fondo = new Color(232, 234, 238);
            letra = Estilo.GRIS;
        }
        etiqueta.setBackground(fondo);
        etiqueta.setForeground(letra);
        etiqueta.setFont(Estilo.FUENTE_NEGRITA);
        return etiqueta;
    }
}
