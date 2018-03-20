/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SolicitanteMedicamentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSolicitanteMedicamentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitanteMedicamentos objSolicitante = new SolicitanteMedicamentos();
    int codDepto;

    public SolicitanteMedicamentos incluirSolicitanteENFAR(SolicitanteMedicamentos objSolicitante) {
        pesquisarDepartamento(objSolicitante.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR (FotoFuncSolici,StatusSolici,NomeSolicitante,Matricula,Cargo,IdDepartamento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objSolicitante.getFotoSolicitante());
            pst.setString(2, objSolicitante.getStatusSoli());
            pst.setString(3, objSolicitante.getNomeSolicitante());
            pst.setString(4, objSolicitante.getMatriculaSolicitante());
            pst.setString(5, objSolicitante.getCargoSolicitante());
            pst.setInt(6, codDepto);
            pst.setString(7, objSolicitante.getObservacao());
            pst.setString(8, objSolicitante.getUsuarioInsert());
            pst.setString(9, objSolicitante.getDataInsert());
            pst.setString(10, objSolicitante.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitante;
    }

    public SolicitanteMedicamentos alterarSolicitanteENFAR(SolicitanteMedicamentos objSolicitante) {
        pesquisarDepartamento(objSolicitante.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR SET FotoFuncSolici=?,StatusSolici=?,NomeSolicitante=?,Matricula=?,Cargo=?,IdDepartamento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFuncSolici='" + objSolicitante.getIdSolicitante() + "'");
            pst.setString(1, objSolicitante.getFotoSolicitante());
            pst.setString(2, objSolicitante.getStatusSoli());
            pst.setString(3, objSolicitante.getNomeSolicitante());
            pst.setString(4, objSolicitante.getMatriculaSolicitante());
            pst.setString(5, objSolicitante.getCargoSolicitante());
            pst.setInt(6, codDepto);
            pst.setString(7, objSolicitante.getObservacao());
            pst.setString(8, objSolicitante.getUsuarioUp());
            pst.setString(9, objSolicitante.getDataUp());
            pst.setString(10, objSolicitante.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitante;
    }

    public SolicitanteMedicamentos excluirSolicitanteENFAR(SolicitanteMedicamentos objSolicitante) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR WHERE IdFuncSoli='" + objSolicitante.getIdSolicitante() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitante;
    }

    public void pesquisarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
