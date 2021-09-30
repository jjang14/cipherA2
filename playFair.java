import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;

//get helped from http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-playfair/
//To understand how to crack playfair cipher and SA algorithm (Simulated-Anealing)
public class playFair {


    public static void main(String[] args){
        String cipherText = "BZISGZFTZCRQHQUNUVUHTFUVAFISCETBGOWLLTTFVTEVPWKCUVZCOGCMTFSBACLFWFCZUVFZSBBAGMVTZQZCWMGPISDKLTCLWRTFOPVDVZDCCASBDKABEVAGWKFULTGATFPRTBSCMEAZSISBAPMVXVRORXEMWMIETZTFUVFOWRTCLWIQMYSWOPVDVZUVQZBZRLEXUPSIISWSTVWRUNTVAUVZBASLWMZEUAZUHZUYFCRTRLKWFZSBTSXVCSGPOWCZSBVIQWLFKSISUHBUUNBMUZLZHECTAFZCLWWMSKOPVDVZUVYMMOSBTVEWFZSBOMMWVZSUPOMPRILZFUSBKSWMEFSBACLFCFVIACCTFCWMSUSBAPHTFWCDISWFAZPSWMAFISCFUHOMMWVZHKKCUVZCTNBSTHXLLTZCSGCSMZVZUVFOMZVZATTFTVISCFOMLUBAXZVMBWCLSKXVKXTRGPVFTSMZVZISCFCLCEWKKBAZVIOGTVIQSUCZSBNYEXOPVDVZRTVLGXUHCUSBYNKXOPVDVZMSXVBAUNLPTZCTBZISAZOPVDVZUVQWCZMBLCWFTVSBFZPRTBSCMCSUSBMVXVRGPOENUZISWLCZZCZWCZBWRLERMZVZVTZQISCSMOXVXWXKZPSGMZVZXOZLUHRUWRUNLPLTISCDCLBACEOPVDVZTHLFWBLTCLCPUHCURWAHLTBAAFAEWBIQKWWRUNLCOPVDVZUVQZZVRKZXCDAZOPVDVZDCPAZSTNIELTSLGXYUOPSDPGZULKCFIQUNMGAFZCLWXRAHWFCZISCMCSCLUZAGCTXCUPSIKSWFSWMCLIXWFUVIZSQNLTCATHLWUZUHNKCFWMZUSPMZVZVTZQISCFUHOMMWVZSMZXKXOPVDVZZBTHIQVIXZSBXVAFZCLWUZWMAFISTHZXSLSUAGWSZXCFSBACXAWKLCMHPGLTVYZPTNISUVLSLCZCCKZCTZCDISCEPGCTFSMZVZUVFZSBDKXREWFMCDTVAFISUZWMGPISQKCSZVCFAPWFOPVDVZUVQMZXZCPAFWGMISWKZPSMLIGEWMAFZCISBTGCCLUZZPFUSBACLFCTLWRTSWISUHSKCASBXTCASBCASBXUXMUVSCFOMZVZUVQZSUSBTXFCGVRDGMISKFNTQYFWVKFGZVKTRPVULPRZXOAHLCOPVDVZXEMOUHCNBZEFKXATTFLWDCCLISWSWMZCSUSBCZSBCVZQWCEFSBLZFCCASBFGGZWXTCCFSBGPZXCDFKRLWRBLPAGEGAVYHUUNISGPYNVILWUTZAYTERGZSUGXOPVDVZBZISCGLFKSSWZXMOMFCZFCWOAZIPPAPNFEWRBWCVUVXZRLEASBGPZXWPOXLCWFBZISACLFCTVIUNUHCYAKWRDQWKTPZPTNXCTAFTWMAFISKFBWCLCGLTAEQGKWTVWFZCTCCFIQMFWKUPSIYTERGZSUGXLWDCCLISWSWMISMOMVXRKBCSGPVFTFSBPASLVXNEWFWMGPISFQCZISUZTHLTHTKXWMSKOPVDVZCLRBTBFZSBTSXVCSGPOWCZISCFUHOMMWVZSHTNIETAWXTNXVTXFSMZVZMCBWRTSYWRUZZCISWCISLCHTFWWMFTCZSBOMMWVZSURDGWIQVTFLUVQWKCUVZCPSPRWMKMMHXREACLCTZCVZEWXVTXFSMZVZUVWOIQKWSBLZHETNXUAFISTHISCTRTCLOGMODCYUWMSUSBPASLPLUVLUACLFCEAKWRDYQTSKXCTAZFCZISTHRBLTTCQYWMGPISFGMZVZBMPMZXLTFCVYMGISUHPKTZUYFTXRWXUXOPVDVZUVFMSBVZFWIVLTCADNLTWREFSBPACBXCTAZFCZKIZAAFZUEWTFZHCFMZULLTVXEFOPVDVZLSKSBMKSGMBTVTHTMYTNACZPTNUVYZSUAPUHRUTFSBZAMKRDMWVZSGMZVZUVWOSBVYHUPNFSZVCFSBOMGLLZMSCZWMSKWMFTCZSBFDGZMYTRMDQGRXSCYUFWCASBACLFCTBMLCCFSBFNKWCIBWRLKASUABISWSPGHUUNUVQYWMGPISFQCLZVWFCDISLFWSLCXRFOAZFGMZVZUVWMEFSBCPMWBZIUOXMDOPVDVZBMMOGZWXMCGMTCMYSBPLTREUPMLCMOSVMZLTRUUHWMZCAGBAAFAEBCXVUFCDACXAWKLCVTLZEWSKFZSBSKFAZMGVUHCGCECLMVWFUVQDAKWRQSPRCSMZVZUVQYWMGPISQKCLULXTTFWFBAEWIRPASGCTMCDYQCLTPSCTUVQOKAHMXCMZISCFCLCTLWHTFWISLCAHLCWMIEBSUHFZSBZOTVISWFXVEYPGCTAFISKFVIQOTVTCFMTXWKFUVPGZPNOPVDVZXRISGZPNISKFVIFMTYECCLWZUVFQTHOPAGURWSKSFTKIIECEPGCFSBZOTVXRRMWKFGMZVZNTVYUKOPYUACFUVIFTLFWSWFZCLWGEGMISWSGMZCISLFWSLCXRFOAZFQCZZCLWNTCLOPVDVZISWLGPZXPASLGVMOGTAFISWSCDDYXCMZISTHLWUTZAYTRLRXMYWMIETZISLCTXZETVSKXVKXWMSKOPVDVZUVXZEFLCISCFUHOMMWVZSVZXGTZUECOZPGWKPCVTMYXTTFKSWFISWSZCCKISLCBZISOMMWKSHQSMOPVDVZISKFBWCLCLZXFUCMZUCA";
        String cipherText2 = "BZISGZFTZCRQHQUNUVUHTFUVAFISCETBGOWLLTTFVTEVPWKCUVZCOGCMTFSBACLFWFCZUVFZSBBAGMVTZQZCWMGPISDKLTCLWRTFOPVDVZDCCASBDKABEVAGWKFULTGATFPRTBSCMEAZSISBAPMVXVRORXEMWMIETZTFUVFOWRTCLWIQMYSWOPVDVZUVQZBZRLEXUPSIISWSTVWRUNTVAUVZBASLWMZEUAZUHZUYFCRTRLKWFZSBTSXVCSGPOW";
        String parentsKey = gernerateParentKey();
        doCrack(cipherText2,parentsKey);

    }

    public static String gernerateParentKey() {
        Character[] key = {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Character> charList = Arrays.asList(key);

        Collections.shuffle(charList);
        String retKey = "";
        for(int i=0;i<charList.size();i++){
            retKey+=charList.get(i);
        }
        return retKey;
    }

    public static void doCrack(String cipherText, String key) {
        String childKey;
        double parentScore,childScore;

        String plainText = decodeCipher(cipherText, key);
        parentScore = scoreQgram(plainText);


        for(int temp =10 ;temp>0; temp--){
            for(int tr = 50000; tr > 0; tr--){
                childKey = shuffleKey(key);
                plainText = decodeCipher(cipherText,childKey);
                childScore = scoreQgram(plainText);
                if(childScore > parentScore){
                    System.out.println("better score: key is " + childKey);
                    System.out.println("plainText is : "+ plainText);
                    parentScore = childScore;
                }
            }
        }
    }


    public static String decodeCipher(String cipherText, String key) {

        String plainText = "";

        for(int i = 0;i<cipherText.length();i+=2){
            char first = cipherText.charAt(i);
            char second = cipherText.charAt(i+1);

            int rowFirst = key.indexOf(first) / 5;
            int rowSecond = key.indexOf(second) / 5;
            int colFirst = key.indexOf(first) % 5;
            int colSecond = key.indexOf(second) % 5;

            if(rowFirst == rowSecond) {
                plainText += key.charAt(5 * rowFirst + (colFirst + 4) % 5);
                plainText += key.charAt(5 * rowSecond + (colSecond + 4) % 5);
            } else if (colFirst == colSecond){
                plainText += key.charAt(5 * ((rowFirst + 4) % 5) + colFirst);
                plainText += key.charAt(5 * ((rowSecond + 4) % 5) + colSecond);
            }else {
                plainText += key.charAt(5 * rowFirst + colSecond);
                plainText += key.charAt(5 * rowSecond + colFirst);
            }

        }

        return plainText;
    }

    public static String shuffleKey(String key){
        int index = 0;
        char[] keyArr = new char[25];
        for(int i =0; i< key.length();i++){
            keyArr[i] = key.charAt(i);
        }
        Random rd = new Random();
        for(int i =0;i<key.length();i++) {
            index = rd.nextInt(i+1);
            char tmp = keyArr[index];
            keyArr[index] = keyArr[i];
            keyArr[i] = tmp;
        }
        String shuffledKey = "";
        for(int i =0; i< key.length();i++){

            shuffledKey+=keyArr[i];
        }

        return shuffledKey;
    }

    public static List<Double> getQgramArr() throws FileNotFoundException {
        File file = new File("./4grams.txt");
        Scanner scanner = new Scanner(file);
        List<Double> qgramList = new ArrayList<Double>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] token = line.split(",");
            qgramList.add(Double.parseDouble(token[0]));
        }
        return qgramList;
    }

    public static double scoreQgram( String plainText) {
        double retScore = 0;
        try {
            List<Double> qgram = getQgramArr();
            int first,second,third,forth;
            for(int i =0;i<plainText.length()-3;i++) {
                first = plainText.charAt(i) - 'A';
                second = plainText.charAt(i+1) - 'A';
                third = plainText.charAt(i+2) - 'A';
                forth = plainText.charAt(i+3) - 'A';

                retScore+= qgram.get(17576*first + 676*second + 26*third + 3*forth);
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }

        return retScore;
    }

}
