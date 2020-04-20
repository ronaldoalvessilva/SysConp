/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleAtividadesUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    //ABA MANUTENÇÃO
    public AtividadesMensalRealizadaUnidades incluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE (StatusAtividade,"
                    + "DataCriacao,DataAtualizacao,IdUnidEmp,Populacao,MesReferencia,AnoReferencia,IdFunc,"
                    + "Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=?,"
                    + "DataCriacao=?,DataAtualizacao=?,IdUnidEmp=?,Populacao=?,MesReferencia=?,AnoReferencia=?,IdFunc=?,"
                    + "Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtividade.getDataCriacao().getTime()));
            if (objAtividade.getDataAtualizacao() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtividade.getDataAtualizacao().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setInt(4, objAtividade.getIdUnidade());
            pst.setInt(5, objAtividade.getMediaPopulacao());
            pst.setString(6, objAtividade.getMesReferencia());
            pst.setString(7, objAtividade.getAnoReferencia());
            pst.setInt(9, objAtividade.getIdFunc());
            pst.setString(9, objAtividade.getObservacao());
            pst.setString(10, objAtividade.getUsuarioInsert());
            pst.setString(11, objAtividade.getDataInsert());
            pst.setString(12, objAtividade.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades finalizarAtividade(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setString(1, objAtividade.getStatus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //ABA ASSI
    public AtividadesMensalRealizadaUnidades incluirASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_SERVICO_SOCIAL (IdAtividade,"
                    + "AtendimentoPsicossocialPreso,AtendimentoPsicossocialFamiliaPreso,IdentificadoCivilmente,"
                    + "TotalServicoSocial) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getAtendimentoPsiPreso());
            pst.setInt(3, objAtividade.getAtendimentoPsiFamilaPreso());
            pst.setInt(4, objAtividade.getPresoIdentCivil());
            pst.setInt(5, objAtividade.getTotal01());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_SERVICO_SOCIAL SET AtendimentoPsicossocialPreso=?,"
                    + "AtendimentoPsicossocialFamiliaPreso=?,IdentificadoCivilmente=?,TotalServicoSocial=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getAtendimentoPsiPreso());
            pst.setInt(2, objAtividade.getAtendimentoPsiFamilaPreso());
            pst.setInt(3, objAtividade.getPresoIdentCivil());
            pst.setInt(4, objAtividade.getTotal01());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirASSI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_SERVICO_SOCIAL WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_SERVICO_SOCIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AFV/AFI
    public AtividadesMensalRealizadaUnidades incluirAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA (IdAtividade,"
                    + "LanchesVisitantes,CafeContratada,AlmocoContratada,JantarContratada,LancheContratada,CafeContratante,"
                    + "AlmocoContratante,JantarContratante,LancheContratante,TotalAlimentacao) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getLanchesVisitantes());
            pst.setInt(3, objAtividade.getCafeContratada());
            pst.setInt(4, objAtividade.getAlmocoContratada());
            pst.setInt(5, objAtividade.getJantarContratada());
            pst.setInt(6, objAtividade.getLancheContratada());
            pst.setInt(7, objAtividade.getCafeContratante());
            pst.setInt(8, objAtividade.getAlmocoContratante());
            pst.setInt(9, objAtividade.getJantarContratante());
            pst.setInt(10, objAtividade.getLancheContratante());
            pst.setInt(11, objAtividade.getTotal02());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA SET LanchesVisitantes=?,"
                    + "CafeContratada=?,AlmocoContratada=?,JantarContratada=?,LancheContratada=?,CafeContratante=?,"
                    + "AlmocoContratante=?,JantarContratante=?,LancheContratante=?,TotalAlimentacao=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getLanchesVisitantes());
            pst.setInt(2, objAtividade.getCafeContratada());
            pst.setInt(3, objAtividade.getAlmocoContratada());
            pst.setInt(4, objAtividade.getJantarContratada());
            pst.setInt(5, objAtividade.getLancheContratada());
            pst.setInt(6, objAtividade.getCafeContratante());
            pst.setInt(7, objAtividade.getAlmocoContratante());
            pst.setInt(8, objAtividade.getJantarContratante());
            pst.setInt(9, objAtividade.getLancheContratante());
            pst.setInt(10, objAtividade.getTotal02());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAFV_AFI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //ASI
    public AtividadesMensalRealizadaUnidades incluirASI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE (IdAtividade,"
                    + "AtendimentoClinico,AtendimentoPsiquiatrico,AtendimentoEnfermagem,ProcedimentoOdontologico,AtendimentoPsicologico,TratamentoAgravosPNAISP,"
                    + "SensibilizadoSaudeBucal,SensibilizadoInfectocontagiosas,SensibilizadoHipertensao,SensibilizadoDiabetes,SensibilizadoSexualidade,"
                    + "VacinadosPNI,TotalSaude) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getAtendimentoClinico());
            pst.setInt(3, objAtividade.getAtendimentoPsiquiatrico());
            pst.setInt(4, objAtividade.getAtendimentoEnfermagem());
            pst.setInt(5, objAtividade.getProcedimentoOdontologico());
            pst.setInt(6, objAtividade.getAtendimentoPsicologico());
            pst.setInt(7, objAtividade.getTratamentoAgravosPNAISP());
            pst.setInt(8, objAtividade.getSensibilizadoSaudeBucal());
            pst.setInt(9, objAtividade.getSensibilizadoInfectocontagiosas());
            pst.setInt(10, objAtividade.getSensibilizadoHipertensao());
            pst.setInt(11, objAtividade.getSensibilizadoDiabetes());
            pst.setInt(12, objAtividade.getSensibilizadoSexualidade());
            pst.setInt(13, objAtividade.getVacinadosPNI());
            pst.setInt(11, objAtividade.getTotal03());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarASI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE SET AtendimentoClinico=?,"
                    + "AtendimentoPsiquiatrico=?,AtendimentoEnfermagem=?,ProcedimentoOdontologico=?,AtendimentoPsicologico=?,TratamentoAgravosPNAISP=?,"
                    + "SensibilizadoSaudeBucal=?,SensibilizadoInfectocontagiosas=?,SensibilizadoHipertensao=?,SensibilizadoDiabetes=?,SensibilizadoSexualidade=?,"
                    + "VacinadosPNI=?,TotalSaude=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getAtendimentoClinico());
            pst.setInt(2, objAtividade.getAtendimentoPsiquiatrico());
            pst.setInt(3, objAtividade.getAtendimentoEnfermagem());
            pst.setInt(4, objAtividade.getProcedimentoOdontologico());
            pst.setInt(5, objAtividade.getAtendimentoPsicologico());
            pst.setInt(6, objAtividade.getTratamentoAgravosPNAISP());
            pst.setInt(7, objAtividade.getSensibilizadoSaudeBucal());
            pst.setInt(8, objAtividade.getSensibilizadoInfectocontagiosas());
            pst.setInt(9, objAtividade.getSensibilizadoHipertensao());
            pst.setInt(10, objAtividade.getSensibilizadoDiabetes());
            pst.setInt(11, objAtividade.getSensibilizadoSexualidade());
            pst.setInt(12, objAtividade.getVacinadosPNI());
            pst.setInt(13, objAtividade.getTotal03());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirASI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AEI
    public AtividadesMensalRealizadaUnidades incluirAEI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL (IdAtividade,"
                    + "MatriculadoEnsinoFormal,FrequentandoEnsinoFormal,MatriculadoCursoProfissionalizante,CertificadoCursoProfissionalizante,"
                    + "TotalEducacional) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getMatriculadoEnsinoFormal());
            pst.setInt(3, objAtividade.getFrequentandoEnsinoFormal());
            pst.setInt(4, objAtividade.getMatriculadoCursoProfissionalizante());
            pst.setInt(5, objAtividade.getCertificadoCursoProfissionalizante());
            pst.setInt(6, objAtividade.getTotal04());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAEI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL SET MatriculadoEnsinoFormal=?,"
                    + "MatriculadoEnsinoFormal=?,FrequentandoEnsinoFormal=?,MatriculadoCursoProfissionalizante=?,CertificadoCursoProfissionalizante=?,"
                    + "TotalEducacional=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getMatriculadoEnsinoFormal());
            pst.setInt(2, objAtividade.getFrequentandoEnsinoFormal());
            pst.setInt(3, objAtividade.getMatriculadoCursoProfissionalizante());
            pst.setInt(4, objAtividade.getCertificadoCursoProfissionalizante());
            pst.setInt(5, objAtividade.getTotal04());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAEI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AMI
    public AtividadesMensalRealizadaUnidades incluirAMI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL (IdAtividade,"
                    + "Cobertor,Colchao,Lencol,Toalha,Pote,Caneca,AparelhoBarbear,CremeDental,EscovaDente,Absorvente,PapelHigienico,"
                    + "SabaoPo,Sabonete,Desodorante,Bermuda,CamisaCamiseta,Cueca,Chinelo,UniformeEsportivo,"
                    + "TotalMaterial) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getCobertor());
            pst.setInt(3, objAtividade.getColchao());
            pst.setInt(4, objAtividade.getLencol());
            pst.setInt(5, objAtividade.getToalha());
            pst.setInt(6, objAtividade.getPote());
            pst.setInt(7, objAtividade.getCaneca());
            pst.setInt(8, objAtividade.getAparelhoBarbear());
            pst.setInt(9, objAtividade.getCremeDental());
            pst.setInt(10, objAtividade.getEscova());
            pst.setInt(11, objAtividade.getAbsorvente());
            pst.setInt(12, objAtividade.getPapelHigienico());
            pst.setInt(13, objAtividade.getSabaoPo());
            pst.setInt(14, objAtividade.getSabonete());
            pst.setInt(15, objAtividade.getDesodorante());
            pst.setInt(16, objAtividade.getBermuda());
            pst.setInt(17, objAtividade.getCamisa());
            pst.setInt(18, objAtividade.getCueca());
            pst.setInt(19, objAtividade.getParChinelos());
            pst.setInt(20, objAtividade.getUniformeCompleto());
            pst.setInt(21, objAtividade.getTotal05());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAMI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL SET MatriculadoEnsinoFormal=?,"
                    + "Cobertor=?,Colchao=?,Lencol=?,Toalha=?,Pote=?,Caneca=?,AparelhoBarbear=?,CremeDental=?,EscovaDente=?,Absorvente=?,PapelHigienico=?,"
                    + "SabaoPo=?,Sabonete=?,Desodorante=?,Bermud=?a,CamisaCamiseta=?,Cueca=?,Chinelo=?,UniformeEsportivo=?,"
                    + "TotalMaterial=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getCobertor());
            pst.setInt(2, objAtividade.getColchao());
            pst.setInt(3, objAtividade.getLencol());
            pst.setInt(4, objAtividade.getToalha());
            pst.setInt(5, objAtividade.getPote());
            pst.setInt(6, objAtividade.getCaneca());
            pst.setInt(7, objAtividade.getAparelhoBarbear());
            pst.setInt(8, objAtividade.getCremeDental());
            pst.setInt(9, objAtividade.getEscova());
            pst.setInt(10, objAtividade.getAbsorvente());
            pst.setInt(11, objAtividade.getPapelHigienico());
            pst.setInt(12, objAtividade.getSabaoPo());
            pst.setInt(13, objAtividade.getSabonete());
            pst.setInt(14, objAtividade.getDesodorante());
            pst.setInt(15, objAtividade.getBermuda());
            pst.setInt(16, objAtividade.getCamisa());
            pst.setInt(17, objAtividade.getCueca());
            pst.setInt(18, objAtividade.getParChinelos());
            pst.setInt(19, objAtividade.getUniformeCompleto());
            pst.setInt(20, objAtividade.getTotal05());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAMI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //SEG
    public AtividadesMensalRealizadaUnidades incluirSEG(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_SEGURANCA (IdAtividade,"
                    + "CelularLocalizadoConvivencia,ObjetoNaoAutorizadoLocalizadoConvivencia,RevistaCela,TentativaFuga,"
                    + "OcorrenciaFuga,OcorrenciaRebeliao,OcorrenciaFerido,OcorrenciaIndisciplina,OcorrenciaRefem,OcorrenciaGravementeFeridoMorto,"
                    + "HorasInterrupcaoCFTV,DiasInterrupcaoScannerCorporal,DiasInterrupcaoRaioXDetectorMetais,DiasInterrupcaoVeiculoTransportePreso,"
                    + "FalhaGeradorEnergia,HorasMauFuncionamentoBRS,AbsorventesEntreguesPortariaScanner,FraldasEntreguesPortariaScanner) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getCelularLocalizadoConvivencia());
            pst.setInt(3, objAtividade.getObjetoNaoAutorizadoLocalizadoConvivencia());
            pst.setInt(4, objAtividade.getRevistaCela());
            pst.setInt(5, objAtividade.getTentativaFuga());
            pst.setInt(6, objAtividade.getOcorrenciaFuga());
            pst.setInt(7, objAtividade.getOcorrenciaRebeliao());
            pst.setInt(8, objAtividade.getOcorrenciaFerido());
            pst.setInt(9, objAtividade.getOcorrenciaIndisciplina());
            pst.setInt(10, objAtividade.getOcorrenciaRefem());
            pst.setInt(11, objAtividade.getOcorrenciaGravementeFeridoMorto());
            pst.setInt(12, objAtividade.getHorasInterrupcaoCFTV());
            pst.setInt(13, objAtividade.getDiasInterrupcaoScannerCorporal());
            pst.setInt(14, objAtividade.getDiasInterrupcaoRaioXDetectorMetais());
            pst.setInt(15, objAtividade.getDiasInterrupcaoVeiculoTransportePreso());
            pst.setInt(16, objAtividade.getFalhaGeradorEnergia());
            pst.setInt(17, objAtividade.getHorasMauFuncionamentoBRS());
            pst.setInt(18, objAtividade.getAbsorventesEntreguesPortariaScanner());
            pst.setInt(19, objAtividade.getFraldasEntreguesPortariaScanner());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_SEGURANCA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarSEG(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_SEGURANCA SET CelularLocalizadoConvivencia=?,"
                    + "OcorrenciaFuga=?,OcorrenciaRebeliao=?,OcorrenciaFerido=?,ObjetoNaoAutorizadoLocalizadoConvivencia=?,RevistaCela=?,TentativaFuga=?,"
                    + "OcorrenciaIndisciplina=?,OcorrenciaRefem=?,OcorrenciaGravementeFeridoMorto=?,HorasInterrupcaoCFTV=?,DiasInterrupcaoScannerCorporal=?,"
                    + "DiasInterrupcaoRaioXDetectorMetais=?,DiasInterrupcaoVeiculoTransportePreso=?,FalhaGeradorEnergia=?,HorasMauFuncionamentoBRS=?,"
                    + "AbsorventesEntreguesPortariaScanner=?,FraldasEntreguesPortariaScanner=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getCelularLocalizadoConvivencia());
            pst.setInt(2, objAtividade.getObjetoNaoAutorizadoLocalizadoConvivencia());
            pst.setInt(3, objAtividade.getRevistaCela());
            pst.setInt(4, objAtividade.getTentativaFuga());
            pst.setInt(5, objAtividade.getOcorrenciaFuga());
            pst.setInt(6, objAtividade.getOcorrenciaRebeliao());
            pst.setInt(7, objAtividade.getOcorrenciaFerido());
            pst.setInt(8, objAtividade.getOcorrenciaIndisciplina());
            pst.setInt(9, objAtividade.getOcorrenciaRefem());
            pst.setInt(10, objAtividade.getOcorrenciaGravementeFeridoMorto());
            pst.setInt(11, objAtividade.getHorasInterrupcaoCFTV());
            pst.setInt(12, objAtividade.getDiasInterrupcaoScannerCorporal());
            pst.setInt(13, objAtividade.getDiasInterrupcaoRaioXDetectorMetais());
            pst.setInt(14, objAtividade.getDiasInterrupcaoVeiculoTransportePreso());
            pst.setInt(15, objAtividade.getFalhaGeradorEnergia());
            pst.setInt(16, objAtividade.getHorasMauFuncionamentoBRS());
            pst.setInt(17, objAtividade.getAbsorventesEntreguesPortariaScanner());
            pst.setInt(18, objAtividade.getFraldasEntreguesPortariaScanner());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_SEGURANCA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirSEG(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_SEGURANCA WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_SEGURANCA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AJ
    public AtividadesMensalRealizadaUnidades incluirAJ(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_JURIDICA (IdAtividade,"
                    + "InternoFamiliaSAJ,AlvaraSolturaRecebido,AlvaraSolturaCumprido,LivramentoCondicionalRequerido,AudienciaProvocada,AudienciaCumprida,"
                    + "JuriProvocado,JuriCumprido,LiberdadeProvisoriaRequerida,LiberdadeProvisoriaDeferida,IndultosRequeridos,"
                    + "IndultosDeferidos,RemicaoRequerida,RemicaoDeferida,CondicionalRequerida,CondicionalDeferida,"
                    + "ProgressaoRegimeRequerida,ProgressaoRegimeDeferida,SaidasTemporariasRequerida,SaidasTemporariasDeferida,"
                    + "HabeasCorpusRequerido,HabeasCorpusDeferido,LaudosPsicologicos,LaudosPsiquiatricos,"
                    + "TransferenciaProvimento,TotalJuridico) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getInternoFamiliaSAJ());
            pst.setInt(3, objAtividade.getAlvaraSolturaRecebido());
            pst.setInt(4, objAtividade.getAlvaraSolturaCumprido());
            pst.setInt(5, objAtividade.getAudienciaProvocada());
            pst.setInt(6, objAtividade.getAudienciaCumprida());
            pst.setInt(7,objAtividade.getLivramentoCondicionalRequerido());
            pst.setInt(8, objAtividade.getJuriProvocado());
            pst.setInt(9, objAtividade.getJuriCumprido());
            pst.setInt(10, objAtividade.getLiberdadeProvisoriaRequerida());
            pst.setInt(11, objAtividade.getLiberdadeProvisoriaDeferida());
            pst.setInt(12, objAtividade.getIndultosRequeridos());
            pst.setInt(13, objAtividade.getIndultosDeferidos());
            pst.setInt(14, objAtividade.getRemicaoRequerida());
            pst.setInt(15, objAtividade.getRemicaoDeferida());
            pst.setInt(16, objAtividade.getCondicionalRequerida());
            pst.setInt(17, objAtividade.getCondicionalDeferida());
            pst.setInt(18, objAtividade.getProgressaoRegimeRequerida());
            pst.setInt(19, objAtividade.getProgressaoRegimeDeferida());
            pst.setInt(20, objAtividade.getSaidasTemporariasRequerida());
            pst.setInt(21, objAtividade.getSaidasTemporariasDeferida());
            pst.setInt(22, objAtividade.getHabeasCorpusRequerido());
            pst.setInt(23, objAtividade.getHabeasCorpusDeferido());
            pst.setInt(24, objAtividade.getLaudosPsicologicos());
            pst.setInt(25, objAtividade.getLaudosPsiquiatricos());
            pst.setInt(26, objAtividade.getTransferenciaProvimento());
            pst.setInt(27, objAtividade.getTotal07());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_JURIDICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAJ(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_JURIDICA SET InternoFamiliaSAJ=?,"
                    + "AlvaraSolturaRecebido=?,AlvaraSolturaCumprido=?,LivramentoCondicionalRequerido=?,AudienciaProvocada=?,AudienciaCumprida=?,"
                    + "JuriProvocado=?,JuriCumprido=?,LiberdadeProvisoriaRequerida=?,LiberdadeProvisoriaDeferida=?,IndultosRequeridos=?,"
                    + "IndultosDeferidos=?,RemicaoRequerida=?,RemicaoDeferida=?,CondicionalRequerida=?,CondicionalDeferida=?,"
                    + "ProgressaoRegimeRequerida=?,ProgressaoRegimeDeferida=?,SaidasTemporariasRequerida=?,SaidasTemporariasDeferida=?,"
                    + "HabeasCorpusRequerido=?,HabeasCorpusDeferido=?,LaudosPsicologicos=?,LaudosPsiquiatricos=?,"
                    + "TransferenciaProvimento=?,TotalJuridico=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getInternoFamiliaSAJ());
            pst.setInt(2, objAtividade.getAlvaraSolturaRecebido());
            pst.setInt(3, objAtividade.getAlvaraSolturaCumprido());
            pst.setInt(4, objAtividade.getAudienciaProvocada());
            pst.setInt(5, objAtividade.getAudienciaCumprida());
            pst.setInt(6,objAtividade.getLivramentoCondicionalRequerido());
            pst.setInt(7, objAtividade.getJuriProvocado());
            pst.setInt(8, objAtividade.getJuriCumprido());
            pst.setInt(9, objAtividade.getLiberdadeProvisoriaRequerida());
            pst.setInt(10, objAtividade.getLiberdadeProvisoriaDeferida());
            pst.setInt(11, objAtividade.getIndultosRequeridos());
            pst.setInt(12, objAtividade.getIndultosDeferidos());
            pst.setInt(13, objAtividade.getRemicaoRequerida());
            pst.setInt(14, objAtividade.getRemicaoDeferida());
            pst.setInt(15, objAtividade.getCondicionalRequerida());
            pst.setInt(16, objAtividade.getCondicionalDeferida());
            pst.setInt(17, objAtividade.getProgressaoRegimeRequerida());
            pst.setInt(18, objAtividade.getProgressaoRegimeDeferida());
            pst.setInt(19, objAtividade.getSaidasTemporariasRequerida());
            pst.setInt(20, objAtividade.getSaidasTemporariasDeferida());
            pst.setInt(21, objAtividade.getHabeasCorpusRequerido());
            pst.setInt(22, objAtividade.getHabeasCorpusDeferido());
            pst.setInt(23, objAtividade.getLaudosPsicologicos());
            pst.setInt(24, objAtividade.getLaudosPsiquiatricos());
            pst.setInt(25, objAtividade.getTransferenciaProvimento());
            pst.setInt(26, objAtividade.getTotal07());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_JURIDICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAJ(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_JURIDICA WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_JURIDICA) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AL
    public AtividadesMensalRealizadaUnidades incluirAL(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL (IdAtividade,"
                    + "Triagem,LaborativaRemunerada,LaborativaNaoRemunerada,"
                    + "TotalLaboral) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getTriagem());
            pst.setInt(3, objAtividade.getLaborativaRemunerada());
            pst.setInt(4, objAtividade.getLaborativaNaoRemunerada());
            pst.setInt(5, objAtividade.getTotal08());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAL(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL SET Triagem=?,"
                    + "LaborativaRemunerada=?,LaborativaNaoRemunerada=?,TotalLaboral=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getTriagem());
            pst.setInt(2, objAtividade.getLaborativaRemunerada());
            pst.setInt(3, objAtividade.getLaborativaNaoRemunerada());
            pst.setInt(4, objAtividade.getTotal08());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAL(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    //AFI
    public AtividadesMensalRealizadaUnidades incluirAF(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO (IdAtividade,"
                    + "CafeInterno,AlmocoInterno,JantarInterno,"
                    + "TotalAlimentacaoInterno) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getCafeInterno());
            pst.setInt(3, objAtividade.getAlmocoInterno());
            pst.setInt(4, objAtividade.getJantarInterno());
            pst.setInt(5, objAtividade.getTotal09());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAF(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO SET Triagem=?,"
                    + "LaborativaRemunerada=?,LaborativaNaoRemunerada=?,TotalLaboral=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getTriagem());
            pst.setInt(2, objAtividade.getLaborativaRemunerada());
            pst.setInt(3, objAtividade.getLaborativaNaoRemunerada());
            pst.setInt(4, objAtividade.getTotal09());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAF(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }
    
    //ATIVIDADES VISITAS INTERNOS
    public AtividadesMensalRealizadaUnidades incluirAVI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATIVIDADES_UNIDADE_VISITA_INTERNO (IdAtividade,"
                    + "NroDiasVisita,NroVisitantes,MediaVisitantesDia,MediaVisitantesInterno,"
                    + "NroCriancasVisitantes) VALUES(?,?,?,?,?)");
            pst.setInt(1, objAtividade.getChave());
            pst.setInt(2, objAtividade.getNumeroDiasVisitas());
            pst.setInt(3, objAtividade.getNumeroVistantesInternos());
            pst.setInt(4, objAtividade.getMediaVisitasDia());
            pst.setInt(5, objAtividade.getMediaVisitasInterno());
            pst.setInt(6, objAtividade.getNumeroCriancasVisitas());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR (ATIVIDADES_UNIDADE_VISITA_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades alterarAVI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE_VISITA_INTERNO SET NroDiasVisita=?,"
                    + "NroVisitantes=?,MediaVisitantesDia=?,MediaVisitantesInterno=?,"
                    + "NroCriancasVisitantes=? WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.setInt(1, objAtividade.getNumeroDiasVisitas());
            pst.setInt(2, objAtividade.getNumeroVistantesInternos());
            pst.setInt(3, objAtividade.getMediaVisitasDia());
            pst.setInt(4, objAtividade.getMediaVisitasInterno());
            pst.setInt(5, objAtividade.getNumeroCriancasVisitas());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ATIVIDADES_UNIDADE_VISITA_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }

    public AtividadesMensalRealizadaUnidades excluirAVI(AtividadesMensalRealizadaUnidades objAtividade) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATIVIDADES_UNIDADE_VISITA_INTERNO WHERE IdAtividade='" + objAtividade.getChave() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR (ATIVIDADES_UNIDADE_VISITA_INTERNO) os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtividade;
    }
}
