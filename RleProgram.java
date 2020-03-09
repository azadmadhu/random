import java.util.Scanner;

public class RleProgram {

    public static void main[

    String() args]

    {

    }

    public static String toHexString(byte[] data) {

        int length = data.length;
        String hex = "";

        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            hex += Integer.toHexString(temp);
        }
        return hex;
    }

    public static int countRuns(byte[] flatData) {

        int runs = 1;

        for (int i = 0; i < flatData.length - 1; i++) {

            if (flatData[i] != flatData[i + 1]) {
                runs++;
            }
        }
        return runs;
    }

    public static byte[] encodeRle(byte[] flatData) {

        int length = 2 * countRuns(flatData);
        int run = 1, j = 0, number;
        byte[] result = new byte[length];

        for (int i = 0; i < flatData.length; i++) {

            number = flatData[i];

            if (i != flatData.length - 1) {

                if (flatData[i] == flatData[i + 1]) {
                    run++;

                } else {
                    result[j] = (byte) run;
                    result[j + 1] = (byte) number;
                    j++;
                    run = 1;
                }

            } else {

                if (flatData[i] == flatData[i - 1]) {
                    result[j] = (byte) run;
                    result[j + 1] = (byte) number;

                } else {
                    result[j] = (byte) 1;
                    result[j + 1] = flatData[i];
                }

            }

        }
        return result;
    }

    public static int getDecodedLength(byte[] rleData) {

        int decodedLength = 0;

        for (int i = 0; i < rleData.length; i = i + 2) {
            decodedLength += (int) rleData[i];
        }

        return decodedLength;
    }

    public static byte[] decodeRle(byte[] rleData) {

        byte[] result = new byte[getDecodedLength(rleData)];
        int j = 0;

        for (int i = 0; i < rleData.length; i = i + 2) {

            int length = rleData[i];
            int number = rleData[i + 1];

            for (int k = j; k < j + length; k++) {
                result[k] = (byte) number;
            }

            j = j + length;

        }

        return result;

    }

    public static byte[] stringToData(String dataString) {

        byte[] data = new byte[dataString.length()];

        for (int i = 0; i < dataString.length(); i++) {

            data[i] = (byte) Integer.parseInt(String.valueOf(dataString.charAt(i)), 16);

        }

        return data;
    }

    public static String toRleString(byte[] rleData) {

        String result = "", run, number;

        for (int i = 0; i < rleData.length; i = i + 2) {

            run = Integer.toString(rleData[i]);
            number = Integer.toHexString(rleData[i + 1]);
            result = result + run + number + ":";

        }
        result = result.substring(0, result.length() - 1);

        return result;
    }

    public static byte[] stringToRle(String rleString) {

        int length, number;
        char temp;
        int stringLength = rleString.length();

        for (int i = 0; i < rleString.length(); i++ ) {

            int count = 0;
            if(rleString.charAt(i)!=58){
                count++;

            }else{

                if(count == 2){

                    

                }


            }


        }


    }
}