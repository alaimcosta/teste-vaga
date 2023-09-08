/*Tarefa 1*/

SELECT 
Employee.FirstName AS Nome_do_Funcionario,
SUM(Invoice.total) AS Valor_Total_Vendido,
MIN(Invoice.Total) AS Menor_Venda,
MAX(Invoice.Total) AS Maior_Venda,
AVG(Invoice.Total) AS Valor_Medio_Venda,
COUNT(*) AS Quantidade_Total 
FROM Invoice 
INNER JOIN Employee ON Invoice.InvoiceId = Employee.EmployeeId
WHERE strftime( '%Y', Invoice.InvoiceDate) = '2011'
GROUP BY Employee.firstname 
ORDER by Invoice.total DESC


SELECT 
Employee.FirstName AS Nome_do_Funcionario,
SUM(Invoice.Total) AS Valor_Total_Vendido,
MIN(Invoice.total) AS Menor_Venda,
MAX(Invoice.total) AS Maior_Venda,
AVG(Invoice.total) AS Valor_Medio_Venda,
COUNT(*) AS Quantidade_Total 
FROM Invoice INNER JOIN Employee ON Invoice.InvoiceId = Employee.EmployeeId WHERE Invoice.invoicedate   GROUP BY Employee.firstname ORDER by Invoice.total DESC


/*Tarefa 2*/
SELECT 
m.name AS Nome, 
g.Name AS Tipo, 
m.Composer AS Compositor
FROM Track m
INNER JOIN PlaylistTrack pt ON m.TrackId = pt.TrackId
INNER JOIN Playlist g ON pt.PlaylistId = g.PlaylistId
WHERE m.composer IS NULL AND g.PlaylistId = 1;

/*Tarefa 3*/
SELECT 
g.Name AS Genero,
SUM(inl.UnitPrice * inl.Quantity) AS Valor_T_Vendido
FROM Genre g
INNER JOIN Track t ON g.GenreId = t.TrackId
INNER JOIN InvoiceLine inl ON t.TrackId = inl.TrackId
GROUP by g.Name
ORDER by Valor_T_Vendido DESC LIMIT 5







