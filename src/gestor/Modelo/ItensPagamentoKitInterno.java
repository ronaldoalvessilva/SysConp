/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class ItensPagamentoKitInterno {

    private int idItem;
    private int idPagto;
    private int idInternoCrc;
    private String nomeInternoCrcKit;
    private int copo;
    private int prato;
    private int colher;
    private int vasilha;
    private int garfo;
    private int absorvente;
    private int bermuda;
    private int lencol;
    private int colchao;
    private int toalha;
    private int camisa;
    private int cueca;
    private int sandalia;
    private int cremeDental;
    private int sabonete;
    private int papelHigienico;
    private int barbeador;
    private int escovaDente;
    private int mostraTodos;
    private int kitInicial;
    private int kitQuinzenal;
    private int tipoEntrada;
    private Date dataEntrega;
    private String horaEntrega;
    private byte[] assinaturaDigital;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int cobertor;
    private int bolaJogo;
    private int calcaoJogo;
    private int camisaJogo;
    private int parMeiao;
    private int desodorante;
    private int sabaoPo;
    private int kitDecimal;
    private int kitMensal; 
    private int kitSemestral;     
    private int kitPersonalizado;

    public ItensPagamentoKitInterno() {
    }

    public ItensPagamentoKitInterno(int idItem, int idPagto, int idInternoCrc, String nomeInternoCrcKit, int copo, int prato, int colher, int vasilha, int garfo, int absorvente, int bermuda, int lencol, int colchao, int toalha, int camisa, int cueca, int sandalia, int cremeDental, int sabonete, int papelHigienico, int barbeador, int escovaDente, int mostraTodos, int kitInicial, int kitQuinzenal, int tipoEntrada, Date dataEntrega, String horaEntrega, byte[] assinaturaDigital, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int cobertor, int bolaJogo, int calcaoJogo, int camisaJogo, int parMeiao, int desodorante, int sabaoPo, int kitDecimal, int kitMensal, int kitSemestral, int kitPersonalizado) {
        this.idItem = idItem;
        this.idPagto = idPagto;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrcKit = nomeInternoCrcKit;
        this.copo = copo;
        this.prato = prato;
        this.colher = colher;
        this.vasilha = vasilha;
        this.garfo = garfo;
        this.absorvente = absorvente;
        this.bermuda = bermuda;
        this.lencol = lencol;
        this.colchao = colchao;
        this.toalha = toalha;
        this.camisa = camisa;
        this.cueca = cueca;
        this.sandalia = sandalia;
        this.cremeDental = cremeDental;
        this.sabonete = sabonete;
        this.papelHigienico = papelHigienico;
        this.barbeador = barbeador;
        this.escovaDente = escovaDente;
        this.mostraTodos = mostraTodos;
        this.kitInicial = kitInicial;
        this.kitQuinzenal = kitQuinzenal;
        this.tipoEntrada = tipoEntrada;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.assinaturaDigital = assinaturaDigital;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.cobertor = cobertor;
        this.bolaJogo = bolaJogo;
        this.calcaoJogo = calcaoJogo;
        this.camisaJogo = camisaJogo;
        this.parMeiao = parMeiao;
        this.desodorante = desodorante;
        this.sabaoPo = sabaoPo;
        this.kitDecimal = kitDecimal;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitPersonalizado = kitPersonalizado;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idPagto
     */
    public int getIdPagto() {
        return idPagto;
    }

    /**
     * @param idPagto the idPagto to set
     */
    public void setIdPagto(int idPagto) {
        this.idPagto = idPagto;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInternoCrcKit
     */
    public String getNomeInternoCrcKit() {
        return nomeInternoCrcKit;
    }

    /**
     * @param nomeInternoCrcKit the nomeInternoCrcKit to set
     */
    public void setNomeInternoCrcKit(String nomeInternoCrcKit) {
        this.nomeInternoCrcKit = nomeInternoCrcKit;
    }

    /**
     * @return the copo
     */
    public int getCopo() {
        return copo;
    }

    /**
     * @param copo the copo to set
     */
    public void setCopo(int copo) {
        this.copo = copo;
    }

    /**
     * @return the prato
     */
    public int getPrato() {
        return prato;
    }

    /**
     * @param prato the prato to set
     */
    public void setPrato(int prato) {
        this.prato = prato;
    }

    /**
     * @return the colher
     */
    public int getColher() {
        return colher;
    }

    /**
     * @param colher the colher to set
     */
    public void setColher(int colher) {
        this.colher = colher;
    }

    /**
     * @return the vasilha
     */
    public int getVasilha() {
        return vasilha;
    }

    /**
     * @param vasilha the vasilha to set
     */
    public void setVasilha(int vasilha) {
        this.vasilha = vasilha;
    }

    /**
     * @return the garfo
     */
    public int getGarfo() {
        return garfo;
    }

    /**
     * @param garfo the garfo to set
     */
    public void setGarfo(int garfo) {
        this.garfo = garfo;
    }

    /**
     * @return the absorvente
     */
    public int getAbsorvente() {
        return absorvente;
    }

    /**
     * @param absorvente the absorvente to set
     */
    public void setAbsorvente(int absorvente) {
        this.absorvente = absorvente;
    }

    /**
     * @return the bermuda
     */
    public int getBermuda() {
        return bermuda;
    }

    /**
     * @param bermuda the bermuda to set
     */
    public void setBermuda(int bermuda) {
        this.bermuda = bermuda;
    }

    /**
     * @return the lencol
     */
    public int getLencol() {
        return lencol;
    }

    /**
     * @param lencol the lencol to set
     */
    public void setLencol(int lencol) {
        this.lencol = lencol;
    }

    /**
     * @return the colchao
     */
    public int getColchao() {
        return colchao;
    }

    /**
     * @param colchao the colchao to set
     */
    public void setColchao(int colchao) {
        this.colchao = colchao;
    }

    /**
     * @return the toalha
     */
    public int getToalha() {
        return toalha;
    }

    /**
     * @param toalha the toalha to set
     */
    public void setToalha(int toalha) {
        this.toalha = toalha;
    }

    /**
     * @return the camisa
     */
    public int getCamisa() {
        return camisa;
    }

    /**
     * @param camisa the camisa to set
     */
    public void setCamisa(int camisa) {
        this.camisa = camisa;
    }

    /**
     * @return the cueca
     */
    public int getCueca() {
        return cueca;
    }

    /**
     * @param cueca the cueca to set
     */
    public void setCueca(int cueca) {
        this.cueca = cueca;
    }

    /**
     * @return the sandalia
     */
    public int getSandalia() {
        return sandalia;
    }

    /**
     * @param sandalia the sandalia to set
     */
    public void setSandalia(int sandalia) {
        this.sandalia = sandalia;
    }

    /**
     * @return the cremeDental
     */
    public int getCremeDental() {
        return cremeDental;
    }

    /**
     * @param cremeDental the cremeDental to set
     */
    public void setCremeDental(int cremeDental) {
        this.cremeDental = cremeDental;
    }

    /**
     * @return the sabonete
     */
    public int getSabonete() {
        return sabonete;
    }

    /**
     * @param sabonete the sabonete to set
     */
    public void setSabonete(int sabonete) {
        this.sabonete = sabonete;
    }

    /**
     * @return the papelHigienico
     */
    public int getPapelHigienico() {
        return papelHigienico;
    }

    /**
     * @param papelHigienico the papelHigienico to set
     */
    public void setPapelHigienico(int papelHigienico) {
        this.papelHigienico = papelHigienico;
    }

    /**
     * @return the barbeador
     */
    public int getBarbeador() {
        return barbeador;
    }

    /**
     * @param barbeador the barbeador to set
     */
    public void setBarbeador(int barbeador) {
        this.barbeador = barbeador;
    }

    /**
     * @return the escovaDente
     */
    public int getEscovaDente() {
        return escovaDente;
    }

    /**
     * @param escovaDente the escovaDente to set
     */
    public void setEscovaDente(int escovaDente) {
        this.escovaDente = escovaDente;
    }

    /**
     * @return the mostraTodos
     */
    public int getMostraTodos() {
        return mostraTodos;
    }

    /**
     * @param mostraTodos the mostraTodos to set
     */
    public void setMostraTodos(int mostraTodos) {
        this.mostraTodos = mostraTodos;
    }

    /**
     * @return the kitInicial
     */
    public int getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(int kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitQuinzenal
     */
    public int getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(int kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the tipoEntrada
     */
    public int getTipoEntrada() {
        return tipoEntrada;
    }

    /**
     * @param tipoEntrada the tipoEntrada to set
     */
    public void setTipoEntrada(int tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the horaEntrega
     */
    public String getHoraEntrega() {
        return horaEntrega;
    }

    /**
     * @param horaEntrega the horaEntrega to set
     */
    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    /**
     * @return the assinaturaDigital
     */
    public byte[] getAssinaturaDigital() {
        return assinaturaDigital;
    }

    /**
     * @param assinaturaDigital the assinaturaDigital to set
     */
    public void setAssinaturaDigital(byte[] assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }

    /**
     * @return the cobertor
     */
    public int getCobertor() {
        return cobertor;
    }

    /**
     * @param cobertor the cobertor to set
     */
    public void setCobertor(int cobertor) {
        this.cobertor = cobertor;
    }

    /**
     * @return the bolaJogo
     */
    public int getBolaJogo() {
        return bolaJogo;
    }

    /**
     * @param bolaJogo the bolaJogo to set
     */
    public void setBolaJogo(int bolaJogo) {
        this.bolaJogo = bolaJogo;
    }

    /**
     * @return the calcaoJogo
     */
    public int getCalcaoJogo() {
        return calcaoJogo;
    }

    /**
     * @param calcaoJogo the calcaoJogo to set
     */
    public void setCalcaoJogo(int calcaoJogo) {
        this.calcaoJogo = calcaoJogo;
    }

    /**
     * @return the camisaJogo
     */
    public int getCamisaJogo() {
        return camisaJogo;
    }

    /**
     * @param camisaJogo the camisaJogo to set
     */
    public void setCamisaJogo(int camisaJogo) {
        this.camisaJogo = camisaJogo;
    }

    /**
     * @return the parMeiao
     */
    public int getParMeiao() {
        return parMeiao;
    }

    /**
     * @param parMeiao the parMeiao to set
     */
    public void setParMeiao(int parMeiao) {
        this.parMeiao = parMeiao;
    }

    /**
     * @return the desodorante
     */
    public int getDesodorante() {
        return desodorante;
    }

    /**
     * @param desodorante the desodorante to set
     */
    public void setDesodorante(int desodorante) {
        this.desodorante = desodorante;
    }

    /**
     * @return the sabaoPo
     */
    public int getSabaoPo() {
        return sabaoPo;
    }

    /**
     * @param sabaoPo the sabaoPo to set
     */
    public void setSabaoPo(int sabaoPo) {
        this.sabaoPo = sabaoPo;
    }

    /**
     * @return the kitDecimal
     */
    public int getKitDecimal() {
        return kitDecimal;
    }

    /**
     * @param kitDecimal the kitDecimal to set
     */
    public void setKitDecimal(int kitDecimal) {
        this.kitDecimal = kitDecimal;
    }

    /**
     * @return the kitMensal
     */
    public int getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(int kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public int getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(int kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitPersonalizado
     */
    public int getKitPersonalizado() {
        return kitPersonalizado;
    }

    /**
     * @param kitPersonalizado the kitPersonalizado to set
     */
    public void setKitPersonalizado(int kitPersonalizado) {
        this.kitPersonalizado = kitPersonalizado;
    }
    
}
