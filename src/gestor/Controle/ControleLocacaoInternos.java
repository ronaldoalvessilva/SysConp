/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LocacaoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleLocacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LocacaoInternos objLocaInt = new LocacaoInternos();
    int codCela;

    public LocacaoInternos incluirLocacaoInternos(LocacaoInternos objLocaInt) {
        buscarCela(objLocaInt.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCACAOINTERNO (StatusLoca,DataLanca,IdCela,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objLocaInt.getStatusLoca());
            pst.setTimestamp(2, new java.sql.Timestamp(objLocaInt.getDataLanca().getTime()));
            pst.setInt(3, codCela);
            pst.setString(4, objLocaInt.getObservacao());
            pst.setString(5, objLocaInt.getUsuarioInsert());
            pst.setString(6, objLocaInt.getDataInsert());
            pst.setString(7, objLocaInt.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objLocaInt;
    }

    public LocacaoInternos alterarLocacaoInternos(LocacaoInternos objLocaInt) {
        buscarCela(objLocaInt.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCACAOINTERNO SET StatusLoca=?,DataLanca=?,IdCela=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLoca='" + objLocaInt.getIdLoca() + "'");
            pst.setString(1, objLocaInt.getStatusLoca());
            pst.setTimestamp(2, new java.sql.Timestamp(objLocaInt.getDataLanca().getTime()));
            pst.setInt(3, codCela);
            pst.setString(4, objLocaInt.getObservacao());
            pst.setString(4, objLocaInt.getObservacao());
            pst.setString(5, objLocaInt.getUsuarioUp());
            pst.setString(6, objLocaInt.getDataUp());
            pst.setString(7, objLocaInt.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objLocaInt;
    }

    public LocacaoInternos excluirLocacaoInternos(LocacaoInternos objLocaInt) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCACAOINTERNO WHERE IdLoca='" + objLocaInt.getIdLoca() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objLocaInt;
    }

    public LocacaoInternos finalizarLocacaoInternos(LocacaoInternos objLocaInt) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCACAOINTERNO SET StatusLoca=? WHERE Idloca='" + objLocaInt.getIdLoca() + "'");
            pst.setString(1, objLocaInt.getStatusLoca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objLocaInt;
    }

    public void buscarCela(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + desc + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CELA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
