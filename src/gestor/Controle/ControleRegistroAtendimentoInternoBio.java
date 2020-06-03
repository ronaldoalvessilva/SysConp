/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroAtendimentoInternos;
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
public class ControleRegistroAtendimentoInternoBio {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();

    int codInt;
    int codDpto;
    int codigoColaborador;
    String pBio = null;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    public static int qtdInternosReg = 0;
    String pAtendido = "Não";

    public RegistroAtendimentoInternos incluirRegAtend(RegistroAtendimentoInternos objRegAtend) {

        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        buscarDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_ATENDIMENTO_INTERNO_PSP (DataReg,Horario,IdInternoCrc,TipoAtendimento,IdDepartamento,AssinaturaDigital,Atendido,UsuarioInsert,DataInsert,HorarioInsert,Qtd,UsuarioAtendente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objRegAtend.getDataReg().getTime()));
            pst.setString(2, objRegAtend.getHorario());
            pst.setInt(3, codInt);
            pst.setString(4, objRegAtend.getTipoAtemdimento());
            pst.setInt(5, codDpto);
            pst.setBytes(6, objRegAtend.getAssinaturaDigital());
            pst.setString(7, objRegAtend.getAtendido());
            pst.setString(8, objRegAtend.getUsuarioInsert());
            pst.setString(9, objRegAtend.getDataInsert());
            pst.setString(10, objRegAtend.getHorarioInsert());
            pst.setInt(11, objRegAtend.getQtdAtend());
            pst.setString(12, objRegAtend.getUsuarioAtendente());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos incluirRegAtendColaborador(RegistroAtendimentoInternos objRegAtend) {

        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        buscarDepartamento(objRegAtend.getNomeDepartamento());
        buscarColaborador(objRegAtend.getNomeFunc(), objRegAtend.getCodigoFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_ATENDIMENTO_INTERNO_PSP (DataReg,Horario,IdInternoCrc,TipoAtendimento,IdDepartamento,IdFunc,AssinaturaDigital,AssinaturaLiberador,DataAssinatura,HoraAssinatura,Atendido,Motivo,UsuarioInsert,DataInsert,HorarioInsert,Impresso,UsuarioAtendente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objRegAtend.getDataReg().getTime()));
            pst.setString(2, objRegAtend.getHorario());
            pst.setInt(3, codInt);
            pst.setString(4, objRegAtend.getTipoAtemdimento());
            pst.setInt(5, codDpto);
            pst.setInt(6, codigoColaborador);
            pst.setBytes(7, objRegAtend.getAssinaturaDigital());
            pst.setBytes(8, objRegAtend.getAssinaturaLiberador());
            pst.setString(9, objRegAtend.getDataAssinatura());
            pst.setString(10, objRegAtend.getHoraAssinatura());
            pst.setString(11, objRegAtend.getAtendido());
            pst.setString(12, objRegAtend.getMotivoImpressao());
            pst.setString(13, objRegAtend.getUsuarioInsert());
            pst.setString(14, objRegAtend.getDataInsert());
            pst.setString(15, objRegAtend.getHorarioInsert());
            pst.setString(16, objRegAtend.getImpressaoAuto());
            pst.setString(17, objRegAtend.getUsuarioAtendente());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR - REGISTRO os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos alterarRegAtend(RegistroAtendimentoInternos objRegAtend) {
        buscarDepartamento(objRegAtend.getNomeDepartamento());
        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_ATENDIMENTO_INTERNO_PSP SET TipoAtendimento=?,IdDepartamento=?,Atendido=?,DataAtendimento=?,IdAtend=?,AtendeEvol=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Qtd=? "
                    + "WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc() + "' "
                    + "AND Atendido='" + pAtendido + "' "
                    + "AND IdDepartamento='" + objRegAtend.getIdDepartamento() + "'");
            pst.setString(1, objRegAtend.getTipoAtemdimento());
            pst.setInt(2, codDpto);
            pst.setString(3, objRegAtend.getAtendido());
            pst.setTimestamp(4, new java.sql.Timestamp(objRegAtend.getDataAtendimento().getTime()));
            pst.setInt(5, objRegAtend.getIdAtend());
            pst.setString(6, objRegAtend.getAtendeEvol());
            pst.setString(7, objRegAtend.getUsuarioUp());
            pst.setString(8, objRegAtend.getDataUp());
            pst.setString(9, objRegAtend.getHorarioUp());
            pst.setInt(10, objRegAtend.getQtdAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos alterarRegEvol(RegistroAtendimentoInternos objRegAtend) {
        buscarDepartamento(objRegAtend.getNomeDepartamento());
        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_ATENDIMENTO_INTERNO_PSP SET TipoAtendimento=?,IdDepartamento=?,Atendido=?,DataAtendimento=?,IdAtend=?,IdEvol=?,AtendeEvol=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Qtd=? "
                    + "WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc() + "' "
                    + "AND Atendido='" + pAtendido + "'");
            pst.setString(1, objRegAtend.getTipoAtemdimento());
            pst.setInt(2, codDpto);
            pst.setString(3, objRegAtend.getAtendido());
            pst.setTimestamp(4, new java.sql.Timestamp(objRegAtend.getDataAtendimento().getTime()));
            pst.setInt(5, objRegAtend.getIdAtend());
            pst.setInt(6, objRegAtend.getIdEvol());
            pst.setString(7, objRegAtend.getAtendeEvol());
            pst.setString(8, objRegAtend.getUsuarioUp());
            pst.setString(9, objRegAtend.getDataUp());
            pst.setString(10, objRegAtend.getHorarioUp());
            pst.setInt(11, objRegAtend.getQtdAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos finalizarAtendimentoGrupoPSI(RegistroAtendimentoInternos objRegAtend) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PSICOLOGIA SET StatusAtendGrupo=? WHERE IdAtGrupoPsi='" + objRegAtend.getIdAtend() + "'");
            pst.setString(1, objRegAtend.getStatusAtendimento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    //EDUCAÇÃO FÍSICA
    public RegistroAtendimentoInternos finalizarAtendimentoGrupoEF(RegistroAtendimentoInternos objRegAtend) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_EF SET StatusAtendGrupo=? WHERE IdAtGrupoEF='" + objRegAtend.getIdAtend() + "'");
            pst.setString(1, objRegAtend.getStatusAtendimento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    //------------------------ ATENDIMENTO EM GRUPO -------------------------------------------//
    public RegistroAtendimentoInternos incluirRegAtendGrupo(RegistroAtendimentoInternos objRegAtend) {

//        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
//        buscarDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_ATENDIMENTO_INTERNO_PSP (IdAtend,DataAtendimento,DataReg,Horario,IdInternoCrc,TipoAtendimento,IdDepartamento,IdFunc,AssinaturaLiberador,DataAssinatura,HoraAssinatura,Atendido,Motivo,UsuarioInsert,DataInsert,HorarioInsert,Qtd,UsuarioAtendente,Impresso) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objRegAtend.getIdAtend());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegAtend.getDataAtendimento().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objRegAtend.getDataReg().getTime()));
            pst.setString(4, objRegAtend.getHorario());
            pst.setInt(5, objRegAtend.getIdInternoCrc());
            pst.setString(6, objRegAtend.getTipoAtemdimento());
            pst.setInt(7, objRegAtend.getIdDepartamento());
            pst.setInt(8, objRegAtend.getCodigoFunc());
            pst.setBytes(9, objRegAtend.getAssinaturaLiberador());
            pst.setString(10, objRegAtend.getDataAssinatura());
            pst.setString(11, objRegAtend.getHoraAssinatura());
            pst.setString(12, objRegAtend.getAtendido());
            pst.setString(13, objRegAtend.getMotivoImpressao());
            pst.setString(14, objRegAtend.getUsuarioInsert());
            pst.setString(15, objRegAtend.getDataInsert());
            pst.setString(16, objRegAtend.getHorarioInsert());
            pst.setInt(17, objRegAtend.getQtdAtend());
            pst.setString(18, objRegAtend.getUsuarioAtendente());
            pst.setString(19, objRegAtend.getImpressaoAuto());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdInternoCrc,NomeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdDepartamento, "
                    + "NomeDepartamento "
                    + "FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDpto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DEPARTAMENTOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarColaborador(String nomeFunc, int idFunc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT NomeFunc,IdFunc "
                    + "FROM COLABORADOR "
                    + "WHERE NomeFunc='" + nomeFunc + "' "
                    + "AND IdFunc='" + idFunc + "'");
            conecta.rs.first();
            codigoColaborador = conecta.rs.getInt("IdFunc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (COLABORADOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> registroInternosAtend = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "PRONTUARIOSCRC.Cnc,PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "DADOSPENAISINTERNOS.Regime,PAVILHAO.DescricaoPav, "
                    + "CELAS.EndCelaPav,BIOMETRIA_INTERNOS.BiometriaDedo1, "
                    + "BIOMETRIA_INTERNOS.BiometriaDedo2, "
                    + "BIOMETRIA_INTERNOS.BiometriaDedo3, "
                    + "BIOMETRIA_INTERNOS.BiometriaDedo4 "
                    + "FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "WHERE PRONTUARIOSCRC.SituacaoCrc='" + situacaoEnt + "' "
                    + "AND BiometriaDedo1!='" + pBio + "' "
                    + "OR PRONTUARIOSCRC.SituacaoCrc='" + situacaoRet + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("Cnc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                registroInternosAtend.add(pDigital);
                qtdInternosReg++;
            }
            return registroInternosAtend;
        } catch (SQLException ex) {
            Logger.getLogger(ControleRegistroAtendimentoInternoBio_ENF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
