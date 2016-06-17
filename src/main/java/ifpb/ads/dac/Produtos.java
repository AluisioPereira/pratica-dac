package ifpb.ads.dac;

import java.util.List;

/**
 * @author Aluísio
 * @since 17/06/2016, 09:20:45
 */
public interface Produtos {

    public void salvar(Produto produto);

    public List<Produto> todos();

}
