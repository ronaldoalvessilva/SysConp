/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cidades;
import gestor.Modelo.Paises;
import gestor.Modelo.ProntuarioCrc;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import static gestor.Visao.TelaProntuarioCrc.jIdInterno;
import static gestor.Visao.TelaProntuarioCrc.jMaeInterno;
import static gestor.Visao.TelaProntuarioCrc.jNomeInterno;
import static gestor.Visao.TelaProntuarioCrc.nomeInternoCrc;
import static gestor.Visao.TelaProntuarioCrc.nomeMaeInterno;
import static gestor.Visao.TelaProntuarioCrc.codInternoCrc;
import static gestor.Visao.TelaProntuarioCrc.nomeInterno;
import static gestor.Visao.TelaProntuarioCrc.codParametrosEntrada;
import static gestor.Visao.TelaProntuarioCrc.pRESPOSTA_gravacao;
import static gestor.Visao.TelaProntuarioCrc.pRESPOSTA_EXCLUSÃO_prontuario;
import static gestor.Visao.TelaProntuarioCrc.pRESPONSTA_CRC_update;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaProntuarioCrc.CODIGO_INTERNO_TABELA_penal;

/**
 *
 * @author Ronaldo
 */
public class ControleInternoCrc {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    Cidades objCida = new Cidades();
    Paises objPais = new Paises();
    int codCidade;
    int codPais;
    String confirmaEntrada = "Não";

    public ProntuarioCrc incluirInternoCrc(ProntuarioCrc objProCrc) {

        PESQUISAR_paises(objProCrc.getNomePais()); // Pesquisa o ID do PAIS
        PESQUISAR_cidade(objProCrc.getNomeCidade()); // Pesquisa o ID  da CIDADE        
        conecta.abrirConexao();
        // Incluir Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRONTUARIOSCRC (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,IdPais,IdCidade,TelefoneCrc,Telefone1Crc,CelularCrc,"
                + "UsuarioInsert,DataInsert,HorarioInsert,CartaoSus,Cnc,ImagemFrente,DocumentacaoCompleta,QuaisDocumentosFaltam,Tornozeleira,UfRG) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            pst.setString(1, objProCrc.getMatricula());
            pst.setTimestamp(2, new java.sql.Timestamp(objProCrc.getDataCadast().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objProCrc.getDataNasci().getTime()));
            pst.setString(4, objProCrc.getFotoInterno());
            pst.setString(5, objProCrc.getNomeInterno());
            pst.setString(6, objProCrc.getMaeInterno());
            pst.setString(7, objProCrc.getPaiInterno());
            pst.setString(8, objProCrc.getAlcunha());
            pst.setString(9, objProCrc.getRgInterno());
            pst.setString(10, objProCrc.getCpfInterno());
            pst.setString(11, objProCrc.getEscolaridade());
            pst.setString(12, objProCrc.getEstadoCivil());
            pst.setString(13, objProCrc.getSexo());
            pst.setString(14, objProCrc.getSituacao());
            pst.setString(15, objProCrc.getReligiao());
            pst.setString(16, objProCrc.getProfissao());
            pst.setString(17, objProCrc.getEndereco());
            pst.setString(18, objProCrc.getBairro());
            pst.setString(19, objProCrc.getCidade());
            pst.setString(20, objProCrc.getEstado());
            pst.setInt(21, codPais);
            pst.setInt(22, codCidade);
            pst.setString(23, objProCrc.getTelefone());
            pst.setString(24, objProCrc.getTelefone1());
            pst.setString(25, objProCrc.getCelular());
            pst.setString(26, objProCrc.getUsuarioInsert());
            pst.setString(27, objProCrc.getDataInsert());
            pst.setString(28, objProCrc.getHoraInsert());
            pst.setString(29, objProCrc.getCartoaSus());
            pst.setString(30, objProCrc.getCnc());
            pst.setBytes(31, objProCrc.getImagemInterno());
            pst.setString(32, objProCrc.getDocumentacaoCompleta());
            pst.setString(33, objProCrc.getQuaisDocumentosFaltam());
            pst.setString(34, objProCrc.getTornozeleira());
            pst.setString(35, objProCrc.getuFRg());
            pst.execute();
            pRESPOSTA_gravacao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_gravacao = "Não";
            Logger.getLogger(ControleInternoCrc.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    //Método para Alterar INTERNO CRC
    public ProntuarioCrc alterarInternoCrc(ProntuarioCrc objProCrc) {
        PESQUISAR_cidade(objProCrc.getNomeCidade()); // Pesquisa o ID  da CIDADE
        PESQUISAR_paises(objProCrc.getNomePais()); // Pesquisa o ID do PAIS
        conecta.abrirConexao();
        // Alterar Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET MatriculaCrc=?,DataCadastCrc=?,DataNasciCrc=?,"
                + "NomeInternoCrc=?,MaeInternoCrc=?,PaiInternoCrc=?,AlcunhaCrc=?,RgInternoCrc=?,CpfInternoCrc=?,FotoInternoCrc=?,EscolaridadeCrc=?,EstadoCivilCrc=?,SexoCrc=?,"
                + "SituacaoCrc=?,ReligiaoCrc=?,ProfissaoCrc=?,EnderecoCrc=?,BairroCrc=?,CidadeCrc=?,EstadoCrc=?,IdCidade=?,IdPais=?,TelefoneCrc=?,Telefone1Crc=?,CelularCrc=?,"
                + "UsuarioUp=?,DataUp=?,HorarioUp=?,CartaoSus=?,Cnc=?,ImagemFrente=?,DocumentacaoCompleta=?,QuaisDocumentosFaltam=?,Tornozeleira=?,UfRG=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "'")) {
            pst.setString(1, objProCrc.getMatricula());
            pst.setTimestamp(2, new java.sql.Timestamp(objProCrc.getDataCadast().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(objProCrc.getDataNasci().getTime()));
            pst.setString(4, objProCrc.getNomeInterno());
            pst.setString(5, objProCrc.getMaeInterno());
            pst.setString(6, objProCrc.getPaiInterno());
            pst.setString(7, objProCrc.getAlcunha());
            pst.setString(8, objProCrc.getRgInterno());
            pst.setString(9, objProCrc.getCpfInterno());
            pst.setString(10, objProCrc.getFotoInterno());
            pst.setString(11, objProCrc.getEscolaridade());
            pst.setString(12, objProCrc.getEstadoCivil());
            pst.setString(13, objProCrc.getSexo());
            pst.setString(14, objProCrc.getSituacao());
            pst.setString(15, objProCrc.getReligiao());
            pst.setString(16, objProCrc.getProfissao());
            pst.setString(17, objProCrc.getEndereco());
            pst.setString(18, objProCrc.getBairro());
            pst.setString(19, objProCrc.getCidade());
            pst.setString(20, objProCrc.getEstado());
            pst.setInt(21, codCidade);
            pst.setInt(22, codPais);
            pst.setString(23, objProCrc.getTelefone());
            pst.setString(24, objProCrc.getTelefone1());
            pst.setString(25, objProCrc.getCelular());
            pst.setString(26, objProCrc.getUsuarioUp());
            pst.setString(27, objProCrc.getDataUp());
            pst.setString(28, objProCrc.getHoraUp());
            pst.setString(29, objProCrc.getCartoaSus());
            pst.setString(30, objProCrc.getCnc());
            pst.setBytes(31, objProCrc.getImagemInterno());
            pst.setString(32, objProCrc.getDocumentacaoCompleta());
            pst.setString(33, objProCrc.getQuaisDocumentosFaltam());
            pst.setString(34, objProCrc.getTornozeleira());
            pst.setString(35, objProCrc.getuFRg());
            pst.executeUpdate();
            pRESPOSTA_gravacao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_gravacao = "Não";
            Logger.getLogger(ControleInternoCrc.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    // EXCLUIR registro do INTERNO CRC
    public ProntuarioCrc excluirInternoCrc(ProntuarioCrc objProCrc) {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRONTUARIOSCRC "
                + "WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "'")) {
            pst.executeUpdate();
            pRESPOSTA_EXCLUSÃO_prontuario = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_EXCLUSÃO_prontuario = "Não";
            Logger.getLogger(ControleInternoCrc.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    // Confirmar como "Sim" caso o CRC utile o registro feito na PORTARIA.
    public ProntuarioCrc confirmarRegInternoCrc(ProntuarioCrc objProCrc) {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADAPORTARIA SET ConfirmaEntrada=? "
                + "WHERE NomeInternoCrc='" + objProCrc.getNomeInterno() + "' "
                + "AND confirmaEntrada='" + confirmaEntrada + "'")) {
            pst.setString(1, objProCrc.getConfirmaEntrada());
            pst.executeUpdate();
            pRESPONSTA_CRC_update = "Sim";
        } catch (SQLException ex) {
            pRESPONSTA_CRC_update = "Não";
            Logger.getLogger(ControleInternoCrc.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return objProCrc;
    }

    public ProntuarioFisicosPenaisInternos confirmarCadastroInterno(ProntuarioFisicosPenaisInternos pPront) {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES SET TransConf=? "
                + "WHERE NomeInternoCrc='" + pPront.getNomeInterno() + "' "
                + "AND MaeInternoCrc='" + pPront.getMaeInterno() + "'")) {
            pst.setString(1, pPront.getTransConf());
            pst.executeUpdate();
            pRESPOSTA_gravacao = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA_gravacao = "Não";
            Logger.getLogger(ControleInternoCrc.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return pPront;
    }

    // Pesquisa CIDADE (NATURALIDADE)
    public void PESQUISAR_cidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdCidade, "
                    + "NomeCidade "
                    + "FROM CIDADES "
                    + "WHERE NomeCidade='" + nome + "'");
            conecta.rs.first();
            codCidade = conecta.rs.getInt("IdCidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // Pesquisar PAIS (NACIONALIDADE)
    public void PESQUISAR_paises(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPais, "
                    + "NomePais "
                    + "FROM PAISES "
                    + "WHERE NomePais='" + nome + "'");
            conecta.rs.first();
            codPais = conecta.rs.getInt("IdPais");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public ProntuarioFisicosPenaisInternos pPESQUISA_EXISTENCIA_interno(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "NomeInternoCrc, "
                    + "MaeInternoCrc "
                    + "FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + jNomeInterno.getText().trim() + "' "
                    + "AND MaeInternoCrc='" + jMaeInterno.getText().trim() + "'");
            conecta.rs.first();
            nomeInternoCrc = conecta.rs.getString("NomeInternoCrc");
            nomeMaeInterno = conecta.rs.getString("MaeInternoCrc");
            conecta.desconecta();
        } catch (SQLException e) {
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }

    public ProntuarioFisicosPenaisInternos pPESQUISA_ENTRADA_LOTE_interno(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc "
                    + "FROM ITENSENTRADA "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            codInternoCrc = conecta.rs.getString("IdInternoCrc");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }

    public ProntuarioFisicosPenaisInternos pPESQUISA_CODIGO_interno(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc "
                    + "FROM PRONTUARIOSCRC");
            conecta.rs.last();
            jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel identificar o número do prontuario... \nERRO: " + e);
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }

    public ProntuarioFisicosPenaisInternos pPESQUISA_INTERNO_portaria(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "NomeInternoCrc "
                    + "FROM ITENSENTRADAPORTARIA "
                    + "WHERE NomeInternoCrc='" + jNomeInterno.getText() + "'");
            conecta.rs.first();
            nomeInterno = conecta.rs.getString("NomeInternoCrc");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }

    public ProntuarioFisicosPenaisInternos CONSULTAR_PARAMETROS_crc(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "EntradasPortaria "
                    + "FROM PARAMETROSCRC");
            conecta.rs.first();
            codParametrosEntrada = conecta.rs.getString("EntradasPortaria");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }

    public ProntuarioFisicosPenaisInternos LOCALIZAR_DADOS_PENAIS_interno(ProntuarioFisicosPenaisInternos objFisicoPenaisInternos) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdInternoCrc "
                    + "FROM DADOSPENAISINTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
            conecta.rs.first();
            CODIGO_INTERNO_TABELA_penal = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objFisicoPenaisInternos;
    }
}
