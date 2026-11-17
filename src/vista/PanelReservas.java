/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Excepciones.HotelException;
import controlador.ControladorHotel;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.EstadoReserva;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Reserva;

public class PanelReservas extends javax.swing.JPanel implements Refrescable {
    private final ControladorHotel controlador = new ControladorHotel();

    public PanelReservas() {
        initComponents();
        Estilo.prepararFecha(spnEntrada, LocalDate.now());
        Estilo.prepararFecha(spnSalida, LocalDate.now().plusDays(1));
        txtEstado.setText(EstadoReserva.CONFIRMADA.toString());
        TablaReservas.configurar(tblReservas);
        refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        pnlFormulario = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblHuesped = new javax.swing.JLabel();
        cmbHuesped = new javax.swing.JComboBox<>();
        lblHabitacion = new javax.swing.JLabel();
        cmbHabitacion = new javax.swing.JComboBox<>();
        lblPersonas = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        lblRecepcionista = new javax.swing.JLabel();
        txtRecepcionista = new javax.swing.JTextField();
        lblEntrada = new javax.swing.JLabel();
        spnEntrada = new javax.swing.JSpinner();
        lblSalida = new javax.swing.JLabel();
        spnSalida = new javax.swing.JSpinner();
        lblNoches = new javax.swing.JLabel();
        txtNoches = new javax.swing.JTextField();
        lblImporte = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        lblEstadoReserva = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrTabla = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();

        setBackground(new java.awt.Color(244, 247, 252));

        lblTitulo.setText("Registro de reservas");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(12, 44, 96));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Datos de la reserva ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblCodigo.setText("Código:");
        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(30, 41, 64));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setBackground(new java.awt.Color(236, 240, 246));
        txtCodigo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtCodigo.setEditable(false);

        lblHuesped.setText("Huésped:");
        lblHuesped.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHuesped.setForeground(new java.awt.Color(30, 41, 64));

        cmbHuesped.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblHabitacion.setText("Habitación:");
        lblHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHabitacion.setForeground(new java.awt.Color(30, 41, 64));

        cmbHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHabitacionActionPerformed(evt);
            }
        });

        lblPersonas.setText("Personas:");
        lblPersonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPersonas.setForeground(new java.awt.Color(30, 41, 64));

        txtPersonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPersonas.setBackground(new java.awt.Color(255, 255, 255));
        txtPersonas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));

        lblRecepcionista.setText("Recepcionista:");
        lblRecepcionista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRecepcionista.setForeground(new java.awt.Color(30, 41, 64));

        txtRecepcionista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRecepcionista.setBackground(new java.awt.Color(236, 240, 246));
        txtRecepcionista.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtRecepcionista.setEditable(false);

        lblEntrada.setText("Fecha de entrada:");
        lblEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(30, 41, 64));

        spnEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnEntrada.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnEntradaStateChanged(evt);
            }
        });

        lblSalida.setText("Fecha de salida:");
        lblSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSalida.setForeground(new java.awt.Color(30, 41, 64));

        spnSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnSalida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSalidaStateChanged(evt);
            }
        });

        lblNoches.setText("Noches:");
        lblNoches.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNoches.setForeground(new java.awt.Color(30, 41, 64));

        txtNoches.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNoches.setBackground(new java.awt.Color(236, 240, 246));
        txtNoches.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtNoches.setEditable(false);

        lblImporte.setText("Importe total:");
        lblImporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblImporte.setForeground(new java.awt.Color(30, 41, 64));

        txtImporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtImporte.setBackground(new java.awt.Color(236, 240, 246));
        txtImporte.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtImporte.setEditable(false);

        lblEstadoReserva.setText("Estado:");
        lblEstadoReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstadoReserva.setForeground(new java.awt.Color(30, 41, 64));

        txtEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado.setBackground(new java.awt.Color(236, 240, 246));
        txtEstado.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        txtEstado.setEditable(false);

        btnRegistrar.setBackground(new java.awt.Color(21, 83, 163));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar reserva");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnRegistrar.setOpaque(true);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(108, 117, 134));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnLimpiar.setOpaque(true);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRecepcionista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHabitacionActionPerformed
        actualizarVistaPrevia();
    }//GEN-LAST:event_cmbHabitacionActionPerformed

    private void spnEntradaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnEntradaStateChanged
        actualizarVistaPrevia();
    }//GEN-LAST:event_spnEntradaStateChanged

    private void spnSalidaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSalidaStateChanged
        actualizarVistaPrevia();
    }//GEN-LAST:event_spnSalidaStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Huesped huesped = (Huesped) cmbHuesped.getSelectedItem();
        Habitacion habitacion = (Habitacion) cmbHabitacion.getSelectedItem();
        try {
            Reserva reserva = controlador.agregarReserva(huesped == null ? null : huesped.getIdentificacion(),
                    habitacion == null ? null : habitacion.getNumero(), txtPersonas.getText(),
                    Estilo.leerFecha(spnEntrada), Estilo.leerFecha(spnSalida));
            Dialogos.info(this, "Reserva " + reserva.getCodigo() + " registrada.\nNoches: " + reserva.getNoches()
                    + "   Importe: " + Estilo.colones(reserva.getImporteTotal()));
            txtPersonas.setText("");
            refrescar();
        } catch (HotelException ex) {
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtPersonas.setText("");
        Estilo.escribirFecha(spnEntrada, LocalDate.now());
        Estilo.escribirFecha(spnSalida, LocalDate.now().plusDays(1));
        if (cmbHuesped.getItemCount() > 0) {
            cmbHuesped.setSelectedIndex(0);
        }
        if (cmbHabitacion.getItemCount() > 0) {
            cmbHabitacion.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void actualizarVistaPrevia() {
        LocalDate entrada = Estilo.leerFecha(spnEntrada);
        LocalDate salida = Estilo.leerFecha(spnSalida);
        if (entrada == null || salida == null) {
            return;
        }
        long[] calculo = controlador.calcularNochesEImporte((Habitacion) cmbHabitacion.getSelectedItem(), entrada, salida);
        txtNoches.setText(String.valueOf(calculo[0]));
        txtImporte.setText(Estilo.colones(calculo[1]));
    }

    @Override
    public void refrescar() {
        Huesped hSel = (Huesped) cmbHuesped.getSelectedItem();
        Habitacion aSel = (Habitacion) cmbHabitacion.getSelectedItem();
        cmbHuesped.setModel(new DefaultComboBoxModel<>(controlador.listarHuespedes().toArray(new Huesped[0])));
        cmbHabitacion.setModel(new DefaultComboBoxModel<>(
                controlador.listarHabitaciones().toArray(new Habitacion[0])));
        seleccionarPorTexto(cmbHuesped, hSel);
        seleccionarPorTexto(cmbHabitacion, aSel);
        txtCodigo.setText(controlador.proximoCodigoReserva());
        txtRecepcionista.setText(controlador.getRecepcionistaActivo() == null ? ""
                : controlador.getRecepcionistaActivo().getUsuario());
        actualizarVistaPrevia();
        TablaReservas.llenar(tblReservas, controlador.listarReservas());
    }

    private static <T> void seleccionarPorTexto(JComboBox<T> combo, T anterior) {
        if (anterior == null) {
            return;
        }
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).toString().equals(anterior.toString())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<modelo.Habitacion> cmbHabitacion;
    private javax.swing.JComboBox<modelo.Huesped> cmbHuesped;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblEstadoReserva;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblHuesped;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblNoches;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JLabel lblRecepcionista;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JScrollPane scrTabla;
    private javax.swing.JSpinner spnEntrada;
    private javax.swing.JSpinner spnSalida;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNoches;
    private javax.swing.JTextField txtPersonas;
    private javax.swing.JTextField txtRecepcionista;
    // End of variables declaration//GEN-END:variables
}
