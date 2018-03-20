/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoInternoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAtendimentoInternosSocial {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoInternoSocial objAtendInt = new AtendimentoInternoSocial();
    int codInternoCrc;
    
    public AtendimentoInternoSocial incluirAtendInternoSocial(AtendimentoInternoSocial objAtendInt) {
        pesquisarInterno(objAtendInt.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOINTERNO (StatusLanc,DataLanc,IdInternoCrc,PedidoRec,DataPedRec,EncaSetor,QualSetor,EncaTirarDoc,DataTirarDoc,EncaRecPai,DataRecPai,CancelaVisita,MotivoCancelVisita,Outros,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtendInt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendInt.getDataLanc().getTime()));
            pst.setInt(3, codInternoCrc);
            pst.setString(4, objAtendInt.getPedidoRec());
            if (objAtendInt.getDataPedRec() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objAtendInt.getDataPedRec().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objAtendInt.getEncaSetor());
            pst.setString(7, objAtendInt.getQualSetor());
            pst.setString(8, objAtendInt.getEncaTirarDoc());
            if (objAtendInt.getDataRecPai() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objAtendInt.getDataTirarDoc().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objAtendInt.getEncaRecPai());
            if (objAtendInt.getDataRecPai() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objAtendInt.getDataRecPai().getTime()));                
            } else {
                pst.setDate(11, null);
            }            
            pst.setString(12, objAtendInt.getCancelaVisita());
            pst.setString(13, objAtendInt.getMotivoCancelVisita());
            pst.setString(14, objAtendInt.getOutros());
            pst.setString(15, objAtendInt.getObservacao());
            pst.setString(16, objAtendInt.getUsuarioInsert());
            pst.setString(17, objAtendInt.getDataInsert());
            pst.setString(18, objAtendInt.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendInt;
    }
    
    public AtendimentoInternoSocial alterarAtendInternoSocial(AtendimentoInternoSocial objAtendInt) {
        pesquisarInterno(objAtendInt.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOINTERNO SET StatusLanc=?,DataLanc=?,IdInternoCrc=?,PedidoRec=?,DataPedRec=?,EncaSetor=?,QualSetor=?,EncaTirarDoc=?,DataTirarDoc=?,EncaRecPai=?,DataRecPai=?,CancelaVisita=?,MotivoCancelVisita=?,Outros=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAtendInt.getIdLanc() + "'");
            pst.setString(1, objAtendInt.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendInt.getDataLanc().getTime()));
            pst.setInt(3, codInternoCrc);
            pst.setString(4, objAtendInt.getPedidoRec());
            if (objAtendInt.getDataPedRec() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objAtendInt.getDataPedRec().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objAtendInt.getEncaSetor());
            pst.setString(7, objAtendInt.getQualSetor());
            pst.setString(8, objAtendInt.getEncaTirarDoc());
            if (objAtendInt.getDataRecPai() != null) {
                pst.setTimestamp(9, new java.sql.Timestamp(objAtendInt.getDataTirarDoc().getTime()));
            } else {
                pst.setDate(9, null);
            }
            pst.setString(10, objAtendInt.getEncaRecPai());
            if (objAtendInt.getDataRecPai() != null) {
                pst.setTimestamp(11, new java.sql.Timestamp(objAtendInt.getDataRecPai().getTime()));                
            } else {
                pst.setDate(11, null);
            }            
            pst.setString(12, objAtendInt.getCancelaVisita());
            pst.setString(13, objAtendInt.getMotivoCancelVisita());
            pst.setString(14, objAtendInt.getOutros());
            pst.setString(15, objAtendInt.getObservacao());
            pst.setString(16, objAtendInt.getUsuarioUp());
            pst.setString(17, objAtendInt.getDataUp());
            pst.setString(18, objAtendInt.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendInt;
    }
    
    public AtendimentoInternoSocial excluirAtendInternoSocial(AtendimentoInternoSocial objAtendInt) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOINTERNO WHERE IdLanc='" + objAtendInt.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendInt;
    }
    
    public AtendimentoInternoSocial finalizarAtendInternoSocial(AtendimentoInternoSocial objAtendInt) {
        
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOINTERNO SET StatusLanc=? WHERE IdLanc='" + objAtendInt.getIdLanc() + "'");
            pst.setString(1, objAtendInt.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtendInt;
    }
    
    public void pesquisarInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar o nome do interno, talvez ela esteja inativa." + e);
        }
        conecta.desconecta();
    }
}
