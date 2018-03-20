/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaTecnicaReceitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleFichaTecnica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaTecnicaReceitas objFicha = new FichaTecnicaReceitas();
    int codCat;

    public FichaTecnicaReceitas incluirFichaTecnicaNUTRI(FichaTecnicaReceitas objFicha) {
        buscarCategoria(objFicha.getDescricaoCategoria());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_TECNICA_NUTRI (StatusFicha,DataFicha,DescricaoFicha,IdCat,Porcoes,FotoReceita,ModoFazer,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objFicha.getStatusFicha());
            pst.setTimestamp(2, new java.sql.Timestamp(objFicha.getDataFicha().getTime()));
            pst.setString(3, objFicha.getDescricaoFicha());
            pst.setInt(4, codCat);
            pst.setInt(5, objFicha.getPorcoes());
            pst.setString(6, objFicha.getCaminhoFoto());
            pst.setString(7, objFicha.getModoFazer());
            pst.setString(8, objFicha.getObservacao());
            pst.setString(9, objFicha.getUsuarioInsert());
            pst.setString(10, objFicha.getDataInsert());
            pst.setString(11, objFicha.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public FichaTecnicaReceitas alterarFichaTecnicaNUTRI(FichaTecnicaReceitas objFicha) {
        buscarCategoria(objFicha.getDescricaoCategoria());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_TECNICA_NUTRI SET StatusFicha=?,DataFicha=?,DescricaoFicha=?,IdCat=?,Porcoes=?,FotoReceita=?,ModoFazer=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFicha='" + objFicha.getIdFicha() + "'");
            pst.setString(1, objFicha.getStatusFicha());
             pst.setString(1, objFicha.getStatusFicha());
            pst.setTimestamp(2, new java.sql.Timestamp(objFicha.getDataFicha().getTime()));
            pst.setString(3, objFicha.getDescricaoFicha());
            pst.setInt(4, codCat);
            pst.setInt(5, objFicha.getPorcoes());
            pst.setString(6, objFicha.getCaminhoFoto());
            pst.setString(7, objFicha.getModoFazer());
            pst.setString(8, objFicha.getObservacao());
            pst.setString(9, objFicha.getUsuarioUp());
            pst.setString(10, objFicha.getDataUp());
            pst.setString(11, objFicha.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public FichaTecnicaReceitas excluirFichaTecnicaNUTRI(FichaTecnicaReceitas objFicha) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_TECNICA_NUTRI WHERE IdFicha='" + objFicha.getIdFicha() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFicha;
    }

    public void buscarCategoria(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CATEGORIA_RECEITAS_NUTRI WHERE DescricaoCategoria='" + desc + "'");
            conecta.rs.first();
            codCat = conecta.rs.getInt("IdCat");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o código da categoria.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
