package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encode_and_Decode_Strings_659 {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            encodedStr.append(strs.get(i));
            if(i != strs.size()-1){
                encodedStr.append(":;");
            }
        }

        return encodedStr.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();

        String buffer = "";
        for(int i = 0; i < str.length(); i++){
            if(i != 0 && str.charAt(i-1) == ':' && str.charAt(i) == ';'){
                decodedStrs.add(buffer.substring(0, buffer.length()-1));
                buffer = "";
                continue;
            }

            buffer += str.charAt(i);

            if(i == str.length()-1){
                decodedStrs.add(buffer);
                buffer = "";
            }
        }

        return decodedStrs;
    }

    public static void main(String[] args){
        List<String> firstInput = Arrays.asList("lint","code","love","you");
        List<String> secondInput = Arrays.asList("we", "say", ":", "yes");

        String firstEncoded = encode(firstInput);
        String secondEncoded = encode(secondInput);

        System.out.println(firstEncoded + " / " + decode(firstEncoded));
        System.out.println(secondEncoded + " / " + decode(secondEncoded));

    }
}
