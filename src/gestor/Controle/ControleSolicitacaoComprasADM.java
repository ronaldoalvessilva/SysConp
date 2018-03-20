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
public class ControleSolicitacaoComprasADM {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoComprasAC objSoliMat = new SolicitacaoComprasAC();

    int codFunc, codLibera, codLocal;

    public SolicitacaoComprasAC incluirSolicitacaoMaterialADM(SolicitacaoComprasAC objSoliMat) {
        buscarColaborador(objSoliMat.getNomeColaborador());
        buscarLiberador(objSoliMat.getNomeLiberador());
        buscarLocalArmazenamento(objSoliMat.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITACAO_PRODUTOS_ADM (StatusSol,Situacao,DataSol,IdFunc,IdFuncAprova,IdLocal,TipoValor,Modulo,ValorAprovado,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.setString(2, objSoliMat.getSituacao());
            pst.setTimestamp(3, new java.sql.Timestamp(objSoliMat.getDataSol().getTime()));
            pst.setInt(4, codFunc);
            pst.setInt(5, codLibera);
            pst.setInt(6, codLocal);
            pst.setInt(7, objSoliMat.getTipoValor());
            pst.setString(8, objSoliMat.getModulo());
            pst.setFloat(9, objSoliMat.getValorAprovado());
            pst.setString(10, objSoliMat.getObservacao());
            pst.setString(11, objSoliMat.getUsuarioInsert());
            pst.setString(12, objSoliMat.getDataInsert());
            pst.setString(13, objSoliMat.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC alterarSolicitacaoMaterialADM(SolicitacaoComprasAC objSoliMat) {
        buscarColaborador(objSoliMat.getNomeColaborador());
        buscarLiberador(objSoliMat.getNomeLiberador());
        buscarLocalArmazenamento(objSoliMat.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_PRODUTOS_ADM SET StatusSol=?,Situacao=?,DataSol=?,IdFunc=?,IdFuncAprova=?,IdLocal=?,TipoValor=?,Modulo=?,ValorAprovado=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.setString(2, objSoliMat.getSituacao());
            pst.setTimestamp(3, new java.sql.Timestamp(objSoliMat.getDataSol().getTime()));
            pst.setInt(4, codFunc);
            pst.setInt(5, codLibera);
            pst.setInt(6, codLocal);
            pst.setInt(7, objSoliMat.getTipoValor());
            pst.setString(8, objSoliMat.getModulo());
            pst.setFloat(9, objSoliMat.getValorAprovado());
            pst.setString(10, objSoliMat.getObservacao());
            pst.setString(11, objSoliMat.getUsuarioUp());
            pst.setString(12, objSoliMat.getDataUp());
            pst.setString(13, objSoliMat.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC excluirSolicitacaoMaterialADM(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITACAO_PRODUTOS_ADM WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public SolicitacaoComprasAC finalizarSolicitacaoMaterialADM(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_PRODUTOS_ADM SET StatusSol=? WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.setString(1, objSoliMat.getStatusSol());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    //--------------------- ATUALIZAR CAMPO (ValorAprovado) DA TABELA SOLICITAÇÃO DE COMPRAS-----------------
    public SolicitacaoComprasAC alterarCampoSolicitacaoMaterialADM(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_PRODUTOS_ADM SET ValorAprovado=?,Situacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSol='" + objSoliMat.getIdSol() + "'");
            pst.setFloat(1, objSoliMat.getValorAprovado());
            pst.setString(2, objSoliMat.getSituacao());
            pst.setString(3, objSoliMat.getUsuarioUp());
            pst.setString(4, objSoliMat.getDataUp());
            pst.setString(5, objSoliMat.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR CAMPO VALOR DO ITEM da solicitação.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }
    
 //--------------------- ATUALIZAR CAMPO (ValorSaldoSolicita, ValorSaldoPedido) DA TABELA APROVADOR_SOLICITACAO_COMPRAS_AC-----------------
    public SolicitacaoComprasAC atualizarSaldoLiberadorCompras(SolicitacaoComprasAC objSoliMat) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APROVADOR_SOLICITACAO_COMPRAS_AC SET ValorSaldoSolicita=? WHERE IdFuncAprova='" + objSoliMat.getIdLibera() + "'");
            pst.setFloat(1, objSoliMat.getValorSaldoRequisicao());                  
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ATUALIZAR SALDO do aprovador.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSoliMat;
    }

    public void buscarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao COLABORADOR a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarLiberador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM APROVADOR_SOLICITACAO_COMPRAS_AC WHERE NomeAprovador='" + nome + "'");
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
