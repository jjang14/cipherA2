import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;
import java.util.zip.CRC32;

public class q1 {
    public static void main(String[] args) {
        String cipherText = "NRVKVLTLGRVMLKQNGRVGKVQABVZKWCMWUAQYLKQNNQGVKWUGWZQNQGVKNVBBAWCCQPQTLGRVRQGGVKPWTPRWUBLGRTYSMWUAWUBLLKQNGKVQABVWUGWZQGKVQABVNVBBVRAWCCQPGUDTLFUGGRVMNVKVTYGRVNVBBAWCCQQBTAVPQTLGWGRVLWKCWUPVAWCCQYWGARWWPTYEGWYWGTAVGRTPBQPGKVCQKSLWGWZAWUKPVGRVMNVKVAWCCQPQTLGRVLWKCWUPVNVBBTYLWGGRTPQYPNVKPWAWYZUPVLDWWKQBTAVAWCCQGRQGPRVBVGGRVLWKCWUPVEWWYZWKPWCVGTCVNTGRWUGTYGVKKUDGTYETGLWGGRVMNVKVBVQKYTYEGWLKQNAWCCQGRVLWKCWUPVNVYGWYAWCCQMQNYTYEQYLKUFFTYETGPVMVPAWCCQZWKTGNQPEVGGTYEIVKMPBVVDMQYLGRVMLKVNQBBCQYYVKWZGRTYEPVIVKMGRTYEGRQGFVETYPNTGRQYCNRMNTGRQYCPQTLQBTAV";
        int key = 3;
        String cipherText2 = "BZISGZFTZCRQHQUNUVUHTFUVAFISCETBGOWLLTTFVTEVPWKCUVZCOGCMTFSBACLFWFCZUVFZSBBAGMVTZQZCWMGPISDKLTCLWRTFOPVDVZDCCASBDKABEVAGWKFULTGATFPRTBSCMEAZSISBAPMVXVRORXEMWMIETZTFUVFOWRTCLWIQMYSWOPVDVZUVQZBZRLEXUPSIISWSTVWRUNTVAUVZBASLWMZEUAZUHZUYFCRTRLKWFZSBTSXVCSGPOWCZSBVIQWLFKSISUHBUUNBMUZLZHECTAFZCLWWMSKOPVDVZUVYMMOSBTVEWFZSBOMMWVZSUPOMPRILZFUSBKSWMEFSBACLFCFVIACCTFCWMSUSBAPHTFWCDISWFAZPSWMAFISCFUHOMMWVZHKKCUVZCTNBSTHXLLTZCSGCSMZVZUVFOMZVZATTFTVISCFOMLUBAXZVMBWCLSKXVKXTRGPVFTSMZVZISCFCLCEWKKBAZVIOGTVIQSUCZSBNYEXOPVDVZRTVLGXUHCUSBYNKXOPVDVZMSXVBAUNLPTZCTBZISAZOPVDVZUVQWCZMBLCWFTVSBFZPRTBSCMCSUSBMVXVRGPOENUZISWLCZZCZWCZBWRLERMZVZVTZQISCSMOXVXWXKZPSGMZVZXOZLUHRUWRUNLPLTISCDCLBACEOPVDVZTHLFWBLTCLCPUHCURWAHLTBAAFAEWBIQKWWRUNLCOPVDVZUVQZZVRKZXCDAZOPVDVZDCPAZSTNIELTSLGXYUOPSDPGZULKCFIQUNMGAFZCLWXRAHWFCZISCMCSCLUZAGCTXCUPSIKSWFSWMCLIXWFUVIZSQNLTCATHLWUZUHNKCFWMZUSPMZVZVTZQISCFUHOMMWVZSMZXKXOPVDVZZBTHIQVIXZSBXVAFZCLWUZWMAFISTHZXSLSUAGWSZXCFSBACXAWKLCMHPGLTVYZPTNISUVLSLCZCCKZCTZCDISCEPGCTFSMZVZUVFZSBDKXREWFMCDTVAFISUZWMGPISQKCSZVCFAPWFOPVDVZUVQMZXZCPAFWGMISWKZPSMLIGEWMAFZCISBTGCCLUZZPFUSBACLFCTLWRTSWISUHSKCASBXTCASBCASBXUXMUVSCFOMZVZUVQZSUSBTXFCGVRDGMISKFNTQYFWVKFGZVKTRPVULPRZXOAHLCOPVDVZXEMOUHCNBZEFKXATTFLWDCCLISWSWMZCSUSBCZSBCVZQWCEFSBLZFCCASBFGGZWXTCCFSBGPZXCDFKRLWRBLPAGEGAVYHUUNISGPYNVILWUTZAYTERGZSUGXOPVDVZBZISCGLFKSSWZXMOMFCZFCWOAZIPPAPNFEWRBWCVUVXZRLEASBGPZXWPOXLCWFBZISACLFCTVIUNUHCYAKWRDQWKTPZPTNXCTAFTWMAFISKFBWCLCGLTAEQGKWTVWFZCTCCFIQMFWKUPSIYTERGZSUGXLWDCCLISWSWMISMOMVXRKBCSGPVFTFSBPASLVXNEWFWMGPISFQCZISUZTHLTHTKXWMSKOPVDVZCLRBTBFZSBTSXVCSGPOWCZISCFUHOMMWVZSHTNIETAWXTNXVTXFSMZVZMCBWRTSYWRUZZCISWCISLCHTFWWMFTCZSBOMMWVZSURDGWIQVTFLUVQWKCUVZCPSPRWMKMMHXREACLCTZCVZEWXVTXFSMZVZUVWOIQKWSBLZHETNXUAFISTHISCTRTCLOGMODCYUWMSUSBPASLPLUVLUACLFCEAKWRDYQTSKXCTAZFCZISTHRBLTTCQYWMGPISFGMZVZBMPMZXLTFCVYMGISUHPKTZUYFTXRWXUXOPVDVZUVFMSBVZFWIVLTCADNLTWREFSBPACBXCTAZFCZKIZAAFZUEWTFZHCFMZULLTVXEFOPVDVZLSKSBMKSGMBTVTHTMYTNACZPTNUVYZSUAPUHRUTFSBZAMKRDMWVZSGMZVZUVWOSBVYHUPNFSZVCFSBOMGLLZMSCZWMSKWMFTCZSBFDGZMYTRMDQGRXSCYUFWCASBACLFCTBMLCCFSBFNKWCIBWRLKASUABISWSPGHUUNUVQYWMGPISFQCLZVWFCDISLFWSLCXRFOAZFGMZVZUVWMEFSBCPMWBZIUOXMDOPVDVZBMMOGZWXMCGMTCMYSBPLTREUPMLCMOSVMZLTRUUHWMZCAGBAAFAEBCXVUFCDACXAWKLCVTLZEWSKFZSBSKFAZMGVUHCGCECLMVWFUVQDAKWRQSPRCSMZVZUVQYWMGPISQKCLULXTTFWFBAEWIRPASGCTMCDYQCLTPSCTUVQOKAHMXCMZISCFCLCTLWHTFWISLCAHLCWMIEBSUHFZSBZOTVISWFXVEYPGCTAFISKFVIQOTVTCFMTXWKFUVPGZPNOPVDVZXRISGZPNISKFVIFMTYECCLWZUVFQTHOPAGURWSKSFTKIIECEPGCFSBZOTVXRRMWKFGMZVZNTVYUKOPYUACFUVIFTLFWSWFZCLWGEGMISWSGMZCISLFWSLCXRFOAZFQCZZCLWNTCLOPVDVZISWLGPZXPASLGVMOGTAFISWSCDDYXCMZISTHLWUTZAYTRLRXMYWMIETZISLCTXZETVSKXVKXWMSKOPVDVZUVXZEFLCISCFUHOMMWVZSVZXGTZUECOZPGWKPCVTMYXTTFKSWFISWSZCCKISLCBZISOMMWKSHQSMOPVDVZISKFBWCLCLZXFUCMZUCA";
        String plainText = getPlainText(cipherText, key);
        System.out.println(cipherText2.length());
        //System.out.println(plainText);
        //getFrequencyLetter(cipherText2);
        //monoalphaCipher(cipherText);
        //String[] pairs = getFrequencyPairs(cipherText2);
        //decodePlayFairCipher(cipherText2,pairs);
        //findCollisionCRC32();
        findWeakCollisionCRC32();

    }

    public static String getPlainText(String cipherText, int key) {
        String plainText = "";
        String [] chars = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for (int i=0; i< cipherText.length();i++){
            int tmp = cipherText.charAt(i);
            tmp -= 'A';
            int index = ((tmp - key) % 25);
            if( index < 0)
                index += 25;
            plainText+= chars[index % 25] ;
        }


        return plainText;
    }

    public static int[] getFrequencyLetter(String cipherText) {
        int[] retVal = new int[26];
        for(int i=0;i<cipherText.length();i++){
            int tmp = cipherText.charAt(i) - 'A';
            retVal[tmp]++;
        }

        System.out.println("Here is the analysis of letter frequency.");
        for(int i =0;i<retVal.length;i++){
            char tmp = 'A';
            tmp+=i;
            System.out.println(tmp + ": " + retVal[i]);
        }

        return retVal;
    }

    public static void monoalphaCipher(String cipherText) {
        char[] plainLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] cipherLetter = {'Q','F','A','L','V','Z','E','R','T','X','S','B','C','Y','W','D','J','K','P','G','U','I','N','O','M','H'};
        String plainText = "";
        boolean flag = false;
        for(int i =0;i<cipherText.length();i++){
            flag = false;
            for(int j=0;j<plainLetters.length;j++){
                if(cipherText.charAt(i) == cipherLetter[j]) {
                    plainText += plainLetters[j];
                    flag = true;
                    break;
                }
            }
            if(!flag)
                plainText+="   ";
        }

        System.out.println("Decoded String is : " + plainText);
    }

    public static String[] getFrequencyPairs(String cipherText){
        //we know that the length of the cipher text is 2718, therefore, the length of pair shoudl 1359
        String[] pairs = new String [1359];
        int[] freqOfParis = new int [1359];

        int k = 0;
        for(int i=0;i<cipherText.length();i+=2){
            pairs[k++]= cipherText.substring(i,i+2);
        }

        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for(int i=0;i<pairs.length;i++){
            if(map.containsKey(pairs[i])) {
                map.put(pairs[i],map.get(pairs[i])+1);
            }else
                map.put(pairs[i],1);
        }

        Map<String, Integer> map2 = sortByValue(map);
        for (Map.Entry<String, Integer> en : map2.entrySet()) {
            System.out.println(en.getKey() +
                    " = " + en.getValue());
        }
        Object[] keys = map.keySet().toArray();
        String[] retArr = new String [keys.length];
        for(int i = 0;i< keys.length;i++){
            retArr[i] = keys[i].toString();
        }
        return retArr;
    }

    // put data from sorted list to hashmap
    //code is retrieve from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });

            // put data from sorted list to hashmap
            HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> aa : list) {
                temp.put(aa.getKey(), aa.getValue());
            }
            return temp;
        }

        public static void decodePlayFairCipher(String cipherText, String[] pairs) {

            String plainTest = "";
            for (int i = 0; i < cipherText.length(); i += 2) {
                if (cipherText.substring(i, i + 2) == "IS") {
                    plainTest += "TH";
                } else if (cipherText.substring(i, i + 2) == "SB") {
                    plainTest += "HE";
                } else
                    plainTest += cipherText.substring(i, i + 2);

            }

            System.out.println(plainTest);
        }

        public static void findCollisionCRC32(){
            HashMap<String,Long> map = new HashMap<String, Long>();
            char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            CRC32 crc = new CRC32();
            long startTime = System.nanoTime();
            byte[] array = new byte[20];
            long iteration = 0;
            long val = 0;
            while(true) {
                crc.reset();
                new Random().nextBytes(array);
                String str = Base64.getUrlEncoder().encodeToString(array);
                byte[] bytes = str.getBytes();
                crc.update(bytes,0,bytes.length);
                val= crc.getValue();
                if(map.containsValue(val)){
                    System.out.println("Collision Detected: the word is " + str);
                    System.out.println("It took " + (System.nanoTime() - startTime));
                    break;
                }else {
                    map.put(str,val);
                    iteration++;
                    System.out.println(iteration+" attempted");
                }
            }

            List<String> keys = new ArrayList<String>();

            for ( String key : map.keySet() ) {
                if ( map.get( key ).equals(val)) {
                    keys.add(key);
                }
            }

            System.out.println( val + " has been found in: " + keys );
        }


        public static void findWeakCollisionCRC32(){
            HashMap<String,Long> map = new HashMap<String, Long>();
            CRC32 crc = new CRC32();
            long startTime = System.nanoTime();
            String MD5Hash = "4f12dff34f57dbc046731a368b0835ca";
            byte[] bytes = MD5Hash.getBytes();
            crc.update(bytes,0,bytes.length);
            long targetVal = crc.getValue();
            byte[] array = new byte[24];
            long val = 0;
            int iteration = 0;
            while(true){
                crc.reset();
                new Random().nextBytes(array);
                String str = Base64.getUrlEncoder().encodeToString(array);
                byte[] tmpBytes = str.getBytes();
                crc.update(tmpBytes,0,tmpBytes.length);
                val= crc.getValue();
                if(val == targetVal){
                    System.out.println("Collision Detected: the word is " + str);
                    System.out.println("It took " + (System.nanoTime() - startTime));
                    break;
                }else {
                    iteration++;
                    System.out.println(iteration+" attempted");
                }
            }
        }
}
