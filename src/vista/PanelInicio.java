/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Excepciones.HotelException;
import controlador.ControladorHotel;
import controlador.ControladorProcesos;
import modelo.Indicadores;

public class PanelInicio extends javax.swing.JPanel implements Refrescable {
    private final ControladorHotel controlador = new ControladorHotel();
    private final ControladorProcesos procesos = new ControladorProcesos();

    public PanelInicio() {
        initComponents();
        refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlBanner = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        lblModulos = new javax.swing.JLabel();
        pnlIndicadores = new javax.swing.JPanel();
        pnlTarjetas = new javax.swing.JPanel();
        pnlTotal = new javax.swing.JPanel();
        lblTitTotal = new javax.swing.JLabel();
        lblValTotal = new javax.swing.JLabel();
        pnlOcupadas = new javax.swing.JPanel();
        lblTitOcupadas = new javax.swing.JLabel();
        lblValOcupadas = new javax.swing.JLabel();
        pnlNoOcupadas = new javax.swing.JPanel();
        lblTitNoOcupadas = new javax.swing.JLabel();
        lblValNoOcupadas = new javax.swing.JLabel();
        pnlConfirmadas = new javax.swing.JPanel();
        lblTitConfirmadas = new javax.swing.JLabel();
        lblValConfirmadas = new javax.swing.JLabel();
        pnlVencidas = new javax.swing.JPanel();
        lblTitVencidas = new javax.swing.JLabel();
        lblValVencidas = new javax.swing.JLabel();
        pnlIngresos = new javax.swing.JPanel();
        lblTitIngresos = new javax.swing.JLabel();
        lblValIngresos = new javax.swing.JLabel();
        pnlProcesos = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        btnProcesos = new javax.swing.JButton();
        btnDemo = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        scrLog = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        lblNota = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 247, 252));

        pnlBanner.setBackground(new java.awt.Color(12, 44, 96));

        lblBienvenida.setText("Bienvenido al Sistema de Gestión Hotelera");
        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));

        lblModulos.setText("Huéspedes · Habitaciones · Reservas · Disponibilidad · Check-in / Check-out");
        lblModulos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblModulos.setForeground(new java.awt.Color(200, 220, 250));

        javax.swing.GroupLayout pnlBannerLayout = new javax.swing.GroupLayout(pnlBanner);
        pnlBanner.setLayout(pnlBannerLayout);
        pnlBannerLayout.setHorizontalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        pnlBannerLayout.setVerticalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pnlIndicadores.setBackground(new java.awt.Color(255, 255, 255));
        pnlIndicadores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Indicadores del hotel ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        pnlTarjetas.setOpaque(false);
        pnlTarjetas.setLayout(new java.awt.GridLayout(2, 3, 12, 12));

        pnlTotal.setBackground(new java.awt.Color(226, 238, 252));
        pnlTotal.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlTotal.setLayout(new java.awt.BorderLayout());

        lblTitTotal.setText("Total habitaciones");
        lblTitTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitTotal.setForeground(new java.awt.Color(21, 83, 163));
        lblTitTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlTotal.add(lblTitTotal, java.awt.BorderLayout.NORTH);

        lblValTotal.setText("0");
        lblValTotal.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValTotal.setForeground(new java.awt.Color(21, 83, 163));
        lblValTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlTotal.add(lblValTotal, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlTotal);

        pnlOcupadas.setBackground(new java.awt.Color(253, 228, 228));
        pnlOcupadas.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlOcupadas.setLayout(new java.awt.BorderLayout());

        lblTitOcupadas.setText("Ocupadas (Hospedado)");
        lblTitOcupadas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitOcupadas.setForeground(new java.awt.Color(197, 48, 48));
        lblTitOcupadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlOcupadas.add(lblTitOcupadas, java.awt.BorderLayout.NORTH);

        lblValOcupadas.setText("0");
        lblValOcupadas.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValOcupadas.setForeground(new java.awt.Color(197, 48, 48));
        lblValOcupadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlOcupadas.add(lblValOcupadas, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlOcupadas);

        pnlNoOcupadas.setBackground(new java.awt.Color(220, 245, 228));
        pnlNoOcupadas.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlNoOcupadas.setLayout(new java.awt.BorderLayout());

        lblTitNoOcupadas.setText("No ocupadas");
        lblTitNoOcupadas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitNoOcupadas.setForeground(new java.awt.Color(40, 150, 85));
        lblTitNoOcupadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlNoOcupadas.add(lblTitNoOcupadas, java.awt.BorderLayout.NORTH);

        lblValNoOcupadas.setText("0");
        lblValNoOcupadas.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValNoOcupadas.setForeground(new java.awt.Color(40, 150, 85));
        lblValNoOcupadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlNoOcupadas.add(lblValNoOcupadas, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlNoOcupadas);

        pnlConfirmadas.setBackground(new java.awt.Color(226, 238, 252));
        pnlConfirmadas.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlConfirmadas.setLayout(new java.awt.BorderLayout());

        lblTitConfirmadas.setText("Reservas confirmadas");
        lblTitConfirmadas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitConfirmadas.setForeground(new java.awt.Color(21, 83, 163));
        lblTitConfirmadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlConfirmadas.add(lblTitConfirmadas, java.awt.BorderLayout.NORTH);

        lblValConfirmadas.setText("0");
        lblValConfirmadas.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValConfirmadas.setForeground(new java.awt.Color(21, 83, 163));
        lblValConfirmadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlConfirmadas.add(lblValConfirmadas, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlConfirmadas);

        pnlVencidas.setBackground(new java.awt.Color(253, 228, 228));
        pnlVencidas.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlVencidas.setLayout(new java.awt.BorderLayout());

        lblTitVencidas.setText("Reservas vencidas");
        lblTitVencidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitVencidas.setForeground(new java.awt.Color(197, 48, 48));
        lblTitVencidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlVencidas.add(lblTitVencidas, java.awt.BorderLayout.NORTH);

        lblValVencidas.setText("0");
        lblValVencidas.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValVencidas.setForeground(new java.awt.Color(197, 48, 48));
        lblValVencidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlVencidas.add(lblValVencidas, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlVencidas);

        pnlIngresos.setBackground(new java.awt.Color(255, 243, 214));
        pnlIngresos.setPreferredSize(new java.awt.Dimension(180, 82));
        pnlIngresos.setLayout(new java.awt.BorderLayout());

        lblTitIngresos.setText("Ingresos esperados");
        lblTitIngresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitIngresos.setForeground(new java.awt.Color(150, 90, 0));
        lblTitIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlIngresos.add(lblTitIngresos, java.awt.BorderLayout.NORTH);

        lblValIngresos.setText("0");
        lblValIngresos.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblValIngresos.setForeground(new java.awt.Color(150, 90, 0));
        lblValIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlIngresos.add(lblValIngresos, java.awt.BorderLayout.CENTER);
        pnlTarjetas.add(pnlIngresos);

        javax.swing.GroupLayout pnlIndicadoresLayout = new javax.swing.GroupLayout(pnlIndicadores);
        pnlIndicadores.setLayout(pnlIndicadoresLayout);
        pnlIndicadoresLayout.setHorizontalGroup(
            pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlTarjetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        pnlIndicadoresLayout.setVerticalGroup(
            pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(pnlTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pnlProcesos.setBackground(new java.awt.Color(255, 255, 255));
        pnlProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)), " Procesos de supervisión (ejecución concurrente) ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(21, 83, 163))); // NOI18N

        lblDescripcion.setText("<html>Ejecuta dos hilos a la vez, cinco ciclos cada uno:<br>• <b>SupervisorReservas</b>: pasa a Vencida las reservas Confirmadas con entrada anterior a hoy.<br>• <b>ActualizadorIndicadores</b>: recalcula los indicadores del hotel.</html>");
        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(30, 41, 64));

        btnProcesos.setBackground(new java.awt.Color(21, 83, 163));
        btnProcesos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProcesos.setForeground(new java.awt.Color(255, 255, 255));
        btnProcesos.setText("Ejecutar procesos de supervisión");
        btnProcesos.setBorderPainted(false);
        btnProcesos.setContentAreaFilled(false);
        btnProcesos.setFocusPainted(false);
        btnProcesos.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnProcesos.setOpaque(true);
        btnProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesosActionPerformed(evt);
            }
        });

        btnDemo.setBackground(new java.awt.Color(108, 117, 134));
        btnDemo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDemo.setForeground(new java.awt.Color(255, 255, 255));
        btnDemo.setText("Cargar datos de ejemplo");
        btnDemo.setBorderPainted(false);
        btnDemo.setContentAreaFilled(false);
        btnDemo.setFocusPainted(false);
        btnDemo.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnDemo.setOpaque(true);
        btnDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoActionPerformed(evt);
            }
        });

        lblEstado.setText("Procesos detenidos.");
        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(30, 41, 64));

        scrLog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 230)));

        txtLog.setBackground(new java.awt.Color(20, 28, 44));
        txtLog.setEditable(false);
        txtLog.setForeground(new java.awt.Color(190, 235, 200));
        txtLog.setColumns(40);
        txtLog.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtLog.setRows(7);
        txtLog.setMargin(new java.awt.Insets(6, 8, 6, 8));
        scrLog.setViewportView(txtLog);

        lblNota.setText("Los mensajes también se muestran en la consola de salida de NetBeans.");
        lblNota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNota.setForeground(new java.awt.Color(30, 41, 64));

        javax.swing.GroupLayout pnlProcesosLayout = new javax.swing.GroupLayout(pnlProcesos);
        pnlProcesos.setLayout(pnlProcesosLayout);
        pnlProcesosLayout.setHorizontalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProcesosLayout.createSequentialGroup()
                        .addComponent(btnProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        pnlProcesosLayout.setVerticalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(scrLog, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlIndicadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(pnlIndicadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(pnlProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesosActionPerformed
        try {
            txtLog.setText("");
            btnProcesos.setEnabled(false);
            lblEstado.setText("Procesos en ejecución…");
            procesos.iniciar(this::agregarLog, this::mostrar, this::alTerminarProcesos);
        } catch (HotelException ex) {
            btnProcesos.setEnabled(false);
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnProcesosActionPerformed

    private void btnDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoActionPerformed
        try {
            controlador.cargarDatosDePrueba();
            refrescar();
            Dialogos.info(this, "Datos de ejemplo cargados: 4 huéspedes, 8 habitaciones y 5 reservas.\n"
                    + "Incluyen una reserva ya vencida para probar la supervisión.");
        } catch (HotelException ex) {
            Dialogos.error(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDemoActionPerformed

    private void alTerminarProcesos() {
        btnProcesos.setEnabled(true);
        lblEstado.setText("Procesos finalizados.");
    }

    private void agregarLog(String linea) {
        txtLog.append(linea + "\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());
    }

    void detenerProcesos() {
        procesos.detener();
    }

    void mostrar(Indicadores indicadores) {
        lblValTotal.setText(String.valueOf(indicadores.getTotalHabitaciones()));
        lblValOcupadas.setText(String.valueOf(indicadores.getOcupadas()));
        lblValNoOcupadas.setText(String.valueOf(indicadores.getNoOcupadas()));
        lblValConfirmadas.setText(String.valueOf(indicadores.getConfirmadas()));
        lblValVencidas.setText(String.valueOf(indicadores.getVencidas()));
        lblValIngresos.setText(Estilo.colones(indicadores.getIngresosEsperados()));
    }

    @Override
    public void refrescar() {
        mostrar(controlador.calcularIndicadores());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDemo;
    private javax.swing.JButton btnProcesos;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblModulos;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblTitConfirmadas;
    private javax.swing.JLabel lblTitIngresos;
    private javax.swing.JLabel lblTitNoOcupadas;
    private javax.swing.JLabel lblTitOcupadas;
    private javax.swing.JLabel lblTitTotal;
    private javax.swing.JLabel lblTitVencidas;
    private javax.swing.JLabel lblValConfirmadas;
    private javax.swing.JLabel lblValIngresos;
    private javax.swing.JLabel lblValNoOcupadas;
    private javax.swing.JLabel lblValOcupadas;
    private javax.swing.JLabel lblValTotal;
    private javax.swing.JLabel lblValVencidas;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlConfirmadas;
    private javax.swing.JPanel pnlIndicadores;
    private javax.swing.JPanel pnlIngresos;
    private javax.swing.JPanel pnlNoOcupadas;
    private javax.swing.JPanel pnlOcupadas;
    private javax.swing.JPanel pnlProcesos;
    private javax.swing.JPanel pnlTarjetas;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JPanel pnlVencidas;
    private javax.swing.JScrollPane scrLog;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
