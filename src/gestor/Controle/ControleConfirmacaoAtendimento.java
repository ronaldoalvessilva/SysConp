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
    String pCONCLUIDO = "Não";

    public RegistroAtendimentoInternos iniciarAtendimento(RegistroAtendimentoInternos objRegAtend) {
        pesquisaInternos(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        pesquisaDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTO_PSP_INTERNO_TV(StatusAtendimento,IdInternoCrc,IdDepartamento,IdRegistro,Atendendo,UsuarioAtendente,DataAtendimento,HorarioInicio,Concluido) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegAtend.getStatusAtendimento());
            pst.setInt(2, codInterno);
            pst.setInt(3, codDepto);
            pst.setInt(4, objRegAtend.getIdRegistro());
            pst.setString(5, objRegAtend.getAtendido());
            pst.setString(6, objRegAtend.getUsuarioAtendente());
            pst.setString(7, objRegAtend.getDataInsert());
            pst.setString(8, objRegAtend.getHorarioInsert());
            pst.setString(9, objRegAtend.getEmAtendimento());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR - ATENDIMENTO os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos confirmarAtendimento(RegistroAtendimentoInternos objRegAtend) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_PSP_INTERNO_TV SET StatusAtendimento=?,Concluido=?,HorarioTermino=?,IdAdentimento=?,TipoAtendimento=? WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc() + "'AND IdDepartamento='" + objRegAtend.getIdDepartamento() + "'AND Atendendo='" + pATENDENDO + "'AND Concluido='" + pCONCLUIDO + "'");
            pst.setString(1, objRegAtend.getStatusAtendimento());
            pst.setString(2, objRegAtend.getConcluido());
            pst.setString(3, objRegAtend.getHorarioUp());
            pst.setInt(4, objRegAtend.getIdAtend());
            pst.setString(5, objRegAtend.getTipoAtemdimento());
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
