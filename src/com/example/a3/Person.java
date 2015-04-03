package com.example.a3;   

public abstract class Person implements Comparable<Person>{

    protected String _name;     /** The person's name */
    protected String _address;  /** The person's home address */
    
    /**
     * Constructor.
     * @param personName - The person's first and last name
     * @param personAddress - The person's address
     */
    public Person(String name, String address) {
        _name = name;
        _address = address;
    }
    
    /**
     * Get the person's current status, for example "Baby", "Student", "Employee".
     * This could also include additional information, e.g. "Student - fees paid"
     * @return - The status string
     */
    public abstract String currentStatus();
    
    
    // Getters & setters
    
    public String getName() {
        return _name;
    }

    public String getAddress() {
        return _address;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setAddress(String address) {
        _address = address;
    }

    @Override
    public String toString() {
        return   "Name: " + _name + "\n"
               + "Address: " + _address + "\n"
               + "Status: "+ currentStatus() + "\n";
    }
    
    /** Compare method to be used in Collection.sort()
     * Comparison is based on person's name
     * @param p - a person to compare to
     * @return 1, 0, -1 corresponding to "greater than", "equal" or "less than".
     */
    public int compareTo(Person p){
    	//compare as many letters as there are in a smaller word
    	for (int i = 0; i < Math.min(_name.length(), p.getName().length()); i++){
    		//if this letter is later in the alphabet, return "greater than" (1)
    		if (_name.charAt(i) > p.getName().charAt(i))
    			return 1;
    		else {
    			//otherwise "less than" (-1)
    			if (_name.charAt(i) < p.getName().charAt(i))
    				return -1;	
    		}
    	}
    	//if all previous letters are equal, the word with more letters is considered "greater"
    	if (_name.length() > p.getName().length())
    		return 1;
    	else{
    		if (_name.length() < p.getName().length())
    			return -1;
    		else return 0;
    	}
    	
    }
    
}