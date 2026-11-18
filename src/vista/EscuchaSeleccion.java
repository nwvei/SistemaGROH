/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Aaron
 */
class EscuchaSeleccion implements ListSelectionListener {

    private final PanelCheck panel;

    EscuchaSeleccion(PanelCheck panel) {
        this.panel = panel;
    }

    @Override
    public void valueChanged(ListSelectionEvent evento) {
        if (!evento.getValueIsAdjusting()) {
            panel.seleccionarFila();
        }
    }
}
