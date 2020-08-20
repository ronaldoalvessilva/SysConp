/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RolVisitas;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.pTOTAL_registros;
import static gestor.Visao.TelaSaidaSimbolica.jCodigoReq;
import static gestor.Visao.TelaSaidaSimbolica.jFotoInternoSB;
import static gestor.Visao.TelaSaidaSimbolica.jIdRegistro;
import static gestor.Visao.TelaSaidaSimbolica.pINTERNOS;
import static gestor.Visao.TelaSaidaSimbolica.idItem;
import static gestor.Visao.TelaSaidaSimbolica.codItem;
import static gestor.Visao.TelaSaidaSimbolica.pCODIGO_INTERNO_rol;
import static gestor.Visao.TelaSaidaSimbolica.pSTATUS_ROL_aberto;
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
    RolVisitas objRol = new RolVisitas();

    String caminho = "";

    public List<SaidaSimbolica> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<SaidaSimbolica> listaInternosSaidaSimbolica = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdItem "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.NrdocumentoSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.TipoBeneficioSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.DataRegistroSA "
                    + "PRONTUARIOSCRC.NomeInternoCrc "
                    + "FROM ITENS_SAIDA_SIMBOLICA_CRC "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida='" + jCodigoReq.getText() + "' "
                    + "ORDER BY IdItem");
            while (conecta.rs.next()) {
                SaidaSimbolica pInternosSaida = new SaidaSimbolica();
                pInternosSaida.setIdItem(conecta.rs.getInt("IdItem"));
                pInternosSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pInternosSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pInternosSaida.setNrdocumentoSA(conecta.rs.getString("NrdocumentoSA"));
                pInternosSaida.setTipoBeneficioSA(conecta.rs.getString("TipoBeneficioSA"));
                pInternosSaida.setDataRegistroSA(conecta.rs.getDate("DataRegistroSA"));
                listaInternosSaidaSimbolica.add(pInternosSaida);
                pTOTAL_registros = pTOTAL_registros + 1;
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
            conecta.executaSQL("SELECT "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdItem, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida,"
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.DataRegistroSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.TipoBeneficioSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.DataRegistroSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.NrdocumentoSA, "
                    + "PRONTUARIOSCRC.MatriculaCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "PRONTUARIOSCRC.MaeInternoCrc,PRONTUARIOSCRC.ImagemFrente, "
                    + "DADOSPENAISINTERNOS.Regime "
                    + "FROM ITENS_SAIDA_SIMBOLICA_CRC "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE IdRegSaida='" + jIdRegistro.getText() + "' "
                    + "AND ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc='" + pINTERNOS + "'");
            conecta.rs.first();
            idItem = conecta.rs.getInt("IdItem");
            codItem = conecta.rs.getInt("IdItem");
            objSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
            objSaida.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
            objSaida.setRegimePenal(conecta.rs.getString("Regime"));
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
            objSaida.setNrdocumentoSA(conecta.rs.getString("NrdocumentoSA"));
            objSaida.setTipoBeneficioSA(conecta.rs.getString("TipoBeneficioSA"));
            objSaida.setDataRegistroSA(conecta.rs.getDate("DataRegistroSA"));
            objSaida.setMaeInterno(conecta.rs.getString("MaeInternoCrc"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objSaida;
    }

    public RolVisitas PESQUISAR_INTERNO_rol(RolVisitas objRol) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdInternoCrc,StatusRol "
                    + "FROM ROLVISITAS "
                    + "WHERE IdInternoCrc='" + objRol.getIdInterno()+ "' "
                    + "AND StatusRol='" + pSTATUS_ROL_aberto + "'");
            conecta.rs.first();
            pCODIGO_INTERNO_rol = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objRol;
    }
}
