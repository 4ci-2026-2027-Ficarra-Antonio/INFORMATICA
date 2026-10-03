# Documentazione SistemaPagamento

## 1. Descrizione del funzionamento
Il codice gestisce la transazione tra un conto bancario e delle richieste di pagamento lette da un file di testo, gli esiti vengono salvati su un file log.

1. Viene creato un conto corrente associato ad un intestatario con un saldo iniziale.
2. Il programma apre un file di input (`pagamenti_input.txt`) tramite le classi `File` e `Scanner` per leggere i dati riga per riga.
3. Apre un file di log (`log_transazioni.txt`) tramite `FileWriter` e `PrintWriter` per registrare i risultati delle operazioni.
3. Elaborazione e metodo **effettuaPagamento()**:
    - Per ogni riga letta, il programma verifica che non sia vuota, la suddivide con il metodo ".split()" e crea un oggetto "Pagamento".
    - La classe "Conto" riceve l'oggetto "Pagamento" come parametro del metodo **effettuaPagamento()**.
    - Il metodo controlla che l'oggetto non sia nullo, che l'importo sia valido e che il saldo disponibile sufficiente.
    - Se il saldo è sufficiente, l'importo viene sottratto dal conto e viene stampato un messaggio di conferma sul file di log.
    - Se è insufficiente, il metodo interrompe il flusso e lancia un'eccezione  `SaldoInsufficienteException`, l'errore viene registrato sul file di log.
4. **main**:
    - Le operazzioni di Input e Outuput e le chiamate a `effettuaPagamento()` sono dentro delle `try-catch`.
    - Eventuali errori (come il saldo insufficiente o la mancanza del file) vengono intercettati.

## 2. Diagramma delle classi - UML

### Classe: "Conto"
| Visibilità | Metodo | Tipo |
| :--- | :--- | :--- |
| `private` | `intestatario` | `String` |
| `private` | `saldo` | `double` |
| `public` | `Conto()` | Costruttore |
| `public` | `Conto(intestatario: String, saldo: double)` | Costruttore |
| `public` | `setIntestatario(intestatario: String)` | `void` |
| `public` | `getIntestatario()` | `String` |
| `public` | `setSaldo(saldo: double)` | `void` |
| `public` | `getSaldo()` | `double` |
| `public` | `effettuaPagamento(p: Pagamento)` | `void` |
| `public` | `toString()` | `String` |

### Classe: "Pagamento"
| Visibilità | Metodo | Tipo |
| :--- | :--- | :--- |
| `private` | `beneficiario` | `String` |
| `private` | `importo` | `double` |
| `public` | `Pagamento()` | Costruttore |
| `public` | `Pagamento(beneficiario: String, importo: double)` | Costruttore |
| `public` | `setBeneficiario(beneficiario: String)` | `void` |
| `public` | `getBeneficiario()` | `String` |
| `public` | `setImporto(importo: double)` | `void` |
| `public` | `getImporto()` | `double` |
| `public` | `toString()` | `String` |

### Classe: "SaldoInsufficienteException"
| Visibilità | Metodo | Tipo |
| :--- | :--- | :--- |
| `public` | `SaldoInsufficienteException(messaggio: String)` | Costruttore (Estende exception) |

### Relazione UML
|  |  |  |  |  |
| :--- | :--- | :--- | :--- | :--- |
| `Conto` | (**Dipendenza**) `--->` | `uses` | `Pagamento` |
| `SaldoInsufficienteException` |  `--->` | `extends` | `Exception` |

`Conto` utilizza un oggetto `Pagamento` come parametro del metodo `effettuaPagamento()`.

## 3. Possibili Upgrade
1. **Storico delle transazioni:**
    - ArrayList<Pagamento> per conservare i pagamenti andati a buon fine.
    - ID pagamento e Data/Ora.
2. **Aggiungere tipologie di pagamenti**
    - Pagamento con bonifico: IBAN, beneficiario e causale.
    - Pagamento Carta: aggiunge delle commissioni.
3. **Interfaccia utente**