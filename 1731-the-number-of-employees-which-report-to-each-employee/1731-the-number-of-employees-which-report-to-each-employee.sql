# Write your MySQL query statement below
SELECT B.employee_id,B.name,
COUNT(A.employee_id ) AS reports_count,
ROUND (AVG(A.age),0) as average_age 
 FROM Employees  AS A
JOIN Employees AS B
ON A.reports_to = B.employee_id
GROUP BY B.employee_id  ;