-- Query (nothing return)
-- create nodes
CREATE (n:Loan { loanId: '12345', amount: 10000 })

CREATE (n:Person { ssn:'210123198810051234' } )

CREATE (n:Phone { phoneNo:'137123456789' })
CREATE (n:Phone { phoneNo:'138001380000' })

-- create relationships
MATCH (p:Person),(l:Loan)
WHERE p.ssn='210123198810051234' AND l.loanId='12345'
CREATE (p)-[r:APPLY]->(l)
RETURN type(r)

MATCH (p:Person),(ph:Phone)
WHERE p.ssn='210123198810051234' AND ph.phoneNo='137123456789'
CREATE (p)-[r:RELTYPE {relation:'OWN'}]->(ph)
RETURN type(r)

MATCH (p1:Phone),(p2:Phone)
WHERE p1.phoneNo='137123456789' AND p2.phoneNo='138001380000'
CREATE (p1)-[r:CALL]->(p2)
RETURN type(r)

MATCH (loan:Loan)-[:APPLY]-(person:Person)-[:OWN]-(appPhone:Phone)-[:CALL]-(callPhones:Phone)
WHERE loan.loanId='12345'
RETURN distinct loan,person,appPhone,callPhones
