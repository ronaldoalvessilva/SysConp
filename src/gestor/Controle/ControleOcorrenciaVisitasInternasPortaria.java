/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OcorrenciaIndisciplinaPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleOcorrenciaVisitasInternasPortaria {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciaIndisciplinaPortaria objocrIndPorta = new OcorrenciaIndisciplinaPortaria();
    int codInterno;

    public OcorrenciaIndisciplinaPortaria incluirOcorrenciaVisitasInternos(OcorrenciaIndisciplinaPortaria objocrIndPorta) {
        buscarVisitaInterna(objocrIndPorta.getNomeIntenoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS (IdReg,IdInternoCrc,TextoOcorrencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objocrIndPorta.getIdReg());
            pst.setInt(2, codInterno);
            pst.setString(3, objocrIndPorta.getTextoOcorrencia());
            pst.setString(4, objocrIndPorta.getUsuarioInsert());
            pst.setString(5, objocrIndPorta.getDataInsert());
            pst.setString(6, objocrIndPorta.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objocrIndPorta;
    }

    public OcorrenciaIndisciplinaPortaria alterarOcorrenciaVisitasInternos(OcorrenciaIndisciplinaPortaria objocrIndPorta) {
        buscarVisitaInterna(objocrIndPorta.getNomeVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS SET IdReg=?,IdInternoCrc=?,TextoOcorrencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdOcr='" + objocrIndPorta.getIdOcr() + "'");
            pst.setInt(1, objocrIndPorta.getIdReg());
            pst.setInt(2, codInterno);
            pst.setString(3, objocrIndPorta.getTextoOcorrencia());
            pst.setString(4, objocrIndPorta.getUsuarioUp());
            pst.setString(5, objocrIndPorta.getDataUp());
            pst.setString(6, objocrIndPorta.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objocrIndPorta;
    }

    public OcorrenciaIndisciplinaPortaria excluirOcorrenciaVisitasInternos(OcorrenciaIndisciplinaPortaria objocrIndPorta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIA_INDISCIPLINA_PORTARIAiNTERNOS WHERE IdOcr='" + objocrIndPorta.getIdOcr() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objocrIndPorta;
    }

    public void buscarVisitaInterna(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
