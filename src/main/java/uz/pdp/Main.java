package uz.pdp;

import uz.pdp.util.Input;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("TicTacToe game");
        System.out.println(" ");

        String[][] matrix = generateMatrix();
        int step = 1;
        String stepStr="";
        while (true){
            showMatrix(matrix);
            if (step%2!=0){
                stepStr="X";
            }else {
                stepStr="0";
            }
            int value= Input.inputInt("Choose number "+stepStr+"'s turn");
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
            step++;
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
}