/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ObjetosPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleObjetosPertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ObjetosPertences objObjetoPertence = new ObjetosPertences();

    public ObjetosPertences incluirObjetosPertences(ObjetosPertences objObjetoPertence) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OBJETOSPERTENCES (StatusLanc,DataLanc,Unidade,DescricaoObjeto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objObjetoPertence.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objObjetoPertence.getDataLanc().getTime()));
            pst.setString(3, objObjetoPertence.getUnidadeArmazenamento());
            pst.setString(4, objObjetoPertence.getDescricaoObjeto());
            pst.setString(5, objObjetoPertence.getUsuarioInsert());
            pst.setString(6, objObjetoPertence.getDataInsert());
            pst.setString(7, objObjetoPertence.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetoPertence;
    }

    public ObjetosPertences alterarObjetosPertences(ObjetosPertences objObjetoPertence) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OBJETOSPERTENCES SET StatusLanc=?,DataLanc=?,Unidade=?,DescricaoObjeto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objObjetoPertence.getIdLanc() + "'");
            pst.setString(1, objObjetoPertence.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objObjetoPertence.getDataLanc().getTime()));
            pst.setString(3, objObjetoPertence.getUnidadeArmazenamento());
            pst.setString(4, objObjetoPertence.getDescricaoObjeto());
            pst.setString(5, objObjetoPertence.getUsuarioUp());
            pst.setString(6, objObjetoPertence.getDataUp());
            pst.setString(7, objObjetoPertence.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetoPertence;
    }

    public ObjetosPertences excluirObjetosPertences(ObjetosPertences objObjetoPertence) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OBJETOSPERTENCES WHERE IdLanc='" + objObjetoPertence.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objObjetoPertence;
    }
}
