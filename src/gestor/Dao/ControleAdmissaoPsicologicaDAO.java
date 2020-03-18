/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.AdmissaoPedagogicaNova;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAdmissaoPsicologicaDAO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoPedagogicaNova objAdmPedago = new AdmissaoPedagogicaNova();
    //
    int idCod = 0;
    int idCodigo = 0;
    int idInterno = 0;
    int idInternoCrc = 0;
    int idCodigoInt = 0;
    String nomeOpeTecnica = "Atendimento do Interno na Pedagogia - (Admissão)";

    public AdmissaoPedagogicaNova incluirAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno0(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADMISSAO_PEDAGOGIA_NOVA (IdAdm,StatusAdm,DataAdm,IdInternoCrc,UltimaEscola,SerieAno,Turno,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setString(2, objAdmPedago.getStatusAdm());
            pst.setTimestamp(3, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setInt(4, idCod);
            pst.setString(5, objAdmPedago.getUltimaEscola());
            pst.setString(6, objAdmPedago.getSerieAno());
            pst.setString(7, objAdmPedago.getTurno());
            pst.setString(8, objAdmPedago.getObservacao());
            pst.setString(9, objAdmPedago.getUsuarioInsert());
            pst.setString(10, objAdmPedago.getDataInsert());
            pst.setString(11, objAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova alterarAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno0(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA_NOVA SET IdAdm=?,StatusAdm=?,DataAdm=?,IdInternoCrc=?,UltimaEscola=?,SerieAno=?,Turno=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAdmNova='" + objAdmPedago.getIdAdm() + "'");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setString(2, objAdmPedago.getStatusAdm());
            pst.setTimestamp(3, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setInt(4, idCod);
            pst.setString(5, objAdmPedago.getUltimaEscola());
            pst.setString(6, objAdmPedago.getSerieAno());
            pst.setString(7, objAdmPedago.getTurno());
            pst.setString(8, objAdmPedago.getObservacao());
            pst.setString(9, objAdmPedago.getUsuarioUp());
            pst.setString(10, objAdmPedago.getDataUp());
            pst.setString(11, objAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova excluirAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADMISSAO_PEDAGOGIA_NOVA WHERE IdAdmNova='" + objAdmPedago.getIdAdm() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova finalizarAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA_NOVA SET StatusAdm=? WHERE IdAdmNova='" + objAdmPedago.getIdAdm() + "'");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR o registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova finalizarMovTec(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET StatusAtend=? "
                    + "WHERE IdAtend='" + objAdmPedago.getIdAdm() + "' "
                    + "AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setString(1, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR na tabela MOVIMENTO TÉCNICO os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    //---------------------------------------- MOVIMENTAÇÃO----------------------------------------------
    public AdmissaoPedagogicaNova incluirMovTec(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno1(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVTECNICO (IdInternoCrc,IdAtend,NomeOpe,DataMov,DeptoMov,StatusAtend) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, idCodigo);
            pst.setInt(2, objAdmPedago.getIdAdm());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setString(5, objAdmPedago.getDeptoPedagogia());
            pst.setString(6, objAdmPedago.getStatusAdm());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova alterarMovTec(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno1(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVTECNICO SET IdInternoCrc=?,IdAtend=?,NomeOpe=?,DataMov=?,DeptoMov=?,StatusAtend=? "
                    + "WHERE IdAtend='" + objAdmPedago.getIdAdm() + "' "
                    + "AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.setInt(1, idCodigo);
            pst.setInt(2, objAdmPedago.getIdAdm());
            pst.setString(3, nomeOpeTecnica);
            pst.setTimestamp(4, new java.sql.Timestamp(objAdmPedago.getDataAdm().getTime()));
            pst.setString(5, objAdmPedago.getDeptoPedagogia());
            pst.setString(6, objAdmPedago.getStatusAdm());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    // Excluir movimento do serviço social 
    public AdmissaoPedagogicaNova excluirMovTec(AdmissaoPedagogicaNova objAdmPedago) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVTECNICO "
                    + "WHERE IdAtend='" + objAdmPedago.getIdAdm() + "' "
                    + "AND NomeOpe='" + nomeOpeTecnica + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    ///------------------------------------------- FAMILIA ---------------------------------------------------
    public AdmissaoPedagogicaNova incluirFamiliaAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno2(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FAMILIA_ADMISSAO_PEDAGOGIA_NOVA (IdAdmNova,IdInternoCrc,RelacaoPai,RelacaoMae,Irmaos,PaisLerEscrever,PaisSeparados,Religiao,IdadeAndou,IdadeFalou,DificuldadeFala,QualDificuldadeFala,Comunicacao,Relacionamento,Lider,RepetiuAno,PorqueRepetiuAno,ProblemaProfessor,QualProblemaProfessor,ComoAtitudeSala,FaltaEscola,PorqueFaltaEscola,AchaEscola,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idInterno);
            pst.setString(3, objAdmPedago.getRelacaoPai());
            pst.setString(4, objAdmPedago.getRelacaoMae());
            pst.setString(5, objAdmPedago.getIrmaos());
            pst.setString(6, objAdmPedago.getPaisLerEscrever());
            pst.setString(7, objAdmPedago.getPaisSeparados());
            pst.setString(8, objAdmPedago.getReligiao());
            pst.setInt(9, objAdmPedago.getIdadeAndou());
            pst.setInt(10, objAdmPedago.getIdadeFalou());
            pst.setString(11, objAdmPedago.getDificuldadeFala());
            pst.setString(12, objAdmPedago.getQualDificuldadeFala());
            pst.setString(13, objAdmPedago.getComunicacao());
            pst.setString(14, objAdmPedago.getRelacionamento());
            pst.setString(15, objAdmPedago.getLider());
            pst.setString(16, objAdmPedago.getRepetiuAno());
            pst.setString(17, objAdmPedago.getPorqueRepetiuAno());
            pst.setString(18, objAdmPedago.getProblemaProfessor());
            pst.setString(19, objAdmPedago.getQualProblemaProfessor());
            pst.setString(20, objAdmPedago.getComoAtitudeSala());
            pst.setString(21, objAdmPedago.getFaltaEscola());
            pst.setString(22, objAdmPedago.getPorqueFaltaEscola());
            pst.setString(23, objAdmPedago.getAchaEscola());
            pst.setString(24, objAdmPedago.getUsuarioInsert());
            pst.setString(25, objAdmPedago.getDataInsert());
            pst.setString(26, objAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova alterarFamiliaAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno2(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FAMILIA_ADMISSAO_PEDAGOGIA_NOVA SET IdAdmNova=?,IdInternoCrc=?,RelacaoPai=?,RelacaoMae=?,Irmaos=?,PaisLerEscrever=?,PaisSeparados=?,Religiao=?,IdadeAndou=?,IdadeFalou=?,DificuldadeFala=?,QualDificuldadeFala=?,Comunicacao=?,Relacionamento=?,Lider=?,RepetiuAno=?,PorqueRepetiuAno=?,ProblemaProfessor=?,QualProblemaProfessor=?,ComoAtitudeSala=?,FaltaEscola=?,PorqueFaltaEscola=?,AchaEscola=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFamNova='" + objAdmPedago.getIdFam() + "'");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idInterno);
            pst.setString(3, objAdmPedago.getRelacaoPai());
            pst.setString(4, objAdmPedago.getRelacaoMae());
            pst.setString(5, objAdmPedago.getIrmaos());
            pst.setString(6, objAdmPedago.getPaisLerEscrever());
            pst.setString(7, objAdmPedago.getPaisSeparados());
            pst.setString(8, objAdmPedago.getReligiao());
            pst.setInt(9, objAdmPedago.getIdadeAndou());
            pst.setInt(10, objAdmPedago.getIdadeFalou());
            pst.setString(11, objAdmPedago.getDificuldadeFala());
            pst.setString(12, objAdmPedago.getQualDificuldadeFala());
            pst.setString(13, objAdmPedago.getComunicacao());
            pst.setString(14, objAdmPedago.getRelacionamento());
            pst.setString(15, objAdmPedago.getLider());
            pst.setString(16, objAdmPedago.getRepetiuAno());
            pst.setString(17, objAdmPedago.getPorqueRepetiuAno());
            pst.setString(18, objAdmPedago.getProblemaProfessor());
            pst.setString(19, objAdmPedago.getQualProblemaProfessor());
            pst.setString(20, objAdmPedago.getComoAtitudeSala());
            pst.setString(21, objAdmPedago.getFaltaEscola());
            pst.setString(22, objAdmPedago.getPorqueFaltaEscola());
            pst.setString(23, objAdmPedago.getAchaEscola());
            pst.setString(24, objAdmPedago.getUsuarioUp());
            pst.setString(25, objAdmPedago.getDataUp());
            pst.setString(26, objAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova excluirFamiliaAdmissaoEscolar(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FAMILIA_ADMISSAO_PEDAGOGIA_NOVA WHERE IdFamNova='" + objAdmPedago.getIdFam() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    //----------------------------------------- SOCIALIZAÇÃO -------------------------------------------------
    public AdmissaoPedagogicaNova incluirAdmissaoSocializaEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno3(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA (IdAdmNova,IdInternoCrc,AmigosFacilidade,Introvertido,Afetuoso,Obediente,Resistente,Cooperador,Medroso,Inseguro,Outros,QualOutros,IdadeEscolar,FamiliarPresente,Adaptacao,Repetencias,Antecedentes,QualProblemaAprendizado,ObservacaoSocializacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idInternoCrc);
            pst.setString(3, objAdmPedago.getAmigosFacilidade());
            pst.setInt(4, objAdmPedago.getIntrovertido());
            pst.setInt(5, objAdmPedago.getAfetuoso());
            pst.setInt(6, objAdmPedago.getObediente());
            pst.setInt(7, objAdmPedago.getResistente());
            pst.setInt(8, objAdmPedago.getCooperador());
            pst.setInt(9, objAdmPedago.getMedroso());
            pst.setInt(10, objAdmPedago.getInseguro());
            pst.setInt(11, objAdmPedago.getOutros());
            pst.setString(12, objAdmPedago.getQualOutros());
            pst.setInt(13, objAdmPedago.getIdadeEscolar());
            pst.setString(14, objAdmPedago.getFamiliarPresente());
            pst.setString(15, objAdmPedago.getAdaptacao());
            pst.setString(16, objAdmPedago.getRepetencias());
            pst.setString(17, objAdmPedago.getAntecedentes());
            pst.setString(18, objAdmPedago.getQualProblemaAprendizado());
            pst.setString(19, objAdmPedago.getObservacaoSocializacao());
            pst.setString(20, objAdmPedago.getUsuarioInsert());
            pst.setString(21, objAdmPedago.getDataInsert());
            pst.setString(22, objAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova alterarAdmissaoSocializaEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno3(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA SET IdAdmNova=?,IdInternoCrc=?,AmigosFacilidade=?,Introvertido=?,Afetuoso=?,Obediente=?,Resistente=?,Cooperador=?,Medroso=?,Inseguro=?,Outros=?,QualOutros=?,IdadeEscolar=?,FamiliarPresente=?,Adaptacao=?,Repetencias=?,Antecedentes=?,QualProblemaAprendizado=?,ObservacaoSocializacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdSocialNova='" + objAdmPedago.getIdSocial() + "'");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idInternoCrc);
            pst.setString(3, objAdmPedago.getAmigosFacilidade());
            pst.setInt(4, objAdmPedago.getIntrovertido());
            pst.setInt(5, objAdmPedago.getAfetuoso());
            pst.setInt(6, objAdmPedago.getObediente());
            pst.setInt(7, objAdmPedago.getResistente());
            pst.setInt(8, objAdmPedago.getCooperador());
            pst.setInt(9, objAdmPedago.getMedroso());
            pst.setInt(10, objAdmPedago.getInseguro());
            pst.setInt(11, objAdmPedago.getOutros());
            pst.setString(12, objAdmPedago.getQualOutros());
            pst.setInt(13, objAdmPedago.getIdadeEscolar());
            pst.setString(14, objAdmPedago.getFamiliarPresente());
            pst.setString(15, objAdmPedago.getAdaptacao());
            pst.setString(16, objAdmPedago.getRepetencias());
            pst.setString(17, objAdmPedago.getAntecedentes());
            pst.setString(18, objAdmPedago.getQualProblemaAprendizado());
            pst.setString(19, objAdmPedago.getObservacaoSocializacao());
            pst.setString(20, objAdmPedago.getUsuarioUp());
            pst.setString(21, objAdmPedago.getDataUp());
            pst.setString(22, objAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova excluirAdmissaoSocializaEscolar(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA WHERE IdSocialNova='" + objAdmPedago.getIdSocial() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    //-------------------------------------------------- ABA FEMININA -----------------------------------------------
    public AdmissaoPedagogicaNova incluirAdmissaoFemininoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno4(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FEMININO_ADMISSAO_PEDAGOGIA_NOVA (IdAdmNova,IdInternoCrc,FilhoDesejado,QueriaEngravidar,FoiAcidental,Perturbou,ComoFoiGestacao,ComoFoiParto,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idCodigoInt);
            pst.setString(3, objAdmPedago.getFilhoDesejado());
            pst.setString(4, objAdmPedago.getQueriaEngravidar());
            pst.setString(5, objAdmPedago.getFoiAcidental());
            pst.setString(6, objAdmPedago.getPerturbou());
            pst.setString(7, objAdmPedago.getComoFoiGestacao());
            pst.setString(8, objAdmPedago.getComoFoiParto());
            pst.setString(9, objAdmPedago.getUsuarioInsert());
            pst.setString(10, objAdmPedago.getDataInsert());
            pst.setString(11, objAdmPedago.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova alterarAdmissaoFemininoEscolar(AdmissaoPedagogicaNova objAdmPedago) {
        buscarInterno4(objAdmPedago.getNomeInternoCrc(), objAdmPedago.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FEMININO_ADMISSAO_PEDAGOGIA_NOVA SET IdAdmNova=?,IdInternoCrc=?,FilhoDesejado=?,QueriaEngravidar=?,FoiAcidental=?,Perturbou=?,ComoFoiGestacao=?,ComoFoiParto=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdFemAdmNova='" + objAdmPedago.getIdFemAdm() + "'");
            pst.setInt(1, objAdmPedago.getIdAdm());
            pst.setInt(2, idCodigoInt);
            pst.setString(3, objAdmPedago.getFilhoDesejado());
            pst.setString(4, objAdmPedago.getQueriaEngravidar());
            pst.setString(5, objAdmPedago.getFoiAcidental());
            pst.setString(6, objAdmPedago.getPerturbou());
            pst.setString(7, objAdmPedago.getComoFoiGestacao());
            pst.setString(8, objAdmPedago.getComoFoiParto());
            pst.setString(9, objAdmPedago.getUsuarioUp());
            pst.setString(10, objAdmPedago.getDataUp());
            pst.setString(11, objAdmPedago.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    public AdmissaoPedagogicaNova excluirAdmissaoFemininoEscolar(AdmissaoPedagogicaNova objAdmPedago) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FEMININO_ADMISSAO_PEDAGOGIA_NOVA WHERE IdFemAdm='" + objAdmPedago.getIdFemAdm() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdmPedago;
    }

    //------------------------------------- PESQUISA DO INTERNO ----------------------------------------------
    public void buscarInterno0(String nome0, int codigo0) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome0 + "' "
                    + "AND IdInternoCrc='" + codigo0 + "'");
            conecta.rs.first();
            idCod = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS - B0) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno1(String nome1, int codigo1) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome1 + "' "
                    + "AND IdInternoCrc='" + codigo1 + "'");
            conecta.rs.first();
            idCodigo = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS - B1) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno2(String nome2, int codigo2) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome2 + "' "
                    + "AND IdInternoCrc='" + codigo2 + "'");
            conecta.rs.first();
            idInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS - B2) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno3(String nome3, int codigo3) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome3 + "' "
                    + "AND IdInternoCrc='" + codigo3 + "'");
            conecta.rs.first();
            idInternoCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS - B3) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno4(String nome4, int codigo4) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome4 + "' "
                    + "AND IdInternoCrc='" + codigo4 + "'");
            conecta.rs.first();
            idCodigoInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PRONTUARIOS - B4) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
