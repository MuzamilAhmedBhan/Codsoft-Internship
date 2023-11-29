import java.util.*;
public class q4 {
    private static final int N = 10;
    private static final int TIME_LIMIT_SECONDS = 10;

    private static ArrayList<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question("Capital of Pakistan?", new String[]{"A. Islamabad", "B. Karachi", "C. Lahore", "D. Peshawar"}, 'A'));
        questions.add(new Question("Longest river in Pakistan?", new String[]{"A. Indus", "B. Jhelum", "C. Chenab", "D. Ravi"}, 'A'));
        questions.add(new Question("National language of Pakistan?", new String[]{"A. Urdu", "B. Punjabi", "C. Sindhi", "D. Pashto"}, 'A'));
        questions.add(new Question("Mountain range in Pakistan?", new String[]{"A. Himalayas", "B. Karakoram", "C. Hindu Kush", "D. Pamir"}, 'B'));
        questions.add(new Question("Most centuries in cricket?", new String[]{"A. Imran Khan", "B. Javed Miandad", "C. Inzamam-ul-Haq", "D. Younis Khan"}, 'D'));
        questions.add(new Question("Largest city in Pakistan?", new String[]{"A. Karachi", "B. Lahore", "C. Faisalabad", "D. Islamabad"}, 'A'));
        questions.add(new Question("Province 'Land of Five Rivers'?", new String[]{"A. Punjab", "B. Sindh", "C. KPK", "D. Balochistan"}, 'A'));
        questions.add(new Question("Currency of Pakistan?", new String[]{"A. PKR", "B. Peso", "C. Taka", "D. Riyal"}, 'A'));
        questions.add(new Question("Year of Pakistan's independence?", new String[]{"A. 1945", "B. 1947", "C. 1950", "D. 1960"}, 'B'));
        questions.add(new Question("National flower of Pakistan?", new String[]{"A. Rose", "B. Lily", "C. Jasmine", "D. Sunflower"}, 'C'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println("Q: " + question.getQuestion());
            displayOptions(question.getOptions());

            System.out.print("Choice (A/B/C/D): ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == question.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. Correct: " + question.getCorrectAnswer() + ".\n");
            }

            // Simulate a timer (in a real application, use a timer thread)
            try {
                Thread.sleep(TIME_LIMIT_SECONDS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + N);
    }

    private static void displayOptions(String[] options) {
        for (String opt : options) {
            System.out.println(opt);
        }
    }

    static class Question {
        private String question;
        private String[] options;
        private char correctAnswer;

        public Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public char getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
