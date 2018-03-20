/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaLaborInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaSaidaLaborInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaLaborInterno objEntSaiLabor = new EntradaSaidaLaborInterno();
    int codEmpresa;
    String StatusEmp = "Ativo";

    public EntradaSaidaLaborInterno incluirEntSaiLabor(EntradaSaidaLaborInterno objEntSaiLabor) {
        buscarEmpresa(objEntSaiLabor.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADALABORINTERNO (StatusLanc,DataLanc,IdEmp,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiLabor.getDataLanc().getTime()));
            pst.setInt(3, codEmpresa);
            pst.setString(4, objEntSaiLabor.getObsLanc());
            pst.setString(5, objEntSaiLabor.getUsuarioInsert());
            pst.setString(6, objEntSaiLabor.getDataInsert());
            pst.setString(7, objEntSaiLabor.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaLaborInterno alterarEntSaiLabor(EntradaSaidaLaborInterno objEntSaiLabor) {
        buscarEmpresa(objEntSaiLabor.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=?,DataLanc=?,IdEmp=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntSaiLabor.getDataLanc().getTime()));
            pst.setInt(3, codEmpresa);
            pst.setString(4, objEntSaiLabor.getObsLanc());
            pst.setString(5, objEntSaiLabor.getUsuarioUp());
            pst.setString(6, objEntSaiLabor.getDataUp());
            pst.setString(7, objEntSaiLabor.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaLaborInterno excluirEntSaiLabor(EntradaSaidaLaborInterno objEntSaiLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADALABORINTERNO WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public EntradaSaidaLaborInterno finalizarEntSaiLabor(EntradaSaidaLaborInterno objEntSaiLabor) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=? WHERE IdLanc='" + objEntSaiLabor.getIdLanc() + "'");
            pst.setString(1, objEntSaiLabor.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiLabor;
    }

    public void buscarEmpresa(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESALAB INNER JOIN AGENDALABORATIVA ON EMPRESALAB.IdEmp=AGENDALABORATIVA.IdEmp WHERE RazaoSocial='" + desc + "'");
            conecta.rs.first();
            codEmpresa = conecta.rs.getInt("IdEmp");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar a empresa, talvez ela esteja inativa." + e);
        }
        conecta.desconecta();
    }
}
