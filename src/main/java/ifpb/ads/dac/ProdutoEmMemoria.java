package ifpb.ads.dac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Aluísio
 * @since 17/06/2016, 10:35:25
 */
public class ProdutoEmMemoria implements Produtos {

    private List<Produto> produto = new ArrayList<>();

    public void salvar(Produto produto) {
        this.produto.add(produto);
    }

    public List<Produto> todos() {
        return produto;
    }
}
