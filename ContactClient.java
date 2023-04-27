import java.util.*;

/**
 * This class has a list of contacts which can be displayed in different ways via a menu system.
 */
public class ContactClient {

    private ArrayList<Contact> list;

    /**
     * This method constructs a new ContactClient object and initializes it with a list of sample contacts.
     */
    public ContactClient() {
        list = new ArrayList<>();
        list.add(new Contact("Joe", "Smith", "jsmith@gmail.com", false));
        list.add(new Contact("Gregory", "Smith", "gregsmith@livemail.com", false));
        list.add(new Contact("Rachel", "Garcia", "gargar@comcast.net", true));
        list.add(new Contact("Susie", "Adams", "sadams@gmail.com", true));
        list.add(new Contact("Lawrence", "Williams", "lolawrence@yahoo.com", false));
        list.add(new Contact("Jerome", "Bradley", "bradleyj@yahoo.com", false));
    }

    /**
     * This method displays the menu options for the Contact Client application.
     */
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome to my contacts list!");
        System.out.println("1.  Display all contacts.");
        System.out.println("2.  Display favorites.");
        System.out.println("3.  Exit.");
        System.out.println();
    }

    /**
     * This method displays all the contacts stored in the Contact Client application. 
     * Each contact's information is printed to the console using the Contact class's overridden toString() method.
     */
    public void displayAllContacts() {
        for(Contact c : list){
            System.out.println(c);
        }
    }

    /**
     * This method constructs a new ContactClient object and initializes it with a list of sample contacts.
     */
    public void displayFavorites() {
        for(Contact c : list){
            if(c.isFavorite()){
                System.out.println(c);
            }
        }
    }

    /**
     * The main method provides the user with a display menu
     * @param args
     */
    public static void main(String[] args) {
        ContactClient contacts = new ContactClient();

        contacts.displayOption(new Scanner(System.in));
    }

    /**
     * This method displays the menu options to the console and prompts the user to select an option.
     * The method reads the user's input and invokes the appropriate method based on the selected menu option.
     * @param in a Scanner object used to read the user's input
     */
    public void displayOption(Scanner in) {
        String choice = "";

        while (!choice.equals("3")) {

            this.displayMenu();
            System.out.print("Enter your numerical choice:");
            choice = in.next();

            System.out.println();
            // display all contacts
            if (choice.equals("1")) {

                this.displayAllContacts();

                // display favorite contacts
            } else if (choice.equals("2")) {

                this.displayFavorites();

            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Invalid choice, try again");
            }
            System.out.println();
        }
        System.out.println("Goodbye");
        in.close();
    }
}

/*

Welcome to my contacts list!
1.  Display all contacts.
2.  Display favorites.
3.  Exit.

Enter your numerical choice:1

Contact #1 Joe Smith (jsmith@gmail.com)
Contact #2 Gregory Smith (gregsmith@livemail.com)
Contact #3 Rachel Garcia (gargar@comcast.net)
Contact #4 Susie Adams (sadams@gmail.com)
Contact #5 Lawrence Williams (lolawrence@yahoo.com)
Contact #6 Jerome Bradley (bradleyj@yahoo.com)


Welcome to my contacts list!
1.  Display all contacts.
2.  Display favorites.
3.  Exit.

Enter your numerical choice:2

Contact #3 Rachel Garcia (gargar@comcast.net)
Contact #4 Susie Adams (sadams@gmail.com)


Welcome to my contacts list!
1.  Display all contacts.
2.  Display favorites.
3.  Exit.

Enter your numerical choice:3

Goodbye

*/
