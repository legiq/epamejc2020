package main.homework2.Strings;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class EvenOddExt extends Programm {
    public static void main(String[] args) throws IOException {
        new EvenOddExt().go();
    }
    @Override
    public String startString() {
        return STARTSTRING;
    }

    @Override
    public String seondInputString() {
        return STARTEVODD;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        String result = ALERTDATA;
        String EvenOdd = chekEvenOdd(Sinput);
        if (Finput != null && EvenOdd != null){
            result = makeString(Finput,EvenOdd);
        }
        return result;
    }
    public String makeString (String str, String EvenOdd){
        String result = "";
        for (int i = 0; i < str.length(); i++) {

            if (EvenOdd.equals(EVEN) && i % 2 == 0) {
                result += str.charAt(i);

            } else if (EvenOdd.equals(ODD) && i % 2 != 0) {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
