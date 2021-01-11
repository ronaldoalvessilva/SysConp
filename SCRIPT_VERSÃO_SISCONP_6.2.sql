/*
DATA: 29/07/2020
AUTOR: RONALDO ALVES DA SILVA
VERS�O: 6.2.0
*/

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CANCELAR_PAGAMENTO_KIT_HIGIENE'))
	CREATE TABLE CANCELAR_PAGAMENTO_KIT_HIGIENE
	(
	IdRegistro INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusRegistro VARCHAR(30) NULL,
	DataRegistro DATETIME NULL,
	IdFunc INT FOREIGN KEY REFERENCES COLABORADOR(IdFunc) NOT NULL,
	IdPav INT FOREIGN KEY REFERENCES PAVILHAO(IdPav) NOT NULL,	
	TipoKit VARCHAR(100) NULL,
	SituacaoInterno VARCHAR(80) NULL,
	IdRegistroComp INT FOREIGN KEY REFERENCES COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE(IdRegistroComp) NOT NULL,
	IdKit INT NULL,
	DataRegistroKit DATETIME NULL,
	MotivoCancelamento VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)
	
IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS'))
	CREATE TABLE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS
	(
	IdItemINT INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegistro INT FOREIGN KEY REFERENCES CANCELAR_PAGAMENTO_KIT_HIGIENE(IdRegistro) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	DataEntrega DATETIME NULL,
	Horario varchar(20) null,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS'))
	CREATE TABLE ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_PRODUTOS
	(
	IdItemPRO INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegistro INT FOREIGN KEY REFERENCES CANCELAR_PAGAMENTO_KIT_HIGIENE(IdRegistro) NOT NULL,	
	IdItemINT INT FOREIGN KEY REFERENCES ITENS_CANCELAR_PAGAMENTO_KIT_HIGIENE_INTERNOS(IdItemINT) NOT NULL,
	IdProd INT FOREIGN KEY REFERENCES PRODUTOS_AC(IdProd) NOT NULL,
	Quantidade FLOAT NULL,
	DataEntrega DATETIME NULL,
	Horario VARCHAR(20) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- SA�DA SIMBOLICA - CRC

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('SAIDA_SIMBOLICA_CRC'))
	CREATE TABLE SAIDA_SIMBOLICA_CRC
	(
	IdRegSaida INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusRegistro VARCHAR(30) NULL,
	DataRegistro DATETIME NULL,	
	Nrdocumento VARCHAR(80) NULL,
	VaraCrime VARCHAR(150) NULL,
	NomeJuiz VARCHAR(150) NULL,
	LocalAudiencia VARCHAR(150) NULL,
	TipoBeneficio VARCHAR(150) NULL,
	MotivoSaida VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_SAIDA_SIMBOLICA_CRC'))
	CREATE TABLE ITENS_SAIDA_SIMBOLICA_CRC
	(
	IdItem INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegSaida INT FOREIGN KEY REFERENCES SAIDA_SIMBOLICA_CRC(IdRegSaida) NOT NULL,	
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	NrdocumentoSA VARCHAR(80) NULL,
	DataRegistroSA DATETIME NULL,	
	TipoBeneficioSA VARCHAR(150) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

--ADICIONAR CAMPOS DE SENHAS PARA SEREM CRIPTOGRAFADAS

ALTER TABLE USUARIOS ALTER COLUMN SenhaUsuario VARCHAR(MAX) NOT NULL
ALTER TABLE USUARIOS ALTER COLUMN ConfirmaSenhaUsuario VARCHAR(MAX) NOT NULL

-- CAMPO DATA PARA CRIA��O DE NOVA SENHA


IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('USUARIOS') AND NAME = 'DataSenha')
           ALTER TABLE USUARIOS ADD DataSenha DATETIME NULL

-- ENTRADAS E SA�DAS COLABORADORES


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ENTRADAS_SAIDAS_COLABORADORES'))
	CREATE TABLE ENTRADAS_SAIDAS_COLABORADORES
	(
	IdRegRegistro INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusRegistro VARCHAR(30) NULL,
	DataRegistro DATETIME NULL,	
	Operacao VARCHAR(80) NULL,
	TipoMovimento VARCHAR(150) NULL,
	UnidadeOrigem VARCHAR(150) NULL,
	UnidadeDestino VARCHAR(150) NULL,
	Motivo VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_ENTRADAS_SAIDAS_COLABORADORES'))
	CREATE TABLE ITENS_ENTRADAS_SAIDAS_COLABORADORES
	(
	IdItem INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegRegistro INT FOREIGN KEY REFERENCES ENTRADAS_SAIDAS_COLABORADORES(IdRegRegistro) NOT NULL,
	IdFunc INT FOREIGN KEY REFERENCES COLABORADOR(IdFunc) NOT NULL,
	DataEvento DATETIME NULL,	
	DataRetorno DATETIME NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


	-- SIGLA DOS NOMES DAS UNIDADES PARA A TRANSFER�NCIA DE COLABORADORES ENTRE AS UNIDADES.

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('UNIDADE_PENAL_EMPRESA') AND NAME = 'Sigla')
           ALTER TABLE UNIDADE_PENAL_EMPRESA ADD Sigla VARCHAR(15) NULL 


--ESCAL DE TRABALHO E FOLGA DOS COLABORADORES - EM (11/11/2020) - ITABUNA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ESCALA_TRABALHO'))
	CREATE TABLE ESCALA_TRABALHO
	(
	IdRegistro INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusEscala VARCHAR(30) NULL,
	DataCadastro DATETIME NULL,
	DescricaoEscala VARCHAR(300) NULL,
	QuantidadeTrab INT NULL,
	QuantidadeFolga INT NULL,
	Turno VARCHAR(80) NULL,
	Turma VARCHAR(80) NULL,
	HorarioInicial VARCHAR(30) NULL,
	HorarioFinal VARCHAR(30) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ESCALA_TRABALHO_FOLGA_COLABORADOR'))
	CREATE TABLE ESCALA_TRABALHO_FOLGA_COLABORADOR
	(
	IdEscala INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegistro INT FOREIGN KEY REFERENCES ESCALA_TRABALHO(IdRegistro) NOT NULL,
	IdFunc INT FOREIGN KEY REFERENCES COLABORADOR(IdFunc) NOT NULL,
	QuantidadeTrab INT NULL,
	QuantidadeFolga INT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- CRONOGRAMA DE ESCALA DE TRABALHO E FOLGA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR'))
	CREATE TABLE CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR
	(
	IdCrono INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegistro INT FOREIGN KEY REFERENCES ESCALA_TRABALHO(IdRegistro) NOT NULL,
	IdEscala INT FOREIGN KEY REFERENCES ESCALA_TRABALHO_FOLGA_COLABORADOR(IdEscala) NOT NULL,
	IdFunc INT FOREIGN KEY REFERENCES COLABORADOR(IdFunc) NOT NULL,
	DataCronograma DATETIME NULL,
	StatusTrabFolga VARCHAR(80) NULL,
	DataInicial DATETIME NULL,
	DataFinal DATETIME NULL,	
	DataPrimeiraFolga DATETIME NULL,
	PrimeiroApt VARCHAR(50) NULL,
	SegundoApt VARCHAR(50) NULL,
	MesReferencia VARCHAR(50) NULL,
	AnoReferencia VARCHAR(10) NULL,
	TipoCronograma VARCHAR(30) NULL,
	Motivo VARCHAR(MAX) NULL,
	)

-- CAMPO PARA KIT PERSONALIZADO

	IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PAGAMENTO_KIT_INTERNOS') AND NAME = 'kitPersonalizado')
           ALTER TABLE PAGAMENTO_KIT_INTERNOS ADD kitPersonalizado VARCHAR(15) NULL 

-- PARENTESCO DO INTERNO NO ROL



	IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSROL') AND NAME = 'ParentescoVisita')
           ALTER TABLE ITENSROL ADD ParentescoVisita VARCHAR(100) NULL 


-- TABELA IMPLEMENTA��O DE FUNCIONALIDADES DO SISTEMA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('IMPLEMENTACAO_SISTEMA'))
	CREATE TABLE IMPLEMENTACAO_SISTEMA
	(
	IdImp INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdModulo INT FOREIGN KEY REFERENCES MODULOS(IdModulo) NOT NULL,
	IdTelas INT FOREIGN KEY REFERENCES TELAS(IdTelas) NOT NULL,
	IdPar INT FOREIGN KEY REFERENCES PARAMETROSCRC (Idpar) NOT NULL,
	Habilitar VARCHAR(15) NULL,
	)

--SCRIPT ACIMA, FOI RODADO EM TODOS OS BANCOS DE DADOS DE PRODU��O DAS UNIDADES EM 17/12/2020

-- CRIA��O DO M�DULO ARMAS E EPIS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('GRUPO_ARMAS'))
	CREATE TABLE GRUPO_ARMAS
	(
	IdGrupoArm INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusGrupoArma  VARCHAR(80) NULL,
	DataCadastro DATETIME NULL,
	DescricaoGrupoArma VARCHAR(250) NULL,
	Obsercacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- GRUPO DE EPI�s

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('GRUPO_EPIs'))
	CREATE TABLE GRUPO_EPIs
	(
	IdGrupoEPI INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusEPI  VARCHAR(80) NULL,
	DataCadastro DATETIME NULL,
	DescricaoGrupoEPI VARCHAR(250) NULL,
	Obsercacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA ACESS�RIOS ARMAS E EPI�s

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ACESSORIOS_ARMA_EPIs'))
	CREATE TABLE ACESSORIOS_ARMA_EPIs
	(
	IdArmaACE INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusACE  VARCHAR(80) NULL,
	DataCadastro DATETIME NULL,
	DescricaoArmaACE VARCHAR(250) NULL,
	Obsercacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA DE ARMAS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ARMAS'))
	CREATE TABLE ARMAS
	(
	IdArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	SerieArma VARCHAR(80) NULL,
	NCMArma VARCHAR(80) NULL,
	DataCadastroArma DATETIME NULL,
	StatusArma VARCHAR(80) NULL,	
	DescricaoArma VARCHAR(250) NULL,
	IdGrupoArm INT FOREIGN KEY REFERENCES GRUPO_ARMAS(IdGrupoArm) NOT NULL,
	MarcaArma VARCHAR(80) NULL,
    ModeloArma VARCHAR(80) NULL,
    CalibreArma VARCHAR(80) NULL,
    CanoArma VARCHAR(80) NULL,
    NumeroTirosArma VARCHAR(50) NULL,
    AcabamentoArma VARCHAR(80) NULL,
    PesoArma VARCHAR(80) NULL,
    MiraArma VARCHAR(80) NULL,
    AlturaArma VARCHAR(80) NULL,
    LarguraArma VARCHAR(80) NULL,
    ComprimentoCanoArma VARCHAR(80) NULL,
    ComprimentoTotalArma VARCHAR(80) NULL,
    DispositivoSegurancaArma VARCHAR(MAX) NULL,
    OutrasCaracteristicasArma VARCHAR(MAX) NULL,
    RegistroArma VARCHAR(80) NULL,
    LicencaArma VARCHAR(80) NULL,
    DataLicencaArma DATETIME NULL,
    UnidadeArma VARCHAR(5) NULL,
    LocalizacaoArma VARCHAR(80) NULL,
    CustoArma REAL NULL,
    EstoqueArma INT NULL,
	FotoArma VARBINARY(MAX) NOT NULL,
	QRCode VARBINARY(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- ACESS�RIOS DA ARMA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ACESSORIOS_ARMA'))
	CREATE TABLE ACESSORIOS_ARMA
	(
	IdAcesArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	IdArmaACE INT FOREIGN KEY REFERENCES ACESSORIOS_ARMA_EPIs(IdArmaACE) NOT NULL,
	Quant INT NOT NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('QRCODE_ARMA'))
	CREATE TABLE QRCODE_ARMA
	(
	IdQrCodeArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	TextoQRCode VARCHAR(MAX) NOT NULL,
	QRCode VARBINARY(MAX) NOT NULL,
	)

-- C�DIGO DE BARRA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CODIGO_BARRA_ARMA'))
	CREATE TABLE CODIGO_BARRA_ARMA
	(
	IdCodigoBarraArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	NumeroSerie VARCHAR(80) NOT NULL,
	CodigoBarra VARBINARY(MAX) NOT NULL,
	)