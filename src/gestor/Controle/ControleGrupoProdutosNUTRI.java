/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GrupoProdutos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleGrupoProdutosNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GrupoProdutos objGrupoProd = new GrupoProdutos();

    public GrupoProdutos incluirGrupoNUTRI(GrupoProdutos objGrupoProd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO GRUPO_PRODUTOS_AC (StatusGru,NomeGrupo,Modulo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objGrupoProd.getStatusGru());
            pst.setString(2, objGrupoProd.getNomeGrupo());
            pst.setString(3, objGrupoProd.getModulo());
            pst.setString(4, objGrupoProd.getUsuarioInsert());
            pst.setString(5, objGrupoProd.getDataInsert());
            pst.setString(6, objGrupoProd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoProd;
    }

    public GrupoProdutos alterarGrupoNUTRI(GrupoProdutos objGrupoProd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE GRUPO_PRODUTOS_AC SET StatusGru=?,NomeGrupo=?,Modulo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdGrupo='" + objGrupoProd.getIdGrupo() + "'");
            pst.setString(1, objGrupoProd.getStatusGru());
            pst.setString(2, objGrupoProd.getNomeGrupo());
            pst.setString(3, objGrupoProd.getModulo());
            pst.setString(4, objGrupoProd.getUsuarioUp());
            pst.setString(5, objGrupoProd.getDataUp());
            pst.setString(6, objGrupoProd.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoProd;
    }

    public GrupoProdutos excluirGrupoNUTRI(GrupoProdutos objGrupoProd) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM GRUPO_PRODUTOS_AC WHERE IdGrupo='" + objGrupoProd.getIdGrupo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objGrupoProd;
    }
}
