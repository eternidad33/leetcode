SELECT d.name as Department,e.name as Employee,e.salary as Salary
FROM department as d
    join employee as e
    on e.departmentid=d.id
WHERE (e.departmentid,e.salary) in (
SELECT departmentid,max(salary)
FROM employee
GROUP BY departmentid
);