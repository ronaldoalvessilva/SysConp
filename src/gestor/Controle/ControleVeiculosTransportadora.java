/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VeiculosTransportadora;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVeiculosTransportadora {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VeiculosTransportadora objVeiTran = new VeiculosTransportadora();

    public VeiculosTransportadora incluirVeiculoTransportador(VeiculosTransportadora objVeiTran) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VEICULOS_TRANSPORTADORA (IdForn,Modelo,Marca,Placa1,Placa2,Cidade,Uf,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objVeiTran.getIdForn());
            pst.setString(2, objVeiTran.getModelo());
            pst.setString(3, objVeiTran.getMarca());
            pst.setString(4, objVeiTran.getPlaca1());
            pst.setString(5, objVeiTran.getPlaca2());
            pst.setString(6, objVeiTran.getCidade());
            pst.setString(7, objVeiTran.getEstado());                       
            pst.setString(8, objVeiTran.getUsuarioInsert());
            pst.setString(9, objVeiTran.getDataInsert());
            pst.setString(10, objVeiTran.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVeiTran;
    }

    public VeiculosTransportadora alterarVeiculoTtransportador(VeiculosTransportadora objVeiTran) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VEICULOS_TRANSPORTADORA SET IdForn=?,Modelo=?,Marca=?,Placa1=?,Placa2=?,Cidade=?,Uf=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdForn='" + objVeiTran.getIdForn() + "'");
            pst.setInt(1, objVeiTran.getIdForn());
            pst.setString(2, objVeiTran.getModelo());
            pst.setString(3, objVeiTran.getMarca());
            pst.setString(4, objVeiTran.getPlaca1());
            pst.setString(5, objVeiTran.getPlaca2());
            pst.setString(6, objVeiTran.getCidade());
            pst.setString(7, objVeiTran.getEstado());                       
            pst.setString(8, objVeiTran.getUsuarioUp());
            pst.setString(9, objVeiTran.getDataUp());
            pst.setString(10, objVeiTran.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVeiTran;
    }

    public VeiculosTransportadora excluirVeiculoTransportador(VeiculosTransportadora objVeiTran) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOS_TRANSPORTADORA WHERE IdForn='" + objVeiTran.getIdForn() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVeiTran;
    }
}
