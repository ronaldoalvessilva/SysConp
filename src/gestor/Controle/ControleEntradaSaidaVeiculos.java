/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaVeiculos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaSaidaVeiculos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVeiculos objEntSaiVei = new EntradaSaidaVeiculos();

    public EntradaSaidaVeiculos incluirVeiculosTerceiros(EntradaSaidaVeiculos objEntSaiVei) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAVEICULOSTERCEIRO (StatusLanc,Datalanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objEntSaiVei.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiVei.getDataLanc().getTime()));            
            pst.setString(3, objEntSaiVei.getObsLanc());
            pst.setString(4, objEntSaiVei.getUsuarioInsert());
            pst.setString(5, objEntSaiVei.getDataInsert());
            pst.setString(6, objEntSaiVei.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVei;
    }
    public EntradaSaidaVeiculos alterarVeiculosTerceiros(EntradaSaidaVeiculos objEntSaiVei) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusLanc=?,Datalanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Idlanc='" + objEntSaiVei.getIdLanc() + "'");
            pst.setString(1, objEntSaiVei.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiVei.getDataLanc().getTime()));            
            pst.setString(3, objEntSaiVei.getObsLanc());
            pst.setString(4, objEntSaiVei.getUsuarioUp());
            pst.setString(5, objEntSaiVei.getDataUp());
            pst.setString(6, objEntSaiVei.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVei;
    }
    public EntradaSaidaVeiculos excluirVeiculosTerceiros(EntradaSaidaVeiculos objEntSaiVei) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAVEICULOSTERCEIRO WHERE Idlanc='" + objEntSaiVei.getIdLanc() + "'");          
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVei;
    }
    public EntradaSaidaVeiculos finalizarVeiculosTerceiros(EntradaSaidaVeiculos objEntSaiVei) {

        conecta.abrirConexao();
        try {
           
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusLanc=? WHERE IdLanc='" + objEntSaiVei.getIdLanc() + "'");
            pst.setString(1, objEntSaiVei.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVei;
    }
}
