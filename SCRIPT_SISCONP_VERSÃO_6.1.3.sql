/*
-- DATA: 09/06/2020
-- NÃO GRAVOU AS TELAS DE ACESSO DA PSICOLOGIA
-- INSERIR MANUALMENTE E DEPOIS SUBSTITUR CORRETAMENTE 

-- VERIFICAR ANTES O BANCO DA UNIDADE PARA VER SE EXISTE


INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Mamnutenção')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Planejamento')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Internos')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Avaliação em Grupo')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Avaliação Individual')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Botao Encerrar')
INSERT INTO TELAS(IdModulo,NomeTela) VALUES(9,'Movimentação:Atendimento Internos em Grupo:Botão Liberar')

-- UPDATE PARA CORRIGIR OS ACESSOS DA PSICOLOGIA

UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Manutenção' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Mamnutenção' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Planejamento' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Planejamento' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Internos' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Internos' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Avaliação em Grupo' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Avaliação em Grupo' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Avaliação Individual' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Avaliação Individual' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Botao Encerrar' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Botao Encerrar' AND IdModulo=9
UPDATE TELAS SET NomeTela='Movimentação:Atendimento Internos em Grupo - PSI:Botão Liberar' WHERE NomeTela='Movimentação:Atendimento Internos em Grupo:Botão Liberar' AND IdModulo=9

-- NÃO SERÁ NECESSÁRIO REALIZAR A INSERÇÃO NEM O UPDATE - ERRO CORRIGDO.

*/

-- CANCELAMENTO DE SAÍDA DE INTERNOS TANTO NO CRC BEM COMO PORTARIA INTERNA

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
	ConfirmacaoRegistro VARCHAR(3) NULL,
	NrDocumento VARCHAR(30) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)
