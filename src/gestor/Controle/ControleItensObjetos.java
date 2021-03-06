/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensObjetosPertences;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensObjetos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensObjetosPertences objItensObj = new ItensObjetosPertences();

    int codPertence;
    int codLocal;

    public ItensObjetosPertences incluirItensEntradaObjetos(ItensObjetosPertences objItensObj) {
        buscarPertenceInternoCrc(objItensObj.getNomePertence());
        buscarLocalPertence(objItensObj.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSOBJETOS (IdEntrada,IdPertence,idLocal,Quant,DataEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensObj.getIdLanc());
            pst.setInt(2, codPertence);
            pst.setInt(3, codLocal);
            pst.setFloat(4, objItensObj.getQuant());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensObj.getDataEntrada().getTime()));
            pst.setString(6, objItensObj.getUsuarioInsert());
            pst.setString(7, objItensObj.getDataInsert());
            pst.setString(8, objItensObj.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensObj;
    }

    public ItensObjetosPertences alterarItensEntradaObjetos(ItensObjetosPertences objItensObj) {
        buscarPertenceInternoCrc(objItensObj.getNomePertence());
        buscarLocalPertence(objItensObj.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSOBJETOS SET IdEntrada=?,IdPertence=?,IdLocal=?,Quant=?,DataEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensObj.getIdItem() + "'");
            pst.setInt(1, objItensObj.getIdLanc());
            pst.setInt(2, codPertence);
            pst.setInt(3, codLocal);
            pst.setFloat(4, objItensObj.getQuant());
            pst.setTimestamp(5, new java.sql.Timestamp(objItensObj.getDataEntrada().getTime()));
            pst.setString(6, objItensObj.getUsuarioUp());
            pst.setString(7, objItensObj.getDataUp());
            pst.setString(8, objItensObj.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensObj;
    }

    public ItensObjetosPertences excluirItensEntradaObjetos(ItensObjetosPertences objItensObj) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSOBJETOS WHERE IdItem='" + objItensObj.getIdItem() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensObj;
    }

    public void buscarPertenceInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PERTENCES WHERE DescricaoPertence='" + nome + "'");
            conecta.rs.first();
            codPertence = conecta.rs.getInt("IdPertence");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Pertence.\nERRO: " + e);
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
}
