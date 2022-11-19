/*
https://app.codility.com/programmers/trainings/6/sql_sum/

Given a table elements with the following structure:

  create table elements (
      v integer not null
  );
write an SQL query that returns the sum of the numbers in column v.

For example, given:

  v
  ---
  2
  10
  20
  10
your query should return 42.
*/

/* test data insert 
INSERT INTO elements (v) VALUES(2);
INSERT INTO elements (v) VALUES(10);
INSERT INTO elements (v) VALUES(20);
INSERT INTO elements (v) VALUES(10);
*/

SELECT SUM(e.v) FROM elements e; 