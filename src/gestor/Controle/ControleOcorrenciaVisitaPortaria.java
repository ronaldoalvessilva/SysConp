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
 * @author Ronaldo
 */
public class ControleOcorrenciaVisitaPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OcorrenciaIndisciplinaPortaria objocrIndPorta = new OcorrenciaIndisciplinaPortaria();
    int codVisita;

    public OcorrenciaIndisciplinaPortaria incluirOcorrenciaVisitas(OcorrenciaIndisciplinaPortaria objocrIndPorta) {
        buscarVisitaInterno(objocrIndPorta.getNomeVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCORRENCIA_INDISCIPLINA_PORTARIA (IdReg,IdVisita,TextoOcorrencia,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objocrIndPorta.getIdReg());
            pst.setInt(2, codVisita);
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

    public OcorrenciaIndisciplinaPortaria alterarOcorrenciaVisitas(OcorrenciaIndisciplinaPortaria objocrIndPorta) {
        buscarVisitaInterno(objocrIndPorta.getNomeVisita());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIA_INDISCIPLINA_PORTARIA SET IdReg=?,IdVisita=?,TextoOcorrencia=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdOcr='" + objocrIndPorta.getIdOcr() + "'");
            pst.setInt(1, objocrIndPorta.getIdReg());
            pst.setInt(2, codVisita);
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

    public OcorrenciaIndisciplinaPortaria excluirOcorrenciaVisitas(OcorrenciaIndisciplinaPortaria objocrIndPorta) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCORRENCIA_INDISCIPLINA_PORTARIA WHERE IdOcr='" + objocrIndPorta.getIdOcr() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objocrIndPorta;
    }

    public void buscarVisitaInterno(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + nome + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
