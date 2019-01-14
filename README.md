# Test 3-4
Third test version 4 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)
Rozhraní ani předdefinované třídy neměňte, pokud to přímo nevyžaduje zadání. Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte zásadně privátní atributy.


Úloha simuluje pohyb osob po místnostech domu.

**Zadání:**

-   Vytvořte třídu HouseImpl implementující rozhraní House. Dům si pamatuje "plán místností", tj. pro každou místnost v domě si pamatuje sousední místnosti, do kterých lze přímo projít (místnosti jsou propojeny dveřmi). Kromě toho si pamatuje, ve kterých místnostech se nacházejí konkrétní osoby. Platí následující pravidla:
     - Dveřmi lze projít oběma směry, tj.pokud lze projít z místnosti A přímo do místnosti B, pak lze projít i z místnosti B do místnosti A.
     - Místnosti jsou v domě unikátní (viz definice rovnosti ve třídě Room), žádná místnost tedy není v domě dvakrát.
    - Každá osoba může být v daném okamžiku pouze v jedné místnosti.
    - Metoda placePerson() umístí/přesune osobu do libovolné místnosti v domě. Metoda tedy slouží ke "vložení" nové osoby do domu, nebo k jejímu přesunu z jedné místnosti do jiné bez ohledu na plán místností.
    - Metoda enterNextDoor() přesune osobu do sousední místnosti. Pokud osoba v domě není, nebo požadovaná místnost nesousedí s aktuální, je to považováno za chybu.
    - Metody loadPlan() a savePlan() pracují pouze s plánem místností (sousednost místností). Lidé a jejich umístění se neukládá/nenahrává. Pozn.: savePlan() implementujte i přesto, že v aktuální podobě třída plán požadovanými metodami nemění.
    - Testovací plán místností je v souboru "directConnections.txt".
    - Třída HouseImpl bude mít jediný konstruktor, který vezme název souboru (jako parametr typu String) a ze souboru načte plán místností. Konstruktor bude vyhazovat výjimku IOException při jakékoliv chybě vstupu/výstupu.

Poznámky a rady:

- Pokud se rozhodnete uzavírat vstup/výstup, tak myslete na to, že k uzavření by mělo dojít za všech okolností, tedy i pokud dojde k chybě.
- Je třeba programovat defenzivně, tj. např. správně ošetřit případný chybný formát dat načítaných ze vstupního proudu.

Třída Demo by při správném řešení měla vypsat:

        Reading data from directConnections.txt...OK
        enterNextDoor() -- unknown person: OK
        enterNextDoor() -- unknown room: OK
        placePerson() -- replacing person: OK, Viviane is in "workroom".
        Viviane doesn't entered "ballroom": OK
        Moving various persons to their neighbouring rooms: OK
        Viviane is in "salon bordeaux". Raquelle is in "ballroom".

        savePlan() -- line order doesn't matter:
        salon bordeaux:workroom
        workroom:salon bordeaux
        workroom:lavatory
        lavatory:workroom
        lavatory:connecting gallery
        entrance hall:connecting gallery
        entrance hall:grand salon
        connecting gallery:lavatory
        connecting gallery:entrance hall
        connecting gallery:ballroom
        connecting gallery:grand salon
        ballroom:connecting gallery
        grand salon:entrance hall
        grand salon:connecting gallery


## License
MIT