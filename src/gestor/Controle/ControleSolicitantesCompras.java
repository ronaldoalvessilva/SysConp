/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SolicitantesCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSolicitantesCompras {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitantesCompras solComp = new SolicitantesCompras();
    int codigoDepto;

    public SolicitantesCompras incluirSolicitanteCompras(SolicitantesCompras solComp) {
        buscarDepartamento(solComp.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITANTES_COMPRAS (StatusSoli,DataSoli,IdDepartamento,TipoValor,ValorMax,ValorGAC,DataInicial,DataFinal,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, solComp.getStatusSoli());
            pst.setTimestamp(2, new java.sql.Timestamp(solComp.getDataSoli().getTime()));
            pst.setInt(3, codigoDepto);
            pst.setFloat(4, solComp.getTipoValor());
            pst.setFloat(5, solComp.getValorMax());
            pst.setFloat(6, solComp.getValorGAC());
            if (solComp.getDataInicial() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(solComp.getDataInicial().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (solComp.getDataFinal() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(solComp.getDataFinal().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, solComp.getObservacao());
            pst.setString(10, solComp.getUsuarioInsert());
            pst.setString(11, solComp.getDataInsert());
            pst.setString(12, solComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return solComp;
    }

    public SolicitantesCompras alterarSolicitanteCompras(SolicitantesCompras solComp) {
        buscarDepartamento(solComp.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITANTES_COMPRAS SET StatusSoli=?,DataSoli=?,IdDepartamento=?,TipoValor=?,ValorMax=?,ValorGAC=?,DataInicial=?,DataFinal=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSoli='" + solComp.getIdSoli() + "'");
            pst.setString(1, solComp.getStatusSoli());
            pst.setTimestamp(2, new java.sql.Timestamp(solComp.getDataSoli().getTime()));
            pst.setInt(3, codigoDepto);
            pst.setFloat(4, solComp.getTipoValor());
            pst.setFloat(5, solComp.getValorMax());
            pst.setFloat(6, solComp.getValorGAC());
            if (solComp.getDataInicial() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(solComp.getDataInicial().getTime()));
            } else {
                pst.setDate(7, null);
            }
            if (solComp.getDataFinal() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(solComp.getDataFinal().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, solComp.getObservacao());
            pst.setString(10, solComp.getUsuarioUp());
            pst.setString(11, solComp.getDataUp());
            pst.setString(12, solComp.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return solComp;
    }

    public SolicitantesCompras excluirSolicitanteCompras(SolicitantesCompras solComp) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITANTES_COMPRAS WHERE IdSoli='" + solComp.getIdSoli() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return solComp;
    }

    public void buscarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codigoDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
