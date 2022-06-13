/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNasc;
    private LocalDate dataLocal;
    private String sexo;
    private String estadoCivil;

    public String getDataEmTexto() {
        return dataEmTexto;
    }

    public void setDataEmTexto(String dataEmTexto) {
        this.dataEmTexto = dataEmTexto;
    }
    private static String dataEmTexto;



 
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente() {
    }

    

//    public Cliente(int id, String nome, String sobreNome, String cpf, String email, String telefone,
//        Date dataNasc, String sexo, String estadoCivil, String cep, String logradouro,
//        String numero, String complemento, String bairro, String cidade, String estado){
//        
//    this.setId(id);    
//    this.setNome(nome);
//    this.setSobreNome(sobreNome);
//    this.setCpf(cpf);
//    this.setEmail(email);
//    this.setTelefone(telefone);
//    this.setDataNasc(dataNasc);
//    this.setSexo(sexo);
//    this.setEstadoCivil(estadoCivil);
//    this.setCep(cep);
//    this.setCep(cep);
//    this.setLogradouro(logradouro);
//    this.setNumero(numero);
//    this.setComplemento(complemento);
//    this.setBairro(bairro);
//    this.setCidade(cidade);
//    this.setCidade(cidade);
//    this.setEstado(estado);
//    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSobrenome() {
        return sobreNome;
    }

    public Cliente(String nome, String sobreNome, LocalDate dataLocal) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataLocal = dataLocal;
    }

    public  int calculaIdade(LocalDate dataAtual) {
        
        LocalDate dataDeNascimento = this.dataLocal;
    
        if ((dataDeNascimento != null) && (dataAtual != null)) {
            return Period.between(dataDeNascimento, dataAtual).getYears();
        } else {
            return 0;
        }
    
        
//        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
//        
//        Calendar cData = Calendar.getInstance();
//        Calendar cHoje = Calendar.getInstance();
//        cData.setTime(formatoData.parse(dataEmTexto));
//        cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
//        int idade = cData.after(cHoje) ? -1 : 0;
//        cData.setTime(formatoData.parse(dataEmTexto));
//        idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
//        return idade;
    }

}
