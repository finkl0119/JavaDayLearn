package Day13;

import java.util.Scanner;

class AnimalClass{

	String animal;
	String food;
	
	void animalInit(String animal, String food) {
		System.out.println(animal + " 동물이 " + food + "를 들고 있습니다.");
	}

	String animalInput(){
		
		Scanner scanner = new Scanner(System.in);
		String animal = scanner.next();
		
		return animal;
	}
	
	String foodInput(){
		
		Scanner scanner = new Scanner(System.in);
		String food = scanner.next();
		
		return food;
	}
	
}

public class ClassQuiz03 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 28번 문제 =====");	
		System.out.println();
		
//		동물이 4마리 있습니다.
//		동물은 원숭이, 개, 닭, 돼지가 있습니다.
//		동물들은 자기가 무슨 동물인지와 음식을 들고 있습니다.
//		(단, 여기에서 무슨 동물과 음식은 함수로 통해서만 값을 넣고 사용을 할 수 있습니다.)
//		그리고 마지막으로 어떤 동물이 어떤 음식을 들고 있는지 출력하는 기능을 가지고 있습니다.
//		처음 먹이와 동물 
//		원숭이 - 바나나 / 개 - 뼈다귀 / 닭 - 모이 / 돼지 - 여물
//		이렇게 가지고 있는 것을 어떤 동물이 어떤 음식을 들고 있는지 출력을 해줍니다.
//		그 이후에 먹이를 옆 동물에게 전달을 합니다.
//		원숭이는 바나나는 개에게로 
//		뼈다귀는 닭에게로 
//		닭의 모이는 돼지에게로
//		돼지의 여물은 원숭이에게로 이동을 합니다.
//		그리고 나서는 어떤 동물이 어떤 음식을 들고있는지 출력을 해주면 됩니다.
		
		AnimalClass animalClass1 = new AnimalClass();
		animalClass1.animal = "원숭이";
		animalClass1.food = "바나나";
		
		AnimalClass animalClass2 = new AnimalClass();
		animalClass2.animal = "개";
		animalClass2.food = "뼈다귀";
		
		AnimalClass animalClass3 = new AnimalClass();
		animalClass3.animal="닭";
		animalClass3.food="모이";
		
		AnimalClass animalClass4 = new AnimalClass();
		animalClass4.animal="돼지";
		animalClass4.food="여물";
		
		animalClass1.animalInit(animalClass1.animal, animalClass1.food);
		animalClass2.animalInit(animalClass2.animal, animalClass2.food);
		animalClass3.animalInit(animalClass3.animal, animalClass3.food);
		animalClass4.animalInit(animalClass4.animal, animalClass4.food);
		
		System.out.println();
		System.out.println(" === 옆 동물에게 전달 ===");
		
		animalClass1.animal = animalClass1.animal; 
		animalClass1.food = animalClass2.food; 
		animalClass1.animalInit(animalClass1.animal, animalClass1.food);
		
		animalClass2.animal = animalClass2.animal; 
		animalClass2.food = animalClass3.food; 
		animalClass2.animalInit(animalClass2.animal, animalClass2.food);
		
		animalClass3.animal = animalClass3.animal; 
		animalClass3.food = animalClass4.food; 
		animalClass3.animalInit(animalClass3.animal, animalClass3.food);

		animalClass4.animal = animalClass4.animal; 
		animalClass4.food = animalClass1.food; 
		animalClass4.animalInit(animalClass4.animal, animalClass4.food);
		
	}	
	
	
	
}
