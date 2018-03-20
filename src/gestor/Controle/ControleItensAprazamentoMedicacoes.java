/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensAprazamentoMedicamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensAprazamentoMedicacoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAprazamentoMedicamento objItensApraza = new ItensAprazamentoMedicamento();
    int codProd;

    public ItensAprazamentoMedicamento incluirItensAprazamentoMedico(ItensAprazamentoMedicamento objItensApraza) {
        buscarProduto(objItensApraza.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_APRAZAMENTO_MEDICACAO (IdProd,IdLanc,IdInternoCrc,QtdItemAP,Unidade,Frequencia,DiasUso,DataInicio,DataTermino,PeriodoHoras,HorarioInicial,HorarioFinal,TextoObservacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codProd);
            pst.setInt(2, objItensApraza.getIdLanc());
            pst.setInt(3, objItensApraza.getIdInternoCrc());
            pst.setInt(4, objItensApraza.getQtdItem());
            pst.setString(5, objItensApraza.getUnidade());
            pst.setString(6, objItensApraza.getFrequencia());
            pst.setInt(7, objItensApraza.getDiasUso());
            pst.setTimestamp(8, new java.sql.Timestamp(objItensApraza.getDataInicio().getTime()));
            pst.setTimestamp(9, new java.sql.Timestamp(objItensApraza.getDataTermino().getTime()));
            pst.setString(10, objItensApraza.getPeriodoHoras());
            pst.setString(11, objItensApraza.getHorarioInicial());
            pst.setString(12, objItensApraza.getHorarioFinal());
            pst.setString(13, objItensApraza.getTextoObservacao());
            pst.setString(14, objItensApraza.getUsuarioInsert());
            pst.setString(15, objItensApraza.getDataInsert());
            pst.setString(16, objItensApraza.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensApraza;
    }

    public ItensAprazamentoMedicamento alterarItensAprazamentoMedico(ItensAprazamentoMedicamento objItensApraza) {
        buscarProduto(objItensApraza.getDescricaoProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_APRAZAMENTO_MEDICACAO SET IdProd=?,IdLanc=?,IdInternoCrc=?,QtdItemAP=?,Unidade=?,Frequencia=?,DiasUso=?,DataInicio=?,DataTermino=?,PeriodoHoras=?,HorarioInicial=?,HorarioFinal=?,TextoObservacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensApraza.getIdItem() + "'");
            pst.setInt(1, codProd);
            pst.setInt(2, objItensApraza.getIdLanc());
            pst.setInt(3, objItensApraza.getIdInternoCrc());
            pst.setInt(4, objItensApraza.getQtdItem());
            pst.setString(5, objItensApraza.getUnidade());
            pst.setString(6, objItensApraza.getFrequencia());
            pst.setInt(7, objItensApraza.getDiasUso());
            pst.setTimestamp(8, new java.sql.Timestamp(objItensApraza.getDataInicio().getTime()));
            pst.setTimestamp(9, new java.sql.Timestamp(objItensApraza.getDataTermino().getTime()));
            pst.setString(10, objItensApraza.getPeriodoHoras());
            pst.setString(11, objItensApraza.getHorarioInicial());
            pst.setString(12, objItensApraza.getHorarioFinal());
            pst.setString(13, objItensApraza.getTextoObservacao());
            pst.setString(14, objItensApraza.getUsuarioUp());
            pst.setString(15, objItensApraza.getDataUp());
            pst.setString(16, objItensApraza.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensApraza;
    }

    public ItensAprazamentoMedicamento excluirItensAprazamentoMedico(ItensAprazamentoMedicamento objItensApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_APRAZAMENTO_MEDICACAO WHERE IdItem='" + objItensApraza.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensApraza;
    }

    // ALTERAR O SALDO DE PRODUTOS NA TABELA ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF
    public ItensAprazamentoMedicamento alterarEstoqueDosesMedicacao(ItensAprazamentoMedicamento objItensApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF SET QtdDosesAT=? WHERE IdProd='" + objItensApraza.getIdProd() + "'AND IdReq='" + objItensApraza.getIdReq()  + "'");
            pst.setInt(1, objItensApraza.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensApraza;
    }

    // ALTERAR O SALDO DE PRODUTOS NA TABELA ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF
    public ItensAprazamentoMedicamento alterarEstoqueDosesMedicacaoAvulsa(ItensAprazamentoMedicamento objItensApraza) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF SET QtdDosesAT=? WHERE IdProd='" + objItensApraza.getIdProd() + "'AND IdReq='" + objItensApraza.getIdReq()  + "'");
            pst.setInt(1, objItensApraza.getQtdItem());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR saldo de estoque.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensApraza;
    }
    public void buscarProduto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + desc + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o produto.\nERRO: " + ex);
        }
    }
}
