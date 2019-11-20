package com.numthe.vigenere;

import java.lang.reflect.Array;
import java.util.*;

public class Decrypt {

    private static Double[] trueEngFrequencies = new Double[]{.08167,.01492,.02202,.04253,.12702,.02228,.02015,.06094,.06966,.00153,.01292,.04025,.02406,.06749,.07505,.01929,.00095,.05987,.06327,.09356,.02758,.00978,.02560,.0015,.01994,.00077};
    private static String[] alphabet = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public static void main(String[] args) {
        String cipher  = args[0];
        int keyLength = findKeyLength(cipher);

        System.out.println(findKey(keyLength,cipher));
    }

    private static ArrayList<String> everyXthLetter(String cipher, int x, int start){

        String[] letters = cipher.split("");
        Double total = Math.floor(letters.length/x);
        ArrayList<String> subselection = new ArrayList<>();
        for(int i = start; i/x < total; i += x){
            subselection.add(letters[i]);
        }
        return subselection;
    }


    private static Double[] letterFreqs(ArrayList<String> subselection){
        Double[] frequencies = new Double[26];
        for(int i = 0; i < 26; i ++){
            if(subselection.contains(alphabet[i])){
                ArrayList<String> character = new ArrayList<>();
                character.add(alphabet[i]);
                ArrayList<String> temp = new ArrayList<>(subselection);
                temp.retainAll(character);
                double tempLength = temp.size();
                double subLength  = subselection.size();
                double freq = tempLength/subLength;
                frequencies[i] = freq;
            } else {
                frequencies[i] = 0.00;
            }
        }
        return frequencies;
    }


    private static int findKeyLength(String cipher){
        double max = 0;
        int length = 0;
        for(int i = 2; i < 7; i++){
            double dot   = 0;
            Double[] frequencyVec = letterFreqs(everyXthLetter(cipher,i, 0));
            Arrays.sort(frequencyVec, Collections.reverseOrder());

            Double[] sortedABC = Arrays.copyOf(trueEngFrequencies,26);
            Arrays.sort(sortedABC, Collections.reverseOrder());

            for (int x = 0; x < 26; x++) {
                dot = dot + (frequencyVec[x] * sortedABC[x]);
            }
            if(dot > max){
                max    = dot;
                length = i;
            }
        }
        return length;
    }


    private static String findKey(int keyLength, String cipher){
        int[] keyIndex = new int[keyLength];
        for(int i = 0; i < keyLength; i++){
            Double[] freqs = letterFreqs(everyXthLetter(cipher, keyLength, i));
            double max = 0;
            int  index = 0;
            for(int n = 0; n < 26; n++) {
                double dot = 0;
                for (int x = 0; x < 26; x++) {
                    dot = dot + (freqs[x] * trueEngFrequencies[((x + 26)-n) % 26]);
                }
                if (dot > max) {
                    max = dot;
                    index = n;
                }

            }
            keyIndex[i] = index;
        }
        String key = "";
        for(int i = 0; i < keyLength; i++){
            key += alphabet[keyIndex[i]];
        }
        return key;
    }
}
