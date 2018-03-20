/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CorredorLocal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleCorredorLocal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CorredorLocal objCorredorLocal = new CorredorLocal();
    int codLocal;
    String statusLocal = "Ativo";

    public CorredorLocal incluirCorredorLocal(CorredorLocal objCorredorLocal) {
        buscarLocal(objCorredorLocal.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CORREDORLOCAL (StatusCor,DescricaoCor,IdLocal) VALUES(?,?,?)");
            pst.setString(1, objCorredorLocal.getStatusCor());
            pst.setString(2, objCorredorLocal.getDescricaoCor());
            pst.setInt(3, codLocal);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCorredorLocal;
    }

    public CorredorLocal alterarCorredorLocal(CorredorLocal objCorredorLocal) {
        buscarLocal(objCorredorLocal.getNomeLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CORREDORLOCAL SET StatusCor=?,DescricaoCor=?,IdLocal=? WHERE IdCor='" + objCorredorLocal.getIdCor() + "'");
            pst.setString(1, objCorredorLocal.getStatusCor());
            pst.setString(2, objCorredorLocal.getDescricaoCor());
            pst.setInt(3, codLocal);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCorredorLocal;
    }

    public CorredorLocal excluirCorredorLocal(CorredorLocal objCorredorLocal) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CORREDORLOCAL WHERE IdCor='" + objCorredorLocal.getIdCor() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objCorredorLocal;
    }

    public void buscarLocal(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCALARMAZENAMENTO WHERE DescricaoLocal='" + desc + "'AND StatusLocal='" + statusLocal + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (LOCAL) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
