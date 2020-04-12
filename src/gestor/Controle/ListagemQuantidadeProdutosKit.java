/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoInicial;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ListagemQuantidadeProdutosKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        List<AtividadesMensalRealizadaUnidades> listaInternospIntFreq = new ArrayList<AtividadesMensalRealizadaUnidades>();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        }
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * "
                    + "FROM (SELECT "
                    + "PRODUTOS_AC.DescricaoProd AS DESCRICAO,"
                    + "SUM(ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.QuantProd) AS TOTAL_ENTREGUE "
                    + "FROM "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE CONVERT(DATE, ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.DataEntrega) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' "
                    + "GROUP BY PRODUTOS_AC.IdProd,PRODUTOS_AC.DescricaoProd "
                    + ") linhas "
                    + "PIVOT (SUM(TOTAL_ENTREGUE) FOR DESCRICAO IN ( "
                    + "[APARELHO DE BARBEAR DESCATAVEL], "
                    + "[ABSORVENTE PARA INTERNAS], "
                    + "[BERMUDA LARANJA G], "
                    + "[CAMISA LARANJA G], "
                    + "[CANECA PLASTICA C ALCA 300ML], "
                    + "[COBERTOR DORME BEM], "
                    + "[COLCHAO DE SOLTEIRO], "
                    + "[COLHER PLASTICA], "
                    + "[CREME DENTAL 90G], "
                    + "[CUECA DE MALHA], "
                    + "[DESODORANTE EM CREME], "
                    + "[ESCOVA DENTAL], "
                    + "[LENCOL DE SOLTEIRO], "
                    + "[PAPEL HIGIENICO 30MTS], "
                    + "[POTE PLASTICO 1.200L], "
                    + "[SABAO EM PO 200G], "
                    + "[SABONETE 90G], "
                    + "[SANDALIA TAM. 37 - 43], "
                    + "[TOALHA DE BANHO], "
                    + "[UNIFORME COMPLETO])) Colunas ");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pQuantRevista = new AtividadesMensalRealizadaUnidades();
                pQuantRevista.setAparelhoBarbear(conecta.rs.getInt("APARELHO DE BARBEAR DESCATAVEL"));
                pQuantRevista.setAbsorvente(conecta.rs.getInt("ABSORVENTE PARA INTERNAS"));
                pQuantRevista.setBermuda(conecta.rs.getInt("BERMUDA LARANJA G"));
                pQuantRevista.setCamisa(conecta.rs.getInt("CAMISA LARANJA G"));
                pQuantRevista.setCaneca(conecta.rs.getInt("CANECA PLASTICA C ALCA 300ML"));
                pQuantRevista.setCobertor(conecta.rs.getInt("COBERTOR DORME BEM"));
                pQuantRevista.setColchao(conecta.rs.getInt("COLCHAO DE SOLTEIRO"));
                pQuantRevista.setColher(conecta.rs.getInt("COLHER PLASTICA"));
                pQuantRevista.setCremeDental(conecta.rs.getInt("CREME DENTAL 90G"));
                pQuantRevista.setCueca(conecta.rs.getInt("CUECA DE MALHA"));
                pQuantRevista.setDesodorante(conecta.rs.getInt("DESODORANTE EM CREME"));
                pQuantRevista.setEscova(conecta.rs.getInt("ESCOVA DENTAL"));
                pQuantRevista.setLencol(conecta.rs.getInt("LENCOL DE SOLTEIRO"));
                pQuantRevista.setPapelHigienico(conecta.rs.getInt("PAPEL HIGIENICO 30MTS"));
                pQuantRevista.setPote(conecta.rs.getInt("POTE PLASTICO 1.200L"));
                pQuantRevista.setSabaoPo(conecta.rs.getInt("SABAO EM PO 200G"));
                pQuantRevista.setSabonete(conecta.rs.getInt("SABONETE 90G"));
                pQuantRevista.setParChinelos(conecta.rs.getInt("SANDALIA TAM. 37 - 43"));
                pQuantRevista.setToalha(conecta.rs.getInt("TOALHA DE BANHO"));
                pQuantRevista.setUniformeCompleto(conecta.rs.getInt("UNIFORME COMPLETO"));
                listaInternospIntFreq.add(pQuantRevista);
            }
            return listaInternospIntFreq;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
