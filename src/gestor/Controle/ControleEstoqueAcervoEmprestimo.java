/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EstoqueAcervoEmprestimo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEstoqueAcervoEmprestimo {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EstoqueAcervoEmprestimo objEstoqueEmp = new EstoqueAcervoEmprestimo();
    
    int codLocal, codLivro;
    String statusLivro = "Ativo";
    String statusLocal = "Ativo";
    
    public EstoqueAcervoEmprestimo incluirEstoqueAcervoEmprestimo(EstoqueAcervoEmprestimo objEstoqueEmp) {
        buscarAcervo(objEstoqueEmp.getNomeLivro());
        buscarLocalAcervo(objEstoqueEmp.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTOQUE_ACERVO (DataLanc,TipoMov,NrDoc,IdLivro,IdLocal,SaldoEstoque) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEstoqueEmp.getDataLanc().getTime()));            
            pst.setString(2, objEstoqueEmp.getTipoMov());
            pst.setInt(3, objEstoqueEmp.getIdDocumento());
            pst.setInt(4, codLivro);
            pst.setInt(5, codLocal);
            pst.setFloat(6, objEstoqueEmp.getSaldoEstoqueAtual());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível INCLUIR registro.\nERRO: " + ex);
        }
        return objEstoqueEmp;
    }
    
    public void buscarAcervo(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LIVROS_REVISTAS_JORNAIS WHERE TituloLivro='" + desc + "'AND StatusLivro='" + statusLivro + "'");
            conecta.rs.first();
            codLivro = conecta.rs.getInt("IdLivro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar a acervo, talvez o mesmo esteja inativa." + e);
        }
        conecta.desconecta();
    }
    
    public void buscarLocalAcervo(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ACERVO WHERE DescricaoLocal='" + desc + "'AND StatusLocal='" + statusLocal + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar local do acervo, talvez o mesmo esteja inativa." + e);
        }
        conecta.desconecta();
    }
}
