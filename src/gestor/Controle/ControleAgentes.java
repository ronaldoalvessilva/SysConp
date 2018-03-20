/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.MovimentoPopulacao;
import gestor.Modelo.PopAgentes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAgentes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PopAgentes objPopAgentes = new PopAgentes();
    MovimentoPopulacao objPopMov = new MovimentoPopulacao();

    public PopAgentes incluirPopAgentes(PopAgentes objPopAgentes) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPAGENTES (DataMov,IdPopMov,AgenteMasc,AgenteFem,Motoristas) VALUES(?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopAgentes.getDataMov().getTime()));
            pst.setInt(2, objPopAgentes.getIdAgente());
            pst.setInt(3, objPopAgentes.getAgenteMasc());
            pst.setInt(4, objPopAgentes.getAgenteFem());
            pst.setInt(5, objPopAgentes.getMotoristas());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopAgentes;
    }

    public PopAgentes alterarPopAgentes(PopAgentes objPopAgentes) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE POPAGENTES SET DataMov=?,IdPopMov=?,AgenteMasc=?,AgenteFem=?,Motoristas=? WHERE IdPopMov='" + objPopAgentes.getIdAgente() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopAgentes.getDataMov().getTime()));
            pst.setInt(2, objPopAgentes.getIdAgente());
            pst.setInt(3, objPopAgentes.getAgenteMasc());
            pst.setInt(4, objPopAgentes.getAgenteFem());
            pst.setInt(5, objPopAgentes.getMotoristas());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopAgentes;
    }

    public PopAgentes excluirPopAgentes(PopAgentes objPopAgentes) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPAGENTES WHERE IdPopMov='" + objPopAgentes.getIdAgente() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados (AGENTES)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopAgentes;
    }
}
