/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensHistoricoDoencaAtual;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensHistoricoDoencasFamiliar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensHistoricoDoencaAtual objItensHist = new ItensHistoricoDoencaAtual();

    int codDoenca;

    public ItensHistoricoDoencaAtual incluirItensHistoricoDoencaAtual(ItensHistoricoDoencaAtual objItensHist) {
        buscarPatologia(objItensHist.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_HISTORICO_DOENCA_FAMILIA (IdHist,IdDoenca,GrauParentesco,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, objItensHist.getIdHist());
            pst.setInt(2, codDoenca);
            pst.setString(3, objItensHist.getGrauParentresco());
            pst.setString(4, objItensHist.getUsuarioInsert());
            pst.setString(5, objItensHist.getDataInsert());
            pst.setString(6, objItensHist.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensHist;
    }

    public ItensHistoricoDoencaAtual alterarItensHistoricoDoencaAtual(ItensHistoricoDoencaAtual objItensHist) {
        buscarPatologia(objItensHist.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_HISTORICO_DOENCA_FAMILIA SET IdHist=?,IdDoenca=?,GrauParentesco=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE ItensIdHist='" + objItensHist.getItensIdHist() + "'");
            pst.setInt(1, objItensHist.getIdHist());
            pst.setInt(2, codDoenca);
            pst.setString(3, objItensHist.getGrauParentresco());
            pst.setString(4, objItensHist.getUsuarioUp());
            pst.setString(5, objItensHist.getDataUp());
            pst.setString(6, objItensHist.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensHist;
    }

    public ItensHistoricoDoencaAtual excluirItensHistoricoDoencaAtual(ItensHistoricoDoencaAtual objItensHist) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_HISTORICO_DOENCA_FAMILIA WHERE ItensIdHist='" + objItensHist.getItensIdHist() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensHist;
    }

    public void buscarPatologia(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOENCAS WHERE Descricao='" + desc + "'");
            conecta.rs.first();
            codDoenca = conecta.rs.getInt("IdDoenca");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
