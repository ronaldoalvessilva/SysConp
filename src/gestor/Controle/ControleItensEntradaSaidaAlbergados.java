/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaLaborInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntradaSaidaAlbergados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaLaborInterno objItenLabor = new ItensEntradaSaidaLaborInterno();
    int codInterno;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    String evadido = "";

    public ItensEntradaSaidaLaborInterno incluirItensAlbergInterno(ItensEntradaSaidaLaborInterno objItenLabor) {

        buscarInterno(objItenLabor.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENTRADA_SAIDA_ALBERGADOS (IdLanc,IdInternoCrc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,Evadido,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItenLabor.getIdLanc());
            pst.setInt(2, codInterno);
            if (objItenLabor.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItenLabor.getDataEntrada().getTime()));
            } else {
                pst.setTimestamp(3, null);
            }
            pst.setString(4, objItenLabor.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItenLabor.getDataSaida().getTime()));
            pst.setString(6, objItenLabor.getHorarioSaida());
            pst.setString(7, evadido);
            pst.setString(8, objItenLabor.getUsuarioInsert());
            pst.setString(9, objItenLabor.getDataInsert());
            pst.setString(10, objItenLabor.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    public ItensEntradaSaidaLaborInterno alterarItensAlbergInterno(ItensEntradaSaidaLaborInterno objItenLabor) {

        buscarInterno(objItenLabor.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENTRADA_SAIDA_ALBERGADOS SET IdLanc=?,IdInternoCrc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,Evadido=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItenLabor.getIdItem() + "'");
            pst.setInt(1, objItenLabor.getIdLanc());
            pst.setInt(2, codInterno);
            if (objItenLabor.getDataEntrada() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItenLabor.getDataEntrada().getTime()));
            } else {
                pst.setTimestamp(3, null);
            }
            pst.setString(4, objItenLabor.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objItenLabor.getDataSaida().getTime()));
            pst.setString(6, objItenLabor.getHorarioSaida());
            pst.setString(7, evadido);
            pst.setString(8, objItenLabor.getUsuarioUp());
            pst.setString(9, objItenLabor.getDataUp());
            pst.setString(10, objItenLabor.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    public ItensEntradaSaidaLaborInterno excluirItensAlbergInterno(ItensEntradaSaidaLaborInterno objItenLabor) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENTRADA_SAIDA_ALBERGADOS WHERE IdItem='" + objItenLabor.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItenLabor;
    }

    public void buscarInterno(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND SituacaoCrc='" + situacaoEnt + "' OR NomeInternoCrc='" + desc + "'AND SituacaoCrc='" + situacaoRet + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
