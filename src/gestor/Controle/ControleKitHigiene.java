/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TiposKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleKitHigiene {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TiposKit objKit = new TiposKit();

    public TiposKit incluirKitHigiene(TiposKit objKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO KITS_HIGIENE_INTERNO (StatusKit,DataKit,KitSemestral,KitInicial,KitDecendial,KitQuinzenal,KitMensal,KitAnual,ObservacaoKit,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objKit.getStatusKit());
            pst.setTimestamp(2, new java.sql.Timestamp(objKit.getDataKit().getTime()));
            pst.setInt(3, objKit.getKitSemestral());
            pst.setInt(4, objKit.getKitInicial());
            pst.setInt(5, objKit.getKitDecendial());
            pst.setInt(6, objKit.getKitQuinzenal());
            pst.setInt(7, objKit.getKitMensal());
            pst.setInt(8, objKit.getKitAnual());
            pst.setString(9, objKit.getObservacaoKit());
            pst.setString(10, objKit.getUsuarioInsert());
            pst.setString(11, objKit.getDataInsert());
            pst.setString(12, objKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objKit;
    }

    public TiposKit alterarKitHigiene(TiposKit objKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_HIGIENE_INTERNO SET StatusKit=?,DataKit=?,KitSemestral=?,KitInicial=?,KitDecendial=?,KitQuinzenal=?,KitMensal=?,KitAnual=?,ObservacaoKit=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdKit='" + objKit.getIdKit() + "'");
            pst.setString(1, objKit.getStatusKit());
            pst.setTimestamp(2, new java.sql.Timestamp(objKit.getDataKit().getTime()));
            pst.setInt(3, objKit.getKitSemestral());
            pst.setInt(4, objKit.getKitInicial());
            pst.setInt(5, objKit.getKitDecendial());
            pst.setInt(6, objKit.getKitQuinzenal());
            pst.setInt(7, objKit.getKitMensal());
            pst.setInt(8, objKit.getKitAnual());
            pst.setString(9, objKit.getObservacaoKit());
            pst.setString(10, objKit.getUsuarioUp());
            pst.setString(11, objKit.getDataUp());
            pst.setString(12, objKit.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objKit;
    }

    public TiposKit excluirKitHigiene(TiposKit objKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM KITS_HIGIENE_INTERNO WHERE IdKit='" + objKit.getIdKit() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objKit;
    }
}
