/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensProgressaoRegime;
import static gestor.Visao.TelaPesquisaInternoMudancaRegimeProgressao.regimeAnterior;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensProRegime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensProgressaoRegime objItenPro = new ItensProgressaoRegime();
    //
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";
    int codInterno;

    public ItensProgressaoRegime incluirItensProgressaoRegime(ItensProgressaoRegime objItenPro) {
        buscarInternoCrc(objItenPro.getNomeInternoCrc(), objItenPro.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSPROGRESSAOREGIME (IdLanc,IdInternoCrc,DataProgressao,NovoRegimePro,NovoTerminoPenaPro,Juizo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItenPro.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItenPro.getDataProgressao().getTime()));
            pst.setString(4, objItenPro.getRegime());                     
            pst.setTimestamp(5, new java.sql.Timestamp(objItenPro.getTerminoPena().getTime()));           
            pst.setString(6, objItenPro.getJuizo());           
            pst.setString(7, objItenPro.getUsuarioInsert());
            pst.setString(8, objItenPro.getDataInsert());
            pst.setString(9, objItenPro.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ITENSPROGRESSAO) os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenPro;
    }

    public ItensProgressaoRegime alterarItensProgressaoRegime(ItensProgressaoRegime objItenPro) {
        buscarInternoCrc(objItenPro.getNomeInternoCrc(), objItenPro.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPROGRESSAOREGIME SET IdLanc=?,IdInternoCrc=?,DataProgressao=?,NovoRegimePro=?,NovoTerminoPenaPro=?,Juizo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItenPro.getIdItem() + "'");
            pst.setInt(1, objItenPro.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setTimestamp(3, new java.sql.Timestamp(objItenPro.getDataProgressao().getTime()));
            pst.setString(4, objItenPro.getRegime());                     
            pst.setTimestamp(5, new java.sql.Timestamp(objItenPro.getTerminoPena().getTime()));           
            pst.setString(6, objItenPro.getJuizo());           
            pst.setString(7, objItenPro.getUsuarioInsert());
            pst.setString(8, objItenPro.getDataInsert());
            pst.setString(9, objItenPro.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenPro;
    }
   
    public ItensProgressaoRegime atualizarRegimeProgressaoInterno(ItensProgressaoRegime objItenPro) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET Regime=? WHERE IdInternoCrc='" + objItenPro.getIdInternoCrc() + "'AND Regime='" + regimeAnterior + "'");
            pst.setString(1, objItenPro.getRegime());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do PRONTUARIO do INTERNO \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenPro;
    }

    public ItensProgressaoRegime excluirItensProgressaoRegime(ItensProgressaoRegime objItenPro) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSPROGRESSAOREGIME WHERE IdItem='" + objItenPro.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenPro;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
