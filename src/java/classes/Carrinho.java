
package classes;

import java.util.LinkedList;

/**
 *
 * @author eduardo.podgornik
 */
public class Carrinho {
    
    
    private LinkedList<Produto> lista = new LinkedList<Produto>();
    private double total =0.0;
    private static Carrinho carrinho = null;
    
    
    public void adicionaCarrinho(String produto, double preco, int quantidade)
    {
        Produto p = new Produto(produto, preco, quantidade);
        lista.add(p);
        total = this.total + preco;
    }
    
    private Carrinho()
    {
        
    }
    
    
    public static Carrinho getInstance()
    {
        if(carrinho == null)
        {
            return new Carrinho();
        }
        else
        {
            return carrinho;
        }
        
    }
    /**
     * @return the lista
     */
    public LinkedList<Produto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<Produto> lista) {
        this.lista = lista;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
