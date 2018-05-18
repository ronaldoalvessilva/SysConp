/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaAdvogadosInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntSaiAdvInternos {

    int codAdvogado;

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaAdvogadosInternos objEntSaiAdInternos = new EntradaSaidaAdvogadosInternos();

    public EntradaSaidaAdvogadosInternos incluirEntSaiAdvogado(EntradaSaidaAdvogadosInternos objEntSaiAdInternos) {
        buscarAdvogado(objEntSaiAdInternos.getNomeAdvogado(),objEntSaiAdInternos.getIdAdvogado());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADASADVINTERNOS (DataLanc,StatusLanc,IdAdvogado,ObsLanc,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAdInternos.getDataLanc().getTime()));
            pst.setString(2, objEntSaiAdInternos.getStatusLanc());
            pst.setInt(3, codAdvogado);
            pst.setString(4, objEntSaiAdInternos.getObsLanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(6, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(8, objEntSaiAdInternos.getHorarioSaida());
            pst.setString(9, objEntSaiAdInternos.getUsuarioInsert());
            pst.setString(10, objEntSaiAdInternos.getDataInsert());
            pst.setString(11, objEntSaiAdInternos.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }

    public EntradaSaidaAdvogadosInternos alterarEntSaiAdvogado(EntradaSaidaAdvogadosInternos objEntSaiAdInternos) {
        buscarAdvogado(objEntSaiAdInternos.getNomeAdvogado(),objEntSaiAdInternos.getIdAdvogado());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET DataLanc=?,StatusLanc=?,IdAdvogado=?,ObsLanc=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "'");  
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAdInternos.getDataLanc().getTime()));
            pst.setString(2, objEntSaiAdInternos.getStatusLanc());
            pst.setInt(3, codAdvogado);
            pst.setString(4, objEntSaiAdInternos.getObsLanc());
            pst.setTimestamp(5, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(6, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(7, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(8, objEntSaiAdInternos.getHorarioSaida());
            pst.setString(9, objEntSaiAdInternos.getUsuarioUp());
            pst.setString(10, objEntSaiAdInternos.getDataUp());
            pst.setString(11, objEntSaiAdInternos.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }

    public EntradaSaidaAdvogadosInternos excluirEntSaiAdvogado(EntradaSaidaAdvogadosInternos objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADASADVINTERNOS WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }

    public EntradaSaidaAdvogadosInternos finalizarEntSaiAdvInterno(EntradaSaidaAdvogadosInternos objEntSaiAdInternos) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET StatusLanc=? WHERE IdLanc='" + objEntSaiAdInternos.getIdLanc() + "'");
            pst.setString(1, objEntSaiAdInternos.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }

    public void buscarAdvogado(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ADVOGADOS WHERE NomeAdvogado='" + desc + "' AND IdAdvogado='" + cod + "'");
            conecta.rs.first();
            codAdvogado = conecta.rs.getInt("IdAdvogado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (ADVOGADO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
