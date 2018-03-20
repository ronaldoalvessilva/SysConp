/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SolicitacaoComprasAC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSolicitacaoComprasENFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoComprasAC objSoliMat = new SolicitacaoComprasAC();

    int codFunc, codLibera, codLocal;

    public SolicitacaoComprasAC incluirSolicitacaoMaterial(SolicitacaoComprasAC objSoliMat) {
        buscarSolicitante(objSoliMat.getNomeColaborador());
        buscarLiberador(objSoliMat.getNomeLiberador());
        buscarLocalArmazenamento(objSoliMat.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR (StatusSol,DataSol,IdFuncSolici,IdFuncAprova,IdLocal,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.setTimestamp(2, new java.sql.Timestamp(objSoliMat.getDataSol().getTime()));
            pst.setInt(3, codFunc);
            pst.setInt(4, codLibera);
            pst.setInt(5, codLocal);
            pst.setString(6, objSoliMat.getObservacao());
            pst.setString(7, objSoliMat.getUsuarioInsert());
            pst.setString(8, objSoliMat.getDataInsert());
            pst.setString(9, objSoliMat.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC alterarSolicitacaoMaterial(SolicitacaoComprasAC objSoliMat) {
        buscarSolicitante(objSoliMat.getNomeColaborador());
        buscarLiberador(objSoliMat.getNomeLiberador());
        buscarLocalArmazenamento(objSoliMat.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR SET StatusSol=?,DataSol=?,IdFuncSolici=?,IdFuncAprova=?,IdLocal=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.setTimestamp(2, new java.sql.Timestamp(objSoliMat.getDataSol().getTime()));
            pst.setInt(3, codFunc);
            pst.setInt(4, codLibera);
            pst.setInt(5, codLocal);
            pst.setString(6, objSoliMat.getObservacao());
            pst.setString(7, objSoliMat.getUsuarioUp());
            pst.setString(8, objSoliMat.getDataUp());
            pst.setString(9, objSoliMat.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC excluirSolicitacaoMaterial(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC finalizarSolicitacaoMaterial(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR SET StatusSol=? WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public void buscarSolicitante(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR WHERE NomeSolicitante='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFuncSolici");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao COLABORADOR a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarLiberador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR WHERE NomeAprovador='" + nome + "'");
            conecta.rs.first();
            codLibera = conecta.rs.getInt("IdFuncAprova");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do LIBERADOR a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarLocalArmazenamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do LOCAL a ser exibidos !!!");
        }
        conecta.desconecta();
    }
}
