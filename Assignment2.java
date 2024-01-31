import java.util.stream.Collectors;
import java.util.*;

 class Student {
    private int studentId;
    private String name;
    private String email;
    private String contactNumber;

    public Student(int studentId, String name, String email, String contactNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void getDetails(){
        System.out.println("Name: "+name+" Email: "+email+" ContactNumber: "+contactNumber);
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }
}


class Assignment {
    private int assignmentId;
    private String title;
    private String description;
    private String dueDate;
    private List<Question> questions;

    public Assignment(int assignmentId, String title, String description, String dueDate) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.questions = new ArrayList<>();
    }
    public String getTitle(){
        return title;
    }

}

class Trainer {
    private int trainerId;
    private String name;
    private String email;
    private String contactNumber;
    private List<TechStack> techStacks;

    public Trainer(int trainerId, String name, String email, String contactNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.techStacks = new ArrayList<>();
    }

    // Getters and setters
}

class TechStack {
    private int techStackId;
    private String name;
    private String description;

    public TechStack(int techStackId, String name, String description) {
        this.techStackId = techStackId;
        this.name = name;
        this.description = description;
    }

    // Getters and setters
}

class Result {
    private int resultId;
    public Student student;
    private Assignment assignment;
    private Trainer trainer;
    private Question question;
    private int score;
    private String feedback;
    private String submissionDate;

    public Result(int resultId, Student student, Assignment assignment, Trainer trainer,Question question, int score, String feedback, String submissionDate) {            
        this.resultId = resultId;
        this.student = student;
        this.assignment = assignment;
        this.trainer = trainer;
        this.question=question;
        this.score = score;
        this.feedback = feedback;
        this.submissionDate = submissionDate;
    }

    // Getters and setters
    public int getScore(){
        return score;
    }
    public int getId(){
        return resultId;
    }
    public Student getStudent(){
        return student;
    }
    public Question getQuestion(){
        return question;
    }
    public Assignment getAssignment(){
        return assignment;
    }
}

class Question {
    private int questionId;
    private int score;
    private int techStackId;
    private int assignmentId;

    public Question(int questionId,  int score, int techStackId, int assignmentId) {
        this.questionId = questionId;  
        this.score = score;
        this.techStackId = techStackId;
        this.assignmentId = assignmentId;
    }
    

    // Getters and setters
    public int getId(){
        return questionId;
    }
}

public class Assignment2 {
  
     public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
 
    public static void getHighestScorer(List<Result> results){
        Map<Student, Integer> totalScoreByStudent = results.stream()
        .collect(Collectors.groupingBy(Result::getStudent,
                Collectors.summingInt(Result::getScore)));
        Map<Student, Integer> sortedTotalScoreByStudent = sortByValueDescending(totalScoreByStudent);

        Map.Entry<Student, Integer> firstEntry = sortedTotalScoreByStudent.entrySet().iterator().next();
        System.out.println("Highest Scorer:"+firstEntry.getKey().getName());
        System.out.println("Percentage:"+firstEntry.getValue()/2);
        
    }

    public static void overallRanking(List<Result> results){
        Map<Student, Integer> totalScoreByStudent = results.stream()
        .collect(Collectors.groupingBy(Result::getStudent,
                Collectors.summingInt(Result::getScore)));
        Map<Student, Integer> sortedTotalScoreByStudent = sortByValueDescending(totalScoreByStudent);
        int i=1;
        for (Map.Entry<Student, Integer> entry : sortedTotalScoreByStudent.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Student:" + student.getName() + " Rank:"+i);
            i++;
        }
    }

    public static void whoNeedImprovement(List<Result> results){
        Map<Student, Integer> totalScoreByStudent = results.stream()
        .collect(Collectors.groupingBy(Result::getStudent,
                Collectors.summingInt(Result::getScore)));
        Map<Student, Integer> sortedTotalScoreByStudent = sortByValueDescending(totalScoreByStudent);
        
        for (Map.Entry<Student, Integer> entry : sortedTotalScoreByStudent.entrySet()) {
            int score = entry.getValue();
            Student s=entry.getKey();
            if(score/2<60){
                System.out.println(s.getName()+" needs improvement as he has scored "+(score/2)+" percentage");
            }
            
        }
    }

    public static void getSecondHighestScorer(List<Result> results){
        Map<Student, Integer> totalScoreByStudent = results.stream()
        .collect(Collectors.groupingBy(Result::getStudent,
                Collectors.summingInt(Result::getScore)));
        Map<Student, Integer> sortedTotalScoreByStudent = sortByValueDescending(totalScoreByStudent);

        Iterator<Map.Entry<Student, Integer>> iterator = sortedTotalScoreByStudent.entrySet().iterator();

        // Check if there is at least one entry in the map
        if (iterator.hasNext()) {
            // Get the first entry
            iterator.next();

            // Check if there is a second entry
            if (iterator.hasNext()) {
                // Get the second entry
                Map.Entry<Student, Integer> secondEntry = iterator.next();

                // Extract the key (student) and value (total score) from the second entry
                Student secondStudent = secondEntry.getKey();
                int secondTotalScore = secondEntry.getValue();

                // Print the details of the second student
                System.out.println("Second Highest Scorer:"+secondStudent.getName());
                System.out.println("Percentage:"+secondTotalScore/2);
            } else {
                System.out.println("There is no second entry in the map.");
            }
        } else {
            System.out.println("The map is empty.");
        }
        
        
    }

    public static void getResultByName(String name,List<Result> results){
        // Filter results for students named "Rohan" or "Prashant"
        List<Result> filteredResults = results.stream()
                .filter(result -> result.getStudent().getName().equals(name) )
                .collect(Collectors.toList());

        // Group filtered results by assignment
        Map<Assignment, List<Result>> resultsByAssignment = filteredResults.stream()
                .collect(Collectors.groupingBy(Result::getAssignment));

        // Calculate total score for each assignment
        resultsByAssignment.forEach((assignment, assignmentResults) -> {
            int totalAssignmentScore = assignmentResults.stream()
                    .mapToInt(Result::getScore)
                    .sum();
            System.out.println("Assignment: " + assignment.getTitle() + ", Total Score: " + totalAssignmentScore);

            // Group results by question within the assignment
            Map<Question, List<Result>> resultsByQuestion = assignmentResults.stream()
                    .collect(Collectors.groupingBy(Result::getQuestion));

            // Calculate total score for each question within the assignment
            resultsByQuestion.forEach((question, questionResults) -> {
                int totalQuestionScore = questionResults.stream()
                        .mapToInt(Result::getScore)
                        .sum();
                System.out.println("  Question: " + question.getId() + ", Total Score: " + totalQuestionScore);
            });
        });
    }
    public static void getAllResultsInDetail(List<Result> results){
        // Group results by student
        Map<Student, Map<Assignment, Map<Question, List<Result>>>> resultsByStudent = results.stream()
                .collect(Collectors.groupingBy(Result::getStudent,
                        Collectors.groupingBy(Result::getAssignment,
                                Collectors.groupingBy(Result::getQuestion))));

        // Iterate over results for each student
        resultsByStudent.forEach((student, assignments) -> {
            System.out.println("Student: " + student.getName());
            assignments.forEach((assignment, questions) -> {
                System.out.println("  Assignment: " + assignment.getTitle());
                questions.forEach((question, questionResults) -> {
                    System.out.println("    Question: " + question.getId());
                    questionResults.forEach(result -> {
                        System.out.println("      Result ID: " + result.getId() + ", Score: " + result.getScore());
                    });
                });
            });
        });
    }
    public static void main(String[] args) {
        // Create Dummy Data
        List<Student> students = new ArrayList<>();
        List<Trainer> trainers = new ArrayList<>();
        List<Assignment> assignments = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        List<TechStack> techStacks = new ArrayList<>();
        List<Result> Results = new ArrayList<>();
        

        // Populate Students
        students.add(new Student(1, "Yash", "abc.y@yahoo.com", "7654321"));
        students.add(new Student(2, "Vinit", "abc.v@yahoo.com", "12345"));
        students.add(new Student(3, "Dwij", "abc.d@yahoo.com", "45678"));
        //Populate Trainer
        trainers.add(new Trainer(1, "Ritu", "ritu@brudite.com", "123098"));
        trainers.add(new Trainer(2, "Krishna", "krishna@brudite.com", "99782"));
        trainers.add(new Trainer(3, "Rishabh", "rishabh@brudite.com", "12700"));
        //Populate Assignments
        assignments.add(new Assignment(1, "Mern", "Web Dev", "2024-01-30"));
        assignments.add(new Assignment(2, "Mean", "Web Dev with angular", "2024-01-21"));
        
        //Populate Questions
        questions.add(new Question(1, 50, 1, 1));
        questions.add(new Question(2, 50, 2, 1));
        questions.add(new Question(3, 50, 4, 2));
        questions.add(new Question(4, 50, 3, 2));

        techStacks.add(new TechStack(1, "Mern", "Web Dev"));
        techStacks.add(new TechStack(2, "Mean", "Web Dev with angular"));
        techStacks.add(new TechStack(3, "Django", "Backend easy"));
        techStacks.add(new TechStack(4, "Kubernetes", "Containerization Tool"));

        //Populate Results
        Results.add(new Result(1, students.get(0), assignments.get(0), trainers.get(0),questions.get(0), 12, "Excellent", "2024-01-27"));
        Results.add(new Result(2, students.get(0), assignments.get(0), trainers.get(0),questions.get(1), 13, "Good Score", "2024-01-20"));
        Results.add(new Result(3, students.get(0), assignments.get(1), trainers.get(0),questions.get(2), 50, "Good Score(Sarcastic)", "2024-01-20"));
        Results.add(new Result(4, students.get(0), assignments.get(1), trainers.get(0),questions.get(3), 42, "Very Poor", "2024-01-20"));
        Results.add(new Result(5, students.get(1), assignments.get(0), trainers.get(0),questions.get(0), 40, "Nice try", "2024-01-20"));
        Results.add(new Result(6, students.get(1), assignments.get(0), trainers.get(0),questions.get(1), 41, "Good score", "2024-01-27"));
        Results.add(new Result(7, students.get(1), assignments.get(1), trainers.get(0),questions.get(2), 17, "Pls leave studies", "2024-01-20"));
        Results.add(new Result(8, students.get(1), assignments.get(1), trainers.get(0),questions.get(3), 20, "Need to improve", "2024-01-27"));
        Results.add(new Result(9, students.get(2), assignments.get(0), trainers.get(0),questions.get(0), 25, "Very Poor", "2024-01-20"));
        Results.add(new Result(10, students.get(2), assignments.get(0), trainers.get(0),questions.get(1), 42, "Very Poor", "2024-01-20"));
        Results.add(new Result(11, students.get(2), assignments.get(1), trainers.get(0),questions.get(2), 38, "Can Improve", "2024-01-20"));
        Results.add(new Result(12, students.get(2), assignments.get(1), trainers.get(0),questions.get(3), 50, "Very Poor", "2024-01-20"));


        // Calculate Data
        // create a method to Find the highest performing Student by adding all techStack(Subjects) marks and finding percentages.
        // getHighestScorer(Results);
        // create a method to Find the second-highest student by adding all techStack(Subjects) marks/Assignments and finding percentages.
        // getSecondHighestScorer(Results);
        // Create a method to find the overall ranking of students by Scores.
        // overallRanking(Results);
        // Get all the Students who need improvements and scored less than 60%.
        // whoNeedImprovement(Results);
        // Get all the Results of one Student named “Rohan/Prashant“ of all his Assignments and questions scores.
        // getResultByName("Yash", Results);
        // Get all the students' results and their scores on all the individual assignments and questions.
        getAllResultsInDetail(Results);
    }
}
