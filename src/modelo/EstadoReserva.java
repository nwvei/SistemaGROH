/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public enum EstadoReserva {
    CONFIRMADA("Confirmada"),
    HOSPEDADO("Hospedado"),
    FINALIZADA("Finalizada"),
    VENCIDA("Vencida");

    private final String texto;

    EstadoReserva(String texto) {
        this.texto = texto;
    }

    public boolean bloqueaDisponibilidad() {
        return this == CONFIRMADA || this == HOSPEDADO;
    }

    public boolean puedePasarA(EstadoReserva destino) {
        return switch (this) {
            case CONFIRMADA -> destino == HOSPEDADO || destino == VENCIDA;
            case HOSPEDADO -> destino == FINALIZADA;
            default -> false;
        };
    }

    @Override
    public String toString() {
        return texto;
    }
}

