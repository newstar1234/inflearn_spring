package array;

public class ArrayDi4 {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];

        int i = 1;
        for(int row = 0; row < arr.length; row++) {
            for(int column = 0; column < arr[row].length; column++) {
                arr[row][column] = i++;
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }
}
