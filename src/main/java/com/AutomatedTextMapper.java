package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AutomatedTextMapper {

    static class BurmeseChar {
        String phonetic;
        int id;
        String script;

        public BurmeseChar(String phonetic, int id, String script) {
            this.phonetic = phonetic;
            this.id = id;
            this.script = script;
        }
    }

    public static void main(String[] args) {

        // ==========================================
        // 1. SET YOUR PATHS HERE
        // ==========================================
        // Your input text file containing the Burmese sentences
        String inputFilePath = "";
        // The output file where the mapping will be saved (e.g., labels.txt)
        String outputFilePath = "txt";

        // Image naming settings
        String prefix = "Sentence-";
        int counter = 1; // Start counting from 1 (or whatever number you need)

        // ==========================================
        // 2. SETUP CHARACTER MAPPING LIST
        // ==========================================
        List<BurmeseChar> charList = new LinkedList<>();

        charList.add(new BurmeseChar("0", 1, "၀"));
        charList.add(new BurmeseChar("1", 2, "၁"));
        charList.add(new BurmeseChar("2", 3, "၂"));
        charList.add(new BurmeseChar("3", 4, "၃"));
        charList.add(new BurmeseChar("4", 5, "၄"));
        charList.add(new BurmeseChar("5", 6, "၅"));
        charList.add(new BurmeseChar("6", 7, "၆"));
        charList.add(new BurmeseChar("7", 8, "၇"));
        charList.add(new BurmeseChar("8", 9, "၈"));
        charList.add(new BurmeseChar("9", 10, "၉"));

        charList.add(new BurmeseChar("Ah", 11, "အ"));
        charList.add(new BurmeseChar("Aha", 12, "အာ"));
        charList.add(new BurmeseChar("O", 13, "အို"));
        charList.add(new BurmeseChar("a_thet", 14, "်"));
        charList.add(new BurmeseChar("au2", 15, "ဪ"));
        charList.add(new BurmeseChar("au3", 16, "ဩ"));
        charList.add(new BurmeseChar("ay2", 17, "ဧ"));
        charList.add(new BurmeseChar("ay3", 18, "၏"));
        charList.add(new BurmeseChar("ay4", 19, "၍"));
        charList.add(new BurmeseChar("ay5", 20, "၌"));
        charList.add(new BurmeseChar("ay6", 21, "၎"));

        charList.add(new BurmeseChar("ba_htoat_chite", 22, "ဗ"));
        charList.add(new BurmeseChar("ba_kone", 23, "ဘ"));
        charList.add(new BurmeseChar("da_htway", 24, "ဒ"));
        charList.add(new BurmeseChar("da_out_chite", 25, "ဓ"));
        charList.add(new BurmeseChar("da_yay_hmote", 26, "ဎ"));
        charList.add(new BurmeseChar("da_yin_kout", 27, "ဍ"));
        charList.add(new BurmeseChar("e1", 28, "ဣ"));
        charList.add(new BurmeseChar("e2", 29, "ဤ"));
        charList.add(new BurmeseChar("eeare", 30, "အဲ"));
        charList.add(new BurmeseChar("ga_khi", 31, "ဃ"));
        charList.add(new BurmeseChar("ga_nge", 32, "ဂ"));
        charList.add(new BurmeseChar("ha", 33, "ဟ"));
        charList.add(new BurmeseChar("ha_htoe", 34, "ှ"));

        charList.add(new BurmeseChar("hna_chaung_ngin", 35, "ူ"));
        charList.add(new BurmeseChar("hsa_lain", 36, "ဆ"));
        charList.add(new BurmeseChar("hta_hsin_htu", 37, "ထ"));
        charList.add(new BurmeseChar("hta_wun_beare", 38, "ဌ"));
        charList.add(new BurmeseChar("ka_kji", 39, "က"));
        charList.add(new BurmeseChar("kha_khway", 40, "ခ"));
        charList.add(new BurmeseChar("la", 41, "လ"));
        charList.add(new BurmeseChar("la_kji", 42, "ဠ"));
        charList.add(new BurmeseChar("lone_kyi_tin", 43, "ိ"));
        charList.add(new BurmeseChar("lone_kyi_tin_hsan_khat", 44, "ီ"));

        charList.add(new BurmeseChar("ma", 45, "မ"));
        charList.add(new BurmeseChar("na_kji", 46, "ဏ"));
        charList.add(new BurmeseChar("na_ngear", 47, "န"));
        charList.add(new BurmeseChar("nga", 48, "င"));
        charList.add(new BurmeseChar("nout_pyit", 49, "ဲ"));
        charList.add(new BurmeseChar("nya_kyi", 50, "ည"));
        charList.add(new BurmeseChar("out_ka_myit", 51, "့"));
        charList.add(new BurmeseChar("pa_sout", 52, "ပ"));
        charList.add(new BurmeseChar("pfa_u_htoat", 53, "ဖ"));
        charList.add(new BurmeseChar("pu1", 54, "၊"));
        charList.add(new BurmeseChar("pu2", 55, "။"));
        charList.add(new BurmeseChar("sah_lone", 56, "စ"));

        charList.add(new BurmeseChar("ta_chaung_ngin", 57, "ု"));
        charList.add(new BurmeseChar("ta_thun_lyin_chate", 58, "ဋ"));
        charList.add(new BurmeseChar("ta_way_htoe", 59, "ေ"));
        charList.add(new BurmeseChar("ta_wun_pu", 60, "တ"));
        charList.add(new BurmeseChar("tay_tay_tin", 61, "ံ"));
        charList.add(new BurmeseChar("tha", 62, "သ"));
        charList.add(new BurmeseChar("tha_kyi", 63, "ဿ"));
        charList.add(new BurmeseChar("u1", 64, "ဥ"));
        charList.add(new BurmeseChar("u2", 65, "ဦ"));
        charList.add(new BurmeseChar("u3", 66, "ဉ"));
        charList.add(new BurmeseChar("un", 67, "အံ"));
        charList.add(new BurmeseChar("wa", 68, "ဝ"));

        charList.add(new BurmeseChar("wa_sa_hna_lone_pout", 69, "း"));
        charList.add(new BurmeseChar("wa_swal", 70, "ွ"));
        charList.add(new BurmeseChar("ya_pint", 71, "ျ"));
        charList.add(new BurmeseChar("ya_yint", 72, "ြ"));
        charList.add(new BurmeseChar("yah_kout", 73, "ရ"));
        charList.add(new BurmeseChar("yah_pet_let", 74, "ယ"));

        charList.add(new BurmeseChar("yay_cha_l", 75, "ါ"));
        charList.add(new BurmeseChar("yay_cha_s", 76, "ာ"));

        charList.add(new BurmeseChar("za_kwear", 77, "ဇ"));
        charList.add(new BurmeseChar("za_myin_hsware", 78, "ဈ"));
        charList.add(new BurmeseChar("virama", 79, "္"));


        // ==========================================
        // 3. READ INPUT AND WRITE TO OUTPUT
        // ==========================================
        System.out.println("Processing file: " + inputFilePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Construct the output line (e.g., "Sentence-1.jpeg    ")
                StringBuilder currentOutputLine = new StringBuilder();
                currentOutputLine.append(prefix).append(counter).append(".jpeg    ");

                // Map each character to its ID
                for (int i = 0; i < line.length(); i++) {
                    String charToFind = String.valueOf(line.charAt(i));
                    boolean found = false;

                    for (BurmeseChar bChar : charList) {
                        if (bChar.script.equals(charToFind)) {
                            currentOutputLine.append(bChar.id).append(" ");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        currentOutputLine.append("? "); // Mark unknown characters
                    }
                }

                // Write the completed line to the new text file
                writer.write(currentOutputLine.toString().trim());
                writer.newLine(); // Move to the next line in the text file

                counter++;
            }

            System.out.println("Success! Labels saved to: " + outputFilePath);
            System.out.println("Total lines processed: " + (counter - 1));

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}