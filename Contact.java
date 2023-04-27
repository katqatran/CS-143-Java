/**
 * Katherine Tran
 *
 * This program represents a contact with a first name, last name, email address, and a flag indicating whether the
 * contact is a favorite. Each contact is assigned a unique identifier number that is generated automatically.
 */

public class Contact {
    
    private String firstName;
    private String lastName;
    private String email;
    private boolean favorite;
    private int num;
    private static int nextNum = 1;

    /**
     * Constructs a new Contact object with the specified first name, last name, email address, and favorite status.
     * @param firstName the first name of the contact.
     * @param lastName the last name of the contact.
     * @param email the email address of the contact.
     * @param favorite true if the contact is a favorite, false otherwise.
     */
    public Contact(String firstName, String lastName, String email, boolean favorite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favorite = favorite;
        this.num = nextNum++;
    }

    /**
     * Returns the email address of this contact object.
     * @return a string containing the contact's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a boolean value indicating whether this contact object is a favorite.
     * @return true if the contact is marked as favorite, false otherwise.
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Returns the numerical identifier of this contact object.
     * @return an integer value representing the contact's identifier.
     */
    public int getNum() {
        return num;
    }

    /**
     * Returns the full name of this contact object. 
     * @return a string containing the contact's first name and last name.
     */
    public String getName(){
        return firstName + " " + lastName;
    }

    /**
     * Returns a String representation of the Contact object. 
     * @return a string containing the contact's number, name, and email address.
     */
    @Override
    public String toString(){
        return "Contact #" + getNum() + " " + getName() + " (" + getEmail() + ")";
    }
}
