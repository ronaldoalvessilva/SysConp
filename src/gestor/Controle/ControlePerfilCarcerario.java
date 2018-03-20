/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PerfilCarcerario;
import gestor.Modelo.PerfilCarcerarioInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePerfilCarcerario {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PerfilCarcerario objPerfil = new PerfilCarcerario();
    int codInt;

    public PerfilCarcerario incluirPerfilCarcerario(PerfilCarcerario objPerfil) {
        buscarInternoCrc(objPerfil.getNomeInternoPerfil());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PERFIL_CARCERARIO (IdPerfil,IdInternoCrc,ResidenciaFixa,"
                    + "FilhosRecPaternidade,FilhosMaior21,ComposicaoFamiliar,RG,FilhosMenor21,CPF,FamiliaRecBeneGov,TemVisita,Escolaridade,"
                    + "FrequentaEscolaUnid,FezENEN,AtividadeLabor,CarteiraAssinada,TranstornoMental,UsouDrogas,UsaDrogas,Diabetes,Hipertensao,"
                    + "Sifilis,Tuberculose,Hepatite,HIV,Hanseniase,Reu,Artigo,UsuarioInsert,DataInsert,HorarioInsert,InteresseTrabalhar,AnemiaFalsiforme) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPerfil.getIdPerfil());
            pst.setInt(2, codInt);
            pst.setString(3, objPerfil.getResidenciaFixa());
            pst.setInt(4, objPerfil.getFilhosRecPaternidade());
            pst.setInt(5, objPerfil.getFilhosMaior21());
            pst.setString(6, objPerfil.getComposicaoFamiliar());
            pst.setString(7, objPerfil.getrG());
            pst.setInt(8, objPerfil.getFilhosMenor21());
            pst.setString(9, objPerfil.getcPF());
            pst.setString(10, objPerfil.getFamiliaRecBeneGov());
            pst.setString(11, objPerfil.getTemVisita());
            pst.setString(12, objPerfil.getEscolaridade());
            pst.setString(13, objPerfil.getFrequentaEscolaUnid());
            pst.setString(14, objPerfil.getFezENEN());
            pst.setString(15, objPerfil.getAtividadeLabor());
            pst.setString(16, objPerfil.getCarteiraAssinada());
            pst.setString(17, objPerfil.getTranstornoMental());
            pst.setString(18, objPerfil.getUsouDrogas());
            pst.setString(19, objPerfil.getUsaDrogas());
            pst.setString(20, objPerfil.getDiabetes());
            pst.setString(21, objPerfil.getHipertensao());
            pst.setString(22, objPerfil.getSifilis());
            pst.setString(23, objPerfil.getTuberculose());
            pst.setString(24, objPerfil.getHepatite());
            pst.setString(25, objPerfil.gethIV());
            pst.setString(26, objPerfil.getHanseniase());
            pst.setString(27, objPerfil.getReu());
            pst.setInt(28, objPerfil.getArtigo());
            pst.setString(29, objPerfil.getUsuarioInsert());
            pst.setString(30, objPerfil.getDataInsert());
            pst.setString(31, objPerfil.getHorarioInsert());
            pst.setString(32, objPerfil.getInteresseTrabalhar());
            pst.setString(33, objPerfil.getAnemiaFalsiforme());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfil;
    }

    public PerfilCarcerario alterarPerfilCarcerario(PerfilCarcerario objPerfil) {
        buscarInternoCrc(objPerfil.getNomeInternoPerfil());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO SET IdPerfil=?,IdInternoCrc=?,ResidenciaFixa=?,"
                    + "FilhosRecPaternidade=?,FilhosMaior21=?,ComposicaoFamiliar=?,RG=?,FilhosMenor21=?,CPF=?,FamiliaRecBeneGov=?,TemVisita=?,Escolaridade=?,"
                    + "FrequentaEscolaUnid=?,FezENEN=?,AtividadeLabor=?,CarteiraAssinada=?,TranstornoMental=?,UsouDrogas=?,UsaDrogas=?,Diabetes=?,Hipertensao=?,"
                    + "Sifilis=?,Tuberculose=?,Hepatite=?,HIV=?,Hanseniase=?,Reu=?,Artigo=?,UsuarioUp=?,DataUp=?,HorarioUp=?,InteresseTrabalhar=?,AnemiaFalsiforme=? WHERE IdPerfilCar='" + objPerfil.getIdPerfilCar() + "'");
            pst.setInt(1, objPerfil.getIdPerfil());
            pst.setInt(2, codInt);
            pst.setString(3, objPerfil.getResidenciaFixa());
            pst.setInt(4, objPerfil.getFilhosRecPaternidade());
            pst.setInt(5, objPerfil.getFilhosMaior21());
            pst.setString(6, objPerfil.getComposicaoFamiliar());
            pst.setString(7, objPerfil.getrG());
            pst.setInt(8, objPerfil.getFilhosMenor21());
            pst.setString(9, objPerfil.getcPF());
            pst.setString(10, objPerfil.getFamiliaRecBeneGov());
            pst.setString(11, objPerfil.getTemVisita());
            pst.setString(12, objPerfil.getEscolaridade());
            pst.setString(13, objPerfil.getFrequentaEscolaUnid());
            pst.setString(14, objPerfil.getFezENEN());
            pst.setString(15, objPerfil.getAtividadeLabor());
            pst.setString(16, objPerfil.getCarteiraAssinada());
            pst.setString(17, objPerfil.getTranstornoMental());
            pst.setString(18, objPerfil.getUsouDrogas());
            pst.setString(19, objPerfil.getUsaDrogas());
            pst.setString(20, objPerfil.getDiabetes());
            pst.setString(21, objPerfil.getHipertensao());
            pst.setString(22, objPerfil.getSifilis());
            pst.setString(23, objPerfil.getTuberculose());
            pst.setString(24, objPerfil.getHepatite());
            pst.setString(25, objPerfil.gethIV());
            pst.setString(26, objPerfil.getHanseniase());
            pst.setString(27, objPerfil.getReu());
            pst.setInt(28, objPerfil.getArtigo());
            pst.setString(29, objPerfil.getUsuarioUp());
            pst.setString(30, objPerfil.getDataUp());
            pst.setString(31, objPerfil.getHorarioUp());
            pst.setString(32, objPerfil.getInteresseTrabalhar());
            pst.setString(33, objPerfil.getAnemiaFalsiforme());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfil;
    }

    public PerfilCarcerario excluirPerfilCarcerario(PerfilCarcerario objPerfil) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PERFIL_CARCERARIO WHERE IdPerfilCar='" + objPerfil.getIdPerfilCar() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPerfil;
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
