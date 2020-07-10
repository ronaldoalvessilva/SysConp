/*
-- DATA: 09/06/2020
-- N�O GRAVOU AS TELAS DE ACESSO DA PSICOLOGIA
-- INSERIR MANUALMENTE E DEPOIS SUBSTITUR CORRETAMENTE 

-- VERIFICAR ANTES O BANCO DA UNIDADE PARA VER SE EXISTE


INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Mamnuten��o')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Planejamento')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Internos')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Avalia��o em Grupo')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Avalia��o Individual')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Botao Encerrar')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimenta��o:Atendimento Internos em Grupo:Bot�o Liberar')

-- UPDATE PARA CORRIGIR OS ACESSOS DA PSICOLOGIA

UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Manuten��o' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Mamnuten��o' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Planejamento' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Planejamento' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Internos' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Internos' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Avalia��o em Grupo' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Avalia��o em Grupo' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Avalia��o Individual' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Avalia��o Individual' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Botao Encerrar' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Botao Encerrar' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimenta��o:Atendimento Internos em Grupo - PSI:Bot�o Liberar' WHERE NomeTela='Movimenta��o:Atendimento Internos em Grupo:Bot�o Liberar' AND IdModulo=9

-- N�O SER� NECESS�RIO REALIZAR A INSER��O NEM O UPDATE - ERRO CORRIGDO.

*/

-- CANCELAMENTO DE SA�DA DE INTERNOS TANTO NO CRC BEM COMO PORTARIA INTERNA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('REGISTRO_CANCELADO_SAIDAS'))
	CREATE TABLE REGISTRO_CANCELADO_SAIDAS
	(
	IdRegCancelSA INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusLanc VARCHAR(30) NULL,
	DataLanc DATETIME NULL,
	Motivo VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)
	
IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_REGISTRO_CANCELADO_SAIDAS'))
	CREATE TABLE ITENS_REGISTRO_CANCELADO_SAIDAS
	(
	IdItemSA INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdRegCancelSA INT FOREIGN KEY REFERENCES REGISTRO_CANCELADO_SAIDAS(IdRegCancelSA) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	DataSaida DATETIME NULL,
	HoraSaida VARCHAR(10) NULL,
    TipoSaidaCrcPortaria VARCHAR(80) NOT NULL,
	SetorSaidaCrcPortaria VARCHAR(80) NOT NULL,
	ConfirmacaoRegistro VARCHAR(3) NULL,
	NrDocumento VARCHAR(30) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- CAMPO PARA INFORMAR QUE O REGISTRO FOI CANCELADO NA SA�DA

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSSAIDA') AND NAME = 'RegistroCancelado')
           ALTER TABLE ITENSSAIDA ADD RegistroCancelado VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSTRANSFERENCIA') AND NAME = 'RegistroCancelado')
           ALTER TABLE ITENSTRANSFERENCIA ADD RegistroCancelado VARCHAR(30) NULL


IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSCRCPORTARIA') AND NAME = 'RegistroCancelado')
           ALTER TABLE ITENSCRCPORTARIA ADD RegistroCancelado VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSREGSAIDA') AND NAME = 'RegistroCancelado')
           ALTER TABLE ITENSREGSAIDA ADD RegistroCancelado VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSREGSAIDA') AND NAME = 'Evadido')
           ALTER TABLE ITENSREGSAIDA ADD Evadido VARCHAR(30) NULL


-- CAMPO PARA DEFINIR SE A ADMISS�O � M�DICA CLINICA OU PSIQUIATRICA

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAOMEDICA') AND NAME = 'TipoAdmissao')
           ALTER TABLE ADMISSAOMEDICA ADD TipoAdmissao VARCHAR(20) NULL
		   

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_MEDICA_ADICIONAL') AND NAME = 'TipoAdmissao')
           ALTER TABLE ADMISSAO_MEDICA_ADICIONAL ADD TipoAdmissao VARCHAR(20) NULL