import com.example.viaggiapp.Poi;

import java.util.ArrayList;

public class Vd {

    private ArrayList<Poi> vdPoi= new ArrayList<Poi>();


    /**Costruttore*/
    public Vd(ArrayList<Poi> vdPoi) {
        this.vdPoi = vdPoi;
    }


    /**Getter & Setter*/
    public ArrayList<Poi> getVdPoi() {
        return vdPoi;
    }

    public void setVdPoi(ArrayList<Poi> vdPoi) {
        this.vdPoi = vdPoi;
    }

}