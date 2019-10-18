/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TipoTratamentoPsicologico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleTipoTraamentoPsicologia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TipoTratamentoPsicologico objTipo = new TipoTratamentoPsicologico();

    public TipoTratamentoPsicologico incluirTipoTratamento(TipoTratamentoPsicologico objTipo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TIPOS_TRATAMENTO_PSICOLOGICO (StatusTipo,DataTipo,DescricaoTipo,Texto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objTipo.getStatusTipo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTipo.getDataTipo().getTime()));
            pst.setString(3, objTipo.getDescricaoTipo());
            pst.setString(4, objTipo.getTexto());
            pst.setString(5, objTipo.getUsuarioInsert());
            pst.setString(6, objTipo.getDataInsert());
            pst.setString(7, objTipo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipo;
    }

    public TipoTratamentoPsicologico alterarTipoTratamento(TipoTratamentoPsicologico objTipo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TIPOS_TRATAMENTO_PSICOLOGICO SET StatusTipo=?,DataTipo=?,DescricaoTipo=?,Texto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTipo='" + objTipo.getIdTipo() + "'");
            pst.setString(1, objTipo.getStatusTipo());
            pst.setTimestamp(2, new java.sql.Timestamp(objTipo.getDataTipo().getTime()));
            pst.setString(3, objTipo.getDescricaoTipo());
            pst.setString(4, objTipo.getTexto());
            pst.setString(5, objTipo.getUsuarioUp());
            pst.setString(6, objTipo.getDataUp());
            pst.setString(7, objTipo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipo;
    }

    public TipoTratamentoPsicologico excluirTipoTratamento(TipoTratamentoPsicologico objTipo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TIPOS_TRATAMENTO_PSICOLOGICO WHERE IdTipo='" + objTipo.getIdTipo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipo;
    }

    public List<TipoTratamentoPsicologico> read() throws Exception {
        conecta.abrirConexao();
        List<TipoTratamentoPsicologico> listaInternosPavilhaoSelecionados = new ArrayList<TipoTratamentoPsicologico>();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_TRATAMENTO_PSICOLOGICO");
            while (conecta.rs.next()) {
                TipoTratamentoPsicologico pTipo = new TipoTratamentoPsicologico();
                pTipo.setIdTipo(conecta.rs.getInt("IdTipo"));
                pTipo.setDescricaoTipo(conecta.rs.getString("DescricaoTipo"));
                listaInternosPavilhaoSelecionados.add(pTipo);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleTipoTraamentoPsicologia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
