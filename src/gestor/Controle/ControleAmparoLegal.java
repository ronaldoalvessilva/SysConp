/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AmparoLegal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAmparoLegal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AmparoLegal objAmparo = new AmparoLegal();

    public AmparoLegal incluirAmparoLegal(AmparoLegal objAmparo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AMPARO_LEGAL (StatusLanc,DataLanc,DescricaoAmparoLegal,Artigo,Paragrafo,Inciso,Alinea,Texto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAmparo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAmparo.getDataLanc().getTime()));
            pst.setString(3, objAmparo.getDescricaoAmparoLegal());
            pst.setString(4, objAmparo.getArtigo());
            pst.setString(5, objAmparo.getParagrafo());
            pst.setString(6, objAmparo.getInciso());
            pst.setString(7, objAmparo.getAlinea());
            pst.setString(8, objAmparo.getTexto());
            pst.setString(9, objAmparo.getUsuarioInsert());
            pst.setString(10, objAmparo.getDataInsert());
            pst.setString(11, objAmparo.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAmparo;
    }

    public AmparoLegal alterarAmparoLegal(AmparoLegal objAmparo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AMPARO_LEGAL SET StatusLanc=?,DataLanc=?,DescricaoAmparoLegal=?,Artigo=?,Paragrafo=?,Inciso=?,Alinea=?,Texto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objAmparo.getIdLanc() + "'");
            pst.setString(1, objAmparo.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAmparo.getDataLanc().getTime()));
            pst.setString(3, objAmparo.getDescricaoAmparoLegal());
            pst.setString(4, objAmparo.getArtigo());
            pst.setString(5, objAmparo.getParagrafo());
            pst.setString(6, objAmparo.getInciso());
            pst.setString(7, objAmparo.getAlinea());
            pst.setString(8, objAmparo.getTexto());
            pst.setString(9, objAmparo.getUsuarioUp());
            pst.setString(10, objAmparo.getDataUp());
            pst.setString(11, objAmparo.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAmparo;
    }

    public AmparoLegal excluirAmparoLegal(AmparoLegal objAmparo) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AMPARO_LEGAL WHERE IdLanc='" + objAmparo.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAmparo;
    }
}
