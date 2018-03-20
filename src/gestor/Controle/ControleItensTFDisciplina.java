/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensTFDisciplina;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensTFDisciplina {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensTFDisciplina objItensTPDisc = new ItensTFDisciplina();

    int codDisc;

    public ItensTFDisciplina incluirDisciplinas(ItensTFDisciplina objItensTPDisc) {
        buscarDisciplinas(objItensTPDisc.getDescricaoDiscplina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSTFDISCIPLINA (IdTempo,IdDisc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setInt(1, objItensTPDisc.getIdTempo());
            pst.setInt(2, codDisc);
            pst.setString(3, objItensTPDisc.getUsuarioInsert());
            pst.setString(4, objItensTPDisc.getDataInsert());
            pst.setString(5, objItensTPDisc.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTPDisc;
    }

    public ItensTFDisciplina alterarDisciplinas(ItensTFDisciplina objItensTPDisc) {
        buscarDisciplinas(objItensTPDisc.getDescricaoDiscplina());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSTFDISCIPLINA SET IdTempo=?,IdDisc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensTPDisc.getIdItem() + "'");
            pst.setInt(1, objItensTPDisc.getIdTempo());
            pst.setInt(2, codDisc);
            pst.setString(3, objItensTPDisc.getUsuarioUp());
            pst.setString(4, objItensTPDisc.getDataUp());
            pst.setString(5, objItensTPDisc.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTPDisc;
    }

    public ItensTFDisciplina excluirDisciplinas(ItensTFDisciplina objItensTPDisc) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSTFDISCIPLINA WHERE IdItem='" + objItensTPDisc.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTPDisc;
    }

    public void buscarDisciplinas(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DISCIPLINAS WHERE Descricao='" + desc + "'");
            conecta.rs.first();
            codDisc = conecta.rs.getInt("IdDisc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DISCIPLINAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
