package com.example.project;

import java.util.Random;
public class RunGame {
        private int actual_tries;             // user times of tried in game
        private int expected_tries;           // user inputted tries
        private int value;                    // system random number
        private int bonus;                    // a bonus for difficulty score
        private int score;                    // a total score of the game

        public RunGame() {
            this.setExpected_tries(0);
            this.setActual_tries(0);
            this.setScore(100);
            this.setBonus(0);

        }
        public void setMode(String mode){
            if (mode.equals("easy")) {
                Random rand = new Random();
                this.setValue(rand.nextInt(10) + 1);
                this.setBonus(1);
            } else if (mode.equals("normal")) {
                Random rand = new Random();
                this.setValue(rand.nextInt(50) + 1);
                this.setBonus(5);
            } else if (mode.equals("hard")) {
                Random rand = new Random();
                this.setValue(rand.nextInt(100) + 1);
                this.setBonus(10);
            }else{
                throw new IllegalArgumentException("please input: easy or normal or hard");
            }
        }

        public String getMode(){
            String mode;
            if(this.getBonus() == 1){
                mode = "easy";
            }else if(this.getBonus() == 5){
                mode = "normal";
            }else if(this.getBonus() == 10){
                mode = "hard";
            }else{
                mode = "please set an correct game mode";
            }
            return mode;
        }

        public int getValue(){
            return this.value;
        }

        public void setExpected_Tries(int expected_tries){
            if(expected_tries > 0){
                this.setExpected_tries(expected_tries);
            }else{
                throw new IllegalArgumentException("please type a positive int number");
            }
        }

        public int getExpected_Tries(){
            return this.getExpected_tries();
        }

        public int getActual_Tries(){
            return this.getActual_tries();
        }

        public String isNumberCorrect (int m) {
            String result;
            if(this.getExpected_tries() == 0){
                throw new IllegalArgumentException("please set an correct expected_tries");
            }else{
                this.setActual_tries(this.getActual_tries() + 1);
                if (this.getActual_tries() < this.getExpected_tries()) {
                    if (this.getValue() == m) {
                        result = "win";      // will be jump to WinPage
                    }else if(this.getValue() < m){
                        result = "too high"; // will be change to show a too high pic
                    }else {
                        result = "too low";  // will be change to show a too low pic
                    }
                }else if(this.getActual_tries() == this.getExpected_tries()){
                    if(this.getValue() == m){
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
            this.score = (int) ((1/ this.getActual_tries()) * this.score * this.getBonus() - this.getExpected_tries());
            return this.score;
        }

    public int getActual_tries() {
        return actual_tries;
    }

    public void setActual_tries(int actual_tries) {
        this.actual_tries = actual_tries;
    }

    public int getExpected_tries() {
        return expected_tries;
    }

    public void setExpected_tries(int expected_tries) {
        this.expected_tries = expected_tries;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
