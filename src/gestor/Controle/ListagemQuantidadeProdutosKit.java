/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.listarInternosPopulacaoNominal;
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
            conecta.executaSQL("SELECT * FROM (SELECT PRODUTOS_AC.DescricaoProd AS DESCRICAO, "
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
                    + "[TOALHA DE BANHO])) Colunas");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pQuantRevista = new AtividadesMensalRealizadaUnidades();
                pQuantRevista.setAparelhoBarbear(Integer.parseInt("APARELHO DE BARBEAR DESCATAVEL"));
                pQuantRevista.setAbsorvente(Integer.parseInt("[ABSORVENTE PARA INTERNAS]"));
                pQuantRevista.setBermuda(Integer.parseInt("BERMUDA LARANJA G"));
                pQuantRevista.setCamisa(Integer.parseInt("CAMISA LARANJA G"));
                pQuantRevista.setCaneca(Integer.parseInt("CANECA PLASTICA C ALCA 300ML"));
                pQuantRevista.setCobertor(Integer.parseInt("COBERTOR DORME BEM"));
                pQuantRevista.setColchao(Integer.parseInt("COLCHAO DE SOLTEIRO"));
                pQuantRevista.setColher(Integer.parseInt("COLHER PLASTICA"));
                pQuantRevista.setCremeDental(Integer.parseInt("CREME DENTAL 90G"));
                pQuantRevista.setCueca(Integer.parseInt("CUECA DE MALHA"));
                pQuantRevista.setDesodorante(Integer.parseInt("DESODORANTE EM CREME"));
                pQuantRevista.setEscova(Integer.parseInt("ESCOVA DENTAL"));
                pQuantRevista.setLencol(Integer.parseInt("LENCOL DE SOLTEIRO"));
                pQuantRevista.setPapelHigienico(Integer.parseInt("PAPEL HIGIENICO 30MTS"));
                pQuantRevista.setPote(Integer.parseInt("POTE PLASTICO 1.200L"));
                pQuantRevista.setSabaoPo(Integer.parseInt("SABAO EM PO 200G"));
                pQuantRevista.setSabonete(Integer.parseInt("SABONETE 90G"));
                pQuantRevista.setParChinelos(Integer.parseInt("SANDALIA TAM. 37 - 43"));
                pQuantRevista.setToalha(Integer.parseInt("TOALHA DE BANHO"));
                listaInternospIntFreq.add(pQuantRevista);
//                pQUANTIDADE_REVISTA_POR_CELA = pQUANTIDADE_REVISTA_POR_CELA + 1;
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
