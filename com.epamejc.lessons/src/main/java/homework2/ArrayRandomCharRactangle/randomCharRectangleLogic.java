package homework2.ArrayRandomCharRactangle;

import java.util.Random;

public class randomCharRectangleLogic {
    public String buildRectangle(int height,int width) {
        Random r = new Random();
        StringBuilder out = new StringBuilder();
        char[][] arr = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = (char) (r.nextInt(94) + 33);
                out.append(arr[i][j]).append(" ");
            }
            out = out.append("\r\n");
        }
        System.out.println(out.length());
        return out.toString();
    }
}