/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EmprestimoAcervo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEmprestimoAcervo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmprestimoAcervo objEmprestimoAcervo = new EmprestimoAcervo();

    int codInterno;

    public EmprestimoAcervo incluirEmprestimoAcervo(EmprestimoAcervo objEmprestimoAcervo) {
        buscarInternoEmprestimoAcervo(objEmprestimoAcervo.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMPRESTIMO_ACERVO (StatusLanc,DataEmp,IdInternoCrc,IdReserva,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objEmprestimoAcervo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEmprestimoAcervo.getDataEmprestimo().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objEmprestimoAcervo.getIdReserva());
            pst.setString(5, objEmprestimoAcervo.getObservacao());
            pst.setString(6, objEmprestimoAcervo.getUsuarioInsert());
            pst.setString(7, objEmprestimoAcervo.getDataInsert());
            pst.setString(8, objEmprestimoAcervo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmprestimoAcervo;
    }

    public EmprestimoAcervo alterarEmprestimoAcervo(EmprestimoAcervo objEmprestimoAcervo) {
        buscarInternoEmprestimoAcervo(objEmprestimoAcervo.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESTIMO_ACERVO SET StatusLanc=?,DataEmp=?,IdInternoCrc=?,IdReserva=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEmprestimo='" + objEmprestimoAcervo.getIdEmprestimo()+ "'");
            pst.setString(1, objEmprestimoAcervo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objEmprestimoAcervo.getDataEmprestimo().getTime()));
            pst.setInt(3, codInterno);
            pst.setInt(4, objEmprestimoAcervo.getIdReserva());
            pst.setString(5, objEmprestimoAcervo.getObservacao());
            pst.setString(6, objEmprestimoAcervo.getUsuarioUp());
            pst.setString(7, objEmprestimoAcervo.getDataUp());
            pst.setString(8, objEmprestimoAcervo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmprestimoAcervo;
    }

    public EmprestimoAcervo excluirEmprestimoAcervo(EmprestimoAcervo objEmprestimoAcervo) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMPRESTIMO_ACERVO WHERE IdEmprestimo='" + objEmprestimoAcervo.getIdEmprestimo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmprestimoAcervo;
    }

    public EmprestimoAcervo finalizarEmprestimoAcervo(EmprestimoAcervo objEmprestimoAcervo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESTIMO_ACERVO SET StatusLanc=? WHERE IdEmprestimo='" + objEmprestimoAcervo.getIdEmprestimo() + "'");
            pst.setString(1, objEmprestimoAcervo.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmprestimoAcervo;
    }

    public void buscarInternoEmprestimoAcervo(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
