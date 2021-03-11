SELECT a.score as Score,
(SELECT count(distinct b.score) FROM scores as b where b.score>=a.score) AS 'Rank'
FROM scores as a
order by score DESC;