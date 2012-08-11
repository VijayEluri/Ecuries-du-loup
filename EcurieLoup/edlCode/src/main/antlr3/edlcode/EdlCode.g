grammar EdlCode;

options {
  k = 1;
  
}

tokens {
	DEBUT_GRAS = '[gras]';
	FIN_GRAS = '[/gras]';
	

	DEBUT_ITALIQUE = '[italique]';
	FIN_ITALIQUE = '[/italique]';
	
	DEBUT_SOULIGNE = '[souligne]';
	FIN_SOULIGNE = '[/souligne]';
	
	DEBUT_BARRE = '[barre]';
	FIN_BARRE = '[/barre]';
	
	DEBUT_CLIGNOTE = '[clignote]';
	FIN_CLIGNOTE = '[/clignote]';
	
	DEBUT_GAUCHE = '[gauche]';
	FIN_GAUCHE =  '[/gauche]';
	
	DEBUT_DROITE = '[droite]';
	FIN_DROITE =  '[/droite]';
	
	DEBUT_CENTRE = '[centre]';
	FIN_CENTRE =  '[/centre]';
	
	DEBUT_JUSTIFIE =  '[justifie]';
	FIN_JUSTIFIE =  '[/justifie]';
	
	DEBUT_TABLEAU = '[tableau]';
	FIN_TABLEAU = '[/tableau]';
	
	DEBUT_LIGNE = '[ligne]';
	FIN_LIGNE = '[/ligne]';
	
	DEBUT_CELLULE = '[cellule]';
	FIN_CELLULE= '[/cellule]';
	
	SMILEY='[smiley="';
	IMAGE = '[image="';
	IMAGE_SITE = '[imageSite="';
	TEXT = '[text';	
	FIN_TEXT= '[/text]';
	FERMETURE_SANS_PARAMETRE = ']';
	FERMETURE_AVEC_PARAMETRE = '"]';
	FERMETURE_PARAMETRE='"';
	LARGEUR = '" largeur="';
	HAUTEUR = '" hauteur="';	
	HAUTEUR_TEXT = ' hauteur="';
	TOP = '" top="';
	LEFT = '" left="';
}


@header {
  package edlcode;
} 

@lexer::header{
  package edlcode;
}


prog returns [String retour =""] : 
      (p =phrase
        {
          retour+=p;
        }
      )* ;
    
 phrase returns [String retour] :  
      DEBUT_GRAS  p =prog FIN_GRAS
        {
       
          $retour = "<strong>"+p+"</strong>";
        }
      |
      
      DEBUT_ITALIQUE  p =prog FIN_ITALIQUE
        {
          $retour = "<span class=\"edlCode_italique\">"+p+"</span>";
        }
      |
      
      DEBUT_SOULIGNE  p =prog FIN_SOULIGNE
        {
           $retour = "<span class=\"edlCode_souligne\">"+p+"</span>";
        }
      
      |
      DEBUT_BARRE  p =prog FIN_BARRE
        {
          $retour = "<span class=\"edlCode_barre\">"+p+"</span>";
        }
       |
      DEBUT_CLIGNOTE  p =prog FIN_CLIGNOTE
        {
          $retour = "<span class=\"edlCode_clignote\">"+p+"</span>";
        }
      |
      DEBUT_GAUCHE  p =prog FIN_GAUCHE
        {
          $retour = "<div class=\"edlCode_gauche\">"+p+"</div>";
        }
     |
      DEBUT_DROITE  p =prog FIN_DROITE
        {
          $retour = "<div class=\"edlCode_droite\">"+p+"</div>";
        }
     
      |
      
       DEBUT_CENTRE  p =prog FIN_CENTRE
        {
          $retour = "<div class=\"edlCode_centre\">"+p+"</div>";
        }
     
      |
           
       DEBUT_JUSTIFIE  p =prog FIN_JUSTIFIE
        {
           $retour = "<div class=\"edlCode_justifie\">"+p+"</div>";
        }
     
      |
      
      '[police="'policeString=police FERMETURE_AVEC_PARAMETRE  p =prog '[/police]'
        {
          $retour = "<span style='font-family:\""+policeString+"\" ; ' >"+p+"</span>";
        }
      |
      
      '[taille="'tailleString= taillePolice FERMETURE_AVEC_PARAMETRE  p =prog '[/taille]'
        {
           $retour = "<span style='font-size:"+tailleString+" ; ' >"+p+"</span>";
        }
      |
      '[couleur="'couleurString= couleur FERMETURE_AVEC_PARAMETRE  p =prog '[/couleur]'
        {
         $retour = "<span style='color: "+couleurString+" ; ' >"+p+"</span>";
        }
      |
      '[fond="'couleurString= couleur FERMETURE_AVEC_PARAMETRE  p =prog '[/fond]'
        {
          $retour = "<span style='background-color: "+couleurString+" ; ' >"+p+"</span>";
        }
      |
      
      ///////////////////////////////////////////
      
       '[lien="'urlString= url FERMETURE_AVEC_PARAMETRE  p =prog '[/lien]'
        {
          $retour = "<a href=\""+urlString+"\">"+p+"</a>";
        }
        
           |
      
      SMILEY cheminString= chemin FERMETURE_AVEC_PARAMETRE
        {
          $retour = "<img src=\""+cheminString+"\" alt=\""+cheminString+"\"";
         //if(largeur != null){
         //   $retour += "width=\""+largeur+"\"";
         //  }
          $retour += " />";
       
        }
      
      |
      TEXT HAUTEUR_TEXT hauteur = dimention FERMETURE_PARAMETRE LARGEUR largeur = dimention FERMETURE_PARAMETRE TOP top = dimention FERMETURE_PARAMETRE LEFT left = dimention FERMETURE_PARAMETRE FERMETURE_AVEC_PARAMETRE p =prog  FIN_TEXT
       {
      
      	$retour = "<div class=\"edl_block\"";
      		if(hauteur != null){
            $retour += " height=\""+hauteur+"\"";
          }
          if(largeur != null){
            $retour += " width=\""+largeur+"\"";
           }
           
           $retour += " style=\"";
           if(top != null){
            	$retour += "top:"+top+";";
            }
            if(left != null){
            	$retour += "left:"+left+";";
            }
          $retour += "\"";
           $retour +=">"+p+"</div>";
        }
      |
      
     IMAGE cheminString= chemin (HAUTEUR hauteur = dimention FERMETURE_PARAMETRE)? (LARGEUR largeur = dimention FERMETURE_PARAMETRE)? (TOP top = dimention FERMETURE_PARAMETRE)? (LEFT left = dimention FERMETURE_PARAMETRE)? FERMETURE_AVEC_PARAMETRE
        {
          $retour = "<img class=\"edl_block\" src=\""+cheminString+"\" alt=\""+cheminString+"\"";
          if(hauteur != null){
            $retour += " height=\""+hauteur+"\"";
          }
         if(largeur != null){
            $retour += " width=\""+largeur+"\"";
          }
          
           $retour += " style=\"";
          if(top != null){
            $retour += "top:"+top+";";
          }
           if(left != null){
            $retour += "left:"+left+";";
          }
          $retour += "\"";
          
          
          $retour += " />";
     
     
     
       }
        |
      IMAGE_SITE cheminString= chemin (HAUTEUR hauteur = dimention FERMETURE_PARAMETRE)? (LARGEUR largeur = dimention FERMETURE_PARAMETRE)?  (TOP top = dimention FERMETURE_PARAMETRE)? (LEFT left = dimention FERMETURE_PARAMETRE)? FERMETURE_AVEC_PARAMETRE
        {
          $retour = "<img class=\"edl_block\" src=\"${ctx}/images/albumPhoto/"+cheminString+"\" alt=\"image "+cheminString+" inexistante \"";
           if(hauteur != null){
            $retour += " height=\""+hauteur+"\"";
          }
         if(largeur != null){
            $retour += " width=\""+largeur+"\"";
          }
           $retour += " style=\"";
          if(top != null){
            $retour += "top:"+top+";";
          }
           if(left != null){
            $retour += "left:"+left+";";
          }
          $retour += "\"";
          
          $retour += " />";
        }
        
      |
       
      DEBUT_TABLEAU SUITE_CARACTERE_QUELQUONQUE?
        {
            $retour="<table class=\"edlCode_tableau\">";
         }
          (l = ligneTableau
            {
              $retour+=l;
            }
          )*
         FIN_TABLEAU
        {
          $retour += "</table>";
        }
      |

      '[titre='intTitre = typetitre']' p =prog '[/titre]' 
        {
         $retour = "<h"+intTitre+">"+p+"</h"+intTitre+">";
        }
      
      |
      
      
      SUITE_CARACTERE_QUELQUONQUE
        {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
        }   
      ;        
ligneTableau returns [String retour] :  
      DEBUT_LIGNE SUITE_CARACTERE_QUELQUONQUE?
         {
             $retour="<tr>";
         }
          (c = celluleTableau
            {
              $retour+=c;
            }
          )*
          FIN_LIGNE SUITE_CARACTERE_QUELQUONQUE?
        {
          $retour += "</tr>";
        }
        ;   
        
celluleTableau returns [String retour] :  
     DEBUT_CELLULE  p =prog FIN_CELLULE SUITE_CARACTERE_QUELQUONQUE?
        {
           $retour = "<td>"+p+"</td>";
        }
        ;   
  
police returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
taillePolice returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
 couleur returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
     
url returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
chemin returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
typetitre returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
 ligne returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;
      
dimention returns [String retour] : 
      SUITE_CARACTERE_QUELQUONQUE
      {
          $retour = $SUITE_CARACTERE_QUELQUONQUE.text;
       }
      ;

SUITE_CARACTERE_QUELQUONQUE:   ('\r'? '\n'| ' ' | '\u000C' | '!' | '\u0023'..'\u0025'| '\u0027'..'\u005A' | '\u005E'..'\u007E' | '\u0080' | '\u00FF' | '\u0100'..'\u017F' | '\u0180'.. '\u024F' | '&')* ;


