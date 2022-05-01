package Projeto.IntegradorII.Utils;

import Projeto.IntegradorII.Controller.ProdutoController;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ValidadorProduto {
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    String erros = "";
    
    
    private String cod;
    private String nome;
    private String marca;
    private String validade;
    private String cor;
    private double preco;
    private int tamanho; //200
    private String unidade; //gramas
    private String descricao;
    private String setor;
    private String tipo;
    private int qtdEstoque;
    
    
    public boolean validarProduto(JTextField txtCod, JTextField txtNome, JTextField txtMarca,
    JDateChooser dataValidade, JTextField txtCor, JTextField txtPreco, JTextField txtTamanho,
    JComboBox cbUnidade, JTextArea txtDescricao, JComboBox cbSetor, JComboBox cbTipo,
    JTextField txtQtdEstoque){
        
    //Executa as funções de validação para cada campo    
        //txtCod não valida por enquanto
        validaString(txtNome);
        validaString(txtMarca);
        validaTxt(txtDescricao);
        validaString(txtCor);
        validaPreco(txtPreco);
        validaQuantidade(txtTamanho);
        validaComboBox(cbUnidade);
        validaData(dataValidade);
        validaComboBox(cbSetor);
        validaComboBox(cbTipo);
        validaQuantidade(txtQtdEstoque);

    //Se não houver erros, atribui os valores às variáveis e retorna true.    
        if(erros.trim().equals("")){
            
            ProdutoController p = new ProdutoController();

            p.inserir
            (txtNome.getText(),
            txtMarca.getText(),
            txtDescricao.getText(),
            cbSetor.getSelectedItem().toString(),
            txtCor.getText(),
            Double.parseDouble(txtPreco.getText()),
            Integer.parseInt(txtQtdEstoque.getText()),
            Double.parseDouble(txtPreco.getText()),
            cbUnidade.getSelectedItem().toString(),
            dataValidade.getDate(),
            txtDescricao.getText());
   
            
            return true;
        }else{
            return false;
        }
    }
    
    
    //Validadores:
    
    //Verifica se o campo está vazio
    public void validaString(JTextField txt){
        if(txt.getText().trim().equals("")){
            erros += "Campo " + txt.getName() + " vazio\n";
            //Deixa a Borda do TextField em Vermelho
            txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    }
    
    //Igual validaString só que para JTextArea
    public void validaTxt(JTextArea txt){
        if(txt.getText().trim().equals("")){
            erros += "Campo " + txt.getName() + " vazio\n";
            //Deixa a Borda do TextField em Vermelho
            txt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        }
    }   
    
    
    //Verifica se um valor númerico positivo
    public void validaPreco(JTextField txt){
        try{            
            double t = Double.parseDouble(txt.getText());
            if (t < 0){
            erros += "Campo Preço inválido\n";
            txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
            }
        }catch(NumberFormatException e){
            erros += "Campo Preço inválido\n";
            txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        }
    }
    
    /*Verifica se a quantidade é um número inteiro positivo para ser usado em 
    Tamanho e qdtEstoque*/
    public void validaQuantidade(JTextField txt){
        try{
            int i = Integer.parseInt(txt.getText());
            if (i < 0){
                erros += "Informe somente valores inteiros positivos em " + txt.getName() + "\n";
                txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
            }
        
        }catch(NumberFormatException e){
                erros+= "Campo " + txt.getName() + " Inválido\n";
                txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
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
        } 
    }


    
    
    //Mostra Erros se houver
    public void exibirErros(){
        JOptionPane.showMessageDialog(null, erros);
    }
    
}
