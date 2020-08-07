/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPagamentoKitInterno;
import static gestor.Visao.TelaPagamentoKitInternoCPK.jComboBoxPavilhao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class CancelamentoPagamentoKitInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();

    int codInterno;
    String pBio = null;
    public static int qtdInternos = 0;
    String statusFinal = "FINALIZADO";

    public ItensPagamentoKitInterno incluirPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {
        buscarInterno(objItensPagto.getNomeInternoCrcKit(), objItensPagto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS (IdRegistro,IdInternoCrc,"
                    + "DataEntrega,Horario,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);

            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objItensPagto.getHoraEntrega());
            pst.setString(5, objItensPagto.getUsuarioInsert());
            pst.setString(6, objItensPagto.getDataInsert());
            pst.setString(7, objItensPagto.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno alterarPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {
        buscarInterno(objItensPagto.getNomeInternoCrcKit(), objItensPagto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PAGAMENTO_KIT_INTERNOS SET IdRegistro=?,IdInternoCrc=?,"
                    + "DataEntrega=?,Horario=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemINT='" + objItensPagto.getIdItem() + "'");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);
            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objItensPagto.getHoraEntrega());
            pst.setString(5, objItensPagto.getUsuarioUp());
            pst.setString(6, objItensPagto.getDataUp());
            pst.setString(7, objItensPagto.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno excluirPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PAGAMENTO_KIT_INTERNOS WHERE IdItemINT='" + objItensPagto.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public java.util.List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        java.util.List<DigitalInternos> listaInternos = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM  PRONTUARIOSCRC "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND BiometriaDedo1!='" + pBio + "' "
                    + "AND StatusComp='" + statusFinal + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaInternos.add(pDigital);
                qtdInternos++;
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPagamentoKitInternos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
