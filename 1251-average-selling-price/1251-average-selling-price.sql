# Write your MySQL query statement below
SELECT Prices.product_id ,
IFNULL(
   ROUND(SUM(Prices.price * UnitsSold.units) / SUM(UnitsSold.units), 2) ,0
) AS   average_price

FROM Prices  left JOIN 
UnitsSold on Prices.product_id = UnitsSold.product_id 
and UnitsSold.purchase_date BETWEEN 
Prices.start_date
AND 
Prices.end_date 
GROUP BY Prices.product_id ;



