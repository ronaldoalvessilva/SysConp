/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jComboBoxAnoReferencia;
import static gestor.Visao.TelaAtividadesMensalUnidade.jComboBoxMesReferencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaMesAno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        List<AtividadesMensalRealizadaUnidades> listaMesAnoAtividades = new ArrayList<AtividadesMensalRealizadaUnidades>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdAtividade,MesReferencia,AnoReferencia "
                    + "FROM ATIVIDADES_UNIDADE "
                    + "WHERE MesReferencia='" + jComboBoxMesReferencia.getSelectedItem() + "' "
                    + "AND AnoReferencia='" + jComboBoxAnoReferencia.getSelectedItem() + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtividadeMesAno = new AtividadesMensalRealizadaUnidades();
                pAtividadeMesAno.setChave(conecta.rs.getInt("IdAtividade"));
                pAtividadeMesAno.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pAtividadeMesAno.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                listaMesAnoAtividades.add(pAtividadeMesAno);
            }
            return listaMesAnoAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaMesAno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
