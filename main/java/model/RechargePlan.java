package model;

public class RechargePlan {
    private int id;
    private int operatorId; 
    private String planName;
    private String planDescription;
    private double price;

   
    public RechargePlan(int id, int operatorId, String planName, String planDescription, double price) {
        this.id = id;
        this.operatorId = operatorId;
        this.planName = planName;
        this.planDescription = planDescription;
        this.price = price;
    }

    
    public int getId() {
        return id;
    }
 

    public int getOperatorId() {
        return operatorId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public double getPrice() {
        return price;
    }
}
