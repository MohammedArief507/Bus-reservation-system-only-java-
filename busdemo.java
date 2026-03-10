package busrev;
import java.util.Scanner;
import java.util.ArrayList;
//javac busrev/bus.java
//javac busrev/booking.java
//javac busrev/busdemo.java
//java  busrev/busdemo
//System.out.println("");

public class busdemo{
    public static void main(String[] args){
        ArrayList<bus> buses =new ArrayList<bus>();
        ArrayList<booking> Bookings = new ArrayList<booking>();
        buses.add(new bus(101,"Trichy(10:10pm)","Chennai(06:00am)",true,52,450));
        buses.add(new bus(202,"coimbatore(08:00pm)","Chennai(05:30am)",false,50,550));
        buses.add(new bus(303,"Trichy(05:00pm)","Bangalore(03:00am)",true,45,750));
        buses.add(new bus(404,"chennai(07:00pm)","thajarur(05:00am)",true,52,450));
         
        
        int userinput = 0;
        String adminusername = "Arief507";
        String adminpassword = "507507";
        Scanner sc = new Scanner(System.in);
        while(userinput!=5){
            System.out.println("\n========================================\n");
            System.out.println("         Wlecome to Arief Travels       ");
            System.out.println("========================================");
            System.out.println("1.Book Ticket");
            System.out.println("2.View buses");
            System.out.println("3.Cancel booking");
            System.out.println("4.Admin login");
            System.out.println("5.Exit");
            userinput = sc.nextInt();
            if(userinput == 1){
                for(bus book : buses){
                    book.displayinfo();
                    }
                System.out.println("how many tickets want to back:");
                int ticketcount = sc.nextInt();
                for(int i =0;i<ticketcount;i++){
                booking Booking = new booking(Bookings,buses);
                if(Booking.seatno != -1 && Booking.isavailable(Bookings,buses)){
                    Bookings.add(Booking);
                    System.out.println("Ticket "+(i+1)+" booked successfully");
                    Booking.displayticket();
                    int capacity = 0;
                    int booked = 0;
                    for(bus book : buses){
                        if(book.getbusno()==Booking.busno){
                            capacity = book.getCapacity();
                        }
                    } 
                    for(booking b: Bookings){
                        if(b.busno==b.busno){
                            booked++;
                        }
                    }
                    System.out.println("remaing seats:"+ (capacity - booked));
                }else{
                    System.out.println("Try again");
                    break;
                }
                }

            }
            else if(userinput == 2){
                for(bus book : buses){
                    book.displayinfo();
                    }
                    System.out.println("Enter 1 to back and 2 to exit:");
                    int anotherinput = sc.nextInt();
                    if(anotherinput  == 2){
                        continue;
                    }
                    
                    else if(anotherinput  == 3){
                       userinput = 5; 
                    }
            }
            else if(userinput == 3){
                System.out.println("Enter booking id to cancel:");
                int id = sc.nextInt();
                for(int i = 0;i<Bookings.size();i++){
                    if(Bookings.get(i).bookingId == id){
                        Bookings.remove(i);
                        System.out.println("booking cancelled");
                    }
                    else{
                        System.out.println("id not found");
                    }
                }

            }
            else if(userinput == 4){
                sc.nextLine(); 
                System.out.println("Enter Admin username:");
                String uname = sc.nextLine();
                System.out.println("Enter Admin password:");
                String pass = sc.nextLine();

                if(uname.equals(adminusername) && pass.equals(adminpassword)){
                    System.out.println("Login successfull");
                    int adminchoice = 0;
                    while(adminchoice != 3){
                        System.out.println("\n======Admin Menu======\n");
                        System.out.println("1.Add bus");
                        System.out.println("2.View booking");
                        System.out.println("3.logout");
                        adminchoice = sc.nextInt();

                        if(adminchoice == 1){
                            System.out.println("Enter Bus NO:");
                            int busno = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter Bus From(name(time(am/pm)):");
                            String busfrom = sc.nextLine();
                            System.out.println("Enter Bus To(name(time(am/pm)):");
                            String busto = sc.nextLine();
                            System.out.println("Enter Bus is Ac?(true/false):");
                            boolean busAc = sc.nextBoolean();
                            System.out.println("Enter Bus capacity:");
                            int buscap = sc.nextInt();
                            System.out.println("Enter Bus fear:");
                            int busfare = sc.nextInt();

                            buses.add(new bus(busno,busfrom,busto,busAc,buscap,busfare));
                            System.out.println("Bus added");
                        }else if(adminchoice == 2){
                            if(Bookings.size() == 0){
                                System.out.println("no booking founded");   
                            }else{
                                for( booking b : Bookings){
                                    b.displaybooking();
                                }
                            }
                        }
                    }
                }else if(uname == adminusername && pass != adminpassword){
                    System.out.println("Invaild  password");
                }else{
                    System.out.println("worng  Username");
                }

            }
            
            
        }
        System.out.println("Thank you...");

    }
}