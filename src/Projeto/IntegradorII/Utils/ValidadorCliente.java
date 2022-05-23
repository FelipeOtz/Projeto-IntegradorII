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


/**
 * A Classe <b>ValidadorCliente</b> verifica se os campos do formulário cliente são válidos.
 * Deve ser instanciada ao clicar em 'Salvar'
 * @author Grupo PI
 * @since abr 2022
 * @version 1.0
 * @see <a href="ValidadorProduto.java">ValidadorProduto.java</a>
 */
public class ValidadorCliente {
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    
    String erros = "";
    
    
    
    /**
     * Chama a validação de todos os campos do formulário
     * @param txtNome Campo <b>JTextField</b>. Nome do formulário cliente
     * @param txtSobrenome <Campo <b>JTextField</b>. Sobrenome do formulário cliente
     * @param txtCPF Campo <b>JFormattedTextField</b>. CPF do formulário cliente
     * @param txtEmail Campo <b>JFormattedTextField</b>. Email do formulário cliente
     * @param txtTelefone Campo <b>JFormattedTextField</b>. Telefone do formulário cliente
     * @param jDateChooser1 Seletor <b>JDateChooser</b>. Data de Nascimento do formulário cliente
     * @param cbSexo Seletor <b>JComboBox</b>. Sexo do formulário cliente
     * @param cbEstadoCivil Seletor <b>JComboBox</b>. Estado Civil do formulário cliente
     * @param txtCep Seletor <b>JFormattedTextField</b>. CEP do formulário cliente
     * @param txtLogradouro Seletor <b>TextField</b>. Logradouro do formulário cliente
     * @param txtNum Seletor <b>TextField</b>. Número do formulário cliente
     * @param txtComplemento Seletor <b>TextField</b>. Complemento do formulário cliente
     * @param txtBairro Seletor <b>TextField</b>. Bairro do formulário cliente
     * @param txtCidade Seletor <b>TextField</b>. Cidade do formulário cliente
     * @param txtEstado Seletor <b>TextField</b>. Estado do formulário cliente
     * @return <b>true</b> se não houver erros na validação,<br><b>false</b> se houver.
     */
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
        
            return true;
        }
        else{
            return false;
        }
    
    }
    
    
    /*Métodos Validadores*/
    
 
    /**
     * Verifica se um JTextField é Vazio
     * Se vazio, Borda do campo Fica em vermelho e
     * mensagem de erro é exbida
     * @param campo JTextField do tipo String
     *
     */
    public void validaString(JTextField campo){    
        if(campo.getText().trim().equals("")){
            erros += "Campo " + campo.getName() + " vazio\n";
            //Deixa a Borda do TextField em Vermelho
            campo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    } 
    
    /*Verifica se num tem menos de 11 Caracteres para os Campos Telefone e CPF
    os quais obrigatóriamente devem ter 11 Digitos)*/   
    
    /**
     * Verifica se o campo numérico está preenchido conforme Máscara de formatação<br>
     * Deixa a borda em vermelho se campo estiver inválido
     * @param num Campo numérico JtextField <b>CPF</b> ou <b>Telefone</b>
     */
    public void validaNum(JTextField num ){
        if(num.getText().replaceAll("\\D", "").length() < 8){
            erros += "Campo " + num.getName() + " inválido\n";
            num.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    }
             
    //
    
    /**
     * Validação de <b>E-mail</b> fazendo uso de Regex<br>
     * Força a digitação de e-mail em formato válido <b>nome@email.com</b><br>
     * Deixa a borda em vermelho se campo estiver inválido
     * @param email Campo JtextField <b>Email</b>
     */
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

    
    /**
     * Validação de campos do tipo <b>Combo box</b><br>
     * Verifica se alguma opção foi selecionada<br>
     * Deixa campo em vermelho caso não tenha opção selecionada 
     * 
     * @param cb Campo JComboBox <b>Sexo</b> ou <b>EstadoCivil</b> 
     */
    public void validaComboBox (JComboBox cb){
        if(cb.getSelectedIndex() < 1){
            erros += "Nenhum " + cb.getName() + " Foi Selecionado\n";
            //Deixa JComboBox em Vermelho
            cb.setBackground(new java.awt.Color(255, 0, 0));
        }
    }
    
    
    /**
    Verifica se alguma data válida foi inserida
     *  
     * 
     * @parm data Seletor JDateChooser 
     */
    public void validaData (JDateChooser data){
        try{
            formatoData.format(data.getDate());
        }
        catch(Exception e){
            erros += "Nenhuma data foi selecionada\n";
        } 
    }
    
    
    
    //
    /**
     *  O Validador de Endereço verifica se os campos estão preenchidos.<br>
     * Faz a chamada da função <b> <a href="#">ValidaString</a><b>
     * para cada um dos campos<br>
     * @param txtCep Campo JTextfield. <b>CEP</b> do formulário
     * @param txtLogradouro Campo JTextfield. <b>Logradouro</b> do formulário
     * @param txtNum Campo JTextfield. <b>Número</b> do formulário
     * @param txtComplemento Campo JTextfield. <b>Complemento</b> do formulário
     * @param txtBairo Campo JTextfield. <b>Bairro</b> do formulário
     * @param txtCidade Campo JTextfield. <b>Cidade</b> do formulário
     * @param txtEstado  Campo JTextfield. <b>Estado</b> do formulário
     */
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
    
    
    /**
     * Exibe uma <b>MessageDialog</b> mostrando ao usuário quais os erros contidos<br>
     * no preenchimento do formulário
     */
    public void exibirErros(){
        JOptionPane.showMessageDialog(null, erros, "Falha ao Salvar", JOptionPane.WARNING_MESSAGE);       
    }
   
   

}