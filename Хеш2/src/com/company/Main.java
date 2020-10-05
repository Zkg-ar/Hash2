package com.company;

public class Main {

    private static String hash = "";
    private static char [] alphabet = new char[]{
            'а','б','в','г','д','е','ё','ж',
            'з','и','й','к','л','м','н','о',
            'п','р','с','т','у','ф','х','ц',
            'ч','ш','щ','ъ','ы','ь','э','ю','я'
    };

    public static void main(String[] args) {
        System.out.println(HashFunc("да,ад,ага,оно,сто,ост,сон,нос.Привет,что нового?Защита информации."));
    }

    public static int func(int first,int last,int sum){
        int dif = last - first;
        int res = (int) (Math.pow(3,first)+Math.pow(2,last)+Math.pow(2,dif))%sum;

        return res;
    }
    public static String HashFunc(String input){
        int sum = 0,first=0,last=0;
        input = input.toLowerCase();
        String [] words = input.split("[.!,?\\-\\s]");

        for (int i = 0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                for (int k = 0;k<alphabet.length;k++) {
                    if(words[i].charAt(0)==alphabet[k]){
                        first=k;
                    }
                    if(words[i].charAt(words[i].length()-1)==alphabet[k]){
                        last=k;
                    }
                    if (words[i].charAt(j) == alphabet[k]) {
                        sum += k;
                    }

                }

            }
//
            hash +=Integer.toString((int) (func(first,last,sum)))+" ";
            sum = 0;

        }

        return hash;
    }

}

