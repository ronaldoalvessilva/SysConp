/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaDeme;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePAI_DEME {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaDeme objFichaDeme = new FichaDeme();
    int codInt;

    public FichaDeme incluirPAI_DEME(FichaDeme objFichaDeme) {
        buscarInternoCrc(objFichaDeme.getNomeInternoCrc(), objFichaDeme.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_DEME (IdPai,IdInternoCrc,NecessitaFamilia,ParaQuemFamilia,EstaGravida,Comprovacao,PreNatal,OndePreNatal,DestinoBebe,SuspeitaGravidez,"
                    + "QuantosPartos,QuantosAbortos,QuantosPartosNornais,QuantasCesarianas,Contraceptivos,QualContraceptivos,Demanda,QualDemanda,Instrucao,EstudandoPreso,ParticipouPrisional,GostariaPrisional,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFichaDeme.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDeme.getNecessitaFamilia());
            pst.setString(4, objFichaDeme.getParaQuemFamilia());
            pst.setString(5, objFichaDeme.getEstaGravida());
            pst.setString(6, objFichaDeme.getComprovacao());
            pst.setString(7, objFichaDeme.getPreNatal());
            pst.setString(8, objFichaDeme.getOndePreNatal());
            pst.setString(9, objFichaDeme.getDestinoBebe());
            pst.setString(10, objFichaDeme.getSuspeitaGravidez());
            pst.setInt(11, objFichaDeme.getQuantosPartos());
            pst.setInt(12, objFichaDeme.getQuantosAbortos());
            pst.setInt(13, objFichaDeme.getQuantosPartosNornais());
            pst.setInt(14, objFichaDeme.getQuantasCesarianas());
            pst.setString(15, objFichaDeme.getContraceptivos());
            pst.setString(16, objFichaDeme.getQualContraceptivos());
            pst.setString(17, objFichaDeme.getDemanda());
            pst.setString(18, objFichaDeme.getQualDemanda());
            pst.setString(19, objFichaDeme.getInstrucao());
            pst.setString(20, objFichaDeme.getEstudandoPreso());
            pst.setString(21, objFichaDeme.getParticipouPrisional());
            pst.setString(22, objFichaDeme.getGostariaPrisional());
            pst.setString(23, objFichaDeme.getUsuarioInsert());
            pst.setString(24, objFichaDeme.getDataInsert());
            pst.setString(25, objFichaDeme.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDeme;
    }

    public FichaDeme alterarPAI_DEME(FichaDeme objFichaDeme) {
        buscarInternoCrc(objFichaDeme.getNomeInternoCrc(), objFichaDeme.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_DEME SET IdPai=?,IdInternoCrc=?,NecessitaFamilia=?,ParaQuemFamilia=?,EstaGravida=?,Comprovacao=?,PreNatal=?,OndePreNatal=?,DestinoBebe=?,SuspeitaGravidez=?,"
                    + "QuantosPartos=?,QuantosAbortos=?,QuantosPartosNornais=?,QuantasCesarianas=?,Contraceptivos=?,QualContraceptivos=?,Demanda=?,QualDemanda=?,Instrucao=?,EstudandoPreso=?,ParticipouPrisional=?,GostariaPrisional=?,UsuarioUp=?,DataUp=?,"
                    + "HorarioUp=? WHERE IdPai='" + objFichaDeme.getIdPai() + "'");
            pst.setInt(1, objFichaDeme.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDeme.getNecessitaFamilia());
            pst.setString(4, objFichaDeme.getParaQuemFamilia());
            pst.setString(5, objFichaDeme.getEstaGravida());
            pst.setString(6, objFichaDeme.getComprovacao());
            pst.setString(7, objFichaDeme.getPreNatal());
            pst.setString(8, objFichaDeme.getOndePreNatal());
            pst.setString(9, objFichaDeme.getDestinoBebe());
            pst.setString(10, objFichaDeme.getSuspeitaGravidez());
            pst.setInt(11, objFichaDeme.getQuantosPartos());
            pst.setInt(12, objFichaDeme.getQuantosAbortos());
            pst.setInt(13, objFichaDeme.getQuantosPartosNornais());
            pst.setInt(14, objFichaDeme.getQuantasCesarianas());
            pst.setString(15, objFichaDeme.getContraceptivos());
            pst.setString(16, objFichaDeme.getQualContraceptivos());
            pst.setString(17, objFichaDeme.getDemanda());
            pst.setString(18, objFichaDeme.getQualDemanda());
            pst.setString(19, objFichaDeme.getInstrucao());
            pst.setString(20, objFichaDeme.getEstudandoPreso());
            pst.setString(21, objFichaDeme.getParticipouPrisional());
            pst.setString(22, objFichaDeme.getGostariaPrisional());
            pst.setString(23, objFichaDeme.getUsuarioUp());
            pst.setString(24, objFichaDeme.getDataUp());
            pst.setString(25, objFichaDeme.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDeme;
    }

    public FichaDeme excluirPAI_DEME(FichaDeme objFichaDeme) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_DEME WHERE IdPai='" + objFichaDeme.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDeme;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
