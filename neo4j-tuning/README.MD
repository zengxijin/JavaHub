CREATE (aa:Loan {loanId:123,loanType:"cash-loan",amount:10000})

查询
MATCH (a:Loan) WHERE a.loanId=123 RETURN a

a通过查询得到引用，a可以在后面的CQL上使用
MATCH (l1:Loan) WHERE a.loanId=123
CREATE 
(p1:Person {name:"jack",age:30} ),
(c1:Phone {cellPhone:"13512345678"} ),
(p1)-[:APPLY]->(l1),
(p1)-[:OWN]->c1

查询指定的连接关系的数据
MATCH (p:Person)-[:APPLY]-(loans)
WHERE p.name="jack"
RETURN p,loans

查询所有的连接关系的数据
MATCH (p:Person)-[*]-(loans)
WHERE p.name="jack"
RETURN p,loans

通过Phone创建联系
MATCH (c:Phone) where c.cellPhone="13512345678"
CREATE
(l:Loan {loanId:456,loanType:"speed-loan",amount:20000}),
(p:Person {name:"tom",age:28}),
(c2:Phone {cellPhone:"13587654321"}),
(c2)-[:CALL]->(c),
(p)-[:OWN]->(c2),
(p)-[:APPLY]->(l)

MATCH (l:Loan)-[:APPLY]-(person)-[:OWN]-(appPhone)-[:CALL]-(callPhones)
where l.loanId=456
return distinct 1,person,appPhone,callPhones

