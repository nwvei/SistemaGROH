/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;

final class TablaReservas {
    static final int COL_CODIGO = 0;
    static final int COL_ESTADO = 9;

    private TablaReservas() {
    }

    static void configurar(JTable tabla) {
        Estilo.estilizarTabla(tabla);
        Estilo.renderizarEstado(tabla, COL_ESTADO);
        Estilo.alinearDerecha(tabla, 8);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(170);
        tabla.getColumnModel().getColumn(COL_ESTADO).setPreferredWidth(95);
    }

    static void llenar(JTable tabla, List<Reserva> reservas) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for (Reserva reserva : reservas) {
            modelo.addRow(new Object[]{reserva.getCodigo(), reserva.getHuesped().getNombreCompleto(),
                reserva.getHabitacion().getNumero(), reserva.getPersonas(), Estilo.fecha(reserva.getFechaEntrada()),
                Estilo.fecha(reserva.getFechaSalida()), Estilo.fecha(reserva.getFechaSalidaReal()), reserva.getNoches(),
                Estilo.colones(reserva.getImporteTotal()), reserva.getEstado().toString(),
                reserva.getRecepcionista().getUsuario()});
        }
    }
}
