/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PlanejamentoAtividades;
import static gestor.Visao.TelaAtividadesEducacaoFisica.jCodigoPesquisa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaPlanejamentoCodigo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PlanejamentoAtividades objPlan = new PlanejamentoAtividades();

    public List<PlanejamentoAtividades> read() throws Exception {
        conecta.abrirConexao();
        List<PlanejamentoAtividades> listaPlanCodigo = new ArrayList<PlanejamentoAtividades>();
        try {
            conecta.executaSQL("SELECT * FROM PLANEJAMENTO_ATIVIDADES_GRUPO "
                    + "WHERE IdPlan='" + jCodigoPesquisa.getText() + "'");
            while (conecta.rs.next()) {
                PlanejamentoAtividades pPlan = new PlanejamentoAtividades();
                pPlan.setCodigo(conecta.rs.getInt("IdPlan"));
                pPlan.setSigla(conecta.rs.getString("Sigla"));
                pPlan.setDescricaoPlanejamento(conecta.rs.getString("DescricaoPlaneja"));
                pPlan.setDepartamento(conecta.rs.getString("Setor"));
                listaPlanCodigo.add(pPlan);
            }
            return listaPlanCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaPlanejamentoCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
