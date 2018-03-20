/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Veiculos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVeiculos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Veiculos objVeic = new Veiculos();

    public Veiculos incluirVeiculos(Veiculos objVeic) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VEICULOS (DataCadastro,ModeloVeiculo,MarcaVeiculo,PlacaVeiculo,CidadeVeiculo,EstadoVeiculo,FotoFrente,FotoLadoEsquerdo,FotoLadoDireito,FotoFundo,UsuarioInsert,DataInsert,HorarioInsert,StatusVei) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objVeic.getDataCadastro().getTime()));
            pst.setString(2, objVeic.getModeloVeiculo());
            pst.setString(3, objVeic.getMarcaVeiculo());
            pst.setString(4, objVeic.getPlacaVeiculo());
            pst.setString(5, objVeic.getCidade());
            pst.setString(6, objVeic.getEstado());
            pst.setString(7, objVeic.getFotoFrente());
            if (objVeic.getFotoLadoDireito() == null) {
                pst.setString(8, null);
            } else {
                pst.setString(8, objVeic.getFotoLadoDireito());
            }
            if (objVeic.getFotoLadoEsquerdo() == null) {
                pst.setString(9, null);
            } else {
                pst.setString(9, objVeic.getFotoLadoEsquerdo());
            }
            if (objVeic.getFotoFundo() == null) {
                pst.setString(10, null);
            } else {
                pst.setString(10, objVeic.getFotoFundo());
            }
            pst.setString(11, objVeic.getUsuarioInsert());
            pst.setString(12, objVeic.getDataInsert());
            pst.setString(13, objVeic.getHoraInsert());
            pst.setString(14, objVeic.getStatusVei());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVeic;
    }

    public Veiculos alterarVeiculos(Veiculos objVeic) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VEICULOS SET DataCadastro=?,ModeloVeiculo=?,MarcaVeiculo=?,PlacaVeiculo=?,CidadeVeiculo=?,EstadoVeiculo=?,FotoFrente=?,FotoLadoEsquerdo=?,FotoLadoDireito=?,FotoFundo=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusVei=? WHERE IdVeiculo='" + objVeic.getIdVeiculo() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objVeic.getDataCadastro().getTime()));
            pst.setString(2, objVeic.getModeloVeiculo());
            pst.setString(3, objVeic.getMarcaVeiculo());
            pst.setString(3, objVeic.getMarcaVeiculo());
            pst.setString(4, objVeic.getPlacaVeiculo());
            pst.setString(5, objVeic.getCidade());
            pst.setString(6, objVeic.getEstado());
            pst.setString(7, objVeic.getFotoFrente());
            if (objVeic.getFotoLadoDireito() == null) {
                pst.setString(8, null);
            } else {
                pst.setString(8, objVeic.getFotoLadoDireito());
            }
            if (objVeic.getFotoLadoEsquerdo() == null) {
                pst.setString(9, null);
            } else {
                pst.setString(9, objVeic.getFotoLadoEsquerdo());
            }
            if (objVeic.getFotoFundo() == null) {
                pst.setString(10, null);
            } else {
                pst.setString(10, objVeic.getFotoFundo());
            }
            pst.setString(11, objVeic.getUsuarioInsert());
            pst.setString(12, objVeic.getDataInsert());
            pst.setString(13, objVeic.getHoraInsert());
            pst.setString(14, objVeic.getStatusVei());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeic;
    }

    public Veiculos excluirVeiculos(Veiculos objVeic) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOS WHERE IdVeiculo='" + objVeic.getIdVeiculo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objVeic;
    }
}
