package my.cool.model;


public class Person {
	private int age;
    private String name;
    
    public Person() {
	}

    public Person(String name) {
        this.name = name;
    }
    
    public Person(int age, String name){
    	this.age = age;
    	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getAge() {
    	return age;
    }
    
}
