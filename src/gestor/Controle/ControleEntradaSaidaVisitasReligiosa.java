/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaVisitasReligiosas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaSaidaVisitasReligiosa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVisitasReligiosas objEntSaiVisitasRel = new EntradaSaidaVisitasReligiosas();
    int codInstituicao;

    public EntradaSaidaVisitasReligiosas incluirEntSaiVisitasReligiosas(EntradaSaidaVisitasReligiosas objEntSaiVisitasRel) {
        buscarInstituicao(objEntSaiVisitasRel.getNomeInstituicao(), objEntSaiVisitasRel.getIdInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADA_SAIDA_VISITAS_RELIGIOSA (StatusLanc,DataLanc,IdCod,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objEntSaiVisitasRel.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiVisitasRel.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setString(4, objEntSaiVisitasRel.getObsLanc());
            pst.setString(5, objEntSaiVisitasRel.getUsuarioInsert());
            pst.setString(6, objEntSaiVisitasRel.getDataInsert());
            pst.setString(7, objEntSaiVisitasRel.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasRel;
    }

    public EntradaSaidaVisitasReligiosas alterarEntSaiVisitasReligiosas(EntradaSaidaVisitasReligiosas objEntSaiVisitasRel) {
        buscarInstituicao(objEntSaiVisitasRel.getNomeInstituicao(), objEntSaiVisitasRel.getIdInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_VISITAS_RELIGIOSA SET StatusLanc=?,DataLanc=?,IdCod=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEntSaiVisita='" + objEntSaiVisitasRel.getIdLanc() + "'");
            pst.setString(1, objEntSaiVisitasRel.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiVisitasRel.getDataLanc().getTime()));
            pst.setInt(3, codInstituicao);
            pst.setString(4, objEntSaiVisitasRel.getObsLanc());
            pst.setString(5, objEntSaiVisitasRel.getUsuarioUp());
            pst.setString(6, objEntSaiVisitasRel.getDataUp());
            pst.setString(7, objEntSaiVisitasRel.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasRel;
    }

    public EntradaSaidaVisitasReligiosas excluirEntSaiVisitasReligiosas(EntradaSaidaVisitasReligiosas objEntSaiVisitasRel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADA_SAIDA_VISITAS_RELIGIOSA WHERE IdEntSaiVisita='" + objEntSaiVisitasRel.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasRel;
    }

    public EntradaSaidaVisitasReligiosas finalizarEntSaiVisitasReligiosas(EntradaSaidaVisitasReligiosas objEntSaiVisitasRel) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_VISITAS_RELIGIOSA SET StatusLanc=? WHERE IdEntSaiVisita='" + objEntSaiVisitasRel.getIdLanc() + "'");
            pst.setString(1, objEntSaiVisitasRel.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasRel;
    }

    public void buscarInstituicao(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAO_RELIGIOSA WHERE NomeInstituicao='" + desc + "'AND IdCod='" + cod + "'");
            conecta.rs.first();
            codInstituicao = conecta.rs.getInt("IdCod");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INSTITUIÇÃO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
