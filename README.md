# mimos

Ho creato il progetto con Spring Initializr
Group ID: com.mimosSpring
Artifact ID: mimos
Dipendenze: WEB, Lombok, MySQL, H2

il db e': mimos

Installare Lombok da lombokproject come JAR da eseguire


Allora parliamo un po' delle tabelle derivate da un molti a molti

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
Creare solo le query che riguardano l'entità

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
