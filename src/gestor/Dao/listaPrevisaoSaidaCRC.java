/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.ItensPrevisaoSaida;
import gestor.Modelo.PrevisaoSaida;
import static gestor.Visao.TelaBuscarPrevisaoSaidaInternos.jDescricaoOp;
import static gestor.Visao.TelaBuscarPrevisaoSaidaInternos.dataInicial;
import static gestor.Visao.TelaBuscarPrevisaoSaidaInternos.dataFinal;
import static gestor.Visao.TelaBuscarPrevisaoSaidaInternos.utilizacaoSaida;
import static gestor.Visao.TelaBuscarPrevisaoSaidaInternos.qtdInternosPS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class listaPrevisaoSaidaCRC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PrevisaoSaida objPrevSaida = new PrevisaoSaida();
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    String situacaoENT = "ENTRADA NA UNIDADE";
    String situacaoRET = "RETORNO A UNIDADE";

    public List<ItensPrevisaoSaida> read() throws Exception {
        conecta.abrirConexao();
        List<ItensPrevisaoSaida> listaInternosKitComp = new ArrayList<ItensPrevisaoSaida>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSPREVISAOSAIDA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSPREVISAOSAIDA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE DataPrevSaida BETWEEN'" + dataInicial + "' "
                    + "AND '" + dataFinal + "' "
                    + "AND ConfirmaSaida='" + utilizacaoSaida + "' "
                    + "AND Beneficio='" + jDescricaoOp.getText() + "'");
            while (conecta.rs.next()) {
                ItensPrevisaoSaida pDigi = new ItensPrevisaoSaida();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCnc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitComp.add(pDigi);
                qtdInternosPS = qtdInternosPS + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
