package uz.pdp;

import uz.pdp.util.Input;

public class Main {
    public static void main(String[] args) {
        System.out.println("TicTacToe game");
        System.out.println(" ");

        String[][] matrix = generateMatrix();
        int step = 1;
        String stepStr="";

        while (!isWin(matrix)){
            showMatrix(matrix);
            if (step%2!=0){
                stepStr="X";
            }else {
                stepStr="0";
            }
            int value= chooseEmptyZone(matrix,stepStr);
            changeMatrix(matrix,value,stepStr);
            if (step==9){
                break;
            }
            step++;
        }
        showMatrix(matrix);
        if (step==9){
            System.out.println("D R A W !");
        }else {
            System.out.println(winner(step)+" is winner!");
        }
    }

    private static void changeMatrix(String[][] matrix,int value, String stepStr) {
        switch (value){
            case 1->matrix[0][0]=stepStr;
            case 2->matrix[0][1]=stepStr;
            case 3->matrix[0][2]=stepStr;
            case 4->matrix[1][0]=stepStr;
            case 5->matrix[1][1]=stepStr;
            case 6->matrix[1][2]=stepStr;
            case 7->matrix[2][0]=stepStr;
            case 8->matrix[2][1]=stepStr;
            case 9->matrix[2][2]=stepStr;
        }
    }
    private static String[][] generateMatrix(){
        String[][] matrix = new String[3][3];
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix.length; j++) {
                matrix[i][j] = ""+number;
                number++;
            }
        }
        return matrix;
    }
    private static void showMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            String str = "|";
            for (int j = 0; j < matrix.length; j++) {
                str+=" "+matrix[i][j]+" |";
            }
            System.out.println(str);
            System.out.println("_____________");
        }
    }
    private static boolean isWin(String[][] matrix){
        return (matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2])) ||
                (matrix[1][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[1][2])) ||
                (matrix[2][0].equals(matrix[2][1]) && matrix[2][1].equals(matrix[2][2])) ||
                (matrix[0][0].equals(matrix[1][0]) && matrix[1][0].equals(matrix[2][0])) ||
                (matrix[0][1].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][1])) ||
                (matrix[0][2].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][2])) ||
                (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) ||
                (matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0]));
    }
    private static String winner(int step){
        step = step-1;
        if (step%2!=0){
            return "X player";
        }else {
            return "0 player";
        }
    }
    private static int chooseEmptyZone(String[][] matrix, String stepStr){
        int value = Input.inputInt("Choose number "+stepStr+"'s turn");
        String string="";
        switch (value){
            case 1->string = matrix[0][0];
            case 2->string = matrix[0][1];
            case 3->string = matrix[0][2];
            case 4->string = matrix[1][0];
            case 5->string = matrix[1][1];
            case 6->string = matrix[1][2];
            case 7->string = matrix[2][0];
            case 8->string = matrix[2][1];
            case 9->string = matrix[2][2];
        }
        if (value<1 || value>9 || string.equals("X") || string.equals("0")){
            System.out.println("Non correct number on game zone!");
            return chooseEmptyZone(matrix,stepStr);
        }else {
            return value;
        }
    }
}