/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author felip
 */
public class ClienteTest {
    
    @Test
    public void calculaIdade1() throws ParseException{
        
        // setup
        Cliente cliente = new Cliente("Felipe", "Ortiz", LocalDate.of(2002, 8, 25));
        
        int idadeAtual = cliente.calculaIdade(LocalDate.now());
        
        // assert
        Assert.assertEquals(19, idadeAtual);
        
        
    }
    
    @Test
    public void calculaIdade2() throws ParseException{
        
        // setup
        Cliente cliente = new Cliente("Roberto", "José", LocalDate.of(2002, 1, 5));
        
        int idadeAtual = cliente.calculaIdade(LocalDate.now());
        
        // assert
        Assert.assertEquals(21, idadeAtual);
        
        
    }
    
    @Test
    public void calculaIdade3() throws ParseException{
        
        // setup
        Cliente cliente = new Cliente("Melqui", "Vieira", LocalDate.of(1998, 10, 2));
        
        int idadeAtual = cliente.calculaIdade(LocalDate.now());
        
        // assert
        Assert.assertEquals(23, idadeAtual);
        
        
    }
    
    
    @Test
     public void calculaIdade4() throws ParseException{
        
        // setup
        Cliente cliente = new Cliente("Julia", "Manga", LocalDate.of(2002, 7, 23));
        
        int idadeAtual = cliente.calculaIdade(LocalDate.now());
        
        // assert
        Assert.assertEquals(30, idadeAtual);
        
        
    }
    
    
}
