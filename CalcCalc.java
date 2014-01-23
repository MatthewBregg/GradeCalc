
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalcCalc extends JFrame
{
	private static final int WIDTH = 700;
	private static final int HEIGHT = 1000;
	
	private JLabel exam1L, exam2L, exam3L, exam4L, examresultL, WebAssignL,WebAssignNL,WAresultL, ClickerL,ClickerResultsL,SelfEvalL,HWL,resultHWL,numHWL,QZL,resultQZL,numQZL,OverallGradeL;
	private JTextField exam1TF, exam2TF, exam3TF, exam4TF,WebAssignTF,WebAssignNTF,ClickerTF,ClickerResultsTF,SelfEvalTF,HWTF,numHWTF,QZTF,numQZTF;
	private JButton calculateB, exitB;
	private TextArea examresultTF,WAresultTF,resultHWTF,resultQZTF,OverallGradeTF;
	//Button handlers:
	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	
	public CalcCalc()
	{
		//labels
		exam1L = new JLabel("Exam 1 points: ", SwingConstants.RIGHT);
		exam2L = new JLabel("Exam 2 points: ", SwingConstants.RIGHT);
		exam3L = new JLabel("Exam 3 points: ", SwingConstants.RIGHT);
		exam4L = new JLabel("Exam 4 points: ", SwingConstants.RIGHT);
		examresultL = new JLabel("Exam Points and Percentage: ", SwingConstants.RIGHT);
		WebAssignL = new JLabel("WA Quiz + HW points(out of 50): ", SwingConstants.RIGHT);
		WebAssignNL = new JLabel("WA Quiz & HW that you are on: ", SwingConstants.RIGHT);
		WAresultL = new JLabel("WA Points and Percentage: ", SwingConstants.RIGHT);
		ClickerL = new JLabel("Clicker Attendance(Percentage): ", SwingConstants.RIGHT);
		ClickerResultsL = new JLabel("Clicker Points and Percentage: ", SwingConstants.RIGHT);
		SelfEvalL = new JLabel("Points from Self Evaluation: ", SwingConstants.RIGHT);
		HWL = new JLabel("Sum of Homework Points: ", SwingConstants.RIGHT);
		resultHWL = new JLabel("Points and Percentage from HW: ", SwingConstants.RIGHT);
		numHWL = new JLabel("Amount of homework assignments turned in: ", SwingConstants.RIGHT);
		QZL = new JLabel("Sum of Non-Dropped Quiz Points(Max 25): ", SwingConstants.RIGHT);
		resultQZL = new JLabel("Points and Percentage from Quiz: ", SwingConstants.RIGHT);
		numQZL = new JLabel("Amount of Quizes Taken: ", SwingConstants.RIGHT);
		OverallGradeL = new JLabel("Overall Grade: ", SwingConstants.RIGHT);
//text boxes  
		 	QZTF = new JTextField(21);
		numQZTF = new JTextField(21);

		HWTF = new JTextField(21);
		numHWTF = new JTextField(21);
		SelfEvalTF = new JTextField(21);
		ClickerResultsTF = new JTextField(21);
		ClickerTF = new JTextField(21);
		exam1TF = new JTextField(21);
		exam2TF = new JTextField(21);
		exam3TF = new JTextField(21);
		exam4TF = new JTextField(21);
		resultHWTF = new TextArea();
		resultQZTF = new TextArea();
		OverallGradeTF = new TextArea();
		WAresultTF = new TextArea();
		examresultTF= new TextArea();
	    WebAssignTF= new JTextField(21);
		WebAssignNTF= new JTextField(21);
		//SPecify handlers for each button and add (register) ActionListeners to each button.
		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		setTitle("MAC2312 Grade Calculator");
		Container pane = getContentPane();
	
		pane.setLayout(new GridLayout(19, 2));
		
		//Add things to the pane in the order you want them to appear (left to right, top to bottom)
		pane.add(exam1L);
	
		pane.add(exam1TF);
		pane.add(exam2L);
		pane.add(exam2TF);
		pane.add(exam3L);
		pane.add(exam3TF);
		pane.add(exam4L);
		pane.add(exam4TF);
		pane.add(examresultL);
		pane.add(examresultTF);
	    pane.add(WebAssignL);
		pane.add(WebAssignTF);
		pane.add(WebAssignNL);
		pane.add(WebAssignNTF);
		pane.add(WAresultL);
		pane.add(WAresultTF);
		pane.add(ClickerL);
		pane.add(ClickerTF);
		pane.add(ClickerResultsL);
		pane.add(ClickerResultsTF);
		pane.add(SelfEvalL);
		pane.add(SelfEvalTF);
		pane.add(HWL);
		pane.add(HWTF);
		pane.add(numHWL);
		pane.add(numHWTF);
		pane.add(resultHWL);
		pane.add(resultHWTF);
		pane.add(QZL);
		pane.add(QZTF);
		pane.add(numQZL);
		pane.add(numQZTF);
		pane.add(resultQZL);
		pane.add(resultQZTF);
		pane.add(OverallGradeL);
		pane.add(OverallGradeTF);
		pane.add(calculateB);
		pane.add(exitB);
	    
		//Set editability
		WAresultTF.setEditable(false);
		ClickerResultsTF.setEditable(false);
		examresultTF.setEditable(false);
		resultHWTF.setEditable(false);
		resultQZTF.setEditable(false);
		//Jframe stuff	
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	    
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//calculates exam grades
			double ex1gd,ex2gd,ex3gd,ex4gd,scoreexam,overexam,bestexam;
			overexam = 240;
			String ex4g,ex1g,ex2g,ex3g,examoutput,unknown;
			unknown="";
			//if true, whats needed will be processed
			Boolean needed = false;
		   	ex1g = (exam1TF.getText()); //Get exam scores
			ex2g = (exam2TF.getText());
			ex3g = (exam3TF.getText());
			ex4g = (exam4TF.getText());
			//	score = (ex3g+ex2g+ex1g) ;
			if (ex1g.equalsIgnoreCase("") || ex1g.equalsIgnoreCase("x")){
				overexam=overexam-60;
				ex1gd = 0;
				unknown=unknown + "Exam 1, ";
			}
			else
			{
				ex1gd = Double.parseDouble(ex1g);
			}
			if (ex2g.equalsIgnoreCase("") ||  ex2g.equalsIgnoreCase("x")){
				overexam=overexam-60;
				ex2gd = 0;
				unknown=unknown + "Exam 2, ";
			}
			else
			{
				ex2gd = Double.parseDouble(ex2g);
			}

			if (ex3g.equalsIgnoreCase("") ||  ex3g.equalsIgnoreCase("x")){
				overexam=overexam-60;
				ex3gd = 0;
				unknown=unknown + "Exam 3, ";
				
			}
			else
			{
				ex3gd = Double.parseDouble(ex3g);
			}

			if (ex4g.equalsIgnoreCase("") ||  ex4g.equalsIgnoreCase("x")){
				overexam=overexam-60;
				ex4gd = 0;
				unknown=unknown + "Exam 4, ";
			}
			else
			{
				ex4gd = Double.parseDouble(ex4g);
			}
		if (overexam == 0){
			examoutput = ("No Exams Entered");
		    
			scoreexam=0;
			bestexam=0;
		}
		else
		{

			scoreexam = (ex1gd+ex2gd+ex3gd+ex4gd);
			bestexam = scoreexam;
			examoutput = (""+scoreexam+" out of "+overexam+" or percentage wise, "+ Math.floor((((ex1gd+ex2gd+ex3gd+ex4gd)/overexam)*10000))/100+"%");
		}
		if (overexam!=240 && overexam!=0){
			scoreexam = (ex1gd+ex2gd+ex3gd+ex4gd);
			bestexam = scoreexam+ (240-overexam);
			examoutput=examoutput+"\n If you ace the remaining exam(s), you can get "+((240-overexam)+ex1gd+ex2gd+ex3gd+ex4gd)+" out of "+240+" or percentage wise, "+ Math.floor((((ex1gd+ex2gd+ex3gd+ex4gd+(240-overexam))/240)*10000))/100+"%";

		}
		else;





examresultTF.setText(examoutput);

//end calculating exam grades

//begin calculating WA grades


String WAscore,WAn,WAresult;
double WAscoreD,WAnD,scoreWA,bestWA;
WAscore = (WebAssignTF.getText()); //Get WA scores
WAn = (WebAssignNTF.getText());
WAresult="";
scoreWA=0;
bestWA=0;
//Take care of Blank space
if (WAscore.equalsIgnoreCase("") ||  WAscore.equalsIgnoreCase("x")){
		    
			    WAscoreD = 0;
				unknown=unknown + "WA, ";
				
				
			}
			else
			{
				WAscoreD = Double.parseDouble(WebAssignTF.getText());
			}
		if (WAn.equalsIgnoreCase("")){
				
				WAnD = 0;
			}
			else
			{
			    WAnD = Double.parseDouble(WebAssignNTF.getText());
			}

		if (WAnD==0)
		{
			WAresult="No WebAssign done/entered";
			scoreWA=0;
			bestWA=50;
		}

		else if (WAscoreD >= 50) {

			WAresult="WebAssign maxed";
			WAscoreD=50;
			scoreWA=50;
			bestWA=50;
		}

		else if (WAnD == 10) {

			scoreWA=WAscoreD;
			WAresult=(""+scoreWA+" out of "+50+" or percentage wise, "+Math.floor((scoreWA/(50)*100)*100)/100+"%");
			bestWA=scoreWA;

			
		}


		else if (WAnD <= 10) {
			double WA2nD;
			if (WAnD*6 >= 50){WA2nD=50;}
			else{WA2nD=WAnD*6;}
			scoreWA=WAscoreD;
			WAresult=(""+scoreWA+" out of "+WA2nD+" or percentage wise, "+Math.floor((scoreWA/(WA2nD)*100)*100)/100+"%");
			bestWA=(scoreWA+(10-WAnD)*6);
			WAresult=WAresult+("\nIf you ace the remaining WA, you can get "+bestWA+" out of "+50+" or percentage wise, "+Math.floor((bestWA/(50)*100)*100)/100+"%");
			
		}




    
		WAresultTF.setText(WAresult);

		//endWebassigncalculations

		//beginattendence
		String ClickerScore,resultClick;
		double scoreClick,bestClick;
		ClickerScore=ClickerTF.getText();
		if (ClickerScore.equalsIgnoreCase("") ||  ClickerScore.equalsIgnoreCase("x")){
			    scoreClick = 0;
				bestClick = 25;
			    resultClick = "No value was input";
				unknown=unknown+"Clicker, ";
			}
			else
			{
			   resultClick =  ClickerScore;
			   ClickerScore = ClickerScore.replace("%", "\0");
			   scoreClick = (Double.parseDouble(ClickerScore)/4);
			   bestClick = scoreClick;
			}



	ClickerResultsTF.setText(resultClick);
//endattendence

	//self eval
	String SelfScore;
	double scoreSelf,bestSelf;
	scoreSelf=0;
	bestSelf=0;
	SelfScore=SelfEvalTF.getText();
		if (SelfScore.equalsIgnoreCase("")){
    
			    scoreSelf = 0;
				bestSelf=2;
			}
			else
			{
			  
			   scoreSelf = Double.parseDouble(SelfScore);
			   bestSelf=scoreSelf;
			}



		//System.out.println(scoreSelf);

//endselfeval

//beginHW
String HWscore,HWn,HWresult;
double HWscoreD,HWnD,scoreHW,bestHW;
HWscore = (HWTF.getText()); //Get HW scores
HWn = (numHWTF.getText());
HWresult="";
scoreHW=0;
bestHW=0;
//Take care of Blank space
if (HWscore.equalsIgnoreCase("") ||  HWscore.equalsIgnoreCase("x")){
		    
			    HWscoreD = 0;
				unknown=unknown + "HW, ";
			}
			else
			{
				HWscoreD = Double.parseDouble(HWTF.getText());
			}
		if (HWn.equalsIgnoreCase("")){
				
				HWnD = 0;
			}
			else
			{
			    HWnD = Double.parseDouble(numHWTF.getText());
			}

		if (HWnD==0)
		{
			HWresult="No HW done/entered";
			scoreHW=0;
			bestHW=25;
		}

	
		else if (HWnD == 5) {

			scoreHW=HWscoreD;
			HWresult=(""+scoreHW+" out of "+25+" or percentage wise, "+Math.floor((scoreHW/(25)*100)*100)/100+"%");
			bestHW=scoreHW;

			
		}


		else if (HWnD <= 5) {
			double HW2nD;
		    HW2nD=HWnD*5;
			scoreHW=HWscoreD;
			HWresult=(""+scoreHW+" out of "+HW2nD+" or percentage wise, "+Math.floor((scoreHW/(HW2nD)*100)*100)/100+"%");
			bestHW=(scoreHW+(5-HWnD)*5);
			HWresult=HWresult+("\nIf you ace the remaining HW, you can get "+bestHW+" out of "+25+" or percentage wise, "+Math.floor((bestHW/(25)*100)*100)/100+"%");
			
		}




    
		resultHWTF.setText(HWresult);




//endhw
//beginquizes
		String QZscore,QZn,QZresult;
double QZscoreD,QZnD,scoreQZ,bestQZ;
QZscore = (QZTF.getText()); //Get QZ scores
QZn = (numQZTF.getText());
QZresult="";
scoreQZ=0;
bestQZ=0;
//Take care of Blank space
if (QZscore.equalsIgnoreCase("") ||  QZscore.equalsIgnoreCase("x")){
		    
			    QZscoreD = 0;
				unknown=unknown + "Quiz, ";
			}
			else
			{
				QZscoreD = Double.parseDouble(QZTF.getText());
			}
		if (QZn.equalsIgnoreCase("")){
				
				QZnD = 0;
			}
			else
			{
			    QZnD = Double.parseDouble(numQZTF.getText());
			}

		if (QZnD==0)
		{
			QZresult="No Quiz done/entered";
			scoreQZ=0;
			bestQZ=25;
		}

	
		else if (QZnD == 6) {

			scoreQZ=QZscoreD;
			QZresult=(""+scoreQZ+" out of "+25+" or percentage wise, "+Math.floor((scoreQZ/(25)*100)*100)/100+"%");
			bestQZ=scoreQZ;

			
		}


		else if (QZnD <= 5) {
			double QZ2nD;
		    QZ2nD=((QZnD-1)*5);
			scoreQZ=QZscoreD;
			QZresult=(""+scoreQZ+" out of "+QZ2nD+" or percentage wise, "+Math.floor((scoreQZ/(QZ2nD)*100)*100)/100+"%");
			bestQZ=(scoreQZ+(6-QZnD)*5);
			QZresult=QZresult+("\nIf you ace the remaining Quiz, you can get "+bestQZ+" out of "+25+" or percentage wise, "+Math.floor((bestQZ/(25)*100)*100)/100+"%");
			
		}




    
		resultQZTF.setText(QZresult);

//endquizes

//Current Grade Calc
		String OverallResult,Grade,BestGrade, bestGrade, totalGrade;
		Double TotalPoints, TotalPointsBest;
		OverallResult="";
		TotalPoints = scoreQZ + scoreHW + scoreSelf + scoreClick + scoreWA + scoreexam;
		TotalPointsBest = bestQZ + bestHW + bestSelf + bestClick + bestWA + bestexam;
		totalGrade=lettergrade(TotalPoints);
		bestGrade=lettergrade(TotalPointsBest);
		if (ex1g.equalsIgnoreCase("x") || ex2g.equalsIgnoreCase("x") || ex3g.equalsIgnoreCase("x") || ex4g.equalsIgnoreCase("x") || ClickerScore.equalsIgnoreCase("x") || QZscore.equalsIgnoreCase("x") || HWscore.equalsIgnoreCase("x") || WAscore.equalsIgnoreCase("x")) 
		{
			double desired;
	desired = Double.parseDouble(OverallGradeTF.getText());
	OverallResult="The total of "+unknown+"must be at least "+((desired-TotalPoints))+"points.";

		}
		else{

		OverallResult="Your current points are: "+TotalPoints+", Which is "+totalGrade+"\n"+" The most points you could get is: "+TotalPointsBest+", Which is "+bestGrade+"\n Best possibly grade does not take into account extra credit on exams, or the possibility of a higher attendence." ;
		}



		OverallGradeTF.setText(OverallResult);
		//end calculations	
		}

			public String lettergrade(double grade)
			{
				if (grade<=204.4){return "E";}
				else if (grade<=218.99){return "a D-";}
				else if (grade<=229.94){return "a D";}
				else if (grade<=240.89){return "a D+";}
				else if (grade<=248.19){return "a C-";}
				else if (grade<=266.44){return "a C";}
				else if (grade<=277.39){return "a C+";}
				else if (grade<=291.99){return "a B-";}
				else if (grade<=302.94){return "a B";}
				else if (grade<=313.89){return "a B+";}
				else if (grade<=328.49){return "an A-";}
				
				else
				return "an A";
				} 
	}
	
	public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		CalcCalc gradecalc = new CalcCalc();
	}
	
}
