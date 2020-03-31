
/**
DATA DE CRIAÇÃO: 30/03/2020 - CFG
QUERY PARA BA DO SERVIÇO SOCIAL
**/
SELECT * FROM ATENDIMENTOFAMILIAR WHERE DataAtendf BETWEEN '01/02/2020' AND '29/02/2020'
SELECT * FROM EVOLUCAO_ATENDIMENTO_FAMILIA WHERE DataEvolVisita BETWEEN '01/02/2020' AND '29/02/2020'


SELECT DataAtendimento,TipoAtendimento FROM REGISTRO_ATENDIMENTO_INTERNO_PSP 
         WHERE DataAtendimento BETWEEN '01/02/2020' 
		 AND '29/02/2020' 
		 AND TipoAtendimento='Admissão Serviço Social' 
		 OR DataAtendimento BETWEEN '01/02/2020' 
		 AND '29/02/2020' 
		 AND TipoAtendimento='Evolução Serviço Social'

/**


**/