//Rectangle Class Implementing Shape Interface and Override calculateArea()
class Rectangle implements Shape {  
    private double width;  
    private double height;  
      
    // Constructor, getters and setters  
      
    @Override  
    public double calculateArea() {  
        return width * height;  
    }  
} 
