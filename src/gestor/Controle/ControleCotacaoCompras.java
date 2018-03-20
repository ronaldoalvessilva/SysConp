/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CotacaoCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCotacaoCompras {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CotacaoCompras objCotacao = new CotacaoCompras();
    int codDepto, codCCusto;

    public CotacaoCompras incluirCotacaoCompras(CotacaoCompras objCotacao) {
        buscarDepartamento(objCotacao.getDescricaoDepartamento());
        buscarCentroCusto(objCotacao.getDescricaoCentroCusto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COTACAO_COMPRAS (StatusCota,DataCotacao,IdDepartamento,IdCusto,TipoCotacao,FreteCotacao,ObservacaoCotacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCotacao.getStatusCota());
            pst.setTimestamp(2, new java.sql.Timestamp(objCotacao.getDataCotacao().getTime()));
            pst.setInt(3, codDepto);
            pst.setInt(4, codCCusto);
            pst.setString(5, objCotacao.getTipoCotacao());
            pst.setString(6, objCotacao.getFreteCotacao());
            pst.setString(7, objCotacao.getObservacaoCotacao());
            pst.setString(8, objCotacao.getUsuarioInsert());
            pst.setString(9, objCotacao.getDataInsert());
            pst.setString(10, objCotacao.getHorarioInsert());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public CotacaoCompras alterarCotacaoCompras(CotacaoCompras objCotacao) {
        buscarDepartamento(objCotacao.getDescricaoDepartamento());
        buscarCentroCusto(objCotacao.getDescricaoCentroCusto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COTACAO_COMPRAS SET StatusCota=?,DataCotacao=?,IdDepartamento=?,IdCusto=?,TipoCotacao=?,FreteCotacao=?,ObservacaoCotacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCota='" + objCotacao.getIdCota() + "'");
            pst.setString(1, objCotacao.getStatusCota());
            pst.setTimestamp(2, new java.sql.Timestamp(objCotacao.getDataCotacao().getTime()));
            pst.setInt(3, codDepto);
            pst.setInt(4, codCCusto);
            pst.setString(5, objCotacao.getTipoCotacao());
            pst.setString(6, objCotacao.getFreteCotacao());
            pst.setString(7, objCotacao.getObservacaoCotacao());
            pst.setString(8, objCotacao.getUsuarioUp());
            pst.setString(9, objCotacao.getDataUp());
            pst.setString(10, objCotacao.getHorarioUp());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public CotacaoCompras excluirCotacaoCompras(CotacaoCompras objCotacao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COTACAO_COMPRAS WHERE IdCota='" + objCotacao.getIdCota() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados...\nERRO: " + e);
        }
        conecta.desconecta();
        return objCotacao;
    }

    public void buscarDepartamento(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + desc + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (DEPARTAMENTOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarCentroCusto(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CENTRO_CUSTO WHERE DescricaoCentro='" + desc + "'");
            conecta.rs.first();
            codCCusto = conecta.rs.getInt("IdCusto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (CENTRO DE CUSTO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
