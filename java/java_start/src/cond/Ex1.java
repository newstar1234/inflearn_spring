package cond;

public class Ex1 {
    public static void main(String[] args) {
        int score = 55;

        String credit;
        
        if(score >= 90) {
            credit = "A";
        }
        else if(score < 90 && score >= 80) {
            credit = "B";
        }
        else if(score < 80 && score >= 70) {
            credit = "C";
        }
        else if(score < 70 && score >= 60) {
            credit = "D";
        }
        else credit = "F";
        
        System.out.println("학점은 : " + credit + " 입니다.");

    }
}
