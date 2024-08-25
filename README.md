Aplikace je postavena na technologiích: SpringBoot, MySQL, JPA a Hibernate, REST API, Lombok
Obsluha je přes REST rozhraní a obsahuje 3 databázové tabulky:
Beers – uložená piva z poskytnutého API
User – uživatelé, kteří hodnotí piva
Ratings – hodnocení jednotlivých piv, obsahuje 2 cizí klíče( na Beers a User) a propojuje tabulky Beers a User
Dále je v aplikaci i filtr pomocí kterého lze hodnocení pro piva filtrovat, lze vyfiltrovat hodnocení pro jednotlivá piva i uživatele a pak i podle datumu.
Řešení souběhu: 
V případě pivní aplikace by riziko bylo největší při práci s databází, kde je více uživatelů pracujících současně, k problému by mohlo například dojít při vkládání nových dat nebo manipulaci s nimi. Řešení vidím v transakcích, kde se musí provést určitý kód celý, pokud se část neprovede, tak se stav vrátí do původního. V rámci springbootu by šlo konkrétně o použití anotace @Transactional. Dalším řešením by bylo použití optimistic nebo pesimictic locking v závislosti na tom, kolik konfliktů se předpokládá. Při využití zámků bych se přikláněl k využití optimistic locking, kde by se do entit přidala anotace @Version s atributem version typu int. JPA by pak měl kontrolovat, zda se verze změnila či ne, pokud ano, tak hodí výjimku. 
