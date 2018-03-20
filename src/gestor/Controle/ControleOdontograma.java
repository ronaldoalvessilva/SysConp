/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Odontograma;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleOdontograma {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Odontograma objOdonto = new Odontograma();

    int codigoInterno;
    int codigoProcedimento;

    public Odontograma incluirOdontoGrama(Odontograma objOdonto) {
        buscarInterno(objOdonto.getNomeInternoCrc(), objOdonto.getIdInternoCrc());
        buscarProccedimento(objOdonto.getDescricaoProcedimento(), objOdonto.getIdProcOdonto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ODONTOGRAMA (IdLanc,IdInternoCrc,IdProcOdonto,NumeroDente,DataOdontograma,FacesDente,ParcialTotal,PlanoTratamento) VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, objOdonto.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, codigoProcedimento);
            pst.setInt(4, objOdonto.getNumeroDente());
            if (objOdonto.getDataOdontograma() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objOdonto.getDataOdontograma().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objOdonto.getFacesDente());
            pst.setString(7, objOdonto.getParcialTotal());               
            pst.setString(8, objOdonto.getPlanoTratamento());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOdonto;
    }

    public Odontograma alterarOdontoGrama(Odontograma objOdonto) {
        buscarInterno(objOdonto.getNomeInternoCrc(), objOdonto.getIdInternoCrc());
        buscarProccedimento(objOdonto.getDescricaoProcedimento(), objOdonto.getIdProcOdonto());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ODONTOGRAMA SET IdLanc=?,IdInternoCrc=?,IdProcOdonto=?,NumeroDente=?,DataOdontograma=?,FacesDente=?,ParcialTotal,PlanoTratamento=? WHERE IdOdonto='" + objOdonto.getIdOdonto() + "'");
            pst.setInt(1, objOdonto.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setInt(3, codigoProcedimento);
            pst.setInt(4, objOdonto.getNumeroDente());
            if (objOdonto.getDataOdontograma() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objOdonto.getDataOdontograma().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objOdonto.getFacesDente());
            pst.setString(7, objOdonto.getParcialTotal());          
            pst.setString(8, objOdonto.getPlanoTratamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOdonto;
    }

    public Odontograma excluirOdontoGrama(Odontograma objOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ODONTOGRAMA WHERE IdLanc='" + objOdonto.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objOdonto;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }

    public void buscarProccedimento(String nomeProd, int codigoProc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PROCEDIMENTOS_ODONTOLOGICO WHERE DescricaoProcedimento='" + nomeProd + "'AND IdProcOdonto='" + codigoProc + "'");
            conecta.rs.first();
            codigoProcedimento = conecta.rs.getInt("IdProcOdonto");
        } catch (Exception e) {
        }
    }
}
