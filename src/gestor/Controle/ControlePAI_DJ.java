/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaPAI_DJ;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePAI_DJ {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaPAI_DJ objFichaDJ = new FichaPAI_DJ();
    int codInt;

    public FichaPAI_DJ incluirPAI_DJ(FichaPAI_DJ objFichaDJ) {
        buscarInternoCrc(objFichaDJ.getNomeInternoCrc(), objFichaDJ.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_DJ (IdPai,IdInternoCrc,RegimeAprisionamento,Artigo,Delito,Reincidente,PossuiPena,QualPena,PossuiJuridica,QualAssistenciaJuridica,"
                    + "PROMAE,AssistenciaJuridica,Trabalhaempresa,TelefoneContatoEmpresa,QualEmpresa,QualFuncaoExerce,CartaInformal,ParaOnde,TelefoneContato,EstudaUP,OndeEstuda,NecessitaTrabalho,QualNecessitaTrabalho,NecessitaEstudaFUP,QualNecessidadeEstudaFUP,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFichaDJ.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDJ.getRegimeAprisionamento());
            pst.setInt(4, objFichaDJ.getArtigo());
            pst.setString(5, objFichaDJ.getDelito());
            pst.setString(6, objFichaDJ.getReincidente());
            pst.setString(7, objFichaDJ.getPossuiPena());
            pst.setString(8, objFichaDJ.getQualPena());
            pst.setString(9, objFichaDJ.getPossuiJuridica());
            pst.setString(10, objFichaDJ.getQualAssistenciaJuridica());
            pst.setString(11, objFichaDJ.getpROMAE());
            pst.setString(12, objFichaDJ.getAssistenciaJuridica());
            pst.setString(13, objFichaDJ.getTrabalhaempresa());
            pst.setString(14, objFichaDJ.getTelefoneContatoEmpresa());
            pst.setString(15, objFichaDJ.getQualEmpresa());
            pst.setString(16, objFichaDJ.getQualFuncaoExerce());
            pst.setString(17, objFichaDJ.getCartaInformal());
            pst.setString(18, objFichaDJ.getParaOnde());
            pst.setString(19, objFichaDJ.getTelefoneContato());
            pst.setString(20, objFichaDJ.getEstudaUP());
            pst.setString(21, objFichaDJ.getOndeEstuda());
            pst.setString(22, objFichaDJ.getNecessitaTrabalho());
            pst.setString(23, objFichaDJ.getQualNecessitaTrabalho());
            pst.setString(24, objFichaDJ.getNecessitaEstudaFUP());
            pst.setString(25, objFichaDJ.getQualNecessidadeEstudaFUP());
            pst.setString(26, objFichaDJ.getUsuarioInsert());
            pst.setString(27, objFichaDJ.getDataInsert());
            pst.setString(28, objFichaDJ.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDJ;
    }

    public FichaPAI_DJ alterarPAI_DJ(FichaPAI_DJ objFichaDJ) {
        buscarInternoCrc(objFichaDJ.getNomeInternoCrc(), objFichaDJ.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_DJ SET IdPai=?,IdInternoCrc=?,RegimeAprisionamento=?,Artigo=?,Delito=?,Reincidente=?,PossuiPena=?,QualPena=?,PossuiJuridica=?,QualAssistenciaJuridica=?,"
                    + "PROMAE=?,AssistenciaJuridica=?,Trabalhaempresa=?,TelefoneContatoEmpresa=?,QualEmpresa=?,QualFuncaoExerce=?,CartaInformal=?,ParaOnde=?,TelefoneContato=?,EstudaUP=?,OndeEstuda=?,NecessitaTrabalho=?,QualNecessitaTrabalho=?,"
                    + "NecessitaEstudaFUP=?,QualNecessidadeEstudaFUP=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPai='" + objFichaDJ.getIdPai() + "'");
            pst.setInt(1, objFichaDJ.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDJ.getRegimeAprisionamento());
            pst.setInt(4, objFichaDJ.getArtigo());
            pst.setString(5, objFichaDJ.getDelito());
            pst.setString(6, objFichaDJ.getReincidente());
            pst.setString(7, objFichaDJ.getPossuiPena());
            pst.setString(8, objFichaDJ.getQualPena());
            pst.setString(9, objFichaDJ.getPossuiJuridica());
            pst.setString(10, objFichaDJ.getQualAssistenciaJuridica());
            pst.setString(11, objFichaDJ.getpROMAE());
            pst.setString(12, objFichaDJ.getAssistenciaJuridica());
            pst.setString(13, objFichaDJ.getTrabalhaempresa());
            pst.setString(14, objFichaDJ.getTelefoneContatoEmpresa());
            pst.setString(15, objFichaDJ.getQualEmpresa());
            pst.setString(16, objFichaDJ.getQualFuncaoExerce());
            pst.setString(17, objFichaDJ.getCartaInformal());
            pst.setString(18, objFichaDJ.getParaOnde());
            pst.setString(19, objFichaDJ.getTelefoneContato());
            pst.setString(20, objFichaDJ.getEstudaUP());
            pst.setString(21, objFichaDJ.getOndeEstuda());
            pst.setString(22, objFichaDJ.getNecessitaTrabalho());
            pst.setString(23, objFichaDJ.getQualNecessitaTrabalho());
            pst.setString(24, objFichaDJ.getNecessitaEstudaFUP());
            pst.setString(25, objFichaDJ.getQualNecessidadeEstudaFUP());
            pst.setString(26, objFichaDJ.getUsuarioInsert());
            pst.setString(27, objFichaDJ.getDataInsert());
            pst.setString(28, objFichaDJ.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDJ;
    }

    public FichaPAI_DJ excluirPAI_DJ(FichaPAI_DJ objFichaDJ) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_DJ WHERE IdPai='" + objFichaDJ.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDJ;
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
