//Circle Class Implementing Shape Interface and Override calculateArea()
class Circle implements Shape {  
    private double radius;  
      
    // Constructor, getters and setters  
      
    @Override  
    public double calculateArea() {  
        return Math.PI * radius * radius;  
    }  
} 
