/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroComissao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRegistroComissaoDisciplinar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroComissao objRegComissao = new RegistroComissao();

    int codPavilhao, codCela;

    public RegistroComissao incluirRegComissao(RegistroComissao objRegComissao) {
        pesquisarPavilhao(objRegComissao.getDescricaoPavilhao());
        pesquisarCela(objRegComissao.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTOCOMISSAOJULGADORA (StatusLanc,DataLanc,IdPav,IdCcela,HorarioInicial,HorarioTermino,Responsavel,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegComissao.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegComissao.getDataLanc().getTime()));
            pst.setInt(3, codPavilhao);
            pst.setInt(4, codCela);
            pst.setString(5, objRegComissao.getHorarioInicial());
            pst.setString(6, objRegComissao.getHorarioTermino());
            pst.setString(7, objRegComissao.getResponsavel());
            pst.setString(8, objRegComissao.getObservacao());
            pst.setString(9, objRegComissao.getUsuarioInsert());
            pst.setString(10, objRegComissao.getDataInsert());
            pst.setString(11, objRegComissao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegComissao;
    }

    public RegistroComissao alterarRegComissao(RegistroComissao objRegComissao) {
        pesquisarPavilhao(objRegComissao.getDescricaoPavilhao());
        pesquisarCela(objRegComissao.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTOCOMISSAOJULGADORA SET StatusLanc=?,DataLanc=?,IdPav=?,IdCcela=?,HorarioInicial=?,HorarioTermino=?,Responsavel=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioU=? WHERE IdLanc='" + objRegComissao.getIdLanc() + "'");
            pst.setString(1, objRegComissao.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegComissao.getDataLanc().getTime()));
            pst.setInt(3, codPavilhao);
            pst.setInt(4, codCela);
            pst.setString(5, objRegComissao.getHorarioInicial());
            pst.setString(6, objRegComissao.getHorarioTermino());
            pst.setString(7, objRegComissao.getResponsavel());
            pst.setString(8, objRegComissao.getObservacao());
            pst.setString(9, objRegComissao.getUsuarioUp());
            pst.setString(10, objRegComissao.getDataUp());
            pst.setString(11, objRegComissao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegComissao;
    }

    public RegistroComissao excluirRegComissao(RegistroComissao objRegComissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTOCOMISSAOJULGADORA WHERE IdLanc='" + objRegComissao.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegComissao;
    }

    public RegistroComissao finalizarRegComissao(RegistroComissao objRegComissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTOCOMISSAOJULGADORA SET StatusLanc=? WHERE IdLanc='" + objRegComissao.getIdLanc() + "'");
            pst.setString(1, objRegComissao.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegComissao;
    }

    public void pesquisarCela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
