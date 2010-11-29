// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g 2010-04-20 20:59:46

  package edlcode;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EdlCodeParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEBUT_GRAS", "FIN_GRAS", "DEBUT_ITALIQUE", "FIN_ITALIQUE", "DEBUT_SOULIGNE", "FIN_SOULIGNE", "DEBUT_BARRE", "FIN_BARRE", "DEBUT_CLIGNOTE", "FIN_CLIGNOTE", "DEBUT_GAUCHE", "FIN_GAUCHE", "DEBUT_DROITE", "FIN_DROITE", "DEBUT_CENTRE", "FIN_CENTRE", "DEBUT_JUSTIFIE", "FIN_JUSTIFIE", "DEBUT_TABLEAU", "FIN_TABLEAU", "DEBUT_LIGNE", "FIN_LIGNE", "DEBUT_CELLULE", "FIN_CELLULE", "SMILEY", "IMAGE", "IMAGE_SITE", "FERMETURE_AVEC_PARAMETRE", "FERMETURE_PARAMETRE", "LARGEUR", "HAUTEUR", "SUITE_CARACTERE_QUELQUONQUE", "'[police=\"'", "'[/police]'", "'[taille=\"'", "'[/taille]'", "'[couleur=\"'", "'[/couleur]'", "'[fond=\"'", "'[/fond]'", "'[lien=\"'", "'[/lien]'", "'[titre='", "']'", "'[/titre]'"
    };
    public static final int FIN_CENTRE=19;
    public static final int IMAGE_SITE=30;
    public static final int DEBUT_TABLEAU=22;
    public static final int FERMETURE_PARAMETRE=32;
    public static final int EOF=-1;
    public static final int FIN_CELLULE=27;
    public static final int DEBUT_SOULIGNE=8;
    public static final int DEBUT_BARRE=10;
    public static final int IMAGE=29;
    public static final int FIN_TABLEAU=23;
    public static final int DEBUT_CLIGNOTE=12;
    public static final int DEBUT_CELLULE=26;
    public static final int DEBUT_GRAS=4;
    public static final int FIN_CLIGNOTE=13;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int DEBUT_LIGNE=24;
    public static final int T__48=48;
    public static final int FIN_SOULIGNE=9;
    public static final int SUITE_CARACTERE_QUELQUONQUE=35;
    public static final int FIN_GRAS=5;
    public static final int DEBUT_JUSTIFIE=20;
    public static final int FIN_DROITE=17;
    public static final int FIN_GAUCHE=15;
    public static final int DEBUT_CENTRE=18;
    public static final int DEBUT_ITALIQUE=6;
    public static final int DEBUT_GAUCHE=14;
    public static final int FERMETURE_AVEC_PARAMETRE=31;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int SMILEY=28;
    public static final int T__39=39;
    public static final int FIN_ITALIQUE=7;
    public static final int LARGEUR=33;
    public static final int DEBUT_DROITE=16;
    public static final int FIN_BARRE=11;
    public static final int FIN_LIGNE=25;
    public static final int HAUTEUR=34;
    public static final int FIN_JUSTIFIE=21;

    // delegates
    // delegators


        public EdlCodeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EdlCodeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return EdlCodeParser.tokenNames; }
    public String getGrammarFileName() { return "/home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g"; }



    // $ANTLR start "prog"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:65:1: prog returns [String retour =\"\"] : (p= phrase )* ;
    public final String prog() throws RecognitionException {
        String retour = "";

        String p = null;


        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:65:34: ( (p= phrase )* )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:66:7: (p= phrase )*
            {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:66:7: (p= phrase )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEBUT_GRAS||LA1_0==DEBUT_ITALIQUE||LA1_0==DEBUT_SOULIGNE||LA1_0==DEBUT_BARRE||LA1_0==DEBUT_CLIGNOTE||LA1_0==DEBUT_GAUCHE||LA1_0==DEBUT_DROITE||LA1_0==DEBUT_CENTRE||LA1_0==DEBUT_JUSTIFIE||LA1_0==DEBUT_TABLEAU||(LA1_0>=SMILEY && LA1_0<=IMAGE_SITE)||(LA1_0>=SUITE_CARACTERE_QUELQUONQUE && LA1_0<=36)||LA1_0==38||LA1_0==40||LA1_0==42||LA1_0==44||LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:66:8: p= phrase
            	    {
            	    pushFollow(FOLLOW_phrase_in_prog337);
            	    p=phrase();

            	    state._fsp--;


            	              retour+=p;
            	            

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "prog"


    // $ANTLR start "phrase"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:72:2: phrase returns [String retour] : ( DEBUT_GRAS p= prog FIN_GRAS | DEBUT_ITALIQUE p= prog FIN_ITALIQUE | DEBUT_SOULIGNE p= prog FIN_SOULIGNE | DEBUT_BARRE p= prog FIN_BARRE | DEBUT_CLIGNOTE p= prog FIN_CLIGNOTE | DEBUT_GAUCHE p= prog FIN_GAUCHE | DEBUT_DROITE p= prog FIN_DROITE | DEBUT_CENTRE p= prog FIN_CENTRE | DEBUT_JUSTIFIE p= prog FIN_JUSTIFIE | '[police=\"' policeString= police FERMETURE_AVEC_PARAMETRE p= prog '[/police]' | '[taille=\"' tailleString= taillePolice FERMETURE_AVEC_PARAMETRE p= prog '[/taille]' | '[couleur=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/couleur]' | '[fond=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/fond]' | '[lien=\"' urlString= url FERMETURE_AVEC_PARAMETRE p= prog '[/lien]' | SMILEY cheminString= chemin FERMETURE_AVEC_PARAMETRE | IMAGE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | IMAGE_SITE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | DEBUT_TABLEAU ( SUITE_CARACTERE_QUELQUONQUE )? (l= ligneTableau )* FIN_TABLEAU | '[titre=' intTitre= typetitre ']' p= prog '[/titre]' | SUITE_CARACTERE_QUELQUONQUE );
    public final String phrase() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE1=null;
        String p = null;

        String policeString = null;

        String tailleString = null;

        String couleurString = null;

        String urlString = null;

        String cheminString = null;

        String hauteur = null;

        String largeur = null;

        String l = null;

        String intTitre = null;


        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:72:33: ( DEBUT_GRAS p= prog FIN_GRAS | DEBUT_ITALIQUE p= prog FIN_ITALIQUE | DEBUT_SOULIGNE p= prog FIN_SOULIGNE | DEBUT_BARRE p= prog FIN_BARRE | DEBUT_CLIGNOTE p= prog FIN_CLIGNOTE | DEBUT_GAUCHE p= prog FIN_GAUCHE | DEBUT_DROITE p= prog FIN_DROITE | DEBUT_CENTRE p= prog FIN_CENTRE | DEBUT_JUSTIFIE p= prog FIN_JUSTIFIE | '[police=\"' policeString= police FERMETURE_AVEC_PARAMETRE p= prog '[/police]' | '[taille=\"' tailleString= taillePolice FERMETURE_AVEC_PARAMETRE p= prog '[/taille]' | '[couleur=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/couleur]' | '[fond=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/fond]' | '[lien=\"' urlString= url FERMETURE_AVEC_PARAMETRE p= prog '[/lien]' | SMILEY cheminString= chemin FERMETURE_AVEC_PARAMETRE | IMAGE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | IMAGE_SITE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | DEBUT_TABLEAU ( SUITE_CARACTERE_QUELQUONQUE )? (l= ligneTableau )* FIN_TABLEAU | '[titre=' intTitre= typetitre ']' p= prog '[/titre]' | SUITE_CARACTERE_QUELQUONQUE )
            int alt8=20;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:73:7: DEBUT_GRAS p= prog FIN_GRAS
                    {
                    match(input,DEBUT_GRAS,FOLLOW_DEBUT_GRAS_in_phrase382); 
                    pushFollow(FOLLOW_prog_in_phrase388);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_GRAS,FOLLOW_FIN_GRAS_in_phrase390); 

                           
                              retour = "<span class=\"edlCode_gras\">"+p+"</span>";
                            

                    }
                    break;
                case 2 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:80:7: DEBUT_ITALIQUE p= prog FIN_ITALIQUE
                    {
                    match(input,DEBUT_ITALIQUE,FOLLOW_DEBUT_ITALIQUE_in_phrase423); 
                    pushFollow(FOLLOW_prog_in_phrase429);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_ITALIQUE,FOLLOW_FIN_ITALIQUE_in_phrase431); 

                              retour = "<span class=\"edlCode_italique\">"+p+"</span>";
                            

                    }
                    break;
                case 3 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:86:7: DEBUT_SOULIGNE p= prog FIN_SOULIGNE
                    {
                    match(input,DEBUT_SOULIGNE,FOLLOW_DEBUT_SOULIGNE_in_phrase464); 
                    pushFollow(FOLLOW_prog_in_phrase470);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_SOULIGNE,FOLLOW_FIN_SOULIGNE_in_phrase472); 

                               retour = "<span class=\"edlCode_souligne\">"+p+"</span>";
                            

                    }
                    break;
                case 4 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:92:7: DEBUT_BARRE p= prog FIN_BARRE
                    {
                    match(input,DEBUT_BARRE,FOLLOW_DEBUT_BARRE_in_phrase505); 
                    pushFollow(FOLLOW_prog_in_phrase511);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_BARRE,FOLLOW_FIN_BARRE_in_phrase513); 

                              retour = "<span class=\"edlCode_barre\">"+p+"</span>";
                            

                    }
                    break;
                case 5 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:97:7: DEBUT_CLIGNOTE p= prog FIN_CLIGNOTE
                    {
                    match(input,DEBUT_CLIGNOTE,FOLLOW_DEBUT_CLIGNOTE_in_phrase540); 
                    pushFollow(FOLLOW_prog_in_phrase546);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_CLIGNOTE,FOLLOW_FIN_CLIGNOTE_in_phrase548); 

                              retour = "<span class=\"edlCode_clignote\">"+p+"</span>";
                            

                    }
                    break;
                case 6 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:102:7: DEBUT_GAUCHE p= prog FIN_GAUCHE
                    {
                    match(input,DEBUT_GAUCHE,FOLLOW_DEBUT_GAUCHE_in_phrase574); 
                    pushFollow(FOLLOW_prog_in_phrase580);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_GAUCHE,FOLLOW_FIN_GAUCHE_in_phrase582); 

                              retour = "<div class=\"edlCode_gauche\">"+p+"</div>";
                            

                    }
                    break;
                case 7 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:107:7: DEBUT_DROITE p= prog FIN_DROITE
                    {
                    match(input,DEBUT_DROITE,FOLLOW_DEBUT_DROITE_in_phrase607); 
                    pushFollow(FOLLOW_prog_in_phrase613);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_DROITE,FOLLOW_FIN_DROITE_in_phrase615); 

                              retour = "<div class=\"edlCode_droite\">"+p+"</div>";
                            

                    }
                    break;
                case 8 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:114:8: DEBUT_CENTRE p= prog FIN_CENTRE
                    {
                    match(input,DEBUT_CENTRE,FOLLOW_DEBUT_CENTRE_in_phrase655); 
                    pushFollow(FOLLOW_prog_in_phrase661);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_CENTRE,FOLLOW_FIN_CENTRE_in_phrase663); 

                              retour = "<div class=\"edlCode_centre\">"+p+"</div>";
                            

                    }
                    break;
                case 9 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:121:8: DEBUT_JUSTIFIE p= prog FIN_JUSTIFIE
                    {
                    match(input,DEBUT_JUSTIFIE,FOLLOW_DEBUT_JUSTIFIE_in_phrase708); 
                    pushFollow(FOLLOW_prog_in_phrase714);
                    p=prog();

                    state._fsp--;

                    match(input,FIN_JUSTIFIE,FOLLOW_FIN_JUSTIFIE_in_phrase716); 

                               retour = "<div class=\"edlCode_justifie\">"+p+"</div>";
                            

                    }
                    break;
                case 10 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:128:7: '[police=\"' policeString= police FERMETURE_AVEC_PARAMETRE p= prog '[/police]'
                    {
                    match(input,36,FOLLOW_36_in_phrase755); 
                    pushFollow(FOLLOW_police_in_phrase758);
                    policeString=police();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase760); 
                    pushFollow(FOLLOW_prog_in_phrase766);
                    p=prog();

                    state._fsp--;

                    match(input,37,FOLLOW_37_in_phrase768); 

                              retour = "<span style='font-family:\""+policeString+"\" ; ' >"+p+"</span>";
                            

                    }
                    break;
                case 11 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:134:7: '[taille=\"' tailleString= taillePolice FERMETURE_AVEC_PARAMETRE p= prog '[/taille]'
                    {
                    match(input,38,FOLLOW_38_in_phrase801); 
                    pushFollow(FOLLOW_taillePolice_in_phrase805);
                    tailleString=taillePolice();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase807); 
                    pushFollow(FOLLOW_prog_in_phrase813);
                    p=prog();

                    state._fsp--;

                    match(input,39,FOLLOW_39_in_phrase815); 

                               retour = "<span style='font-size:"+tailleString+" ; ' >"+p+"</span>";
                            

                    }
                    break;
                case 12 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:139:7: '[couleur=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/couleur]'
                    {
                    match(input,40,FOLLOW_40_in_phrase841); 
                    pushFollow(FOLLOW_couleur_in_phrase845);
                    couleurString=couleur();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase847); 
                    pushFollow(FOLLOW_prog_in_phrase853);
                    p=prog();

                    state._fsp--;

                    match(input,41,FOLLOW_41_in_phrase855); 

                             retour = "<span style='color: "+couleurString+" ; ' >"+p+"</span>";
                            

                    }
                    break;
                case 13 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:144:7: '[fond=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/fond]'
                    {
                    match(input,42,FOLLOW_42_in_phrase881); 
                    pushFollow(FOLLOW_couleur_in_phrase885);
                    couleurString=couleur();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase887); 
                    pushFollow(FOLLOW_prog_in_phrase893);
                    p=prog();

                    state._fsp--;

                    match(input,43,FOLLOW_43_in_phrase895); 

                              retour = "<span style='background-color: "+couleurString+" ; ' >"+p+"</span>";
                            

                    }
                    break;
                case 14 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:152:8: '[lien=\"' urlString= url FERMETURE_AVEC_PARAMETRE p= prog '[/lien]'
                    {
                    match(input,44,FOLLOW_44_in_phrase943); 
                    pushFollow(FOLLOW_url_in_phrase947);
                    urlString=url();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase949); 
                    pushFollow(FOLLOW_prog_in_phrase955);
                    p=prog();

                    state._fsp--;

                    match(input,45,FOLLOW_45_in_phrase957); 

                              retour = "<a href=\""+urlString+"\">"+p+"</a>";
                            

                    }
                    break;
                case 15 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:159:7: SMILEY cheminString= chemin FERMETURE_AVEC_PARAMETRE
                    {
                    match(input,SMILEY,FOLLOW_SMILEY_in_phrase1004); 
                    pushFollow(FOLLOW_chemin_in_phrase1009);
                    cheminString=chemin();

                    state._fsp--;

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1011); 

                              retour = "<img src=\""+cheminString+"\" alt=\""+cheminString+"\"";
                             //if(largeur != null){
                             //   retour += "width=\""+largeur+"\"";
                             //  }
                              retour += " />";
                           
                            

                    }
                    break;
                case 16 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:171:6: IMAGE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE
                    {
                    match(input,IMAGE,FOLLOW_IMAGE_in_phrase1050); 
                    pushFollow(FOLLOW_chemin_in_phrase1055);
                    cheminString=chemin();

                    state._fsp--;

                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:171:33: ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==HAUTEUR) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:171:34: HAUTEUR hauteur= dimention FERMETURE_PARAMETRE
                            {
                            match(input,HAUTEUR,FOLLOW_HAUTEUR_in_phrase1058); 
                            pushFollow(FOLLOW_dimention_in_phrase1064);
                            hauteur=dimention();

                            state._fsp--;

                            match(input,FERMETURE_PARAMETRE,FOLLOW_FERMETURE_PARAMETRE_in_phrase1066); 

                            }
                            break;

                    }

                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:171:84: ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==LARGEUR) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:171:85: LARGEUR largeur= dimention FERMETURE_PARAMETRE
                            {
                            match(input,LARGEUR,FOLLOW_LARGEUR_in_phrase1071); 
                            pushFollow(FOLLOW_dimention_in_phrase1077);
                            largeur=dimention();

                            state._fsp--;

                            match(input,FERMETURE_PARAMETRE,FOLLOW_FERMETURE_PARAMETRE_in_phrase1079); 

                            }
                            break;

                    }

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1083); 

                              retour = "<img src=\""+cheminString+"\" alt=\""+cheminString+"\"";
                              if(hauteur != null){
                                retour += " height=\""+hauteur+"\"";
                              }
                             if(largeur != null){
                                retour += " width=\""+largeur+"\"";
                              }
                              
                              
                              retour += " />";
                         
                         
                         
                           

                    }
                    break;
                case 17 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:188:7: IMAGE_SITE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE
                    {
                    match(input,IMAGE_SITE,FOLLOW_IMAGE_SITE_in_phrase1111); 
                    pushFollow(FOLLOW_chemin_in_phrase1116);
                    cheminString=chemin();

                    state._fsp--;

                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:188:39: ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==HAUTEUR) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:188:40: HAUTEUR hauteur= dimention FERMETURE_PARAMETRE
                            {
                            match(input,HAUTEUR,FOLLOW_HAUTEUR_in_phrase1119); 
                            pushFollow(FOLLOW_dimention_in_phrase1125);
                            hauteur=dimention();

                            state._fsp--;

                            match(input,FERMETURE_PARAMETRE,FOLLOW_FERMETURE_PARAMETRE_in_phrase1127); 

                            }
                            break;

                    }

                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:188:90: ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==LARGEUR) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:188:91: LARGEUR largeur= dimention FERMETURE_PARAMETRE
                            {
                            match(input,LARGEUR,FOLLOW_LARGEUR_in_phrase1132); 
                            pushFollow(FOLLOW_dimention_in_phrase1138);
                            largeur=dimention();

                            state._fsp--;

                            match(input,FERMETURE_PARAMETRE,FOLLOW_FERMETURE_PARAMETRE_in_phrase1140); 

                            }
                            break;

                    }

                    match(input,FERMETURE_AVEC_PARAMETRE,FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1144); 

                              retour = "<img src=\"${ctx}/images/albumPhoto/"+cheminString+"\" alt=\"image "+cheminString+" inexistante \"";
                               if(hauteur != null){
                                retour += " height=\""+hauteur+"\"";
                              }
                             if(largeur != null){
                                retour += " width=\""+largeur+"\"";
                              }
                              retour += " />";
                            

                    }
                    break;
                case 18 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:202:7: DEBUT_TABLEAU ( SUITE_CARACTERE_QUELQUONQUE )? (l= ligneTableau )* FIN_TABLEAU
                    {
                    match(input,DEBUT_TABLEAU,FOLLOW_DEBUT_TABLEAU_in_phrase1188); 
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:202:21: ( SUITE_CARACTERE_QUELQUONQUE )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==SUITE_CARACTERE_QUELQUONQUE) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:202:21: SUITE_CARACTERE_QUELQUONQUE
                            {
                            match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_phrase1190); 

                            }
                            break;

                    }


                                retour ="<table class=\"edlCode_tableau\">";
                             
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:206:11: (l= ligneTableau )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==DEBUT_LIGNE) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:206:12: l= ligneTableau
                    	    {
                    	    pushFollow(FOLLOW_ligneTableau_in_phrase1218);
                    	    l=ligneTableau();

                    	    state._fsp--;


                    	                  retour+=l;
                    	                

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match(input,FIN_TABLEAU,FOLLOW_FIN_TABLEAU_in_phrase1256); 

                              retour += "</table>";
                            

                    }
                    break;
                case 19 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:217:7: '[titre=' intTitre= typetitre ']' p= prog '[/titre]'
                    {
                    match(input,46,FOLLOW_46_in_phrase1283); 
                    pushFollow(FOLLOW_typetitre_in_phrase1288);
                    intTitre=typetitre();

                    state._fsp--;

                    match(input,47,FOLLOW_47_in_phrase1289); 
                    pushFollow(FOLLOW_prog_in_phrase1294);
                    p=prog();

                    state._fsp--;

                    match(input,48,FOLLOW_48_in_phrase1296); 

                             retour = "<h"+intTitre+">"+p+"</h"+intTitre+">";
                            

                    }
                    break;
                case 20 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:224:7: SUITE_CARACTERE_QUELQUONQUE
                    {
                    SUITE_CARACTERE_QUELQUONQUE1=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_phrase1337); 

                              retour = (SUITE_CARACTERE_QUELQUONQUE1!=null?SUITE_CARACTERE_QUELQUONQUE1.getText():null);
                            

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "phrase"


    // $ANTLR start "ligneTableau"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:229:1: ligneTableau returns [String retour] : DEBUT_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )? (c= celluleTableau )* FIN_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )? ;
    public final String ligneTableau() throws RecognitionException {
        String retour = null;

        String c = null;


        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:229:38: ( DEBUT_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )? (c= celluleTableau )* FIN_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )? )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:230:7: DEBUT_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )? (c= celluleTableau )* FIN_LIGNE ( SUITE_CARACTERE_QUELQUONQUE )?
            {
            match(input,DEBUT_LIGNE,FOLLOW_DEBUT_LIGNE_in_ligneTableau1384); 
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:230:19: ( SUITE_CARACTERE_QUELQUONQUE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==SUITE_CARACTERE_QUELQUONQUE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:230:19: SUITE_CARACTERE_QUELQUONQUE
                    {
                    match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligneTableau1386); 

                    }
                    break;

            }


                         retour ="<tr>";
                     
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:234:11: (c= celluleTableau )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==DEBUT_CELLULE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:234:12: c= celluleTableau
            	    {
            	    pushFollow(FOLLOW_celluleTableau_in_ligneTableau1415);
            	    c=celluleTableau();

            	    state._fsp--;


            	                  retour+=c;
            	                

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,FIN_LIGNE,FOLLOW_FIN_LIGNE_in_ligneTableau1454); 
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:239:21: ( SUITE_CARACTERE_QUELQUONQUE )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==SUITE_CARACTERE_QUELQUONQUE) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:239:21: SUITE_CARACTERE_QUELQUONQUE
                    {
                    match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligneTableau1456); 

                    }
                    break;

            }


                      retour += "</tr>";
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "ligneTableau"


    // $ANTLR start "celluleTableau"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:245:1: celluleTableau returns [String retour] : DEBUT_CELLULE p= prog FIN_CELLULE ( SUITE_CARACTERE_QUELQUONQUE )? ;
    public final String celluleTableau() throws RecognitionException {
        String retour = null;

        String p = null;


        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:245:40: ( DEBUT_CELLULE p= prog FIN_CELLULE ( SUITE_CARACTERE_QUELQUONQUE )? )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:246:6: DEBUT_CELLULE p= prog FIN_CELLULE ( SUITE_CARACTERE_QUELQUONQUE )?
            {
            match(input,DEBUT_CELLULE,FOLLOW_DEBUT_CELLULE_in_celluleTableau1506); 
            pushFollow(FOLLOW_prog_in_celluleTableau1512);
            p=prog();

            state._fsp--;

            match(input,FIN_CELLULE,FOLLOW_FIN_CELLULE_in_celluleTableau1514); 
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:246:41: ( SUITE_CARACTERE_QUELQUONQUE )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==SUITE_CARACTERE_QUELQUONQUE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:246:41: SUITE_CARACTERE_QUELQUONQUE
                    {
                    match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_celluleTableau1516); 

                    }
                    break;

            }


                       retour = "<td>"+p+"</td>";
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "celluleTableau"


    // $ANTLR start "police"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:252:1: police returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String police() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE2=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:252:32: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:253:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE2=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_police1560); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE2!=null?SUITE_CARACTERE_QUELQUONQUE2.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "police"


    // $ANTLR start "taillePolice"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:259:1: taillePolice returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String taillePolice() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE3=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:259:38: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:260:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE3=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_taillePolice1600); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE3!=null?SUITE_CARACTERE_QUELQUONQUE3.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "taillePolice"


    // $ANTLR start "couleur"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:266:2: couleur returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String couleur() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE4=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:266:34: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:267:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE4=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_couleur1641); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE4!=null?SUITE_CARACTERE_QUELQUONQUE4.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "couleur"


    // $ANTLR start "url"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:274:1: url returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String url() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE5=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:274:29: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:275:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE5=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_url1687); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE5!=null?SUITE_CARACTERE_QUELQUONQUE5.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "url"


    // $ANTLR start "chemin"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:281:1: chemin returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String chemin() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE6=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:281:32: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:282:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE6=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_chemin1727); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE6!=null?SUITE_CARACTERE_QUELQUONQUE6.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "chemin"


    // $ANTLR start "typetitre"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:287:1: typetitre returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String typetitre() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE7=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:287:35: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:288:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE7=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_typetitre1760); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE7!=null?SUITE_CARACTERE_QUELQUONQUE7.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "typetitre"


    // $ANTLR start "ligne"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:294:2: ligne returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String ligne() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE8=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:294:32: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:295:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE8=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligne1801); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE8!=null?SUITE_CARACTERE_QUELQUONQUE8.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "ligne"


    // $ANTLR start "dimention"
    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:301:1: dimention returns [String retour] : SUITE_CARACTERE_QUELQUONQUE ;
    public final String dimention() throws RecognitionException {
        String retour = null;

        Token SUITE_CARACTERE_QUELQUONQUE9=null;

        try {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:301:35: ( SUITE_CARACTERE_QUELQUONQUE )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:302:7: SUITE_CARACTERE_QUELQUONQUE
            {
            SUITE_CARACTERE_QUELQUONQUE9=(Token)match(input,SUITE_CARACTERE_QUELQUONQUE,FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_dimention1841); 

                      retour = (SUITE_CARACTERE_QUELQUONQUE9!=null?SUITE_CARACTERE_QUELQUONQUE9.getText():null);
                   

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retour;
    }
    // $ANTLR end "dimention"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\25\uffff";
    static final String DFA8_eofS =
        "\25\uffff";
    static final String DFA8_minS =
        "\1\4\24\uffff";
    static final String DFA8_maxS =
        "\1\56\24\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24";
    static final String DFA8_specialS =
        "\25\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\uffff\1\2\1\uffff\1\3\1\uffff\1\4\1\uffff\1\5\1\uffff"+
            "\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\11\1\uffff\1\22\5\uffff"+
            "\1\17\1\20\1\21\4\uffff\1\24\1\12\1\uffff\1\13\1\uffff\1\14"+
            "\1\uffff\1\15\1\uffff\1\16\1\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "72:2: phrase returns [String retour] : ( DEBUT_GRAS p= prog FIN_GRAS | DEBUT_ITALIQUE p= prog FIN_ITALIQUE | DEBUT_SOULIGNE p= prog FIN_SOULIGNE | DEBUT_BARRE p= prog FIN_BARRE | DEBUT_CLIGNOTE p= prog FIN_CLIGNOTE | DEBUT_GAUCHE p= prog FIN_GAUCHE | DEBUT_DROITE p= prog FIN_DROITE | DEBUT_CENTRE p= prog FIN_CENTRE | DEBUT_JUSTIFIE p= prog FIN_JUSTIFIE | '[police=\"' policeString= police FERMETURE_AVEC_PARAMETRE p= prog '[/police]' | '[taille=\"' tailleString= taillePolice FERMETURE_AVEC_PARAMETRE p= prog '[/taille]' | '[couleur=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/couleur]' | '[fond=\"' couleurString= couleur FERMETURE_AVEC_PARAMETRE p= prog '[/fond]' | '[lien=\"' urlString= url FERMETURE_AVEC_PARAMETRE p= prog '[/lien]' | SMILEY cheminString= chemin FERMETURE_AVEC_PARAMETRE | IMAGE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | IMAGE_SITE cheminString= chemin ( HAUTEUR hauteur= dimention FERMETURE_PARAMETRE )? ( LARGEUR largeur= dimention FERMETURE_PARAMETRE )? FERMETURE_AVEC_PARAMETRE | DEBUT_TABLEAU ( SUITE_CARACTERE_QUELQUONQUE )? (l= ligneTableau )* FIN_TABLEAU | '[titre=' intTitre= typetitre ']' p= prog '[/titre]' | SUITE_CARACTERE_QUELQUONQUE );";
        }
    }
 

    public static final BitSet FOLLOW_phrase_in_prog337 = new BitSet(new long[]{0x0000555870555552L});
    public static final BitSet FOLLOW_DEBUT_GRAS_in_phrase382 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FIN_GRAS_in_phrase390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_ITALIQUE_in_phrase423 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase429 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FIN_ITALIQUE_in_phrase431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_SOULIGNE_in_phrase464 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase470 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FIN_SOULIGNE_in_phrase472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_BARRE_in_phrase505 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase511 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_FIN_BARRE_in_phrase513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_CLIGNOTE_in_phrase540 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase546 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_FIN_CLIGNOTE_in_phrase548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_GAUCHE_in_phrase574 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase580 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_FIN_GAUCHE_in_phrase582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_DROITE_in_phrase607 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase613 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_FIN_DROITE_in_phrase615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_CENTRE_in_phrase655 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase661 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_FIN_CENTRE_in_phrase663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_JUSTIFIE_in_phrase708 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase714 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_FIN_JUSTIFIE_in_phrase716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_phrase755 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_police_in_phrase758 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase760 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase766 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_phrase768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_phrase801 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_taillePolice_in_phrase805 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase807 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase813 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_phrase815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_phrase841 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_couleur_in_phrase845 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase847 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase853 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_phrase855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_phrase881 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_couleur_in_phrase885 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase887 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase893 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_phrase895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_phrase943 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_url_in_phrase947 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase949 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase955 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_phrase957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SMILEY_in_phrase1004 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_chemin_in_phrase1009 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMAGE_in_phrase1050 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_chemin_in_phrase1055 = new BitSet(new long[]{0x0000000680000000L});
    public static final BitSet FOLLOW_HAUTEUR_in_phrase1058 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dimention_in_phrase1064 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_FERMETURE_PARAMETRE_in_phrase1066 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_LARGEUR_in_phrase1071 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dimention_in_phrase1077 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_FERMETURE_PARAMETRE_in_phrase1079 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMAGE_SITE_in_phrase1111 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_chemin_in_phrase1116 = new BitSet(new long[]{0x0000000680000000L});
    public static final BitSet FOLLOW_HAUTEUR_in_phrase1119 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dimention_in_phrase1125 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_FERMETURE_PARAMETRE_in_phrase1127 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_LARGEUR_in_phrase1132 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dimention_in_phrase1138 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_FERMETURE_PARAMETRE_in_phrase1140 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_FERMETURE_AVEC_PARAMETRE_in_phrase1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_TABLEAU_in_phrase1188 = new BitSet(new long[]{0x0000000801800000L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_phrase1190 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_ligneTableau_in_phrase1218 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_FIN_TABLEAU_in_phrase1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_phrase1283 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_typetitre_in_phrase1288 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_phrase1289 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_phrase1294 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_phrase1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_phrase1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_LIGNE_in_ligneTableau1384 = new BitSet(new long[]{0x0000000806000000L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligneTableau1386 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_celluleTableau_in_ligneTableau1415 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_FIN_LIGNE_in_ligneTableau1454 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligneTableau1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUT_CELLULE_in_celluleTableau1506 = new BitSet(new long[]{0x0000555870555550L});
    public static final BitSet FOLLOW_prog_in_celluleTableau1512 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_FIN_CELLULE_in_celluleTableau1514 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_celluleTableau1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_police1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_taillePolice1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_couleur1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_url1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_chemin1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_typetitre1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_ligne1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUITE_CARACTERE_QUELQUONQUE_in_dimention1841 = new BitSet(new long[]{0x0000000000000002L});

}