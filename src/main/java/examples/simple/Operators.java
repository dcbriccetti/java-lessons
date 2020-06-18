package examples.simple;

/** Demonstrates several commonly-used operators */
public class Operators {
  @SuppressWarnings("ConstantConditions")
  public static void main(String[] args) {
    int student1Age = 10;
    int student2Age = 11;
    int sumAges = student1Age + student2Age;
    int diffAges = student2Age - student1Age;
    boolean student2Older = student2Age > student1Age;
    boolean student2OlderOrSome = student2Age >= student1Age;
    boolean agesEqual = student1Age == student2Age;
    int student1Grade = 5;
    int student2Grade = 5;
    boolean sameAgeAndGrade = student1Age == student2Age && student1Grade == student2Grade;
    boolean sameAgeOrSameGrade = student1Age == student2Age || student1Grade == student2Grade;
    ++student1Age; // student 1 has a birthday
    student2Age += 2; // student 2 has two birthdays
    int remainder = 14 % 12; // % is the “remainder” or “modulo” operator
    boolean remainderIs2 = remainder == 2; // True
  }
}
