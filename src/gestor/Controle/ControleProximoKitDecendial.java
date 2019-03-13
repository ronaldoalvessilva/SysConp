/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7 TI 02
 */
public class ControleProximoKitDecendial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    int codInterno;

    public GravarInternosKitCompleto incluirProximoKitDecendial(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_DECENDIAL_INTERNOS (IdRegistroComp,DataPagto,IdInternoCrc,DataPrevisaoPro,KitPago,Utilizado) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(3, codInterno);
            pst.setTimestamp(4, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(5, objGravaIntComp.getKitPago());
            pst.setString(6, objGravaIntComp.getUtili());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit decendial.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto incluirProximoKitQuinzenal(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_QUINZENAL_INTERNOS (IdRegistroComp,DataPagto,IdInternoCrc,DataPrevisaoPro,KitPago,Utilizado) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(3, codInterno);
            pst.setTimestamp(4, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(5, objGravaIntComp.getKitPago());
            pst.setString(6, objGravaIntComp.getUtili());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit quinzenal.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto incluirProximoKitMensal(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_MENSAL_INTERNOS (IdRegistroComp,DataPagto,IdInternoCrc,DataPrevisaoPro,KitPago,Utilizado) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(3, codInterno);
            pst.setTimestamp(4, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(5, objGravaIntComp.getKitPago());
            pst.setString(6, objGravaIntComp.getUtili());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit mensal.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto incluirProximoKitSemestral(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_SEMESTRAL_INTERNOS (IdRegistroComp,DataPagto,IdInternoCrc,DataPrevisaoPro,KitPago,Utilizado) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(3, codInterno);
            pst.setTimestamp(4, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(5, objGravaIntComp.getKitPago());
            pst.setString(6, objGravaIntComp.getUtili());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit semestral.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public GravarInternosKitCompleto incluirProximoKitAnual(GravarInternosKitCompleto objGravaIntComp) {
        buscarInterno(objGravaIntComp.getNomeInternoCrc(), objGravaIntComp.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_ANUAL_INTERNOS (IdRegistroComp,DataPagto,IdInternoCrc,DataPrevisaoPro,KitPago,Utilizado) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objGravaIntComp.getIdRegistroComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objGravaIntComp.getDataPagamento().getTime()));
            pst.setInt(3, codInterno);
            pst.setTimestamp(4, new java.sql.Timestamp(objGravaIntComp.getDataPrevisao().getTime()));
            pst.setString(5, objGravaIntComp.getKitPago());
            pst.setString(6, objGravaIntComp.getUtili());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR internos do kit anual.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGravaIntComp;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do INTERNO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
