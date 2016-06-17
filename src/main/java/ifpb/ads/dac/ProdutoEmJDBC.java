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
import javax.ejb.Stateless;


/**
 * @author Aluísio
 * @since 17/06/2016, 10:15:35
 */
@Stateless
public class ProdutoEmJDBC implements Produtos {

    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5433/dac-jsf";
    private String senha = "12345";
    private String usuario = "postgres";

    public ProdutoEmJDBC() {
        initConnection();
    }

    private void initConnection() {
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (descricao) values(?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, produto.getDescricao());
            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Produto> todos() {
        List<Produto> produto = new ArrayList<>();
        String sql = "Select * from produto;";
        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            ResultSet result = prepareStatement.executeQuery();

            while (result.next()) {
                produto.add(new Produto(result.getString("descricao")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }
}
