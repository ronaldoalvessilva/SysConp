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