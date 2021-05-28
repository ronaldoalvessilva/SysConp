/*
DATA: 05/04/2021
AUTOR: RONALDO ALVES DA SILVA
VERS�O: 6.3.4.2021
*/

-- CANCELAMENTO DE EVAS�O DE INTERNOS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CANCELAMENTO_EVASAO_INTERNOS'))
	CREATE TABLE CANCELAMENTO_EVASAO_INTERNOS
	(
	IdCancelaEvasao INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusRegistro VARCHAR(30) NULL,
	DataRegistro DATETIME NULL,
	TipoOperacaoCancelar INT NULL,
	NomeResponsavel VARCHAR(200) NULL,
	CargoResponsavel VARCHAR(100) NULL,
	NumeroDocumentoCancela VARCHAR(100) NULL,
	DataCancelamento DATETIME NULL,
	IdLanc INT FOREIGN KEY REFERENCES EVADIDOSIND(IdLanc) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	MotivoCancelamento VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


	-- PAR�METRO PARA GERAR POPULA��O AUTOM�TICA OU N�O

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PARAMETROSCRC') AND NAME = 'PopulacaoAutomatica')
          ALTER TABLE PARAMETROSCRC ADD PopulacaoAutomatica VARCHAR(5) NULL 

	-- FECHA SISTEMA DIARIAMENTE

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PARAMETROSCRC') AND NAME = 'FecharSistema')
          ALTER TABLE PARAMETROSCRC ADD FecharSistema VARCHAR(5) NULL 

UPDATE PARAMETROSCRC SET PopulacaoAutomatica='N�o',FecharSistema='N�o'

-- CONTROLAR MAIORIDADE PENAL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PARAMETROSCRC') AND NAME = 'ControlaMP')
          ALTER TABLE PARAMETROSCRC ADD ControlaMP VARCHAR(5) NULL 


IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PARAMETROSCRC') AND NAME = 'MaioridadePenal')
          ALTER TABLE PARAMETROSCRC ADD MaioridadePenal INT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PARAMETROSCRC') AND NAME = 'HabilitarAlerta')
          ALTER TABLE PARAMETROSCRC ADD HabilitarAlerta VARCHAR(5) NULL 