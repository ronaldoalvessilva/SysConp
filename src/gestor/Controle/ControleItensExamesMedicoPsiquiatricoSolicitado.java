/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensExameMedicoPsiquiatricoSolicitado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensExamesMedicoPsiquiatricoSolicitado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensExameMedicoPsiquiatricoSolicitado objItensExame = new ItensExameMedicoPsiquiatricoSolicitado();

    int codExame;

    public ItensExameMedicoPsiquiatricoSolicitado incluirItensExameMedicoPsiquiatrico(ItensExameMedicoPsiquiatricoSolicitado objItensExame) {
        buscarExame(objItensExame.getDescricaoExame());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO (IdSolExame,IdExame,PrimeiraAmostra,SegundaAmostra,TerceiraAmostra,UsuarioInsert,DataInsert,HorarioInsert,ExameReal,MotivoExame) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensExame.getIdSolExame());
            pst.setInt(2, codExame);
            pst.setString(3, objItensExame.getPrimeiraAmostra());
            pst.setString(4, objItensExame.getSegundaAmostra());
            pst.setString(5, objItensExame.getTerceiraAmostra());
            pst.setString(6, objItensExame.getUsuarioInsert());
            pst.setString(7, objItensExame.getDataInsert());
            pst.setString(8, objItensExame.getHorarioInsert());
            pst.setString(9, objItensExame.getExameRealizado());
            pst.setString(10, objItensExame.getMotivoRealizado());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensExame;
    }

    public ItensExameMedicoPsiquiatricoSolicitado alterarItensExameMedicoPsiquiatrico(ItensExameMedicoPsiquiatricoSolicitado objItensExame) {
        buscarExame(objItensExame.getDescricaoExame());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO SET IdSolExame=?,IdExame=?,PrimeiraAmostra=?,SegundaAmostra=?,TerceiraAmostra=?,UsuarioUp=?,DataUp=?,HorarioUp=?,ExameReal=?,MotivoExame=? WHERE IdItemExame='" + objItensExame.getIdItemExame() + "'");
            pst.setInt(1, objItensExame.getIdSolExame());
            pst.setInt(2, codExame);
            pst.setString(3, objItensExame.getPrimeiraAmostra());
            pst.setString(4, objItensExame.getSegundaAmostra());
            pst.setString(5, objItensExame.getTerceiraAmostra());
            pst.setString(6, objItensExame.getUsuarioUp());
            pst.setString(7, objItensExame.getDataUp());
            pst.setString(8, objItensExame.getHorarioUp());
            pst.setString(9, objItensExame.getExameRealizado());
            pst.setString(10, objItensExame.getMotivoRealizado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensExame;
    }

    public ItensExameMedicoPsiquiatricoSolicitado excluirItensExameMedicoPsiquiatrico(ItensExameMedicoPsiquiatricoSolicitado objItensExame) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO WHERE IdItemExame='" + objItensExame.getIdItemExame() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensExame;
    }

    public void buscarExame(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_EXAMES_MEDICO WHERE DescricaoExame='" + desc + "'");
            conecta.rs.first();
            codExame = conecta.rs.getInt("IdExame");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
