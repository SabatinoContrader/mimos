package defaultStructure;

import java.util.Iterator;

public class LDIterator<K, V> implements Iterator<K> {
 
    private Coppia<K, V> attuale;
    private int totale = 0;
    private int posizione = 0;
     
     
 
    public LDIterator(Coppia<K, V> headList, int n) {
 
        this.attuale = headList.getSucc();
        this.totale = n;
    }
 
    public boolean hasNext() {
 
        return (posizione < totale);
    }
 
    @Override
    public K next() {
         
        K temp = attuale.getChiave();
        posizione++;
         
        if (hasNext())
            attuale = attuale.getSucc();
         
        return temp;
    }
 
    @Override
    public void remove() {
 
        throw new EccezioneOperazioneNonValida();
         
    }
 
}