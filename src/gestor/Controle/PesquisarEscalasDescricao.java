/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalaFolgas;
import static gestor.Visao.TelaFuncionarios.jCodigoPesqFunc;
import static gestor.Visao.TelaFuncionarios.jComboBoxDescricaoEscala;
import static gestor.Visao.TelaFuncionarios.jIDFunc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class PesquisarEscalasDescricao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalaFolgas objEscalas = new EscalaFolgas();
    String pSTATUS_ativo = "Ativo";

    public List<EscalaFolgas> read() throws Exception {
        conecta.abrirConexao();
        List<EscalaFolgas> listaRegistroEntradasSaidasColaboradores = new ArrayList<EscalaFolgas>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistro, "
                    + "StatusEscala, "
                    + "DataCadastro, "
                    + "QuantidadeTrab, "
                    + "QuantidadeFolga, "
                    + "DescricaoEscala, "
                    + "Turno, "
                    + "Turma "
                    + "FROM ESCALA_TRABALHO "
                    + "WHERE StatusEscala='" + pSTATUS_ativo + "'");
            while (conecta.rs.next()) {
                EscalaFolgas pEscalFolgas = new EscalaFolgas();
                pEscalFolgas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pEscalFolgas.setStatusEscala(conecta.rs.getString("StatusEscala"));
                pEscalFolgas.setDataCadastro(conecta.rs.getDate("DataCadastro"));
                pEscalFolgas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
                pEscalFolgas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
                pEscalFolgas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
                pEscalFolgas.setTurno(conecta.rs.getString("Turno"));
                pEscalFolgas.setTurma(conecta.rs.getString("Turma"));
                listaRegistroEntradasSaidasColaboradores.add(pEscalFolgas);
            }
            return listaRegistroEntradasSaidasColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public EscalaFolgas MOSTRAR_escala(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdRegistro, "
                    + "StatusEscala,DataCadastro, "
                    + "QuantidadeTrab,QuantidadeFolga, "
                    + "DescricaoEscala,Turno,"
                    + "Turma "
                    + "FROM ESCALA_TRABALHO "
                    + "WHERE DescricaoEscala='" + jComboBoxDescricaoEscala.getSelectedItem() + "'");
            conecta.rs.first();
            objEscalas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objEscalas.setStatusEscala(conecta.rs.getString("StatusEscala"));
            objEscalas.setDataCadastro(conecta.rs.getDate("DataCadastro"));
            objEscalas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
            objEscalas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
            objEscalas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
            objEscalas.setTurno(conecta.rs.getString("Turno"));
            objEscalas.setTurma(conecta.rs.getString("Turma"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas MOSTRAR_FUNC_escala(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala,"
                    + "ESCALA_TRABALHO.DescricaoEscala, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeTrab, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeFolga, "
                    + "ESCALA_TRABALHO.Turno, "
                    + "ESCALA_TRABALHO.Turma, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc "
                    + "FROM ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "INNER JOIN ESCALA_TRABALHO "
                    + "ON ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro=ESCALA_TRABALHO.IdRegistro "
                    + "WHERE IdFunc='" + jCodigoPesqFunc.getText() + "'");
            conecta.rs.first();
            objEscalas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objEscalas.setIdEscala(conecta.rs.getInt("IdEscala"));
            objEscalas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
            objEscalas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
            objEscalas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
            objEscalas.setTurno(conecta.rs.getString("Turno"));
            objEscalas.setTurma(conecta.rs.getString("Turma"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }

    public EscalaFolgas MOSTRAR_FUNC_cronograma(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala,"
                    + "ESCALA_TRABALHO.DescricaoEscala, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeTrab, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeFolga, "
                    + "ESCALA_TRABALHO.Turno, "
                    + "ESCALA_TRABALHO.Turma, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc, "
                    + "COLABORADOR.NomeFunc "
                    + "FROM ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "INNER JOIN ESCALA_TRABALHO "
                    + "ON ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro=ESCALA_TRABALHO.IdRegistro "
                    + "INNER JOIN COLABORADOR "
                    + "ON ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE COLABORADOR.IdFunc='" + jIDFunc.getText() + "'");
            conecta.rs.first();
            objEscalas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objEscalas.setIdFunc(conecta.rs.getInt("IdFunc"));
            objEscalas.setNomeFuncEscala(conecta.rs.getString("NomeFunc"));
            objEscalas.setIdEscala(conecta.rs.getInt("IdEscala"));
            objEscalas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
            objEscalas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
            objEscalas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
            objEscalas.setTurno(conecta.rs.getString("Turno"));
            objEscalas.setTurma(conecta.rs.getString("Turma"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }
    
    public EscalaFolgas MOSTRAR_DADOS_CRONOGRAMA_gravado(EscalaFolgas objEscalas) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala,"
                    + "ESCALA_TRABALHO.DescricaoEscala, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeTrab, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeFolga, "
                    + "ESCALA_TRABALHO.Turno, "
                    + "ESCALA_TRABALHO.Turma, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc, "
                    + "COLABORADOR.NomeFunc "
                    + "FROM CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "INNER JOIN ESCALA_TRABALHO "
                    + "ON CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala=ESCALA_TRABALHO.IdEscala "
                    + "INNER JOIN COLABORADOR "
                    + "ON CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc='" + jIDFunc.getText() + "'");
            conecta.rs.first();
            objEscalas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
            objEscalas.setIdFunc(conecta.rs.getInt("IdFunc"));
            objEscalas.setNomeFuncEscala(conecta.rs.getString("NomeFunc"));
            objEscalas.setIdEscala(conecta.rs.getInt("IdEscala"));
            objEscalas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
            objEscalas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
            objEscalas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
            objEscalas.setTurno(conecta.rs.getString("Turno"));
            objEscalas.setTurma(conecta.rs.getString("Turma"));
            objEscalas.setPrimeiroApt(conecta.rs.getString("PrimeiroApt"));
            objEscalas.setSegundoApt(conecta.rs.getString("SegundoApt"));
            objEscalas.setDataInicial(conecta.rs.getDate("DataInicial"));
            objEscalas.setDataFinal(conecta.rs.getDate("DataFinal"));
            objEscalas.setDataPrimeiraFolga(conecta.rs.getDate("DataPrimeiraFolga"));
        } catch (SQLException ex) {
            Logger.getLogger(ControleEscalaFolgas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objEscalas;
    }
}
