/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensTratamentoInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensTratamentoInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensTratamentoInterno objItensTrat = new ItensTratamentoInterno();

    int codDoenca, codTipo;

    public ItensTratamentoInterno incluirTratamento(ItensTratamentoInterno objItensTrat) {
        buscarPatologia(objItensTrat.getDescricaoPatologia());
        buscarTipoTratamento(objItensTrat.getDescricaoTipoTratamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_TRATAMENTOS_INTERNOS (IdAvalia,IdDoenca,IdTipo,Tratamento,Notificacao,Outros,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensTrat.getIdAvalia());
            pst.setInt(2, codDoenca);
            pst.setInt(3, codTipo);
            pst.setString(4, objItensTrat.getTratamento());
            pst.setString(5, objItensTrat.getNotificacao());
            pst.setString(6, objItensTrat.getOutros());
            pst.setString(7, objItensTrat.getUsuarioInsert());
            pst.setString(8, objItensTrat.getDataInsert());
            pst.setString(9, objItensTrat.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTrat;
    }

    public ItensTratamentoInterno alterarTratamento(ItensTratamentoInterno objItensTrat) {
        buscarPatologia(objItensTrat.getDescricaoPatologia());
        buscarTipoTratamento(objItensTrat.getDescricaoTipoTratamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_TRATAMENTOS_INTERNOS SET IdAvalia=?,IdDoenca=?,IdTipo=?,Tratamento=?,Notificacao=?,Outros=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemTrat='" + objItensTrat.getIdItemTrat() + "'");
            pst.setInt(1, objItensTrat.getIdAvalia());
            pst.setInt(2, codDoenca);
            pst.setInt(3, codTipo);
            pst.setString(4, objItensTrat.getTratamento());
            pst.setString(5, objItensTrat.getNotificacao());
            pst.setString(6, objItensTrat.getOutros());
            pst.setString(7, objItensTrat.getUsuarioUp());
            pst.setString(8, objItensTrat.getDataUp());
            pst.setString(9, objItensTrat.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTrat;
    }

    public ItensTratamentoInterno excluirTratamento(ItensTratamentoInterno objItensTrat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_TRATAMENTOS_INTERNOS WHERE IdItemTrat='" + objItensTrat.getIdItemTrat() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensTrat;
    }

    public void buscarPatologia(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOENCAS WHERE Descricao='" + desc + "'");
            conecta.rs.first();
            codDoenca = conecta.rs.getInt("IdDoenca");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o patologia.\nERRO: " + ex);
        }
    }

    public void buscarTipoTratamento(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_TRATAMENTOS WHERE DescricaoTipo='" + desc + "'");
            conecta.rs.first();
            codTipo = conecta.rs.getInt("IdTipo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o patologia.\nERRO: " + ex);
        }
    }
}
