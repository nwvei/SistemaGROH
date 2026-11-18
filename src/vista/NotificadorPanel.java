/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Hilos.Notificador;
import javax.swing.SwingUtilities;
import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
class NotificadorPanel implements Notificador {

    private final PanelInicio panel;

    NotificadorPanel(PanelInicio panel) {
        this.panel = panel;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        SwingUtilities.invokeLater(new TareaVista(panel, mensaje, null, false));
    }

    @Override
    public void mostrarIndicadores(Indicadores indicadores) {
        SwingUtilities.invokeLater(new TareaVista(panel, null, indicadores, false));
    }

    @Override
    public void procesosTerminados() {
        SwingUtilities.invokeLater(new TareaVista(panel, null, null, true));
    }
}
