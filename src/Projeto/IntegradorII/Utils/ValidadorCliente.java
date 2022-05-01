package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Controller.ClienteController;
import Projeto.IntegradorII.View.EditarClientes;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
    
    public boolean validarCliente (JTextField txtNome, JTextField txtSobrenome, JTextField txtCPF,
    JTextField txtEmail, JTextField txtTelefone, JDateChooser jDateChooser1, JComboBox cbSexo, JComboBox cbEstadoCivil,
    JTextField txtCep, JTextField txtLogradouro, JTextField txtNum, JTextField txtComplemento, JTextField txtBairro,
    JTextField txtCidade, JTextField txtEstado){
        
        
        //Aciona valiação dos campos de dados Pessoais
        validaString(txtNome);
        validaString(txtSobrenome);
        validaNum(txtCPF);
        validaEmail(txtEmail);
        validaNum(txtTelefone);
        validaData(jDateChooser1);
        validaComboBox(cbSexo);
        validaComboBox(cbEstadoCivil);
        validaEndereco(txtCep, txtLogradouro, txtNum, txtComplemento, txtBairro, txtCidade, txtEstado);  
        
        
        //Se não houver erros    
        if(erros.trim().equals("")){
            
            ClienteController c1 = new ClienteController();    

            c1.inserir(
                txtNome.getText(),
                txtSobrenome.getText(),
                txtCPF.getText(),
                txtEmail.getText().toLowerCase(),
                txtTelefone.getText(),
                formatoData.format(jDateChooser1.getDate()),
                cbSexo.getSelectedItem().toString(),
                cbEstadoCivil.getSelectedItem().toString(),
                txtCep.getText(),
                txtLogradouro.getText(),
                txtNum.getText(),
                txtComplemento.getText(),
                txtBairro.getText(),
                txtCidade.getText(),
                txtEstado.getText()
            );
        
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
            //Deixa a Borda do TextField em Vermelho
            campo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    } 
    
    /*Verifica se num tem menos de 11 Caracteres para os Campos Telefone e CPF
    os quais obrigatóriamente devem ter 11 Digitos)*/    
    public void validaNum(JTextField num){
        if(num.getText().replaceAll("\\D", "").length() < 8){
            erros += "Campo " + num.getName() + " inválido\n";
            //Deixa a Borda do TextField em Vermelho
            num.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
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
            //Deixa a Borda do TextField em Vermelho
            email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    }  

    /*Verifica se alguma opção do comboBox foi selecionada*/ 
    public void validaComboBox (JComboBox cb){
        if(cb.getSelectedIndex() < 1){
            erros += "Nenhum " + cb.getName() + " Foi Selecionado\n";
            //Deixa combo box em Vermelho
            cb.setBackground(new java.awt.Color(255, 0, 0));
        }
    }
    
    
    /*Verifica se alguma data foi Selecionada*/
    public void validaData (JDateChooser data){
        try{
            formatoData.format(data.getDate());
        }
        catch(Exception e){
            erros += "Nenhuma data foi selecionada\n";
            //Borda Fica e
            // data.setBackground(new java.awt.Color(255, 0, 0));
        } 
    }
    
    
    
    //Validador de Endereço, verifica se os campos estão preenchidos
    public void validaEndereco(JTextField txtCep, JTextField txtLogradouro, JTextField txtNum,
        JTextField txtComplemento, JTextField txtBairo, JTextField txtCidade, JTextField txtEstado){
            validaNum(txtCep);
            validaString(txtLogradouro);
            validaString(txtNum);
            //validaString(txtComplemento); Complemento não valida pois é Opcional
            validaString(txtBairo);
            validaString(txtCidade);
            validaString(txtEstado);
        }
    
    
    //Exibe Erros
    public void exibirErros (){
        JOptionPane.showMessageDialog(null, erros, "Falha ao Salvar", JOptionPane.WARNING_MESSAGE);
        
        
    }
   
   

}