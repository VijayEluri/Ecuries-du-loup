// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g 2010-04-20 20:59:46

  package edlcode;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EdlCodeLexer extends Lexer {
    public static final int FIN_CENTRE=19;
    public static final int IMAGE_SITE=30;
    public static final int DEBUT_TABLEAU=22;
    public static final int EOF=-1;
    public static final int FERMETURE_PARAMETRE=32;
    public static final int FIN_CELLULE=27;
    public static final int DEBUT_SOULIGNE=8;
    public static final int DEBUT_BARRE=10;
    public static final int IMAGE=29;
    public static final int FIN_TABLEAU=23;
    public static final int DEBUT_CELLULE=26;
    public static final int DEBUT_CLIGNOTE=12;
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
    public static final int FIN_LIGNE=25;
    public static final int FIN_BARRE=11;
    public static final int HAUTEUR=34;
    public static final int FIN_JUSTIFIE=21;

    // delegates
    // delegators

    public EdlCodeLexer() {;} 
    public EdlCodeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EdlCodeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g"; }

    // $ANTLR start "DEBUT_GRAS"
    public final void mDEBUT_GRAS() throws RecognitionException {
        try {
            int _type = DEBUT_GRAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:7:12: ( '[gras]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:7:14: '[gras]'
            {
            match("[gras]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_GRAS"

    // $ANTLR start "FIN_GRAS"
    public final void mFIN_GRAS() throws RecognitionException {
        try {
            int _type = FIN_GRAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:8:10: ( '[/gras]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:8:12: '[/gras]'
            {
            match("[/gras]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_GRAS"

    // $ANTLR start "DEBUT_ITALIQUE"
    public final void mDEBUT_ITALIQUE() throws RecognitionException {
        try {
            int _type = DEBUT_ITALIQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:9:16: ( '[italique]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:9:18: '[italique]'
            {
            match("[italique]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_ITALIQUE"

    // $ANTLR start "FIN_ITALIQUE"
    public final void mFIN_ITALIQUE() throws RecognitionException {
        try {
            int _type = FIN_ITALIQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:10:14: ( '[/italique]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:10:16: '[/italique]'
            {
            match("[/italique]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_ITALIQUE"

    // $ANTLR start "DEBUT_SOULIGNE"
    public final void mDEBUT_SOULIGNE() throws RecognitionException {
        try {
            int _type = DEBUT_SOULIGNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:11:16: ( '[souligne]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:11:18: '[souligne]'
            {
            match("[souligne]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_SOULIGNE"

    // $ANTLR start "FIN_SOULIGNE"
    public final void mFIN_SOULIGNE() throws RecognitionException {
        try {
            int _type = FIN_SOULIGNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:12:14: ( '[/souligne]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:12:16: '[/souligne]'
            {
            match("[/souligne]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_SOULIGNE"

    // $ANTLR start "DEBUT_BARRE"
    public final void mDEBUT_BARRE() throws RecognitionException {
        try {
            int _type = DEBUT_BARRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:13:13: ( '[barre]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:13:15: '[barre]'
            {
            match("[barre]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_BARRE"

    // $ANTLR start "FIN_BARRE"
    public final void mFIN_BARRE() throws RecognitionException {
        try {
            int _type = FIN_BARRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:14:11: ( '[/barre]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:14:13: '[/barre]'
            {
            match("[/barre]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_BARRE"

    // $ANTLR start "DEBUT_CLIGNOTE"
    public final void mDEBUT_CLIGNOTE() throws RecognitionException {
        try {
            int _type = DEBUT_CLIGNOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:15:16: ( '[clignote]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:15:18: '[clignote]'
            {
            match("[clignote]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_CLIGNOTE"

    // $ANTLR start "FIN_CLIGNOTE"
    public final void mFIN_CLIGNOTE() throws RecognitionException {
        try {
            int _type = FIN_CLIGNOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:16:14: ( '[/clignote]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:16:16: '[/clignote]'
            {
            match("[/clignote]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_CLIGNOTE"

    // $ANTLR start "DEBUT_GAUCHE"
    public final void mDEBUT_GAUCHE() throws RecognitionException {
        try {
            int _type = DEBUT_GAUCHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:17:14: ( '[gauche]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:17:16: '[gauche]'
            {
            match("[gauche]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_GAUCHE"

    // $ANTLR start "FIN_GAUCHE"
    public final void mFIN_GAUCHE() throws RecognitionException {
        try {
            int _type = FIN_GAUCHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:18:12: ( '[/gauche]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:18:14: '[/gauche]'
            {
            match("[/gauche]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_GAUCHE"

    // $ANTLR start "DEBUT_DROITE"
    public final void mDEBUT_DROITE() throws RecognitionException {
        try {
            int _type = DEBUT_DROITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:19:14: ( '[droite]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:19:16: '[droite]'
            {
            match("[droite]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_DROITE"

    // $ANTLR start "FIN_DROITE"
    public final void mFIN_DROITE() throws RecognitionException {
        try {
            int _type = FIN_DROITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:20:12: ( '[/droite]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:20:14: '[/droite]'
            {
            match("[/droite]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_DROITE"

    // $ANTLR start "DEBUT_CENTRE"
    public final void mDEBUT_CENTRE() throws RecognitionException {
        try {
            int _type = DEBUT_CENTRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:21:14: ( '[centre]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:21:16: '[centre]'
            {
            match("[centre]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_CENTRE"

    // $ANTLR start "FIN_CENTRE"
    public final void mFIN_CENTRE() throws RecognitionException {
        try {
            int _type = FIN_CENTRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:22:12: ( '[/centre]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:22:14: '[/centre]'
            {
            match("[/centre]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_CENTRE"

    // $ANTLR start "DEBUT_JUSTIFIE"
    public final void mDEBUT_JUSTIFIE() throws RecognitionException {
        try {
            int _type = DEBUT_JUSTIFIE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:23:16: ( '[justifie]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:23:18: '[justifie]'
            {
            match("[justifie]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_JUSTIFIE"

    // $ANTLR start "FIN_JUSTIFIE"
    public final void mFIN_JUSTIFIE() throws RecognitionException {
        try {
            int _type = FIN_JUSTIFIE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:24:14: ( '[/justifie]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:24:16: '[/justifie]'
            {
            match("[/justifie]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_JUSTIFIE"

    // $ANTLR start "DEBUT_TABLEAU"
    public final void mDEBUT_TABLEAU() throws RecognitionException {
        try {
            int _type = DEBUT_TABLEAU;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:25:15: ( '[tableau]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:25:17: '[tableau]'
            {
            match("[tableau]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_TABLEAU"

    // $ANTLR start "FIN_TABLEAU"
    public final void mFIN_TABLEAU() throws RecognitionException {
        try {
            int _type = FIN_TABLEAU;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:26:13: ( '[/tableau]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:26:15: '[/tableau]'
            {
            match("[/tableau]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_TABLEAU"

    // $ANTLR start "DEBUT_LIGNE"
    public final void mDEBUT_LIGNE() throws RecognitionException {
        try {
            int _type = DEBUT_LIGNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:27:13: ( '[ligne]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:27:15: '[ligne]'
            {
            match("[ligne]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_LIGNE"

    // $ANTLR start "FIN_LIGNE"
    public final void mFIN_LIGNE() throws RecognitionException {
        try {
            int _type = FIN_LIGNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:28:11: ( '[/ligne]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:28:13: '[/ligne]'
            {
            match("[/ligne]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_LIGNE"

    // $ANTLR start "DEBUT_CELLULE"
    public final void mDEBUT_CELLULE() throws RecognitionException {
        try {
            int _type = DEBUT_CELLULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:29:15: ( '[cellule]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:29:17: '[cellule]'
            {
            match("[cellule]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUT_CELLULE"

    // $ANTLR start "FIN_CELLULE"
    public final void mFIN_CELLULE() throws RecognitionException {
        try {
            int _type = FIN_CELLULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:30:13: ( '[/cellule]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:30:15: '[/cellule]'
            {
            match("[/cellule]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIN_CELLULE"

    // $ANTLR start "SMILEY"
    public final void mSMILEY() throws RecognitionException {
        try {
            int _type = SMILEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:31:8: ( '[smiley=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:31:10: '[smiley=\"'
            {
            match("[smiley=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SMILEY"

    // $ANTLR start "IMAGE"
    public final void mIMAGE() throws RecognitionException {
        try {
            int _type = IMAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:32:7: ( '[image=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:32:9: '[image=\"'
            {
            match("[image=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMAGE"

    // $ANTLR start "IMAGE_SITE"
    public final void mIMAGE_SITE() throws RecognitionException {
        try {
            int _type = IMAGE_SITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:33:12: ( '[imageSite=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:33:14: '[imageSite=\"'
            {
            match("[imageSite=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMAGE_SITE"

    // $ANTLR start "FERMETURE_AVEC_PARAMETRE"
    public final void mFERMETURE_AVEC_PARAMETRE() throws RecognitionException {
        try {
            int _type = FERMETURE_AVEC_PARAMETRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:34:26: ( '\"]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:34:28: '\"]'
            {
            match("\"]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FERMETURE_AVEC_PARAMETRE"

    // $ANTLR start "FERMETURE_PARAMETRE"
    public final void mFERMETURE_PARAMETRE() throws RecognitionException {
        try {
            int _type = FERMETURE_PARAMETRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:35:21: ( '\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:35:23: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FERMETURE_PARAMETRE"

    // $ANTLR start "LARGEUR"
    public final void mLARGEUR() throws RecognitionException {
        try {
            int _type = LARGEUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:36:9: ( '\" largeur=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:36:11: '\" largeur=\"'
            {
            match("\" largeur=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LARGEUR"

    // $ANTLR start "HAUTEUR"
    public final void mHAUTEUR() throws RecognitionException {
        try {
            int _type = HAUTEUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:37:9: ( '\" hauteur=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:37:11: '\" hauteur=\"'
            {
            match("\" hauteur=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAUTEUR"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:38:7: ( '[police=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:38:9: '[police=\"'
            {
            match("[police=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:39:7: ( '[/police]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:39:9: '[/police]'
            {
            match("[/police]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:40:7: ( '[taille=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:40:9: '[taille=\"'
            {
            match("[taille=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:41:7: ( '[/taille]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:41:9: '[/taille]'
            {
            match("[/taille]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:42:7: ( '[couleur=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:42:9: '[couleur=\"'
            {
            match("[couleur=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:43:7: ( '[/couleur]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:43:9: '[/couleur]'
            {
            match("[/couleur]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:44:7: ( '[fond=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:44:9: '[fond=\"'
            {
            match("[fond=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:45:7: ( '[/fond]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:45:9: '[/fond]'
            {
            match("[/fond]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:46:7: ( '[lien=\"' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:46:9: '[lien=\"'
            {
            match("[lien=\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:47:7: ( '[/lien]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:47:9: '[/lien]'
            {
            match("[/lien]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:48:7: ( '[titre=' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:48:9: '[titre='
            {
            match("[titre="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:49:7: ( ']' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:49:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:50:7: ( '[/titre]' )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:50:9: '[/titre]'
            {
            match("[/titre]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "SUITE_CARACTERE_QUELQUONQUE"
    public final void mSUITE_CARACTERE_QUELQUONQUE() throws RecognitionException {
        try {
            int _type = SUITE_CARACTERE_QUELQUONQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:28: ( ( ( '\\r' )? '\\n' | ' ' | '\\u000C' | '!' | '\\u0023' .. '\\u0025' | '\\u0027' .. '\\u005A' | '\\u005E' .. '\\u007E' | '\\u0080' | '\\u00FF' | '\\u0100' .. '\\u017F' | '\\u0180' .. '\\u024F' | '&' )* )
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:32: ( ( '\\r' )? '\\n' | ' ' | '\\u000C' | '!' | '\\u0023' .. '\\u0025' | '\\u0027' .. '\\u005A' | '\\u005E' .. '\\u007E' | '\\u0080' | '\\u00FF' | '\\u0100' .. '\\u017F' | '\\u0180' .. '\\u024F' | '&' )*
            {
            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:32: ( ( '\\r' )? '\\n' | ' ' | '\\u000C' | '!' | '\\u0023' .. '\\u0025' | '\\u0027' .. '\\u005A' | '\\u005E' .. '\\u007E' | '\\u0080' | '\\u00FF' | '\\u0100' .. '\\u017F' | '\\u0180' .. '\\u024F' | '&' )*
            loop2:
            do {
                int alt2=13;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:33: ( '\\r' )? '\\n'
            	    {
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:33: ( '\\r' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='\r') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:33: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:45: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 3 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:51: '\\u000C'
            	    {
            	    match('\f'); 

            	    }
            	    break;
            	case 4 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:62: '!'
            	    {
            	    match('!'); 

            	    }
            	    break;
            	case 5 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:68: '\\u0023' .. '\\u0025'
            	    {
            	    matchRange('#','%'); 

            	    }
            	    break;
            	case 6 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:88: '\\u0027' .. '\\u005A'
            	    {
            	    matchRange('\'','Z'); 

            	    }
            	    break;
            	case 7 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:109: '\\u005E' .. '\\u007E'
            	    {
            	    matchRange('^','~'); 

            	    }
            	    break;
            	case 8 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:130: '\\u0080'
            	    {
            	    match('\u0080'); 

            	    }
            	    break;
            	case 9 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:141: '\\u00FF'
            	    {
            	    match('\u00FF'); 

            	    }
            	    break;
            	case 10 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:152: '\\u0100' .. '\\u017F'
            	    {
            	    matchRange('\u0100','\u017F'); 

            	    }
            	    break;
            	case 11 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:173: '\\u0180' .. '\\u024F'
            	    {
            	    matchRange('\u0180','\u024F'); 

            	    }
            	    break;
            	case 12 :
            	    // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:308:195: '&'
            	    {
            	    match('&'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUITE_CARACTERE_QUELQUONQUE"

    public void mTokens() throws RecognitionException {
        // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:8: ( DEBUT_GRAS | FIN_GRAS | DEBUT_ITALIQUE | FIN_ITALIQUE | DEBUT_SOULIGNE | FIN_SOULIGNE | DEBUT_BARRE | FIN_BARRE | DEBUT_CLIGNOTE | FIN_CLIGNOTE | DEBUT_GAUCHE | FIN_GAUCHE | DEBUT_DROITE | FIN_DROITE | DEBUT_CENTRE | FIN_CENTRE | DEBUT_JUSTIFIE | FIN_JUSTIFIE | DEBUT_TABLEAU | FIN_TABLEAU | DEBUT_LIGNE | FIN_LIGNE | DEBUT_CELLULE | FIN_CELLULE | SMILEY | IMAGE | IMAGE_SITE | FERMETURE_AVEC_PARAMETRE | FERMETURE_PARAMETRE | LARGEUR | HAUTEUR | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | SUITE_CARACTERE_QUELQUONQUE )
        int alt3=45;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:10: DEBUT_GRAS
                {
                mDEBUT_GRAS(); 

                }
                break;
            case 2 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:21: FIN_GRAS
                {
                mFIN_GRAS(); 

                }
                break;
            case 3 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:30: DEBUT_ITALIQUE
                {
                mDEBUT_ITALIQUE(); 

                }
                break;
            case 4 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:45: FIN_ITALIQUE
                {
                mFIN_ITALIQUE(); 

                }
                break;
            case 5 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:58: DEBUT_SOULIGNE
                {
                mDEBUT_SOULIGNE(); 

                }
                break;
            case 6 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:73: FIN_SOULIGNE
                {
                mFIN_SOULIGNE(); 

                }
                break;
            case 7 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:86: DEBUT_BARRE
                {
                mDEBUT_BARRE(); 

                }
                break;
            case 8 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:98: FIN_BARRE
                {
                mFIN_BARRE(); 

                }
                break;
            case 9 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:108: DEBUT_CLIGNOTE
                {
                mDEBUT_CLIGNOTE(); 

                }
                break;
            case 10 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:123: FIN_CLIGNOTE
                {
                mFIN_CLIGNOTE(); 

                }
                break;
            case 11 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:136: DEBUT_GAUCHE
                {
                mDEBUT_GAUCHE(); 

                }
                break;
            case 12 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:149: FIN_GAUCHE
                {
                mFIN_GAUCHE(); 

                }
                break;
            case 13 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:160: DEBUT_DROITE
                {
                mDEBUT_DROITE(); 

                }
                break;
            case 14 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:173: FIN_DROITE
                {
                mFIN_DROITE(); 

                }
                break;
            case 15 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:184: DEBUT_CENTRE
                {
                mDEBUT_CENTRE(); 

                }
                break;
            case 16 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:197: FIN_CENTRE
                {
                mFIN_CENTRE(); 

                }
                break;
            case 17 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:208: DEBUT_JUSTIFIE
                {
                mDEBUT_JUSTIFIE(); 

                }
                break;
            case 18 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:223: FIN_JUSTIFIE
                {
                mFIN_JUSTIFIE(); 

                }
                break;
            case 19 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:236: DEBUT_TABLEAU
                {
                mDEBUT_TABLEAU(); 

                }
                break;
            case 20 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:250: FIN_TABLEAU
                {
                mFIN_TABLEAU(); 

                }
                break;
            case 21 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:262: DEBUT_LIGNE
                {
                mDEBUT_LIGNE(); 

                }
                break;
            case 22 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:274: FIN_LIGNE
                {
                mFIN_LIGNE(); 

                }
                break;
            case 23 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:284: DEBUT_CELLULE
                {
                mDEBUT_CELLULE(); 

                }
                break;
            case 24 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:298: FIN_CELLULE
                {
                mFIN_CELLULE(); 

                }
                break;
            case 25 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:310: SMILEY
                {
                mSMILEY(); 

                }
                break;
            case 26 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:317: IMAGE
                {
                mIMAGE(); 

                }
                break;
            case 27 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:323: IMAGE_SITE
                {
                mIMAGE_SITE(); 

                }
                break;
            case 28 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:334: FERMETURE_AVEC_PARAMETRE
                {
                mFERMETURE_AVEC_PARAMETRE(); 

                }
                break;
            case 29 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:359: FERMETURE_PARAMETRE
                {
                mFERMETURE_PARAMETRE(); 

                }
                break;
            case 30 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:379: LARGEUR
                {
                mLARGEUR(); 

                }
                break;
            case 31 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:387: HAUTEUR
                {
                mHAUTEUR(); 

                }
                break;
            case 32 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:395: T__36
                {
                mT__36(); 

                }
                break;
            case 33 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:401: T__37
                {
                mT__37(); 

                }
                break;
            case 34 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:407: T__38
                {
                mT__38(); 

                }
                break;
            case 35 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:413: T__39
                {
                mT__39(); 

                }
                break;
            case 36 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:419: T__40
                {
                mT__40(); 

                }
                break;
            case 37 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:425: T__41
                {
                mT__41(); 

                }
                break;
            case 38 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:431: T__42
                {
                mT__42(); 

                }
                break;
            case 39 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:437: T__43
                {
                mT__43(); 

                }
                break;
            case 40 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:443: T__44
                {
                mT__44(); 

                }
                break;
            case 41 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:449: T__45
                {
                mT__45(); 

                }
                break;
            case 42 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:455: T__46
                {
                mT__46(); 

                }
                break;
            case 43 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:461: T__47
                {
                mT__47(); 

                }
                break;
            case 44 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:467: T__48
                {
                mT__48(); 

                }
                break;
            case 45 :
                // /home/krack/workspace/EcurieLoup/edlCode/src/main/java/edlcode/EdlCode.g:1:473: SUITE_CARACTERE_QUELQUONQUE
                {
                mSUITE_CARACTERE_QUELQUONQUE(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA2_eotS =
        "\1\1\15\uffff";
    static final String DFA2_eofS =
        "\16\uffff";
    static final String DFA2_minS =
        "\1\12\15\uffff";
    static final String DFA2_maxS =
        "\1\u024f\15\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14";
    static final String DFA2_specialS =
        "\16\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\1\uffff\1\4\1\2\22\uffff\1\3\1\5\1\uffff\3\6\1\15\64\7"+
            "\3\uffff\41\10\1\uffff\1\11\176\uffff\1\12\u0080\13\u00d0\14",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 308:32: ( ( '\\r' )? '\\n' | ' ' | '\\u000C' | '!' | '\\u0023' .. '\\u0025' | '\\u0027' .. '\\u005A' | '\\u005E' .. '\\u007E' | '\\u0080' | '\\u00FF' | '\\u0100' .. '\\u017F' | '\\u0180' .. '\\u024F' | '&' )*";
        }
    }
    static final String DFA3_eotS =
        "\1\4\1\uffff\1\23\103\uffff";
    static final String DFA3_eofS =
        "\106\uffff";
    static final String DFA3_minS =
        "\1\42\1\57\1\40\2\uffff\1\141\1\142\2\155\1\uffff\1\145\2\uffff"+
        "\1\141\1\151\3\uffff\1\150\3\uffff\1\141\3\uffff\1\145\2\uffff\1"+
        "\141\1\151\3\uffff\1\141\3\uffff\1\154\1\uffff\1\142\1\uffff\1\145"+
        "\5\uffff\1\154\1\uffff\1\142\1\uffff\1\145\1\147\14\uffff\1\145"+
        "\1\75\2\uffff";
    static final String DFA3_maxS =
        "\1\135\1\164\1\135\2\uffff\1\162\2\164\1\157\1\uffff\1\157\2\uffff"+
        "\2\151\3\uffff\1\154\3\uffff\1\162\3\uffff\1\157\2\uffff\2\151\3"+
        "\uffff\1\141\3\uffff\1\156\1\uffff\1\151\1\uffff\1\147\5\uffff\1"+
        "\156\1\uffff\1\151\1\uffff\2\147\14\uffff\1\145\1\123\2\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\53\1\55\4\uffff\1\7\1\uffff\1\15\1\21\2\uffff\1\40\1"+
        "\46\1\34\1\uffff\1\35\1\1\1\13\1\uffff\1\4\1\6\1\10\1\uffff\1\16"+
        "\1\22\2\uffff\1\41\1\47\1\3\1\uffff\1\5\1\31\1\11\1\uffff\1\44\1"+
        "\uffff\1\52\1\uffff\1\36\1\37\1\2\1\14\1\12\1\uffff\1\45\1\uffff"+
        "\1\54\2\uffff\1\17\1\27\1\23\1\42\1\25\1\50\1\20\1\30\1\24\1\43"+
        "\1\26\1\51\2\uffff\1\32\1\33";
    static final String DFA3_specialS =
        "\106\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\70\uffff\1\1\1\uffff\1\3",
            "\1\6\62\uffff\1\11\1\12\1\13\1\uffff\1\20\1\5\1\uffff\1\7\1"+
            "\14\1\uffff\1\16\3\uffff\1\17\2\uffff\1\10\1\15",
            "\1\22\74\uffff\1\21",
            "",
            "",
            "\1\25\20\uffff\1\24",
            "\1\31\1\32\1\33\1\uffff\1\40\1\26\1\uffff\1\27\1\34\1\uffff"+
            "\1\36\3\uffff\1\37\2\uffff\1\30\1\35",
            "\1\42\6\uffff\1\41",
            "\1\44\1\uffff\1\43",
            "",
            "\1\46\6\uffff\1\45\2\uffff\1\47",
            "",
            "",
            "\1\50\7\uffff\1\51",
            "\1\52",
            "",
            "",
            "",
            "\1\54\3\uffff\1\53",
            "",
            "",
            "",
            "\1\56\20\uffff\1\55",
            "",
            "",
            "",
            "\1\60\6\uffff\1\57\2\uffff\1\61",
            "",
            "",
            "\1\62\7\uffff\1\63",
            "\1\64",
            "",
            "",
            "",
            "\1\65",
            "",
            "",
            "",
            "\1\67\1\uffff\1\66",
            "",
            "\1\70\6\uffff\1\71",
            "",
            "\1\73\1\uffff\1\72",
            "",
            "",
            "",
            "",
            "",
            "\1\75\1\uffff\1\74",
            "",
            "\1\76\6\uffff\1\77",
            "",
            "\1\101\1\uffff\1\100",
            "\1\102",
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
            "\1\103",
            "\1\104\25\uffff\1\105",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DEBUT_GRAS | FIN_GRAS | DEBUT_ITALIQUE | FIN_ITALIQUE | DEBUT_SOULIGNE | FIN_SOULIGNE | DEBUT_BARRE | FIN_BARRE | DEBUT_CLIGNOTE | FIN_CLIGNOTE | DEBUT_GAUCHE | FIN_GAUCHE | DEBUT_DROITE | FIN_DROITE | DEBUT_CENTRE | FIN_CENTRE | DEBUT_JUSTIFIE | FIN_JUSTIFIE | DEBUT_TABLEAU | FIN_TABLEAU | DEBUT_LIGNE | FIN_LIGNE | DEBUT_CELLULE | FIN_CELLULE | SMILEY | IMAGE | IMAGE_SITE | FERMETURE_AVEC_PARAMETRE | FERMETURE_PARAMETRE | LARGEUR | HAUTEUR | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | SUITE_CARACTERE_QUELQUONQUE );";
        }
    }
 

}