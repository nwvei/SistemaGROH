/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Excepciones.HotelException;
import modelo.GestorHotel;
import modelo.Recepcionista;

public class ControladorSesion {
    private final GestorHotel gestor = GestorHotel.getInstancia();

    public Recepcionista iniciarSesion(String usuario, String contrasena) throws HotelException {
        return gestor.iniciarSesion(usuario, contrasena);
    }

    public void cerrarSesion() {
        gestor.cerrarSesion();
    }

    public Recepcionista getRecepcionistaActivo() {
        return gestor.getRecepcionistaActivo();
    }
}
