package model;

import java.util.ArrayList;

public class Landlord extends UserProfile{
    ArrayList<Property> properties;

    
	/**
	 * Constructor of Landlord that calls the UserProfile constructor 
	 * to inherit all the User's methods like getID, getEmail, setEmail, set and get password etc
	 */
    public Landlord(String name, String email, String pswd){
        super(name, email, pswd);
    }

    
	/**
	 * Method to add the property passed in to an ArrayList of properties
	 * @param p
	 */
    public void addProperty(Property p){
        properties.add(p);
    }


	/**
	 * Method to remove the property corresponding to the id passed in from the ArrayList of properties
	 * @param id
	 */
    public void removeProperty(int id){
        for(int i = 0; i < properties.size(); i++){
            if(properties.get(i).getID() == id){
                properties.remove(i);
            }
        }
    }
}

