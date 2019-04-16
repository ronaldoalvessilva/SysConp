/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProgramacaoKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleProgramacaoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProgramacaoKit objProg = new ProgramacaoKit();

    int codigoPavilhao;

    public ProgramacaoKit incluirProgramacaoKit(ProgramacaoKit objProg) {
        buscarPavilhao(objProg.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROGRAMACAO_PAGAMENTO_KITS_INTERNOS (DataUltimoPagto,DataPROG,DataPrevisao,TipoKit,IdPav,IdKit,ProgGerada,KitPago,DataPagamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objProg.getDataUltimoPagto().getTime()));
            pst.setTimestamp(2, new java.sql.Timestamp(objProg.getDataPROG().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objProg.getDataPrevisao().getTime()));
            pst.setInt(4, objProg.getTipoKit());
            pst.setInt(5, codigoPavilhao);
            pst.setInt(6, objProg.getIdKit());
            pst.setString(7, objProg.getProgGerado());
            pst.setString(8, objProg.getKitPago());
            if (objProg.getDataPagamento() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objProg.getDataPagamento().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objProg.getUsuarioInsert());
            pst.setString(11, objProg.getDataInsert());
            pst.setString(12, objProg.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR PROGRAMAÇÃO DE KIT.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProg;
    }

    public ProgramacaoKit excluirProgramacaoKit(ProgramacaoKit objProg) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROGRAMACAO_PAGAMENTO_KITS_INTERNOS WHERE IdPROG='" + objProg.getIdPROG() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR PROGTRAMAÇÃO DO KIT.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProg;
    }

    public void buscarPavilhao(String nomePav) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + nomePav + "'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
