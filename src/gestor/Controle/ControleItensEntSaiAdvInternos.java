/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaAdvInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntSaiAdvInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos = new ItensEntradaSaidaAdvInternos();
    int codInterno;
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";

    public ItensEntradaSaidaAdvInternos incluirItensEnSaiAdvInternos(ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos) {
        buscarInterno(objItensEntSaiAdvInternos.getNomeInterno(),objItensEntSaiAdvInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSADVOGADOINTERNOS (IdInternoCrc,IdAdvogado,Idlanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensEntSaiAdvInternos.getIdAdvogado());
            pst.setInt(3, objItensEntSaiAdvInternos.getIdlanc());    
            pst.setString(4, objItensEntSaiAdvInternos.getUsuarioInsert());
            pst.setString(5, objItensEntSaiAdvInternos.getDataInsert());
            pst.setString(6, objItensEntSaiAdvInternos.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensEntSaiAdvInternos;
    }

    public ItensEntradaSaidaAdvInternos alterarItensEnSaiAdvInternos(ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos) {
        buscarInterno(objItensEntSaiAdvInternos.getNomeInterno(),objItensEntSaiAdvInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSADVOGADOINTERNOS SET IdInternoCrc=?,IdAdvogado=?,Idlanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE idItem='" + objItensEntSaiAdvInternos.getIdItem() + "'");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensEntSaiAdvInternos.getIdAdvogado());
            pst.setInt(3, objItensEntSaiAdvInternos.getIdlanc()); 
            pst.setString(4, objItensEntSaiAdvInternos.getUsuarioUp());
            pst.setString(5, objItensEntSaiAdvInternos.getDataUp());
            pst.setString(6, objItensEntSaiAdvInternos.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensEntSaiAdvInternos;
    }

    public ItensEntradaSaidaAdvInternos excluirItensEnSaiAdvInternos(ItensEntradaSaidaAdvInternos objItensEntSaiAdvInternos) {      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSADVOGADOINTERNOS WHERE idItem='" + objItensEntSaiAdvInternos.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensEntSaiAdvInternos;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "' "
                    + "AND SituacaoCrc='" + situacaoEnt + "' "
                    + "OR NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "' "
                    + "AND SituacaoCrc='" + situacaoRet + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
