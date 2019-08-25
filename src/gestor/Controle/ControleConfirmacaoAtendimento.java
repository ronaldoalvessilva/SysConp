/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroAtendimentoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleConfirmacaoAtendimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    int codInterno;
    int codDepto;
    String pATENDENDO = "Sim";

    public RegistroAtendimentoInternos iniciarAtendimento(RegistroAtendimentoInternos objRegAtend) {
        pesquisaInternos(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        pesquisaDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTO_PSP_INTERNO_TV(IdInternoCrc,IdDepartamento,IdRegistro,Atendendo,UsuarioAtendente,DataAtendimento,HorarioInicio,Concluido) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, codDepto);
            pst.setInt(3, objRegAtend.getIdRegistro());
            pst.setString(4, objRegAtend.getAtendido());
            pst.setString(5, objRegAtend.getUsuarioAtendente());
            pst.setString(6, objRegAtend.getDataInsert());
            pst.setString(7, objRegAtend.getHorarioInsert());
            pst.setString(8, objRegAtend.getEmAtendimento());            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR - ATENDIMENTO os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos confirmarAtendimento(RegistroAtendimentoInternos objRegAtend) {
        pesquisaInternos(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        pesquisaDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_PSP_INTERNO_TV SET Concluido=?,HorarioTermino=?,IdAdentimento=?,TipoAtendimento=? WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc()+ "'AND IdDepartamento='" + objRegAtend.getIdDepartamento() + "'AND Atendendo='" + pATENDENDO + "'");
            pst.setString(1, objRegAtend.getConcluido());
            pst.setString(2, objRegAtend.getHorarioUp());
            pst.setInt(3, objRegAtend.getIdAtend());
            pst.setString(4, objRegAtend.getTipoAtemdimento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }
     public RegistroAtendimentoInternos excluirAtendimento(RegistroAtendimentoInternos objRegAtend) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTO_PSP_INTERNO_TV WHERE IdAPIT='" + objRegAtend.getIdAPIT() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public void pesquisaInternos(String nome, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisaDepartamento(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + desc + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
