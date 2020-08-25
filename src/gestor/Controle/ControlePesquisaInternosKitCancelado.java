package gestor.Controle;


import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPagamentoKitInterno;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jIdRegistro;
import static gestor.Visao.TelaPesquisaInternoKitPagoCancelado.pITEM_KIT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePesquisaInternosKitCancelado {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    
    public ItensPagamentoKitInterno pPESQUISAR_produto(ItensPagamentoKitInterno objItensPagto) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DISTINCT PRODUTOS_AC.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.Quantidade "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS.IdRegistro='" + jIdRegistro.getText() + "' "
                    + "AND IdItemINT='" + pITEM_KIT + "'");
        } catch (Exception e) {
        }
         conecta.desconecta();
        return objItensPagto;
    }
}
