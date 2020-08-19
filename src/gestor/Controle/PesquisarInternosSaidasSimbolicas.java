/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.jCodigoReq;
import static gestor.Visao.TelaSaidaSimbolica.jFotoInternoSB;
import static gestor.Visao.TelaSaidaSimbolica.jIdRegistro;
import static gestor.Visao.TelaSaidaSimbolica.pINTERNOS;
import static gestor.Visao.TelaSaidaSimbolica.idItem;
import static gestor.Visao.TelaSaidaSimbolica.codItem;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ronal
 */
public class PesquisarInternosSaidasSimbolicas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    String caminho = "";

    public List<SaidaSimbolica> read() throws Exception {
        conecta.abrirConexao();
        List<SaidaSimbolica> listaInternosSaidaSimbolica = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdItem "
                    + "FROM ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida='" + jCodigoReq.getText() + "' "
                    + "ORDER BY IdItem");
            while (conecta.rs.next()) {
                SaidaSimbolica pInternosSaida = new SaidaSimbolica();
                pInternosSaida.setIdItem(conecta.rs.getInt("IdItem"));
                pInternosSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pInternosSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosSaidaSimbolica.add(pInternosSaida);
            }
            return listaInternosSaidaSimbolica;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public SaidaSimbolica MOSTRAR_SAIDA_SIMBOLICA_internos(SaidaSimbolica objSaida) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_SAIDA_SIMBOLICA_CRC.IdItem, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida,"
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "PRONTUARIOSCRC.ImagemFrente, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.DataEntrega, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.Horario "
                    + "FROM ITENS_SAIDA_SIMBOLICA_CRC "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdRegSaida='" + jIdRegistro.getText() + "' "
                    + "AND ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc='" + pINTERNOS + "'");
            conecta.rs.first();
            idItem = conecta.rs.getInt("IdItem");
            codItem = conecta.rs.getInt("IdItem");
            objSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
            // Capturando foto
            caminho = conecta.rs.getString("FotoInternoCrc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoInternoSB.setIcon(i);
                jFotoInternoSB.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInternoSB.getWidth(), jFotoInternoSB.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoInternoSB.getWidth(), jFotoInternoSB.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoInternoSB.setIcon(icon);
            }
            objSaida.setNrdocumentoSA(conecta.rs.getString("DataEntrega"));
            objSaida.setDataRegistroSA(conecta.rs.getDate("Horario"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objSaida;
    }
}
