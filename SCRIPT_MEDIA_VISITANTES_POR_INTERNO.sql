SELECT ITENSFAMILIAR.IdInternoCrc,PRONTUARIOSCRC.NomeInternoCrc,
       ITENSFAMILIAR.IdVisita,
	   VISITASINTERNO.NomeVisita,
	   SUM(ITENSFAMILIAR.Quantidade) AS QUANTIDADE   	   
                     FROM VISITASINTERNO 
                     INNER JOIN ITENSFAMILIAR 
                     ON VISITASINTERNO.IdVisita=ITENSFAMILIAR.IdVisita 
					 INNER JOIN PRONTUARIOSCRC
					 ON ITENSFAMILIAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc
                     WHERE CONVERT(DATE, ITENSFAMILIAR.DataEntrada) BETWEEN'01/02/2020' 
                     AND '29/02/2020' 
                     GROUP BY ITENSFAMILIAR.IdInternoCrc,
					 PRONTUARIOSCRC.NomeInternoCrc,ITENSFAMILIAR.IdVisita,
					 VISITASINTERNO.NomeVisita
/*
SELECT ColA, SUM(ColB)
FROM tabela
GROUP BY ColA;
*/