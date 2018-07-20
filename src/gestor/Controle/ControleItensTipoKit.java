/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensKitHigiene;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleItensTipoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensKitHigiene objItensKit = new ItensKitHigiene();

    int codProd;
    public static int qtdProd = 0;

    public ItensKitHigiene incluirItensKitHigiene(ItensKitHigiene objItensKit) {
        buscarProduto(objItensKit.getIdProd(), objItensKit.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRODUTOS_KITS_HIGIENE_INTERNO (IdKit,IdProd,QuantItem,KitSemestral,KitInicial,KitDecendial,KitQuinzenal,KitMensal,KitAnual,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensKit.getIdKit());
            pst.setInt(2, codProd);
            pst.setFloat(3, objItensKit.getQuantItem());
            pst.setInt(4, objItensKit.getKitSemestral());
            pst.setInt(5, objItensKit.getKitInicial());
            pst.setInt(6, objItensKit.getKitDecendial());
            pst.setInt(7, objItensKit.getKitQuinzenal());
            pst.setInt(8, objItensKit.getKitMensal());
            pst.setInt(9, objItensKit.getKitAnual());
            pst.setString(10, objItensKit.getUsuarioInsert());
            pst.setString(11, objItensKit.getDataInsert());
            pst.setString(12, objItensKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensKit;
    }

    public ItensKitHigiene alterarItensKitHigiene(ItensKitHigiene objItensKit) {
        buscarProduto(objItensKit.getIdProd(), objItensKit.getNomeProduto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRODUTOS_KITS_HIGIENE_INTERNO SET IdKit=?,IdProd=?,QuantItem=?,KitSemestral=?,KitInicial=?,KitDecendial=?,KitQuinzenal=?,KitMensal=?,KitAnual=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensKit.getIdItem() + "'");
            pst.setInt(1, objItensKit.getIdKit());
            pst.setInt(2, codProd);
            pst.setFloat(3, objItensKit.getQuantItem());
            pst.setInt(4, objItensKit.getKitSemestral());
            pst.setInt(5, objItensKit.getKitInicial());
            pst.setInt(6, objItensKit.getKitDecendial());
            pst.setInt(7, objItensKit.getKitQuinzenal());
            pst.setInt(8, objItensKit.getKitMensal());
            pst.setInt(9, objItensKit.getKitAnual());
            pst.setString(10, objItensKit.getUsuarioUp());
            pst.setString(11, objItensKit.getDataUp());
            pst.setString(12, objItensKit.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensKit;
    }

    public ItensKitHigiene excluirItensKitHigiene(ItensKitHigiene objItensKit) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRODUTOS_KITS_HIGIENE_INTERNO WHERE IdItem='" + objItensKit.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensKit;
    }

    public void buscarProduto(int codigo, String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE IdProd='" + codigo + "' "
                    + "AND DescricaoProd='" + nome + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
