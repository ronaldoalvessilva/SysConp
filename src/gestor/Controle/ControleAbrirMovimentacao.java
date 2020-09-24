/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AbrirMovimentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleAbrirMovimentacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AbrirMovimentos objAbriNov = new AbrirMovimentos();

    public AbrirMovimentos alterarEntradaFamiliar(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFAMILIAR SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaAdvogadosInternos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVINTERNOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaAdvogadosDepartamento(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASADVOGADOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVisitasDiversas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASVISITAS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaColaboradores(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADASFUNC SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSUNIDADE SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosCarga(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOCARGA SET StatusEnt=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaVeiculosTerceiro(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAVEICULOSTERCEIRO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaLaborativa(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADALABORINTERNO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarRetornoInternos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGRETORNO SET StatusRet=? WHERE IdRetorno='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEntradaInterUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAINTERNOSPORTARIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarSaidaInterUnidade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGSAIDACRC SET StatusSai=? WHERE IdSaida='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarMovPertences(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAPERTENCES SET SituacaoEnt=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarMovDeposito(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITOPORTARIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOcorrenciasP1(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1 SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOcorrenciasInd(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET StatusReg=? WHERE IdReg='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //----------------------------------------- PORTARIA EXTERNA ------------------------------------------------
    public AbrirMovimentos alterarOcorrenciasP1E(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_P1E SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_REGISTROS_CHEGADA(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA SET StatusReg=? WHERE IdRegVisita='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //-------------------------------------- GERÊNCIA ADMINISTRATIVA -----------------------------------
    public AbrirMovimentos alterar_ATIVIDADES_MENSAL(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_UNIDADE SET StatusAtividade=? WHERE IdAtividade='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //------------------------------------ GERÊNCIA OPERACIONAL ------------------------------------------
    public AbrirMovimentos alterar_LOCACAO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOCACAOINTERNO SET StatusLoca=? WHERE IdLoca='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_TRANSFERENCIA(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRANSFERENCIALOCAL SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_VALORES(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEPOSITOPORTARIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_REVISTA(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROCEDIMENTOS SET StatusLanc=? WHERE IdProc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_PENALIDADE_I(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTROEVENTOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_PENALIDADE_II(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGIMENTO_DISCIPLINAR_INTERNOS SET StatusReg=? WHERE IdReg='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_RETIRAR_PENALIDADE(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETIRADAINTERNO SET StatusLanc=? WHERE IdLancRet='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_LIVRO_OCORRENCIA(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIASEGURANCA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_BLOQUEIO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTRO_INDISCIPLINA_PORTARIA SET StatusReg=? WHERE IdReg='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_NIM(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ORGANOGRAMA_CRIME SET StatusOrg=? WHERE IdOrg='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_PERTENCES_GTE(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERTENCES SET StatusLanc=? WHERE IdPertence='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_ENTRADA_PERTENCES_GTE(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAOBJETOSPERTENCES SET StatusLanc=? WHERE IdEntrada='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_SAIDA_PERTENCES_GTE(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDAOBJETOSPERTENCES SET StatusLanc=? WHERE IdSaida='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //-------------------------------------------- ALMOXARIFADO --------------------------------------------------------
    public AbrirMovimentos alterar_NF(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SAIDAOBJETOSPERTENCES SET StatusNf=? WHERE IdNfEntrada='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_INVENTARIO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_AC SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_MONTAGEM(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET StatusComp=? WHERE IdRegistroComp='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_KIT_INDIVIDUAL(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_PRODUTOS_INTERNOS SET StatusReq=? WHERE IdReq='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_REQUISICAO_AVULSA(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REQUISICAO_AVULSA_PRODUTOS SET StatusReq=? WHERE IdReq='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_CANCELAMENTO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAR_PAGAMENTO_KIT_HIGIENE SET StatusRegistro=? WHERE IdRegistro='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_ESTORNO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESTORNO_PRODUTOS_AC SET StatusEst=? WHERE IdEst='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_SOL_COMPRAS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_PRODUTOS_ADM SET StatusSol=? WHERE IdSol='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //----------------------------------- BASE I ----------------------------------------------------------------------------
    public AbrirMovimentos alterar_ENTREGA_KIT_B1(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=? WHERE IdPagto='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_ESCOLTA_B1(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCOLTA_INTERNO_PSP SET StatusEscolta=? WHERE IdEsco='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarLIVRO_OCORRENCIA_B1(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //----------------------------------------------- BASE II --------------------------------------------------------------------
    public AbrirMovimentos alterar_ENTREGA_KIT_B2(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=? WHERE IdPagto='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterar_ESCOLTA_B2(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ESCOLTA_INTERNO_PSP SET StatusEscolta=? WHERE IdEsco='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarLIVRO_OCORRENCIA_B2(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_BASE_SEGURANCA_AUXILIAR SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //---------------------------------------------------- TRIAGEM -------------------------------------------------
    public AbrirMovimentos alterarPRE_LOCACAO_tri(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRE_LOCACAO_INTERNOS SET StatusReg=? WHERE CodigoReg='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //------------------------------------------------- ENFERMAGEM --------------------------------------------------
    public AbrirMovimentos alterarADM_medica(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOMEDICA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_medica_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_MEDICA_ADICIONAL SET StatusLanc=? WHERE IdAdmADI='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarAVA_medica(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAO_MEDICA_PSIQUIATRICA SET StatusAval=? WHERE IdAvalia='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarSOLI_exames(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO SET StatusSolExame=? WHERE IdSolExame='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarENCA_cirurgias(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS SET StatusEnca=? WHERE IdEnca='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCALENDARIO_vacinas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CARTILHA_VACINAS_INTERNOS SET StatusCart=? WHERE IdCart='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarHISTORICO_doe(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_DOENCA_FAMILIA SET StatusHist=? WHERE IdHist='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATENDIMENTO_grupo(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_ENFERMAGEM SET StatusAtendGrupo=? WHERE IdAtGrupoEnf='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarAPRAZA_medico(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE APRAZAMENTO_MEDICACAO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarPERFIL_carcerario(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=? WHERE IdPerfil='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_enfermagem(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOENFERMEIRA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_enfermagem_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_ENFERMEIRA_COMPLEMENTAR SET StatusLanc=? WHERE IdADME='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATEND_tec_enfermagem(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTECENFERMAGEM SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORRE_tec_enfermagem(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_ME SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //-------------------------------------------------------- ODONOTOLOGIA -------------------------------------------------------------------------------
    public AbrirMovimentos alterarADM_odonto(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTODONTO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORRE_odonto(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_OD SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //------------------------------------------------------- PSICOLOGIA -------------------------------------------------------------
    public AbrirMovimentos alterarADM_psicologico(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAOPSI SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_psicologica_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_PSICOLOGIA SET StatusLanc=? WHERE IdPortaPSI='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarAVA_psicologica(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AVALIACAOPSI SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORRE_psicologica(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_PSI SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATEND_grupo_psi(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PSICOLOGIA SET StatusAtendGrupo=? WHERE IdAtGrupoPsi='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //----------------------------------------------------- SERVIÇO SOCIAL -----------------------------------------------------------------------
    public AbrirMovimentos alterarADM_social(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET StatusAtend=? WHERE IdAtend='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_social_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_SERVICO_SOCIAL SET StatusAtend=? WHERE IdAtendSS='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarPERFIL_carcerario_SS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERFIL_CARCERARIO_INTERNO SET StatusPerfil=? WHERE IdPerfil='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATUALIZA_doc(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZACAO_DOCUMENTOS_INTERNOS SET StatusDoc=? WHERE CodigoDoc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATENDE_familia(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIAR SET StatusAtendf=? WHERE IdAtendf='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCANCELAR_visitas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL SET StatusCan=? WHERE IdCan='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATENDIMENTO_grupo_SS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_SS SET StatusAtendGrupo=? WHERE IdAtGrupoSS='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONTROLE_ligacoes(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTROLIGA SET StatusControl=? WHERE IdControl='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORRE_social(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_SERVICO_SOCIAL SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarHISTORICO_avalia_SS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_AVALICAO_SERVICO_SOCIAL SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarHISTORICO_AVALIA_emp_SS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_VISITA_EMPREGO_SERVICO_SOCIAL SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATESTADO_reclusao(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SOLICITACAO_ATESTADO_RECLUSAO SET StatusAux=? WHERE CodRegAux='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //----------------------------------------------------- PEDAGOGIA -------------------------------------------------------------------
    public AbrirMovimentos alterarRESERVA_acervo(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESERVA_ACERVO SET StatusLanc=? WHERE IdReserva='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarEMPRESTIMO_acervo(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESERVA_ACERVO SET StatusLanc=? WHERE IdReserva='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarDEVOLUCAO_acervo(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_ACERVO SET StatusLanc=? WHERE IdDevolucao='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCOMPRAS_livros(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPRAS_ACERVO SET StatusLanc=? WHERE IdCompra='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarINVENTARIO(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INVENTARIO_LIVROS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_pedagogia(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA SET StatusAdm=? WHERE IdAdm='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADM_pedagogia_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_PEDAGOGIA_NOVA SET StatusAdmNova=? WHERE IdAdm='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarMATRICULAS(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MATRICULAESCOLAR SET StatusMat=? WHERE IdMat='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONCLUIR_matricula(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZAR_MATRICULA_INTERNO SET StatusAtual=? WHERE IdAtual='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONTROLE_frequencia(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA SET StatusFreq=? WHERE IdFreq='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarBAIXA_internos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE BAIXAINTERNOS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATIVIDADES_comp(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET StatusAC=? WHERE IdAC='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATENDIMENTO_grupo_peda(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_PE SET StatusAtendGrupo=? WHERE IdAtGrupoPE='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONTROLE_FREQ_cursos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA SET StatusFAC=? WHERE IdFAC='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarREMISSAO_leitura(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RESENHA_REMICAO_INTERNO SET StatusResenha=? WHERE IdResenha='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATUALIZACAO_escolaridade(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATUALIZACAO_DOCUMENTOS_INTERNOS SET StatusDoc=? WHERE CodigoDoc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONTROLE_DIAS_horas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_PEDAGOGIA_EXTERNA SET StatusFreqLab=? WHERE IdFreqLab='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarASSISTENCIA_educacao(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ASSISTENCIA_EDUCACAO_EXTERNA SET StatusLanc=? WHERE IdEduca='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORR_peda(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_PE SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //------------------------------------------------------- TERAPIA OCUPACIONAL -------------------------------------------------------------------
    public AbrirMovimentos alterarADMISSAO_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOTERAPIA SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADMISSAO_COMP_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_TERAPIA_PE SET StatusLanc=? WHERE IdATN='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarTRIAGEM_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRIAGEM_OCUPACIONAL SET StatusLanc=? WHERE IdTriagem='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCONTROLE_DIAS_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_LABORATIVA_EXTERNA SET StatusFreqLab=? WHERE IdFreqLab='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarATENDIMENTO_grupo_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTO_GRUPO_TO SET StatusAtendGrupo=? WHERE IdAtGrupoTO='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarOCORR_to(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_TO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarCAPACITACAO_oficinas(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CAPACITACAO_INTERNO_TO SET StatusRegistro=? WHERE IdCap='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarFREQUENCIA_cursos(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FREQUENCIA_CAPACITACAO_INTERNO_TO SET StatusRegistro=? WHERE IdFreqCap='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    //------------------------------------------------------ JURÍDICO --------------------------------------------------------------------
    public AbrirMovimentos alterarADMISSAO_jur(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOJURIDICO SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }

    public AbrirMovimentos alterarADMISSAO_COMP_jur(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADMISSAO_JURIDICO_ADICIONAL SET StatusLanc=? WHERE IdADM_JURI='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
    
    public AbrirMovimentos alterarFICHA_juridica(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_JURIDICA SET StatusFicha=? WHERE IdFicha='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
    
    public AbrirMovimentos alterarATENDIMENTO_familiar(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIARJURIDICO SET StatusAtendf=? WHERE IdAtendf='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
    
    public AbrirMovimentos alterarAUDIENCIA_justificativa(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AUDIENCIAS SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
    
    public AbrirMovimentos alterarOCORR_jur(AbrirMovimentos objAbriNov) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCORRENCIAS_JU SET StatusLanc=? WHERE IdLanc='" + objAbriNov.getIdLanc() + "'");
            pst.setString(1, objAbriNov.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAbriNov;
    }
}
