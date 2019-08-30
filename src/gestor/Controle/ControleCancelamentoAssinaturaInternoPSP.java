/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CancelamentoAssinaturaInternoPSP;
import gestor.Modelo.RegistroAtendimentoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleCancelamentoAssinaturaInternoPSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CancelamentoAssinaturaInternoPSP objCancela = new CancelamentoAssinaturaInternoPSP();

    int codInt;
    int codDpto;

    public CancelamentoAssinaturaInternoPSP incluirRegistroCancelamento(CancelamentoAssinaturaInternoPSP objCancela) {

        buscarInternoCrc(objCancela.getNomeInterno(), objCancela.getIdInternoCrc());
        buscarDepartamento(objCancela.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ELIMIAR_ASSINATURA_INTERNO_PSP (StatusCancelamento,DataCancelamento,IdInternoCrc,IdDepartamento,IdRegistro,UsuarioAtendente,DataRegistro,Horario,TipoAtendimento,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCancela.getStatusCancelamento());
            pst.setTimestamp(2, new java.sql.Timestamp(objCancela.getDataCancelamento().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, codDpto);
            pst.setInt(5, objCancela.getIdRegistro());
            pst.setString(6, objCancela.getUsuarioAtendente());
            pst.setTimestamp(7, new java.sql.Timestamp(objCancela.getDataRegistro().getTime()));
            pst.setString(8, objCancela.getHorario());
            pst.setString(9, objCancela.getTipoAtendimento());
            pst.setString(10, objCancela.getMotivo());
            pst.setString(11, objCancela.getUsuarioInsert());
            pst.setString(12, objCancela.getDataInsert());
            pst.setString(13, objCancela.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancela;
    }

    public CancelamentoAssinaturaInternoPSP excluirAssinaturaInternoPSP(CancelamentoAssinaturaInternoPSP objCancela) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdRegistro='" + objCancela.getIdRegistro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR registro assinatura de Interno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancela;
    }

    public CancelamentoAssinaturaInternoPSP excluirRegistroCancelamento(CancelamentoAssinaturaInternoPSP objCancela) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ELIMIAR_ASSINATURA_INTERNO_PSP WHERE IdCancel='" + objCancela.getIdCancel() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCancela;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDpto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DEPARTAMENTOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
