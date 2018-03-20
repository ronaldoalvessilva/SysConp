/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaFunc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntSaidFunc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaFunc objEntSaiFunc = new EntradaSaidaFunc();

    public EntradaSaidaFunc incluirEntradaSaiFunc(EntradaSaidaFunc objEntSaiFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADASFUNC (DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiFunc.getDataLanc().getTime()));
            pst.setString(2, objEntSaiFunc.getStatusLanc());
            pst.setString(3, objEntSaiFunc.getObsLanc());
            pst.setString(4, objEntSaiFunc.getUsuarioInsert());
            pst.setString(5, objEntSaiFunc.getDataInsert());
            pst.setString(6, objEntSaiFunc.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiFunc;
    }

    public EntradaSaidaFunc alterarEntradaSaiFunc(EntradaSaidaFunc objEntSaiFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFUNC SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiFunc.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiFunc.getDataLanc().getTime()));
            pst.setString(2, objEntSaiFunc.getStatusLanc());
            pst.setString(3, objEntSaiFunc.getObsLanc());
            pst.setString(4, objEntSaiFunc.getUsuarioUp());
            pst.setString(5, objEntSaiFunc.getDataUp());
            pst.setString(6, objEntSaiFunc.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiFunc;
    }

    public EntradaSaidaFunc excluirEntradaSaiFunc(EntradaSaidaFunc objEntSaiFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADASFUNC WHERE IdLanc='" + objEntSaiFunc.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiFunc;
    }
     public EntradaSaidaFunc finalizarEntradaSaiVisitas(EntradaSaidaFunc objEntSaiFunc) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFUNC SET StatusLanc=? WHERE IdLanc='" + objEntSaiFunc.getIdLanc() + "'");
            pst.setString(1, objEntSaiFunc.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiFunc;
    }
}
