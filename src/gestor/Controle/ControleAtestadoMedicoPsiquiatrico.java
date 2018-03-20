/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtestadoMedicoPsiquiatrico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAtestadoMedicoPsiquiatrico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtestadoMedicoPsiquiatrico objAtestado = new AtestadoMedicoPsiquiatrico();

    public AtestadoMedicoPsiquiatrico incluirAtestadoMedicoPsiquiatrico(AtestadoMedicoPsiquiatrico objAtestado) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATESTADO_MEDICO_PSIQUIATRICO (DataAtesta,IdLanc,IdInternoCrc,ModeloAtestado,TextoAtestado,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtestado.getDataAtesta().getTime()));
            pst.setInt(2, objAtestado.getIdLanc());
            pst.setInt(3, objAtestado.getIdInternoCrc());
            pst.setInt(4, objAtestado.getModeloAtestado());
            pst.setString(5, objAtestado.getTextoAtestado());
            pst.setString(6, objAtestado.getUsuarioInsert());
            pst.setString(7, objAtestado.getDataInsert());
            pst.setString(8, objAtestado.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }

    public AtestadoMedicoPsiquiatrico alterarAtestadoMedicoPsiquiatrico(AtestadoMedicoPsiquiatrico objAtestado) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATESTADO_MEDICO_PSIQUIATRICO SET DataAtesta=?,IdLanc=?,IdInternoCrc=?,ModeloAtestado=?,TextoAtestado=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAtestado.getIdLanc() + "'AND IdItem='" + objAtestado.getIdItem() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtestado.getDataAtesta().getTime()));
            pst.setInt(2, objAtestado.getIdLanc());
            pst.setInt(3, objAtestado.getIdInternoCrc());
            pst.setInt(4, objAtestado.getModeloAtestado());
            pst.setString(5, objAtestado.getTextoAtestado());
            pst.setString(6, objAtestado.getUsuarioUp());
            pst.setString(7, objAtestado.getDataUp());
            pst.setString(8, objAtestado.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }

    public AtestadoMedicoPsiquiatrico excluirAtestadoMedicoPsiquiatrico(AtestadoMedicoPsiquiatrico objAtestado) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATESTADO_MEDICO_PSIQUIATRICO WHERE IdLanc='" + objAtestado.getIdLanc() + "'AND IdItem='" + objAtestado.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }

    public AtestadoMedicoPsiquiatrico finalizarAtestadoMedicoPsiquiatrico(AtestadoMedicoPsiquiatrico objAtestado) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATESTADO_MEDICO_PSIQUIATRICO SET StatusLanc=? WHERE IdLanc='" + objAtestado.getIdLanc() + "'");
            //       pst.setString(1, objAtestado.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtestado;
    }
}
