/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FamiliaAdmissaoPedagogica;
import gestor.Modelo.SocializacaoAdmPedagogica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleSocializacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SocializacaoAdmPedagogica objSociaAdmPedago = new SocializacaoAdmPedagogica();

    int idCod;

    public SocializacaoAdmPedagogica incluirAdmissaoSocializaEscolar(SocializacaoAdmPedagogica objSociaAdmPedago) {
        buscarInterno(objSociaAdmPedago.getNomeInternoCrc(), objSociaAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOCIALIZACAO_ADMISSAO_PEDAGOGIA (IdAdm,IdInternoCrc,AmigosFacilidade,Introvertido,Afetuoso,Obediente,Resistente,Cooperador,Medroso,Inseguro,Outros,QualOutros,IdadeEscolar,FamiliarPresente,Adaptacao,Repetencias,Antecedentes,QualProblemaAprendizado,ObservacaoSocializacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSociaAdmPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objSociaAdmPedago.getAmigosFacilidade());
            pst.setInt(4, objSociaAdmPedago.getIntrovertido());
            pst.setInt(5, objSociaAdmPedago.getAfetuoso());
            pst.setInt(6, objSociaAdmPedago.getObediente());
            pst.setInt(7, objSociaAdmPedago.getResistente());
            pst.setInt(8, objSociaAdmPedago.getCooperador());
            pst.setInt(9, objSociaAdmPedago.getMedroso());
            pst.setInt(10, objSociaAdmPedago.getInseguro());
            pst.setInt(11, objSociaAdmPedago.getOutros());
            pst.setString(12, objSociaAdmPedago.getQualOutros());
            pst.setInt(13, objSociaAdmPedago.getIdadeEscolar());
            pst.setString(14, objSociaAdmPedago.getFamiliarPresente());
            pst.setString(15, objSociaAdmPedago.getAdaptacao());
            pst.setString(16, objSociaAdmPedago.getRepetencias());
            pst.setString(17, objSociaAdmPedago.getAntecedentes());
            pst.setString(18, objSociaAdmPedago.getQualProblemaAprendizado());
            pst.setString(19, objSociaAdmPedago.getObservacaoSocializacao());
            pst.setString(20, objSociaAdmPedago.getUsuarioInsert());
            pst.setString(21, objSociaAdmPedago.getDataInsert());
            pst.setString(22, objSociaAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSociaAdmPedago;
    }

    public SocializacaoAdmPedagogica alterarAdmissaoSocializaEscolar(SocializacaoAdmPedagogica objSociaAdmPedago) {
        buscarInterno(objSociaAdmPedago.getNomeInternoCrc(), objSociaAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOCIALIZACAO_ADMISSAO_PEDAGOGIA SET IdAdm=?,IdInternoCrc=?,AmigosFacilidade=?,Introvertido=?,Afetuoso=?,Obediente=?,Resistente=?,Cooperador=?,Medroso=?,Inseguro=?,Outros=?,QualOutros=?,IdadeEscolar=?,FamiliarPresente=?,Adaptacao=?,Repetencias=?,Antecedentes=?,QualProblemaAprendizado=?,ObservacaoSocializacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSocial='" + objSociaAdmPedago.getIdSocial() + "'");
            pst.setInt(1, objSociaAdmPedago.getIdAdm());
            pst.setInt(2, idCod);
            pst.setString(3, objSociaAdmPedago.getAmigosFacilidade());
            pst.setInt(4, objSociaAdmPedago.getIntrovertido());
            pst.setInt(5, objSociaAdmPedago.getAfetuoso());
            pst.setInt(6, objSociaAdmPedago.getObediente());
            pst.setInt(7, objSociaAdmPedago.getResistente());
            pst.setInt(8, objSociaAdmPedago.getCooperador());
            pst.setInt(9, objSociaAdmPedago.getMedroso());
            pst.setInt(10, objSociaAdmPedago.getInseguro());
            pst.setInt(11, objSociaAdmPedago.getOutros());
            pst.setString(12, objSociaAdmPedago.getQualOutros());
            pst.setInt(13, objSociaAdmPedago.getIdadeEscolar());
            pst.setString(14, objSociaAdmPedago.getFamiliarPresente());
            pst.setString(15, objSociaAdmPedago.getAdaptacao());
            pst.setString(16, objSociaAdmPedago.getRepetencias());
            pst.setString(17, objSociaAdmPedago.getAntecedentes());
            pst.setString(18, objSociaAdmPedago.getQualProblemaAprendizado());
            pst.setString(19, objSociaAdmPedago.getObservacaoSocializacao());
            pst.setString(20, objSociaAdmPedago.getUsuarioUp());
            pst.setString(21, objSociaAdmPedago.getDataUp());
            pst.setString(22, objSociaAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSociaAdmPedago;
    }

    public SocializacaoAdmPedagogica excluirAdmissaoSocializaEscolar(SocializacaoAdmPedagogica objSociaAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA WHERE IdSocial='" + objSociaAdmPedago.getIdSocial() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSociaAdmPedago;
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
