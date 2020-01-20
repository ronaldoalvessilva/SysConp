/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FrequenciaAtividadesComplementaresPedagogia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleFrequenciaACC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FrequenciaAtividadesComplementaresPedagogia objCapacitaInt = new FrequenciaAtividadesComplementaresPedagogia();
    int codigoCurso;
    int codigoInterno;

    public FrequenciaAtividadesComplementaresPedagogia incluirFrequenciaACC(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {
        buscarCurso(objCapacitaInt.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA (DataFAC,StatusFAC,IdCurso,IdProf,CargaHoraria,TurnoAtividade,Dia2,Dia3,Dia4,Dia5,Dia6,Dia7,Dia8,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objCapacitaInt.getDataFAC().getTime()));
            pst.setString(2, objCapacitaInt.getStatusFAC());
            pst.setInt(3, codigoCurso);
            pst.setInt(4, objCapacitaInt.getIdProf());
            pst.setString(5, objCapacitaInt.getCargaHoraria());
            pst.setString(6, objCapacitaInt.getTurnoAtividade());
            pst.setInt(7, objCapacitaInt.getDia2());
            pst.setInt(8, objCapacitaInt.getDia3());
            pst.setInt(9, objCapacitaInt.getDia4());
            pst.setInt(10, objCapacitaInt.getDia5());
            pst.setInt(11, objCapacitaInt.getDia6());
            pst.setInt(12, objCapacitaInt.getDia7());
            pst.setInt(13, objCapacitaInt.getDia8());
            pst.setString(14, objCapacitaInt.getObservacao());
            pst.setString(15, objCapacitaInt.getUsuarioInsert());
            pst.setString(16, objCapacitaInt.getDataInsert());
            pst.setString(17, objCapacitaInt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    public FrequenciaAtividadesComplementaresPedagogia alterarFrequenciaACC(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {
        buscarCurso(objCapacitaInt.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET DataFAC=?,StatusFAC=?,IdCurso=?,IdProf=?,CargaHoraria=?,TurnoAtividade=?,Dia2=?,Dia3=?,Dia4=?,Dia5=?,Dia6=?,Dia7=?,Dia8=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFAC='" + objCapacitaInt.getIdFAC() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objCapacitaInt.getDataFAC().getTime()));
            pst.setString(2, objCapacitaInt.getStatusFAC());
            pst.setInt(3, codigoCurso);
            pst.setInt(4, objCapacitaInt.getIdProf());
            pst.setString(5, objCapacitaInt.getCargaHoraria());
            pst.setString(6, objCapacitaInt.getTurnoAtividade());
            pst.setInt(7, objCapacitaInt.getDia2());
            pst.setInt(8, objCapacitaInt.getDia3());
            pst.setInt(9, objCapacitaInt.getDia4());
            pst.setInt(10, objCapacitaInt.getDia5());
            pst.setInt(11, objCapacitaInt.getDia6());
            pst.setInt(12, objCapacitaInt.getDia7());
            pst.setInt(13, objCapacitaInt.getDia8());
            pst.setString(14, objCapacitaInt.getObservacao());
            pst.setString(15, objCapacitaInt.getUsuarioUp());
            pst.setString(16, objCapacitaInt.getDataUp());
            pst.setString(17, objCapacitaInt.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    public FrequenciaAtividadesComplementaresPedagogia excluirFrequenciaACC(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {
        buscarCurso(objCapacitaInt.getDescricaoCurso());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA WHERE IdFAC='" + objCapacitaInt.getIdFAC() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    public FrequenciaAtividadesComplementaresPedagogia finalizarFrequenciaACC(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET StatusFAC=? WHERE IdFAC='" + objCapacitaInt.getIdFAC() + "'");
            pst.setString(1, objCapacitaInt.getStatusFAC());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    //------------------------------- INTERNOS CAPACITANDO 
    public FrequenciaAtividadesComplementaresPedagogia incluirInternoFrequenciaCapacitacao(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {
        buscarInterno(objCapacitaInt.getNomeInterno(), objCapacitaInt.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA (IdInternoCrc,IdFAC,DataEntrada,HoraEntrada,HoraSaida,NotaAvalia,Frequencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codigoInterno);
            pst.setInt(2, objCapacitaInt.getIdFAC());
            if (objCapacitaInt.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCapacitaInt.getDataEntrada().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCapacitaInt.getHorariaEntrada());
            pst.setString(5, objCapacitaInt.getHorarioSaida());
            pst.setFloat(6, objCapacitaInt.getNotaAvaliacao());
            pst.setString(7, objCapacitaInt.getFrequencia());
            pst.setString(8, objCapacitaInt.getUsuarioInsert());
            pst.setString(9, objCapacitaInt.getDataInsert());
            pst.setString(10, objCapacitaInt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    public FrequenciaAtividadesComplementaresPedagogia alterarInternoFrequenciaCapacitacao(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {
        buscarInterno(objCapacitaInt.getNomeInterno(), objCapacitaInt.getIdInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET IdInternoCrc=?,IdFreqCap=?,DataEntrada=?,HoraEntrada=?,HoraSaida=?,NotaAvalia=?,Frequencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemFAC='" + objCapacitaInt.getIdItemFreqCap()+ "'");
            pst.setInt(1, codigoInterno);
            pst.setInt(2, objCapacitaInt.getIdFAC());
            if (objCapacitaInt.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objCapacitaInt.getDataEntrada().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objCapacitaInt.getHorariaEntrada());
            pst.setString(5, objCapacitaInt.getHorarioSaida());
            pst.setFloat(6, objCapacitaInt.getNotaAvaliacao());
            pst.setString(7, objCapacitaInt.getFrequencia());
            pst.setString(8, objCapacitaInt.getUsuarioUp());
            pst.setString(9, objCapacitaInt.getDataUp());
            pst.setString(10, objCapacitaInt.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
    }

    public FrequenciaAtividadesComplementaresPedagogia excluirInternoFrequenciaCapacitacao(FrequenciaAtividadesComplementaresPedagogia objCapacitaInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA WHERE IdItemFAC='" + objCapacitaInt.getIdItemFreqCap() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCapacitaInt;
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
