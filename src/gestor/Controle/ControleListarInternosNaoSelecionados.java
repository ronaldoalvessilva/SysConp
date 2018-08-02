/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ListarInternosNaoSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
// METODO QUE LISTA TODOS OS INTERNOS QUE NÃO FORAM SELECIONADOS PARA O KIT COMPLETO
public class ControleListarInternosNaoSelecionados {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    
    public List<ListarInternosNaoSelecionados> read() throws Exception {
        String pUtili = "Não";       
        conecta.abrirConexao();
        List<ListarInternosNaoSelecionados> listaInternosNaoSelec = new ArrayList<ListarInternosNaoSelecionados>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "WHERE Utili='" + pUtili + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                ListarInternosNaoSelecionados pLista = new ListarInternosNaoSelecionados();
                pLista.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pLista.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosNaoSelec.add(pLista);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosNaoSelec;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListarInternosNaoSelecionados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
