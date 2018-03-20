/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegSaidaInternos;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.RegistroSaidaPortaria;
import gestor.Modelo.TransferenciaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensRegSaidaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroSaidaPortaria objSaida = new RegistroSaidaPortaria();
    ItensRegSaidaInternos objItemSaida = new ItensRegSaidaInternos();
    //
    ItensTransInterno objItensTrans = new ItensTransInterno(); // Dados dos itens do internos TRANSFRÊNCIA
    TransferenciaInternos objTrans = new TransferenciaInternos(); // Dados da capa

    int codInt;
    int qtdUnit = 1;
    //
    int codInterno;
    String pBio = null;
    public static int qtdInternos = 0;
    String confirmacaoSaida = "Não";
    String nrDocumento = "";

    public ItensRegSaidaInternos incluirItensRegSaida(ItensRegSaidaInternos objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSREGSAIDA (IdInternoCrc,IdSaida,DataSaida,DestinoSaida,DocumentoSaida,ConfirmaSaida,IdSaidaTmp,HoraSaida,QtdSaida,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaSaida) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(4, objItemSaida.getNomeDestino());
            pst.setString(5, objItemSaida.getDocumento());
            pst.setString(6, objItemSaida.getConfirmaSaida());
            pst.setString(7, objItemSaida.getIdItemRegSaida());
            pst.setString(8, objItemSaida.getHorarioSaida());
            pst.setInt(9, qtdUnit);
            pst.setString(10, objItemSaida.getUsuarioInsert());
            pst.setString(11, objItemSaida.getDataInsert());
            pst.setString(12, objItemSaida.getHoraInsert());
            pst.setBytes(13, objItemSaida.getAssinaturaDigital());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    public ItensRegSaidaInternos alterarItensRegSaida(ItensRegSaidaInternos objItemSaida) {
        //Pesquisar Nome do Interno através do código
        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGSAIDA SET IdInternoCrc=?,IdSaida=?,DataSaida=?,DestinoSaida=?,DocumentoSaida=?,ConfirmaSaida=?,IdSaidaTmp=?,HoraSaida=?,QtdSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItemSaida.getIdItemSaida() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            pst.setString(4, objItemSaida.getNomeDestino());
            pst.setString(5, objItemSaida.getDocumento());
            pst.setString(6, objItemSaida.getConfirmaSaida());
            pst.setString(7, objItemSaida.getIdItemRegSaida());
            pst.setString(8, objItemSaida.getHorarioSaida());
            pst.setInt(9, qtdUnit);
            pst.setString(10, objItemSaida.getUsuarioUp());
            pst.setString(11, objItemSaida.getDataUp());
            pst.setString(12, objItemSaida.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //Método para excluir ITENS DE SAIDA
    public ItensRegSaidaInternos excluirItensRegSaida(ItensRegSaidaInternos objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSREGSAIDA WHERE IdItem='" + objItemSaida.getIdItemSaida() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // Confirma a saida na tabela ITENSSAIDA
    public ItensRegSaidaInternos confirmaRegistroSaida(ItensRegSaidaInternos objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET SaidaConfirmada=?,HoraSaida=? WHERE IdSaida='" + objItemSaida.getIdItemSaida() + "'AND IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'");
            pst.setString(1, objItemSaida.getConfirmaSaida());
            pst.setString(2, objItemSaida.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // Confirma a saida na tabela ITENSCRCPORTARIA 
    public ItensRegSaidaInternos confirmaRegSaidaItensCrcPort(ItensRegSaidaInternos objItemSaida) {
// Modificado em 01/06/2015 pois não estava funcionando 100% - Foi testado com sucesso na base de teste.
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET SaidaConfirmada=? WHERE IdItemSaida='" + objItemSaida.getIdItemCrcPortaria() + "'AND IdInternoCrc='" + objItemSaida.getIdInternoSaida() + "'AND IdSaida='" + objItemSaida.getIdItemSaida() + "'");
            pst.setString(1, objItemSaida.getConfirmaSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    ///----------------------------------------
    // Confirma a saida na tabela ITENSTRANSFERENCIA
    public ItensTransInterno confirmaRegistroTransferencia(ItensTransInterno objItensTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSTRANSFERENCIA SET SaidaConfirmada=? WHERE IdItem='" + objItensTrans.getIdItemTrans() + "'");
            pst.setString(1, objItensTrans.getConfirmaSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    // Buscar INTERNO
    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "' AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> listaInternosSaida = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "WHERE SaidaConfirmada='" + confirmacaoSaida + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setIdItemSaida(conecta.rs.getString("IdSaida"));
                pDigital.setIdItemCrcPort(conecta.rs.getInt("IdItemSaida"));                
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaInternosSaida.add(pDigital);
                qtdInternos++;
            }
            return listaInternosSaida;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
