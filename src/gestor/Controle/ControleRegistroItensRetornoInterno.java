/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegistroRetornoInterno;
import gestor.Modelo.RegistroRetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRegistroItensRetornoInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRegistroRetornoInterno objItensRetorno = new ItensRegistroRetornoInterno();
    RegistroRetornoInternos objRetorno = new RegistroRetornoInternos();
    int codInt;
    int qtdUnit = 1;
    String confirmacaoSaida = "Não";
    String nrDocumento = "";
    public static int qtdInternos = 0;
    String pBio = null;

    public ItensRegistroRetornoInterno incluirItensRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSREGISTRO (IdInternoCrc,IdRetorno,DataRetorno,OrigemRetorno,DocumentoRetorno,QtdSaida,HorarioRetorno,ConfirmacaoRetorno,UsuarioInsert,DataInsert,HorarioInsert,AssinaturaEntrada) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getNomerOrigem());
            pst.setString(5, objItensRetorno.getDocumento());
            pst.setInt(6, qtdUnit);
            pst.setString(7, objItensRetorno.getHorarioRetorno());
            pst.setString(8, objItensRetorno.getConfirmaRetorno());
            pst.setString(9, objItensRetorno.getUsuarioInsert());
            pst.setString(10, objItensRetorno.getDataInsert());
            pst.setString(11, objItensRetorno.getHoraInsert());
            pst.setBytes(12, objItensRetorno.getAssinaturaDigital());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel interno na tabela (ITENSREGISTRO) os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    public ItensRegistroRetornoInterno alterarItensRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET IdInternoCrc=?,IdRetorno=?,DataRetorno=?,OrigemRetorno=?,DocumentoRetorno=?,QtdSaida=?,HorarioRetorno=?,ConfirmacaoRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getNomerOrigem());
            pst.setString(5, objItensRetorno.getDocumento());
            pst.setInt(6, qtdUnit);
            pst.setString(7, objItensRetorno.getHorarioRetorno());
            pst.setString(8, objItensRetorno.getConfirmaRetorno());
            pst.setString(9, objItensRetorno.getUsuarioInsert());
            pst.setString(10, objItensRetorno.getDataInsert());
            pst.setString(11, objItensRetorno.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    //Método para excluir ITENS DE SAIDA
    public ItensRegistroRetornoInterno excluirItensRetorno(ItensRegistroRetornoInterno objItensRetorno) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSREGISTRO WHERE IdItem='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.executeUpdate();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    // Buscar INTERNO
    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> listaInternosRetorno = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM MOVISR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON MOVISR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON MOVISR.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "WHERE NrDocRetorno='" + nrDocumento + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));               
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaInternosRetorno.add(pDigital);
                qtdInternos++;
            }
            return listaInternosRetorno;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
