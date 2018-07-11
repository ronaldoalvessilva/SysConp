/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaOJInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntSaiOficialJusticaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaOJInternos objItensEntSaiOJInternos = new ItensEntradaSaidaOJInternos();
    int codInterno;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";

    public ItensEntradaSaidaOJInternos incluirItensEnSaiOJInternos(ItensEntradaSaidaOJInternos objItensEntSaiOJInternos) {
        buscarInterno(objItensEntSaiOJInternos.getNomeInterno(),objItensEntSaiOJInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS (IdInternoCrc,IdOficial,Idlanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensEntSaiOJInternos.getIdOficial());
            pst.setInt(3, objItensEntSaiOJInternos.getIdlanc());    
            pst.setString(4, objItensEntSaiOJInternos.getUsuarioInsert());
            pst.setString(5, objItensEntSaiOJInternos.getDataInsert());
            pst.setString(6, objItensEntSaiOJInternos.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiOJInternos;
    }

    public ItensEntradaSaidaOJInternos alterarItensEnSaiOJInternos(ItensEntradaSaidaOJInternos objItensEntSaiOJInternos) {
        buscarInterno(objItensEntSaiOJInternos.getNomeInterno(),objItensEntSaiOJInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS SET IdInternoCrc=?,IdOficial=?,Idlanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE idItem='" + objItensEntSaiOJInternos.getIdItem() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensEntSaiOJInternos.getIdOficial());
            pst.setInt(3, objItensEntSaiOJInternos.getIdlanc()); 
            pst.setString(4, objItensEntSaiOJInternos.getUsuarioUp());
            pst.setString(5, objItensEntSaiOJInternos.getDataUp());
            pst.setString(6, objItensEntSaiOJInternos.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiOJInternos;
    }

    public ItensEntradaSaidaOJInternos excluirItensEnSaiOJInternos(ItensEntradaSaidaOJInternos objItensEntSaiOJInternos) {      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS WHERE idItem='" + objItensEntSaiOJInternos.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensEntSaiOJInternos;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo  + "'AND SituacaoCrc='" + situacaoEnt + "' OR NomeInternoCrc='" + desc + "' AND IdInternoCrc='" + codigo + "'AND SituacaoCrc='" + situacaoRet + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
