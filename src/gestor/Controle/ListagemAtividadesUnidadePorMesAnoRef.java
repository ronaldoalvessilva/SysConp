/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jCodigoAtividade;
import static gestor.Visao.TelaAtividadesMensalUnidade.jComboBoxAnoPesquisa;
import static gestor.Visao.TelaAtividadesMensalUnidade.jComboBoxMesPesquisa;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListagemAtividadesUnidadePorMesAnoRef {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<AtividadesMensalRealizadaUnidades> listaTodasAtividades = new ArrayList<AtividadesMensalRealizadaUnidades>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdAtividade,StatusAtividade,"
                    + "DataCriacao,Populacao, "
                    + "MesReferencia,AnoReferencia, "
                    + "DescricaoUnidade "
                    + "FROM ATIVIDADES_UNIDADE "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON ATIVIDADES_UNIDADE.IdUnidEmp=UNIDADE_PENAL_EMPRESA.IdUnidEmp "
                    + "WHERE MesReferencia='" + jComboBoxMesPesquisa.getSelectedItem() + "' "
                    + "AND AnoReferencia='" + jComboBoxAnoPesquisa.getSelectedItem() + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtividade = new AtividadesMensalRealizadaUnidades();
                pAtividade.setChave(conecta.rs.getInt("IdAtividade"));
                pAtividade.setDataCriacao(conecta.rs.getDate("DataCriacao"));
                pAtividade.setMediaPopulacao(conecta.rs.getInt("Populacao"));
                pAtividade.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pAtividade.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                pAtividade.setUnidadePrisional(conecta.rs.getString("DescricaoUnidade"));
                listaTodasAtividades.add(pAtividade);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaTodasAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemAtividadesUnidadePorMesAnoRef.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
