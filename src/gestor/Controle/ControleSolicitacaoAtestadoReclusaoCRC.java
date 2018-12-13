/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SolicitacaoAtestadoReclusao;
import static gestor.Visao.TelaSolicitacaoAuxilioReclusaoCRC.jComboBoxTipoSolicitante;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleSolicitacaoAtestadoReclusaoCRC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoAtestadoReclusao objSolicitaAux = new SolicitacaoAtestadoReclusao();
    int codigoVisita;
    int codigoInterno;
    public static int qtdVisitasInterno = 0;
    String statusVisita = "Ativo";
    String pBio = null;

    public SolicitacaoAtestadoReclusao incluirSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {
        if (jComboBoxTipoSolicitante.getSelectedItem().equals("Advogado")) {
            pesquisarAdvogado(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Oficial de Justiça")) {
            pesquisarOficialJustica(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Visitas Diversas")) {
            pesquisarVisita(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITACAO_ATESTADO_RECLUSAO_CRC (DataRegAux,StatusAux,Finalidade,DataPedAux,DataPrevAux,IdVisita,IdInternoCrc,MotivoAux,UtilizadoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objSolicitaAux.getDataRegAux().getTime()));
            pst.setString(2, objSolicitaAux.getStatusAux());
            pst.setString(3, objSolicitaAux.getFinalidade());
            pst.setTimestamp(4, new java.sql.Timestamp(objSolicitaAux.getDataPedAux().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objSolicitaAux.getDataPrevAux().getTime()));
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setString(8, objSolicitaAux.getMotivoAux());
            pst.setString(9, objSolicitaAux.getUtilizacao());
            pst.setString(10, objSolicitaAux.getUsuarioInsert());
            pst.setString(11, objSolicitaAux.getDataInsert());
            pst.setString(12, objSolicitaAux.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
    }

    public SolicitacaoAtestadoReclusao alterarSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {
        if (jComboBoxTipoSolicitante.getSelectedItem().equals("Advogado")) {
            pesquisarAdvogado(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Oficial de Justiça")) {
            pesquisarOficialJustica(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        } else if (jComboBoxTipoSolicitante.getSelectedItem().equals("Visitas Diversas")) {
            pesquisarVisita(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
            pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        }
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO_CRC SET DataRegAux=?,StatusAux=?,Finalidade=?,DataPedAux=?,DataPrevAux=?,IdVisita=?,IdInternoCrc=?,MotivoAux=?,UtilizadoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objSolicitaAux.getDataRegAux().getTime()));
            pst.setString(2, objSolicitaAux.getStatusAux());
            pst.setString(3, objSolicitaAux.getFinalidade());
            pst.setTimestamp(4, new java.sql.Timestamp(objSolicitaAux.getDataPedAux().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objSolicitaAux.getDataPrevAux().getTime()));
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setString(8, objSolicitaAux.getMotivoAux());
            pst.setString(9, objSolicitaAux.getUtilizacao());
            pst.setString(10, objSolicitaAux.getUsuarioUp());
            pst.setString(11, objSolicitaAux.getDataUp());
            pst.setString(12, objSolicitaAux.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
    }

    public SolicitacaoAtestadoReclusao excluirSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITACAO_ATESTADO_RECLUSAO_CRC WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
    }

    public SolicitacaoAtestadoReclusao finalizarSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO_CRC SET StatusAux=? WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");
            pst.setString(1, objSolicitaAux.getStatusAux());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusaoCRC.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }
}
