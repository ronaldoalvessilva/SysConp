/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.IndicadoresAcompanhamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleIndicadoresAcompanhaPedagogia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    IndicadoresAcompanhamento objPerfilInter = new IndicadoresAcompanhamento();
    int codInt;

    public IndicadoresAcompanhamento incluirIndicadorAcompanhamentoPedagogia(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO "
                    + "INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA (IdIndAco,IdInternoCrc,DataPeda,"
                    + "ICAA,QtdICAA,IC1,QtdIC1,IC2P,QtdIC2P,IAAU,QtdIAAU,IC3,QtdIC3,IREL,QtdIREL,"
                    + "IAC,QtdIAC,ICU1,QtdICU1,IC2,QtdIC2,ICA,QtdICA,Observacao,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataPeda().getTime()));
            pst.setString(4, objPerfilInter.getiCAA());
            pst.setInt(5, objPerfilInter.getQtdICAA());
            pst.setString(6, objPerfilInter.getiC1());
            pst.setInt(7, objPerfilInter.getQtdIC1());
            pst.setString(8, objPerfilInter.getiC2P());
            pst.setInt(9, objPerfilInter.getQtdIC2P());
            pst.setString(10, objPerfilInter.getiAAU());
            pst.setInt(11, objPerfilInter.getQtdIAAU());
            pst.setString(12, objPerfilInter.getiC3());
            pst.setInt(13, objPerfilInter.getQtdIC3());
            pst.setString(14, objPerfilInter.getiREL());
            pst.setInt(15, objPerfilInter.getQtdIREL());
            pst.setString(16, objPerfilInter.getiAC());
            pst.setInt(17, objPerfilInter.getQtdIAC());
            pst.setString(18, objPerfilInter.getiCU1());
            pst.setInt(19, objPerfilInter.getQtdICU1());
            pst.setString(20, objPerfilInter.getiC2());
            pst.setInt(21, objPerfilInter.getQtdIC2());
            pst.setString(22, objPerfilInter.getiCA());
            pst.setInt(23, objPerfilInter.getQtdICA());
            pst.setString(24, objPerfilInter.getObservacaoPeda());
            pst.setString(25, objPerfilInter.getUsuarioInsert());
            pst.setString(26, objPerfilInter.getDataInsert());
            pst.setString(27, objPerfilInter.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento alterarIndicadorAcompanhamentoPedagogia(IndicadoresAcompanhamento objPerfilInter) {
        buscarInternoCrc(objPerfilInter.getNomeInternoPerfil(), objPerfilInter.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA SET IdIndAco=?,IdInternoCrc=?,DataPeda=?,ICAA=?,QtdICAA=?,IC1=?,QtdIC1=?,IC2P=?,QtdIC2P=?,IAAU=?,QtdIAAU=?,IC3=?,QtdIC3=?,IREL=?,QtdIREL=?,IAC=?,QtdIAC=?,ICU1=?,QtdICU1=?,IC2=?,QtdIC2=?,ICA=?,QtdICA=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPedago='" + objPerfilInter.getIdPedago() + "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.setInt(1, objPerfilInter.getIdIndAco());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objPerfilInter.getDataPeda().getTime()));
            pst.setString(4, objPerfilInter.getiCAA());
            pst.setInt(5, objPerfilInter.getQtdICAA());
            pst.setString(6, objPerfilInter.getiC1());
            pst.setInt(7, objPerfilInter.getQtdIC1());
            pst.setString(8, objPerfilInter.getiC2P());
            pst.setInt(9, objPerfilInter.getQtdIC2P());
            pst.setString(10, objPerfilInter.getiAAU());
            pst.setInt(11, objPerfilInter.getQtdIAAU());
            pst.setString(12, objPerfilInter.getiC3());
            pst.setInt(13, objPerfilInter.getQtdIC3());
            pst.setString(14, objPerfilInter.getiREL());
            pst.setInt(15, objPerfilInter.getQtdIREL());
            pst.setString(16, objPerfilInter.getiAC());
            pst.setInt(17, objPerfilInter.getQtdIAC());
            pst.setString(18, objPerfilInter.getiCU1());
            pst.setInt(19, objPerfilInter.getQtdICU1());
            pst.setString(20, objPerfilInter.getiC2());
            pst.setInt(21, objPerfilInter.getQtdIC2());
            pst.setString(22, objPerfilInter.getiCA());
            pst.setInt(23, objPerfilInter.getQtdICA());
            pst.setString(24, objPerfilInter.getObservacaoPeda());
            pst.setString(25, objPerfilInter.getUsuarioUp());
            pst.setString(26, objPerfilInter.getDataUp());
            pst.setString(27, objPerfilInter.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public IndicadoresAcompanhamento excluirIndicadorAcompanhamentoPedagogia(IndicadoresAcompanhamento objPerfilInter) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA WHERE IdPedago='" + objPerfilInter.getIdPedago()+ "'AND IdIndAco='" + objPerfilInter.getIdIndAco() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfilInter;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
