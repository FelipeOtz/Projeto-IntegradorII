package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Telas.EditarClientes;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidadorCliente {
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    
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
    JTextField txtEmail, JTextField txtTelefone, JDateChooser jDateChooser1, JComboBox cbSexo, JComboBox cbEstadoCivil){
        
        validaString(txtNome);
        validaString(txtSobrenome);
        validaNum(txtCPF);
        validaEmail(txtEmail);
        validaNum(txtTelefone);
        validaData(jDateChooser1);
        validaComboBox(cbSexo);
        validaComboBox(cbEstadoCivil);

        //Se não houver erros, atribui os valores às variáveis e retorna true.    
        if(erros.trim().equals("")){
            this.nome = txtNome.getText();
            this.sobreNome = txtSobrenome.getText();
            this.cpf = txtCPF.getText().replaceAll("\\D", "");
            this.email = txtEmail.getText().toLowerCase();
            this.telefone = txtTelefone.getText().replaceAll("\\D", "");    
            this.dataNasc = formatoData.format(jDateChooser1.getDate());
            this.sexo = cbSexo.getSelectedItem().toString();
            this.estadoCivil = cbEstadoCivil.getSelectedItem().toString();
            return true;
        }

        else{
            return false;
        }
    
    }
    
    
    /*Métodos Validadores*/
    
    //Verifica se um JTextField é Vazio ("")
    public void validaString(JTextField campo){    
        if(campo.getText().trim().equals("")){
            erros += "Campo " + campo.getName() + " vazio\n";
        }
    } 
    
    /*Verifica se num tem menos de 11 Caracteres para os Campos Telefone e CPF
    os quais obrigatóriamente devem ter 11 Digitos)*/    
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

    /*Verifica se alguma opção do comboBox foi selecionada*/ 
    public void validaComboBox (JComboBox cb){
        if(cb.getSelectedIndex() < 1){
            erros += "Nenhum " + cb.getName() + " Foi Selecionado\n";
        }
    }
    
    
    /*Verifica se alguma data foi Selecionada*/
    public void validaData (JDateChooser data){
        try{
            formatoData.format(data.getDate());
        }
        catch(Exception e){
            erros += "Nenhuma data foi selecionada\n";
        } 
    }
    
    //Exibe Erros
    public void exibirErros (){
        JOptionPane.showMessageDialog(null, erros);
    }
   
   

}