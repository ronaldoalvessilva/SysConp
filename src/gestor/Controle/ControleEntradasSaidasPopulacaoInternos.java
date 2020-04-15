/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleEntradasSaidasPopulacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    int codModulo;
    int codGrupo;

    public EntradaSaidasPolucaoInternos incluirEntradaSaidaPopulacao(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_SAIDAS_POPULACAO_INTERNOS (DataMovimento,HorarioMovimento,TipoOperacao,Populacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntradaSaida.getDataMovimento().getTime()));
            pst.setString(2, objEntradaSaida.getHorarioMovimento());
            pst.setString(3, objEntradaSaida.getTipoOperacao());
            pst.setInt(4, objEntradaSaida.getPopulacao());
            pst.setString(5, objEntradaSaida.getUsuarioInsert());
            pst.setString(6, objEntradaSaida.getDataInsert());
            pst.setString(7, objEntradaSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }

    public EntradaSaidasPolucaoInternos incluirEntradaSaidaPortaria(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_SAIDAS_POPULACAO_INTERNOS (IdDocumento,DataMovimento,HorarioMovimento,TipoOperacao,Quantidade,Populacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objEntradaSaida.getIdDocumento());
            pst.setTimestamp(2, new java.sql.Timestamp(objEntradaSaida.getDataMovimento().getTime()));
            pst.setString(3, objEntradaSaida.getHorarioMovimento());
            pst.setString(4, objEntradaSaida.getTipoOperacao());
            pst.setInt(5, objEntradaSaida.getQuantidade());
            pst.setInt(6, objEntradaSaida.getPopulacao());
            pst.setString(7, objEntradaSaida.getUsuarioInsert());
            pst.setString(8, objEntradaSaida.getDataInsert());
            pst.setString(9, objEntradaSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }

    public EntradaSaidasPolucaoInternos alterarEntradaSaidaPortaria(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_POPULACAO_INTERNOS SET DataMovimento=?,HorarioMovimento=?,TipoOperacao=?,Quantidade=?,Populacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDocumento='" + objEntradaSaida.getIdDocumento() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntradaSaida.getDataMovimento().getTime()));
            pst.setString(2, objEntradaSaida.getHorarioMovimento());
            pst.setString(3, objEntradaSaida.getTipoOperacao());
            pst.setInt(4, objEntradaSaida.getQuantidade());
            pst.setInt(5, objEntradaSaida.getPopulacao());
            pst.setString(6, objEntradaSaida.getUsuarioUp());
            pst.setString(7, objEntradaSaida.getDataUp());
            pst.setString(8, objEntradaSaida.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }

    public EntradaSaidasPolucaoInternos excluirEntradaSaidaPortaria(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAS_SAIDAS_POPULACAO_INTERNOS WHERE IdDocumento='" + objEntradaSaida.getIdDocumento() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }
}
