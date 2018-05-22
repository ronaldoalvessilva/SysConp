/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import gestor.Modelo.ProntuarioFisicosPenaisInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleExportacaoInterno {

    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ProntuarioFisicosPenaisInternos pPront = new ProntuarioFisicosPenaisInternos();

    // TABELA DO BANCO DE DADOS DE LAURO DE FREITAS.
    public ProntuarioFisicosPenaisInternos incluirProntuarioInternoLF(ProntuarioFisicosPenaisInternos pPront) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                    + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                    + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,TelefoneCrc,Telefone1Crc,CelularCrc,CartaoSus,Cnc,Cutis,Olhos,Cabelos,"
                    + "Barba,Bigode,Nariz,Boca,Rosto,Labios,Camisa,Calca,Sapato,Peso,Altura,Sinais,Orelhas,Pescoco,Compleicao,DataEntrada,DataCrime,DataPrisao,"
                    + "DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,CrimeEdiondo,TerminoPena,Identificador,"
                    + "Identificador1,Identificador2,Identificador3,Perfil,RegiaoCorpo,RegiaoCorpo1,RegiaoCorpo2,DataNovaEntrada,UsuarioInsert,DataInsert,HorarioInsert,DataTrans,TransConf,UnidadeOrigem,UnidadeDestino,ConfirmadoExp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pPront.getMatricula());
            if (pPront.getDataCadast() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(pPront.getDataCadast().getTime()));
            } else {
                pst.setDate(2, null);
            }
            if (pPront.getDataNasci() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(pPront.getDataNasci().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, pPront.getFotoInterno());
            pst.setString(5, pPront.getNomeInterno());
            pst.setString(6, pPront.getMaeInterno());
            pst.setString(7, pPront.getPaiInterno());
            pst.setString(8, pPront.getAlcunha());
            pst.setString(9, pPront.getRgInterno());
            pst.setString(10, pPront.getCpfInterno());
            pst.setString(11, pPront.getEscolaridade());
            pst.setString(12, pPront.getEstadoCivil());
            pst.setString(13, pPront.getSexo());
            pst.setString(14, pPront.getSituacao());
            pst.setString(15, pPront.getReligiao());
            pst.setString(16, pPront.getProfissao());
            pst.setString(17, pPront.getEndereco());
            pst.setString(18, pPront.getBairro());
            pst.setString(19, pPront.getCidade());
            pst.setString(20, pPront.getEstado());
            pst.setString(21, pPront.getTelefone());
            pst.setString(22, pPront.getTelefone1());
            pst.setString(23, pPront.getCelular());
            pst.setString(24, pPront.getCartoaSus());
            pst.setString(25, pPront.getCnc());
            pst.setString(26, pPront.getCutis());
            pst.setString(27, pPront.getOlhos());
            pst.setString(28, pPront.getCabelos());
            pst.setString(29, pPront.getBarba());
            pst.setString(30, pPront.getBigode());
            pst.setString(31, pPront.getNariz());
            pst.setString(32, pPront.getBoca());
            pst.setString(33, pPront.getRosto());
            pst.setString(34, pPront.getLabios());
            pst.setString(35, pPront.getCamisa());
            pst.setString(36, pPront.getCalca());
            pst.setString(37, pPront.getSapato());
            pst.setString(38, pPront.getPeso());
            pst.setString(39, pPront.getAltura());
            pst.setString(40, pPront.getSinais());
            pst.setString(41, pPront.getOrelha());
            pst.setString(42, pPront.getPescoco());
            pst.setString(43, pPront.getCompleicao());
            if (pPront.getDataEntrada() != null) {
                pst.setTimestamp(44, new java.sql.Timestamp(pPront.getDataEntrada().getTime()));
            } else {
                pst.setDate(44, null);
            }
            if (pPront.getDataCrime() != null) {
                pst.setTimestamp(45, new java.sql.Timestamp(pPront.getDataCrime().getTime()));
            } else {
                pst.setDate(45, null);
            }
            if (pPront.getDataPrisao() != null) {
                pst.setTimestamp(46, new java.sql.Timestamp(pPront.getDataPrisao().getTime()));
            } else {
                pst.setDate(46, null);
            }
            if (pPront.getDataCondenacao() != null) {
                pst.setTimestamp(47, new java.sql.Timestamp(pPront.getDataCondenacao().getTime()));
            } else {
                pst.setDate(47, null);
            }
            pst.setString(48, pPront.getParticipacao());
            pst.setString(49, pPront.getRegime());
            pst.setString(50, pPront.getPena());
            pst.setString(51, pPront.getArtigo1());
            pst.setString(52, pPront.getArtigo2());
            pst.setString(53, pPront.getArtigo3());
            pst.setString(54, pPront.getParagrafo1());
            pst.setString(55, pPront.getParagrafo2());
            pst.setString(56, pPront.getParagrafo3());
            pst.setString(57, pPront.getCrimeEdiondo());
            if (pPront.getTerminoPena() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(pPront.getTerminoPena().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, pPront.getIdentificador());
            pst.setString(60, pPront.getIdentificador1());
            pst.setString(61, pPront.getIdentificador2());
            pst.setString(62, pPront.getIdentificador3());
            if (pPront.getPerfil() != null) {
                pst.setString(63, pPront.getPerfil());
            } else {
                pst.setString(63, null);
            }
            if (pPront.getRegiaoCorpo() != null) {
                pst.setString(64, pPront.getRegiaoCorpo());
            } else {
                pst.setString(64, null);
            }
            if (pPront.getRegiaoCorpo1() != null) {
                pst.setString(65, pPront.getRegiaoCorpo1());
            } else {
                pst.setString(65, null);
            }
            if (pPront.getRegiaoCorpo2() != null) {
                pst.setString(66, pPront.getRegiaoCorpo2());
            } else {
                pst.setString(66, null);
            }
            if (pPront.getDataNovaEntrada() != null) {
                pst.setTimestamp(67, new java.sql.Timestamp(pPront.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(67, null);
            }
            pst.setString(68, pPront.getUsuarioInsert());
            pst.setString(69, pPront.getDataInsert());
            pst.setString(70, pPront.getHoraInsert());
            if (pPront.getDataTrans() != null) {
                pst.setTimestamp(71, new java.sql.Timestamp(pPront.getDataTrans().getTime()));
            } else {
                pst.setDate(71, null);
            }
            pst.setString(72, pPront.getTransConf());
            pst.setString(73, pPront.getUnidadeOrigem());
            pst.setString(74, pPront.getUnidadeDestino());
            pst.setString(75, pPront.getConfirmaExp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return pPront;
    }

    // TABELA DO BANCO DE DADOS DE ITABUNA
    public ProntuarioFisicosPenaisInternos incluirProntuarioInternoITB(ProntuarioFisicosPenaisInternos pPront) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                    + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                    + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,TelefoneCrc,Telefone1Crc,CelularCrc,CartaoSus,Cnc,Cutis,Olhos,Cabelos,"
                    + "Barba,Bigode,Nariz,Boca,Rosto,Labios,Camisa,Calca,Sapato,Peso,Altura,Sinais,Orelhas,Pescoco,Compleicao,DataEntrada,DataCrime,DataPrisao,"
                    + "DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,CrimeEdiondo,TerminoPena,Identificador,"
                    + "Identificador1,Identificador2,Identificador3,Perfil,RegiaoCorpo,RegiaoCorpo1,RegiaoCorpo2,DataNovaEntrada,UsuarioInsert,DataInsert,HorarioInsert,DataTrans,TransConf,UnidadeOrigem,UnidadeDestino,ConfirmadoExp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pPront.getMatricula());
            if (pPront.getDataCadast() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(pPront.getDataCadast().getTime()));
            } else {
                pst.setDate(2, null);
            }
            if (pPront.getDataNasci() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(pPront.getDataNasci().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, pPront.getFotoInterno());
            pst.setString(5, pPront.getNomeInterno());
            pst.setString(6, pPront.getMaeInterno());
            pst.setString(7, pPront.getPaiInterno());
            pst.setString(8, pPront.getAlcunha());
            pst.setString(9, pPront.getRgInterno());
            pst.setString(10, pPront.getCpfInterno());
            pst.setString(11, pPront.getEscolaridade());
            pst.setString(12, pPront.getEstadoCivil());
            pst.setString(13, pPront.getSexo());
            pst.setString(14, pPront.getSituacao());
            pst.setString(15, pPront.getReligiao());
            pst.setString(16, pPront.getProfissao());
            pst.setString(17, pPront.getEndereco());
            pst.setString(18, pPront.getBairro());
            pst.setString(19, pPront.getCidade());
            pst.setString(20, pPront.getEstado());
            pst.setString(21, pPront.getTelefone());
            pst.setString(22, pPront.getTelefone1());
            pst.setString(23, pPront.getCelular());
            pst.setString(24, pPront.getCartoaSus());
            pst.setString(25, pPront.getCnc());
            pst.setString(26, pPront.getCutis());
            pst.setString(27, pPront.getOlhos());
            pst.setString(28, pPront.getCabelos());
            pst.setString(29, pPront.getBarba());
            pst.setString(30, pPront.getBigode());
            pst.setString(31, pPront.getNariz());
            pst.setString(32, pPront.getBoca());
            pst.setString(33, pPront.getRosto());
            pst.setString(34, pPront.getLabios());
            pst.setString(35, pPront.getCamisa());
            pst.setString(36, pPront.getCalca());
            pst.setString(37, pPront.getSapato());
            pst.setString(38, pPront.getPeso());
            pst.setString(39, pPront.getAltura());
            pst.setString(40, pPront.getSinais());
            pst.setString(41, pPront.getOrelha());
            pst.setString(42, pPront.getPescoco());
            pst.setString(43, pPront.getCompleicao());
            if (pPront.getDataEntrada() != null) {
                pst.setTimestamp(44, new java.sql.Timestamp(pPront.getDataEntrada().getTime()));
            } else {
                pst.setDate(44, null);
            }
            if (pPront.getDataCrime() != null) {
                pst.setTimestamp(45, new java.sql.Timestamp(pPront.getDataCrime().getTime()));
            } else {
                pst.setDate(45, null);
            }
            if (pPront.getDataPrisao() != null) {
                pst.setTimestamp(46, new java.sql.Timestamp(pPront.getDataPrisao().getTime()));
            } else {
                pst.setDate(46, null);
            }
            if (pPront.getDataCondenacao() != null) {
                pst.setTimestamp(47, new java.sql.Timestamp(pPront.getDataCondenacao().getTime()));
            } else {
                pst.setDate(47, null);
            }
            pst.setString(48, pPront.getParticipacao());
            pst.setString(49, pPront.getRegime());
            pst.setString(50, pPront.getPena());
            pst.setString(51, pPront.getArtigo1());
            pst.setString(52, pPront.getArtigo2());
            pst.setString(53, pPront.getArtigo3());
            pst.setString(54, pPront.getParagrafo1());
            pst.setString(55, pPront.getParagrafo2());
            pst.setString(56, pPront.getParagrafo3());
            pst.setString(57, pPront.getCrimeEdiondo());
            if (pPront.getTerminoPena() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(pPront.getTerminoPena().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, pPront.getIdentificador());
            pst.setString(60, pPront.getIdentificador1());
            pst.setString(61, pPront.getIdentificador2());
            pst.setString(62, pPront.getIdentificador3());
            if (pPront.getPerfil() != null) {
                pst.setString(63, pPront.getPerfil());
            } else {
                pst.setString(63, null);
            }
            if (pPront.getRegiaoCorpo() != null) {
                pst.setString(64, pPront.getRegiaoCorpo());
            } else {
                pst.setString(64, null);
            }
            if (pPront.getRegiaoCorpo1() != null) {
                pst.setString(65, pPront.getRegiaoCorpo1());
            } else {
                pst.setString(65, null);
            }
            if (pPront.getRegiaoCorpo2() != null) {
                pst.setString(66, pPront.getRegiaoCorpo2());
            } else {
                pst.setString(66, null);
            }
            if (pPront.getDataNovaEntrada() != null) {
                pst.setTimestamp(67, new java.sql.Timestamp(pPront.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(67, null);
            }
            pst.setString(68, pPront.getUsuarioInsert());
            pst.setString(69, pPront.getDataInsert());
            pst.setString(70, pPront.getHoraInsert());
            if (pPront.getDataTrans() != null) {
                pst.setTimestamp(71, new java.sql.Timestamp(pPront.getDataTrans().getTime()));
            } else {
                pst.setDate(71, null);
            }
            pst.setString(72, pPront.getTransConf());
            pst.setString(73, pPront.getUnidadeOrigem());
            pst.setString(74, pPront.getUnidadeDestino());
            pst.setString(75, pPront.getConfirmaExp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return pPront;
    }
    // TABELA DE DADOS DE VITÓRIA DA CONQUISTA

    public ProntuarioFisicosPenaisInternos incluirProntuarioInternoVC(ProntuarioFisicosPenaisInternos pPront) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                    + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                    + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,TelefoneCrc,Telefone1Crc,CelularCrc,CartaoSus,Cnc,Cutis,Olhos,Cabelos,"
                    + "Barba,Bigode,Nariz,Boca,Rosto,Labios,Camisa,Calca,Sapato,Peso,Altura,Sinais,Orelhas,Pescoco,Compleicao,DataEntrada,DataCrime,DataPrisao,"
                    + "DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,CrimeEdiondo,TerminoPena,Identificador,"
                    + "Identificador1,Identificador2,Identificador3,Perfil,RegiaoCorpo,RegiaoCorpo1,RegiaoCorpo2,DataNovaEntrada,UsuarioInsert,DataInsert,HorarioInsert,DataTrans,TransConf,UnidadeOrigem,UnidadeDestino,ConfirmadoExp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pPront.getMatricula());
            if (pPront.getDataCadast() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(pPront.getDataCadast().getTime()));
            } else {
                pst.setDate(2, null);
            }
            if (pPront.getDataNasci() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(pPront.getDataNasci().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, pPront.getFotoInterno());
            pst.setString(5, pPront.getNomeInterno());
            pst.setString(6, pPront.getMaeInterno());
            pst.setString(7, pPront.getPaiInterno());
            pst.setString(8, pPront.getAlcunha());
            pst.setString(9, pPront.getRgInterno());
            pst.setString(10, pPront.getCpfInterno());
            pst.setString(11, pPront.getEscolaridade());
            pst.setString(12, pPront.getEstadoCivil());
            pst.setString(13, pPront.getSexo());
            pst.setString(14, pPront.getSituacao());
            pst.setString(15, pPront.getReligiao());
            pst.setString(16, pPront.getProfissao());
            pst.setString(17, pPront.getEndereco());
            pst.setString(18, pPront.getBairro());
            pst.setString(19, pPront.getCidade());
            pst.setString(20, pPront.getEstado());
            pst.setString(21, pPront.getTelefone());
            pst.setString(22, pPront.getTelefone1());
            pst.setString(23, pPront.getCelular());
            pst.setString(24, pPront.getCartoaSus());
            pst.setString(25, pPront.getCnc());
            pst.setString(26, pPront.getCutis());
            pst.setString(27, pPront.getOlhos());
            pst.setString(28, pPront.getCabelos());
            pst.setString(29, pPront.getBarba());
            pst.setString(30, pPront.getBigode());
            pst.setString(31, pPront.getNariz());
            pst.setString(32, pPront.getBoca());
            pst.setString(33, pPront.getRosto());
            pst.setString(34, pPront.getLabios());
            pst.setString(35, pPront.getCamisa());
            pst.setString(36, pPront.getCalca());
            pst.setString(37, pPront.getSapato());
            pst.setString(38, pPront.getPeso());
            pst.setString(39, pPront.getAltura());
            pst.setString(40, pPront.getSinais());
            pst.setString(41, pPront.getOrelha());
            pst.setString(42, pPront.getPescoco());
            pst.setString(43, pPront.getCompleicao());
            if (pPront.getDataEntrada() != null) {
                pst.setTimestamp(44, new java.sql.Timestamp(pPront.getDataEntrada().getTime()));
            } else {
                pst.setDate(44, null);
            }
            if (pPront.getDataCrime() != null) {
                pst.setTimestamp(45, new java.sql.Timestamp(pPront.getDataCrime().getTime()));
            } else {
                pst.setDate(45, null);
            }
            if (pPront.getDataPrisao() != null) {
                pst.setTimestamp(46, new java.sql.Timestamp(pPront.getDataPrisao().getTime()));
            } else {
                pst.setDate(46, null);
            }
            if (pPront.getDataCondenacao() != null) {
                pst.setTimestamp(47, new java.sql.Timestamp(pPront.getDataCondenacao().getTime()));
            } else {
                pst.setDate(47, null);
            }
            pst.setString(48, pPront.getParticipacao());
            pst.setString(49, pPront.getRegime());
            pst.setString(50, pPront.getPena());
            pst.setString(51, pPront.getArtigo1());
            pst.setString(52, pPront.getArtigo2());
            pst.setString(53, pPront.getArtigo3());
            pst.setString(54, pPront.getParagrafo1());
            pst.setString(55, pPront.getParagrafo2());
            pst.setString(56, pPront.getParagrafo3());
            pst.setString(57, pPront.getCrimeEdiondo());
            if (pPront.getTerminoPena() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(pPront.getTerminoPena().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, pPront.getIdentificador());
            pst.setString(60, pPront.getIdentificador1());
            pst.setString(61, pPront.getIdentificador2());
            pst.setString(62, pPront.getIdentificador3());
            if (pPront.getPerfil() != null) {
                pst.setString(63, pPront.getPerfil());
            } else {
                pst.setString(63, null);
            }
            if (pPront.getRegiaoCorpo() != null) {
                pst.setString(64, pPront.getRegiaoCorpo());
            } else {
                pst.setString(64, null);
            }
            if (pPront.getRegiaoCorpo1() != null) {
                pst.setString(65, pPront.getRegiaoCorpo1());
            } else {
                pst.setString(65, null);
            }
            if (pPront.getRegiaoCorpo2() != null) {
                pst.setString(66, pPront.getRegiaoCorpo2());
            } else {
                pst.setString(66, null);
            }
            if (pPront.getDataNovaEntrada() != null) {
                pst.setTimestamp(67, new java.sql.Timestamp(pPront.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(67, null);
            }
            pst.setString(68, pPront.getUsuarioInsert());
            pst.setString(69, pPront.getDataInsert());
            pst.setString(70, pPront.getHoraInsert());
            if (pPront.getDataTrans() != null) {
                pst.setTimestamp(71, new java.sql.Timestamp(pPront.getDataTrans().getTime()));
            } else {
                pst.setDate(71, null);
            }
            pst.setString(72, pPront.getTransConf());
            pst.setString(73, pPront.getUnidadeOrigem());
            pst.setString(74, pPront.getUnidadeDestino());
            pst.setString(75, pPront.getConfirmaExp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return pPront;
    }
    // TABELA DO BANCO DE DADOS DE SALVADOR

    public ProntuarioFisicosPenaisInternos incluirProntuarioInternoSSA(ProntuarioFisicosPenaisInternos pPront) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES (MatriculaCrc,DataCadastCrc,DataNasciCrc,"
                    + "FotoInternoCrc,NomeInternoCrc,MaeInternoCrc,PaiInternoCrc,AlcunhaCrc,RgInternoCrc,CpfInternoCrc,EscolaridadeCrc,EstadoCivilCrc,SexoCrc,"
                    + "SituacaoCrc,ReligiaoCrc,ProfissaoCrc,EnderecoCrc,BairroCrc,CidadeCrc,EstadoCrc,TelefoneCrc,Telefone1Crc,CelularCrc,CartaoSus,Cnc,Cutis,Olhos,Cabelos,"
                    + "Barba,Bigode,Nariz,Boca,Rosto,Labios,Camisa,Calca,Sapato,Peso,Altura,Sinais,Orelhas,Pescoco,Compleicao,DataEntrada,DataCrime,DataPrisao,"
                    + "DataCondenacao,Participacao,Regime,Pena,Artigo1,Artigo2,Artigo3,Paragrafo1,Paragrafo2,Paragrafo3,CrimeEdiondo,TerminoPena,Identificador,"
                    + "Identificador1,Identificador2,Identificador3,Perfil,RegiaoCorpo,RegiaoCorpo1,RegiaoCorpo2,DataNovaEntrada,UsuarioInsert,DataInsert,HorarioInsert,DataTrans,TransConf,UnidadeOrigem,UnidadeDestino,ConfirmadoExp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, pPront.getMatricula());
            if (pPront.getDataCadast() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(pPront.getDataCadast().getTime()));
            } else {
                pst.setDate(2, null);
            }
            if (pPront.getDataNasci() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(pPront.getDataNasci().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, pPront.getFotoInterno());
            pst.setString(5, pPront.getNomeInterno());
            pst.setString(6, pPront.getMaeInterno());
            pst.setString(7, pPront.getPaiInterno());
            pst.setString(8, pPront.getAlcunha());
            pst.setString(9, pPront.getRgInterno());
            pst.setString(10, pPront.getCpfInterno());
            pst.setString(11, pPront.getEscolaridade());
            pst.setString(12, pPront.getEstadoCivil());
            pst.setString(13, pPront.getSexo());
            pst.setString(14, pPront.getSituacao());
            pst.setString(15, pPront.getReligiao());
            pst.setString(16, pPront.getProfissao());
            pst.setString(17, pPront.getEndereco());
            pst.setString(18, pPront.getBairro());
            pst.setString(19, pPront.getCidade());
            pst.setString(20, pPront.getEstado());
            pst.setString(21, pPront.getTelefone());
            pst.setString(22, pPront.getTelefone1());
            pst.setString(23, pPront.getCelular());
            pst.setString(24, pPront.getCartoaSus());
            pst.setString(25, pPront.getCnc());
            pst.setString(26, pPront.getCutis());
            pst.setString(27, pPront.getOlhos());
            pst.setString(28, pPront.getCabelos());
            pst.setString(29, pPront.getBarba());
            pst.setString(30, pPront.getBigode());
            pst.setString(31, pPront.getNariz());
            pst.setString(32, pPront.getBoca());
            pst.setString(33, pPront.getRosto());
            pst.setString(34, pPront.getLabios());
            pst.setString(35, pPront.getCamisa());
            pst.setString(36, pPront.getCalca());
            pst.setString(37, pPront.getSapato());
            pst.setString(38, pPront.getPeso());
            pst.setString(39, pPront.getAltura());
            pst.setString(40, pPront.getSinais());
            pst.setString(41, pPront.getOrelha());
            pst.setString(42, pPront.getPescoco());
            pst.setString(43, pPront.getCompleicao());
            if (pPront.getDataEntrada() != null) {
                pst.setTimestamp(44, new java.sql.Timestamp(pPront.getDataEntrada().getTime()));
            } else {
                pst.setDate(44, null);
            }
            if (pPront.getDataCrime() != null) {
                pst.setTimestamp(45, new java.sql.Timestamp(pPront.getDataCrime().getTime()));
            } else {
                pst.setDate(45, null);
            }
            if (pPront.getDataPrisao() != null) {
                pst.setTimestamp(46, new java.sql.Timestamp(pPront.getDataPrisao().getTime()));
            } else {
                pst.setDate(46, null);
            }
            if (pPront.getDataCondenacao() != null) {
                pst.setTimestamp(47, new java.sql.Timestamp(pPront.getDataCondenacao().getTime()));
            } else {
                pst.setDate(47, null);
            }
            pst.setString(48, pPront.getParticipacao());
            pst.setString(49, pPront.getRegime());
            pst.setString(50, pPront.getPena());
            pst.setString(51, pPront.getArtigo1());
            pst.setString(52, pPront.getArtigo2());
            pst.setString(53, pPront.getArtigo3());
            pst.setString(54, pPront.getParagrafo1());
            pst.setString(55, pPront.getParagrafo2());
            pst.setString(56, pPront.getParagrafo3());
            pst.setString(57, pPront.getCrimeEdiondo());
            if (pPront.getTerminoPena() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(pPront.getTerminoPena().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, pPront.getIdentificador());
            pst.setString(60, pPront.getIdentificador1());
            pst.setString(61, pPront.getIdentificador2());
            pst.setString(62, pPront.getIdentificador3());
            if (pPront.getPerfil() != null) {
                pst.setString(63, pPront.getPerfil());
            } else {
                pst.setString(63, null);
            }
            if (pPront.getRegiaoCorpo() != null) {
                pst.setString(64, pPront.getRegiaoCorpo());
            } else {
                pst.setString(64, null);
            }
            if (pPront.getRegiaoCorpo1() != null) {
                pst.setString(65, pPront.getRegiaoCorpo1());
            } else {
                pst.setString(65, null);
            }
            if (pPront.getRegiaoCorpo2() != null) {
                pst.setString(66, pPront.getRegiaoCorpo2());
            } else {
                pst.setString(66, null);
            }
            if (pPront.getDataNovaEntrada() != null) {
                pst.setTimestamp(67, new java.sql.Timestamp(pPront.getDataNovaEntrada().getTime()));
            } else {
                pst.setDate(67, null);
            }
            pst.setString(68, pPront.getUsuarioInsert());
            pst.setString(69, pPront.getDataInsert());
            pst.setString(70, pPront.getHoraInsert());
            if (pPront.getDataTrans() != null) {
                pst.setTimestamp(71, new java.sql.Timestamp(pPront.getDataTrans().getTime()));
            } else {
                pst.setDate(71, null);
            }
            pst.setString(72, pPront.getTransConf());
            pst.setString(73, pPront.getUnidadeOrigem());
            pst.setString(74, pPront.getUnidadeDestino());
            pst.setString(75, pPront.getConfirmaExp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return pPront;
    }
}
