
import java.util.Scanner;

public class calculateFinalGradess {
    public static void main(String[] args) {
        double quiz, midterm, lastterm;
        double percentageQuiz, percentageMid;
        double passingGrade;
        double average1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the passing grade: ");
        passingGrade = scan.nextInt();
        System.out.println("Enter the quiz grade: ");
        quiz = scan.nextInt();

        

        while (true) {
            System.out.println("Enter the effect of the quiz grade on the percentage: ");
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter decimal number between 0 and 1 (like 0.2).");
                scan.next(); // Geçersiz girişi tüket
            }
            percentageQuiz = scan.nextDouble();

            if (percentageQuiz > 0 && percentageQuiz < 1) {
                break; // Doğru giriş yapıldığında döngüyü sonlandır
            } else {
                System.out.println("Please enter a percentage between 0 and 1.");
                // Else bloğunda döngünün başına geri dön
                continue;
            }
        }

        System.out.println("Enter the midterm grade: ");
        midterm = scan.nextInt();

        while (true) {
            System.out.println("Enter the effect of the midterm grade on the percentage: ");
            
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number:");
                scan.next(); // Geçersiz girişi tüket
            }
            percentageMid = scan.nextDouble();

            if (percentageMid > 0 && percentageMid < 1) {
                System.out.println("Valid percentage entered: " + percentageMid);
                break;
            } else {
                System.out.println("Please enter a percentage between 0 and 1.");
                continue;
            }
        }

        average1 = (quiz * percentageQuiz) + (midterm * percentageMid);
        System.out.println("Your average is:" + average1);

        lastterm = (passingGrade - (quiz * percentageQuiz) - (midterm * percentageMid))
                / (1 - (percentageMid + percentageQuiz));

        passingGrade = (quiz * percentageQuiz) + (midterm * percentageMid)
                + (lastterm * (1 - (percentageMid + percentageQuiz)));

        lastterm = (int) lastterm;

        if (average1 < 50) {
            System.out.println("You need to get " + lastterm + " for pass.");
        } else {
            System.out.println("You are already passed.");
        }

        scan.close();
    }

}
