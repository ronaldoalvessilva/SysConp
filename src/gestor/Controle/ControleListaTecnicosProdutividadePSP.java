/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import static Util.Produtividade.Produtividade.qtd;
import static Util.Produtividade.Produtividade.qtdTecnicosPSP;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaPeriodoProdutividade.jDataFinal;
import static gestor.Visao.TelaPeriodoProdutividade.jDataInicial;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaTecnicosProdutividadePSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroAtendimentoInternos objProdKit = new RegistroAtendimentoInternos();
    //
    String dataInicial;
    String dataFinal;

    public List<RegistroAtendimentoInternos> read() throws Exception {
        conecta.abrirConexao();
        List<RegistroAtendimentoInternos> listaTecnicosPSP = new ArrayList<RegistroAtendimentoInternos>();
        try {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataInicial = formatoAmerica.format(jDataInicial.getDate().getTime());
            dataFinal = formatoAmerica.format(jDataFinal.getDate().getTime());
            conecta.executaSQL("SELECT DEPARTAMENTOS.NomeDepartamento,REGISTRO_ATENDIMENTO_INTERNO_PSP.UsuarioInsert, REGISTRO_ATENDIMENTO_INTERNO_PSP.Qtd, COUNT(REGISTRO_ATENDIMENTO_INTERNO_PSP.Qtd) "
                    + "FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "INNER JOIN DEPARTAMENTOS "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdDepartamento=DEPARTAMENTOS.IdDepartamento "
                    + "INNER JOIN COLABORADOR "
                    + "ON REGISTRO_ATENDIMENTO_INTERNO_PSP.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE REGISTRO_ATENDIMENTO_INTERNO_PSP.DataReg>='" + dataInicial + "' "
                    + "AND REGISTRO_ATENDIMENTO_INTERNO_PSP.DataReg<='" + dataFinal + "' "
                    + "GROUP BY DEPARTAMENTOS.NomeDepartamento,REGISTRO_ATENDIMENTO_INTERNO_PSP.UsuarioInsert, REGISTRO_ATENDIMENTO_INTERNO_PSP.Qtd");
            while (conecta.rs.next()) {
                RegistroAtendimentoInternos pDigi = new RegistroAtendimentoInternos();
                pDigi.setNomeFunc(conecta.rs.getString("UsuarioInsert"));
                pDigi.setNomeDepartamento(conecta.rs.getString("NomeDepartamento"));
                pDigi.setQtd(conecta.rs.getInt("Qtd"));
                listaTecnicosPSP.add(pDigi);
                qtdTecnicosPSP = qtdTecnicosPSP + 1;
            }
            return listaTecnicosPSP;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaTecnicosProdutividadePSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
