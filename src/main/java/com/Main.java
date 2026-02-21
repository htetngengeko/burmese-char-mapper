package com;

public class Main {
    public static void main(String[] args) {

//            BurmeseCharMapper mapper = new BurmeseCharMapper();
//            Scanner scanner = new Scanner(System.in);
//
//            boolean stop = false;
//
//            do{
//                System.out.print("Enter Character (e.g., နှင်းဆီပန်း): ");
//                String input = scanner.nextLine();
//
//                String result = mapper.mappedId(input);
//                System.out.print("Output IDs: " + result);
//                System.out.println();
//
//                System.out.print("Do you wanna continue? y/n");
//                String nextOrNot= scanner.nextLine();
//
//                if(nextOrNot.equals("n"))
//                    stop = true;
//            } while (!stop);
//
//        }
            FileNameChanger changer = new FileNameChanger();
            changer.fileNameChanger("", "Sentence_", 184);

    }
}