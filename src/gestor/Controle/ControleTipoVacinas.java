/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TipoExameMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleTipoVacinas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TipoExameMedico objTipoEx = new TipoExameMedico();

    public TipoExameMedico incluirTipoExame(TipoExameMedico objTipoEx) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TIPOS_VACINAS (StatusVacina,Classificacao,DescricaoVacina,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?)");
            pst.setString(1, objTipoEx.getStatusExame());
            pst.setString(2, objTipoEx.getClassificacao());
            pst.setString(3, objTipoEx.getDescricaoExame());
            pst.setString(4, objTipoEx.getUsuarioInsert());
            pst.setString(5, objTipoEx.getDataInsert());
            pst.setString(6, objTipoEx.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoEx;
    }

    public TipoExameMedico alterarTipoExame(TipoExameMedico objTipoEx) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TIPOS_VACINAS SET StatusVacina=?,Classificacao=?,DescricaoVacina=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdVacina='" + objTipoEx.getIdExame() + "'");
            pst.setString(1, objTipoEx.getStatusExame());
            pst.setString(2, objTipoEx.getClassificacao());
            pst.setString(3, objTipoEx.getDescricaoExame());
            pst.setString(4, objTipoEx.getUsuarioUp());
            pst.setString(5, objTipoEx.getDataUp());
            pst.setString(6, objTipoEx.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoEx;
    }

    public TipoExameMedico excluirTipoExame(TipoExameMedico objTipoEx) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TIPOS_VACINAS WHERE IdVacina='" + objTipoEx.getIdExame() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTipoEx;
    }
}
