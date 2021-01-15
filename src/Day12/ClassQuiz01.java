package Day12;

class Pencil {
	
	String pencil = "연필";
	String pencilColor;
	
	public void draw() {
		
		System.out.println(pencil+"은 쓰는 기능");
		System.out.println("쓰는 기능은 "+ pencilColor + " " + pencilColor + "로 적습니다.");
		
	}
}

class Eraser {
	
	String eraser = "지우개";
	String eraserCompany;
	
	public void draw() {
		
		System.out.println(eraser+"는 지우는 기능");
		System.out.println(eraser + "를 "+ eraserCompany + " 제품으로 지웁니다.");
		
	}
}

class Pen {
	
	String pen = "펜";
	String penColor;
	String penCompany;
	
	public void draw() {
		
		System.out.println(pen+"은 쓰는 기능");
		System.out.println(pen+ "을 "+ penCompany + " 제품의 " + penColor + "으로 씁니다.");
		
	}
}


public class ClassQuiz01 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 26번 문제 =====");	

//		연필, 지우개, 펜이 있습니다.
//		
//		연필은 각각 빨강, 파란, 주황, 노란 색을 가지고 있습니다.
//		그리고 연필은 쓰는 기능(출력) 이 있습니다.
//		예) 쓰는 기능은 빨간색 연필로 적습니다.(출력)
//
//			지우개는 각각 잠자리, 모닝글로리의 제조사가 있습니다.
//			그리고 지우개는 지우는 기능(출력)이 있습니다.
//		예) 지우개를 잠자리의 제품으로 지웁니다.(출력)
//
//			펜은 검정색 - 모나미 / 초록 - 제트스트림 / 베이비블루 - 워터맨을 가지고 있습니다.
//			그리고 펜은 쓰는기능(출력)이 있습니다.
//		예) 펜을 모나미 제품의 검정색으로 씁니다.(출력)
//
//		먼저 4개의 연필을 쓰고 그다음 2개의 지우개로 지우고 
//		마지막으로 3개의 펜을 쓰는 프로그램을 만들어 주세요.
// 객체 9개로
		
		Pencil pencilRed = new Pencil();
		pencilRed.pencilColor = "빨간색";
		//System.out.println(pencilRed.pencil+"은 쓰는 기능");
		//System.out.println("쓰는 기능은 "+ pencilRed.pencilColor + " " + pencilRed.pencilColor + "로 적습니다.");
		pencilRed.draw();
		
		Pencil pencilBlue = new Pencil();
		pencilBlue.pencilColor = "파란색";
		//System.out.println(pencilBlue.pencil+"은 쓰는 기능");
		//System.out.println("쓰는 기능은 "+ pencilBlue.pencilColor+ " " + pencilBlue.pencil + "로 적습니다.");
		pencilBlue.draw();
		
		Pencil pencilOrange = new Pencil();
		pencilOrange.pencilColor = "주황색";
		//System.out.println(pencilOrange.pencil+"은 쓰는 기능");
		//System.out.println("쓰는 기능은 "+ pencilOrange.pencilColor + " " + pencilOrange.pencil+ "로 적습니다.");
		pencilOrange.draw();
		
		Pencil pencilYello = new Pencil();
		pencilYello.pencilColor = "노란색";
		//System.out.println(pencilYello.pencil+"은 쓰는 기능");
		//System.out.println("쓰는 기능은 "+ pencilYello.pencilColor+ " " + pencilYello.pencil+ "로 적습니다.");
		pencilYello.draw();
		
		//===================================================================================
		
		Eraser EraserDragonfly = new Eraser();
		EraserDragonfly.eraserCompany = "잠자리";
		//System.out.println(EraserDragonfly.eraser+"는 지우는 기능");
		//System.out.println(EraserDragonfly.eraser + "를 "+ EraserDragonfly.eraserCompany + " 제품으로 지웁니다.");
		EraserDragonfly.draw();
		
		Eraser EraserMorning = new Eraser();
		EraserMorning.eraserCompany = "모닝글로리";
		//System.out.println(EraserMorning.eraser+"는 지우는 기능");
		//System.out.println(EraserMorning.eraser + "를 "+ EraserMorning.eraserCompany + " 제품으로 지웁니다.");
		EraserMorning.draw();
		
		//===================================================================================
		
		Pen penMonami = new Pen();
		penMonami.penColor = "검정색";
		penMonami.penCompany = "모나미";
		//System.out.println(penMonami.pen+"은 쓰는 기능");
		//System.out.println(penMonami.pen+ "을 "+ penMonami.penCompany + " 제품의 " + penMonami.penColor + "으로 씁니다.");
		penMonami.draw();
		
		Pen penJetstream = new Pen();
		penJetstream.penColor = "초록색";
		penJetstream.penCompany = "제트스트림";
		//System.out.println(penJetstream.pen+"은 쓰는 기능");
		//System.out.println(penJetstream.pen + "을 "+ penJetstream.penCompany + " 제품의 " + penJetstream.penColor + "으로 씁니다.");
		penJetstream.draw();
		
		Pen penWaterman = new Pen();
		penWaterman.penColor = "베이비블루색";
		penWaterman.penCompany = "워터맨";
		//System.out.println(penWaterman.pen+"은 쓰는 기능");
		//System.out.println(penWaterman.pen + "을 "+ penWaterman.penCompany + " 제품의 " + penWaterman.penColor + "으로 씁니다.");
		penWaterman.draw();
		
	}	
	
	
}
