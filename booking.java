package busrev;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class booking{
    static int bookid=1000;
    String passangername;
    int busno;
    Date date;
    int bookingId;
    int busfare;
    int seatno;

    booking(ArrayList<booking> Bookings,ArrayList<bus> buses){
        Scanner sc = new Scanner(System.in);
        bookingId = bookid++;
        System.out.println("Enter Passangername:");
        passangername = sc.nextLine();
        System.out.println("Enter BusNo:");
        busno = sc.nextInt();
        sc.nextLine();
        
        
        

        LocalDate date = null;

        while (date == null) {
            System.out.print("Enter Date (dd-MM-yyyy): ");
            String input = sc.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                date = LocalDate.parse(input, formatter);
                } 
                catch (DateTimeParseException e) {
                    System.out.println("Invalid date! Please enter correct date.");
                    }
        }
        
        assignseat(Bookings);
        assignfare(buses);
        System.out.println("Select seat(all odd number are windo seats):");
        int selectseatno = sc.nextInt();
        if(isseatvaild(selectseatno, Bookings,buses)){
            seatno = selectseatno;
        }else{
            System.out.println("seat not available..try another seat.");
            seatno =-1;
        }

    }
    
    private void assignseat(ArrayList<booking> Bookings){
        int maxseat =0;
        for(booking b : Bookings){
            if(b.busno == this.busno && b.seatno > maxseat ){
                maxseat = b.seatno;
            }
        }
        seatno = maxseat + 1;
    }
    private void assignfare(ArrayList<bus> buses){
        for(bus b : buses){
            if(b.getbusno() == busno){
                busfare = b.getFare();
            }
        }
    }
    private boolean isseatvaild(int selectseatno,ArrayList<booking> Bookings,ArrayList<bus> buses){
        int capacity=0;

        for(bus b : buses){
            if(b.getbusno() == this.busno){
                capacity = b.getCapacity();
            }
        }
        if(selectseatno > capacity || selectseatno <=0){
            System.out.println("invaild seatNo,max seat:"+capacity);
            return false;
        } 
        for(booking b : Bookings){
            if(b.busno == this.busno && b.seatno==selectseatno){
                System.out.println("seat already booked");
                return false;
            }
        } 
        return true; 
     }
    public boolean isavailable(ArrayList<booking> Bookings,ArrayList<bus> buses){
        int capacity = 0;
        for(bus Bus:buses){
            if(Bus.getbusno() == busno){
                capacity = Bus.buscapacity;
            }
        }
        int booked = 0;
        for(booking b : Bookings){
            if(b.busno == busno && b.date.equals(date) ){
                booked++;
            }
        }
        return booked<capacity?true:false;
        

    }
    public void displayticket(){
        System.out.println("========================================");
        System.out.println("           Bus Tickect                  ");
        System.out.println("========================================");
        System.out.println("Booking ID      :"+bookid);
        System.out.println("Passanger Name  :"+passangername);
        System.out.println("Bus no          :"+busno);
        System.out.println("Seat No         :"+seatno);
        System.out.println("Fare            :"+busfare);
        System.out.println("========================================");
    }
    public void displaybooking(){
            System.out.println("Booking id:"+bookingId+" | Name: "+passangername+" | BusNO: "+busno +"| BUS fare:"+busfare );

        }

}