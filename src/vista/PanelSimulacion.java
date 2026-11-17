/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Excepciones.HotelException;
import controlador.ControladorHotel;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoReserva;
import modelo.Reserva;

public class PanelSimulacion extends javax.swing.JPanel implements Refrescable {
    private final ControladorHotel controlador = new ControladorHotel();

    public PanelSimulacion() {
        initComponents();
        Estilo.prepararFecha(spnFecha, LocalDate.now().plusDays(3));
        Estilo.estilizarTabla(tblSimulacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        pnlFiltro = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        spnFecha = new javax.swing.JSpinner();
        btnSimular = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblResumen = new javax.swing.JLabel();
        scrTabla = new javax.swing.JScrollPane();
        tblSimulacion = new javax.swing.JTable();

        setBackground(new java.awt.Color(244, 247, 252));

        lblTitulo.setText("Simulación de vencimientos");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 44, 96));

        pnlFiltro.setBackground(new java.awt.Color(255, 255, 255));
        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Fecha de referencia ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblFecha.setText("Fecha de referencia:");
        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(30, 41, 64));

        spnFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSimular.setBackground(new java.awt.Color(21, 83, 163));
        btnSimular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimular.setForeground(new java.awt.Color(255, 255, 255));
        btnSimular.setText("Simular");
        btnSimular.setBorderPainted(false);
        btnSimular.setContentAreaFilled(false);
        btnSimular.setFocusPainted(false);
        btnSimular.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnSimular.setOpaque(true);
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        lblAviso.setBackground(new java.awt.Color(255, 243, 214));
        lblAviso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(130, 80, 0));
        lblAviso.setText("<html><b>Simulación informativa.</b> No modifica los estados reales de las reservas. Una reserva Confirmada vence a partir del día siguiente a su fecha de entrada.</html>");
        lblAviso.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 114, 0)), javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        lblAviso.setOpaque(true);

        lblResumen.setText(" ");
        lblResumen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResumen.setForeground(new java.awt.Color(30, 41, 64));

        scrTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)));

        tblSimulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Código", "Huésped", "Habitación", "Entrada", "Estado real", "Resultado en la fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabla.setViewportView(tblSimulacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        try {
            LocalDate referencia = Estilo.leerFecha(spnFecha);
            List<Reserva> resultado = controlador.simularVencimientos(referencia);
            DefaultTableModel modelo = (DefaultTableModel) tblSimulacion.getModel();
            modelo.setRowCount(0);
            for (Reserva reserva : resultado) {
                modelo.addRow(new Object[]{reserva.getCodigo(), reserva.getHuesped().getNombreCompleto(),
                    reserva.getHabitacion().getNumero(), Estilo.fecha(reserva.getFechaEntrada()), reserva.getEstado().toString(),
                    reserva.getEstado() == EstadoReserva.CONFIRMADA ? "Vencería" : "Ya vencida"});
            }
            lblResumen.setText(resultado.isEmpty()
                    ? "Ninguna reserva estaría vencida el " + Estilo.fecha(referencia) + "."
                    : resultado.size() + " reserva(s) estarían vencidas el " + Estilo.fecha(referencia) + ".");
        } catch (HotelException ex) {
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSimularActionPerformed

    @Override
    public void refrescar() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimular;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblResumen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JScrollPane scrTabla;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tblSimulacion;
    // End of variables declaration//GEN-END:variables
}
