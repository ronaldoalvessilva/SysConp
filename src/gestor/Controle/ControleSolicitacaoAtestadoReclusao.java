/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DigitalVisitasInterno;
import gestor.Modelo.SolicitacaoAtestadoReclusao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleSolicitacaoAtestadoReclusao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SolicitacaoAtestadoReclusao objSolicitaAux = new SolicitacaoAtestadoReclusao();
    int codigoVisita;
    int codigoInterno;
    public static int qtdVisitasInterno = 0;
    String statusVisita = "Ativo";
    String pBio = null;

    public SolicitacaoAtestadoReclusao incluirSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {
        pesquisarVisita(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
        pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOLICITACAO_ATESTADO_RECLUSAO (DataRegAux,StatusAux,Finalidade,DataPedAux,DataPrevAux,IdVisita,IdInternoCrc,MotivoAux,AssinaturaVisita,AssinaturaInterno,DataAssinaturaVisita,HoraAssinaturaVisita,DataAssinaturaInterno,HoraAssinaturaInterno,UtilizadoCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objSolicitaAux.getDataRegAux().getTime()));
            pst.setString(2, objSolicitaAux.getStatusAux());
            pst.setString(3, objSolicitaAux.getFinalidade());
            pst.setTimestamp(4, new java.sql.Timestamp(objSolicitaAux.getDataPedAux().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objSolicitaAux.getDataPrevAux().getTime()));
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setString(8, objSolicitaAux.getMotivoAux());
            pst.setBytes(9, objSolicitaAux.getAssinaturaVisita());
            pst.setBytes(10, objSolicitaAux.getAssinaturaInterno());
            if (objSolicitaAux.getDataAssinaturaVisita() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objSolicitaAux.getDataAssinaturaVisita().getTime()));
            } else {
                pst.setDate(11, null);
            }
            pst.setString(12, objSolicitaAux.getHoraAssinaturaVisita());
            if (objSolicitaAux.getDataAssinaturaInterno() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objSolicitaAux.getDataAssinaturaInterno().getTime()));
            } else {
                pst.setDate(13, null);
            }
            pst.setString(14, objSolicitaAux.getHoraAssinaturaInterno());
            pst.setString(15, objSolicitaAux.getUtilizacao());
            pst.setString(16, objSolicitaAux.getUsuarioInsert());
            pst.setString(17, objSolicitaAux.getDataInsert());
            pst.setString(18, objSolicitaAux.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
    }

    public SolicitacaoAtestadoReclusao alterarSolicitacaoAtestadoReclusao(SolicitacaoAtestadoReclusao objSolicitaAux) {
        pesquisarVisita(objSolicitaAux.getNomeVisitaSolicitanteAux(), objSolicitaAux.getIdVisitaAux());
        pesquisarInterno(objSolicitaAux.getNomeInternoCrc(), objSolicitaAux.getIdInternoAux());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO SET DataRegAux=?,StatusAux=?,Finalidade=?,DataPedAux=?,DataPrevAux=?,IdVisita=?,IdInternoCrc=?,MotivoAux=?,AssinaturaVisita=?,AssinaturaInterno=?,DataAssinaturaVisita=?,HoraAssinaturaVisita=?,DataAssinaturaInterno=?,HoraAssinaturaInterno=?,UtilizadoCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objSolicitaAux.getDataRegAux().getTime()));
            pst.setString(2, objSolicitaAux.getStatusAux());
            pst.setString(3, objSolicitaAux.getFinalidade());
            pst.setTimestamp(4, new java.sql.Timestamp(objSolicitaAux.getDataPedAux().getTime()));
            pst.setTimestamp(5, new java.sql.Timestamp(objSolicitaAux.getDataPrevAux().getTime()));
            pst.setInt(6, codigoVisita);
            pst.setInt(7, codigoInterno);
            pst.setString(8, objSolicitaAux.getMotivoAux());
            pst.setBytes(9, objSolicitaAux.getAssinaturaVisita());
            pst.setBytes(10, objSolicitaAux.getAssinaturaInterno());
            if (objSolicitaAux.getDataAssinaturaVisita() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objSolicitaAux.getDataAssinaturaVisita().getTime()));
            } else {
                pst.setDate(11, null);
            }
            pst.setString(12, objSolicitaAux.getHoraAssinaturaVisita());
            if (objSolicitaAux.getDataAssinaturaInterno() != null) {
                pst.setTimestamp(13, new java.sql.Timestamp(objSolicitaAux.getDataAssinaturaInterno().getTime()));
            } else {
                pst.setDate(13, null);
            }
            pst.setString(14, objSolicitaAux.getHoraAssinaturaInterno());
            pst.setString(15, objSolicitaAux.getUtilizacao());
            pst.setString(16, objSolicitaAux.getUsuarioUp());
            pst.setString(17, objSolicitaAux.getDataUp());
            pst.setString(18, objSolicitaAux.getHorarioUp());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOLICITACAO_ATESTADO_RECLUSAO WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO SET StatusAux=? WHERE CodRegAux='" + objSolicitaAux.getCodRegAux() + "'");           
            pst.setString(1, objSolicitaAux.getStatusAux());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSolicitaAux;
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSolicitacaoAtestadoReclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public List<DigitalVisitasInterno> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalVisitasInterno> listaVistasInterno = new ArrayList<DigitalVisitasInterno>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSROL "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON VISITASINTERNO.IdVisita=ITENSROL.IdVisita "
                    + "INNER JOIN ROLVISITAS "
                    + "ON ITENSROL.IdRol=ROLVISITAS.IdRol "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ROLVISITAS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO ON CELAS.IdPav=PAVILHAO.IdPav  "
                    + "WHERE VISITASINTERNO.BiometriaDedo1!='" + pBio + "' "
                    + "AND VISITASINTERNO.StatusVisita='" + statusVisita + "' ");
            while (conecta.rs.next()) {
                DigitalVisitasInterno pDigi = new DigitalVisitasInterno();
                pDigi.setIdVisita(conecta.rs.getInt("IdVisita"));
                pDigi.setNomeVisita(conecta.rs.getString("NomeVisita"));
                pDigi.setStatusVisita(conecta.rs.getString("StatusVisita"));
                pDigi.setGrauParentesco(conecta.rs.getString("ParentescoVisita"));
                pDigi.setFotoVisita(conecta.rs.getString("ImagemVisita"));
                pDigi.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigi.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigi.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigi.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                pDigi.setImagemFrenteVI(conecta.rs.getBytes("ImagemFrenteVI"));
                listaVistasInterno.add(pDigi);
                qtdVisitasInterno++;
            }
            return listaVistasInterno;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
