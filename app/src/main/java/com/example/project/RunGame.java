package com.example.project;

import java.util.Random;

public class RunGame {
        int actual_tries;             // user times of tried in game
        int expected_tries;           // user inputted tries
        int value;                    // system random number
        int bonus;                    // a bonus for difficulty score
        int score;                    // a total score of the game

        public RunGame() {
            this.expected_tries = 0;
            this.actual_tries = 0;
            this.score = 100;
            this.bonus = 0;

        }
        public void setMode(String mode){
            if (mode.equals("easy")) {
                Random rand = new Random();
                this.value = rand.nextInt(10) + 1;
                this.bonus = 1;
            } else if (mode.equals("normal")) {
                Random rand = new Random();
                this.value = rand.nextInt(50) + 1;
                this.bonus = 5;
            } else if (mode.equals("hard")) {
                Random rand = new Random();
                this.value = rand.nextInt(100) + 1;
                this.bonus = 10;
            }else{
                throw new IllegalArgumentException("please input: easy or normal or hard");
            }
        }

        public String getMode(){
            String mode;
            if(this.bonus == 1){
                mode = "easy";
            }else if(this.bonus == 5){
                mode = "normal";
            }else if(this.bonus == 10){
                mode = "hard";
            }else{
                mode = "please set an correct game mode";
            }
            return mode;
        }
        public void setValue(int n){
            this.value = n;
        }//only for test

        public int getValue(){
            return this.value;
        }

        public void setExpected_Tries(int expected_tries){
            if(expected_tries > 0){
                this.expected_tries = expected_tries;
            }else{
                throw new IllegalArgumentException("please type a positive int number");
            }
        }

        public int getExpected_Tries(){
            return this.expected_tries;
        }

        public int getActual_Tries(){
            return this.actual_tries;
        }

        public String isNumberCorrect (int m) {
            String result;
            this.actual_tries++;
            if(this.expected_tries == 0){
                throw new IllegalArgumentException("please set an correct expected_tries");
            }else{

                if (this.actual_tries < this.expected_tries) {
                    if (this.value == m) {
                        result = "win";      // will be jump to WinPage
                    }else if(this.value < m){

                        result = "too high"; // will be change to show a too high pic
                    }else {

                        result = "too low";  // will be change to show a too low pic
                    }
                }else if(this.actual_tries == this.expected_tries){
                    if(this.value == m){
                        result = "win";
                    }else{
                        result = "lose";
                    }
                }else{
                    throw new IllegalArgumentException("over tries than expected");
                }
            }
            return result;
        }

        public int getScore(){
            double score = (double)((1/ this.actual_tries) * this.score * this.bonus) - this.expected_tries;
            this.score = (int)score;
            return this.score;
        }

}
