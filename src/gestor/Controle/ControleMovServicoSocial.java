/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoServicoSocial;
import gestor.Modelo.MovTecnicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleMovServicoSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    MovTecnicoSocial objMovTec = new MovTecnicoSocial();
    AtendimentoServicoSocial objAtendSocial = new AtendimentoServicoSocial();
    String nomeOpeTecnica = "Admissão no Serviço Social";
    int codInt;

    // Incluir movimento do serviço social
    public AtendimentoServicoSocial incluirMovTec(AtendimentoServicoSocial objAtendSocial) {
        buscarInternoCrc(objAtendSocial.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtendSocial.getIdAtend());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setString(5, objAtendSocial.getDeptoSocial());
            pst.setString(6, objAtendSocial.getStatusAtend());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Alterar movimento do serviço social 
    public AtendimentoServicoSocial alterarMovTec(AtendimentoServicoSocial objAtendSocial) {
        buscarInternoCrc(objAtendSocial.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? WHERE IdAtend='" + objAtendSocial.getIdAtend() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objAtendSocial.getIdAtend());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setString(5, objAtendSocial.getDeptoSocial());
            pst.setString(6, objAtendSocial.getStatusAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    public AtendimentoServicoSocial finalizarMovTec(AtendimentoServicoSocial objAtendSocial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? WHERE IdAtend='" + objAtendSocial.getIdAtend() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAtendSocial.getStatusAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Excluir movimento do serviço social 
    public AtendimentoServicoSocial excluirMovTec(AtendimentoServicoSocial objAtendSocial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO WHERE IdAtend='" + objAtendSocial.getIdAtend() + "' AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Buscar o nome do interno
    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
