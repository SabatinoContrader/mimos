# mimos

Ho creato il progetto con Spring Initializr
Group ID: com.mimosSpring
Artifact ID: mimos
Dipendenze: WEB, Lombok, MySQL, H2

il db e': mimos

Installare Lombok da lombokproject come JAR da eseguire
La dipendenza nel pom aggiunge il jar nelle maven dependencies
Dato che non mi generava le get e set ho aggiungo manualmente la libreria esterna jar nel progetto

Il pom genrato crea diversi problemi in merito al mapping, quindi copiare questo pom "frankenstein"
-L'aggiunta principale � in merito alla dipendenza del Tomcat Server che per� dovrebbe essere gi� soddisfatta dallo starter web
-Per la Connection lasciare la dipendenza che genera in maniera dipendente dalla versione del mysql
-Attualmente � basato sulla 2.0.2, ma se si volesse procede con la 2.1.0 l'application.properties v� implementato come segue:
	.spring.jpa.properties.hibernate.jdbc.time_zone = UTC
	.spring.datasource.url = jdbc:mysql://localhost:3306/NOMEDB?serverTimezone=UTC&useLegacyDatetimeCode=false


Allora parliamo un po' delle tabelle derivate da un molti a molti
Sto testando vari metodi per la gestione della tabella derivata senza che vi sia una enetit� associata
Il codice che sto scrivendo anche se deprecato o non pertinente lo sto commentando
Quanto sotto � da aggiornare se tutto � ok

@ManyToMany

nella classe Tab1:
@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
@JoinTable(
    name = "tab1_tab2", 
    joinColumns = { @JoinColumn(name = "pk_tab1") }, 
    inverseJoinColumns = { @JoinColumn(name = "pk_tab2") })
private Set<Tab2Entity> tab2 = new HashSet<Tab2Entity>();

nella classe Tab2:
@ManyToMany(mappedBy = "tab2", fetch=FetchType.EAGER)
private Set<Tab1Entity> tab1 = new HashSet<Tab1Entity>();

Nelle rispettive Repository:
Creare solo le query che riguardano l'entit�

Per popolare tab1_tab2:

  Session session = null;
  Transaction transaction = null;
  
 session = HibernateUtil.getSessionFactory().openSession();
 transaction = session.beginTransaction();
 transaction.begin();

 Tab2 tabella2_1 = new Tab2("value1", "value2");
 Tab2 tabella2_2 = new Tab2("value3", "value4");

 // Tabella1_1 have 2 addresses
 Tab1 tabella1_1 = new Tab1("valore a cidda", "valore a cidda viola", 3);
 tabella1_1.getTab2().add(tabella2_1);
 tabella1_1.getTab2().add(tabella2_2);

 // Tabella1_2 have 1 address
 Tab1 tabella1_2 = new Tab1("valore a iola", "valore a iola viola", 2);
 tabella1_2.getTab2().add(tabella2_2);

 session.save(tabella1_1);
 session.save(tabella1_2);
 transaction.commit();
 
 Per aggiungere colonne a tab1_tab2:
 cerca su internet altrimenti si crea l'Entity e si gioca con i @ManyToOne & @OneToMany
 
 
 
