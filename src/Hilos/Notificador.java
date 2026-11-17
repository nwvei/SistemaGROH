/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import modelo.Indicadores;

/**
 *
 * @author Aaron
 */
public interface Notificador {

    void mostrarMensaje(String mensaje);

    void mostrarIndicadores(Indicadores indicadores);

    void procesosTerminados();
}
