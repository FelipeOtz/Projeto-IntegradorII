/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto.IntegradorII.Controller;

import Projeto.IntegradorII.DAO.ProdutoDAO;
import Projeto.IntegradorII.Model.Produto;
import java.util.Date;

/**
 *
 * @author felip
 */
public class ProdutoController {

    public static boolean inserir(
            String nome,
            String marca,
            String tipo,
            String setor,
            String cor,
            double preco,
            int estoque,
            double tamanho,
            String unidade,
            Date validade,
            String descricao
    ) {

        Produto produto = new Produto();
        
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setTipo(tipo);
        produto.setSetor(setor);
        produto.setCor(cor);
        produto.setPreco(preco);
        produto.setEstoque(estoque);
        produto.setTamanho(tamanho);
        produto.setUnidade(unidade);
        produto.setValidade(validade);
        produto.setDescricao(descricao);
        
        return ProdutoDAO.inserir(produto);
    }
}
