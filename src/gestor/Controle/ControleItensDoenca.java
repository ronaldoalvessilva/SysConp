/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensDoencas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensDoenca {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensDoencas objItensDoenca = new ItensDoencas();
    int codDoenca;

    public ItensDoencas incluirDoencas(ItensDoencas objItensDoenca) {
        buscarDoencas(objItensDoenca.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSADMISSAODOENCAS (DataLanc,IdLanc,IdDoenca) VALUES(?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensDoenca.getDataLanc().getTime()));
            pst.setInt(2, objItensDoenca.getIdLanc());
            pst.setInt(3, codDoenca);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objItensDoenca;
    }

    public ItensDoencas alterarDoencas(ItensDoencas objItensDoenca) {
        buscarDoencas(objItensDoenca.getDescricaoDoenca());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSADMISSAODOENCAS SET DataLanc=?,IdLanc=?,IdDoenca=? WHERE IdLanc='" + objItensDoenca.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensDoenca.getDataLanc().getTime()));
            pst.setInt(2, objItensDoenca.getIdLanc());
            pst.setInt(3, codDoenca);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objItensDoenca;
    }

    public ItensDoencas excluirDoencas(ItensDoencas objItensDoenca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSADMISSAODOENCAS WHERE IdLanc='" + objItensDoenca.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + e);
        }
        conecta.desconecta();
        return objItensDoenca;
    }

    public void buscarDoencas(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DOENCAS WHERE Descricao='" + desc + "'");
            conecta.rs.first();
            codDoenca = conecta.rs.getInt("IdDoenca");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (DOENÇAS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
