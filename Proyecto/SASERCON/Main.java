/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SASERCON;

/**
 *
 * @author darki
 */
public class Main {
    public static void main(String[] args) {
        Login L = new Login();
        L.solicitar_usuario();
        L.solicitar_contrasenha();
        L.recuperar();
        L.guardar();
        L.mostrar();
    }
}