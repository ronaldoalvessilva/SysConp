/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesJuridicas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAtividadesJuridicas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesJuridicas objAtivJu = new AtividadesJuridicas();

    // Incluir Atividade
    public AtividadesJuridicas incluirAgendaEscolta(AtividadesJuridicas objAtivJu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADESJURIDICOS (StatusAtiv,DataAtiv,DescricaoAtiv,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objAtivJu.getStatusAtiv());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtivJu.getDataAtiv().getTime()));
            pst.setString(3, objAtivJu.getDescricaoAtiv());
            pst.setString(4, objAtivJu.getUsuarioInsert());
            pst.setString(5, objAtivJu.getDataInsert());
            pst.setString(6, objAtivJu.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtivJu;
    }
    public AtividadesJuridicas alterarAgendaEscolta(AtividadesJuridicas objAtivJu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADESJURIDICOS SET StatusAtiv=?,DataAtiv=?,DescricaoAtiv=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtiv='" + objAtivJu.getIdAtiv()  + "'");
            pst.setString(1, objAtivJu.getStatusAtiv());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtivJu.getDataAtiv().getTime()));
            pst.setString(3, objAtivJu.getDescricaoAtiv());
            pst.setString(4, objAtivJu.getUsuarioUp());
            pst.setString(5, objAtivJu.getDataUp());
            pst.setString(6, objAtivJu.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtivJu;
    }
     public AtividadesJuridicas excluirAgendaEscolta(AtividadesJuridicas objAtivJu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADESJURIDICOS WHERE IdAtiv='" + objAtivJu.getIdAtiv()  + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtivJu;
    }
}
