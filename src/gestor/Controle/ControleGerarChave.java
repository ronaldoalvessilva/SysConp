/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import Utilitarios.CriptografarDadosChaveSistema;
import Utilitarios.Criptografia;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ChaveLiberacao;
import static gestor.Visao.TelaGerarChaveValidacao.jCHAVE_liberacao;
import static gestor.Visao.TelaGerarChaveValidacao.jID_REGISTRO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaGerarChaveValidacao.pRESPOSTA;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleGerarChave {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ChaveLiberacao objChave = new ChaveLiberacao();

    public ChaveLiberacao incluirChaveValidacao(ChaveLiberacao objChave) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CHAVE_LIBERACAO (DataLiberacao,CNPJ,RazaoSocial,DataValidade,CHAVE01_LIBERACAO,UsuarioInsert,DataInsert,HorarioInsert)VALUES(?,?,?,?,?,?,?,?)");
            if (objChave.getDataLiberacao() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(objChave.getDataLiberacao().getTime()));
            } else {
                pst.setDate(1, null);
            }
            pst.setString(2, objChave.getcNPJ());
            pst.setString(3, objChave.getRazaoSocial());
            if (objChave.getDataValidade() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objChave.getDataValidade().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, Criptografia.criptografar(objChave.getcHAVE01_liberacao()));
//            pst.setString(5, objChave.getcHAVE01_liberacao());
            pst.setString(6, objChave.getUsuarioInsert());
            pst.setString(7, objChave.getDataInsert());
            pst.setString(8, objChave.getHorarioInsert());
            pst.execute(); // Executa a inserção
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objChave;
    }

    public ChaveLiberacao alterarChaveValidacao(ChaveLiberacao objChave) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CHAVE_LIBERACAO SET DataLiberacao=?,CNPJ=?,RazaoSocial=?,DataValidade=?,CHAVE01_LIBERACAO=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE ID_REGISTRO='" + objChave.getiD_REGISTRO() + "'");
            if (objChave.getDataLiberacao() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(objChave.getDataLiberacao().getTime()));
            } else {
                pst.setDate(1, null);
            }
            pst.setString(2, objChave.getcNPJ());
            pst.setString(3, objChave.getRazaoSocial());
            if (objChave.getDataValidade() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objChave.getDataValidade().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, Criptografia.criptografar(objChave.getcHAVE01_liberacao()));
            pst.setString(6, objChave.getUsuarioUp());
            pst.setString(7, objChave.getDataUp());
            pst.setString(8, objChave.getHorarioUp());
            pst.executeUpdate(); // Executa a inserção
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objChave;
    }

    public ChaveLiberacao excluirChaveValidacao(ChaveLiberacao objChave) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CHAVE_LIBERACAO WHERE ID_REGISTRO='" + objChave.getiD_REGISTRO() + "'");
            pst.executeUpdate(); // Executa a inserção
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objChave;
    }

    public ChaveLiberacao pBUSCAR_Chave(ChaveLiberacao objChave) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ID_REGISTRO, "
                    + "CHAVE01_LIBERACAO "
                    + "FROM CHAVE_LIBERACAO");
            conecta.rs.last();
            jID_REGISTRO.setText(conecta.rs.getString("ID_REGISTRO"));
            jCHAVE_liberacao.setText(conecta.rs.getString("CHAVE01_LIBERACAO"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível buscar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objChave;
    }
}
