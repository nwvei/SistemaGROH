/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Excepciones.HotelException;
import controlador.ControladorHotel;
import modelo.EstadoReserva;
import modelo.Reserva;

public class PanelCheck extends javax.swing.JPanel implements Refrescable {
    private final ControladorHotel controlador = new ControladorHotel();

    public PanelCheck() {
        initComponents();
        TablaReservas.configurar(tblReservas);
        tblReservas.getSelectionModel().addListSelectionListener(e -> {
            int fila = tblReservas.getSelectedRow();
            if (!e.getValueIsAdjusting() && fila >= 0) {
                txtCodigo.setText(String.valueOf(tblReservas.getValueAt(fila, TablaReservas.COL_CODIGO)));
                buscar();
            }
        });
        refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        grpOperacion = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        pnlBusqueda = new javax.swing.JPanel();
        lblCodigoReserva = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlDetalle = new javax.swing.JPanel();
        lblHuesped = new javax.swing.JLabel();
        txtHuesped = new javax.swing.JTextField();
        lblHabitacion = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        lblEstadoActual = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblEntrada = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        lblSalida = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        lblSalidaReal = new javax.swing.JLabel();
        txtSalidaReal = new javax.swing.JTextField();
        rdoCheckIn = new javax.swing.JRadioButton();
        rdoCheckOut = new javax.swing.JRadioButton();
        btnProcesar = new javax.swing.JButton();
        scrTabla = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();

        setBackground(new java.awt.Color(244, 247, 252));

        lblTitulo.setText("Check-in / Check-out");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 44, 96));

        pnlBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        pnlBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Reserva ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblCodigoReserva.setText("Código de reserva:");
        lblCodigoReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodigoReserva.setForeground(new java.awt.Color(30, 41, 64));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));

        btnBuscar.setBackground(new java.awt.Color(21, 83, 163));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnBuscar.setOpaque(true);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Detalle de la reserva ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblHuesped.setText("Huésped:");
        lblHuesped.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHuesped.setForeground(new java.awt.Color(30, 41, 64));

        txtHuesped.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHuesped.setBackground(new java.awt.Color(236, 240, 246));
        txtHuesped.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtHuesped.setEditable(false);

        lblHabitacion.setText("Habitación:");
        lblHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHabitacion.setForeground(new java.awt.Color(30, 41, 64));

        txtHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHabitacion.setBackground(new java.awt.Color(236, 240, 246));
        txtHabitacion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtHabitacion.setEditable(false);

        lblEstadoActual.setText("Estado actual:");
        lblEstadoActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstadoActual.setForeground(new java.awt.Color(30, 41, 64));

        txtEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado.setBackground(new java.awt.Color(236, 240, 246));
        txtEstado.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtEstado.setEditable(false);

        lblEntrada.setText("Entrada programada:");
        lblEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(30, 41, 64));

        txtEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEntrada.setBackground(new java.awt.Color(236, 240, 246));
        txtEntrada.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtEntrada.setEditable(false);

        lblSalida.setText("Salida programada:");
        lblSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSalida.setForeground(new java.awt.Color(30, 41, 64));

        txtSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSalida.setBackground(new java.awt.Color(236, 240, 246));
        txtSalida.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtSalida.setEditable(false);

        lblSalidaReal.setText("Salida real:");
        lblSalidaReal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSalidaReal.setForeground(new java.awt.Color(30, 41, 64));

        txtSalidaReal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSalidaReal.setBackground(new java.awt.Color(236, 240, 246));
        txtSalidaReal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtSalidaReal.setEditable(false);

        grpOperacion.add(rdoCheckIn);
        rdoCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoCheckIn.setText("Realizar check-in (Confirmada → Hospedado)");
        rdoCheckIn.setOpaque(false);
        rdoCheckIn.setSelected(true);

        grpOperacion.add(rdoCheckOut);
        rdoCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoCheckOut.setText("Realizar check-out (Hospedado → Finalizada)");
        rdoCheckOut.setOpaque(false);

        btnProcesar.setBackground(new java.awt.Color(40, 150, 85));
        btnProcesar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProcesar.setForeground(new java.awt.Color(255, 255, 255));
        btnProcesar.setText("Procesar");
        btnProcesar.setBorderPainted(false);
        btnProcesar.setContentAreaFilled(false);
        btnProcesar.setFocusPainted(false);
        btnProcesar.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnProcesar.setOpaque(true);
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalidaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSalidaReal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(rdoCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(rdoCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalidaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalidaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        scrTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)));

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Código", "Huésped", "Habitación", "Personas", "Entrada", "Salida", "Salida real", "Noches", "Importe", "Estado", "Recepcionista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabla.setViewportView(tblReservas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        try {
            Reserva r = rdoCheckIn.isSelected() ? controlador.realizarCheckIn(txtCodigo.getText())
                    : controlador.realizarCheckOut(txtCodigo.getText());
            mostrar(r);
            refrescar();
            Dialogos.info(this, (rdoCheckIn.isSelected() ? "Check-in" : "Check-out") + " realizado. Reserva "
                    + r.getCodigo() + " ahora está " + r.getEstado() + ".");
        } catch (HotelException ex) {
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void buscar() {
        try {
            mostrar(controlador.buscarReserva(txtCodigo.getText()));
        } catch (HotelException ex) {
            mostrar(null);
            Dialogos.error(this, ex.getMessage());
        }
    }

    private void mostrar(Reserva r) {
        txtHuesped.setText(r == null ? "" : r.getHuesped().getNombreCompleto());
        txtHabitacion.setText(r == null ? "" : r.getHabitacion().toString());
        txtEntrada.setText(r == null ? "" : Estilo.fecha(r.getFechaEntrada()));
        txtSalida.setText(r == null ? "" : Estilo.fecha(r.getFechaSalida()));
        txtSalidaReal.setText(r == null ? "" : Estilo.fecha(r.getFechaSalidaReal()));
        txtEstado.setText(r == null ? "" : r.getEstado().toString());
        if (r != null) {
            (r.getEstado() == EstadoReserva.HOSPEDADO ? rdoCheckOut : rdoCheckIn).setSelected(true);
        }
    }

    @Override
    public void refrescar() {
        TablaReservas.llenar(tblReservas, controlador.listarReservas());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.ButtonGroup grpOperacion;
    private javax.swing.JLabel lblCodigoReserva;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblEstadoActual;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblHuesped;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JLabel lblSalidaReal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JRadioButton rdoCheckIn;
    private javax.swing.JRadioButton rdoCheckOut;
    private javax.swing.JScrollPane scrTabla;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtHuesped;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtSalidaReal;
    // End of variables declaration//GEN-END:variables
}
