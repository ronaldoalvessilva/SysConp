/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaVisitasDiversas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaSaidaVisitasDiversas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVisitasDiversas objEntSaiVisitas = new EntradaSaidaVisitasDiversas();

    public EntradaSaidaVisitasDiversas incluirEntradaSaiVisitas(EntradaSaidaVisitasDiversas objEntSaiVisitas) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADASVISITAS (DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiVisitas.getDataLanc().getTime()));
            pst.setString(2, objEntSaiVisitas.getStatusLanc());
            pst.setString(3, objEntSaiVisitas.getObsLanc());
            pst.setString(4, objEntSaiVisitas.getUsuarioInsert());
            pst.setString(5, objEntSaiVisitas.getDataInsert());
            pst.setString(6, objEntSaiVisitas.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitas;
    }

    public EntradaSaidaVisitasDiversas alterarEntradaSaiVisitas(EntradaSaidaVisitasDiversas objEntSaiVisitas) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASVISITAS SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiVisitas.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiVisitas.getDataLanc().getTime()));
            pst.setString(2, objEntSaiVisitas.getStatusLanc());
            pst.setString(3, objEntSaiVisitas.getObsLanc());
            pst.setString(4, objEntSaiVisitas.getUsuarioUp());
            pst.setString(5, objEntSaiVisitas.getDataUp());
            pst.setString(6, objEntSaiVisitas.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitas;
    }

    public EntradaSaidaVisitasDiversas excluirEntradaSaiVisitas(EntradaSaidaVisitasDiversas objEntSaiVisitas) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADASVISITAS WHERE IdLanc='" + objEntSaiVisitas.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitas;
    }

    public EntradaSaidaVisitasDiversas finalizarEntradaSaiVisitas(EntradaSaidaVisitasDiversas objEntSaiVisitas) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASVISITAS SET StatusLanc=? WHERE IdLanc='" + objEntSaiVisitas.getIdLanc() + "'");
            pst.setString(1, objEntSaiVisitas.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitas;
    }
}
