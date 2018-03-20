/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AdmissaoPedagogica;
import gestor.Modelo.MovTecPedagogia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecPedagogia objMovTec = new MovTecPedagogia();
    AdmissaoPedagogica objAdmPedago = new AdmissaoPedagogica();
    String nomeOpeTecnica = "Atendimento do Interno na Pedagogia - (Admissão)";
    int codInt;

    // Incluir movimento do serviço social
    public AdmissaoPedagogica incluirMovTec(AdmissaoPedagogica objAdmPedago) {
        buscarInternoCrc(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmPedago.getIdAdm());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setString(5, objAdmPedago.getDeptoPedagogia());
            pst.setString(6, objAdmPedago.getStatusAdm());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    // Alterar movimento do serviço social 
    public AdmissaoPedagogica alterarMovTec(AdmissaoPedagogica objAdmPedago) {
        buscarInternoCrc(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAdmPedago.getIdAdm() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAdmPedago.getIdAdm());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setString(5, objAdmPedago.getDeptoPedagogia());
            pst.setString(6, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogica finalizarMovTec(AdmissaoPedagogica objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAdmPedago.getIdAdm() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    // Excluir movimento do serviço social 
    public AdmissaoPedagogica excluirMovTec(AdmissaoPedagogica objAdmPsi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAdmPsi.getIdAdm() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAdmPsi;
    }

    // Buscar o nome do interno
    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
