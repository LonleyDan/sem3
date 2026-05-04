package se.kth.iv1350.seminar3.dto;

/**
 * CustomerDTO that contains the primative data of customer and bike information.
 * Contains getter method to retrive data.
 */
public class CustomerDTO {
    // Could make this final but sometimes customer change for example phonenumber or email.
    private String phoneNumber;
    private String name;
    private String email;
    private String bikeBrand;
    private int bikeModel;
    private int bikeSerialNo;


    /**
     * Creates CustomerDTO that contains all personal information and bike information.
     * 
     * Used Source action to quickly generate constructors and getter for them. 
     * @param bikeBrand The Bikebrand.
     * @param bikeModel The bike model.
     * @param bikeSerialNo The bikes serial number.
     * @param email Customers email.
     * @param name Customers name
     * @param phoneNumber Customers phone number.
     */ 
    public CustomerDTO(String bikeBrand, int bikeModel, int bikeSerialNo, String email, String name, String phoneNumber) {
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNo = bikeSerialNo;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Used Source action to quickly generate getter for each property then retrns them. 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public int getBikeModel() {
        return bikeModel;
    }

    public int getBikeSerialNo() {
        return bikeSerialNo;
    }

}
