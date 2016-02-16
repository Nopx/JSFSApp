package org.nopx.vocabapp;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Vocab{
	
	public static int STATE_WORDS =0;
	public static int STATE_KANJI =1;
	
	//List	 	of 	List
	//Lektions		VocabListe
	public ArrayList <ArrayList <String[]>> vocab = new ArrayList <ArrayList <String[]>>();
	private String[][] currentVocab;
	private String[][] verbs;
	private String[][] nouns;
	private String[][] adjectives;
	public Vocab(boolean[] settings){	
		if(settings.length <50){
			initializeVocabAsKanji();
			currentVocab = getVocabList(settings);
		}
		else{
			initializeVocabAsWords();			
			currentVocab = getVocabList(settings);
			verbs = getWordTypeList("verb");
			nouns = getWordTypeList("nomen");
			adjectives = getWordTypeList("adjektiv");
			}
	}
	
	private void initializeVocabAsWords(){
				ArrayList<String[]> lektion1 = new ArrayList<String[]>();
			lektion1.add(new String[]{"ja","hai","はい","adjektiv"});
			lektion1.add(new String[]{"nein","iie","いいえ","adjektiv"});
			lektion1.add(new String[]{"bitte(beim Anbieten)","douzo","どうぞ","nomen"});
			lektion1.add(new String[]{"danke","doumo","どうも","adjektiv"});
			lektion1.add(new String[]{"heute","kyou","きょう","adjektiv"});
			lektion1.add(new String[]{"morgen","ashita","あした","adjektiv"});
			lektion1.add(new String[]{"übermorgen","asatte","あさって","adjektiv"});
			lektion1.add(new String[]{"essen","tabemasu(1)","たべます(1)","verb"});
			lektion1.add(new String[]{"trinken","nomimasu(5)","のみます(5)","verb"});
			lektion1.add(new String[]{"reden,sprechen","hanashimasu(5)","はなします(5)","verb"});
			lektion1.add(new String[]{"warten","machimasu(5)","まちます(5)","verb"});
			lektion1.add(new String[]{"spielen, sich vergnügen","asobimasu(5)","あそびます(5)","verb"});
		vocab.add(lektion1);

		ArrayList<String[]> lektion2 = new ArrayList<String[]>();
			lektion2.add(new String[]{"Fisch","sakana","さかな","nomen"});
			lektion2.add(new String[]{"Gemüse","yasai","やさい","nomen"});
			lektion2.add(new String[]{"Brot","pan","ぱん","nomen"});
			lektion2.add(new String[]{"Kaffee","kohi","こひ","nomen"});
			lektion2.add(new String[]{"Ei","tamago","たまご","nomen"});
			lektion2.add(new String[]{"gestern","kinou","きのう","adjektiv"});
			lektion2.add(new String[]{"heute Abend","konban","こんばん","nomen"});
			lektion2.add(new String[]{"immer","itsumo","いつも","adjektiv"});
			lektion2.add(new String[]{"meistens","taitei","たいてい","adjektiv"});
			lektion2.add(new String[]{"was","nani","なに","adjektiv"});
			lektion2.add(new String[]{"kaufen","kaimasu(5)","かいます(5)","verb"});
			lektion2.add(new String[]{"sich ausruhen,Pause machen","yasumimasu(5)","やすみます(5)","nomen"});
			lektion2.add(new String[]{"tun","shimasu(unr.)","します(unr.)","verb"});
			lektion2.add(new String[]{"arbeiten","shigoto o shimasu","しごと お します","adjektiv"});
			lektion2.add(new String[]{"Kleidung,Kleider","fuku","ふく","nomen"});
			lektion2.add(new String[]{"Buch","hon","ほん","nomen"});
			lektion2.add(new String[]{"Zeitschrift","zasshi","ざっし","nomen"});
			lektion2.add(new String[]{"Arbeit","shigoto","しごと","nomen"});
			lektion2.add(new String[]{"Verzeihung","sumimasen","すみません","nomen"});
		vocab.add(lektion2);

		ArrayList<String[]> lektion3 = new ArrayList<String[]>();
			lektion3.add(new String[]{"Spielfilm","eiga","えいが","nomen"});
			lektion3.add(new String[]{"Musik","ongaku","おんがく","nomen"});
			lektion3.add(new String[]{"Zeitung","shinbun","しんぶん","nomen"});
			lektion3.add(new String[]{"Fernseher; Fernsehen","terebi","てれび","nomen"});
			lektion3.add(new String[]{"Radio","rajio","らじお","nomen"});
			lektion3.add(new String[]{"ich","watashi","わたし","adjektiv"});
			lektion3.add(new String[]{"Süßigkeiten, Gebäck","o-kashi","お-かし","nomen"});
			lektion3.add(new String[]{"Reiswein, Alkohol, Getränk","o-sake","お-さけ","nomen"});
			lektion3.add(new String[]{"(an/zu)hören; fragen","kikimasu(5)","ききます(5)","verb"});
			lektion3.add(new String[]{"(an/zu)sehen","mimasu(1)","みます(1)","verb"});
			lektion3.add(new String[]{"herstellen, zubereiten","tsukurimasu(5)","つくります(5)","verb"});
			lektion3.add(new String[]{"lesen","yomimasu(5)","よみます(5)","verb"});
			lektion3.add(new String[]{"oft, häufig","yoku","よく","adjektiv"});
			lektion3.add(new String[]{"selten, kaum, nicht sehr","amari +Verneinung","あまり +Verneinung","adjektiv"});
			lektion3.add(new String[]{"gar nicht, nie","zenzen +Verneinung","ぜんぜん +Verneinung","adjektiv"});
		vocab.add(lektion3);

		ArrayList<String[]> lektion4 = new ArrayList<String[]>();
			lektion4.add(new String[]{"(Land-)Karte, Plan","chizu","ちず","nomen"});
			lektion4.add(new String[]{"Papier","kami","かみ","nomen"});
			lektion4.add(new String[]{"Wörterbuch","jisho","じしょ","nomen"});
			lektion4.add(new String[]{"Postkarte","hagaki","はがき","nomen"});
			lektion4.add(new String[]{"Foto","shashin","しゃしん","nomen"});
			lektion4.add(new String[]{"Bleistift","enpitsu","えんぴつ","nomen"});
			lektion4.add(new String[]{"(kaltes) Wasser","mizu","みず","nomen"});
			lektion4.add(new String[]{"(drückt Überraschung aus)","a","あ","nomen"});
			lektion4.add(new String[]{"diese Person hier","kochira","こちら","nomen"});
			lektion4.add(new String[]{"Freund/in(nicht Liebespartner)","tomodachi","ともだち","nomen"});
			lektion4.add(new String[]{"Tee","o-cha","お-ちゃ","nomen"});
			lektion4.add(new String[]{"anders sein, nicht stimmen","chigaimasu(5)","ちがいます(5)","verb"});
			lektion4.add(new String[]{"verstehen, wissen","wakarimasu(5)","わかります(5)","verb"});
			lektion4.add(new String[]{"schreiben, zeichnen","kakimasu(5)","かきます(5)","verb"});
		vocab.add(lektion4);

		ArrayList<String[]> lektion5 = new ArrayList<String[]>();
			lektion5.add(new String[]{"Sie, du","anata","あなた","nomen"});
			lektion5.add(new String[]{"wer","dare","だれ","adjektiv"});
			lektion5.add(new String[]{"Person(neutral), Leute","hito","ひと","nomen"});
			lektion5.add(new String[]{"Person(höflich)","kata","かた","nomen"});
			lektion5.add(new String[]{"Angestellte(r)","kaisha-in","かいしゃ-いん","nomen"});
			lektion5.add(new String[]{"Arzt, Ärztin","isha","いしゃ","nomen"});
			lektion5.add(new String[]{"Schüler(in), Student(in)","gakusei","がくせい","nomen"});
			lektion5.add(new String[]{"Lehrer(in)","sensei","せんせい","nomen"});
			lektion5.add(new String[]{"Ingenieur(in)","enjinia","えんじにあ","nomen"});
			lektion5.add(new String[]{"Japan","Nihon","にほん","nomen"});
			lektion5.add(new String[]{"Uhr","tokei","とけい","nomen"});
			lektion5.add(new String[]{"Schirm","kasa","かさ","nomen"});
			lektion5.add(new String[]{"Es tut mir Leid","gomen nasai","ごめん なさい","nomen"});
			lektion5.add(new String[]{"vielen Dank","arigatou gozaimasu","ありがとう ございます","nomen"});
			lektion5.add(new String[]{"Hm ...","saa ...","さあ ...","nomen"});
		vocab.add(lektion5);

		ArrayList<String[]> lektion6 = new ArrayList<String[]>();
			lektion6.add(new String[]{"Morgen, morgens","asa","あさ","nomen"});
			lektion6.add(new String[]{"Mittag, mittags","hiru","ひる","nomen"});
			lektion6.add(new String[]{"Abend, abends","ban","ばん","nomen"});
			lektion6.add(new String[]{"Gericht, Speise","ryouri","りょうり","nomen"});
			lektion6.add(new String[]{"gekochter Reis, Essen","gohan","ごはん","nomen"});
			lektion6.add(new String[]{"Frühstück","asa-gohan","あさ-ごはん","nomen"});
			lektion6.add(new String[]{"Mittagessen","hiru-gohan","ひる-ごはん","nomen"});
			lektion6.add(new String[]{"Abendessen","ban-gohan ","ばん-ごはん ","nomen"});
			lektion6.add(new String[]{"Miso-Suppe","miso-shiru","みそ-しる","nomen"});
			lektion6.add(new String[]{"roher Fisch in Scheiben","sashimi","さしみ","nomen"});
			lektion6.add(new String[]{"dann, dannach","sorekara","それから","adjektiv"});
			lektion6.add(new String[]{"tja, also","jaa(Verschleifung von >>dewa<<)","じゃあ(Verschleifung von >>dewa<<)","adjektiv"});
			lektion6.add(new String[]{"(sich) treffen; begegnen","aimasu(5)","あいます(5)","verb"});
			lektion6.add(new String[]{"Famillienname","myouji","mようじ","nomen"});
			lektion6.add(new String[]{"Ehemann(höflich)","danna-san","だんな-さん","nomen"});
			lektion6.add(new String[]{"Einkäufe","kaimono(5)","かいもの(5)","nomen"});
			lektion6.add(new String[]{"Auto, Wagen","kurama","くらま","nomen"});
			lektion6.add(new String[]{"ein wenig, ein bisschen","chotto","ちょっと","adjektiv"});
		vocab.add(lektion6);

		ArrayList<String[]> lektion7 = new ArrayList<String[]>();
			lektion7.add(new String[]{"Firma","kaisha","かいしゃ","nomen"});
			lektion7.add(new String[]{"Konferenz, geschäftl. Besprechung","kaigi","かいぎ","nomen"});
			lektion7.add(new String[]{"Hallo!(als Ruf)","yaa","やあ","nomen"});
			lektion7.add(new String[]{"gesund, wohl auf","genki","げんき","adjektiv"});
			lektion7.add(new String[]{"Danke,gut.(Antwort auf >>O-genki desu ka<<)","o-kage-sama-de","お-かげ-さま-で","nomen"});
			lektion7.add(new String[]{"Lebensmittel, Essen","tabemono","たべもの","nomen"});
			lektion7.add(new String[]{"Getränk","nomimono","のみもの","nomen"});
			lektion7.add(new String[]{"Geld","o-kane","お-かね","nomen"});
			lektion7.add(new String[]{"Bier","bîru","び~る","nomen"});
			lektion7.add(new String[]{"viel, viele","takusan","たくさん","adjektiv"});
			lektion7.add(new String[]{"ab und zu, manchmal","tokidoki","ときどき","adjektiv"});
			lektion7.add(new String[]{"Party","pâtî","ぱ~tい~","nomen"});
			lektion7.add(new String[]{"sehr","totemo","とても","adjektiv"});
			lektion7.add(new String[]{"da sein, stattfinden, es gibt","arimasu(5)","あります(5)","verb"});
			lektion7.add(new String[]{"kommen","kimasu(unr.)","きます(unr.)","verb"});
			lektion7.add(new String[]{"ja(weicher als >>hai<<)","ee","ええ","adjektiv"});
			lektion7.add(new String[]{"aber","demo","でも","adjektiv"});
		vocab.add(lektion7);

		ArrayList<String[]> lektion8 = new ArrayList<String[]>();
			lektion8.add(new String[]{"Hut, Mütze","boushi","ぼうし","nomen"});
			lektion8.add(new String[]{"Farbe","iro","いろ","nomen"});
			lektion8.add(new String[]{"Größe","saizu","さいず","nomen"});
			lektion8.add(new String[]{"Gast, Kunde","o-kyaku","お-きゃく","nomen"});
			lektion8.add(new String[]{"gut(wenn man etwas gut kann)","umai","うまい","adjektiv"});
			lektion8.add(new String[]{"preiswert, billig","yasui","やすい","adjektiv"});
			lektion8.add(new String[]{"niedlich, süß","kawaii","かわいい","adjektiv"});
			lektion8.add(new String[]{"groß","ookii","おおきい","adjektiv"});
			lektion8.add(new String[]{"klein","chiisai","ちいさい","adjektiv"});
			lektion8.add(new String[]{"gut","ii","いい","adjektiv"});
			lektion8.add(new String[]{"schlecht","warui","わるい","adjektiv"});
			lektion8.add(new String[]{"interessant","omoshiroi","おもしろい","adjektiv"});
			lektion8.add(new String[]{"schwierig","muzukashii","むずかしい","adjektiv"});
			lektion8.add(new String[]{"wie","ikaga","いかが","adjektiv"});
			lektion8.add(new String[]{"was für ein","donna","どんな","adjektiv"});
			lektion8.add(new String[]{"nein/ aber nicht doch","iya/iya iya","いや/いや いや","adjektiv"});
			lektion8.add(new String[]{"Studium, Lernen","benkyou","べんきょう","nomen"});
			lektion8.add(new String[]{"Schüler","seito","せいと","nomen"});
		vocab.add(lektion8);

		ArrayList<String[]> lektion9 = new ArrayList<String[]>();
			lektion9.add(new String[]{"Guten Abend!","konban wa","こんばん わ","nomen"});
			lektion9.add(new String[]{"warum","doushite","どうして","adjektiv"});
			lektion9.add(new String[]{"Restaurant","resutoran","れすとらん","nomen"});
			lektion9.add(new String[]{"Speisekarte","menyû","めんゆ~","nomen"});
			lektion9.add(new String[]{"Fleisch","(o-)niku","(お-)にく","nomen"});
			lektion9.add(new String[]{"Fleischgericht","niku-ryouri","にく-りょうり","nomen"});
			lektion9.add(new String[]{"Hühnerfleisch","toriniku","とりにく","nomen"});
			lektion9.add(new String[]{"Rindfleisch","gyuuniku","ぎゅうにく","nomen"});
			lektion9.add(new String[]{"Gesicht","kao","かお","nomen"});
			lektion9.add(new String[]{"Gesichtsfarbe, Aussehen","kao-iro","かお-いろ","nomen"});
			lektion9.add(new String[]{"Wetter","tenki","てんき","nomen"});
			lektion9.add(new String[]{"Sommer","natsu","なつ","nomen"});
			lektion9.add(new String[]{"lecker, wohlschmeckend","oishii","おいしい","adjektiv"});
			lektion9.add(new String[]{"nicht gut schmeckend","mazui","まずい","adjektiv"});
			lektion9.add(new String[]{"(viel) beschäftigt","isogashii","いそがしい","adjektiv"});
			lektion9.add(new String[]{"heiß","atsui","あつい","adjektiv"});
			lektion9.add(new String[]{"angenehm kühl","suzushii","すずしい","adjektiv"});
			lektion9.add(new String[]{"unangenehm kühl","samui","さむい","adjektiv"});
			lektion9.add(new String[]{"kalt(bei Berührung)","tsumetai","つめたい","nomen"});
		vocab.add(lektion9);

		ArrayList<String[]> lektion10 = new ArrayList<String[]>();
			lektion10.add(new String[]{"Reise","ryokou","りょこう","nomen"});
			lektion10.add(new String[]{"Regen","ame","あめ","nomen"});
			lektion10.add(new String[]{"zahlreich, viel","ooi","おおい","adjektiv"});
			lektion10.add(new String[]{"neu","atarashii","あたらしい","adjektiv"});
			lektion10.add(new String[]{"kurz","mijikai","みじかい","adjektiv"});
			lektion10.add(new String[]{"alt(Dinge)","furui","ふるい","nomen"});
			lektion10.add(new String[]{"langweilig, uninteressant","tsumaranai","つまらない","adjektiv"});
			lektion10.add(new String[]{"lang","nagai","ながい","adjektiv"});
			lektion10.add(new String[]{"amüsant, schön, toll","tanoshii","たのしい","adjektiv"});
			lektion10.add(new String[]{"wie","dou","どう","adjektiv"});
			lektion10.add(new String[]{"es ist schade","zannen desu/deshita","ざんねん です/でした","adjektiv"});
		vocab.add(lektion10);

		ArrayList<String[]> lektion11 = new ArrayList<String[]>();
			lektion11.add(new String[]{"jetzt, gerade","ima","いま","adjektiv"});
			lektion11.add(new String[]{"jetzt gleich","ima kara","いま から","adjektiv"});
			lektion11.add(new String[]{"Haus, Zuhause, Wohnung","uchi","うち","nomen"});
			lektion11.add(new String[]{"Zimmer","heya","へや","nomen"});
			lektion11.add(new String[]{"wo","doko(ni,de)","どこ(に,で)","adjektiv"});
			lektion11.add(new String[]{"sich aufhalten","imasu(1)","います(1)","verb"});
			lektion11.add(new String[]{"Hochschule, Universität","daigaku","だいがく","nomen"});
			lektion11.add(new String[]{"Kantine, Mensa, Esszimmer","shokudou","しょくどう","nomen"});
			lektion11.add(new String[]{"Café","kissaten","きっさてん","nomen"});
			lektion11.add(new String[]{"Park","kouen","こうえん","nomen"});
			lektion11.add(new String[]{"jeden Tag","mainichi","まいにち","nomen"});
			lektion11.add(new String[]{"Meer","umi","うみ","nomen"});
			lektion11.add(new String[]{"Schwimmbad, Pool","pûru","ぷ~る","nomen"});
			lektion11.add(new String[]{"schwimmer","oyogimasu(5)","およぎます(5)","verb"});
			lektion11.add(new String[]{"(ab)schneiden, trennen, (Telefon) unterbrechen","kirimasu","きります","nomen"});
			lektion11.add(new String[]{"Telefon","denwa","でんわ","nomen"});
			lektion11.add(new String[]{"telefonieren","denwa (o) shimasu","でんわ (お) します","adjektiv"});
		vocab.add(lektion11);

		ArrayList<String[]> lektion12 = new ArrayList<String[]>();
			lektion12.add(new String[]{"Bus","basu","ばす","nomen"});
			lektion12.add(new String[]{"Zug","densha","電車","nomen"});
			lektion12.add(new String[]{"Fahrrad","jitensha","じてん車","nomen"});
			lektion12.add(new String[]{"Name","namae","なまえ","nomen"});
			lektion12.add(new String[]{"Ort","tokoro","ところ","nomen"});
			lektion12.add(new String[]{"Haus (= uchi)","ie","いえ","nomen"});
			lektion12.add(new String[]{"Famillie","kazoku","かぞく","nomen"});
			lektion12.add(new String[]{"Geschwister","kyoudai","きょうだい","nomen"});
			lektion12.add(new String[]{"ich (Männersprache)","boku","ぼく","nomen"});
			lektion12.add(new String[]{"zusammen, gemeinsam","issho ni","いっしょ に","adjektiv"});
			lektion12.add(new String[]{"weit entfernt, fern","tooi","とおい","adjektiv"});
			lektion12.add(new String[]{"gehen, fahren, ...","ikimasu(5)","行きます(5)","verb"});
			lektion12.add(new String[]{"Essstäbchen","o-hashi","お-はし","nomen"});
			lektion12.add(new String[]{"wohnen","sunde imasu","すんで います","adjektiv"});
			lektion12.add(new String[]{"Hand","te","て","nomen"});
		vocab.add(lektion12);

		ArrayList<String[]> lektion13 = new ArrayList<String[]>();
			lektion13.add(new String[]{"Mann","otoko no hito","男の人","nomen"});
			lektion13.add(new String[]{"Frau","onna no hito","女の人","nomen"});
			lektion13.add(new String[]{"Mädchen","onna no ko","女のこ","nomen"});
			lektion13.add(new String[]{"sie (weiblich, Singular)","kanojo","かのじょ","nomen"});
			lektion13.add(new String[]{"Ortschaft Stadt","machi","まち","nomen"});
			lektion13.add(new String[]{"Gebäude","tatemono","たてもの","nomen"});
			lektion13.add(new String[]{"schön","kirei","きれい","adjektiv"});
			lektion13.add(new String[]{"Nummer","bangou","ばんごう","nomen"});
			lektion13.add(new String[]{"welche Nummer","nan-ban","なん-ばん","nomen"});
			lektion13.add(new String[]{"Handy","keitai (denwa)","けいたい (電話)","nomen"});
			lektion13.add(new String[]{"schon","mou","もう","adjektiv"});
			lektion13.add(new String[]{"noch (nicht)","mada","まだ","adjektiv"});
			lektion13.add(new String[]{"kennen lernen","shiriaimasu(5)","しりあいます(5)","verb"});
			lektion13.add(new String[]{"sagen","iimasu(5)","いいます(5)","verb"});
		vocab.add(lektion13);

		ArrayList<String[]> lektion14 = new ArrayList<String[]>();
			lektion14.add(new String[]{"Handy-Mail","keitai-mêru","けいたい-め~る","nomen"});
			lektion14.add(new String[]{"Vorlesung","kougi","こうぎ","nomen"});
			lektion14.add(new String[]{"Bibliothek","tosho-kan","としょ-かん","nomen"});
			lektion14.add(new String[]{"Supermarkt","sûpâ","す~ぱ~","nomen"});
			lektion14.add(new String[]{"Teller","o-sara","お-さら","nomen"});
			lektion14.add(new String[]{"selbst, eigenständig","jibun de","じぶん で","adjektiv"});
			lektion14.add(new String[]{"aufstehen (vom Bett)","okiru(1)","おきる(1)","nomen"});
			lektion14.add(new String[]{"duschen","shawâ o abiru(1)","しゃわ~ お あびる(1)","verb"});
			lektion14.add(new String[]{"(Kleidung) anziehen","kiru(1)","きる(1)","nomen"});
			lektion14.add(new String[]{"hinausgehen, verlassen","(...o) deru(1)","(...お) でる(1)","verb"});
			lektion14.add(new String[]{"waschen, spülen","arau(5)","あらう(5)","verb"});
			lektion14.add(new String[]{"(nach Hause) zurückkehren","kaeru(5)","かえる(5)","nomen"});
			lektion14.add(new String[]{"sich hinlegen, schlafen","neru(1)","ねる(1)","verb"});
			lektion14.add(new String[]{"Kino","eiga-kan","えいが-かん","nomen"});
			lektion14.add(new String[]{"Ticket, (Fahr/Eintritts) Karte","kippu","きっぷ","nomen"});
			lektion14.add(new String[]{"sterben","shinu(5)","しぬ(5)","verb"});
		vocab.add(lektion14);

		ArrayList<String[]> lektion15 = new ArrayList<String[]>();
			lektion15.add(new String[]{"Kunstmuseum","bijutsu-kan","びじゅつ-かん","nomen"});
			lektion15.add(new String[]{"Schloss","o-shiro","お-しろ","nomen"});
			lektion15.add(new String[]{"Nähe","chikaku","ちかく","nomen"});
			lektion15.add(new String[]{"nahe","chikai","ちかい","adjektiv"});
			lektion15.add(new String[]{"Eingang","iriguchi","いりぐち","nomen"});
			lektion15.add(new String[]{"Garten","niwa","にわ","nomen"});
			lektion15.add(new String[]{"in Ordnung, okay","daijoubu","だいじょうぶ","nomen"});
			lektion15.add(new String[]{"ein bisschen (=chotto)","sukoshi","すこし","adjektiv"});
			lektion15.add(new String[]{"wirklich, tatsächlich","hontou ni","本とう に","adjektiv"});
			lektion15.add(new String[]{"Bushaltestelle","basu-tei","ばす-てい","nomen"});
			lektion15.add(new String[]{"alle","mina/minna","みな/みんな","adjektiv"});
			lektion15.add(new String[]{"zu Fuß gehen","aruku(5)","あるく(5)","nomen"});
			lektion15.add(new String[]{"einsteigen, aufsteigen; fahren","noru(5)","のる(5)","verb"});
			lektion15.add(new String[]{"aussteigen, absteigen","oriru(1)","おりる(1)","verb"});
		vocab.add(lektion15);

		ArrayList<String[]> lektion16 = new ArrayList<String[]>();
			lektion16.add(new String[]{"Kirschbaum, Kirschblüte, ...","sakura","さくら","nomen"});
			lektion16.add(new String[]{"Blume, Blüte","hana","花","nomen"});
			lektion16.add(new String[]{"Kirschblüte","sakura no hana","さくら の 花","nomen"});
			lektion16.add(new String[]{"(öffentliches) Fest","(o-)matsuri","(お-)まつり","nomen"});
			lektion16.add(new String[]{"Werbung","koukoku","こうこく","nomen"});
			lektion16.add(new String[]{"Japan-Verein","Nihonjin-kai","日本人会","nomen"});
			lektion16.add(new String[]{"Sushiröllchen","maki-zushi","まき-ずし","nomen"});
			lektion16.add(new String[]{"Reis mit Beilagen in einer kleinen Box","o-bentou","お-べんとう","nomen"});
			lektion16.add(new String[]{"Sitzplatz","seki","せき","nomen"});
			lektion16.add(new String[]{"(her)zeigen","miseru(1)","見せる(1)","verb"});
			lektion16.add(new String[]{"bestellen; beauftragen; erbitten","tanomu(5)","たのむ(5)","verb"});
			lektion16.add(new String[]{"(be)zahlen","harau(5)","はらう(5)","verb"});
			lektion16.add(new String[]{"nehmen; hier: besetzen","toru(5)","とる(5)","verb"});
			lektion16.add(new String[]{"Bahnhof","eki","えき","nomen"});
		vocab.add(lektion16);

		ArrayList<String[]> lektion17 = new ArrayList<String[]>();
			lektion17.add(new String[]{"Spaziergang","sanpo","さんぽ","nomen"});
			lektion17.add(new String[]{"spazieren gehen","sanpo suru / sanpo ni iku","さんぽ する / さんぽ に いく","verb"});
			lektion17.add(new String[]{"Spaß, Freude","tanoshimi","たのしみ","nomen"});
			lektion17.add(new String[]{">>Ich freue mich darauf.<<","tanoshimi desu","たのしみ です","nomen"});
			lektion17.add(new String[]{"in Ruhe, langsam","yukkuri","ゆっくり","nomen"});
			lektion17.add(new String[]{"Berg(e)","yama","やま","nomen"});
			lektion17.add(new String[]{"Fluss","kawa","かわ","nomen"});
			lektion17.add(new String[]{"sich anziehen","fuku o kiru(1)","ふく お きる(1)","verb"});
			lektion17.add(new String[]{"Bank (zum Sitzen)","benchi","べんち","nomen"});
			lektion17.add(new String[]{"es regnet","ame ga furu(5)","あめ が ふる(5)","verb"});
			lektion17.add(new String[]{"ankommen, eintreffen","tsuku(5)","つく(5)","verb"});
			lektion17.add(new String[]{"sich setzen, sitzen","suwaru(5)","すわる(5)","verb"});
			lektion17.add(new String[]{"steigen, klettern","noboru(5)","のぼる(5)","verb"});
			lektion17.add(new String[]{"vergessen","wasureru(1)","わすれる(1)","verb"});
			lektion17.add(new String[]{"Bahnhofs-vorplatz","ekimae","えきまえ","nomen"});
			lektion17.add(new String[]{"mitnehmen","motte iku","もって 行","adjektiv"});
			lektion17.add(new String[]{"mitbringen","motte kuru","もって くる","adjektiv"});
		vocab.add(lektion17);

		ArrayList<String[]> lektion18 = new ArrayList<String[]>();
			lektion18.add(new String[]{">>Liebe Anwesende<<, >>Verehrte Damen und Herren<< (höfliche Anrede für mehrere Personen)","mina-san","みな-さん","nomen"});
			lektion18.add(new String[]{"Vormittag(s), a.m.","gozen","ごぜん","nomen"});
			lektion18.add(new String[]{"Nachmittag(s), p.m.","gogo","ごご","nomen"});
			lektion18.add(new String[]{"(Schul)Tafel","kokuban","こくばん","nomen"});
			lektion18.add(new String[]{"nebenan","tonari","となり","adjektiv"});
			lektion18.add(new String[]{"Nachbar; Nebensitzer","tonari no hito","となり の 人","nomen"});
			lektion18.add(new String[]{"Hälfte, halb","hanbun","はん分","nomen"});
			lektion18.add(new String[]{"Unterricht","jugyou","じゅぎょう","nomen"});
			lektion18.add(new String[]{"Hausaufgaben","shukudai","しゅくだい","nomen"});
			lektion18.add(new String[]{"Pause, Urlaub, Ferien","yasumi","休み","nomen"});
			lektion18.add(new String[]{"streng","kibishii","きびしい","adjektiv"});
			lektion18.add(new String[]{"aufpassen, achtgeben","ki o tsukeru(1)","気おつける(1)","verb"});
			lektion18.add(new String[]{"antworten","kotaeru(1)","こたえる(1)","verb"});
			lektion18.add(new String[]{"in Zukunft","kore kara","これ から","nomen"});
			lektion18.add(new String[]{"Eiscreme","aisukurimu","あいすくりむ","nomen"});
			lektion18.add(new String[]{"Geschenk","purezento","ぷれぜんと","nomen"});
		vocab.add(lektion18);

		ArrayList<String[]> lektion19 = new ArrayList<String[]>();
			lektion19.add(new String[]{"oder","ka","か","adjektiv"});
			lektion19.add(new String[]{"Gefühl","kimochi","気もち","nomen"});
			lektion19.add(new String[]{"sich gut anfühlen, angenehm","kimochi ga ii","気もち が いい","adjektiv"});
			lektion19.add(new String[]{"komisch, seltsam","okashii","おかしい","adjektiv"});
			lektion19.add(new String[]{"Prüfung","shiken","しけん","nomen"});
			lektion19.add(new String[]{"Vokabel","tango","たん語","nomen"});
			lektion19.add(new String[]{"Grammatik","bunpou","ぶんぽう","nomen"});
			lektion19.add(new String[]{"alles(bei Dingen)","zenbu","ぜんぶ","nomen"});
			lektion19.add(new String[]{"dauern; kosten","kakaru(5)","かかる(5)","verb"});
			lektion19.add(new String[]{"sich etw. merken","oboeru(1)","おぼえる(1)","verb"});
			lektion19.add(new String[]{"Frühling","haru","はる","nomen"});
			lektion19.add(new String[]{"Sorge","shinpai","しんぱい","nomen"});
			lektion19.add(new String[]{"sich Sorgen machen","shinpai suru","しんぱい する","verb"});
			lektion19.add(new String[]{"sich anstrengen/bemühen","ganbaru(5)","がんばる(5)","verb"});
		vocab.add(lektion19);

		ArrayList<String[]> lektion20 = new ArrayList<String[]>();
			lektion20.add(new String[]{"letzte Woche","senshuu","先しゅう","nomen"});
			lektion20.add(new String[]{"alles Mögliche, Diverses","iroiro","いろいろ","nomen"});
			lektion20.add(new String[]{"Job, Nebenjob, Teilzeitarbeit","(aru)baito","(ある)ばいと","nomen"});
			lektion20.add(new String[]{"Waschmaschine","sentaku ki","せんたく き","nomen"});
			lektion20.add(new String[]{"Kind","kodomo","こども","nomen"});
			lektion20.add(new String[]{"(etw.) beginnen, anfangen","hajimeru(1)","はじめる(1)","verb"});
			lektion20.add(new String[]{"sich unterhalten","hanashi o suru","話おする","verb"});
			lektion20.add(new String[]{"früher","mukashi","むかし","adjektiv"});
			lektion20.add(new String[]{"stark","tsuyoi","つよい","adjektiv"});
			lektion20.add(new String[]{"Wind","kaze","かぜ","nomen"});
			lektion20.add(new String[]{"wehen; blasen","fuku(5)","ふく(5)","verb"});
			lektion20.add(new String[]{"Lehrbuch, Schulbuch","kyoukasho","きょうかしょ","nomen"});
			lektion20.add(new String[]{"Geschichte (Historie)","rekishi","れきし","nomen"});
			lektion20.add(new String[]{"Kneipe","izaka-ya","いざか-や","nomen"});
			lektion20.add(new String[]{"Sport","supôtsu","すぽ~つ","nomen"});
		vocab.add(lektion20);

		ArrayList<String[]> lektion21 = new ArrayList<String[]>();
			lektion21.add(new String[]{"Schule","gakkou","学こう","nomen"});
			lektion21.add(new String[]{"Semester, Trimester, ...","gakki","学き","nomen"});
			lektion21.add(new String[]{"Klasse","kurasu","くらす","nomen"});
			lektion21.add(new String[]{"wenig, nicht zahlreich","sukunai","少ない","adjektiv"});
			lektion21.add(new String[]{"letztes/voriges Jahr","kyonen","きょねん","nomen"});
			lektion21.add(new String[]{"nächstes Jahr","rainen","来ねん","nomen"});
			lektion21.add(new String[]{"beginnen","hajimaru(5)","はじまる(5)","verb"});
			lektion21.add(new String[]{"(etw.) aufhören, aufgeben, unterlassen","yameru(1)","やめる(1)","verb"});
			lektion21.add(new String[]{"Eltern, Elternteil","oya","おや","nomen"});
			lektion21.add(new String[]{"reisen, bereisen","ryokou (o) suru","りょこう (お) する","verb"});
			lektion21.add(new String[]{"Bild","e","え","nomen"});
			lektion21.add(new String[]{"werden","naru(5)","なる(5)","verb"});
			lektion21.add(new String[]{"geboren werden","umareru(1)","生まれる(1)","verb"});
			lektion21.add(new String[]{"Traum","yume","ゆめ","nomen"});
		vocab.add(lektion21);

		ArrayList<String[]> lektion22 = new ArrayList<String[]>();
			lektion22.add(new String[]{"Ding, Gegenstand","mono","もの","nomen"});
			lektion22.add(new String[]{"Kuchen","kêki","け~き","nomen"});
			lektion22.add(new String[]{"Smartphone","sumâtofon (Abk.: sumaho)","すま~とほん (あbk.: すまほ)","nomen"});
			lektion22.add(new String[]{"Download / herunterladen","daunrôdo (suru)","だうんろ~ど (する)","nomen"});
			lektion22.add(new String[]{"(mein) Opa","jii-chan","じい-ちゃん","nomen"});
			lektion22.add(new String[]{"Musikstück, Song","kyoku","きょく","nomen"});
			lektion22.add(new String[]{">>pops<<, Popmusik","poppusu","ぽっぷす","nomen"});
			lektion22.add(new String[]{"(Musik-)Band","bando","ばんど","nomen"});
			lektion22.add(new String[]{"Gruppe","gurûpu","ぐる~ぷ","nomen"});
			lektion22.add(new String[]{"Liedtext, Lyrics","kashi","かし","nomen"});
			lektion22.add(new String[]{"Nummer 1, am meisten","ichiban","いちばん","nomen"});
			lektion22.add(new String[]{"praktisch","benri (na)","べんり (な)","adjektiv"});
			lektion22.add(new String[]{"alles mögliche, diverse","iroiro (na)","いろいろ (な)","adjektiv"});
			lektion22.add(new String[]{"gesund, munter, aufgeweckt","genki (na)","げん気(な)","adjektiv"});
			lektion22.add(new String[]{"ruhig, leise","shizuka (na)","しずか (な)","adjektiv"});
			lektion22.add(new String[]{"sehr gemocht","dai-suki (na)","大すき (な)","adjektiv"});
			lektion22.add(new String[]{"bekannt, berühmt","yuumei (na)","ゆうめい (な)","adjektiv"});
			lektion22.add(new String[]{"wechseln, sich ändern","kawaru(5)","かわる(5)","verb"});
			lektion22.add(new String[]{"wie teuer","ikura","いくら","adjektiv"});
			lektion22.add(new String[]{"Euro","Yûro","ゆ~ろ","nomen"});
		vocab.add(lektion22);

		ArrayList<String[]> lektion23 = new ArrayList<String[]>();
			lektion23.add(new String[]{"Bazar (Verwendung wie im Deutschen)","bazâ","ばざ~","nomen"});
			lektion23.add(new String[]{"(Ton-/Video-) Kassette","têpu","て~ぷ","nomen"});
			lektion23.add(new String[]{"langsam, in Ruhe (=yukkuri)","yukkuri to","ゆっくり と","adjektiv"});
			lektion23.add(new String[]{"brauchen","iru(5)","いる(5)","verb"});
			lektion23.add(new String[]{"verkaufen","uru(5)","うる(5)","verb"});
			lektion23.add(new String[]{"Ware","shoushin","しょうしん","nomen"});
			lektion23.add(new String[]{"Yen","en","えん","nomen"});
			lektion23.add(new String[]{"Spielzeug","omocha","おもちゃ","nomen"});
			lektion23.add(new String[]{"(hier:) kosten","suru","する","verb"});
			lektion23.add(new String[]{"Sojasoße","shouyu","しょうゆ","nomen"});
			lektion23.add(new String[]{"Reiscracker","senbei","せんべい","nomen"});
			lektion23.add(new String[]{"Packung, Verpackung","pakkêji","ぱっけ~じ","nomen"});
			lektion23.add(new String[]{"billig, preiswert","yasui","安い","adjektiv"});
			lektion23.add(new String[]{"hoch; teuer","takai","高い","adjektiv"});
			lektion23.add(new String[]{"Apfel","ringo","りんご","nomen"});
			lektion23.add(new String[]{"Gramm","guramu","ぐらむ","nomen"});
		vocab.add(lektion23);

		ArrayList<String[]> lektion24 = new ArrayList<String[]>();
			lektion24.add(new String[]{"Weihnachten","kurisumasu","くりすます","nomen"});
			lektion24.add(new String[]{"Zeit, Saison","jiki","時き","nomen"});
			lektion24.add(new String[]{"Kaufhaus (department Store)","depâto","でぱ~と","nomen"});
			lektion24.add(new String[]{"Laden, Geschäft","(o-)mise","店","nomen"});
			lektion24.add(new String[]{"Rock","sukâto","すか~と","nomen"});
			lektion24.add(new String[]{"Brief","tegami","てがみ","nomen"});
			lektion24.add(new String[]{"dieses Jahr","kotoshi","ことし","nomen"});
			lektion24.add(new String[]{"in letzter Zeit, neuerdings","saikin","さいきん","nomen"});
			lektion24.add(new String[]{"welche(r/s)","dore","どれ","adjektiv"});
			lektion24.add(new String[]{"welche(r/s) ...","dono ...","どの ...","adjektiv"});
			lektion24.add(new String[]{"aber","kedo (= keredomo)","けど (= けれども)","adjektiv"});
			lektion24.add(new String[]{"glücklich; erfreulich","ureshii","うれしい","adjektiv"});
			lektion24.add(new String[]{"übrigens","tokoro de","ところ で","adjektiv"});
			lektion24.add(new String[]{"geben, schenken","ageru(1), kureru(1)","あげる(1), くれる(1)","verb"});
			lektion24.add(new String[]{"bekommen","morau(5)","もらう(5)","verb"});
			lektion24.add(new String[]{"sich für ... entscheiden, ... nehmen","... ni suru","... に する","verb"});
			lektion24.add(new String[]{"jdm. etw. zahlen, jdn. zu etw. einladen","ogoru(5)","おごる(5)","verb"});
			lektion24.add(new String[]{"Weiß / weiß","shiro / shiroi","しろ / しろい","nomen"});
			lektion24.add(new String[]{"Schwarz / schwarz","kuro / kuroi","くろ / くろい","nomen"});
			lektion24.add(new String[]{"Rot / rot","aka / akai","あか / あかい","nomen"});
			lektion24.add(new String[]{"Blau / blau","ao / aoi","あお / あおい","nomen"});
		vocab.add(lektion24);

		ArrayList<String[]> lektion25 = new ArrayList<String[]>();
			lektion25.add(new String[]{"Sache (abstrakt)","koto","こと","nomen"});
			lektion25.add(new String[]{"Auslandsstudent","ryuugakusei","りゅう学生","nomen"});
			lektion25.add(new String[]{"im Ausland studieren","ryuugaku suru","りゅう学する","nomen"});
			lektion25.add(new String[]{"vormitags","gozenchuu","午ぜん中","adjektiv"});
			lektion25.add(new String[]{"nur","dake","だけ","adjektiv"});
			lektion25.add(new String[]{"wann","itsu","いつ","adjektiv"});
			lektion25.add(new String[]{"Kurzzeit-Auslandsstudium","tanki-ryuugaku","たんき-りゅう学","nomen"});
			lektion25.add(new String[]{"Wohnheim","ryou","りょう","nomen"});
			lektion25.add(new String[]{"natürlich, selbstverständlich","mochiron","もちろん","adjektiv"});
			lektion25.add(new String[]{"bald, sofort","sugu","すぐ","adjektiv"});
			lektion25.add(new String[]{"(noch) mehr","motto","もっと","adjektiv"});
			lektion25.add(new String[]{"unbedingt, auf jeden Fall","zehi","ぜひ","nomen"});
			lektion25.add(new String[]{"Freiheit; frei","jiyuu","じゆう","nomen"});
			lektion25.add(new String[]{"Sightseeing","kankou","かんこう","nomen"});
			lektion25.add(new String[]{"Geburtstag","(o-) tanjou-bi","(お-) たん生日","nomen"});
			lektion25.add(new String[]{"Homestay, Aufenthalt in Gastfamillie","hômu-sutei","ほ~む-すてい","nomen"});
			lektion25.add(new String[]{"können","dekiru(1)","できる(1)","verb"});
			lektion25.add(new String[]{"wissen, kennen, erfahren","shiru(5)","しる(5)","verb"});
			lektion25.add(new String[]{"übernachten, kurzzeitig wohnen","tomaru(5)","とまる(5)","verb"});
			lektion25.add(new String[]{"sich anmelden","moushi-komu(5)","もうし-こむ(5)","verb"});
		vocab.add(lektion25);

		ArrayList<String[]> lektion26 = new ArrayList<String[]>();
		vocab.add(lektion26);

		ArrayList<String[]> lektion27 = new ArrayList<String[]>();
		vocab.add(lektion27);

		ArrayList<String[]> lektion28 = new ArrayList<String[]>();
		vocab.add(lektion28);

		ArrayList<String[]> lektion29 = new ArrayList<String[]>();
		vocab.add(lektion29);

		ArrayList<String[]> lektion30 = new ArrayList<String[]>();
		vocab.add(lektion30);

		ArrayList<String[]> lektion31 = new ArrayList<String[]>();
		vocab.add(lektion31);

		ArrayList<String[]> lektion32 = new ArrayList<String[]>();
		vocab.add(lektion32);

		ArrayList<String[]> lektion33 = new ArrayList<String[]>();
		vocab.add(lektion33);

		ArrayList<String[]> lektion34 = new ArrayList<String[]>();
		vocab.add(lektion34);

		ArrayList<String[]> lektion35 = new ArrayList<String[]>();
		vocab.add(lektion35);

		ArrayList<String[]> lektion36 = new ArrayList<String[]>();
		vocab.add(lektion36);

		ArrayList<String[]> lektion37 = new ArrayList<String[]>();
		vocab.add(lektion37);

		ArrayList<String[]> lektion38 = new ArrayList<String[]>();
		vocab.add(lektion38);

		ArrayList<String[]> lektion39 = new ArrayList<String[]>();
		vocab.add(lektion39);

		ArrayList<String[]> lektion40 = new ArrayList<String[]>();
		vocab.add(lektion40);

		ArrayList<String[]> lektion41 = new ArrayList<String[]>();
		vocab.add(lektion41);

		ArrayList<String[]> lektion42 = new ArrayList<String[]>();
		vocab.add(lektion42);

		ArrayList<String[]> lektion43 = new ArrayList<String[]>();
		vocab.add(lektion43);

		ArrayList<String[]> lektion44 = new ArrayList<String[]>();
		vocab.add(lektion44);

		ArrayList<String[]> lektion45 = new ArrayList<String[]>();
		vocab.add(lektion45);

		ArrayList<String[]> lektion46 = new ArrayList<String[]>();
		vocab.add(lektion46);

		ArrayList<String[]> lektion47 = new ArrayList<String[]>();
		vocab.add(lektion47);

		ArrayList<String[]> lektion48 = new ArrayList<String[]>();
		vocab.add(lektion48);

		ArrayList<String[]> lektion49 = new ArrayList<String[]>();
		vocab.add(lektion49);

		ArrayList<String[]> lektion50 = new ArrayList<String[]>();
		vocab.add(lektion50);
	}
	
	private void initializeVocabAsKanji(){
				ArrayList<String[]> lektion11 = new ArrayList<String[]>();
			lektion11.add(new String[]{"日","Sonne; Tag","hi","NICHI, JITSU"});
			lektion11.add(new String[]{"本","Ursprung; Buch","moto","HON"});
			lektion11.add(new String[]{"人","Person, Mensch","hito","JIN, NIN"});
			vocab.add(lektion11);

			ArrayList<String[]> lektion12 = new ArrayList<String[]>();
			lektion12.add(new String[]{"行","gehen, fahren","i(kimasu)","KOU, GYOU"});
			lektion12.add(new String[]{"電","Elektrizität","--","DEN"});
			lektion12.add(new String[]{"車","Rad, Wagen, Auto","kurama","SHA"});
			vocab.add(lektion12);

			ArrayList<String[]> lektion13 = new ArrayList<String[]>();
			lektion13.add(new String[]{"女","Frau","onna","JO"});
			lektion13.add(new String[]{"男","Mann","otoko","DAN"});
			lektion13.add(new String[]{"話","sprechen; Gespräch","hana(shimasu); hanashi","WA"});
			vocab.add(lektion13);

			ArrayList<String[]> lektion14 = new ArrayList<String[]>();
			lektion14.add(new String[]{"会","sich treffen, sich versammeln","a(u)","KAI"});
			lektion14.add(new String[]{"休","sich ausruhen","yasu(mu)","KYUU"});
			lektion14.add(new String[]{"見","sehen, ansehen","mi(ru)","KEN"});
			vocab.add(lektion14);

			ArrayList<String[]> lektion15 = new ArrayList<String[]>();
			lektion15.add(new String[]{"天","Himmel (oft im übertragenen Sinn)","--","TEN"});
			lektion15.add(new String[]{"気","Geist, Seele, Energie","--","KI"});
			lektion15.add(new String[]{"町","Ortschaft, Stadt","machi","CHOU"});
			vocab.add(lektion15);

			ArrayList<String[]> lektion16 = new ArrayList<String[]>();
			lektion16.add(new String[]{"大","groß","oo(kii)","DAI, TAI"});
			lektion16.add(new String[]{"学","lernen","mana(bu)","GAKU"});
			lektion16.add(new String[]{"花","Blume, Blüte","hana","KA"});
			vocab.add(lektion16);

			ArrayList<String[]> lektion17 = new ArrayList<String[]>();
			lektion17.add(new String[]{"今","jetzt","ima","KON"});
			lektion17.add(new String[]{"時","Zeit; ... Uhr","toki","JI"});
			lektion17.add(new String[]{"分","teilen; verstehen; Teil; Minute","wa(keru), wa(karu)","BUN, FUN (PUN)"});
			vocab.add(lektion17);

			ArrayList<String[]> lektion18 = new ArrayList<String[]>();
			lektion18.add(new String[]{"先","Spitze; zuvor","saki","SEN"});
			lektion18.add(new String[]{"生","gebären; geboren werden; leben","u(mu), u(mareru)","SEI, SHOU"});
			lektion18.add(new String[]{"食","essen","ta(beru)","SHOKU"});
			vocab.add(lektion18);

			ArrayList<String[]> lektion19 = new ArrayList<String[]>();
			lektion19.add(new String[]{"語","Sprache; Wort; erzählen","--","GO"});
			lektion19.add(new String[]{"雨","Regen","ame","U"});
			lektion19.add(new String[]{"来","kommen","ku(ru)","RAI"});
			vocab.add(lektion19);

			ArrayList<String[]> lektion20 = new ArrayList<String[]>();
			lektion20.add(new String[]{"火","Feuer","hi","KA"});
			lektion20.add(new String[]{"水","Wasser","mizu","SUI"});
			lektion20.add(new String[]{"木","Baum; Holz","ki","MOKU, BOKU"});
			vocab.add(lektion20);

			ArrayList<String[]> lektion21 = new ArrayList<String[]>();
			lektion21.add(new String[]{"小","klein","chii(sai)","SHOU"});
			lektion21.add(new String[]{"少","wenig","suku(nai), soku(shi)","SHOU"});
			lektion21.add(new String[]{"多","viel, zahlreich","oo(i)","TA"});
			vocab.add(lektion21);

			ArrayList<String[]> lektion22 = new ArrayList<String[]>();
			lektion22.add(new String[]{"古","alt","furu(i)","KO"});
			lektion22.add(new String[]{"何","was","nani, nan","KA"});
			lektion22.add(new String[]{"聞","hören, fragen","ki(ku)","BUN"});
			vocab.add(lektion22);

			ArrayList<String[]> lektion23 = new ArrayList<String[]>();
			lektion23.add(new String[]{"安","billig; (sicher)","yasu(i)","AN"});
			lektion23.add(new String[]{"高","hoch; teuer","taka(i)","KOU"});
			lektion23.add(new String[]{"買","kaufen","ka(u)","BAI"});
			vocab.add(lektion23);

			ArrayList<String[]> lektion24 = new ArrayList<String[]>();
			lektion24.add(new String[]{"子","Kind","ko","SHI"});
			lektion24.add(new String[]{"白","weiß","shiro(i)","HAKU"});
			lektion24.add(new String[]{"店","Laden, Geschäft","mise","TEN"});
			vocab.add(lektion24);

			ArrayList<String[]> lektion25 = new ArrayList<String[]>();
			lektion25.add(new String[]{"月","Mond, Monat","tsuki","GATSU, GETSU"});
			lektion25.add(new String[]{"午","12 Uhr mittags","--","GO"});
			lektion25.add(new String[]{"中","Mitte, innen","naka","CHUU"});
			vocab.add(lektion25);

			ArrayList<String[]> lektion26 = new ArrayList<String[]>();
			vocab.add(lektion26);

			ArrayList<String[]> lektion27 = new ArrayList<String[]>();
			vocab.add(lektion27);

			ArrayList<String[]> lektion28 = new ArrayList<String[]>();
			vocab.add(lektion28);

			ArrayList<String[]> lektion29 = new ArrayList<String[]>();
			vocab.add(lektion29);

			ArrayList<String[]> lektion30 = new ArrayList<String[]>();
			vocab.add(lektion30);

			ArrayList<String[]> lektion31 = new ArrayList<String[]>();
			vocab.add(lektion31);

			ArrayList<String[]> lektion32 = new ArrayList<String[]>();
			vocab.add(lektion32);

			ArrayList<String[]> lektion33 = new ArrayList<String[]>();
			vocab.add(lektion33);

			ArrayList<String[]> lektion34 = new ArrayList<String[]>();
			vocab.add(lektion34);

			ArrayList<String[]> lektion35 = new ArrayList<String[]>();
			vocab.add(lektion35);

			ArrayList<String[]> lektion36 = new ArrayList<String[]>();
			vocab.add(lektion36);

			ArrayList<String[]> lektion37 = new ArrayList<String[]>();
			vocab.add(lektion37);

			ArrayList<String[]> lektion38 = new ArrayList<String[]>();
			vocab.add(lektion38);

			ArrayList<String[]> lektion39 = new ArrayList<String[]>();
			vocab.add(lektion39);

			ArrayList<String[]> lektion40 = new ArrayList<String[]>();
			vocab.add(lektion40);

			ArrayList<String[]> lektion41 = new ArrayList<String[]>();
			vocab.add(lektion41);

			ArrayList<String[]> lektion42 = new ArrayList<String[]>();
			vocab.add(lektion42);

			ArrayList<String[]> lektion43 = new ArrayList<String[]>();
			vocab.add(lektion43);

			ArrayList<String[]> lektion44 = new ArrayList<String[]>();
			vocab.add(lektion44);

			ArrayList<String[]> lektion45 = new ArrayList<String[]>();
			vocab.add(lektion45);

			ArrayList<String[]> lektion46 = new ArrayList<String[]>();
			vocab.add(lektion46);

			ArrayList<String[]> lektion47 = new ArrayList<String[]>();
			vocab.add(lektion47);

			ArrayList<String[]> lektion48 = new ArrayList<String[]>();
			vocab.add(lektion48);

			ArrayList<String[]> lektion49 = new ArrayList<String[]>();
			vocab.add(lektion49);

			ArrayList<String[]> lektion50 = new ArrayList<String[]>();
			vocab.add(lektion50);

	}
	
	public String[][] getVocabList(boolean[] selection){
		ArrayList<String[]> list = new ArrayList<String[]>();
		for(int i =0; i<vocab.size(); i++){
			if(selection[i]){
				for(int j=0; j< vocab.get(i).size(); j++){
					list.add(vocab.get(i).get(j));
				}
			}
		}
		Object[] obHelp = list.toArray();
		String[][] returnList = new String[obHelp.length][((String[])obHelp[0]).length];
		for(int i = 0; i < obHelp.length; i++){
			returnList[i] = (String[])obHelp[i];
		}
		android.util.Log.d("Error","no error");
		return returnList;
	}
	
	private String[][] getWordTypeList(String type){
		type = type.toLowerCase();
		ArrayList<String[]> list = new ArrayList<String[]>();
		for(int i =0; i<50; i++){
			int length = vocab.get(i).size();
			for(int j =0; j<length; j++){
				if(vocab.get(i).get(j)[3].equals(type)){
					list.add(vocab.get(i).get(j));
				}
			}
		}
		Object[] obHelp = list.toArray();
		String[][] returnList = new String[obHelp.length][((String[])obHelp[0]).length];
		for(int i = 0; i < obHelp.length; i++){
			returnList[i] = (String[])obHelp[i];
		}
		return returnList;
	}
	
	public String[] getRandomKanji(){
		Random r = new Random();
		int rInt = r.nextInt(currentVocab.length);
		return currentVocab[rInt];
	}
	
	public String[] getRandomWord(String type){
		Random r = new Random();
		String[][] words;
		if(type.equals("verb"))
			words = verbs;
		else if(type.equals("nomen"))
			words = nouns;
		else 
			words = adjectives;
		int rInt = r.nextInt(words.length);
		return words[rInt];
	}
	
	public String[][] getQuestionAnswerSet(int size){
		String[][] returnString = new String[size][vocab.get(0).get(0).length];
		Random r = new Random();
		int vocabIndex = r.nextInt(currentVocab.length);
		returnString[0] = currentVocab[vocabIndex];
		
		for(int i=1; i<returnString.length; i++){
			returnString[i] = getRandomWord(returnString[0][3]);
		}
		//filter out doubles and get random words
		for(int i=1; i<returnString.length; i++){
			boolean isDouble = false;
			if(i == returnString.length-1){
				returnString[i] = getRandomWord(returnString[0][3]);
				break;
			}
			for(int j =0; j <returnString.length-1; j++){
				if(j==i) j++;
				else{
					if(returnString[i].equals(returnString[j])) 
						isDouble = true;
				}
			}
			if(isDouble){
				returnString[i] = getRandomWord(returnString[0][3]);
				i--;
			}
		}
		return returnString;
	}
	
	public String[][] getQuestionAnswerSetKanji(int size){
		String[][] returnString = new String[size][vocab.get(0).get(0).length];
		Random r = new Random();
		int vocabIndex = r.nextInt(currentVocab.length);
		returnString[0] = currentVocab[vocabIndex];
		
		for(int i=1; i<returnString.length; i++){
			returnString[i] = getRandomKanji();
		}
		//filter out doubles and get random words
		for(int i=1; i<returnString.length; i++){
			boolean isDouble = false;
			if(i == returnString.length-1){
				returnString[i] = getRandomKanji();
				break;
			}
			for(int j =0; j <returnString.length-1; j++){
				if(j==i) j++;
				else{
					if(returnString[i].equals(returnString[j])) 
						isDouble = true;
				}
			}
			if(isDouble){
				returnString[i] = getRandomKanji();
				i--;
			}
		}
		return returnString;
	}
	
	public String[] getVocabByIndex(int index){
		if(index>=currentVocab.length){
			index = currentVocab.length-1;
		}
		return currentVocab[index];
	}
	
	public int getRandomIndex(){
		return new Random().nextInt(currentVocab.length);
	}
}
