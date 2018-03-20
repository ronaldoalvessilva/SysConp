/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaPAI_DPTL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePAI_DPTL {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaPAI_DPTL objFichaDPTL = new FichaPAI_DPTL();
    int codInt;

    public FichaPAI_DPTL incluirPAI_DPTL(FichaPAI_DPTL objFichaDPTL) {
        buscarInternoCrc(objFichaDPTL.getNomeInternoCrc(), objFichaDPTL.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_DPTL (IdPai,IdInternoCrc,ProfissaoOcupacao,TrabalhaDetido,Desempregado,CarteiraAssinada,QuantoTempoCarteira,FaixaSalarial,TemBeneficios,QuemTemBeneficios,"
                    + "DemandaReclusao,DemandaDesemprego,PossuiRedimento,QualRendimento,ExerceAtividade,QualAtividadeExerce,GeracaoRenda,AptidaoProfissional,QualAptidao,DemandaProfissional,QualDemandaProfissional,AptidaoArt,QualAptidaoArt,DemandaLazer,QualDemandaLazer,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFichaDPTL.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDPTL.getProfissaoOcupacao());
            pst.setString(4, objFichaDPTL.getTrabalhaDetido());
            pst.setString(5, objFichaDPTL.getDesempregado());
            pst.setString(6, objFichaDPTL.getCarteiraAssinada());
            pst.setInt(7, objFichaDPTL.getQuantoTempoCarteira());
            pst.setDouble(8, objFichaDPTL.getFaixaSalarial());
            pst.setString(9, objFichaDPTL.getTemBeneficios());
            pst.setString(10, objFichaDPTL.getQuemTemBeneficios());
            pst.setString(11, objFichaDPTL.getDemandaReclusao());
            pst.setString(12, objFichaDPTL.getDemandaDesemprego());
            pst.setString(13, objFichaDPTL.getPossuiRedimento());
            pst.setString(14, objFichaDPTL.getQualRendimento());
            pst.setString(15, objFichaDPTL.getExerceAtividade());
            pst.setString(16, objFichaDPTL.getQualAtividadeExerce());
            pst.setString(17, objFichaDPTL.getGeracaoRenda());
            pst.setString(18, objFichaDPTL.getAptidaoProfissional());
            pst.setString(19, objFichaDPTL.getQualAptidao());
            pst.setString(20, objFichaDPTL.getDemandaProfissional());
            pst.setString(21, objFichaDPTL.getQualDemandaProfissional());
            pst.setString(22, objFichaDPTL.getAptidaoArt());
            pst.setString(23, objFichaDPTL.getQualAptidaoArt());
            pst.setString(24, objFichaDPTL.getDemandaLazer());
            pst.setString(25, objFichaDPTL.getQualDemandaLazer());
            pst.setString(26, objFichaDPTL.getUsuarioInsert());
            pst.setString(27, objFichaDPTL.getDataInsert());
            pst.setString(28, objFichaDPTL.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDPTL;
    }

    public FichaPAI_DPTL alterarPAI_DPTL(FichaPAI_DPTL objFichaDPTL) {
        buscarInternoCrc(objFichaDPTL.getNomeInternoCrc(), objFichaDPTL.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_DPTL SET IdPai=?,IdInternoCrc=?,ProfissaoOcupacao=?,TrabalhaDetido=?,Desempregado=?,CarteiraAssinada=?,QuantoTempoCarteira=?,FaixaSalarial=?,TemBeneficios=?,QuemTemBeneficios=?,"
                    + "DemandaReclusao=?,DemandaDesemprego=?,PossuiRedimento=?,QualRendimento=?,ExerceAtividade=?,QualAtividadeExerce=?,GeracaoRenda=?,AptidaoProfissional=?,QualAptidao=?,DemandaProfissional=?,QualDemandaProfissional=?,AptidaoArt=?,QualAptidaoArt=?,DemandaLazer=?,QualDemandaLazer=?,UsuarioUp=?,DataUp=?,"
                    + "HorarioUp=? WHERE IdPai='" + objFichaDPTL.getIdPai() + "'");
            pst.setInt(1, objFichaDPTL.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objFichaDPTL.getProfissaoOcupacao());
            pst.setString(4, objFichaDPTL.getTrabalhaDetido());
            pst.setString(5, objFichaDPTL.getDesempregado());
            pst.setString(6, objFichaDPTL.getCarteiraAssinada());
            pst.setInt(7, objFichaDPTL.getQuantoTempoCarteira());
            pst.setDouble(8, objFichaDPTL.getFaixaSalarial());
            pst.setString(9, objFichaDPTL.getTemBeneficios());
            pst.setString(10, objFichaDPTL.getQuemTemBeneficios());
            pst.setString(11, objFichaDPTL.getDemandaReclusao());
            pst.setString(12, objFichaDPTL.getDemandaDesemprego());
            pst.setString(13, objFichaDPTL.getPossuiRedimento());
            pst.setString(14, objFichaDPTL.getQualRendimento());
            pst.setString(15, objFichaDPTL.getExerceAtividade());
            pst.setString(16, objFichaDPTL.getQualAtividadeExerce());
            pst.setString(17, objFichaDPTL.getGeracaoRenda());
            pst.setString(18, objFichaDPTL.getAptidaoProfissional());
            pst.setString(19, objFichaDPTL.getQualAptidao());
            pst.setString(20, objFichaDPTL.getDemandaProfissional());
            pst.setString(21, objFichaDPTL.getQualDemandaProfissional());
            pst.setString(22, objFichaDPTL.getAptidaoArt());
            pst.setString(23, objFichaDPTL.getQualAptidaoArt());
            pst.setString(24, objFichaDPTL.getDemandaLazer());
            pst.setString(25, objFichaDPTL.getQualDemandaLazer());
            pst.setString(26, objFichaDPTL.getUsuarioInsert());
            pst.setString(27, objFichaDPTL.getDataInsert());
            pst.setString(28, objFichaDPTL.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDPTL;
    }

    public FichaPAI_DPTL excluirPAI_DPTL(FichaPAI_DPTL objFichaDPTL) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_DPTL WHERE IdPai='" + objFichaDPTL.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFichaDPTL;
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
