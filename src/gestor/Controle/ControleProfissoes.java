/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Profissoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleProfissoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Profissoes objProf = new Profissoes();

    public Profissoes incluirProfissao(Profissoes objProf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROFISSAO (StatusProf,DescricaoProf,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setString(1, objProf.getStatusProf());
            pst.setString(2, objProf.getDescricaoProf());
            pst.setString(3, objProf.getUsuarioInsert());
            pst.setString(4, objProf.getDataInsert());
            pst.setString(5, objProf.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Profissoes alterarProfissao(Profissoes objProf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROFISSAO SET StatusProf=?,DescricaoProf=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCodigoProf='" + objProf.getIdCodigo() + "'");
            pst.setString(1, objProf.getStatusProf());
            pst.setString(2, objProf.getDescricaoProf());
            pst.setString(3, objProf.getUsuarioUp());
            pst.setString(4, objProf.getDataUp());
            pst.setString(5, objProf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Profissoes excluirProfissao(Profissoes objProf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROFISSAO WHERE IdCodigoProf='" + objProf.getIdCodigo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProf;
    }
}
