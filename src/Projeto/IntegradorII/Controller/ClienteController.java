/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Controller;

import Projeto.IntegradorII.Model.Cliente;

/**
 *
 * @author felip
 */
public class ClienteController {
    public static boolean inserir(String nome){
    Cliente cliente = new Cliente();
    cliente.setNome(nome);
      return true ;
    }
}
