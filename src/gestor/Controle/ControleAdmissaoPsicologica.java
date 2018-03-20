/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPedagogica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAdmissaoPsicologica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPedagogica objAdmPedago = new AdmissaoPedagogica();
    int idCod;

    public AdmissaoPedagogica incluirAdmissaoEscolar(AdmissaoPedagogica objAdmPedago) {
        buscarInterno(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_PEDAGOGIA (StatusAdm,DataAdm,IdInternoCrc,UltimaEscola,SerieAno,Turno,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setInt(3, idCod);
            pst.setString(4, objAdmPedago.getUltimaEscola());
            pst.setString(5, objAdmPedago.getSerieAno());
            pst.setString(6, objAdmPedago.getTurno());
            pst.setString(7, objAdmPedago.getObservacao());
            pst.setString(8, objAdmPedago.getUsuarioInsert());
            pst.setString(9, objAdmPedago.getDataInsert());
            pst.setString(10, objAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogica alterarAdmissaoEscolar(AdmissaoPedagogica objAdmPedago) {
        buscarInterno(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA SET StatusAdm=?,DataAdm=?,IdInternoCrc=?,UltimaEscola=?,SerieAno=?,Turno=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAdm='" + objAdmPedago.getIdAdm() + "'");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.setTimestamp(2, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setInt(3, idCod);
            pst.setString(4, objAdmPedago.getUltimaEscola());
            pst.setString(5, objAdmPedago.getSerieAno());
            pst.setString(6, objAdmPedago.getTurno());
            pst.setString(7, objAdmPedago.getObservacao());
            pst.setString(8, objAdmPedago.getUsuarioUp());
            pst.setString(9, objAdmPedago.getDataUp());
            pst.setString(10, objAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogica excluirAdmissaoEscolar(AdmissaoPedagogica objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_PEDAGOGIA WHERE IdAdm='" + objAdmPedago.getIdAdm() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogica finalizarAdmissaoEscolar(AdmissaoPedagogica objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA SET StatusAdm=? WHERE IdAdm='" + objAdmPedago.getIdAdm() + "'");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR o registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
