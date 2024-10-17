# CodFisc-Ex
Calcolo di età e data di nascita da un codice fiscale, architettura microservizi Restful

## Struttura

L'applicativo è strutturato come segue:

- CodFiscEx: Il componente padre, dal quale i submodules ereditano le dipendenze
    - CodFiscExCommon: Modulo che definisce POJO, eccezioni e metodi di utility
    - CodFiscExRest: Modulo che implementa l'architettura REST, esponendo la risorsa di recupero età e data di nascita da un codice fiscale.


## Swagger

E' possibile utilizzare lo Swagger definito all'interno del progetto.

Una volta clonato ed avviato il progetto è possibile accedere alla URL 

    http://localhost:8080/swagger-ui/index.html

>[!NOTE]
>Il codice fiscale verrà automaticamente proposto dallo Swagger.
>**Potrebbe** non essere un codice fiscale valido, in modo tale da testare la coerenza dei controlli dello strato di servizio.
