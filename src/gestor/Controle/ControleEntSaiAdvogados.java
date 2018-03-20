/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaAdvogados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntSaiAdvogados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaAdvogados objEntSaiAd = new EntradaSaidaAdvogados();

    public EntradaSaidaAdvogados incluirEntAdvogado(EntradaSaidaAdvogados objEntSaiAd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADASADVOGADOS (DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAd.getDataLanc().getTime()));
            pst.setString(2, objEntSaiAd.getStatusLanc());
            pst.setString(3, objEntSaiAd.getObsLanc());
            pst.setString(4, objEntSaiAd.getUsuarioInsert());
            pst.setString(5, objEntSaiAd.getDataInsert());
            pst.setString(6, objEntSaiAd.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAd;
    }

    public EntradaSaidaAdvogados alterarEntAdvogado(EntradaSaidaAdvogados objEntSaiAd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVOGADOS SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiAd.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAd.getDataLanc().getTime()));
            pst.setString(2, objEntSaiAd.getStatusLanc());
            pst.setString(3, objEntSaiAd.getObsLanc());
            pst.setString(4, objEntSaiAd.getUsuarioUp());
            pst.setString(5, objEntSaiAd.getDataUp());
            pst.setString(6, objEntSaiAd.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAd;
    }

    public EntradaSaidaAdvogados excluirEntAdvogado(EntradaSaidaAdvogados objEntSaiAd) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADASADVOGADOS WHERE IdLanc='" + objEntSaiAd.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAd;
    }

    public EntradaSaidaAdvogados finalizarEntradaSaiVisitas(EntradaSaidaAdvogados objEntSaiAd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVOGADOS SET StatusLanc=? WHERE IdLanc='" + objEntSaiAd.getIdLanc() + "'");
            pst.setString(1, objEntSaiAd.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAd;
    }
}
