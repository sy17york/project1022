package com.example.project;
import java.util.Random;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestRunGame {
    @Test
    public void test_01(){
        RunGame aby = new RunGame();
        aby.setMode("easy");
        aby.setExpected_Tries(10);
        assertEquals("easy",aby.getMode());
        assertEquals(10,aby.getExpected_Tries());
        assertEquals(0,aby.getActual_Tries());
        assertTrue(aby.value>0 && (aby.value <= 10));
        Random n = new Random();
        String a = aby.isNumberCorrect( n.nextInt(11) );
        assertTrue(  a.equals("too high") || a.equals("win") || a.equals("too low"));
        assertEquals(1, aby.actual_tries);
    }
    @Test
    public void test_02(){
        RunGame abs = new RunGame();
        abs.setMode("normal");
        abs.setExpected_Tries(50);
        assertEquals("normal",abs.getMode());
        assertEquals(50,abs.getExpected_Tries());
        assertEquals(0,abs.getActual_Tries());
        int n = 0;
        for( int i = 1; i < 51; i++){
            if(abs.isNumberCorrect(i).equals("win")){
                n = i;
                break;
            }
        }assertEquals( n, abs.actual_tries);
        assertEquals( n, abs.getValue());
    }
}