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
}
