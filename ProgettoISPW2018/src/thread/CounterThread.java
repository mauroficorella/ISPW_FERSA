package thread;

import entity.Annuncio;
import java.util.ArrayList;

public class CounterThread extends Thread   {
    private ArrayList<Annuncio> a;
    public CounterThread(ArrayList<Annuncio> a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int numAnnunci = 0;
        for (int i=0; i<a.size(); i++)  {
            numAnnunci++;
        }
        System.out.println("Sono presenti " + numAnnunci + " annunci.");
    }
}
