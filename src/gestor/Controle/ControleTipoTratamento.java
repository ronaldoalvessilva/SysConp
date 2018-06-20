/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TipoTratamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleTipoTratamento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TipoTratamento objTipoTratamento = new TipoTratamento();

    public TipoTratamento incluirTipoTratamento(TipoTratamento objTipoTratamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TIPOS_TRATAMENTOS (StatusTipo,DataTipo,DescricaoTipo,ObservacaoTipo,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, objTipoTratamento.getStatusTipo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTipoTratamento.getDataTipo().getTime()));
            pst.setString(3, objTipoTratamento.getDescricaoTipo());
            pst.setString(4, objTipoTratamento.getObservacaoTipo());
            pst.setString(5, objTipoTratamento.getUsuarioInsert());
            pst.setString(6, objTipoTratamento.getDataInsert());
            pst.setString(7, objTipoTratamento.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoTratamento;
    }
    public TipoTratamento alterarTipoTratamento(TipoTratamento objTipoTratamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TIPOS_TRATAMENTOS SET StatusTipo=?,DataTipo=?,DescricaoTipo=?,ObservacaoTipo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTipo='" + objTipoTratamento.getIdTipo() + "'");
            pst.setString(1, objTipoTratamento.getStatusTipo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTipoTratamento.getDataTipo().getTime()));
            pst.setString(3, objTipoTratamento.getDescricaoTipo());
            pst.setString(4, objTipoTratamento.getObservacaoTipo());
            pst.setString(5, objTipoTratamento.getUsuarioUp());
            pst.setString(6, objTipoTratamento.getDataUp());
            pst.setString(7, objTipoTratamento.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoTratamento;
    }
    public TipoTratamento excluirTipoTratamento(TipoTratamento objTipoTratamento) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TIPOS_TRATAMENTOS WHERE IdTipo='" + objTipoTratamento.getIdTipo() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoTratamento;
    }
}
