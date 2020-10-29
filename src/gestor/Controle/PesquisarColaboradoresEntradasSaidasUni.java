/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradasSaidasColaboradores;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pTOTAL_registros;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jCodigoPesqFunc;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jFotoColaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jIdRegistro;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pID_colaborador;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pITEM;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pID_item;
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
public class PesquisarColaboradoresEntradasSaidasUni {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradasSaidasColaboradores objEntraSaiFunc = new EntradasSaidasColaboradores();

    String caminho = "";

    public List<EntradasSaidasColaboradores> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<EntradasSaidasColaboradores> listaColaboradorSaida = new ArrayList<EntradasSaidasColaboradores>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdItem, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdRegRegistro, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdFunc, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.DataEvento, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.DataRetorno, "
                    + "COLABORADOR.NomeFunc, "
                    + "COLABORADOR.NomeMae "
                    + "FROM ITENS_ENTRADAS_SAIDAS_COLABORADORES "
                    + "INNER JOIN COLABORADOR "
                    + "ON ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdRegRegistro='" + jCodigoPesqFunc.getText() + "'");
            while (conecta.rs.next()) {
                EntradasSaidasColaboradores pColaboradoresEntSaida = new EntradasSaidasColaboradores();
                pColaboradoresEntSaida.setIdItem(conecta.rs.getInt("IdItem"));
                pColaboradoresEntSaida.setIdColaborador(conecta.rs.getInt("IdFunc"));
                pColaboradoresEntSaida.setNomeColaborador(conecta.rs.getString("NomeFunc"));
                pColaboradoresEntSaida.setDataEvento(conecta.rs.getDate("DataEvento"));
                pColaboradoresEntSaida.setDataRetorno(conecta.rs.getDate("DataRetorno"));
                pColaboradoresEntSaida.setNomeMaeColaborador(conecta.rs.getString("NomeMae"));
                listaColaboradorSaida.add(pColaboradoresEntSaida);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaColaboradorSaida;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarColaboradoresEntradasSaidasUni.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public EntradasSaidasColaboradores MOSTRAR_ENTRADA_SAIDA_colaboradores(EntradasSaidasColaboradores objEntSaidaCola) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdItem, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdRegRegistro,"
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdFunc, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.DataEvento, "
                    + "ITENS_ENTRADAS_SAIDAS_COLABORADORES.DataRetorno, "
                    + "COLABORADOR.ImagemFunc, "
                    + "COLABORADOR.MatriculaFunc, "
                    + "COLABORADOR.Funcao, "
                    + "COLABORADOR.NomeFunc,"
                    + "COLABORADOR.NomeMae, "
                    + "COLABORADOR.ImagemFrenteCO "
                    + "FROM ITENS_ENTRADAS_SAIDAS_COLABORADORES "
                    + "INNER JOIN COLABORADOR "
                    + "ON ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdItem='" + pID_item + "' "
                    + "AND ITENS_ENTRADAS_SAIDAS_COLABORADORES.IdFunc='" + pID_colaborador + "'");
            conecta.rs.first();
            pITEM = conecta.rs.getInt("IdItem");
            objEntSaidaCola.setIdColaborador(conecta.rs.getInt("IdFunc"));
            objEntSaidaCola.setMatricula(conecta.rs.getString("MatriculaFunc"));
            objEntSaidaCola.setFuncao(conecta.rs.getString("Funcao"));
            objEntSaidaCola.setNomeColaborador(conecta.rs.getString("NomeFunc"));
            // Capturando foto
            caminho = conecta.rs.getString("ImagemFunc");
            if (caminho != null) {
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jFotoColaborador.setIcon(i);
                jFotoColaborador.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH)));
            }
            // BUSCAR A FOTO NO BANCO DE DADOS
            byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteCO"));
            if (imgBytes != null) {
                ImageIcon pic = null;
                pic = new ImageIcon(imgBytes);
                Image scaled = pic.getImage().getScaledInstance(jFotoColaborador.getWidth(), jFotoColaborador.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                jFotoColaborador.setIcon(icon);
            }
            objEntSaidaCola.setNomeMaeColaborador(conecta.rs.getString("NomeMae"));
            objEntSaidaCola.setDataEvento(conecta.rs.getDate("DataEvento"));
            objEntSaidaCola.setDataRetorno(conecta.rs.getDate("DataRetorno"));
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarColaboradoresEntradasSaidasUni.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEntSaidaCola;
    }
}
