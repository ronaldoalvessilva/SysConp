/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CapacitacaoInternoTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleCapacitacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CapacitacaoInternoTO objCap = new CapacitacaoInternoTO();
    int codigoCurso;
    int codigoInterno;

    public CapacitacaoInternoTO incluirCapacitacao(CapacitacaoInternoTO objCap) {
        buscarCurso(objCap.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CAPACITACAO_INTERNO_TO (DataRegistro,StatusRegistro,IdCurso,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objCap.getDataRegistro().getTime()));
            pst.setString(2, objCap.getStatusRegistro());
            pst.setInt(3, codigoCurso);
            pst.setString(4, objCap.getObservacao());
            pst.setString(5, objCap.getUsuarioInsert());
            pst.setString(6, objCap.getDataInsert());
            pst.setString(7, objCap.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public CapacitacaoInternoTO alterarCapacitacao(CapacitacaoInternoTO objCap) {
        buscarCurso(objCap.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CAPACITACAO_INTERNO_TO SET DataRegistro=?,StatusRegistro=?,IdCurso=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCap='" + objCap.getIdCap() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objCap.getDataRegistro().getTime()));
            pst.setString(2, objCap.getStatusRegistro());
            pst.setInt(3, codigoCurso);
            pst.setString(4, objCap.getObservacao());
            pst.setString(5, objCap.getUsuarioUp());
            pst.setString(6, objCap.getDataUp());
            pst.setString(7, objCap.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public CapacitacaoInternoTO excluirCapacitacao(CapacitacaoInternoTO objCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CAPACITACAO_INTERNO_TO WHERE IdCap='" + objCap.getIdCap() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public CapacitacaoInternoTO finalizarCapacitacao(CapacitacaoInternoTO objCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CAPACITACAO_INTERNO_TO SET StatusRegistro=? WHERE IdCap='" + objCap.getIdCap() + "'");
            pst.setString(1, objCap.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    //------------------------------- INTERNOS CAPACITANDO 
    public CapacitacaoInternoTO incluirInternoCapacitacao(CapacitacaoInternoTO objCap) {
        buscarInterno(objCap.getNomeInterno(), objCap.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CAPACITACAO_INTERNO_TO (DataInicio,DataConclusao,IdInternoCrc,IdCap,SituacaoCurso,CargaHoraria,NotaAvalia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            if (objCap.getDataInicio() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(objCap.getDataInicio().getTime()));
            } else {
                pst.setDate(1, null);
            }
            if (objCap.getDataConclusao() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objCap.getDataConclusao().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, codigoInterno);
            pst.setInt(4, objCap.getIdCap());
            pst.setString(5, objCap.getSituacaoCurso());
            pst.setString(6, objCap.getCargaHoraria());
            pst.setFloat(7, objCap.getNotaAvaliacao());
            pst.setString(8, objCap.getUsuarioInsert());
            pst.setString(9, objCap.getDataInsert());
            pst.setString(10, objCap.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public CapacitacaoInternoTO alterarInternoCapacitacao(CapacitacaoInternoTO objCap) {
        buscarInterno(objCap.getNomeInterno(), objCap.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CAPACITACAO_INTERNO_TO SET DataInicio=?,DataConclusao=?,IdInternoCrc=?,IdCap=?,SituacaoCurso=?,CargaHoraria=?,NotaAvalia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemCap='" + objCap.getIdItemCap() + "'");
            if (objCap.getDataInicio() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(objCap.getDataInicio().getTime()));
            } else {
                pst.setDate(1, null);
            }
            if (objCap.getDataConclusao() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objCap.getDataConclusao().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setInt(3, codigoInterno);
            pst.setInt(4, objCap.getIdCap());
            pst.setString(5, objCap.getSituacaoCurso());
            pst.setString(6, objCap.getCargaHoraria());
            pst.setFloat(7, objCap.getNotaAvaliacao());
            pst.setString(8, objCap.getUsuarioUp());
            pst.setString(9, objCap.getDataUp());
            pst.setString(10, objCap.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public CapacitacaoInternoTO excluirInternoCapacitacao(CapacitacaoInternoTO objCap) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CAPACITACAO_INTERNO_TO WHERE IdItemCap='" + objCap.getIdItemCap() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCap;
    }

    public void buscarCurso(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS WHERE DescricaoCurso='" + desc + "'");
            conecta.rs.first();
            codigoCurso = conecta.rs.getInt("IdCurso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CURSOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
