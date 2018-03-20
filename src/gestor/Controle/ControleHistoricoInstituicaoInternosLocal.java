/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoInternoEducacaoLocal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleHistoricoInstituicaoInternosLocal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoInternoEducacaoLocal objHistInterEduLocal = new HistoricoInternoEducacaoLocal();
    int codInt;
    int codInst;

    public HistoricoInternoEducacaoLocal incluirInterEdu(HistoricoInternoEducacaoLocal objHistInterEduLocal) {
        buscarInterno(objHistInterEduLocal.getNomeInterno());
        buscarInstituicao(objHistInterEduLocal.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_INTERNO_EDUCACIONAL (IdInternoCrc,IdCod,IdItem,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, codInst);
            pst.setInt(3, objHistInterEduLocal.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objHistInterEduLocal.getDataEntrada().getTime()));
            pst.setString(5, objHistInterEduLocal.getHorarioEntrada());
            if (objHistInterEduLocal.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objHistInterEduLocal.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objHistInterEduLocal.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEduLocal;
    }

    public HistoricoInternoEducacaoLocal alterarInterEdu(HistoricoInternoEducacaoLocal objHistInterEduLocal) {
        buscarInterno(objHistInterEduLocal.getNomeInterno());
        buscarInstituicao(objHistInterEduLocal.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_INTERNO_EDUCACIONAL SET IdInternoCrc=?,IdCod=?,IdItem=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE IdInternoCrc='" + objHistInterEduLocal.getIdInternoCrc() + "'AND IdItem='" + objHistInterEduLocal.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, codInst);
            pst.setInt(3, objHistInterEduLocal.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objHistInterEduLocal.getDataEntrada().getTime()));
            pst.setString(5, objHistInterEduLocal.getHorarioEntrada());
            if (objHistInterEduLocal.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objHistInterEduLocal.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objHistInterEduLocal.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEduLocal;
    }

    public HistoricoInternoEducacaoLocal excluirInterEdu(HistoricoInternoEducacaoLocal objHistInterEduLocal) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_INTERNO_EDUCACIONAL WHERE IdInternoCrc='" + objHistInterEduLocal.getIdInternoCrc() + "'AND IdItem='" + objHistInterEduLocal.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEduLocal;
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarInstituicao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + desc + "'");
            conecta.rs.first();
            codInst = conecta.rs.getInt("IdCod");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (EMPRESA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
