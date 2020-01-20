-- VERS�O 6.1.0 - SISCONP

-- ORGANOGRAMADO CRIME
-- DATA: 02/10/2019

USE DB_SOCIALIZA_CPMS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ORGANOGRAMA_CRIME'))
	CREATE TABLE ORGANOGRAMA_CRIME
	(
	IdOrg INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusOrg VARCHAR(30) NULL,  
	DataOrg DATETIME NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,
	Faccao VARCHAR(200) NULL,
	IdPav INT FOREIGN KEY REFERENCES PAVILHAO(IdPav) NOT NULL,
	IdCela INT FOREIGN KEY REFERENCES CELAS(IdCela) NOT NULL,
	Recompensa REAL NULL,
	SituacaoRegistro VARCHAR(30) NULL,
	ObservacaoFrente VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- NIVEL 1

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L1A_ORGANOGRAMA_CRIME'))
	CREATE TABLE L1A_ORGANOGRAMA_CRIME
	(
	IdL1A INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,
	Observacao VARCHAR(MAX) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L1B_ORGANOGRAMA_CRIME'))
	CREATE TABLE L1B_ORGANOGRAMA_CRIME
	(
	IdL1B INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,	
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L1C_ORGANOGRAMA_CRIME'))
	CREATE TABLE L1C_ORGANOGRAMA_CRIME
	(
	IdL1C INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,	
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L1D_ORGANOGRAMA_CRIME'))
	CREATE TABLE L1D_ORGANOGRAMA_CRIME
	(
	IdL1D INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,	
	)

-- NIVEL 2

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L2A_ORGANOGRAMA_CRIME'))
	CREATE TABLE L2A_ORGANOGRAMA_CRIME
	(
	IdL2A INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,
	Observacao VARCHAR(MAX) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L2B_ORGANOGRAMA_CRIME'))
	CREATE TABLE L2B_ORGANOGRAMA_CRIME
	(
	IdL2B INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	CartaBaralho VARBINARY(MAX) NULL,		
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L2C_ORGANOGRAMA_CRIME'))
	CREATE TABLE L2C_ORGANOGRAMA_CRIME
	(
	IdL2C INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,	
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('L2D_ORGANOGRAMA_CRIME'))
	CREATE TABLE L2D_ORGANOGRAMA_CRIME
	(
	IdL2D INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdOrg INT FOREIGN KEY REFERENCES ORGANOGRAMA_CRIME(IdOrg) NOT NULL,				
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	CartaBaralho VARBINARY(MAX) NULL,	
	)


-- TIPOS DE TRATAMENTO PSICOLOGICO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('TIPOS_TRATAMENTO_PSICOLOGICO'))
	CREATE TABLE TIPOS_TRATAMENTO_PSICOLOGICO
	(
	IdTipo INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusTipo VARCHAR(7) NULL,
	DataTipo DATETIME NULL,
	DescricaoTipo VARCHAR(300) NULL,
	Texto VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

-- TRATAMENTO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('TRATAMENTO_PSICOLOGICO'))
	CREATE TABLE TRATAMENTO_PSICOLOGICO
	(
	IdTRAT INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusTrat VARCHAR(15) NULL,
	DataTrat DATETIME NULL,
	IdTipo INT FOREIGN KEY REFERENCES TIPOS_TRATAMENTO_PSICOLOGICO(IdTipo) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	ID_REGISTRO_ATEND_EVOL INT NOT NULL,
	DataInicio DATETIME NULL,
	DataTermino DATETIME NULL,
	TextoTratamento VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

-- LISTA DE PASSAGEM DE INTERNOS COM PULSEIRA ELETRONICA. - TERAPIA OCUPACIONLA/PORTARIA INTERNA

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSAGENDALABORATIVA') AND NAME = 'Pulseira')
   ALTER TABLE ITENSAGENDALABORATIVA ADD Pulseira VARCHAR(3) NULL

-- LISTA DE INTERNOS SAIDA LABORATIVA NA PORTARIA DA UNIDADE.

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSLABORINTERNO') AND NAME = 'Tornozeleira')
   ALTER TABLE ITENSLABORINTERNO ADD Tornozeleira VARCHAR(3) NULL

   -- CAMPO PARA PRONTUARIOSCRC

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PRONTUARIOSCRC') AND NAME = 'Tornozeleira')
   ALTER TABLE PRONTUARIOSCRC ADD Tornozeleira VARCHAR(13) NULL


-- TABELA DE ASSIST�NCIA EDUCA��O EXTERNA - CAPA

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'IdCurso')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD IdCurso INT NOT NULL

-- SE A FOREIGN KEY N�O EXISITR CRIAR A CHAVE

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
WHERE CONSTRAINT_TYPE = 'FOREIGN KEY' AND TABLE_NAME = 'ASSISTENCIA_EDUCACAO_EXTERNA' 
AND TABLE_SCHEMA ='dbo')
BEGIN
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD CONSTRAINT FK_ASSISTENCIA_EDUCACAO_EXTERNA FOREIGN KEY (IdCurso) REFERENCES CURSOS (IdCurso)
END


-- TABELA DOS DIAS DA SEMANA PARA INSTITUI��ES DE ENSINO EXTERNO


IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaSeg')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaSeg INT NOT NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaTer')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaTer INT NOT NULL   

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaQua')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaQua INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaQui')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaQui INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaSex')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaSex INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaSab')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaSab INT NOT NULL 
   
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ASSISTENCIA_EDUCACAO_EXTERNA') AND NAME = 'DiaDom')
   ALTER TABLE ASSISTENCIA_EDUCACAO_EXTERNA ADD DiaDom INT NOT NULL  	


-- TABELA DE ITENS DE INTERNOS ESTUDANDO


IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaSeg')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaSeg INT NOT NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaTer')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaTer INT NOT NULL   

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaQua')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaQua INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaQui')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaQui INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaSex')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaSex INT NOT NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaSab')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaSab INT NOT NULL 
   
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'DiaDom')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD DiaDom INT NOT NULL  	
	
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSeg')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSeg VARCHAR(5) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraTer')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraTer VARCHAR(5) NULL  

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraQua')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraQua VARCHAR(5) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraQui')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraQui VARCHAR(5) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSex')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSex VARCHAR(5) NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSab')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSab VARCHAR(5) NULL
   
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraDom')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraDom VARCHAR(5) NULL  

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSegEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSegEnt VARCHAR(5) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraTerEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraTerEnt VARCHAR(5) NULL   

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraQuaEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraQuaEnt VARCHAR(5) NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraQuiEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraQuiEnt VARCHAR(5) NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSexEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSexEnt VARCHAR(5) NULL 

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraSabEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraSabEnt VARCHAR(5) NULL 
   
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('INTERNOS_SAIDA_EDUCACIONAL') AND NAME = 'HoraDomEnt')
   ALTER TABLE INTERNOS_SAIDA_EDUCACIONAL ADD HoraDomEnt VARCHAR(5) NULL 
	
		
	
-- TABELAS DE ATIVIDADES COMPLEMENTARES

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_COMPLEMENTARES_PEDAGOGICA'))
	CREATE TABLE ATIVIDADES_COMPLEMENTARES_PEDAGOGICA
	(
	IdAC INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusAC VARCHAR(15) NULL,
	DataAC DATETIME NULL,
	IdCod INT FOREIGN KEY REFERENCES INSTITUICAOESCOLAR(IdCod) NOT NULL,
	IdProf INT FOREIGN KEY REFERENCES PROFESSORES(IdProf) NOT NULL,	
	CargaHoraria VARCHAR(6) NULL,
	TurnoAtividade VARCHAR(80) NULL,
	Dia2 INT NULL,
	Dia3 INT NULL,
	Dia4 INT NULL,
	Dia5 INT NULL,
	Dia6 INT NULL,
	Dia7 INT NULL,
	Dia8 INT NULL,
	IdCurso INT FOREIGN KEY REFERENCES CURSOS(IdCurso) NOT NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)
	

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA'))
	CREATE TABLE ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA
	(
	IdItemAC INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	IdAC INT FOREIGN KEY REFERENCES ATIVIDADES_COMPLEMENTARES_PEDAGOGICA(IdAC) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	DataInicio DATETIME NULL,
	DataConclusao DATETIME NULL,
	Situacao VARCHAR(80) NULL,
	Avalicao VARCHAR(80) NULL,
	Observacao VARCHAR(MAX) NULL,
	DiaSeg INT NULL,
	DiaTer INT NULL,
	DiaQua INT NULL,
	DiaQui INT NULL,
	DiaSex INT NULL,
	DiaSab INT NULL,
	DiaDom INT NULL,	
	HoraEntSeg VARCHAR(15) NULL,
	HoraEntTer VARCHAR(15) NULL,
	HoraEntQua VARCHAR(15) NULL,
	HoraEntQui VARCHAR(15) NULL,
	HoraEntSex VARCHAR(15) NULL,
	HoraEntSab VARCHAR(15) NULL,
	HoraEntDom VARCHAR(15) NULL,
	HoraSaiSeg VARCHAR(15) NULL,
	HoraSaiTer VARCHAR(15) NULL,
	HoraSaiQua VARCHAR(15) NULL,
	HoraSaiQui VARCHAR(15) NULL,
	HoraSaiSex VARCHAR(15) NULL,
	HoraSaiSab VARCHAR(15) NULL,
	HoraSaiDom VARCHAR(15) NULL,		
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)
	
-- TABELA DE CONTROLE DE FREQU�NCIA DOS CURSOS E ATIVIDADES COMPLEMENTARES DA PEDAGOGIA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA'))
	CREATE TABLE FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA
	(
	IdFAC INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusFAC VARCHAR(15) NULL,
	DataFAC DATETIME NULL,
	IdCurso INT FOREIGN KEY REFERENCES CURSOS(IdCurso) NOT NULL,
	IdProf INT FOREIGN KEY REFERENCES PROFESSORES(IdProf) NOT NULL,	
	CargaHoraria VARCHAR(6) NULL,
	TurnoAtividade VARCHAR(80) NULL,
	Dia2 INT NULL,
	Dia3 INT NULL,
	Dia4 INT NULL,
	Dia5 INT NULL,
	Dia6 INT NULL,
	Dia7 INT NULL,
	Dia8 INT NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)
	

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA'))
	CREATE TABLE ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA
	(
	IdItemFAC INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 	
	IdFAC INT FOREIGN KEY REFERENCES FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA(IdFAC) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	DataEntrada DATETIME NULL,
	HoraEntrada VARCHAR(40) NULL,
	HoraSaida VARCHAR(40) NULL,
	NotaAvalia VARCHAR(40) NULL,
	Frequencia VARCHAR(40) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)
	
	
	
	
	
	
	
	
	