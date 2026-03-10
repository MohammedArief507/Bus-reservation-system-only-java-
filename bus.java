package busrev;

public class bus{
    int busno;
    String busfrom;
    String busto;
    boolean busAc;
    int buscapacity;
    int busfare;

    bus(int no,String from,String to,boolean Ac,int cap,int fare){
        this.busno = no;
        this.busfrom = from;
        this.busto = to;
        this.busAc = Ac;
        this.buscapacity = cap;
        this.busfare = fare;

    }
      
    public int getbusno(){
        return busno;
    }
    public boolean isAc(){
        return busAc;
    }

    public int getCapacity(){
        return buscapacity;
    }
    public void setCapacity(int buscap){
        buscapacity = buscap;
    }
    public void setAc(boolean val){
        busAc = val;
    }
    public int getFare(){
        return busfare;
    }
    public void displayinfo(){
        System.out.println("BusNO: " + busno + ", FROM: " + busfrom + ", TO: " + busto + ",  AC: " + busAc + ", capacity: " + buscapacity);
    }
   
}