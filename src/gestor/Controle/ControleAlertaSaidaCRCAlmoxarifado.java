/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidasInternosCRCAlmoxarifado;
import static gestor.Visao.TelaAlertaSaidaInternosCRCAlmoxarifado.pTOTAL_registros;
import static gestor.Visao.TelaModuloAlmoxarifado.pALERTA_almox;
import static gestor.Visao.TelaModuloAlmoxarifado.pNOME_usuario1;
import static gestor.Visao.TelaModuloAlmoxarifado.pNOME_usuario2;
import static gestor.Visao.TelaModuloAlmoxarifado.pNOME_usuario3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleAlertaSaidaCRCAlmoxarifado {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidasInternosCRCAlmoxarifado objSaidaCRCAlmox = new SaidasInternosCRCAlmoxarifado();

    String CONFIRMACAO_saida = "Não";

    public List<SaidasInternosCRCAlmoxarifado> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<SaidasInternosCRCAlmoxarifado> LISTA_INTERNOS_saida = new ArrayList<SaidasInternosCRCAlmoxarifado>();
        try {
            conecta.executaSQL("SELECT "
                    + "i.DataSaida, "
                    + "i.IdInternoCrc, "
                    + "p.NomeInternoCrc, "
                    + "i.DestinoSaida, "
                    + "i.SaidaConfirmada "
                    + "FROM ITENSCRCPORTARIA AS i "
                    + "INNER JOIN PRONTUARIOSCRC AS p "
                    + "ON i.IdInternoCrc=p.IdInternoCrc "
                    + "WHERE i.SaidaConfirmada='" + CONFIRMACAO_saida + "' "
                    + "ORDER BY p.NomeInternoCrc");
            while (conecta.rs.next()) {
                SaidasInternosCRCAlmoxarifado pSaida = new SaidasInternosCRCAlmoxarifado();
                pSaida.setDataSaida(conecta.rs.getDate("DataSaida"));
                pSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pSaida.setDestinoInterno(conecta.rs.getString("DestinoSaida"));
                LISTA_INTERNOS_saida.add(pSaida);
                ++pTOTAL_registros;
            }
            return LISTA_INTERNOS_saida;
        } catch (SQLException ex) {
            Logger.getLogger(ControleAlertaSaidaCRCAlmoxarifado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public SaidasInternosCRCAlmoxarifado pPESQUISAR_saida(SaidasInternosCRCAlmoxarifado objSaidaCRCAlmox) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "HabilitarAlertaAlmox, "
                    + "UsuarioAlmoxarifado01, "
                    + "UsuarioAlmoxarifado02, "
                    + "UsuarioAlmoxarifado03 "
                    + "FROM PARAMETROSCRC");
            conecta.rs.first();
            pALERTA_almox = conecta.rs.getString("HabilitarAlertaAlmox");
            pNOME_usuario1  = conecta.rs.getString("UsuarioAlmoxarifado01");
            pNOME_usuario2  = conecta.rs.getString("UsuarioAlmoxarifado02");
            pNOME_usuario3  = conecta.rs.getString("UsuarioAlmoxarifado03");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objSaidaCRCAlmox;
    }
}
