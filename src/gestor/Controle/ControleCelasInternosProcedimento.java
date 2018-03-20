/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPavilhaoCelaInternosProcedimento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCelasInternosProcedimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPavilhaoCelaInternosProcedimento objItensProced = new ItensPavilhaoCelaInternosProcedimento();

    int codInternoCrc;
    int codPavilhao;
    int codCela;

    public ItensPavilhaoCelaInternosProcedimento incluirPavilhaoCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {
        pesquisarPavilhao(objItensProced.getDescricaoPavilhao());
        pesquisarCela(objItensProced.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSPCIP (DataProc,IdProc,IdPav,IdCela,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensProced.getDataProc().getTime()));
            pst.setInt(2, objItensProced.getIdProc());
            pst.setInt(3, codPavilhao);
            pst.setInt(4, codCela);
            pst.setString(5, objItensProced.getUsuarioInsert());
            pst.setString(6, objItensProced.getDataInsert());
            pst.setString(7, objItensProced.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }

    public ItensPavilhaoCelaInternosProcedimento alterarPavilhaoCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {
        pesquisarPavilhao(objItensProced.getDescricaoPavilhao());
        pesquisarCela(objItensProced.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPCIP SET DataProc=?,IdProc=?,IdPav=?,IdCela=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItensPcip='" + objItensProced.getIdItensPcip() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensProced.getDataProc().getTime()));
            pst.setInt(2, objItensProced.getIdProc());
            pst.setInt(3, codPavilhao);
            pst.setInt(4, codCela);
            pst.setString(5, objItensProced.getUsuarioUp());
            pst.setString(6, objItensProced.getDataUp());
            pst.setString(7, objItensProced.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }

    public ItensPavilhaoCelaInternosProcedimento excluirPavilhaoCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSPCIP WHERE IdItensPcip='" + objItensProced.getIdItensPcip() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir o registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }

    //------------------------ *******************************************--------------------------------------
    // Metódo para os internos das celas do procedimento.
    public ItensPavilhaoCelaInternosProcedimento incluirInternosCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {
        pesquisarCela(objItensProced.getDescricaoCela());
        pesquisarInternoCrc(objItensProced.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOSPROCEDIMENTOS (IdProc,IdItensPcip,IdCela,IdInternoCrc) VALUES(?,?,?,?)");
            pst.setInt(1, objItensProced.getIdProc());
            pst.setInt(2, objItensProced.getIdItensPcip());
            pst.setInt(3, codCela);
            pst.setInt(4, codInternoCrc);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }

    public ItensPavilhaoCelaInternosProcedimento alterarInternosCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {
        pesquisarCela(objItensProced.getDescricaoCela());
        pesquisarInternoCrc(objItensProced.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOSPROCEDIMENTOS SET IdCela=?,IdInternoCrc=? WHERE IdItensPcIP='" + objItensProced.getIdItensPcip() + "'");
            pst.setInt(1, codCela);
            pst.setInt(2, codInternoCrc);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }   

    public ItensPavilhaoCelaInternosProcedimento excluirInternosCela(ItensPavilhaoCelaInternosProcedimento objItensProced) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOSPROCEDIMENTOS WHERE IdItensPcip='" + objItensProced.getIdItensPcip() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensProced;
    }

    public void pesquisarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarCela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
