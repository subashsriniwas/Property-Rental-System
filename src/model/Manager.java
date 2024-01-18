package model;



public class Manager extends UserProfile{

	
	/**
	 * Constructor of Manager that calls the UserProfile constructor 
	 * to inherit all the User's methods like getID, getEmail, setEmail, set and get password etc
	 */
    public Manager(String name, String email, String pswd){
        super(name, email, pswd);
    }
    
	/**
	 * Method to change the Listing state of the property corresponding to the propertyID passed in 
	 * @param newState
	 * @param propertyID
	 */
    public void changeListingState(String newState, int propertyID){
    }
    
    
	/**
	 * Method to change the listing fees of the property passed in 
	 * @param newFee
	 * @param p
	 */
    public void changeFees(int newFee, Property p){
    }
}

