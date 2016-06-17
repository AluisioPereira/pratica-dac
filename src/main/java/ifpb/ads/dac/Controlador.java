package ifpb.ads.dac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * @author Aluísio
 * @since 17/06/2016, 09:49:01
 */
@Named
@RequestScoped
public class Controlador implements Serializable{
    
    private Produto produto =  new Produto();
    
    private Produtos servico = new ProdutoEmMemoria();
    @Inject
    private Produtos servico1;// = new ProdutoEmJDBC();
    
    private List<Produto> todos = new ArrayList<>();
    
    public String redirecionar(){        
        return "home.xhtml";
    }
    public String salvar(){
        servico1.salvar(produto);
        servico.salvar(produto);
        todos = servico.todos();
        return "home.xhtml";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> todos() {
        return servico.todos();
//        return todos;
    }    

  public void setTodos(List<Produto> todos) {
       this.todos = todos;
   }
    
}
