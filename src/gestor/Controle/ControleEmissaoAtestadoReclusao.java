/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EmissaoAtestadoReclusao;
import gestor.Modelo.SolicitacaoAtestadoReclusao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleEmissaoAtestadoReclusao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmissaoAtestadoReclusao objEmissao = new EmissaoAtestadoReclusao();
    int codigoVisita;
    int codigoInterno;
    public static int qtdColaborador = 0;
    String statusVisita = "Ativo";
    String pBio = null;

    public EmissaoAtestadoReclusao incluirEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {
        pesquisarVisita(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
        pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMISSAO_ATESTADO_RECLUSAO (StatusAtestado,ClassAtestado,DataAtestado,DataValidade,IdVisita,IdInternoCrc,CodRegAux,TextoAtestado,AssinaturaColaborador,DataAssinatura,HoraAssinatura,CodigoValidador,ChaveInterno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEmissao.getStatusAtestado());
            pst.setString(2, objEmissao.getClassAtestado());
            pst.setTimestamp(3, new java.sql.Timestamp(objEmissao.getDataAtestado().getTime()));
            if (objEmissao.getDataValidade() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEmissao.getDataValidade().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setInt(5, codigoVisita);
            pst.setInt(6, codigoInterno);
            pst.setInt(7, objEmissao.getCodRegAux());
            pst.setString(8, objEmissao.getTextoAtestado());
            pst.setBytes(9, objEmissao.getAssinaturaColaborador());
            pst.setString(10, objEmissao.getDataAssinatura());
            pst.setString(11, objEmissao.getHorarioLiberacao());
            pst.setBytes(12, objEmissao.getValidadorDados());
            pst.setBytes(13, objEmissao.getChaveInterno());
            pst.setString(14, objEmissao.getUsuarioInsert());
            pst.setString(15, objEmissao.getDataInsert());
            pst.setString(16, objEmissao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao alterarEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {
        pesquisarVisita(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
        pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO SET StatusAtestado=?,ClassAtestado=?,DataAtestado=?,DataValidade=?,IdVisita=?,IdInternoCrc=?,CodRegAux=?,TextoAtestado=?,AssinaturaColaborador=?,DataAssinatura=?,HoraAssinatura=?,CodigoValidador=?,ChaveInterno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.setString(1, objEmissao.getStatusAtestado());
            pst.setString(2, objEmissao.getClassAtestado());
            pst.setTimestamp(3, new java.sql.Timestamp(objEmissao.getDataAtestado().getTime()));
            if (objEmissao.getDataValidade() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEmissao.getDataValidade().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setInt(5, codigoVisita);
            pst.setInt(6, codigoInterno);
            pst.setInt(7, objEmissao.getCodRegAux());
            pst.setString(8, objEmissao.getTextoAtestado());
            pst.setBytes(9, objEmissao.getAssinaturaColaborador());
            pst.setString(10, objEmissao.getDataAssinatura());
            pst.setString(11, objEmissao.getHorarioLiberacao());
            pst.setBytes(12, objEmissao.getValidadorDados());
            pst.setBytes(13, objEmissao.getChaveInterno());
            pst.setString(14, objEmissao.getUsuarioUp());
            pst.setString(15, objEmissao.getDataUp());
            pst.setString(16, objEmissao.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao excluirEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMISSAO_ATESTADO_RECLUSAO WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao finalizarEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO SET StatusAtestado=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.setString(1, objEmissao.getStatusAtestado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao confirmarEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO SET UtilizadoCrc=? WHERE CodRegAux='" + objEmissao.getCodRegAux() + "'");
            pst.setString(1, objEmissao.getUtilizadoCrc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR a TABELA SOLICITACAO_ATESTADO_RECLUSAO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao gravarCriptografiaEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO SET ChaveInterno=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.setBytes(1, objEmissao.getChaveInterno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR a CHAVE DE VALIDAÇÃO DO INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public void pesquisarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO "
                    + "WHERE NomeVisita='" + nome + "' "
                    + "AND IdVisita='" + codigo + "'");
            conecta.rs.first();
            codigoVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmissaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void pesquisarInterno(String nomeInt, int codigoInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nomeInt + "' "
                    + "AND IdInternoCrc='" + codigoInt + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmissaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }
}
