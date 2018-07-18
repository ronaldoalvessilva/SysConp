/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPagamentoKitInterno;
import gestor.Modelo.PagamentoKitInterno;
import static gestor.Visao.TelaPagamentoKitInterno.jComboBoxPavilhao;
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
public class ControlePagamentosKitInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();

    int codInterno;
    String pBio = null;
    public static int qtdInternos = 0;

    public ItensPagamentoKitInterno incluirPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {
        buscarInterno(objItensPagto.getNomeInternoCrcKit(), objItensPagto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PAGAMENTO_KIT_INTERNOS (IdPagto,IdInternoCrc,Copo,Prato,Colher,Vasilha,Garfo,"
                    + "Absorvente,Bermuda,Colchas,Colchao,Toalha,Camisa,Cueca,Sandalia,CremeDental,Sabonete,PapelHigienico,Barbeador,EscovaDente,MostraTodos,KitInicial,"
                    + "KitQuinzenal,TipoEntrada,DataEntrega,Horario,AssinaturaDigital,UsuarioInsert,DataInsert,"
                    + "HorarioInsert,Cobertor,BolaFutSal,CalcaoJg,CamisaJg,ParMeiao,SabaoPo,Desodorante,KitDecimal,KitSemestral,kitMensal,KitPersonalizado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensPagto.getCopo());
            pst.setInt(4, objItensPagto.getPrato());
            pst.setInt(5, objItensPagto.getColher());
            pst.setInt(6, objItensPagto.getVasilha());
            pst.setInt(7, objItensPagto.getGarfo());
            pst.setInt(8, objItensPagto.getAbsorvente());
            pst.setInt(9, objItensPagto.getBermuda());
            pst.setInt(10, objItensPagto.getLencol());
            pst.setInt(11, objItensPagto.getColchao());
            pst.setInt(12, objItensPagto.getToalha());
            pst.setInt(13, objItensPagto.getCamisa());
            pst.setInt(14, objItensPagto.getCueca());
            pst.setInt(15, objItensPagto.getSandalia());
            pst.setInt(16, objItensPagto.getCremeDental());
            pst.setInt(17, objItensPagto.getSabonete());
            pst.setInt(18, objItensPagto.getPapelHigienico());
            pst.setInt(19, objItensPagto.getBarbeador());
            pst.setInt(20, objItensPagto.getEscovaDente());
            pst.setInt(21, objItensPagto.getMostraTodos());
            pst.setInt(22, objItensPagto.getKitInicial());
            pst.setInt(23, objItensPagto.getKitQuinzenal());
            pst.setInt(24, objItensPagto.getTipoEntrada());
            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(25, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(25, null);
            }
            pst.setString(26, objItensPagto.getHoraEntrega());
            pst.setBytes(27, objItensPagto.getAssinaturaDigital());
            pst.setString(28, objItensPagto.getUsuarioInsert());
            pst.setString(29, objItensPagto.getDataInsert());
            pst.setString(30, objItensPagto.getHorarioInsert());
            pst.setInt(31, objItensPagto.getCobertor());
            pst.setInt(32, objItensPagto.getBolaJogo());
            pst.setInt(33, objItensPagto.getCalcaoJogo());
            pst.setInt(34, objItensPagto.getCamisaJogo());
            pst.setInt(35, objItensPagto.getParMeiao());
            pst.setInt(36, objItensPagto.getSabaoPo());
            pst.setInt(37, objItensPagto.getDesodorante());
            pst.setInt(38, objItensPagto.getKitDecimal());
            pst.setInt(39, objItensPagto.getKitSemestral());
            pst.setInt(40, objItensPagto.getKitMensal());
            pst.setInt(41, objItensPagto.getKitPersonalizado());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PAGAMENTO_KIT_INTERNOS SET IdPagto=?,IdInternoCrc=?,Copo=?,Prato=?,Colher=?,"
                    + "Vasilha=?,Garfo=?,Absorvente=?,Bermuda=?,Colchas=?,Colchao=?,Toalha=?,Camisa=?,Cueca=?,Sandalia=?,CremeDental=?,Sabonete=?,"
                    + "PapelHigienico=?,Barbeador=?,EscovaDente=?,MostraTodos=?,KitInicial=?,KitQuinzenal=?,TipoEntrada=?,DataEntrega=?,Horario=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=?,Cobertor=?,BolaFutSal=?,CalcaoJg=?,CamisaJg=?,ParMeiao=?,SabaoPo=?,Desodorante=?,KitDecimal=?,"
                    + "KitSemestral=?,kitMensal=?,AssinaturaDigital=?,KitPersonalizado=? WHERE IdItem='" + objItensPagto.getIdItem() + "'");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensPagto.getCopo());
            pst.setInt(4, objItensPagto.getPrato());
            pst.setInt(5, objItensPagto.getColher());
            pst.setInt(6, objItensPagto.getVasilha());
            pst.setInt(7, objItensPagto.getGarfo());
            pst.setInt(8, objItensPagto.getAbsorvente());
            pst.setInt(9, objItensPagto.getBermuda());
            pst.setInt(10, objItensPagto.getLencol());
            pst.setInt(11, objItensPagto.getColchao());
            pst.setInt(12, objItensPagto.getToalha());
            pst.setInt(13, objItensPagto.getCamisa());
            pst.setInt(14, objItensPagto.getCueca());
            pst.setInt(15, objItensPagto.getSandalia());
            pst.setInt(16, objItensPagto.getCremeDental());
            pst.setInt(17, objItensPagto.getSabonete());
            pst.setInt(18, objItensPagto.getPapelHigienico());
            pst.setInt(19, objItensPagto.getBarbeador());
            pst.setInt(20, objItensPagto.getEscovaDente());
            pst.setInt(21, objItensPagto.getMostraTodos());
            pst.setInt(22, objItensPagto.getKitInicial());
            pst.setInt(23, objItensPagto.getKitQuinzenal());
            pst.setInt(24, objItensPagto.getTipoEntrada());
            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(25, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(25, null);
            }
            pst.setString(26, objItensPagto.getHoraEntrega());
            pst.setString(27, objItensPagto.getUsuarioUp());
            pst.setString(28, objItensPagto.getDataUp());
            pst.setString(29, objItensPagto.getHorarioUp());
            pst.setInt(30, objItensPagto.getCobertor());
            pst.setInt(31, objItensPagto.getBolaJogo());
            pst.setInt(32, objItensPagto.getCalcaoJogo());
            pst.setInt(33, objItensPagto.getCamisaJogo());
            pst.setInt(34, objItensPagto.getParMeiao());
            pst.setInt(35, objItensPagto.getSabaoPo());
            pst.setInt(36, objItensPagto.getDesodorante());
            pst.setInt(37, objItensPagto.getKitDecimal());
            pst.setInt(38, objItensPagto.getKitSemestral());
            pst.setInt(39, objItensPagto.getKitMensal());
            pst.setBytes(40, objItensPagto.getAssinaturaDigital());
            pst.setInt(41, objItensPagto.getKitPersonalizado());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PAGAMENTO_KIT_INTERNOS WHERE IdItem='" + objItensPagto.getIdItem() + "'");
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
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
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
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaInternos.add(pDigital);
                qtdInternos++;
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
