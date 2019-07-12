#REST проект Ферма.


Есть 3 сущности: ферма, фермер, корова

У фермы есть список фермеров, у фермеров список коров.

api фермы:

 * /farm
 * /farm/{id}
 * /farm/{id}/farmer
 * /farm/{id}/cow
 * /farm/{id}/cow/cost
 * /farm/ (post запрос)
 * /farm/{id} (put запрос)
 * /farm/{id} (delete запрос)

api фермеров:

 * /farmer
 * /farmer/{id}
 * /farmer/{id}/cow
 * /farmer/ (post запрос)
 * /farmer/{id} (put запрос)
 * /farmer/{id} (delete запрос)
 
api коров:
 
 * /cow
 * /cow/{id}
 * /cow/ (post запрос)
 * /cow/{id} (put запрос)
 * /cow/{id} (delete запрос)


