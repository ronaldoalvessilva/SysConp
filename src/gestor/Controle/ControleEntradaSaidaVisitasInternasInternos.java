/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaVisitasInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaSaidaVisitasInternasInternos {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVisitasInternos objEntSaiVisitasInterno = new EntradaSaidaVisitasInternos();

    public EntradaSaidaVisitasInternos incluirEntradaSaidaInternas(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_INTERNO_INTERNA(DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiVisitasInterno.getDataLanc().getTime()));
            pst.setString(2, objEntSaiVisitasInterno.getStatusLanc());
            pst.setString(3, objEntSaiVisitasInterno.getObsLanc());
            pst.setString(4, objEntSaiVisitasInterno.getUsuarioInsert());
            pst.setString(5, objEntSaiVisitasInterno.getDataInsert());
            pst.setString(6, objEntSaiVisitasInterno.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }

    public EntradaSaidaVisitasInternos alterarEntradaSaidaInternas(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_INTERNO_INTERNA SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiVisitasInterno.getDataLanc().getTime()));
            pst.setString(2, objEntSaiVisitasInterno.getStatusLanc());
            pst.setString(3, objEntSaiVisitasInterno.getObsLanc());
            pst.setString(4, objEntSaiVisitasInterno.getUsuarioUp());
            pst.setString(5, objEntSaiVisitasInterno.getDataUp());
            pst.setString(6, objEntSaiVisitasInterno.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }

    public EntradaSaidaVisitasInternos excluirEntradaSaidaInternas(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAS_INTERNO_INTERNA WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }

    public EntradaSaidaVisitasInternos finalizarEntradaSaidaInternas(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_INTERNO_INTERNA SET StatusLanc=? WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
            pst.setString(1, objEntSaiVisitasInterno.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }
}
