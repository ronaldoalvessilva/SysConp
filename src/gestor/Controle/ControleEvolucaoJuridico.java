/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EvolucaoJuridico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEvolucaoJuridico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EvolucaoJuridico objEvolu = new EvolucaoJuridico();
    int codInt;

    public EvolucaoJuridico incluirEvolucaoJuridico(EvolucaoJuridico objEvoluJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EVOLUCAOJURIDICO (DataEvo,IdInternoCrc,IdLanc,DataEnca,TipoAdvogado,Resposta,HoraEnvio,SetorEncaminhamento,Evolucao,UsuarioInsert,DataInsert,HorarioInsert,AdmEvo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvoluJuri.getDataEvo().getTime()));
            pst.setInt(2, objEvoluJuri.getIdInternoCrc());
            pst.setInt(3, objEvoluJuri.getIdLanc());
            if (objEvoluJuri.getDataEnca() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEvoluJuri.getDataEnca().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objEvoluJuri.getTipoAdvogado());
            pst.setString(6, objEvoluJuri.getResposta());
            pst.setString(7, objEvoluJuri.getHoraEnvio());
            pst.setString(8, objEvoluJuri.getSetorEncaminhamento());
            pst.setString(9, objEvoluJuri.getEvolucao());
            pst.setString(10, objEvoluJuri.getUsuarioInsert());
            pst.setString(11, objEvoluJuri.getDataInsert());
            pst.setString(12, objEvoluJuri.getHorarioInsert());
            pst.setString(13, objEvoluJuri.getAdmEvo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvoluJuri;
    }

    public EvolucaoJuridico alterarEvolucaoJuridico(EvolucaoJuridico objEvoluJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOJURIDICO SET DataEvo=?,IdInternoCrc=?,IdLanc=?,DataEnca=?,TipoAdvogado=?,Resposta=?,HoraEnvio=?,SetorEncaminhamento=?,Evolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEvo='" + objEvoluJuri.getIdEvo() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEvoluJuri.getDataEvo().getTime()));
            pst.setInt(2, objEvoluJuri.getIdInternoCrc());
            pst.setInt(3, objEvoluJuri.getIdLanc());
            if (objEvoluJuri.getDataEnca() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objEvoluJuri.getDataEnca().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objEvoluJuri.getTipoAdvogado());
            pst.setString(6, objEvoluJuri.getResposta());
            pst.setString(7, objEvoluJuri.getHoraEnvio());
            pst.setString(8, objEvoluJuri.getSetorEncaminhamento());
            pst.setString(9, objEvoluJuri.getEvolucao());
            pst.setString(10, objEvoluJuri.getUsuarioUp());
            pst.setString(11, objEvoluJuri.getDataUp());
            pst.setString(12, objEvoluJuri.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEvoluJuri;
    }

    public EvolucaoJuridico excluirEvolucaoJuridico(EvolucaoJuridico objEvoluJuri) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EVOLUCAOJURIDICO WHERE IdEvo='" + objEvoluJuri.getIdEvo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoluJuri;
    }

    // Modificar o interno da evolução quando o mesmo foir modificado na capa.
    public EvolucaoJuridico alterarInternoEvolucaoJuridicoADM(EvolucaoJuridico objEvoluJuri) {
        buscarInternoCrc(objEvoluJuri.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EVOLUCAOJURIDICO SET IdInternoCrc=?,Evolucao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEvoluJuri.getIdLanc() + "'AND AdmEvo='" + objEvoluJuri.getAdmEvo() + "'");
            pst.setInt(1, codInt);
            pst.setString(2, objEvoluJuri.getEvolucao());
            pst.setString(3, objEvoluJuri.getUsuarioUp());
            pst.setString(4, objEvoluJuri.getDataUp());
            pst.setString(5, objEvoluJuri.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEvoluJuri;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
