# Write your MySQL query statement below
SELECT * FROM Cinema WHERE id % 2 NOT IN(0) AND description not in ('boring') order by rating desc;
