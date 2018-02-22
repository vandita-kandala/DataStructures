
class Top{  
void dog(){System.out.println("eating...");}  
}  



class Dog extends Top{ 
	@Override
void dog(){System.out.println("barkiwwng...");}  
}  



class BabyDog extends Dog{  
}  




class Animal extends BabyDog{  
	void dog(){System.out.println("animal...");}  

public static void main(String args[]){  
Top d = new Dog();  

d.dog();  
}

} 