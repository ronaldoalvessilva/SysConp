/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaldoPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleSaldoPertences {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaldoPertences objSaldoPertences = new SaldoPertences();

    int codObj;
    int codLocal;
    int codInternoCrc;

    public SaldoPertences incluirQuantidadeEntradaObjetos(SaldoPertences objSaldoPertences) {
        buscarPertenceInternoCrc(objSaldoPertences.getDescricaoObjeto());
        buscarLocalPertence(objSaldoPertences.getDescricaoLocal());
        buscarInternoCrc(objSaldoPertences.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTOQUEPERTENCES (IdMov,StatusMov,DataLanc,IdItemMov,IdPertence,IdLocal,IdInternoCrc,QtdLanc,SaldoEstoque) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSaldoPertences.getIdMov());
            pst.setString(2, objSaldoPertences.getStatusMov());
            pst.setTimestamp(3, new java.sql.Timestamp(objSaldoPertences.getDataLanc().getTime()));
            pst.setInt(4, objSaldoPertences.getIdItemMov());
            pst.setInt(5, codObj);
            pst.setInt(6, codLocal);
            pst.setInt(7, codInternoCrc);
            pst.setFloat(8, objSaldoPertences.getQtdLanc());
            pst.setFloat(9, objSaldoPertences.getSaldoEstoque());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaldoPertences;
    }

    public SaldoPertences alterarQuantidadeEntradaObjetos(SaldoPertences objSaldoPertences) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTOQUEPERTENCES SET SaldoEstoque=? WHERE IdInternoCrc='" + objSaldoPertences.getIdInternoCrc() + "'AND IdPertence='" + objSaldoPertences.getIdObj() + "'");
            pst.setFloat(1, objSaldoPertences.getSaldoEstoque());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSaldoPertences;
    }   

    public SaldoPertences excluirQuantidadeEntradaObjetos(SaldoPertences objSadoPertences) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESTOQUEPERTENCES WHERE IdMov='" + objSadoPertences.getIdMov() + "'AND StatusMov='" + objSadoPertences.getStatusMov() + "'AND IdPertence='" + objSadoPertences.getIdObj() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSadoPertences;
    }

    public void buscarPertenceInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PERTENCES WHERE DescricaoPertence='" + nome + "'");
            conecta.rs.first();
            codObj = conecta.rs.getInt("IdPertence");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Pertence/Objeto.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void buscarLocalPertence(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCALPERTENCES WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Local do pertence.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void buscarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o interno.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
