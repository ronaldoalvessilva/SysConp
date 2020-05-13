/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoPsicologica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEvolucaoPsicologica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoPsicologica evolu = new EvolucaoPsicologica();

    int codInterno;

    public EvolucaoPsicologica incluirEvolucaoPsi(EvolucaoPsicologica evolu) {
        buscarInternoCrc(evolu.getNomeInternoCrc(), evolu.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOPSICOLOGICA (StatusEvo,DataEvolucao,IdLanc,IdInternoCrc,Historico,UsuarioInsert,DataInsert,HorarioInsert,NomeDepartamento,DataEncaminhamento,HoraEncaminhamento) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, evolu.getStatusEvo());
            pst.setTimestamp(2, new java.sql.Timestamp(evolu.getDataEvolucao().getTime()));
            pst.setInt(3, evolu.getIdLanc());
            pst.setInt(4, codInterno);
            pst.setString(5, evolu.getHistorico());
            pst.setString(6, evolu.getUsuarioInsert());
            pst.setString(7, evolu.getDataInsert());
            pst.setString(8, evolu.getHorarioInsert());
            pst.setString(9, evolu.getNomeDepartamento());
            pst.setTimestamp(10, new java.sql.Timestamp(evolu.getDataEncaminhamento().getTime()));
            pst.setString(11, evolu.getHoraEncaminhamento());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return evolu;
    }

    public EvolucaoPsicologica alterarEvolucaoPsi(EvolucaoPsicologica evolu) {
        buscarInternoCrc(evolu.getNomeInternoCrc(), evolu.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOPSICOLOGICA SET StatusEvo=?,DataEvolucao=?,IdLanc=?,IdInternoCrc=?,Historico=?,UsuarioUp=?,DataUp=?,HorarioUp=?,NomeDepartamento=?,DataEncaminhamento=?,HoraEncaminhamento=? WHERE IdEvolucao='" + evolu.getIdEvolucao() + "'AND IdLanc='" + evolu.getIdLanc() + "'AND IdInternoCrc='" + evolu.getIdInternoCrc() + "'");
            pst.setString(1, evolu.getStatusEvo());
            pst.setTimestamp(2, new java.sql.Timestamp(evolu.getDataEvolucao().getTime()));
            pst.setInt(3, evolu.getIdLanc());
            pst.setInt(4, codInterno);
            pst.setString(5, evolu.getHistorico());
            pst.setString(6, evolu.getUsuarioUp());
            pst.setString(7, evolu.getDataUp());
            pst.setString(8, evolu.getHorarioUp());
            pst.setString(9, evolu.getNomeDepartamento());
            pst.setTimestamp(10, new java.sql.Timestamp(evolu.getDataEncaminhamento().getTime()));
            pst.setString(11, evolu.getHoraEncaminhamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return evolu;
    }

    public EvolucaoPsicologica excluirEvolucaoPsi(EvolucaoPsicologica evolu) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOPSICOLOGICA  WHERE IdEvolucao='" + evolu.getIdEvolucao() + "'AND IdLanc='" + evolu.getIdLanc() + "'AND IdInternoCrc='" + evolu.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return evolu;
    }

    public EvolucaoPsicologica incluirEvolucaoPsiADM(EvolucaoPsicologica evolu) {
        buscarInternoCrc(evolu.getNomeInternoCrc(), evolu.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOPSICOLOGICA (DataEvolucao,IdLanc,IdInternoCrc,Historico,UsuarioInsert,DataInsert,HorarioInsert,NomeDepartamento,DataEncaminhamento,HoraEncaminhamento,AdmEvo) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            if (evolu.getDataEvolucao() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(evolu.getDataEvolucao().getTime()));
            } else {
                pst.setDate(1, null);
            }
            pst.setInt(2, evolu.getIdLanc());
            pst.setInt(3, codInterno);
            pst.setString(4, evolu.getHistorico());
            pst.setString(5, evolu.getUsuarioInsert());
            pst.setString(6, evolu.getDataInsert());
            pst.setString(7, evolu.getHorarioInsert());
            pst.setString(8, evolu.getNomeDepartamento());
            pst.setTimestamp(9, new java.sql.Timestamp(evolu.getDataEncaminhamento().getTime()));
            pst.setString(10, evolu.getHoraEncaminhamento());
            pst.setString(11, evolu.getAdmEvo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return evolu;
    }

    public EvolucaoPsicologica alterarEvolucaoPsiADM(EvolucaoPsicologica evolu) {
        buscarInternoCrc(evolu.getNomeInternoCrc(), evolu.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOPSICOLOGICA SET DataEvolucao=?,IdLanc=?,IdInternoCrc=?,Historico=?,UsuarioUp=?,DataUp=?,HorarioUp=?,NomeDepartamento=?,DataEncaminhamento=?,HoraEncaminhamento=? WHERE AdmEvo='" + evolu.getAdmEvo() + "'AND IdLanc='" + evolu.getIdLanc() + "'");
            if (evolu.getDataEvolucao() != null) {
                pst.setTimestamp(1, new java.sql.Timestamp(evolu.getDataEvolucao().getTime()));
            } else {
                pst.setDate(1, null);
            }
            pst.setInt(2, evolu.getIdLanc());
            pst.setInt(3, codInterno);
            pst.setString(4, evolu.getHistorico());
            pst.setString(5, evolu.getUsuarioUp());
            pst.setString(6, evolu.getDataUp());
            pst.setString(7, evolu.getHorarioUp());
            pst.setString(8, evolu.getNomeDepartamento());
            pst.setTimestamp(9, new java.sql.Timestamp(evolu.getDataEncaminhamento().getTime()));
            pst.setString(10, evolu.getHoraEncaminhamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return evolu;
    }

    public void buscarInternoCrc(String nomeInterno, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!\nERRO: " + e);
        }
        conecta.desconecta();
    }
}
