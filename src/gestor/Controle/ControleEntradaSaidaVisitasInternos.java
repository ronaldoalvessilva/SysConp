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
 * @author user
 */
public class ControleEntradaSaidaVisitasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVisitasInternos objEntSaiVisitasInterno = new EntradaSaidaVisitasInternos();

    public EntradaSaidaVisitasInternos incluirEntradaSaiFamiliar(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADASFAMILIAR(DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
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

    public EntradaSaidaVisitasInternos alterarEntradaSaiFamiliar(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFAMILIAR SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
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

    public EntradaSaidaVisitasInternos excluirEntradaSaiFamiliar(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADASFAMILIAR WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }

    public EntradaSaidaVisitasInternos finalizarEntradaSaiFamiliar(EntradaSaidaVisitasInternos objEntSaiVisitasInterno) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFAMILIAR SET StatusLanc=? WHERE IdLanc='" + objEntSaiVisitasInterno.getIdLanc() + "'");
            pst.setString(1, objEntSaiVisitasInterno.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasInterno;
    }
}
