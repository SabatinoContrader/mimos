package defaultStructure;

import java.util.Iterator;

public class LinkedDizionario<K, V> implements IDizionario<K, V>, Iterable<K> {
 
    private Coppia<K, V> headList = null;
    private Coppia<K, V> lastList = null;
    private int n = 0;
     
    @Override
    public Iterator<K> iterator() {
 
        return new LDIterator<K, V>(headList, n);
    }
     
    public LinkedDizionario() {
         
         
    }
 
    @Override
    public void insert(K key, V value){

        if (this.isEmpty()) {
            headList = new Coppia<K, V>(null, null);
            lastList = new Coppia<K, V>(key, value);
            headList.setSuccessivo(lastList);
        }
        else {/*
            if (search(key) != null)
                throw new EccezioneChiavePresente("Chiave presente");*/
            lastList.setSuccessivo(new Coppia<K, V>(key, value));
            lastList = lastList.getSucc();
        }
 
        n++;
 
    }
 
    public boolean isEmpty() {
 
        return n == 0;
    }
 
    @Override
    public void delete(K key) {
         
        if (search(key) == null)
            throw new EccezioneChiaveNonPresente("Chiave non presente");
         
        Iterator<K> it = iterator();
     
        if (!it.hasNext())
            throw new EccezioneDizionarioVuoto("Dizionario Vuoto");
     
        Coppia<K, V> att = headList.getSucc();
        Coppia<K, V> pre = headList;
         
        while (it.hasNext()) {
            if (att.getChiave().equals(key)) {
                pre.setSuccessivo(att.getSucc());
                break;
            }
            pre = att;
            att = att.getSucc();
            it.next();
        }
 
    }
 
    @Override
    public V search(K key) {
         
        Iterator<K> it = iterator();
     
        if (!it.hasNext())
            throw new EccezioneDizionarioVuoto("Dizionario Vuoto");
     
        V value = null;
        Coppia<K, V> att = headList.getSucc();
         
        while (it.hasNext()) {
            if (att.getChiave().equals(key)) {
                return value = att.getValore();
            }
            att = att.getSucc();
            it.next();
        }
         
        return value;
         
    }
     
}