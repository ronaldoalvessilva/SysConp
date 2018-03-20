/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaVeiculosCarga;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntradaSaidaVeiculosCarga {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaVeiculosCarga objVeiCarga = new EntradaSaidaVeiculosCarga();
    int codVisita;
    int codVeiculo;

    public EntradaSaidaVeiculosCarga incluirEntVeiculoCarga(EntradaSaidaVeiculosCarga objVeiCarga) {
        buscarVisitante(objVeiCarga.getNomeVisita(), objVeiCarga.getIdVisita());
        buscarVeiculo(objVeiCarga.getModeloVeiculo(), objVeiCarga.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAVEICULOCARGA (StatusEnt,Datalanc,IdVisita,IdVeiculo,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objVeiCarga.getStatusEnt());
            pst.setTimestamp(2, new java.sql.Timestamp(objVeiCarga.getDataLanc().getTime()));
            pst.setInt(3, codVisita);
            pst.setInt(4, codVeiculo);
            pst.setString(5, objVeiCarga.getObservacao());
            pst.setString(6, objVeiCarga.getUsuarioInsert());
            pst.setString(7, objVeiCarga.getDataInsert());
            pst.setString(8, objVeiCarga.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeiCarga;
    }

    public EntradaSaidaVeiculosCarga alterarEntVeiculoCarga(EntradaSaidaVeiculosCarga objVeiCarga) {
        buscarVisitante(objVeiCarga.getNomeVisita(), objVeiCarga.getIdVisita());
        buscarVeiculo(objVeiCarga.getModeloVeiculo(), objVeiCarga.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOCARGA SET StatusEnt=?,Datalanc=?,IdVisita=?,IdVeiculo=?,Observacao=?, UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objVeiCarga.getIdLanc() + "'");
            pst.setString(1, objVeiCarga.getStatusEnt());
            pst.setTimestamp(2, new java.sql.Timestamp(objVeiCarga.getDataLanc().getTime()));
            pst.setInt(3, codVisita);
            pst.setInt(4, codVeiculo);
            pst.setString(5, objVeiCarga.getObservacao());
            pst.setString(6, objVeiCarga.getUsuarioUp());
            pst.setString(7, objVeiCarga.getDataUp());
            pst.setString(8, objVeiCarga.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeiCarga;
    }

    public EntradaSaidaVeiculosCarga excluirEntVeiculoCarga(EntradaSaidaVeiculosCarga objVeiCarga) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAVEICULOCARGA WHERE IdLanc='" + objVeiCarga.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeiCarga;
    }

    // Finalizar operação para evitar que seja alterado ou excluído
    public EntradaSaidaVeiculosCarga finalizarEntradaSaiFamiliar(EntradaSaidaVeiculosCarga objVeiCarga) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOCARGA SET StatusEnt=? WHERE IdLanc='" + objVeiCarga.getIdLanc() + "'");
            pst.setString(1, objVeiCarga.getStatusEnt());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeiCarga;
    }

    public void buscarVisitante(String desc, int codV) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS WHERE NomeVisita='" + desc + "'AND IdVisita='" + codV + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVeiculo(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VEICULOS WHERE ModeloVeiculo='" + desc + "'AND IdVeiculo='" + cod + "'");
            conecta.rs.first();
            codVeiculo = conecta.rs.getInt("IdVeiculo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VEICULO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
