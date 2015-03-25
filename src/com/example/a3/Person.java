package com.example.studentdatabase;   // **Update your package name here!

public abstract class Person {

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
}