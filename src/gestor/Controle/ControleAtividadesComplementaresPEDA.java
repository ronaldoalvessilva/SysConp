/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesComplementarePedagogica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleAtividadesComplementaresPEDA {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesComplementarePedagogica objAtivi = new AtividadesComplementarePedagogica();

    public AtividadesComplementarePedagogica incluirAC(AtividadesComplementarePedagogica objAtivi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_COMPLEMENTARES_PEDAGOGICA (StatusAC,DataAC,IdCod,IdProf,CargaHoraria,TurnoAtividade,Dia2,Dia3,Dia4,Dia5,Dia6,Dia7,Dia8,IdCurso,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtivi.getStatusAC());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtivi.getDataAC().getTime()));
            pst.setInt(3, objAtivi.getIdCod());
            pst.setInt(4, objAtivi.getIdProf());
            pst.setString(5, objAtivi.getCargaHoraria());
            pst.setString(6, objAtivi.getTurnoAtividade());
            pst.setInt(7, objAtivi.getDia2());
            pst.setInt(8, objAtivi.getDia3());
            pst.setInt(9, objAtivi.getDia4());
            pst.setInt(10, objAtivi.getDia5());
            pst.setInt(11, objAtivi.getDia6());
            pst.setInt(12, objAtivi.getDia7());
            pst.setInt(13, objAtivi.getDia8());
            pst.setInt(14, objAtivi.getIdCurso());
            pst.setString(15, objAtivi.getObservacao());
            pst.setString(16, objAtivi.getUsuarioInsert());
            pst.setString(17, objAtivi.getDataInsert());
            pst.setString(18, objAtivi.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public AtividadesComplementarePedagogica alterarAC(AtividadesComplementarePedagogica objAtivi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET StatusAC=?,DataAC=?,IdCod=?,IdProf=?,CargaHoraria=?,TurnoAtividade=?,Dia2=?,Dia3=?,Dia4=?,Dia5=?,Dia6=?,Dia7=?,Dia8=?,IdCurso=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAC='" + objAtivi.getIdAC() + "'");
            pst.setString(1, objAtivi.getStatusAC());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtivi.getDataAC().getTime()));
            pst.setInt(3, objAtivi.getIdCod());
            pst.setInt(4, objAtivi.getIdProf());
            pst.setString(5, objAtivi.getCargaHoraria());
            pst.setString(6, objAtivi.getTurnoAtividade());
            pst.setInt(7, objAtivi.getDia2());
            pst.setInt(8, objAtivi.getDia3());
            pst.setInt(9, objAtivi.getDia4());
            pst.setInt(10, objAtivi.getDia5());
            pst.setInt(11, objAtivi.getDia6());
            pst.setInt(12, objAtivi.getDia7());
            pst.setInt(13, objAtivi.getDia8());
            pst.setInt(14, objAtivi.getIdCurso());
            pst.setString(15, objAtivi.getObservacao());
            pst.setString(16, objAtivi.getUsuarioUp());
            pst.setString(17, objAtivi.getDataUp());
            pst.setString(18, objAtivi.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }

    public AtividadesComplementarePedagogica excluirAC(AtividadesComplementarePedagogica objAtivi) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_COMPLEMENTARES_PEDAGOGICA WHERE IdAC='" + objAtivi.getIdAC() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtivi;
    }
}
