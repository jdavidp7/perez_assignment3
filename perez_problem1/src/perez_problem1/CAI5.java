package perez_problem1;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;
public class CAI5 {
	private int problemType, difficultyType, randomNumber1, randomNumber2, studentAnswer;
	public void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		Scanner input = new Scanner(System.in);
		// generate random numbers with SecureRandomm object
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		// Ask to enter difficulty level of 1, 2, 3, or 4
		int difficultyLevel, problemType, correct = 0, repeat, mix = 0;
		while (1 > 0) {
			System.out.println("Enter difficulty level: 1 - 2 - 3 - 4");
			difficultyLevel = input.nextInt();
			if (difficultyLevel >= 1 && difficultyLevel <= 4) {
				break;
			}
			else {
				System.out.println("Invalid option");
			}
		}
		setDifficultyType(difficultyLevel);
		// Ask student to enter a problem type of 1, 2, 3, 4, or 5 with an appropriate label
		while(1 > 0) {
			System.out.println("Select a problem type:");
			System.out.println("1. Addition");
			System.out.println("2. Multiplication");
			System.out.println("3. Subtraction");
			System.out.println("4. Division");
			System.out.println("5. Mix");
			problemType = input.nextInt();
			if (problemType >= 1 && problemType <= 5) {
				break;
			} else {
				System.out.println("Invalid option");
			}
		}
		setProblemType(problemType);
		if (readProblemType() == 5) {
			mix = 1;
		}

		// Solve 10 different problems
		for (int i = 0; i < 10; i++) {
			// Two numbers sampled from a uniform random distribution with bounds determined by the problem difficulty
			if (mix == 1) {
				int rand = 0;
				while(rand == 0 || rand >= 5) {
					rand = secureRandomGenerator.nextInt(5);
				}
				setProblemType(rand);
			}
			setRandomNumber1(secureRandomGenerator.nextInt(generateQuestionArgument()));
			setRandomNumber2(secureRandomGenerator.nextInt(generateQuestionArgument()));
			
			if (readProblemType() == 4) {
				while (1 > 0) {
					while (getRandomNumber2() == 0 || getRandomNumber1() == 0 || getRandomNumber2() > getRandomNumber1()) {
						setRandomNumber1(secureRandomGenerator.nextInt(generateQuestionArgument()));	
						setRandomNumber2(secureRandomGenerator.nextInt(generateQuestionArgument()));
					}
					if (getRandomNumber1() % getRandomNumber2() == 0) {
						break;
					}else {
						setRandomNumber1(secureRandomGenerator.nextInt(generateQuestionArgument()));

						setRandomNumber2(secureRandomGenerator.nextInt(generateQuestionArgument()));
						continue;
					}
					


					
				}
			}
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
			if (mix == 1) {
				setProblemType(secureRandomGenerator.nextInt(5));
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
	public String operation() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		
		if (readProblemType() == 1) {
			return "plus";
		}
		else if (readProblemType() == 2) {
			return "times";
		}
		else if (readProblemType() == 3) {
			return "minus";
		}
		else if (readProblemType() == 4) {
			return "divided by";
		}
		else if (readProblemType() == 5 || readProblemType() == 0) {
			int rand = 0;
			while(rand == 0) {
				rand = secureRandomGenerator.nextInt(5);
			}
			setProblemType(rand);
			return operation();
		} 
		return "oops";
		
	}
	public int readProblemType() {
		//  reads the problem type from the student
		// 1-addition 2-multiplication 3-subtraction 4-division 5-random mix
		return problemType;
	}
	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}
	public int readDifficultyType() {
		// reads the difficulty level from the student
		
		return difficultyType;
	}
	public void setDifficultyType(int difficultyType) {
		this.difficultyType = difficultyType;
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
	
	public int generateQuestionArgument() {
		// Use difficulty level to generate a random number
		if (readDifficultyType() == 1) {
			// Difficulty level of 1 shall limit random numbers to range of 0-9, inclusive
			return 10;
		} else if (readDifficultyType() == 2) {
			// Difficulty level of 2 shall limit random numbers to range of 0-99, inclusive
			return 100;
		} else if (readDifficultyType() == 3) {
			// Difficulty level of 3 shall limit random numbers to range of 0-999, inclusive
			return 1000;
		} else if (readDifficultyType() == 4) {
			// Difficulty level of 4 shall limit random numbers to range of 0-9999, inclusive
			return 10000;
		} else {
			return 0;
		}

	}
	public void askQuestion() throws NoSuchAlgorithmException, NoSuchProviderException {
		// prints the problem to the screen
		System.out.println("How much is " + getRandomNumber1() + " " + operation() + " " + getRandomNumber2() + "?");
	}
	public boolean isAnswerCorrect() {
		// Checks to see if student's answer matches the correct answer to the problem
		int a;
		if (readProblemType() == 1) {
			a = getRandomNumber1() + getRandomNumber2();
			if (a == getStudentAnswer()) {
				return true;
			} else {
				return false;
			}
		}
		if (readProblemType() == 2) {
			a = getRandomNumber1() * getRandomNumber2();
			if (a == getStudentAnswer()) {
				return true;
			} else {
				return false;
			}
		}
		if (readProblemType() == 3) {
			a = getRandomNumber1() - getRandomNumber2();
			if (a == getStudentAnswer()) {
				return true;
			} else {
				return false;
			}
		}
		if (readProblemType() == 4) {
			a = getRandomNumber1() / getRandomNumber2();
			if (a == getStudentAnswer()) {
				return true;
			} else {
				return false;
			}
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
		CAI5 quiz = new CAI5();
		quiz.quiz();
	}
	
	

}

