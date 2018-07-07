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
    String pBio = null;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    public static int qtdInternosReg = 0;
    String atendido = "Não";

    public RegistroAtendimentoInternos incluirRegAtend(RegistroAtendimentoInternos objRegAtend) {

        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        buscarDepartamento(objRegAtend.getNomeDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTRO_ATENDIMENTO_INTERNO_PSP (DataReg,Horario,IdInternoCrc,TipoAtendimento,IdDepartamento,AssinaturaDigital,Atendido,UsuarioInsert,DataInsert,HorarioInsert,Impresso) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(11, objRegAtend.getImpressaoAuto());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public RegistroAtendimentoInternos alterarRegAtend(RegistroAtendimentoInternos objRegAtend) {

        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_ATENDIMENTO_INTERNO_PSP SET Atendido=?,DataAtendimento=?,IdAtend=?,AtendeEvol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc() + "'AND Atendido='" + atendido + "'");
            pst.setString(1, objRegAtend.getAtendido());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegAtend.getDataAtendimento().getTime()));
            pst.setInt(3, objRegAtend.getIdAtend());            
            pst.setString(4, objRegAtend.getAtendeEvol());  
            pst.setString(5, objRegAtend.getUsuarioUp());
            pst.setString(6, objRegAtend.getDataUp());
            pst.setString(7, objRegAtend.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }
    public RegistroAtendimentoInternos alterarRegEvol(RegistroAtendimentoInternos objRegAtend) {

        buscarInternoCrc(objRegAtend.getNomeInternoCrc(), objRegAtend.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_ATENDIMENTO_INTERNO_PSP SET Atendido=?,DataAtendimento=?,IdAtend=?,IdEvol=?,AtendeEvol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRegAtend.getIdInternoCrc() + "'AND IdAtend='" + objRegAtend.getIdAtend() + "'");
            pst.setString(1, objRegAtend.getAtendido());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegAtend.getDataAtendimento().getTime()));
            pst.setInt(3, objRegAtend.getIdAtend());
            pst.setInt(4, objRegAtend.getIdEvol());
            pst.setString(5, objRegAtend.getAtendeEvol());
            pst.setString(6, objRegAtend.getUsuarioUp());
            pst.setString(7, objRegAtend.getDataUp());
            pst.setString(8, objRegAtend.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegAtend;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
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
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS "
                    + "WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDpto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (DEPARTAMENTOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> registroInternosAtend = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
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
            Logger.getLogger(ControleRegistroAtendimentoInternoBio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
