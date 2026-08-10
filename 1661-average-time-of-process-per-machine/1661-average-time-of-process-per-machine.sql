# Write your MySQL query statement below
SELECT A.machine_id ,  ROUND(AVG(A.timestamp - B.timestamp), 3) AS processing_time
FROM Activity AS A
JOIN ACTIVITY AS B
ON A.machine_id= B.machine_id
AND
A.process_id= B.process_id
AND 
A.activity_type='end' 
AND 
B.activity_type='start'
GROUP BY A.machine_id ; 