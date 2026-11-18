/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Aaron
 */
public class AbrirLogin implements Runnable {

    @Override
    public void run() {
        new FrmLogin().setVisible(true);
    }
}
