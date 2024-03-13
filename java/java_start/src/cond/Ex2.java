package cond;

public class Ex2 {
    public static void main(String[] args) {
        int distance = 140;

        if(distance <= 1) {
            System.out.println("도보를 이용하세요");
        }
        else if(distance <= 5) {
            System.out.println("자전거를 이용하세요");
        }
        else if(distance <= 25) {
            System.out.println("자동차를 이용하세요");
        }
        else if(distance <= 150) {
            System.out.println("비행기를 이용하세요");
        }
    }
}
