package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Telas.EditarClientes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validador {
    String erros = "";
    
    

   public void validaString(String s, String nomeCampo){
        //Validação de CPF
        if(nomeCampo.equals("CPF")){
            //Se CPF tiver menos de 11 Caracteres
            if(s.length() < 11){
                erros += "Campo CPF com menos de 11 Caraceres\n";
            }
         
        //Validação de E-mail 
        }else if(nomeCampo.equals("Email")){
            String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailPat.matcher(s);
            if (!matcher.find()){
                erros += "Email Inválido\n";
            }
        }
        
        
        
        //Validação para os demais campos de String      
        //Valida se uma String é Vazia ("")
        else{
            if(s.trim().equals("")){
                erros += "Campo " + nomeCampo + " vazio\n";
            }
        }
   
   } 

   
   
   //Valida se o E-mail está em formato válido (user@provedor.com)
   public void validaEmail(String email){
       
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
