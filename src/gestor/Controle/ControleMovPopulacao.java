/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MovimentoPopulacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovPopulacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovimentoPopulacao objPopMov = new MovimentoPopulacao();

    public MovimentoPopulacao incluirMovPop(MovimentoPopulacao objPopMov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVPOPULACAO (DataPopMov,StatusPop,TotalGeralAgentes,TotalGeralInternos,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopMov.getDataPopMov().getTime()));
            pst.setString(2, objPopMov.getStatusPop());
            pst.setInt(3, objPopMov.getTotalGeralAgentes());
            pst.setInt(4, objPopMov.getTotalGeralInternos());
            pst.setString(5, objPopMov.getUsuarioInsert());
            pst.setString(6, objPopMov.getDataInsert());
            pst.setString(7, objPopMov.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopMov;
    }

    public MovimentoPopulacao alterarMovPop(MovimentoPopulacao objPopMov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVPOPULACAO SET DataPopMov=?,StatusPop=?,TotalGeralAgentes=?,TotalGeralInternos=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPopMov='" + objPopMov.getIdPopMov() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopMov.getDataPopMov().getTime()));
            pst.setString(2, objPopMov.getStatusPop());
            pst.setInt(3, objPopMov.getTotalGeralAgentes());
            pst.setInt(4, objPopMov.getTotalGeralInternos());
            pst.setString(5, objPopMov.getUsuarioUp());
            pst.setString(6, objPopMov.getDataUp());
            pst.setString(7, objPopMov.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopMov;
    }

    public MovimentoPopulacao excluirMovPop(MovimentoPopulacao objPopMov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVPOPULACAO WHERE IdPopMov='" + objPopMov.getIdPopMov() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados (CABEÇALHO)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopMov;
    }

    public MovimentoPopulacao finalizarMovPop(MovimentoPopulacao objPopMov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVPOPULACAO SET StatusPop=? WHERE IdPopMov='" + objPopMov.getIdPopMov() + "'");
            pst.setString(1, objPopMov.getStatusPop());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopMov;
    }
}
