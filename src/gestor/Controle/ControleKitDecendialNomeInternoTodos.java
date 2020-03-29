/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jComboBoxPavilhao;
import static gestor.Visao.TelaProgramacaoKitsHigiene.qtdInternos;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jNomeInternoPesq;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleKitDecendialNomeInternoTodos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    String situacaoENT = "ENTRADA NA UNIDADE";
    String situacaoRET = "RETORNO A UNIDADE";

    public List<GravarInternosKitCompleto> read() throws Exception {
        String pUtili = "Sim";
        conecta.abrirConexao();
        List<GravarInternosKitCompleto> listaInternosKitComp = new ArrayList<GravarInternosKitCompleto>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoPesq.getText() + "%' "
                    + "AND PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoENT + "' "
                    + "OR NomeInternoCrc LIKE'%" + jNomeInternoPesq.getText() + "%' "
                    + "AND PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoRET + "'");
            while (conecta.rs.next()) {
                GravarInternosKitCompleto pDigi = new GravarInternosKitCompleto();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleKitDecendialNomeInternoTodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
