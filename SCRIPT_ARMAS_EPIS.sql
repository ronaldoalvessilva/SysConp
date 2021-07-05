/*
MODULO CONTROLE DE ARMAS E EPIS DO M�DULO DE SEGUN�A

*/


 --ESSAS NOVAS IMPLEMENTA��ES N�O SER�O APLICADAS AT� A PRESENTE DATA

-- CRIA��O DO M�DULO ARMAS E EPIS


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('GRUPO_ARMAS'))
	CREATE TABLE GRUPO_ARMAS
	(
	IdGrupoArm INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusGrupoArma  VARCHAR(80) NULL,
	DataCadastro DATETIME NULL,
	DescricaoGrupoArma VARCHAR(250) NULL,
	Observacao VARCHAR(MAX) NULL,
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
	Observacao VARCHAR(MAX) NULL,
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
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA DE INVENT�RIO DE ARMAS E EPIS E LOCAL DE ARMAZENAMENTO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('LOCAL_ARMAZENAMENTO_ARMAS_EPI'))
	CREATE TABLE LOCAL_ARMAZENAMENTO_ARMAS_EPI
	(
	IdLocal INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	StatusLocal VARCHAR(20) NULL,
	DescricaoPrincipal VARCHAR(200) NULL,
	DescricaoLocal VARCHAR(200) NULL,
	DescricaoResumida VARCHAR(30) NULL,
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
    --LocalizacaoArma VARCHAR(80) NULL,
	IdLocal INT FOREIGN KEY REFERENCES LOCAL_ARMAZENAMENTO_ARMAS_EPI(IdLocal) NOT NULL,
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
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('QRCODE_ARMA'))
	CREATE TABLE QRCODE_ARMA
	(
	IdQrCodeArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	TextoQRCode VARCHAR(MAX) NOT NULL,
	QRCode VARBINARY(MAX) NOT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- C�DIGO DE BARRA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CODIGO_BARRA_ARMA'))
	CREATE TABLE CODIGO_BARRA_ARMA
	(
	IdCodigoBarraArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	NumeroSerie VARCHAR(80) NOT NULL,
	CodigoBarra VARBINARY(MAX) NOT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- HIST�RICO DE MOVIMENTA��O DE ARMAS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('HISTORICO_ARMA'))
	CREATE TABLE HISTORICO_ARMA
	(
	IdHistArma INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdArma INT FOREIGN KEY REFERENCES ARMAS(IdArma) NOT NULL,
	DataMov DATETIME NULL,
	HoraMov VARBINARY(30) NULL,
	IdFunc INT FOREIGN KEY REFERENCES COLABORADOR(IdFunc) NOT NULL,
	Historico VARBINARY(MAX) NULL,
	Observacao VARBINARY(MAX) NULL,
	)


-- TABELA DE CADASTRO DE EQUIPAMENTOS - EPIS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('EQUIPAMENTOS_SEGURANCA_EPI'))
	CREATE TABLE EQUIPAMENTOS_SEGURANCA_EPI
	(
	IdEquipamento INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	FotoEquipamento VARBINARY(MAX) NULL,
	StatusEquipamento VARCHAR(50) NULL,
	DataCadastroEquipamento DATETIME NULL,
	DescricaoEquipamento VARCHAR(300) NULL,
	Unidade VARCHAR(50) NULL,
	MarcaEquipamento VARCHAR(150) NULL,
	ModeloEquipamento VARCHAR(150) NULL,
	ComprimentoEquipamento VARCHAR(150) NULL,
	TipoMaterialEquipamento VARCHAR(150) NULL,
	PesoEquipamento REAL NULL,
	CorEquipamento VARCHAR(150) NULL,
	Observacao VARCHAR(MAX) NULL,
	CodigoBarras VARBINARY(MAX) NULL,
	QRCode VARBINARY(MAX) NULL,
	NumeroCodigoBarras VARCHAR(80) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('QRCODE_EPI'))
	CREATE TABLE QRCODE_EPI
	(
	IdQrCodeEpi INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdEquipamento INT FOREIGN KEY REFERENCES EQUIPAMENTOS_SEGURANCA_EPI(IdEquipamento) NOT NULL,
	TextoQRCode VARCHAR(MAX) NOT NULL,
	QRCode VARBINARY(MAX) NOT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('CODIGO_BARRA_EPI'))
	CREATE TABLE CODIGO_BARRA_EPI
	(
	IdCodigoBarraEpi INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdEquipamento INT FOREIGN KEY REFERENCES EQUIPAMENTOS_SEGURANCA_EPI(IdEquipamento) NOT NULL,
	NumeroSerie VARCHAR(80) NOT NULL,
	CodigoBarra VARBINARY(MAX) NOT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)
  

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('INVENTARIO_ARMAS_EPI'))
	CREATE TABLE INVENTARIO_ARMAS_EPI
	(
	IdLanc INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	StatusLanc VARCHAR(20) NULL,
	TipoInventario VARCHAR(30) NULL,
	IdLocal INT FOREIGN KEY REFERENCES LOCAL_ARMAZENAMENTO_ARMAS_EPI(IdLocal) NOT NULL,
	Responsavel VARCHAR(250) NULL,
	DataInicio DATE NULL,
	DataTermino DATE NULL,
	HorarioInicio VARCHAR(20) NULL,
	HorarioTermino VARCHAR(20) NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	Modulo VARCHAR(1) NULL,
	)


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_INVENTARIO_ARMAS_EPI'))
	CREATE TABLE ITENS_INVENTARIO_ARMAS_EPI
	(
	IdItem INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	IdLanc INT FOREIGN KEY REFERENCES INVENTARIO_ARMAS_EPI(IdLanc) NOT NULL,
	IdProd INT FOREIGN KEY REFERENCES PRODUTOS_AC(IdProd) NOT NULL,
	IdLocal INT FOREIGN KEY REFERENCES LOCAL_ARMAZENAMENTO_ARMAS_EPI(IdLocal) NOT NULL,
	QtdItem FLOAT NULL,
	ValorCusto MONEY NULL,
	Lote VARCHAR(50) NULL,
	DataLote DATE NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	Modulo VARCHAR(1) NULL,
	)






/*


USE DB_SOCIALIZA_VC
GO

/****** Object:  Table dbo.INVENTARIO_AC    Script DATE: 19/01/2021 14:39:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.INVENTARIO_ARMAS_EPI(
	IdLanc INT IDENTITY(1,1) NOT NULL,
	StatusLanc VARCHAR(20) NULL,
	TipoInventario VARCHAR(30) NULL,
	IdLocal INT NOT NULL,
	Responsavel VARCHAR(250) NULL,
	DataInicio DATE NULL,
	DataTermino DATE NULL,
	HorarioInicio VARCHAR(20) NULL,
	HorarioTermino VARCHAR(20) NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	Modulo VARCHAR(1) NULL,
PRIMARY KEY CLUSTERED 
(
	IdLanc ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON PRIMARY
) ON PRIMARY TEXTIMAGE_ON PRIMARY
GO

ALTER TABLE dbo.INVENTARIO_ARMAS_EPI  WITH CHECK ADD FOREIGN KEY(IdLocal)
REFERENCES dbo.LOCAL_ARMAZENAMENTO_ARMAS_EPI (IdLocal)
GO


USE DB_SOCIALIZA_VC
GO

/****** Object:  Table dbo.ITENS_INVENTARIO_AC    Script DATE: 19/01/2021 14:38:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.ITENS_INVENTARIO_ARMAS_EPI(
	IdItem INT IDENTITY(1,1) NOT NULL,
	IdLanc INT NOT NULL,
	IdProd INT NOT NULL,
	IdLocal INT NOT NULL,
	QtdItem FLOAT NULL,
	ValorCusto MONEY NULL,
	Lote VARCHAR(50) NULL,
	DataLote DATE NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	Modulo VARCHAR(1) NULL,
PRIMARY KEY CLUSTERED 
(
	IdItem ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON PRIMARY
) ON PRIMARY
GO

ALTER TABLE dbo.ITENS_INVENTARIO_ARMAS_EPI  WITH CHECK ADD FOREIGN KEY(IdLanc)
REFERENCES dbo.INVENTARIO_ARMAS_EPI (IdLanc)
GO

ALTER TABLE dbo.ITENS_INVENTARIO_ARMAS_EPI  WITH CHECK ADD FOREIGN KEY(IdLocal)
REFERENCES dbo.LOCAL_ARMAZENAMENTO_ARMAS_EPI (IdLocal)
GO
/*
ALTER TABLE dbo.ITENS_INVENTARIO_ARMAS_EPI  WITH CHECK ADD FOREIGN KEY(IdProd)
REFERENCES dbo.PRODUTOS_AC (IdProd)
*/
GO

*/
