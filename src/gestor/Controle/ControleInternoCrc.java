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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

    public ProntuarioCrc incluirInternoCrc(ProntuarioCrc objProCrc) throws SQLException {

        buscarPaises(objProCrc.getNomePais()); // Pesquisa o ID do PAIS
        buscarCidade(objProCrc.getNomeCidade()); // Pesquisa o ID  da CIDADE        
        conecta.abrirConexao();
        // Incluir Registro na tabela de INTERNOS CRC
        try (
                PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRONTUARIOSCRC (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                        + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                        + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,IdPais,IdCidade,TelefoneCrc,Telefone1Crc,CelularCrc,UsuarioInsert,DataInsert,HorarioInsert,CartaoSus,Cnc,ImagemFrente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
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
            pst.execute();
        }
        conecta.desconecta();
        return objProCrc;
    }

    //Método para Alterar INTERNO CRC
    public ProntuarioCrc alterarInternoCrc(ProntuarioCrc objProCrc) throws SQLException {
        buscarCidade(objProCrc.getNomeCidade()); // Pesquisa o ID  da CIDADE
        buscarPaises(objProCrc.getNomePais()); // Pesquisa o ID do PAIS
        conecta.abrirConexao();
        // Alterar Registro na tabela de INTERNOS CRC
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET MatriculaCrc=?,DataCadastCrc=?,DataNasciCrc=?,"
                + "NomeInternoCrc=?,MaeInternoCrc=?,PaiInternoCrc=?,AlcunhaCrc=?,RgInternoCrc=?,CpfInternoCrc=?,FotoInternoCrc=?,EscolaridadeCrc=?,EstadoCivilCrc=?,SexoCrc=?,"
                + "SituacaoCrc=?,ReligiaoCrc=?,ProfissaoCrc=?,EnderecoCrc=?,BairroCrc=?,CidadeCrc=?,EstadoCrc=?,IdCidade=?,IdPais=?,TelefoneCrc=?,Telefone1Crc=?,CelularCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=?,CartaoSus=?,Cnc=?,ImagemFrente=? WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "'")) {
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
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objProCrc;
    }

    // EXCLUIR registro do INTERNO CRC
    public ProntuarioCrc excluirInternoCrc(ProntuarioCrc objProCrc) throws SQLException {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRONTUARIOSCRC "
                + "WHERE IdInternoCrc='" + objProCrc.getIdInterno() + "'")) {
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objProCrc;
    }

    // Confirmar como "Sim" caso o CRC utile o registro feito na PORTARIA.
    public ProntuarioCrc confirmarRegInternoCrc(ProntuarioCrc objProCrc) throws SQLException {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSENTRADAPORTARIA SET ConfirmaEntrada=? "
                + "WHERE NomeInternoCrc='" + objProCrc.getNomeInterno() + "' "
                + "AND confirmaEntrada='" + confirmaEntrada + "'")) {
            pst.setString(1, objProCrc.getConfirmaEntrada());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objProCrc;
    }
    //ProntuarioFisicosPenaisInternos pPront = new ProntuarioFisicosPenaisInternos();

    public ProntuarioFisicosPenaisInternos confirmarCadastroInterno(ProntuarioFisicosPenaisInternos pPront) throws SQLException {
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES SET TransConf=? "
                + "WHERE NomeInternoCrc='" + pPront.getNomeInterno() + "' "
                + "AND MaeInternoCrc='" + pPront.getMaeInterno() + "'")) {
            pst.setString(1, pPront.getTransConf());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return pPront;
    }

// Pesquisa CIDADE (NATURALIDADE)
    public void buscarCidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CIDADES WHERE NomeCidade='" + nome + "'");
            conecta.rs.first();
            codCidade = conecta.rs.getInt("IdCidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
// Pesquisar PAIS (NACIONALIDADE)

    public void buscarPaises(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAISES WHERE NomePais='" + nome + "'");
            conecta.rs.first();
            codPais = conecta.rs.getInt("IdPais");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
