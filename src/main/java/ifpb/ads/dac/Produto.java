package ifpb.ads.dac;

import java.time.LocalDate;


/**
 * @author Aluísio
 * @since 17/06/2016, 10:30:45
 */
public class Produto {
    private int id;
    private String descricao;

    public Produto() {
    }
    
    public Produto(String descricao) {
        this.descricao = descricao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
