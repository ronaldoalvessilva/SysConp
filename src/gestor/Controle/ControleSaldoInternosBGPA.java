/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensLocacaoInternos;
import gestor.Modelo.TransferenciaLocalInternos;
import static gestor.Visao.TelaTransCelasBGPA.jIdInterno;
import static gestor.Visao.TelaTransCelasBGPA.pCODIGO_INTERNO_kit;
import static gestor.Visao.TelaTransCelasBGPA.pKIT_pago;
import static gestor.Visao.TelaTransCelasBGPA.pUTILIZADO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_inicial;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_decendial;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_quinzenal;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_mensal;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_semestral;
import static gestor.Visao.TelaTransCelasBGPA.pTIPO_KIT_anual;
import static gestor.Visao.TelaTransCelasBGPA.pRESPOSTA_transferencia;

/**
 *
 * @author user
 */
public class ControleSaldoInternosBGPA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TransferenciaLocalInternos objTranLocalInt = new TransferenciaLocalInternos();
    ItensLocacaoInternos objItensLoca = new ItensLocacaoInternos();
    //
    String pKIT_PAGO_nao = "Não";
    String pUTILIZADO_sim = "Sim";

    public ItensLocacaoInternos incluirSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOCALINTERNOS (IdInternoCrc,IdCela) VALUES(?,?)");
            pst.setInt(1, objItensLoca.getIdInternoCrc());
            pst.setInt(2, objItensLoca.getIdCela());
            pst.execute();
            pRESPOSTA_transferencia = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_transferencia = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos alterarSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCALINTERNOS SET IdInternoCrc=?,IdCela=? WHERE IdInternoCrc='" + objItensLoca.getIdInternoCrc() + "'OR IdCela='" + objItensLoca.getIdCela() + "'");
            pst.setInt(1, objItensLoca.getIdInternoCrc());
            pst.setInt(2, objItensLoca.getIdCela());
            pst.executeUpdate();
            pRESPOSTA_transferencia = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_transferencia = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }

    public ItensLocacaoInternos excluirSaldo(ItensLocacaoInternos objItensLoca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LOCALINTERNOS WHERE IdInternoCrc='" + objItensLoca.getIdInternoCrc() + "'");
            pst.executeUpdate();
            pRESPOSTA_transferencia = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_transferencia = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLoca;
    }
    // Alterar o local do interno, ou seja, transfere de um local para outro. (TelaTransCelas)

    public TransferenciaLocalInternos transferirInternoLocal(TransferenciaLocalInternos objTranLocalInt) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLOCACAOINTERNO SET IdLoca=?,IdInternoCrc=?,IdCela=? WHERE IdInternoCrc='" + objTranLocalInt.getIdInternoCrc() + "'");
            pst.setInt(1, objTranLocalInt.getIdLanc());
            pst.setInt(2, objTranLocalInt.getIdInternoCrc());
            pst.setInt(3, objTranLocalInt.getIdCela());
            pst.executeUpdate();
            pRESPOSTA_transferencia = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_transferencia = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    //--------------------- VERIFICAÇÃO DO PAGAMENTO DOS KITS DOS INTERNOS -------------------------------------------------
    //ESSA PESQUISA É PARA VERIFICAR SE O INTERNO TEM KIT A SER PAGO, PARA QUE O SISTEMA IMPEÇA A TRANSFERÊNCIA
    //DE CELA ANTES DE PAGAR O KIT.
    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_inicial(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_INICIAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_inicial = "Sim";            
        } catch (Exception e) {
            pTIPO_KIT_inicial = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_decendial(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_DECENDIAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_decendial = "Sim";
        } catch (Exception e) {
            pTIPO_KIT_decendial = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_quinzenal(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_QUINZENAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_quinzenal = "Sim";
        } catch (Exception e) {
            pTIPO_KIT_quinzenal = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_mensal(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_MENSAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_mensal = "Sim";
        } catch (Exception e) {
             pTIPO_KIT_mensal = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_semestral(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_SEMESTRAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_semestral = "Sim";
        } catch (Exception e) {
             pTIPO_KIT_semestral = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }

    public TransferenciaLocalInternos VERIFICAR_INTERNO_KIT_anual(TransferenciaLocalInternos objTranLocalInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc, "
                    + "KitPago, "
                    + "Utilizado "
                    + "FROM KITS_ANUAL_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND KitPago='" + pKIT_PAGO_nao + "' "
                    + "AND Utilizado='" + pUTILIZADO_sim + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_kit = conecta.rs.getInt("IdInternoCrc");
            pKIT_pago = conecta.rs.getString("KitPago");
            pUTILIZADO = conecta.rs.getString("Utilizado");
            pTIPO_KIT_anual = "Sim";
        } catch (Exception e) {
            pTIPO_KIT_anual = "Não";
        }
        conecta.desconecta();
        return objTranLocalInt;
    }
}
