package fr.uvsq.zumu_panchi.model;

import java.util.Date;

/**
 * Not used. For future implementation
 * @author paul
 *
 */
public class User {

    private int id;
    
    private String firstname;
    
    private String lastname;
    
    // better than String because we can compare Dates
    private Date birthDate;
    
    private String email;
    
    private String address;
    
    private String phoneNumber;
    
    private int loyaltyPoints;
}
