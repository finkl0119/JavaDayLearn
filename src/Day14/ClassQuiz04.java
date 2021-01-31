package Day14;

import java.util.Scanner;

//1월 18일
class Computer1{
	
	String makeCompany;
	String makeSpecification;
	Integer makePrice;
	
	void SetMakeCompany(String makeCompany) {
		  
		this.makeCompany = makeCompany;
    }
	String GetMakeCompany() {
		return this.makeCompany;
	}
	
	void SetMakeSpecification(String makeSpecification) {
		  
		this.makeSpecification = makeSpecification;
    }
	String GetMakeSpecification() {
		return this.makeSpecification;
	}
	
	void SetMakePrice(Integer makePrice) {
		  
		this.makePrice = makePrice;
    }
	Integer GetMakePrice() {
		return this.makePrice;
	}
	
	void useOk(String makeCompany, String makeSpecification, Integer makePrice) {
		System.out.println("제조사가 " +this.makeCompany+ "인 " + this.makeSpecification + "컴퓨터를 사용한다.");
	}
	
}

class AirConditioner1{
	
	String makeCompany;
	String makeSpecification;
	Integer makePrice;
	
	void SetMakeCompany(String makeCompany) {
		  
		this.makeCompany = makeCompany;
    }
	String GetMakeCompany() {
		return this.makeCompany;
	}
	
	void SetMakeSpecification(String makeSpecification) {
		  
		this.makeSpecification = makeSpecification;
    }
	String GetMakeSpecification() {
		return this.makeSpecification;
	}
	
	void SetMakePrice(Integer makePrice) {
		  
		this.makePrice = makePrice;
    }
	Integer GetMakePrice() {
		return this.makePrice;
	}
	
	void useOk() {
		System.out.println("제조사가 " +makeCompany+ "인 " + makeSpecification + "에어컨을 사용한다.");
	}
	
}

class Refrigerator1{
	
	String makeCompany;
	String makeDoor;
	String makeSpecification;
	Integer makePrice;
	
	void SetMakeCompany(String makeCompany) {
		  
		this.makeCompany = makeCompany;
    }
	String GetMakeCompany() {
		return this.makeCompany;
	}
	
	void SetMakeDoor(String makeDoor) {
		  
		this.makeDoor = makeDoor;
    }
	String GetMakeDoor() {
		return this.makeDoor;
	}
	
	void SetMakeSpecification(String makeSpecification) {
		  
		this.makeSpecification = makeSpecification;
    }
	String GetMakeSpecification() {
		return this.makeSpecification;
	}
	
	void SetMakePrice(Integer makePrice) {
		  
		this.makePrice = makePrice;
    }
	Integer GetMakePrice() {
		return this.makePrice;
	}

	void useOk() {
		System.out.println("제조사가 " +makeCompany+ "인 "+ makeDoor +"형 "+ makeSpecification + " 냉장고가 식품을 관리한다.");
	}
	
}

class AirCleaner1{
	
	String makeCompany;
	Integer makePrice;
	
	void SetMakeCompany(String makeCompany) {
		  
		this.makeCompany = makeCompany;
    }
	String GetMakeCompany() {
		return this.makeCompany;
	}
	
	void SetMakePrice(Integer makePrice) {
		  
		this.makePrice = makePrice;
    }
	Integer GetMakePrice() {
		return this.makePrice;
	}
	
	void useOk() {
		System.out.println("제조사가 " +makeCompany+ "인 공기청정기가 공기를 깨끗하게 한다.");
	}
	
}

class Mart{
	
	Computer1 computer[] = new Computer1[2];
	AirConditioner1 airConditioners[] = new AirConditioner1[2];
	Refrigerator1 refrigerators[] = new Refrigerator1[2];
	AirCleaner1 airCleaners[] = new AirCleaner1[2];
	
}

public class ClassQuiz04 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 30번 문제 =====");	
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		Mart mart = new Mart();
		mart.computer[0].SetMakeCompany("삼성");
		mart.computer[0].SetMakeSpecification("CPU i7");
		mart.computer[0].SetMakePrice(200);
		
		mart.computer[1].SetMakeCompany("LG");
		mart.computer[1].SetMakeSpecification("CPU i5");
		mart.computer[1].SetMakePrice(150);
		
		mart.airConditioners[0].SetMakeCompany("삼성");
		mart.airConditioners[0].SetMakeSpecification("벽걸이");
		mart.airConditioners[0].SetMakePrice(100);
		
		mart.airConditioners[1].SetMakeCompany("LG");
		mart.airConditioners[1].SetMakeSpecification("스탠드");
		mart.airConditioners[1].SetMakePrice(200);
		
		mart.refrigerators[0].SetMakeCompany("삼성");
		mart.refrigerators[0].SetMakeDoor("양문");
		mart.refrigerators[0].SetMakeSpecification("600L");
		mart.refrigerators[0].SetMakePrice(200);
		
		mart.refrigerators[1].SetMakeCompany("LG");
		mart.refrigerators[1].SetMakeDoor("4도어");
		mart.refrigerators[1].SetMakeSpecification("800L");
		mart.refrigerators[1].SetMakePrice(350);
		
		mart.airCleaners[0].SetMakeCompany("LG");
		mart.airCleaners[0].SetMakePrice(80);
		
		mart.airCleaners[1].SetMakeCompany("다이슨");
		mart.airCleaners[1].SetMakePrice(60);
		
		int again = 1;
		while(again<4 && again>0) {
			
			System.out.println(again + "번 소비자 상품을 선택해주세요.");
			System.out.print("1. 컴퓨터 2. 에어컨 3. 냉장고 4. 공기청정기 : ");
			int select_0 = scanner.nextInt();
			if((select_0 < 5) && (select_0 > 0)) {
				if(select_0 == 1) {
					System.out.println("제조사 및 사양을 선택해주세요.");
					System.out.printf("1.삼성(i7) 2.LG(i5) : ");
					int select_1 = scanner.nextInt();
					if(select_1 < 3 && select_1 > 0) {
						for(select_1=1; select_1<mart.computer.length+1; select_1++) {
							mart.computer[select_1].useOk(mart.computer[select_1].GetMakeCompany(), mart.computer[select_1].GetMakeSpecification(), mart.computer[select_1].GetMakePrice());
						}
						again++;	
					}else {
						System.out.println("잘못된 입력값입니다.");
						continue;
					}
					
				}else if(select_0 == 2) {
					System.out.println("제조사 및 종류을 선택해주세요.");
					System.out.printf("1.삼성(벽걸이) 2.LG(스탠드) : ");
					int select_1 = scanner.nextInt();
					again++;
				} else if(select_0 == 3) {
					System.out.println("제조사 및 도어를 선택해주세요.");
					System.out.printf("1.삼성(양문) 2.LG(4도어) : ");
					int select_1 = scanner.nextInt();
					again++;
				}else if (select_0 == 4){
					System.out.println("제조사를 선택해주세요.");
					System.out.printf("1.LG 2.다이슨 : ");
					int select_1 = scanner.nextInt();
					again++;
				} else {
					System.out.println("제조사 번호 선택이 초과 되었습니다.");
					continue;
				}
			}else {
				System.out.println("입력값을 초과하였습니다.");
				continue;
			}
			
			
		}
			
		
	}	

}
