/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import gestor.Modelo.PavilhaoInternosSelecionados;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jComboBoxPavilhoes;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePavilhaoInternosMontaKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    PavilhaoInternosSelecionados objPavIntSelec = new PavilhaoInternosSelecionados();
    //
    String situacaoEntrada = "ENTRADA NA UNIDADE";
    String situacaoRetorno = "RETORNO A UNIDADE";
    int codPavilhao = 0;
    int codInterno = 0;

    public PavilhaoInternosMontagemKit incluirPavilhaoInternos(PavilhaoInternosMontagemKit objPavInt) {
        buscarPavilhao(objPavInt.getDescricaoPavilhao(), objPavInt.getIdPav());
        buscarInternoPavilhao(objPavInt.getNomeInternoCrc(), objPavInt.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOS_PAVILHAO_KIT_LOTE (IdRegistroComp,IdInternoCrc,IdPav,Utili,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objPavInt.getIdRegistroComp());
            pst.setInt(2, codInterno);
            pst.setInt(3, codPavilhao);
            pst.setString(4, objPavInt.getpUtili());
            pst.setString(5, objPavInt.getUsuarioInsert());
            pst.setString(6, objPavInt.getDataInsert());
            pst.setString(7, objPavInt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados (PAVILHÃO/INTERNOS).\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPavInt;
    }

    public PavilhaoInternosMontagemKit excluirPavilhaoInternos(PavilhaoInternosMontagemKit objPavInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOS_PAVILHAO_KIT_LOTE WHERE IdRegistroComp='" + objPavInt.getIdRegistroComp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados (PAVILHÃO/INTERNOS).\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPavInt;
    }

    public List<PavilhaoInternoMontaKit> read() throws Exception {
        conecta.abrirConexao();
        List<PavilhaoInternoMontaKit> listaInternosPavilhao = new ArrayList<PavilhaoInternoMontaKit>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoEntrada + "' "
                    + "OR PAVILHAO.DescricaoPav='" + jComboBoxPavilhoes.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.SituacaoCrc='" + situacaoRetorno + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                PavilhaoInternoMontaKit pDigi = new PavilhaoInternoMontaKit();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCncInternoCrc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setIdPav(conecta.rs.getInt("IdPav"));
                pDigi.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                listaInternosPavilhao.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosPavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public void buscarInternoPavilhao(String nomeInterno, int idInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "' AND IdInternoCrc='" + idInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dos INTERNOS a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarPavilhao(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do PAVILHÃO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
