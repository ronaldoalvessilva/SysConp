/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.VisitasAdvogadosInternos;
import gestor.Modelo.VisitasReligiosasPortaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleVisitasReligiosas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    VisitasReligiosasPortaria objEntSaiVisitasReligiosas = new VisitasReligiosasPortaria();

    public VisitasReligiosasPortaria incluirVisitasHistReligiosa(VisitasReligiosasPortaria objEntSaiVisitasReligiosas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_VISITAS_RELIGIOSA (IdCod,IdVisitaRel,IdEntSaiVisita,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objEntSaiVisitasReligiosas.getIdIstituicao());
            pst.setInt(2, objEntSaiVisitasReligiosas.getIdVisitaRel());
            pst.setInt(3, objEntSaiVisitasReligiosas.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEntSaiVisitasReligiosas.getDataEntrada().getTime()));
            pst.setString(5, objEntSaiVisitasReligiosas.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objEntSaiVisitasReligiosas.getDataSaida().getTime()));
            pst.setString(7, objEntSaiVisitasReligiosas.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasReligiosas;
    }

    public VisitasReligiosasPortaria alterarVisitasHistReligiosa(VisitasReligiosasPortaria objEntSaiVisitasReligiosas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_VISITAS_RELIGIOSA SET IdCod=?,IdVisitaRel=?,IdEntSaiVisita=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE IdEntSaiVisita='" + objEntSaiVisitasReligiosas.getIdLanc() + "'");
            pst.setInt(1, objEntSaiVisitasReligiosas.getIdIstituicao());
            pst.setInt(2, objEntSaiVisitasReligiosas.getIdVisitaRel());
            pst.setInt(3, objEntSaiVisitasReligiosas.getIdLanc());
            pst.setTimestamp(4, new java.sql.Timestamp(objEntSaiVisitasReligiosas.getDataEntrada().getTime()));
            pst.setString(5, objEntSaiVisitasReligiosas.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objEntSaiVisitasReligiosas.getDataSaida().getTime()));
            pst.setString(7, objEntSaiVisitasReligiosas.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasReligiosas;
    }

    public VisitasReligiosasPortaria excluirVisitasHistReligiosa(VisitasReligiosasPortaria objEntSaiVisitasReligiosas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_VISITAS_RELIGIOSA WHERE IdEntSaiVisita='" + objEntSaiVisitasReligiosas.getIdLanc() + "' AND IdVisitaRel='" + objEntSaiVisitasReligiosas.getIdVisitaRel() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiVisitasReligiosas;
    }

    public VisitasReligiosasPortaria alterarHorarioAdvogadosInterno(VisitasReligiosasPortaria objEntSaiAdInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_VISITAS_RELIGIOSA SET DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE Idlanc='" + objEntSaiAdInternos.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiAdInternos.getDataEntrada().getTime()));
            pst.setString(2, objEntSaiAdInternos.getHorarioEntrada());
            pst.setTimestamp(3, new java.sql.Timestamp(objEntSaiAdInternos.getDataSaida().getTime()));
            pst.setString(4, objEntSaiAdInternos.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiAdInternos;
    }
}
