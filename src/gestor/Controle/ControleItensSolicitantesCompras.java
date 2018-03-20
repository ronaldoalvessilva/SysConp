/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensSolicitantesCompras;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensSolicitantesCompras {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSolicitantesCompras itensSolComp = new ItensSolicitantesCompras();
    int codigoFunc;   

    public ItensSolicitantesCompras incluirItensSolicitanteCompras(ItensSolicitantesCompras itensSolComp) {
        buscarColaborador(itensSolComp.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SOLICITANTES_COMPRAS (IdSeq,IdSoli,IdFunc,ValorMax,DataInicial,DataFinal,ValorVTA,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, itensSolComp.getIdSeq());
            pst.setInt(2, itensSolComp.getIdSoli());
            pst.setInt(3, codigoFunc);
            pst.setFloat(4, itensSolComp.getValorMax());
            if (itensSolComp.getDataInicialFunc()!= null) {
                pst.setTimestamp(5, new java.sql.Timestamp(itensSolComp.getDataInicialFunc().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (itensSolComp.getDataFinalFunc()!= null) {
                pst.setTimestamp(6, new java.sql.Timestamp(itensSolComp.getDataFinalFunc().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setFloat(7, itensSolComp.getValorVTA());          
            pst.setString(8, itensSolComp.getUsuarioInsert());
            pst.setString(9, itensSolComp.getDataInsert());
            pst.setString(10, itensSolComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return itensSolComp;
    }

    public ItensSolicitantesCompras alterarItensSolicitanteCompras(ItensSolicitantesCompras itensSolComp) {
        buscarColaborador(itensSolComp.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITANTES_COMPRAS SET IdSeq=?,IdSoli=?,IdFunc=?,ValorMax=?,DataInicial=?,DataFinal=?,ValorVTA=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + itensSolComp.getIdItem() + "'");
            pst.setInt(1, itensSolComp.getIdSeq());
            pst.setInt(2, itensSolComp.getIdSoli());
            pst.setInt(3, codigoFunc);
            pst.setFloat(4, itensSolComp.getValorMax());
             if (itensSolComp.getDataInicialFunc()!= null) {
                pst.setTimestamp(5, new java.sql.Timestamp(itensSolComp.getDataInicialFunc().getTime()));
            } else {
                pst.setDate(5, null);
            }
            if (itensSolComp.getDataFinalFunc()!= null) {
                pst.setTimestamp(6, new java.sql.Timestamp(itensSolComp.getDataFinalFunc().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setFloat(7, itensSolComp.getValorVTA());           
            pst.setString(8, itensSolComp.getUsuarioUp());
            pst.setString(9, itensSolComp.getDataUp());
            pst.setString(10, itensSolComp.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return itensSolComp;
    }

    public ItensSolicitantesCompras excluirItensSolicitanteCompras(ItensSolicitantesCompras itensSolComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_SOLICITANTES_COMPRAS WHERE IdItem='" + itensSolComp.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return itensSolComp;
    }

    public void buscarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codigoFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
