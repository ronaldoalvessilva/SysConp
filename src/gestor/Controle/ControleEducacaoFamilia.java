/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FamiliaAdmissaoPedagogica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEducacaoFamilia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FamiliaAdmissaoPedagogica objFamAdmPedago = new FamiliaAdmissaoPedagogica();

    int idCod;

    public FamiliaAdmissaoPedagogica incluirFamiliaAdmissaoEscolar(FamiliaAdmissaoPedagogica objFamAdmPedago) {
        buscarInterno(objFamAdmPedago.getNomeInternoCrc(), objFamAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FAMILIA_ADMISSAO_PEDAGOGIA (IdAdm,IdInternoCrc,RelacaoPai,RelacaoMae,Irmaos,PaisLerEscrever,PaisSeparados,Religiao,IdadeAndou,IdadeFalou,DificuldadeFala,QualDificuldadeFala,Comunicacao,Relacionamento,Lider,RepetiuAno,PorqueRepetiuAno,ProblemaProfessor,QualProblemaProfessor,ComoAtitudeSala,FaltaEscola,PorqueFaltaEscola,AchaEscola,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objFamAdmPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objFamAdmPedago.getRelacaoPai());
            pst.setString(4, objFamAdmPedago.getRelacaoMae());
            pst.setString(5, objFamAdmPedago.getIrmaos());
            pst.setString(6, objFamAdmPedago.getPaisLerEscrever());
            pst.setString(7, objFamAdmPedago.getPaisSeparados());
            pst.setString(8, objFamAdmPedago.getReligiao());
            pst.setInt(9, objFamAdmPedago.getIdadeAndou());
            pst.setInt(10, objFamAdmPedago.getIdadeFalou());
            pst.setString(11, objFamAdmPedago.getDificuldadeFala());
            pst.setString(12, objFamAdmPedago.getQualDificuldadeFala());
            pst.setString(13, objFamAdmPedago.getComunicacao());
            pst.setString(14, objFamAdmPedago.getRelacionamento());
            pst.setString(15, objFamAdmPedago.getLider());
            pst.setString(16, objFamAdmPedago.getRepetiuAno());
            pst.setString(17, objFamAdmPedago.getPorqueRepetiuAno());
            pst.setString(18, objFamAdmPedago.getProblemaProfessor());
            pst.setString(19, objFamAdmPedago.getQualProblemaProfessor());
            pst.setString(20, objFamAdmPedago.getComoAtitudeSala());
            pst.setString(21, objFamAdmPedago.getFaltaEscola());
            pst.setString(22, objFamAdmPedago.getPorqueFaltaEscola());
            pst.setString(23, objFamAdmPedago.getAchaEscola());
            pst.setString(24, objFamAdmPedago.getUsuarioInsert());
            pst.setString(25, objFamAdmPedago.getDataInsert());
            pst.setString(26, objFamAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFamAdmPedago;
    }

    public FamiliaAdmissaoPedagogica alterarFamiliaAdmissaoEscolar(FamiliaAdmissaoPedagogica objFamAdmPedago) {
        buscarInterno(objFamAdmPedago.getNomeInternoCrc(), objFamAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FAMILIA_ADMISSAO_PEDAGOGIA SET IdAdm=?,IdInternoCrc=?,RelacaoPai=?,RelacaoMae=?,Irmaos=?,PaisLerEscrever=?,PaisSeparados=?,Religiao=?,IdadeAndou=?,IdadeFalou=?,DificuldadeFala=?,QualDificuldadeFala=?,Comunicacao=?,Relacionamento=?,Lider=?,RepetiuAno=?,PorqueRepetiuAno=?,ProblemaProfessor=?,QualProblemaProfessor=?,ComoAtitudeSala=?,FaltaEscola=?,PorqueFaltaEscola=?,AchaEscola=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFam='" + objFamAdmPedago.getIdFam() + "'");
            pst.setInt(1, objFamAdmPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objFamAdmPedago.getRelacaoPai());
            pst.setString(4, objFamAdmPedago.getRelacaoMae());
            pst.setString(5, objFamAdmPedago.getIrmaos());
            pst.setString(6, objFamAdmPedago.getPaisLerEscrever());
            pst.setString(7, objFamAdmPedago.getPaisSeparados());
            pst.setString(8, objFamAdmPedago.getReligiao());
            pst.setInt(9, objFamAdmPedago.getIdadeAndou());
            pst.setInt(10, objFamAdmPedago.getIdadeFalou());
            pst.setString(11, objFamAdmPedago.getDificuldadeFala());
            pst.setString(12, objFamAdmPedago.getQualDificuldadeFala());
            pst.setString(13, objFamAdmPedago.getComunicacao());
            pst.setString(14, objFamAdmPedago.getRelacionamento());
            pst.setString(15, objFamAdmPedago.getLider());
            pst.setString(16, objFamAdmPedago.getRepetiuAno());
            pst.setString(17, objFamAdmPedago.getPorqueRepetiuAno());
            pst.setString(18, objFamAdmPedago.getProblemaProfessor());
            pst.setString(19, objFamAdmPedago.getQualProblemaProfessor());
            pst.setString(20, objFamAdmPedago.getComoAtitudeSala());
            pst.setString(21, objFamAdmPedago.getFaltaEscola());
            pst.setString(22, objFamAdmPedago.getPorqueFaltaEscola());
            pst.setString(23, objFamAdmPedago.getAchaEscola());
            pst.setString(24, objFamAdmPedago.getUsuarioUp());
            pst.setString(25, objFamAdmPedago.getDataUp());
            pst.setString(26, objFamAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFamAdmPedago;
    }

    public FamiliaAdmissaoPedagogica excluirFamiliaAdmissaoEscolar(FamiliaAdmissaoPedagogica objFamAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FAMILIA_ADMISSAO_PEDAGOGIA WHERE IdFam='" + objFamAdmPedago.getIdFam() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objFamAdmPedago;
    }

    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
