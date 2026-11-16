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
        DefaultTableModel m = (DefaultTableModel) tabla.getModel();
        m.setRowCount(0);
        for (Reserva r : reservas) {
            m.addRow(new Object[]{r.getCodigo(), r.getHuesped().getNombreCompleto(),
                r.getHabitacion().getNumero(), r.getPersonas(), Estilo.fecha(r.getFechaEntrada()),
                Estilo.fecha(r.getFechaSalida()), Estilo.fecha(r.getFechaSalidaReal()), r.getNoches(),
                Estilo.colones(r.getImporteTotal()), r.getEstado().toString(),
                r.getRecepcionista().getUsuario()});
        }
    }
}
