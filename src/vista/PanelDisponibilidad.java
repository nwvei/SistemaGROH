/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Excepciones.HotelException;
import controlador.ControladorHotel;
import controlador.ResultadoDisponibilidad;
import java.time.LocalDate;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;

public class PanelDisponibilidad extends javax.swing.JPanel implements Refrescable {
    private final ControladorHotel controlador = new ControladorHotel();

    public PanelDisponibilidad() {
        initComponents();
        Estilo.prepararFecha(spnFecha, LocalDate.now());
        Estilo.estilizarTabla(tblDisponibles);
        Estilo.alinearDerecha(tblDisponibles, 3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        pnlFiltro = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        spnFecha = new javax.swing.JSpinner();
        btnConsultar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblNumeros = new javax.swing.JLabel();
        scrTabla = new javax.swing.JScrollPane();
        tblDisponibles = new javax.swing.JTable();

        setBackground(new java.awt.Color(244, 247, 252));

        lblTitulo.setText("Consulta de disponibilidad");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 44, 96));

        pnlFiltro.setBackground(new java.awt.Color(255, 255, 255));
        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Fecha de consulta ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblFecha.setText("Fecha:");
        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(30, 41, 64));

        spnFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnConsultar.setBackground(new java.awt.Color(21, 83, 163));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorderPainted(false);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setFocusPainted(false);
        btnConsultar.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnConsultar.setOpaque(true);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
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
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        lblTotal.setBackground(new java.awt.Color(220, 245, 228));
        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(40, 150, 85));
        lblTotal.setText("Seleccione una fecha y presione Consultar.");
        lblTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 14, 10, 14));
        lblTotal.setOpaque(true);

        lblNumeros.setText(" ");
        lblNumeros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumeros.setForeground(new java.awt.Color(30, 41, 64));

        scrTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)));

        tblDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Número", "Tipo", "Capacidad", "Tarifa por noche"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabla.setViewportView(tblDisponibles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(10, 10, 10)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            ResultadoDisponibilidad r = controlador.consultarDisponibilidad(Estilo.leerFecha(spnFecha));
            lblTotal.setText("Habitaciones disponibles el " + Estilo.fecha(r.fecha()) + ": " + r.total());
            lblNumeros.setText(r.habitaciones().isEmpty() ? "Sin habitaciones disponibles."
                    : "Habitaciones: " + r.habitaciones().stream().map(Habitacion::getNumero)
                            .collect(Collectors.joining(", ")));
            DefaultTableModel m = (DefaultTableModel) tblDisponibles.getModel();
            m.setRowCount(0);
            for (Habitacion h : r.habitaciones()) {
                m.addRow(new Object[]{h.getNumero(), h.getTipo(), h.getCapacidad(),
                    Estilo.colones(h.getTarifaPorNoche())});
            }
        } catch (HotelException ex) {
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    @Override
    public void refrescar() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumeros;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JScrollPane scrTabla;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tblDisponibles;
    // End of variables declaration//GEN-END:variables
}
