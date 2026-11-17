/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public final class Recepcionista {

    private final String usuario;
    private final String contrasena;

    Recepcionista(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    boolean validar(String usuarioIngresado, String contrasenaIngresada) {
        return usuario.equals(usuarioIngresado) && contrasena.equals(contrasenaIngresada);
    }

    @Override
    public String toString() {
        return usuario;
    }
}
