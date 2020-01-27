/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAtividadeJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jIDInternoJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jIDLanc;
import static gestor.Visao.TelaAtividadesRealizadasADM.qtdAtividades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ronaldo
 */
public class ControleItensAtividadeJuridico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAtividadeJuridico objAtivi = new ItensAtividadeJuridico();
    int qtd = 1;
    int codAtividade;

    public ItensAtividadeJuridico incluirAtividade(ItensAtividadeJuridico objAtivi) {
        buscarAtividade(objAtivi.getDescricaoAtividade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSATENDIMENTOJURI (DataItem,IdLanc,IdAtiv,IdInternoCrc,QtdAtiv,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtivi.getDataItem().getTime()));
            pst.setInt(2, objAtivi.getIdLanc());
            pst.setInt(3, codAtividade);
            pst.setInt(4, objAtivi.getIdInternoCrc());
            pst.setInt(5, qtd);
            pst.setString(6, objAtivi.getUsuarioInsert());
            pst.setString(7, objAtivi.getDataInsert());
            pst.setString(8, objAtivi.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public ItensAtividadeJuridico alterarAtividade(ItensAtividadeJuridico objAtivi) {
        buscarAtividade(objAtivi.getDescricaoAtividade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSATENDIMENTOJURI SET DataItem=?,IdLanc=?,IdAtiv=?,IdInternoCrc=?,QtdAtiv=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objAtivi.getIdItem() + "'AND IdAtiv='" + objAtivi.getIdAtiv() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtivi.getDataItem().getTime()));
            pst.setInt(2, objAtivi.getIdLanc());
            pst.setInt(3, objAtivi.getIdAtiv());
            pst.setInt(4, objAtivi.getIdInternoCrc());
            pst.setInt(5, qtd);
            pst.setString(6, objAtivi.getUsuarioUp());
            pst.setString(7, objAtivi.getDataUp());
            pst.setString(8, objAtivi.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public ItensAtividadeJuridico excluirAtividade(ItensAtividadeJuridico objAtivi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSATENDIMENTOJURI "
                    + "WHERE IdItem='" + objAtivi.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public ItensAtividadeJuridico excluirAtividadeRealizadas(ItensAtividadeJuridico objAtivi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSATENDIMENTOJURI "
                    + "WHERE IdLanc='" + objAtivi.getIdLanc() + "' "
                    + "AND IdAtiv='" + objAtivi.getIdAtiv() + "' "
                    + "AND IdInternoCrc='" + objAtivi.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    // Alterar interno quando usuário modificar na capa do atendimento juridico interno.
    public ItensAtividadeJuridico alterarInternoAtividade(ItensAtividadeJuridico objAtivi) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSATENDIMENTOJURI SET IdInternoCrc=? "
                    + "WHERE IdLanc='" + objAtivi.getIdLanc() + "'");
            pst.setInt(1, objAtivi.getIdInternoCrc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public void buscarAtividade(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATIVIDADESJURIDICOS "
                    + "WHERE DescricaoAtiv='" + desc + "'");
            conecta.rs.first();
            codAtividade = conecta.rs.getInt("IdAtiv");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar a atividade.\nERRO: " + ex);
        }
    }

    public List<ItensAtividadeJuridico> read() throws Exception {
        conecta.abrirConexao();
        List<ItensAtividadeJuridico> listaAtividadesRealizadas = new ArrayList<ItensAtividadeJuridico>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSATENDIMENTOJURI "
                    + "INNER JOIN ATIVIDADESJURIDICOS "
                    + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                    + "INNER JOIN ATENDIMENTOJURIDICO "
                    + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                    + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "' "
                    + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            while (conecta.rs.next()) {
                ItensAtividadeJuridico pDigital = new ItensAtividadeJuridico();
                pDigital.setIdAtiv(conecta.rs.getInt("IdAtiv"));
                pDigital.setDataItem(conecta.rs.getDate("DataItem"));
                pDigital.setDescricaoAtividade(conecta.rs.getString("DescricaoAtiv"));
                listaAtividadesRealizadas.add(pDigital);
                qtdAtividades++;
            }
            return listaAtividadesRealizadas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
