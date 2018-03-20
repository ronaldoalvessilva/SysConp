/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Prateleiras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePrateleiras {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Prateleiras objPrat = new Prateleiras();
    int codLocal, codCorredor;
    String statusLocal = "Ativo";
    String statusCorredor = "Ativo";

    public Prateleiras incluirPrateleiras(Prateleiras objPrat) {
        buscarLocal(objPrat.getDescricaoLocal());
        buscarCorredor(objPrat.getDescricaoCorredor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRATELEIRAS (StatusPrat,DescricaoPrat,IdLocal,IdCor) VALUES(?,?,?,?)");
            pst.setString(1, objPrat.getStatusPrat());
            pst.setString(2, objPrat.getDescricaoPrat());
            pst.setInt(3, codLocal);
            pst.setInt(4, codCorredor);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrat;
    }

    public Prateleiras alterarPrateleiras(Prateleiras objPrat) {
        buscarLocal(objPrat.getDescricaoLocal());
        buscarCorredor(objPrat.getDescricaoCorredor());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRATELEIRAS SET StatusPrat=?,DescricaoPrat=?,IdLocal=?,IdCor=? WHERE IdPrat='" + objPrat.getIdPrat() + "'");
            pst.setString(1, objPrat.getStatusPrat());
            pst.setString(2, objPrat.getDescricaoPrat());
            pst.setInt(3, codLocal);
            pst.setInt(4, codCorredor);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrat;
    }

    public Prateleiras excluirPrateleiras(Prateleiras objPrat) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRATELEIRAS WHERE IdPrat='" + objPrat.getIdPrat() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPrat;
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

    public void buscarCorredor(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CORREDORLOCAL WHERE DescricaoCor='" + desc + "'AND StatusCor='" + statusCorredor + "'");
            conecta.rs.first();
            codCorredor = conecta.rs.getInt("IdCor");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CORREDOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
