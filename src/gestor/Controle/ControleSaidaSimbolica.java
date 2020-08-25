/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.jCodigoReq;
import static gestor.Visao.TelaSaidaSimbolica.jIdRegistro;
import static gestor.Visao.TelaSaidaSimbolica.pTOTAL_registros;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleSaidaSimbolica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    public SaidaSimbolica incluirRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SAIDA_SIMBOLICA_CRC (StatusRegistro,DataRegistro,Nrdocumento,VaraCrime,NomeJuiz,LocalAudiencia,TipoBeneficio,MotivoSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objSaida.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaida.getDataRegistro().getTime()));
            pst.setString(3, objSaida.getNrdocumento());
            pst.setString(4, objSaida.getVaraCrime());
            pst.setString(5, objSaida.getNomeJuiz());
            pst.setString(6, objSaida.getLocalAudiencia());
            pst.setString(7, objSaida.getTipoBeneficio());
            pst.setString(8, objSaida.getMotivoSaida());
            pst.setString(9, objSaida.getUsuarioInsert());
            pst.setString(10, objSaida.getDataInsert());
            pst.setString(11, objSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica alterarRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDA_SIMBOLICA_CRC SET StatusRegistro=?,DataRegistro=?,Nrdocumento=?,VaraCrime=?,NomeJuiz=?,LocalAudiencia=?,TipoBeneficio=?,MotivoSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegSaida='" + objSaida.getIdRegSaida() + "'");
            pst.setString(1, objSaida.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objSaida.getDataRegistro().getTime()));
            pst.setString(3, objSaida.getNrdocumento());
            pst.setString(4, objSaida.getVaraCrime());
            pst.setString(5, objSaida.getNomeJuiz());
            pst.setString(6, objSaida.getLocalAudiencia());
            pst.setString(7, objSaida.getTipoBeneficio());
            pst.setString(8, objSaida.getMotivoSaida());
            pst.setString(9, objSaida.getUsuarioUp());
            pst.setString(10, objSaida.getDataUp());
            pst.setString(11, objSaida.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica excluirRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROMSAIDA_SIMBOLICA_CRC WHERE IdRegSaida='" + objSaida.getIdRegSaida() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica finalizarRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDA_SIMBOLICA_CRC SET StatusRegistro=? WHERE IdRegSaida='" + objSaida.getIdRegSaida() + "'");
            pst.setString(1, objSaida.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica PESQUISAR_status(SaidaSimbolica objSaida) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegSaida,StatusRegistro "
                    + "FROM SAIDA_SIMBOLICA_CRC "
                    + "WHERE IdRegSaida='" + jIdRegistro.getText() + "'");
            conecta.rs.first();
            objSaida.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível verificar se lançamento foi finalizado.\nERROR: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

//------------------------------------------------- ITENS INTERNOS
    public SaidaSimbolica incluirItensRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_SAIDA_SIMBOLICA_CRC (IdRegSaida,IdInternoCrc,NrdocumentoSA,DataRegistroSA,TipoBeneficioSA,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSaida.getIdRegSaida());
            pst.setInt(2, objSaida.getIdInternoCrc());
            pst.setString(3, objSaida.getNrdocumentoSA());
            if (objSaida.getDataRegistroSA() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objSaida.getDataRegistroSA().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objSaida.getTipoBeneficioSA());
            pst.setString(6, objSaida.getUsuarioInsert());
            pst.setString(7, objSaida.getDataInsert());
            pst.setString(8, objSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica alterarItensRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_SAIDA_SIMBOLICA_CRC SET IdRegSaida=?,IdInternoCrc=?,NrdocumentoSA=?,DataRegistroSA=?,TipoBeneficioSA=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objSaida.getIdItem() + "'");
            pst.setInt(1, objSaida.getIdRegSaida());
            pst.setInt(2, objSaida.getIdInternoCrc());
            pst.setString(3, objSaida.getNrdocumentoSA());
            if (objSaida.getDataRegistroSA() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objSaida.getDataRegistroSA().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objSaida.getTipoBeneficioSA());
            pst.setString(6, objSaida.getUsuarioUp());
            pst.setString(7, objSaida.getDataUp());
            pst.setString(8, objSaida.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica excluirItensRegistroSaida(SaidaSimbolica objSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_SAIDA_SIMBOLICA_CRC WHERE IdItem='" + objSaida.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    //----------------------------- PESQUISAS ------------------------------------------------------
    public List<SaidaSimbolica> read() throws Exception {
        pTOTAL_registros = 0;
        List<SaidaSimbolica> listaTodasSaidasSimbolicas = new ArrayList<SaidaSimbolica>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegSaida,StatusRegistro,DataRegistro, "
                    + "Nrdocumento,VaraCrime,NomeJuiz,LocalAudiencia,TipoBeneficio, "
                    + "MotivoSaida "
                    + "FROM SAIDA_SIMBOLICA_CRC");
            while (conecta.rs.next()) {
                SaidaSimbolica pSaidaSimbolica = new SaidaSimbolica();
                pSaidaSimbolica.setIdRegSaida(conecta.rs.getInt("IdRegSaida"));
                pSaidaSimbolica.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pSaidaSimbolica.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pSaidaSimbolica.setNrdocumento(conecta.rs.getString("Nrdocumento"));
                pSaidaSimbolica.setVaraCrime(conecta.rs.getString("VaraCrime"));
                pSaidaSimbolica.setNomeJuiz(conecta.rs.getString("NomeJuiz"));
                pSaidaSimbolica.setLocalAudiencia(conecta.rs.getString("LocalAudiencia"));
                pSaidaSimbolica.setTipoBeneficio(conecta.rs.getString("TipoBeneficio"));
                pSaidaSimbolica.setMotivoSaida(conecta.rs.getString("MotivoSaida"));
                listaTodasSaidasSimbolicas.add(pSaidaSimbolica);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaTodasSaidasSimbolicas;
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public SaidaSimbolica PESQUISAR_codigo(SaidaSimbolica objSaida) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegSaida "
                    + "FROM SAIDA_SIMBOLICA_CRC");
            conecta.rs.last();
            jIdRegistro.setText(String.valueOf(conecta.rs.getInt("IdRegSaida")));
        } catch (Exception ERROR) {
            Logger.getLogger(ControleCancelamentoPagoKit.class.getName()).log(Level.SEVERE, null, ERROR);
        }
        conecta.desconecta();
        return objSaida;
    }

    public SaidaSimbolica MOSTRAR_interno(SaidaSimbolica objSaida) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegSaida, "
                    + "StatusRegistro,DataRegistro, "
                    + "Nrdocumento,VaraCrime, "
                    + "NomeJuiz,LocalAudiencia,"
                    + "TipoBeneficio,MotivoSaida "
                    + "FROM SAIDA_SIMBOLICA_CRC "
                    + "WHERE IdRegSaida='" + jCodigoReq.getText() + "' ");
            conecta.rs.first();
            objSaida.setIdRegSaida(conecta.rs.getInt("IdRegSaida"));
            objSaida.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
            objSaida.setDataRegistro(conecta.rs.getDate("DataRegistro"));
            objSaida.setNrdocumento(conecta.rs.getString("Nrdocumento"));
            objSaida.setVaraCrime(conecta.rs.getString("VaraCrime"));
            objSaida.setNomeJuiz(conecta.rs.getString("NomeJuiz"));
            objSaida.setLocalAudiencia(conecta.rs.getString("LocalAudiencia"));
            objSaida.setTipoBeneficio(conecta.rs.getString("TipoBeneficio"));
            objSaida.setMotivoSaida(conecta.rs.getString("MotivoSaida"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidaSimbolica.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objSaida;
    }
}
