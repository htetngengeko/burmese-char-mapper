package com;

import java.util.LinkedList;
import java.util.List;

public class BurmeseCharMapper {

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

    public String mappedId (String burmeseString) {
         List<BurmeseChar> charList = new LinkedList<>();
        String result = "";

// --- DIGITS (IDs 1-10) ---
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

        charList.add(new BurmeseChar("ba_htoat_chite", 18, "ဗ"));
        charList.add(new BurmeseChar("ba_kone", 19, "ဘ"));
        charList.add(new BurmeseChar("da_htway", 20, "ဒ"));
        charList.add(new BurmeseChar("da_out_chite", 21, "ဓ"));
        charList.add(new BurmeseChar("da_yay_hmote", 22, "ဎ"));
        charList.add(new BurmeseChar("da_yin_kout", 23, "ဍ"));
        charList.add(new BurmeseChar("e1", 24, "ဣ"));
        charList.add(new BurmeseChar("e2", 25, "ဤ"));
        charList.add(new BurmeseChar("eeare", 26, "အဲ"));
        charList.add(new BurmeseChar("ga_khi", 27, "ဃ"));
        charList.add(new BurmeseChar("ga_nge", 28, "ဂ"));
        charList.add(new BurmeseChar("ha", 29, "ဟ"));
        charList.add(new BurmeseChar("ha_htoe", 30, "ှ"));

        charList.add(new BurmeseChar("hna_chaung_ngin", 31, "ူ"));
        charList.add(new BurmeseChar("hsa_lain", 32, "ဆ"));
        charList.add(new BurmeseChar("hta_hsin_htu", 33, "ထ"));
        charList.add(new BurmeseChar("hta_wun_beare", 34, "ဌ"));
        charList.add(new BurmeseChar("ka_kji", 35, "က"));
        charList.add(new BurmeseChar("kha_khway", 36, "ခ"));
        charList.add(new BurmeseChar("la", 37, "လ"));
        charList.add(new BurmeseChar("la_kji", 38, "ဠ"));
        charList.add(new BurmeseChar("lone_kyi_tin", 39, "ိ"));
        charList.add(new BurmeseChar("lone_kyi_tin_hsan_khat", 40, "ီ"));

        charList.add(new BurmeseChar("ma", 41, "မ"));
        charList.add(new BurmeseChar("na_kji", 42, "ဏ"));
        charList.add(new BurmeseChar("na_ngear", 43, "န"));
        charList.add(new BurmeseChar("nga", 44, "င"));
        charList.add(new BurmeseChar("nout_pyit", 45, "ဲ"));
        charList.add(new BurmeseChar("nya_kyi", 46, "ည"));
        charList.add(new BurmeseChar("out_ka_myit", 47, "့"));
        charList.add(new BurmeseChar("pa_sout", 48, "ပ"));
        charList.add(new BurmeseChar("pfa_u_htoat", 49, "ဖ"));
        charList.add(new BurmeseChar("sah_lone", 50, "စ"));

        charList.add(new BurmeseChar("ta_chaung_ngin", 51, "ု"));
        charList.add(new BurmeseChar("ta_thun_lyin_chate", 52, "ဋ"));
        charList.add(new BurmeseChar("ta_way_htoe", 53, "ေ"));
        charList.add(new BurmeseChar("ta_wun_pu", 54, "တ"));
        charList.add(new BurmeseChar("tay_tay_tin", 55, "ံ"));
        charList.add(new BurmeseChar("tha", 56, "သ"));
        charList.add(new BurmeseChar("u1", 57, "ဥ"));
        charList.add(new BurmeseChar("u2", 58, "ဦး"));
        charList.add(new BurmeseChar("un", 59, "အံ"));
        charList.add(new BurmeseChar("wa", 60, "ဝ"));

        charList.add(new BurmeseChar("wa_sa_hna_lone_pout", 61, "း"));
        charList.add(new BurmeseChar("wa_swal", 62, "ွ"));
        charList.add(new BurmeseChar("ya_pint", 63, "ျ"));
        charList.add(new BurmeseChar("ya_yint", 64, "ြ"));
        charList.add(new BurmeseChar("yah_kout", 65, "ရ"));
        charList.add(new BurmeseChar("yah_pet_let", 66, "ယ"));
        charList.add(new BurmeseChar("yay_cha", 67, "ာ"));
        charList.add(new BurmeseChar("yay_cha", 67, "ါ"));
        charList.add(new BurmeseChar("za_kwear", 68, "ဇ"));
        charList.add(new BurmeseChar("za_myin_hsware", 69, "ဈ"));

        for (int i = 0; i < burmeseString.length(); i++) {
            String charToFind = String.valueOf(burmeseString.charAt(i));

            boolean found = false;

            for (BurmeseChar bChar : charList) {
                if (bChar.script.equals(charToFind)) {
                    result = bChar.id + " ";
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.print("? ");
            }
        }

        return result;
    }
}
