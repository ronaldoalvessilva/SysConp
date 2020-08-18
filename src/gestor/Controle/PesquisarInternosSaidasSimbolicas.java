/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoPagamentoKitHigiene;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaCancelamentoPagamentoKits.jCodigoReq;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisarInternosSaidasSimbolicas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    String caminho = "";

    public List<SaidaSimbolica> read() throws Exception {
        conecta.abrirConexao();
        List<SaidaSimbolica> listaInternosSaidaSimbolica = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdItem "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida='" + jCodigoReq.getText() + "' "
                    + "ORDER BY IdItem");
            while (conecta.rs.next()) {
                SaidaSimbolica pInternosSaida = new SaidaSimbolica();
                pInternosSaida.setIdItem(conecta.rs.getInt("IdItem"));
                pInternosSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pInternosSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosSaidaSimbolica.add(pInternosSaida);
            }
            return listaInternosSaidaSimbolica;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
