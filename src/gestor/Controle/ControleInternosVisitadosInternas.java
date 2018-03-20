/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaSaidaVisitasInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleInternosVisitadosInternas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaSaidaVisitasInternos objItensVisitaInternos = new ItensEntradaSaidaVisitasInternos();
    int codInterno;  

    public ItensEntradaSaidaVisitasInternos incluirInternasVisitantes(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarInternaVisitante(objItensVisitaInternos.getNomeInternosCrc(),objItensVisitaInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_VISITA_INTERNO (IdInternoCrc,IdRol,Idlanc) VALUES(?,?,?)");
            pst.setInt(1, codInterno);
            pst.setInt(2, objItensVisitaInternos.getIdRol());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());           
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados na tabela (ITENSFAMILIAR).\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos alterarInternasVisitantes(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        buscarInternaVisitante(objItensVisitaInternos.getNomeInternosCrc(),objItensVisitaInternos.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_VISITA_INTERNO SET IdInternoCrc=?,IdRol=?,Idlanc=? WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.setInt(1, codInterno);            
            pst.setInt(2, objItensVisitaInternos.getIdRol());
            pst.setInt(3, objItensVisitaInternos.getIdlanc());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public ItensEntradaSaidaVisitasInternos excluirInternasVisitantes(ItensEntradaSaidaVisitasInternos objItensVisitaInternos) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_VISITA_INTERNO WHERE IdItem='" + objItensVisitaInternos.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVisitaInternos;
    }

    public void buscarInternaVisitante(String desc, int codigoVisitaInterna) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoVisitaInterna + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

}
