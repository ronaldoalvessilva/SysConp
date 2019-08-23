/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegSaidaInternos;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.RegistroSaidaPortaria;
import gestor.Modelo.TransferenciaInternos;
import static gestor.Visao.TelaRegistroEntradaSaidaEducacional.jNomeInstituicao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleSEEducacaoPortariaBio {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroSaidaPortaria objSaida = new RegistroSaidaPortaria();
    ItensRegSaidaInternos objItemSaida = new ItensRegSaidaInternos();
    //
    ItensTransInterno objItensTrans = new ItensTransInterno(); // Dados dos itens do internos TRANSFRÊNCIA
    TransferenciaInternos objTrans = new TransferenciaInternos(); // Dados da capa
    //
    String pBio = null;
    String pAtivo = "Ativo";
    int tipoAcesso = 0; // Zero é liberado na tabela de INTERNOS_SAIDA_EDUCACIONAL
    String evadidoEscola = "";
    public static int qtdInternosEdu = 0;

    public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> listaInternosSaida = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM INTERNOS_SAIDA_EDUCACIONAL "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ASSISTENCIA_EDUCACAO_EXTERNA "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdEduca=ASSISTENCIA_EDUCACAO_EXTERNA.IdEduca "
                    + "INNER JOIN INSTITUICAOESCOLAR "
                    + "ON ASSISTENCIA_EDUCACAO_EXTERNA.IdCod=INSTITUICAOESCOLAR.IdCod "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON INTERNOS_SAIDA_EDUCACIONAL.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "WHERE NomeInstituicao='" + jNomeInstituicao.getText() + "' "
                    + "AND TipoAcesso='" + tipoAcesso + "' "
                    + "AND Evadido='" + evadidoEscola + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                pDigital.setImagemFrente(conecta.rs.getBytes("ImagemFrente"));
                listaInternosSaida.add(pDigital);
                qtdInternosEdu++;
            }
            return listaInternosSaida;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
