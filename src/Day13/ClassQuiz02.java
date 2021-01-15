package Day13;


//자동차 생산
class MakeCar{

	String carColor;
	String carCompany;
	Integer carSpeed;
	
	public void MakeCarDraw(){
		System.out.println("제조 차량 색상은 " + carColor + ", 제조회사는 " + carCompany + ", 최대속력은 " +carSpeed+ "입니다.");
	}
	
}

//자전거 생산 
class MakeBicycle{
	
	String bicycleCompany;
	String bicycleKinds;
	
	public void MakeBicycleDraw(){
		System.out.println("제조 자전거 회사는 " + bicycleCompany + ", 기능은 " + bicycleKinds +  "입니다.");
	}
}

//오토바이 생산
class MakeBike{
	
	String bikeColor;
	String bikeCompany;
	Integer bikeSpeed;
	
	public void MakeBikeDraw(){
		System.out.println("제조 오토바이 색상은 " + bikeColor + ", 제조회사는 " + bikeCompany + ", 최대속력은 " +bikeSpeed+ "입니다.");
	}
}

//첫번째 사람
class FirstPerson{

	MakeCar car1;
	MakeCar car2;
	void driving(MakeCar makeCar) {
		makeCar.MakeCarDraw();
	}
}

//두번째 사람
class SecondPerson{
	
	MakeBicycle makeBicycle;
	void driving(MakeBicycle makeBicycle) {
		makeBicycle.MakeBicycleDraw();
	}
	
	MakeBike makeBike;
	void Taking(MakeBike makeBike) {
		makeBike.MakeBikeDraw();
	}

}

class AllClass {
	
	MakeCar makeCar1 = new MakeCar();
	MakeCar makeCar2 = new MakeCar();
	MakeCar makeCar3 = new MakeCar();
	MakeCar makeCar4 = new MakeCar();
	
	MakeBicycle makeBicycle1 = new MakeBicycle();
	MakeBicycle makeBicycle2 = new MakeBicycle();
	
	MakeBike makeBike1 = new MakeBike();
	
}

public class ClassQuiz02 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 27번 문제 =====");	
		System.out.println();
		
//		자동차가 존재합니다. 자동차는 색깔과 제조사 최고속력을 가지고 있고 
//		운전하는 기능을 가지고 있습니다
//		
//		자전거가 존재합니다. 자전거는 제조사와 어떤 기능의 자전거인 종류와 
//		타다의 기능을 가지고 있습니다.
//		
//		오토바이가 존재합니다. 오토바이는 색깔과 제조사 최고 속력을 가지고 있습니다.
//		자동차와 똑같이 운전하는 기능을 가지고 있습니다.
//		
//		자동차 색깔 : 은, 검정, 하얀, 형광
//		자동차 제조사 : Ford, BMW, 삼성, 현대
//		최고속력 : 220, 240, 200, 180
//		
//		자전거 제조사 : 삼천리, 자이언트
//		자전거 기능 : 산악용, 접이식용
//		
//		오토바이 제조사 : 대림
//		오토바이 색깔 : 빨간
//		오토바이 최고속력 : 180
//		
//		사람이 두명이 존재합니다.
//		첫번째 사람은 자동차를 두대 가지고 있습니다.
//		두번째 사람은 자전거와 오토바이를 가지고 있습니다.
//		
//		첫번째사람 
//		1번차 : 검정, BMW, 240
//		2번차 : 형광, 현대, 180
//	
//		두번째사람 
//		자전거 : 삼천리, 산악용
//		오토바이 : 대림, 빨간, 180
//		
//		HINT : 차고지에 만들어져있어야함.
//				운전하는 기능, 타다의 기능 따로 Class
			
		AllClass allClass = new AllClass();
		allClass.makeCar1.carColor = "은색";
		allClass.makeCar2.carColor = "검정색";
		allClass.makeCar3.carColor = "하얀색";
		allClass.makeCar4.carColor = "형광색";
		
		allClass.makeCar1.carCompany = "Ford";
		allClass.makeCar2.carCompany = "BMW";
		allClass.makeCar3.carCompany = "삼성";
		allClass.makeCar4.carCompany = "현대";
		
		allClass.makeCar1.carSpeed= 220;
		allClass.makeCar2.carSpeed= 240;
		allClass.makeCar3.carSpeed= 200;
		allClass.makeCar4.carSpeed= 180;
		
		allClass.makeBicycle1.bicycleCompany = "삼천리";
		allClass.makeBicycle2.bicycleCompany = "자이언트";
		
		allClass.makeBicycle1.bicycleKinds = "산악용";
		allClass.makeBicycle2.bicycleKinds = "접이식용";
		
		allClass.makeBike1.bikeColor = "빨간색";
		allClass.makeBike1.bikeCompany = "대림";
		allClass.makeBike1.bikeSpeed = 180;
		
		FirstPerson firstPerson = new FirstPerson();
		firstPerson.car1 = allClass.makeCar2;
		firstPerson.car2 = allClass.makeCar4;
		
		SecondPerson secondPerson = new SecondPerson();
		secondPerson.makeBicycle = allClass.makeBicycle1;
		secondPerson.makeBike = allClass.makeBike1;
		
		System.out.println("==== 첫번째 사람 ====");
		System.out.println();
		
		firstPerson.driving(firstPerson.car1);
		firstPerson.driving(firstPerson.car2);
		
		System.out.println("==== 두번째 사람 ====");
		
		secondPerson.driving(secondPerson.makeBicycle);
		secondPerson.Taking(secondPerson.makeBike);
		
		
	}	
	
	
	
}
