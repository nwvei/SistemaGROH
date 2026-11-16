/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorHotel;
import controlador.ControladorSesion;
import javax.swing.SwingUtilities;

public class FrmHotel extends javax.swing.JFrame {
    private final ControladorSesion sesion = new ControladorSesion();
    private final ControladorHotel controlador = new ControladorHotel();

    public FrmHotel() {
        initComponents();
        String nombre = sesion.getRecepcionistaActivo() == null ? "—"
                : sesion.getRecepcionistaActivo().getUsuario();
        lblRecepcionista.setText("Recepcionista: " + nombre);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlEncabezado = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblRecepcionista = new javax.swing.JLabel();
        btnCambiarUsuario = new javax.swing.JButton();
        tabs = new javax.swing.JTabbedPane();
        pnlInicio = new vista.PanelInicio();
        pnlHuespedes = new vista.PanelHuespedes();
        pnlHabitaciones = new vista.PanelHabitaciones();
        pnlReservas = new vista.PanelReservas();
        pnlDisponibilidad = new vista.PanelDisponibilidad();
        pnlCheck = new vista.PanelCheck();
        pnlSimulacion = new vista.PanelSimulacion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión Hotelera - Hotel");
        setMinimumSize(new java.awt.Dimension(1050, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlEncabezado.setBackground(new java.awt.Color(12, 44, 96));

        lblLogo.setText("<html>HOTEL  <font color=\"#FFC846\" face=\"Segoe UI Symbol\">★★★★★</font></html>");
        lblLogo.setFont(new java.awt.Font("Segoe UI Black", 1, 26)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));

        lblSubtitulo.setText("Sistema de gestión de reservas y operaciones hoteleras");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(190, 210, 240));

        lblRecepcionista.setText("Recepcionista: —");
        lblRecepcionista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRecepcionista.setForeground(new java.awt.Color(255, 255, 255));

        btnCambiarUsuario.setBackground(new java.awt.Color(40, 120, 220));
        btnCambiarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCambiarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarUsuario.setText("Cambiar usuario");
        btnCambiarUsuario.setBorderPainted(false);
        btnCambiarUsuario.setContentAreaFilled(false);
        btnCambiarUsuario.setFocusPainted(false);
        btnCambiarUsuario.setMargin(new java.awt.Insets(8, 18, 8, 18));
        btnCambiarUsuario.setOpaque(true);
        btnCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnCambiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        tabs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        tabs.addTab("Inicio", pnlInicio);

        tabs.addTab("Huéspedes", pnlHuespedes);

        tabs.addTab("Habitaciones", pnlHabitaciones);

        tabs.addTab("Reservas", pnlReservas);

        tabs.addTab("Disponibilidad", pnlDisponibilidad);

        tabs.addTab("Check-in / Check-out", pnlCheck);

        tabs.addTab("Simulación", pnlSimulacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pnlInicio.detenerProcesos();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void btnCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarUsuarioActionPerformed
        if (!Dialogos.confirmar(this, "Para ingresar con otro usuario debe cerrarse la sesión actual.\n"
                + "Los datos registrados se conservarán.\n\n¿Desea cerrar la sesión?", "Cambiar usuario")) {
            return;
        }
        pnlInicio.detenerProcesos();
        sesion.cerrarSesion();
        dispose();
        SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
    }//GEN-LAST:event_btnCambiarUsuarioActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged

        if (tabs.getSelectedComponent() instanceof Refrescable r) {
            r.refrescar();
        }
    }//GEN-LAST:event_tabsStateChanged

    public void revisarVencimientosAlIniciar() {
        int vencidas = controlador.revisarVencimientos();
        pnlInicio.refrescar();
        Dialogos.info(this, "Revisión de reservas realizada correctamente.\n"
                + (vencidas == 0 ? "No hay reservas por vencer."
                        : vencidas + " reserva(s) Confirmada(s) pasaron a estado Vencida."));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarUsuario;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRecepcionista;
    private javax.swing.JLabel lblSubtitulo;
    private vista.PanelCheck pnlCheck;
    private vista.PanelDisponibilidad pnlDisponibilidad;
    private javax.swing.JPanel pnlEncabezado;
    private vista.PanelHabitaciones pnlHabitaciones;
    private vista.PanelHuespedes pnlHuespedes;
    private vista.PanelInicio pnlInicio;
    private vista.PanelReservas pnlReservas;
    private vista.PanelSimulacion pnlSimulacion;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
