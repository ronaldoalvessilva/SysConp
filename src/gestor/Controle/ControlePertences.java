/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Pertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlePertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Pertences objPer = new Pertences();

    public Pertences incluirPertences(Pertences objPer) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PERTENCES (StatusLanc,DataCadastro,DescricaoPertence,FotoPertence,Unidade,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objPer.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPer.getDataCadastro().getTime()));
            pst.setString(3, objPer.getDescricaoPertence());
            pst.setString(4, objPer.getFotoPertence());
            pst.setString(5, objPer.getUnidade());
            pst.setString(6, objPer.getUsuarioInsert());
            pst.setString(7, objPer.getDataInsert());
            pst.setString(8, objPer.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPer;
    }

    public Pertences alterarPertences(Pertences objPer) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERTENCES SET StatusLanc=?,DataCadastro=?,DescricaoPertence=?,FotoPertence=?,Unidade=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPertence='" + objPer.getIdPertence() + "'");
            pst.setString(1, objPer.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPer.getDataCadastro().getTime()));
            pst.setString(3, objPer.getDescricaoPertence());
            pst.setString(4, objPer.getFotoPertence());
            pst.setString(5, objPer.getUnidade());
            pst.setString(6, objPer.getUsuarioInsert());
            pst.setString(7, objPer.getDataInsert());
            pst.setString(8, objPer.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPer;
    }

    public Pertences excluirPertences(Pertences objPer) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PERTENCES WHERE IdPertence='" + objPer.getIdPertence() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPer;
    }
}
