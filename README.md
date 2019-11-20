# Vigenere_Key_Finder_Java
## A simple Vigenere Key Finder

--------------------------------------------
Cipher (#205 Dinneen):
QCERIOEECFZWERWUSAMXXPNSCUSOTWBYDTRPCGZRJKECXSZOOWUSIRMTLQTITEINRXSIBLUSEBSVYTQCXTLKRPEAKPPHMDXPPVZHFEHDVFTSZGVCINYTXYRXFCYZFPFTSLFYULFFCOEXIPTQSPASMSXHISLZZUVLFYISIMPGQEQSECCPFOMXIPTGWBJIMKZZUGEEZVDVBSUMHSPDSLPFSZREHISLZZUHLBOJTWUZBSEJYECJSZMSLFDEBVFEAQCPQWZVBDTZXFXEMXULKDRBDHDWBTDEVPXYNYSZWMVFEUQRTXAJMOR

Key: BLAZE

Message:
PRESENTEDBYLESSTHANTWENTYTHOUSANDUNORGANIZEDTROOPSTHISISAQUESTIONWHICHTHECOUNTRYWILLNOTALLOWMETOEVADETHEREISACURIOUSMYSTERYABOUTTHENUMBEROFTHETROOPSNOWWITHYOUWHENITELEGRAPHEDYOUONTHETHSAYINGYOUHADOVERAHUNDREDTHOUSANDWITHYOUIHADJUSTOBTAINEDFROMTHESECRETARYOFWARASTATEMENTTAKENASHESAIDFROMYOUROWNRETURNSMAKING
--------------------------------------------


To decrypt the Vigenere I decided to write this code to find the key. 
I then used professor Oser's decryptor with the found key.

The "Decrypt" class contains four methods (not including main) and two static attributes.

### The Attributes:
- "trueEngFrequencies" is just an array containing the average letter frequencies in English in alphabetical order.
- "alphabet" is just an array containing each letter of the alphabet (capitalized)


### The Methods:

- "everyXthLetter" is a method that takes in a cipher to decipher (String cipher), the (potential) length of a key (int x), and the starting position (int start). It splits the cipher into an array of letters and then takes a subsection of that array, taking only every Xth letter, beginning at start. It returns this subsection as an ArrayList<String>. 

- "letterFreqs" is a method that takes in a subselection (ArrayList<String>) and returns an array of its letter frequencies i alphabetical order. It does this by iterating through the alphabet and using two temporary Array Lists to count the number of each letter in the subsection (making use of the retailAll() and size() methods on ArrayList). The proportions of those letters are then found and added to a new array (Double[]). These frequencies are returned.

- "findKeyLength" is a method that takes in the raw cipher (String cipher) and returns the most likely key length (I'm not sure if this is actually the case). It does this by testing each potential key length from 1-7 and then taking the dot product of that frequency vector (made with "everyXthLetter" and "letterFreqs") with the real english frequencies (trueEngFrequencies). Both of these vectors are first sorted because we are comparing frequencies and not looking for the letters themselves. It then returns the most likely key length (i.e. the one with the largest dot product)

- "findKey" takes in the key length (int keyLength) and the raw cipher (String cipher). Then, for each letter in the key, it generates a letter frequency vector (each time at a different starting point). For each of these vectors, it iterates through the alphabet, taking the dot product of the found frequency vector and the True English Frequencies (translates by a different amount for each letter). It simultaneously records which dot product is the largest and also which letter it corresponds to. After doing this "keyLength" times, we are left with the actual key. The function returns the key.


### To Run:

In the command line...

Run this like any other java file (either compile the .java file in src with javac Filepath/Filename.java and then run it with java Filepath/Filename.java, or run the .jar file in out with java -jar Filepath/Filename.jar)

However, with both of these you need to input the cipher text you would like to find the key for as a parameter for main.

E.X.

java src/com/numthe/vigenere/Decrypt.java DITQBJMOZRHBDRATGOKYNHHMEYBZSWTOZQCSISOPTJDQJDMTRRFCMDBBBHKCYBDXBTHNSMKZDMBRYCNNFCMLCAYQXKZWGAJJHBJCWMCHTNMHNLBURVGYBCQYBHEQMRSNTZJZNQCDITKCKNGDPJUMCWTOJMCBNGDNWYRRSWYTMBJLVGGHBHCGICSZLIURHRMITFFYUBPSNYRBCICMHRHYQSYNHKXLTNVHRMITSPJFTBRFHBDYKNDQWTOKDDYCZRAJLSZGSYCSFFNKDQXNGZL

OR

java -jar out/artifacts/Decrypt_Vigenere_jar/Decrypt_Vigenere.jar DITQBJMOZRHBDRATGOKYNHHMEYBZSWTOZQCSISOPTJDQJDMTRRFCMDBBBHKCYBDXBTHNSMKZDMBRYCNNFCMLCAYQXKZWGAJJHBJCWMCHTNMHNLBURVGYBCQYBHEQMRSNTZJZNQCDITKCKNGDPJUMCWTOJMCBNGDNWYRRSWYTMBJLVGGHBHCGICSZLIURHRMITFFYUBPSNYRBCICMHRHYQSYNHKXLTNVHRMITSPJFTBRFHBDYKNDQWTOKDDYCZRAJLSZGSYCSFFNKDQXNGZL


### TEST/EXAMPLES:

--------------------------------------------
Cipher (#201 Burch):
DITQBJMOZRHBDRATGOKYNHHMEYBZSWTOZQCSISOPTJDQJDMTRRFCMDBBBHKCYBDXBTHNSMKZDMBRYCNNFCMLCAYQXKZWGAJJHBJCWMCHTNMHNLBURVGYBCQYBHEQMRSNTZJZNQCDITKCKNGDPJUMCWTOJMCBNGDNWYRRSWYTMBJLVGGHBHCGICSZLIURHRMITFFYUBPSNYRBCICMHRHYQSYNHKXLTNVHRMITSPJFTBRFHBDYKNDQWTOKDDYCZRAJLSZGSYCSFFNKDQXNGZL 

Key: FUZZY

Message:
YOURDESPATCHESCOMPLAININGTHATYOUARENOTPROPERLYSUSTAINEDWHILETHEYDONOTOFFENDMEDOPAINMEVERYMUCHBLENCKERSDIVISIONWASWITHDRAWNFROMYOUBEFOREYOULEFTHEREANDYOUKNEWTHEPRESSUREUNDERWHICHIDIDITANDASITHOUGHTACQUIESCEDINITCERTAINLYNOTWITHOUTRELUCTANCEAFTERYOULEFTIASCERTAINEDTHATLESSTHAN

--------------------------------------------
Cipher (#202 Chun):
JQMPDONPQEIUVFEDIZIKDCHGNCYVYSJBWWDQMQPQBYNKOBXJCDJYZAGULMCVBSWWNUMQIXUXBQLUFMHDVIZVRUXMHODWMQPMUAJSDABQXQHLOKDUAUKIDCPMJCWPKDXXCBJINVRYMMXODQIUDEAWVYWYVJYEEMTCEFLRYICBKYDAMPLQHSUMELXUYDWMFOICOPOTZWTWQHIUCQMRWXSNQQXMUAFSLYZVOTUVFDYYLWZEHBJOBCVGYVQQPMXYAVOHUVFCJLIWCROZIKDXKQEBXVQDBYIXOYNEKDXICVKWUQPONJWUSDABJOKJXGBFIBQWQWIPNJBMDKBNQOYHYIPNEBQQBQCTTYQX

Key: QUICK

Message:
TWENTYTHOUSANDUNORGANIZEDMENWITHOUTASINGLEFIELDBATTERYWEREALLYOUDESIGNEDTOBELEFTFORTHEDEFENCEOFWASHINGTONANDMANASSASJUNCTIONANDPARTOFTHISEVENWASTOGOTOGENHOOKERSOLDPOSITIONGENBANKSCORPSONCEDESIGNEDFORMANASSASJUNCTIONWASDIVERTEDANDTIEDUPONTHELINEOFWINCHESTERANDSTRAUSBURGANDCOULDNOTLEAVEITWITHOUTAGAINEXPOSINGTHEUPPERPOTOMACANDTHEBALTIMOREANDOHIORAILROAD

--------------------------------------------
Cipher (#203 Deuberry):
VYIRNTVSDLVVDNPYFUKBRIERCPKWGCPDCCMYVLKYPUSTKPVRRFQLLCZGXOMCCXRDYVKELNVRTHMPKOSFGVNDKAKOSSTEBZAMWRNKVYEQYRGAGYPFCJYPUSZAMNARFKEGSMPDYDVRCIBGVFRCCTKHZRYRSGGPXTNLUYOTJFSYSFGAUCEOVNSMHRLKRJVCNKORNCCTJOEYTDYBMTGSACNVFSCPKIQCNPSDAWIEGYFSEDLPVGKCEKECGVNARNTVCHQGCYSFKJTGYVURNTGDESMFVTZGPDCCMYVLKGFFNNRHFRFCVKHZRKNAR

Key: CRAZY

Message:
THISPRESENTEDORWOULDPRESENTWHENMCDOWELLANDSUMNERSHOULDBEGONEAGREATTEMPTATIONTOTHEENEMYTOTURNBACKFROMTHERAPPAHANOCKANDSACKWASHINGTONMYEXPLICITORDERTHATWASHINGTONSHOULDBYTHEJUDGMENTOFALLTHECOMMANDERSOFARMYCORPSBELEFTENTIRELYSECUREHADBEENNEGLECTEDITWASPRECISELYTHISTHATDROVEMETODETAINMCDOWELLIDONOTFORGETTHATIWAS

--------------------------------------------

