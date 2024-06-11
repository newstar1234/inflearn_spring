package array;

public class ArrayDi2 {
    public static void main(String[] args) {
        // 2X3 2차원 배열을 만든다.
        int[][] arr = new int[2][3]; // 행 2, 열 3

        arr[0][0] = 1; // 0행 0열
        arr[0][1] = 2; // 0행 1열
        arr[0][2] = 3; // 0행 2열
        arr[1][0] = 4; // 1행 0열
        arr[1][1] = 5; // 1행 1열
        arr[1][2] = 6; // 1행 2열

        for(int row = 0; row < 2; row++) {
            for(int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }

    }
}
