/**
* Katherine Tran
*
* This program generates and stores a random number of Bus objects with route numbers between 100 and 130. 
* It reads from a text file with route numbers and their descriptions and adds them to a Map. The program prints the
* list of Bus objects in the Set to the console and their corresponding routes with their descriptions, if available.
*/
import java.util.*;
import java.io.*;

public class BusBarnEngine {

   public static void main(String[] args) {
      Random rand = new Random();
      Set<Bus> barn = new TreeSet<>();
      Map<Integer,String> routes = new TreeMap<>();
      
      addBuses(barn, rand);
      setRoutes(routes, "routes.txt");
      printBarn(barn);
      printBarnRoutes(barn, routes);
   }

   /**
    * Add a random number of buses between 1 and 10 with randomly generated route numbers between 100 and 130 to the given set of buses.
    * @param barn the set of buses to add to
    * @param r the Random object used to generate random numbers
    * @throws IllegalArgumentException if the set of buses is null
    */
   public static void addBuses(Set<Bus> barn, Random r) {
      int numBuses = r.nextInt(10) + 1;

      for (int i = 0; i<= numBuses; i++) {
         // construct the buses
         Bus b = new Bus();
         //generate a route number between 100 - 130
         b.setRoute(r.nextInt(100,131));
         // add the bus object to the set
         barn.add(b);
      }
   }
  
   /**
    * Prints the list of buses in the provided set of buses to the console.
    * @param barn the set of buses to print
    * @throws IllegalArgumentException if the set of buses is null
    */
   public static void printBarn(Set<Bus> barn) {
      System.out.println("\nBuses at the Bus Barn");
      System.out.println("=====================");
      for(Bus b : barn) {
         System.out.println(b);
      }
      if(barn.isEmpty()) { System.out.println("The bus barn is empty!"); }
   }

   /**
    * Populates the provided map of routes with route numbers and their descriptions from a text file.
    * @param routes map that uses the route number as the key and the route description as the value
    * @param fileName name of the file that holds the route number/description
    * @throws IllegalArgumentException if the map of routes or the file name is null
    * @throws FileNotFoundException if the specified file cannot be found
    *
    */
   public static void setRoutes(Map<Integer,String> routes, String fileName) {
      try (Scanner file = new Scanner(new File(fileName))){

         while (file.hasNextLine()) {
            String number = file.nextLine();
            String desc = file.nextLine();
            routes.put(Integer.parseInt(number), desc);
         }
         System.out.println("Routes = " + routes);
        
      } catch(FileNotFoundException e) {
         System.err.println(e);         
      }  
   }

   /**
   * Prints the routes of all buses in the bus barn set along with the corresponding route description, if available.
   * @param barn the set of bus objects
   * @param routes the map of route numbers and descriptions
   */
   public static void printBarnRoutes (Set<Bus> barn, Map<Integer,String> routes) {
      // Traverse through all the buses in the bus barn Set
      for (Bus b : barn) {
         // Check if the bus's route is a key in the route Map
         if (routes.containsKey(b.getRoute())) {
            System.out.println("BUS #" + b.getNumber() + " traveling ROUTE #"
                    + b.getRoute() + " (" + routes.get(b.getRoute()) + ")");
         } else {
            System.out.println("BUS #" + b.getNumber() + " traveling ROUTE #" + b.getRoute());
         }
      }
   }
}
