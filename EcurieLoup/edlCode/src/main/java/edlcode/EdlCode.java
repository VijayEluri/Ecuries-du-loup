package edlcode;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import service.smiley.SmileyManager;

import com.lowagie.text.html.HtmlEncoder;

import donnees.smiley.Smiley;
import fr.ecuriesduloup.siteoptions.data.Option;
import fr.ecuriesduloup.siteoptions.service.OptionsService;

public class EdlCode {
	private List<RemplacementEntre> caracteres;
	private List<String> bigadinsWords;

	private SmileyManager smileyManager;
	private OptionsService optionsService;

	public EdlCode(){
		this.caracteres = new ArrayList<RemplacementEntre>();

		this.caracteres.add(new RemplacementEntre("&quot;", "\""));//

		this.caracteres.add(new RemplacementEntre("&#013;", ""));//

		this.caracteres.add(new RemplacementEntre("&#192;", "&Agrave;"));//Â
		this.caracteres.add(new RemplacementEntre("&#193;", "&Aacute;"));//A
		this.caracteres.add(new RemplacementEntre("&#194;", "&Acirc;"));//Â
		this.caracteres.add(new RemplacementEntre("&#195;", "&Atilde;"));//Â
		this.caracteres.add(new RemplacementEntre("&#196;", "&Auml;"));//Ä
		this.caracteres.add(new RemplacementEntre("&#197;", "&Aring;"));//Å
		this.caracteres.add(new RemplacementEntre("Æ", "&Aelig"));//Æ

		this.caracteres.add(new RemplacementEntre("&#199;", "&Ccedil;"));//Ç

		this.caracteres.add(new RemplacementEntre("&#200;", "&Egrave;"));//È
		this.caracteres.add(new RemplacementEntre("&#201;", "&Eacute;"));//É
		this.caracteres.add(new RemplacementEntre("&#202;", "&Ecirc;"));//Ê
		this.caracteres.add(new RemplacementEntre("&#203;", "&Euml;"));//Ë

		this.caracteres.add(new RemplacementEntre("&#204;", "&Igrave;"));//Ì
		this.caracteres.add(new RemplacementEntre("&#205;", "&Iacute;"));//Í
		this.caracteres.add(new RemplacementEntre("&#206;", "&Icirc;"));//Î
		this.caracteres.add(new RemplacementEntre("&#207;", "&Iuml;"));//Ï

		this.caracteres.add(new RemplacementEntre("&#208;", "&eth;"));//Ð

		this.caracteres.add(new RemplacementEntre("&#209;", "&Ntilde;"));//Ñ

		this.caracteres.add(new RemplacementEntre("&#210;", "&Ograve;"));//Ò
		this.caracteres.add(new RemplacementEntre("&#211;", "&Oacute;"));//Ó		
		this.caracteres.add(new RemplacementEntre("&#212;", "&Ocirc;"));//Ô
		this.caracteres.add(new RemplacementEntre("&#213;", "&Otilde;"));//Õ
		this.caracteres.add(new RemplacementEntre("&#214;", "&Ouml;"));//Ö

		this.caracteres.add(new RemplacementEntre("&#215;", "&times;"));//×

		this.caracteres.add(new RemplacementEntre("&#216;", "&Oslash;"));//Ø
		this.caracteres.add(new RemplacementEntre("&#217;", "&Ugrave;"));//Ù
		this.caracteres.add(new RemplacementEntre("&#218;", "&Uacute;"));//Ú		
		this.caracteres.add(new RemplacementEntre("&#219;", "&Ucirc;"));//Û
		this.caracteres.add(new RemplacementEntre("&#220;", "&Uuml;"));//Ü

		this.caracteres.add(new RemplacementEntre("&#221;", "&Yacute;"));//Ý

		this.caracteres.add(new RemplacementEntre("&#222;", "&thorn;"));//Þ
		this.caracteres.add(new RemplacementEntre("&#223;", "&szlig;"));//ß

		this.caracteres.add(new RemplacementEntre("&#223;", "&szlig;"));//ß

		this.caracteres.add(new RemplacementEntre("&#224;", "&agrave;"));//à
		this.caracteres.add(new RemplacementEntre("&#225;", "&aacute;"));//Á
		this.caracteres.add(new RemplacementEntre("&#226;", "&acirc;"));//â
		this.caracteres.add(new RemplacementEntre("&#227;", "&atilde;"));//Ã
		this.caracteres.add(new RemplacementEntre("&#228;", "&auml;"));//ä
		this.caracteres.add(new RemplacementEntre("&#228;", "&auml;"));//ä
		this.caracteres.add(new RemplacementEntre("&#229;", "&aring;"));//Å
		this.caracteres.add(new RemplacementEntre("&#230;", "&aelig;"));//Æ

		this.caracteres.add(new RemplacementEntre("&#231;", "&ccedil;"));//Ç

		this.caracteres.add(new RemplacementEntre("&#232;", "&egrave;"));//è
		this.caracteres.add(new RemplacementEntre("&#233;", "&eacute;"));//é
		this.caracteres.add(new RemplacementEntre("&#234;", "&ecirc;"));//ê
		this.caracteres.add(new RemplacementEntre("&#235;", "&euml;"));//ë	

		this.caracteres.add(new RemplacementEntre("&#236;", "&igrave;"));//Ì	
		this.caracteres.add(new RemplacementEntre("&#237;", "&iacute;"));//Í	
		this.caracteres.add(new RemplacementEntre("&#238;", "&icirc;"));//Î	
		this.caracteres.add(new RemplacementEntre("&#239;", "&iuml;"));//Ï

		this.caracteres.add(new RemplacementEntre("&#240;", "&eth;"));//Ð

		this.caracteres.add(new RemplacementEntre("&#241;", "&ntilde;"));//Ñ

		this.caracteres.add(new RemplacementEntre("&#242;", "&ograve;"));//Ò
		this.caracteres.add(new RemplacementEntre("&#243;", "&oacute;"));//Ó		
		this.caracteres.add(new RemplacementEntre("&#244;", "&ocirc;"));//Ô		
		this.caracteres.add(new RemplacementEntre("&#245;", "&otilde;"));//Õ		
		this.caracteres.add(new RemplacementEntre("&#246;", "&ouml;"));//ö	

		this.caracteres.add(new RemplacementEntre("&#247;", "&divide;"));//÷		

		this.caracteres.add(new RemplacementEntre("&#248;", "&oslash;"));//Ø

		this.caracteres.add(new RemplacementEntre("&#249;", "&ugrave;"));//Ù
		this.caracteres.add(new RemplacementEntre("&#250;", "&uacute;"));//Ú
		this.caracteres.add(new RemplacementEntre("&#251;", "&ucirc;"));//Û
		this.caracteres.add(new RemplacementEntre("&#252;", "&uuml;"));//Ü


		this.caracteres.add(new RemplacementEntre("&#253;", "&yacute;"));//Ý
		this.caracteres.add(new RemplacementEntre("&#254;", "&thorn;"));//Þ
		this.caracteres.add(new RemplacementEntre("&#255;", "&yuml;"));//Ÿ

		this.initBigadinWord();
	}

	private void initBigadinWord() {
		this.bigadinsWords = new ArrayList<String>();
		this.bigadinsWords.add("cheval");
		this.bigadinsWords.add("chevaux");

		this.bigadinsWords.add("poney");
		this.bigadinsWords.add("poneys");

		this.bigadinsWords.add("équidé");
		this.bigadinsWords.add("équidés");

	}

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}


	public void setOptionsService(OptionsService optionsService) {
		this.optionsService = optionsService;
	}

	public String parse(String texte, String pathServeur) throws EdlCodeEncodageException{
		texte = this.remplaceSmiley(texte, pathServeur);
		texte = this.replaceBigadin(texte);
		texte = HtmlEncoder.encode(texte);
		texte = this.remplaceCaractereHTML(texte);

		EdlCodeLexer lexer = new EdlCodeLexer(new ANTLRStringStream(texte));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		EdlCodeParser parser = new EdlCodeParser(tokens);
		String texteEncoder = "";
		try {
			texteEncoder = parser.prog();
			if(texteEncoder.equals("")&&(!texte.equals(""))){
				throw new EdlCodeEncodageException();
			}
		} catch (RecognitionException e) {
			throw new EdlCodeEncodageException();
		}
		texteEncoder = this.remplacePath(texteEncoder, pathServeur);
		return texteEncoder;


	}
	private String remplaceSmiley(String texte, String pathServeur){
		if(this.smileyManager != null){
			for(Smiley smiley : this.smileyManager.recupererTousLesSmiley()){
				String cheminImage= pathServeur+"/images/smiley/"+smiley.getId();
				cheminImage =cheminImage.replace("\\", "/");
				texte = texte.replace(smiley.getCode(),"[smiley=\""+cheminImage+"\"]");
			}
		}
		return texte;
	}

	private String replaceBigadin(String texte){
		if(this.optionsService != null){
			Option option = this.optionsService.get("bigadin");
			if(option  != null && option.getValue().equals("1")){
				for(String word : this.bigadinsWords){
					texte = texte.replaceAll(word, "bigadin");
				}
			}
		}
		return texte;
	}
	private String remplaceCaractereHTML(String texte){
		for(RemplacementEntre remplacement : this.caracteres){
			texte = texte.replace(remplacement.getARemplacer(), remplacement.getRemplacement());
		}
		return texte;
	}

	private String remplacePath(String texte, String pathServeur){
		return texte.replace("${ctx}", pathServeur);
	}
}
