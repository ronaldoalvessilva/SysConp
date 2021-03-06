/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EmissaoAtestadoReclusao;
import static gestor.Visao.TelaEmissaoAtestadoReclusaoCRC.jComboBoxTipoSolicitante;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 

/**
 *
 * @author ronal
 */
public class ControleEmissaoAtestadoReclusaoCRC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmissaoAtestadoReclusao objEmissao = new EmissaoAtestadoReclusao();
    int codigoVisita;
    int codigoInterno;
    public static int qtdColaborador = 0;
    String statusVisita = "Ativo";
    String pBio = null;

    public EmissaoAtestadoReclusao incluirEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {
        if (jComboBoxTipoSolicitante.getSelectedItem().equals("Advogado")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Oficial de Justiça")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Visitas Diversas")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMISSAO_ATESTADO_RECLUSAO_CRC (StatusAtestado,ClassAtestado,DataAtestado,TipoSolicitante,DataValidade,IdVisita,IdInternoCrc,CodRegAux,TextoAtestado,AssinaturaColaborador,DataAssinatura,HoraAssinatura,CodigoValidador,ChaveInterno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEmissao.getStatusAtestado());
            pst.setString(2, objEmissao.getClassAtestado());
            pst.setTimestamp(3, new java.sql.Timestamp(objEmissao.getDataAtestado().getTime()));
            pst.setString(4, objEmissao.getTipoSolicitante());
            if (objEmissao.getDataValidade() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objEmissao.getDataValidade().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setInt(8, objEmissao.getCodRegAux());
            pst.setString(9, objEmissao.getTextoAtestado());
            pst.setBytes(10, objEmissao.getAssinaturaColaborador());
            pst.setString(11, objEmissao.getDataAssinatura());
            pst.setString(12, objEmissao.getHorarioLiberacao());
            pst.setBytes(13, objEmissao.getValidadorDados());
            pst.setBytes(14, objEmissao.getChaveInterno());
            pst.setString(15, objEmissao.getUsuarioInsert());
            pst.setString(16, objEmissao.getDataInsert());
            pst.setString(17, objEmissao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public EmissaoAtestadoReclusao alterarEmissaoAtestadoReclusao(EmissaoAtestadoReclusao objEmissao) {
        if (jComboBoxTipoSolicitante.getSelectedItem().equals("Advogado")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Oficial de Justiça")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Visitas Diversas")) {
            pesquisarAdvogado(objEmissao.getNomeSolicitanteAtestado(), objEmissao.getIdVisitaAtestado());
            pesquisarInterno(objEmissao.getNomeInternoAtestado(), objEmissao.getIdInternoAtestado());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO_CRC SET StatusAtestado=?,ClassAtestado=?,DataAtestado=?,TipoSolicitante=?,DataValidade=?,IdVisita=?,IdInternoCrc=?,CodRegAux=?,TextoAtestado=?,AssinaturaColaborador=?,DataAssinatura=?,HoraAssinatura=?,CodigoValidador=?,ChaveInterno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.setString(1, objEmissao.getStatusAtestado());
            pst.setString(2, objEmissao.getClassAtestado());
            pst.setTimestamp(3, new java.sql.Timestamp(objEmissao.getDataAtestado().getTime()));
            pst.setString(4, objEmissao.getTipoSolicitante());
            if (objEmissao.getDataValidade() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objEmissao.getDataValidade().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setInt(8, objEmissao.getCodRegAux());
            pst.setString(9, objEmissao.getTextoAtestado());
            pst.setBytes(10, objEmissao.getAssinaturaColaborador());
            pst.setString(11, objEmissao.getDataAssinatura());
            pst.setString(12, objEmissao.getHorarioLiberacao());
            pst.setBytes(13, objEmissao.getValidadorDados());
            pst.setBytes(14, objEmissao.getChaveInterno());
            pst.setString(15, objEmissao.getUsuarioUp());
            pst.setString(16, objEmissao.getDataUp());
            pst.setString(17, objEmissao.getHorarioUp());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMISSAO_ATESTADO_RECLUSAO_CRC WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO_CRC SET StatusAtestado=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO_CRC SET UtilizadoCrc=? WHERE CodRegAux='" + objEmissao.getCodRegAux() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMISSAO_ATESTADO_RECLUSAO_CRC SET ChaveInterno=? WHERE IdAtestado='" + objEmissao.getIdAtestado() + "'");
            pst.setBytes(1, objEmissao.getChaveInterno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR a CHAVE DE VALIDAÇÃO DO INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmissao;
    }

    public void pesquisarAdvogado(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADVOGADOS "
                    + "WHERE NomeAdvogado='" + nome + "' "
                    + "AND IdAdvogado='" + codigo + "'");
            conecta.rs.first();
            codigoVisita = conecta.rs.getInt("IdAdvogado");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmissaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void pesquisarOficialJustica(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OFICIAL_JUSTICA "
                    + "WHERE NomeOficial='" + nome + "' "
                    + "AND IdOficial='" + codigo + "'");
            conecta.rs.first();
            codigoVisita = conecta.rs.getInt("IdOficial");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmissaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void pesquisarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASDIVERSAS "
                    + "WHERE NomeVisita='" + nome + "' "
                    + "AND IdVisita='" + codigo + "'");
            conecta.rs.first();
            codigoVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmissaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleEmissaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }
}
