package perez_problem1;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2 {
	private int randomNumber1, randomNumber2, studentAnswer;
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		Scanner input = new Scanner(System.in);
		// generate random numbers with SecureRandomm object
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		// Ask to enter difficulty level of 1, 2, 3, or 4
		

		
		// Two numbers sampled from a uniform random distribution with bounds determined by the problem difficulty
			
		setRandomNumber1(secureRandomGenerator.nextInt(10));
		setRandomNumber2(secureRandomGenerator.nextInt(10));
		askQuestion();
		setStudentAnswer(input.nextInt());
		// display random positive message if correct
		// display random negative message if incorrect
	  while (isAnswerCorrect() == false) {
		  displayIncorrectResponse();
		  askQuestion();
		  setStudentAnswer(input.nextInt());	
		  
	  } 
	
	  displayCorrectResponse();

		
		

		input.close();
		
	}
	
	
	
	
	public int getRandomNumber1() {
		return randomNumber1;
	}
	public void setRandomNumber1(int randomNumber1) {
		this.randomNumber1 = randomNumber1;
	}
	public int getRandomNumber2() {
		return randomNumber2;
	}
	public void setRandomNumber2(int randomNumber2) {
		this.randomNumber2 = randomNumber2;
	}
	public int getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(int studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	

	public void askQuestion() throws NoSuchAlgorithmException, NoSuchProviderException {
		// prints the problem to the screen
		System.out.println("How much is " + getRandomNumber1() + " " + "times" + " " + getRandomNumber2() + "?");
	}
	public boolean isAnswerCorrect() {
		// Checks to see if student's answer matches the correct answer to the problem
		int a;
		a = getRandomNumber1() * getRandomNumber2();
		
		if (getStudentAnswer() == a) {
			return true;
		}
		
		
		return false;
	}
	public static void displayCorrectResponse() throws NoSuchAlgorithmException, NoSuchProviderException {
		// prints out the response when a student enters a correct answer
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int random = secureRandomGenerator.nextInt(3);
		if (random == 0) {
			System.out.println("Very good!");
		}
		if (random == 1) {
			System.out.println("Excellent!");
		}
		if (random == 2) {
			System.out.println("Nice work!");
		}
		if (random == 3) {
			System.out.println("Keep up the good work!");
		}
		
	}
	public static void displayIncorrectResponse() throws NoSuchAlgorithmException, NoSuchProviderException {
		// prints out the response when a student enters an incorrect answer
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int random = secureRandomGenerator.nextInt(3);
		if (random == 0) {
			System.out.println("No, Please try again.");
		}
		if (random == 1) {
			System.out.println("Wrong. Try once more.");
		}
		if (random == 2) {
			System.out.println("Don't give up!");
		}
		if (random == 3) {
			System.out.println("No, keep trying.");
		}
	}

	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		CAI2 quiz = new CAI2();
		quiz.quiz();
	}
	
	

}

