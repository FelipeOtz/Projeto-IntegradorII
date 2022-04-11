package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Telas.EditarClientes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validador {
    String erros = "";
    
    private String nome;
    private String sobreNome;
    private String cpf; 
    private String email;
    private String telefone;
    private String dataNasc;
    private String sexo;
    private String estadoCivil;
    
    public boolean validarCliente (JTextField txtNome, JTextField txtSobrenome, JTextField txtCPF,
    JTextField txtEmail, JTextField txtTelefone, Date jDateChooser1, JComboBox cbSexo, JComboBox cbEstadoCivil){
        this.nome = txtNome.getText();
        this.sobreNome = txtSobrenome.getText();
        this.cpf = txtCPF.getText().replaceAll("\\D", "");
        this.email = txtEmail.getText().toLowerCase();
        this.telefone = txtTelefone.getText().replaceAll("\\D", "");
        //this.dataNasc = (new SimpleDateFormat("dd/MM/yyyy")).format(jDateChooser1.getDate());
        this.sexo = cbSexo.getSelectedItem().toString();
        this.estadoCivil = cbEstadoCivil.getSelectedItem().toString();
        
        
        validaString(txtNome);
        validaString(txtSobrenome);
        validaNum(txtCPF);
        validaEmail(txtEmail);
        validaNum(txtTelefone);
        //Data Não Precisa de Validação por enquanto
        validaComboBox(cbSexo);
        validaComboBox(cbEstadoCivil);
    //Se a String erros estiver vazia significa que não houveram erros, logo a validação
    // retornará true.    
    if(erros.trim().equals(""))
        return true;
    else
        return false;
    
    }
    
    
    /*Métodos Validadores*/
    
    //Valida se um JTextField é Vazio ("")
    public void validaString(JTextField campo){    
        if(campo.getText().trim().equals("")){
            erros += "Campo " + campo.getName() + " vazio\n";
        }
    } 
    
    /*Verifica se num tem menos de 11 Caracteres
    para os Campos Telefone e CPF os quais obrigatóriamente devem ter 11 Digitos)*/    
    public void validaNum(JTextField num){
        if(num.getText().replaceAll("\\D", "").length() < 11){
            erros += "Campo " + num.getName() + " inválido\n"; 
        }
    }
        
         
    //Validação de E-mail usando Regex
    public void validaEmail(JTextField email){
    String e = email.getText();
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPat.matcher(e);
        if (!matcher.find()){
            erros += "Email Inválido\n";
        }
    }  

    /*Se o selectedIndex for igual a 0 significa que nenhuma
    opção foi selecionada*/ 
    public void validaComboBox (JComboBox cb){
        if(cb.getSelectedIndex() < 1){
            erros += "Nenhum " + cb.getName() + " Foi Selecionado\n";
        }
    }
           
    public void showErros (){
        JOptionPane.showMessageDialog(null, erros);
    }
   
   

}