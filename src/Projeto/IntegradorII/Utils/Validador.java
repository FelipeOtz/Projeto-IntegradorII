package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Telas.EditarClientes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validador {
    String erros = "";
    
    
    //nome, sobrenome, cpf, email, telefone, dt nasc, sexo, estado civil
    public void validarCliente(String nome, String sobreNome, String cpf, String email,
    String telefone, String dataNasc, String sexo, String estadoCivil){
        validaString(nome);
        validaString(sobreNome);
        validaCPF(cpf);
        validaEmail(email);
        
    }
    
    
    //Se CPF tiver menos de 11 Caracteres    
   public void validaCPF(String cpf){
        if(cpf.length() < 11){
        erros += "Campo CPF inválido\n"; 
        }
    }
        
         
    //Validação de E-mail usando Regex
    public void validaEmail(String email){
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPat.matcher(email);
        if (!matcher.find()){
            erros += "Email Inválido\n";
        }
    }  
        
           
    //Valida se uma String é Vazia ("")
    public void validaString(String campo){    
            if(campo.trim().equals("")){
                erros += "Campo " + campo + " vazio\n";
            }
        }
    

     
   //Exibe os Erros se Houver
   public void msgSalvar(){
       if (!erros.equals("")){
           JOptionPane.showMessageDialog(null, "Erros Encontrados:\n" + erros);
       }else{
           JOptionPane.showMessageDialog(null, "Alterações Salvas");
       }
   }
   
   

}