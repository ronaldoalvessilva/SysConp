/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaOficialJusticaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntSaiOFInternos {

    int codOficialJustica;

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaOficialJusticaInternos objEntSaiOFInternos = new EntradaSaidaOficialJusticaInternos();

    public EntradaSaidaOficialJusticaInternos incluirEntSaiOficialJustica(EntradaSaidaOficialJusticaInternos objEntSaiOFInternos) {
        buscarOficialJustica(objEntSaiOFInternos.getNomeOficialJustica(),objEntSaiOFInternos.getIdOficialJustica());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_OFICIAL_JUSTICA_INTERNOS (DataLanc,StatusLanc,IdOficial,ObsLanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiOFInternos.getDataLanc().getTime()));
            pst.setString(2, objEntSaiOFInternos.getStatusLanc());
            pst.setInt(3, codOficialJustica);
            pst.setString(4, objEntSaiOFInternos.getObsLanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objEntSaiOFInternos.getDataEntrada().getTime()));
            pst.setString(6, objEntSaiOFInternos.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objEntSaiOFInternos.getDataSaida().getTime()));
            pst.setString(8, objEntSaiOFInternos.getHorarioSaida());
            pst.setString(9, objEntSaiOFInternos.getUsuarioInsert());
            pst.setString(10, objEntSaiOFInternos.getDataInsert());
            pst.setString(11, objEntSaiOFInternos.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOFInternos;
    }

    public EntradaSaidaOficialJusticaInternos alterarEntSaiOficialJustica(EntradaSaidaOficialJusticaInternos objEntSaiOFInternos) {
        buscarOficialJustica(objEntSaiOFInternos.getNomeOficialJustica(),objEntSaiOFInternos.getIdOficialJustica());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA_INTERNOS SET DataLanc=?,StatusLanc=?,IdOficial=?,ObsLanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Idlanc='" + objEntSaiOFInternos.getIdLanc() + "'");  
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiOFInternos.getDataLanc().getTime()));
            pst.setString(2, objEntSaiOFInternos.getStatusLanc());
            pst.setInt(3, codOficialJustica);
            pst.setString(4, objEntSaiOFInternos.getObsLanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objEntSaiOFInternos.getDataEntrada().getTime()));
            pst.setString(6, objEntSaiOFInternos.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objEntSaiOFInternos.getDataSaida().getTime()));
            pst.setString(8, objEntSaiOFInternos.getHorarioSaida());
            pst.setString(9, objEntSaiOFInternos.getUsuarioUp());
            pst.setString(10, objEntSaiOFInternos.getDataUp());
            pst.setString(11, objEntSaiOFInternos.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOFInternos;
    }

    public EntradaSaidaOficialJusticaInternos excluirEntSaiOficialJustica(EntradaSaidaOficialJusticaInternos objEntSaiOFInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAS_OFICIAL_JUSTICA_INTERNOS WHERE Idlanc='" + objEntSaiOFInternos.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOFInternos;
    }

    public EntradaSaidaOficialJusticaInternos finalizarEntSaiOficialJustica(EntradaSaidaOficialJusticaInternos objEntSaiOFInternos) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA_INTERNOS SET StatusLanc=? WHERE IdLanc='" + objEntSaiOFInternos.getIdLanc()+ "'");
            pst.setString(1, objEntSaiOFInternos.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOFInternos;
    }

    public void buscarOficialJustica(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OFICIAL_JUSTICA WHERE NomeOficial='" + desc + "'AND IdOficial='" + codigo  + "'");
            conecta.rs.first();
            codOficialJustica = conecta.rs.getInt("IdOficial");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (OFICIA DE JUSTIÇA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
