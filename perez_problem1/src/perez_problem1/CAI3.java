package perez_problem1;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;
public class CAI3 {
	private int randomNumber1, randomNumber2, studentAnswer;
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		Scanner input = new Scanner(System.in);
		// generate random numbers with SecureRandomm object
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		// Ask to enter difficulty level of 1, 2, 3, or 4
		int correct = 0, repeat;
		

		// Solve 10 different problems
		for (int i = 0; i < 10; i++) {
			// Two numbers sampled from a uniform random distribution with bounds determined by the problem difficulty
			
			setRandomNumber1(secureRandomGenerator.nextInt(10));
			setRandomNumber2(secureRandomGenerator.nextInt(10));
			
			
			askQuestion();
			setStudentAnswer(input.nextInt());
			// display random positive message if correct
			// display random negative message if incorrect
			if (isAnswerCorrect()) {
				displayCorrectResponse();
				correct++;
			} else {
				displayIncorrectResponse();
			}
			
		}
		// display student score after student has attempted to solve 10 problems
		// Score is percentage of problems correctly solved
		// Print message for >=75% and <75%
		displayCompletionMessage(correct);
			
		// Ask if student would like to solve new problem set, if yes then restart, if no then terminate
		System.out.println("Would you like to solve new problem set?");
		System.out.println("1 - yes");
		System.out.println("2 - no");
		repeat = input.nextInt();
		if (repeat == 1) {
			quiz();
		}

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
	public static void displayCompletionMessage(int correct) {
		// prints out the student's score and appropriate score response
		double score;
		score = (correct / 10.0) * 100;
		System.out.printf("Quiz score: %.2f%% \n", score);
		if (score >= 75.00) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		CAI3 quiz = new CAI3();
		quiz.quiz();
	}
	
	

}

