/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaVeiculoUnidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEntradaVeiculoUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaVeiculoUnidade objEntVeiUni = new EntradaVeiculoUnidade();

    public EntradaVeiculoUnidade incluirVeiculoUnidade(EntradaVeiculoUnidade objEntVeiUni) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAVEICULOSUNIDADE (StatusLanc,DataLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objEntVeiUni.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntVeiUni.getDataLanc().getTime()));            
            pst.setString(3, objEntVeiUni.getObsLanc());
            pst.setString(4, objEntVeiUni.getUsuarioInsert());
            pst.setString(5, objEntVeiUni.getDataInsert());
            pst.setString(6, objEntVeiUni.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntVeiUni;
    }
    public EntradaVeiculoUnidade alterarVeiculoUnidade(EntradaVeiculoUnidade objEntVeiUni) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusLanc=?,DataLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntVeiUni.getIdLanc()  + "'");
            pst.setString(1, objEntVeiUni.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntVeiUni.getDataLanc().getTime()));            
            pst.setString(3, objEntVeiUni.getObsLanc());
            pst.setString(4, objEntVeiUni.getUsuarioUp());
            pst.setString(5, objEntVeiUni.getDataUp());
            pst.setString(6, objEntVeiUni.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntVeiUni;
    }
    public EntradaVeiculoUnidade excluirVeiculoUnidade(EntradaVeiculoUnidade objEntVeiUni) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAVEICULOSUNIDADE WHERE IdLanc='" + objEntVeiUni.getIdLanc()  + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntVeiUni;
    }
    public EntradaVeiculoUnidade finalizarVeiculoUnidade(EntradaVeiculoUnidade objEntVeiUni) {

       conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusLanc=? WHERE IdLanc='" + objEntVeiUni.getIdLanc() + "'");
            pst.setString(1, objEntVeiUni.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntVeiUni;
    }
}
