/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InventarioEstoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleInventarioEstoque {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InventarioEstoque objInventEstoque = new InventarioEstoque();
    int codLocal;

    public InventarioEstoque incluirInventario(InventarioEstoque objInventEstoque) {
        buscarLocalArmazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INVENTARIO_FAR (StatusLanc,TipoInventario,IdLocal,Responsavel,DataInicio,DataTermino,HorarioInicio,HorarioTermino,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objInventEstoque.getStatusLanc());
            pst.setString(2, objInventEstoque.getTipoInventario());
            pst.setInt(3, codLocal);
            pst.setString(4, objInventEstoque.getResponsavel());
            pst.setTimestamp(5, new java.sql.Timestamp(objInventEstoque.getDataInicio().getTime()));
            if (objInventEstoque.getDataTermino() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objInventEstoque.getHorarioInicio());
            pst.setString(8, objInventEstoque.getHorarioTermino());
            pst.setString(9, objInventEstoque.getObservacao());
            pst.setString(10, objInventEstoque.getUsuarioInsert());
            pst.setString(11, objInventEstoque.getDataInsert());
            pst.setString(12, objInventEstoque.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioEstoque alterarInventario(InventarioEstoque objInventEstoque) {
        buscarLocalArmazenamento(objInventEstoque.getNomeLocalArmazenamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_FAR SET StatusLanc=?,TipoInventario=?,IdLocal=?,Responsavel=?,DataInicio=?,DataTermino=?,HorarioInicio=?,HorarioTermino=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.setString(1, objInventEstoque.getStatusLanc());
            pst.setString(2, objInventEstoque.getTipoInventario());
            pst.setInt(3, codLocal);
            pst.setString(4, objInventEstoque.getResponsavel());
            pst.setTimestamp(5, new java.sql.Timestamp(objInventEstoque.getDataInicio().getTime()));
            if (objInventEstoque.getDataTermino() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objInventEstoque.getHorarioInicio());
            pst.setString(8, objInventEstoque.getHorarioTermino());
            pst.setString(9, objInventEstoque.getObservacao());
            pst.setString(10, objInventEstoque.getUsuarioUp());
            pst.setString(11, objInventEstoque.getDataUp());
            pst.setString(12, objInventEstoque.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioEstoque excluirInventario(InventarioEstoque objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INVENTARIO_FAR WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public InventarioEstoque efetivarInventario(InventarioEstoque objInventEstoque) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_FAR SET StatusLanc=?,DataTermino=?,HorarioTermino=? WHERE IdLanc='" + objInventEstoque.getIdLanc() + "'");
            pst.setString(1, objInventEstoque.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objInventEstoque.getDataTermino().getTime()));
            pst.setString(3, objInventEstoque.getHorarioTermino());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EFETIVA essse inventário.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objInventEstoque;
    }

    public void buscarLocalArmazenamento(String nomeLocal) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nomeLocal + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar código do local de armazenamento.\nERRO :" + ex);
        }
    }
}
