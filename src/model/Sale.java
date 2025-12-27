package model;

import java.util.ArrayList;

public class Sale {
    private String date;
    private String time;
    private String customerName;
    private ArrayList <String> watchModel; // Storing items as an array
    private double subtotal;
    private String employeeName;
    private String transactionMethod;
    private String transactionState;

    // Constructor: This receives all the data when you create a 'new Sale'
    public Sale(String date, String time, String customerName, ArrayList<String> watchModel,
                double subtotal, String employeeName, String transactionMethod, String transactionState) {
        this.date = date;
        this.time = time;
        this.customerName = customerName;
        this.watchModel = watchModel;
        this.subtotal = subtotal;
        this.employeeName = employeeName;
        this.transactionMethod = transactionMethod;
        this.transactionState = transactionState;
    }

    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getCustomerName(){
        return customerName;
    }
    public ArrayList<String> getWatchModel() {
        return watchModel;
    }
    public double getSubtotal(){
        return subtotal;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public String getTransactionMethod(){
        return transactionMethod;
    }
    public String getTransactionState(){
        return transactionState;
    }

    public void printReceipt(){
        System.out.println("-------------- Sales Record --------------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("------------------------------------------");
        // Format: Left-align Item (25 spaces), Right-align Qty (5 spaces)
        System.out.printf("%-25s %5s\n", "Model Name", "Qty");

        // "watchModels" is your ArrayList containing strings like "ModelName:Quantity"
        for (String entry : watchModel) {

            // Step 1: Split the entry by the colon separator
            String[] parts = entry.split(":");

            String modelName = parts[0]; // The part BEFORE the :
            String quantity = "1";       // Default to 1 (safety)

            // Step 2: Check if quantity exists (avoid index out of bounds error)
            if (parts.length > 1) {
                quantity = parts[1]; // The part AFTER the :
            }

            // Step 3: Print nicely
            System.out.printf("%-25s %5s\n", modelName, quantity);
        }

        System.out.println("------------------------------------------");
        System.out.println("Date: " + date +"\t Time: " + time);
        System.out.println("Subtotal: RM" + subtotal);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Transaction Method: " + transactionMethod);
        System.out.println("Transaction Status: " + transactionState);
        System.out.println();
    }

    public String salesToCSV(){
        String watchModelStr ="";
        for (int i =0; i<watchModel.size(); i++){
            watchModelStr+= watchModel.get(i);
            if (i<watchModel.size()-1){
                watchModelStr+="|";
            }
        }
        return date+","+time+","+customerName+","+watchModelStr+","+subtotal+","+employeeName+","+transactionMethod+","+transactionState;
    }


}
