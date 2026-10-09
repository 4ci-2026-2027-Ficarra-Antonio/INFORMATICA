# Documentazione Parcheggio

*Nota: mi sono permesso di andare oltre le richieste della consegna originale per sviluppare un'applicazione completa aggiungendo liste dinamiche (ArrayList).*

## 1. Descizione del funzionamento
Il codice gestisce l'ingresso, l'uscita e lo stato di un parcheggio tramite un menu interattivo da terminale.

1. **Inizializzazione**
    - Viene creato un oggetto `Parcheggio` con capienza massima di 500 posti e una tariffa oraria iniziale di 1.50€.
    - Viene creato un oggetto `Scanner` per la lettura dell'input e tutte le variabili vengono dichiarate all'inizio.
2. **Entrata dell'auto nel parcheggio**
    - L'utente inserisce la targa, la marca e il modello con cui verrà creato un oggetto di classe `Car`.
    - Il metodo `entra()` verifica che ci siano posti disponibili e scorre la lista delle auto presenti nell'ArrayList.
    - Se la targa è già presente nel parcheggio, l'ingresso viene rifiutato. Altrimenti, l'auto viene aggiunta e i posti disponibili diminuiscono.
3. **Uscita dell'auto dal parcheggio**
    - L'utente inserisce la targa e le ore di sosta trascorse.
    - Viene cercata l'auto nel parcheggio (nell'ArrayList) tramite la targa
    - Se l'auto viene trovata, viene rimossa, i posti disponibili aumentano di uno e viene calcolato il costo totale della sosta attraverso la tariffa oraria.
    - Se l'auto non viene trovata, il metodo restituisce -1 e la classe test stampa un errore.
4. **Altre funzioni**
    - Possibilità di modificare il costo orario della sosta.
    - Visualizzazione dello stato del parcheggio (posti, tariffa e auto presenti).

## 2. Diagramma delle classi - UML

### Classe "Car"
| Visibilità | Metodo | Tipo |
| :--- | :--- | :--- |
| `private` | `targa` | `String` |
| `private` | `marca` | `String` |
| `private` | `modello` | `String` |
| `public` | `Car()` | Costruttore vuoto |
| `public` | `Car(t: String, ma: String, mo: String)` | Costruttore con parametri |
| `public` | `Car(auto: Car)` | Costruttore di copia |
| `public` | `setTarga(t: String)` | `void` |
| `public` | `getTarga()` | `String` |
| `public` | `setMarca(ma: String)` | `void` |
| `public` | `getMarca()` | `String` |
| `public` | `setModello(mo: String)` | `void` |
| `public` | `getModello()` | `String` |
| `public` | `uguale(auto: Car)` | `boolean` |
| `public` | `toString()` | `String` |

### Classe "Parcheggio"
| Visibilità | Metodo | Tipo |
| :--- | :--- | :--- |
| `private` | `postiDisponibili` | `int` |
| `private` | `capienzaMax` | `int` |
| `private` | `costoOrario` | `double` |
| `private` | `autoPresenti` | `ArrayList<Car>` |
| `public` | `Parcheggio()` | Costruttore vuoto |
| `public` | `Parcheggio(posti: int, costo: double)` | Costruttore con parametri |
| `public` | `Parcheggio(p: Parcheggio)` | Costruttore di copia |
| `public` | `setCostoOrario(costo: double)` | `void` |
| `public` | `getCostoOrario()` | `double` |
| `public` | `getPostiDisponibili()` | `int` |
| `public` | `entra(auto: Car)` | `boolean` |
| `public` | `esce(auto: Car, ore: double)` | `double` |
| `public` | `toString()` | `String` |

### Relazione UML
|  |  |  |  |  |
| :--- | :--- | :--- | :--- | :--- |
| `Parcheggio` | `--->` | `contiene` | `Car` |
| `Test` | `--->` | `uses` | `Car` e `Parcheggio` |

## 3. Possibili upgrade futuri
1. **File di testo:**
    - Salvataggio e caricamento dello stato del parcheggio su file di testo
2. **Storico pagamenti:**
    - Salvare i dati delle auto uscite per calcolare gli incassi giornalieri totali.
3. **Categorie di veicoli:**
    - Differenziazione delle tariffe per tipologia di veicolo
4. **Gestione errori con classe exception personalizzata:**
    - Sostituire nel metodo esce la gestione dell'eventuale errore con "-1" con il lancio di un'eccezione personalizzata.