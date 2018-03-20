/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaAlbergados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaSaidaAlbergados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaAlbergados objEntSaiLabor = new EntradaSaidaAlbergados();    

    public EntradaSaidaAlbergados incluirEntSaiAlberg(EntradaSaidaAlbergados objEntSaiLabor) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADA_SAIDA_ALBERGADOS (StatusLanc,DataLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiLabor.getDataLanc().getTime()));           
            pst.setString(3, objEntSaiLabor.getObsLanc());
            pst.setString(4, objEntSaiLabor.getUsuarioInsert());
            pst.setString(5, objEntSaiLabor.getDataInsert());
            pst.setString(6, objEntSaiLabor.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaAlbergados alterarEntSaiAlberg(EntradaSaidaAlbergados objEntSaiLabor) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_ALBERGADOS SET StatusLanc=?,DataLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiLabor.getDataLanc().getTime()));            
            pst.setString(3, objEntSaiLabor.getObsLanc());
            pst.setString(4, objEntSaiLabor.getUsuarioUp());
            pst.setString(5, objEntSaiLabor.getDataUp());
            pst.setString(6, objEntSaiLabor.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaAlbergados excluirEntSaiAlberg(EntradaSaidaAlbergados objEntSaiLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADA_SAIDA_ALBERGADOS WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaAlbergados finalizarEntSaiAlberg(EntradaSaidaAlbergados objEntSaiLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADA_SAIDA_ALBERGADOS SET StatusLanc=? WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }    
}
