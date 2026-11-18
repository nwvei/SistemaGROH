/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
class TareaVista implements Runnable {

    private final PanelInicio panel;
    private final String mensaje;
    private final Indicadores indicadores;
    private final boolean terminar;

    TareaVista(PanelInicio panel, String mensaje, Indicadores indicadores, boolean terminar) {
        this.panel = panel;
        this.mensaje = mensaje;
        this.indicadores = indicadores;
        this.terminar = terminar;
    }

    @Override
    public void run() {
        if (indicadores != null) {
            panel.mostrar(indicadores);
        }
        if (terminar) {
            panel.alTerminarProcesos();
        }
    }
}
