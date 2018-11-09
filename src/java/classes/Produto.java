/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author eduardo.podgornik
 */
public class Produto {

    
          
     private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(String nome, double preco, int quantidade)
    {
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
    }
    
    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 

    
    public Produto(String nome, float preco)
    {
        this.nome = nome;
        this.preco = preco;
    
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
       
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
   
}
