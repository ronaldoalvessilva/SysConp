/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LiberadoresBancoVirtual;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLiberadorFinanceiro {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LiberadoresBancoVirtual objLibeBV = new LiberadoresBancoVirtual();
    int codInt;

    public LiberadoresBancoVirtual incluirLiberador(LiberadoresBancoVirtual objLibeBV) {
        buscarInterno(objLibeBV.getNomeUsuario(), objLibeBV.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LIBERADORES_BANCO_VIRTUAL (StatusLanc,DataLanc,IdUsuario,Tipo,DataValidade,ValorLiberado,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objLibeBV.getStatuLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objLibeBV.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objLibeBV.getTipo());
            if (objLibeBV.getDataValidade() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objLibeBV.getDataValidade().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setFloat(6, objLibeBV.getValorLiberado());
            pst.setString(7, objLibeBV.getObservacao());
            pst.setString(8, objLibeBV.getUsuarioInsert());
            pst.setString(9, objLibeBV.getDataInsert());
            pst.setString(10, objLibeBV.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLibeBV;
    }

    public LiberadoresBancoVirtual alterarLiberador(LiberadoresBancoVirtual objLibeBV) {
        buscarInterno(objLibeBV.getNomeUsuario(), objLibeBV.getIdUsuario());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LIBERADORES_BANCO_VIRTUAL SET StatusLanc=?,DataLanc=?,IdUsuario=?,Tipo=?,DataValidade=?,ValorLiberado=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objLibeBV.getIdLanc() + "'");
            pst.setString(1, objLibeBV.getStatuLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objLibeBV.getDataLanc().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objLibeBV.getTipo());
            if (objLibeBV.getDataValidade() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objLibeBV.getDataValidade().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setFloat(6, objLibeBV.getValorLiberado());
            pst.setString(7, objLibeBV.getObservacao());
            pst.setString(8, objLibeBV.getUsuarioUp());
            pst.setString(9, objLibeBV.getDataUp());
            pst.setString(10, objLibeBV.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLibeBV;
    }

    public LiberadoresBancoVirtual excluirLiberador(LiberadoresBancoVirtual objLibeBV) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LIBERADORES_BANCO_VIRTUAL WHERE IdLanc='" + objLibeBV.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLibeBV;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nome + "'AND IdUsuario='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do usuário a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
