/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaVeiculos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntradaSaidaVeiculos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVeiculos objItensVeiculosTer = new ItensEntradaSaidaVeiculos();
    int codVisita;
    int codVeiculo;

    public ItensEntradaSaidaVeiculos incluirItensVeiculo(ItensEntradaSaidaVeiculos objItensVeiculosTer) {

        buscarVisita(objItensVeiculosTer.getNomeVisita(), objItensVeiculosTer.getIdVisita());
        buscarVeiculo(objItensVeiculosTer.getModeloVeiculo(), objItensVeiculosTer.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVEICULOSTERCEIRO (IdVisita,Idlanc,IdVeiculo,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,OrigemEntrada,DestinoEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codVisita);
            pst.setInt(2, objItensVeiculosTer.getIdlanc());
            pst.setInt(3, codVeiculo);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVeiculosTer.getDataEntrada().getTime()));
            pst.setString(5, objItensVeiculosTer.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensVeiculosTer.getDataSaida().getTime()));
            pst.setString(7, objItensVeiculosTer.getHorarioSaida());
            pst.setString(8, objItensVeiculosTer.getOrigemEntrada());
            pst.setString(9, objItensVeiculosTer.getDestinoEntrada());
            pst.setString(10, objItensVeiculosTer.getUsuarioInsert());
            pst.setString(11, objItensVeiculosTer.getDataInsert());
            pst.setString(12, objItensVeiculosTer.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiculosTer;
    }

    public ItensEntradaSaidaVeiculos alterarItensVeiculo(ItensEntradaSaidaVeiculos objItensVeiculosTer) {

        buscarVisita(objItensVeiculosTer.getNomeVisita(), objItensVeiculosTer.getIdVisita());
        buscarVeiculo(objItensVeiculosTer.getModeloVeiculo(), objItensVeiculosTer.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSVEICULOSTERCEIRO SET IdVisita=?,Idlanc=?,IdVeiculo=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,OrigemEntrada=?,DestinoEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Iditem='" + objItensVeiculosTer.getIdItem() + "'");
            pst.setInt(1, codVisita);
            pst.setInt(2, objItensVeiculosTer.getIdlanc());
            pst.setInt(3, codVeiculo);
            pst.setTimestamp(4, new java.sql.Timestamp(objItensVeiculosTer.getDataEntrada().getTime()));
            pst.setString(5, objItensVeiculosTer.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objItensVeiculosTer.getDataSaida().getTime()));
            pst.setString(7, objItensVeiculosTer.getHorarioSaida());
            pst.setString(8, objItensVeiculosTer.getOrigemEntrada());
            pst.setString(9, objItensVeiculosTer.getDestinoEntrada());
            pst.setString(10, objItensVeiculosTer.getUsuarioUp());
            pst.setString(11, objItensVeiculosTer.getDataUp());
            pst.setString(12, objItensVeiculosTer.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiculosTer;
    }

    public ItensEntradaSaidaVeiculos excluirItensVeiculo(ItensEntradaSaidaVeiculos objItensVeiculosTer) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSVEICULOSTERCEIRO WHERE Iditem='" + objItensVeiculosTer.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiculosTer;
    }

    public void buscarVisita(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE NomeVisita='" + desc + "'AND IdVisita='" + codigo + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVeiculo(String desc, int codVei) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VEICULOS WHERE ModeloVeiculo='" + desc + "'AND IdVeiculo='" + codVei + "'");
            conecta.rs.first();
            codVeiculo = conecta.rs.getInt("IdVeiculo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VEICULO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
