/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VerificarDocumentosVisita;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ContoleVerificarDocumentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VerificarDocumentosVisita objVerifica = new VerificarDocumentosVisita();

    int codVisita;
    int codInterno;

    public VerificarDocumentosVisita incluirDocumentos(VerificarDocumentosVisita objVerifica) {
        buscarVisita(objVerifica.getNomeVisita(), objVerifica.getIdVisita());
        buscarInterno(objVerifica.getNomeInternooCrc(), objVerifica.getIdinternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VERIFICA_DOCUMENTOS_VISITA (IdVisita,Ident,DFoto,Ant,Comp,Decla,Autori,Responsavel,Justificativa,Aprova,Ates,VisApr,VisRep,UsuarioInsert,DataInsert,HorarioInsert,IdInternoCrc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codVisita);
            pst.setInt(2, objVerifica.getIdent());
            pst.setInt(3, objVerifica.getdFoto());
            pst.setInt(4, objVerifica.getAnt());
            pst.setInt(5, objVerifica.getComp());
            pst.setInt(6, objVerifica.getDecla());
            pst.setInt(7, objVerifica.getAutori());
            pst.setString(8, objVerifica.getColaboradorResponsavel());
            pst.setString(9, objVerifica.getJustificativa());
            pst.setString(10, objVerifica.getAprova());
            pst.setInt(11, objVerifica.getAtes());
            pst.setInt(12, objVerifica.getVisApr());
            pst.setInt(13, objVerifica.getVisRep());
            pst.setString(14, objVerifica.getUsuarioInsert());
            pst.setString(15, objVerifica.getDataInsert());
            pst.setString(16, objVerifica.getHorarioInsert());
            pst.setInt(17, codInterno);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVerifica;
    }

    public VerificarDocumentosVisita alterarDocumentos(VerificarDocumentosVisita objVerifica) {
        buscarVisita(objVerifica.getNomeVisita(), objVerifica.getIdVisita());
        buscarInterno(objVerifica.getNomeInternooCrc(), objVerifica.getIdinternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VERIFICA_DOCUMENTOS_VISITA SET IdVisita=?,Ident=?,DFoto=?,Ant=?,Comp=?,Decla=?,Autori=?,Responsavel=?,Justificativa=?,Aprova=?,Ates=?,VisApr=?,VisRep=?,UsuarioUp=?,DataUp=?,HorarioUp=?,IdInternoCrc=? WHERE IdVisita='" + objVerifica.getIdVisita() + "'");
            pst.setInt(1, codVisita);
            pst.setInt(2, objVerifica.getIdent());
            pst.setInt(3, objVerifica.getdFoto());
            pst.setInt(4, objVerifica.getAnt());
            pst.setInt(5, objVerifica.getComp());
            pst.setInt(6, objVerifica.getDecla());
            pst.setInt(7, objVerifica.getAutori());
            pst.setString(8, objVerifica.getColaboradorResponsavel());
            pst.setString(9, objVerifica.getJustificativa());
            pst.setString(10, objVerifica.getAprova());
            pst.setInt(11, objVerifica.getAtes());
            pst.setInt(12, objVerifica.getVisApr());
            pst.setInt(13, objVerifica.getVisRep());
            pst.setString(14, objVerifica.getUsuarioUp());
            pst.setString(15, objVerifica.getDataUp());
            pst.setString(16, objVerifica.getHorarioUp());
            pst.setInt(17, codInterno);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVerifica;
    }

    public VerificarDocumentosVisita excluirDocumentos(VerificarDocumentosVisita objVerifica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VERIFICA_DOCUMENTOS_VISITA WHERE IdVerDoc='" + objVerifica.getIdVerDoc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objVerifica;
    }

    public void buscarVisita(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + nome + "' "
                    + "AND IdVisita='" + codigo + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nomeInt, int codigoInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInt + "' "
                    + "AND IdInternoCrc='" + codigoInt + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
