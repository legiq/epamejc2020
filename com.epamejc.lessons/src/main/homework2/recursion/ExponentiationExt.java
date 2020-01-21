package main.homework2.recursion;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class ExponentiationExt extends Programm {
    public static void main(String[] args) throws IOException {
        new ExponentiationExt().go();
    }
    @Override
    public String startString() {
        return STARTNUMBER;
    }

    @Override
    public String seondInputString() {
        return STARTPOW;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        Double num = chekDouble(Finput);
        Integer pow = chekInt(Sinput);
        boolean chek = num != null && pow != null;
        if (!chek){
            return ALERTDATA;
        } else if(chek && pow <= 0){
            return ALERTPOW;
        }else {
            return String.valueOf(exponent(num,pow));
        }
    }
    private double exponent(double num,int pow){
        if(pow == 1){

            return num;

        } else{
            double result = 0;

            result = num + exponent(num,pow-1);

            return result;
        }
    }
}
