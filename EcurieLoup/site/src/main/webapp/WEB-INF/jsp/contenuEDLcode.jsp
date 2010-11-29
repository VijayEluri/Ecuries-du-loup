
<fmt:bundle basename="i18n.edlCode">
<div class="formulaire_edl_code" >
	<div class="mise_en_forme_texte">
	<input type="button" value="g"
		title="gras" class="edlCode_gras" onclick="storeCaretPareil('gras')" />
	<input type="button" value="i" title="italique" class="edlCode_italique"
		onclick="storeCaretPareil('italique')" /> <input type="button"
		value="s" title="souligné" class="edlCode_souligne"
		onclick="storeCaretPareil('souligne')" /> <input type="button"
		value="b" title="barré" class="edlCode_barre"
		onclick="storeCaretPareil('barre')" /> <input type="button" value="c"
		title="clignote" class="edlCode_clignote"
		onclick="storeCaretPareil('clignote')" />
	</div>
	
	<div class="position_texte">
	<img src="${ctx }/images/alignement_gauche.gif" title="aligner à gauche" onclick="storeCaretPareil('gauche')" />
	<img src="${ctx }/images/alignement_centre.gif" title="centre" onclick="storeCaretPareil('centre')" />
	<img src="${ctx }/images/alignement_droite.gif" title="droite" onclick="storeCaretPareil('droite')" />
	</div>
	
	<div class="titre"><input type="button" value="T1"
		title="titre de niveau 1" onclick="storeCaret('titre=1', 'titre')" />
	<input type="button" value="T2" title="titre de niveau 2"
		onclick="storeCaret('titre=2', 'titre')" /> <input type="button"
		value="T3" title="titre de niveau 3"
		onclick="storeCaret('titre=3', 'titre')" /> <input type="button"
		value="T4" title="titre de niveau 4"
		onclick="storeCaret('titre=4', 'titre')" /> <input type="button"
		value="T5" title="titre de niveau 5"
		onclick="storeCaret('titre=5', 'titre')" /> <input type="button"
		value="T6" title="titre de niveau 6"
		onclick="storeCaret('titre=6', 'titre')" /></div>
	
	<div class="ajout_element">
	
		<img src="${ctx }/images/ajouter_image.png" class="icone" onclick="ajoutImage()" alt="<fmt:message key="edlcode.formulaire.image.ajout.alt" />"  title="<fmt:message key="edlcode.formulaire.image.ajout.title" />"/> 
	
		<img src="${ctx }/images/link.png" class="icone" onclick="ajoutLien()" alt="<fmt:message key="edlcode.formulaire.link.ajout.alt" />"  title="<fmt:message key="edlcode.formulaire.link.ajout.title" />"/> 
	</div>
	
	<div class="">
	<select id="policeEdlCode">
		<option>Arial</option>
		<option>Arial Black</option>
		<option>Comic Sans MS</option>
		<option>Courier New</option>
		<option>Georgia</option>
		<option>Impact</option>
		<option>Times New Roman</option>
	</select>
	<img src="${ctx }/images/font.png" class="icone" onclick="ajoutPolice()" alt="<fmt:message key="edlcode.formulaire.font.add.alt" />"  title="<fmt:message key="edlcode.formulaire.font.add.title" />"/> 

	 <select
		id="tailleEdlCode">
		<option>70%</option>
		<option>80%</option>
		<option>90%</option>
		<option selected="selected">100%</option>
		<option>110%</option>
		<option>120%</option>
		<option>130%</option>
	</select>
	
	 <input type="button" value="Taille" title="Utilisé la taille choisi"
		onclick="ajoutTaille()" />
		
	<!--  partie couleur du texte -->
	<img id="ajoutCouleurIcone" src="${ctx }/images/color-line.png" class="icone"  alt="couleur texte" onclick="ajoutCouleur()"/> 
	<input id="couleurEdlCode" name="couleur" type="hidden"	value="#ff0000" />
	<img id="couleurText" src="${ctx }/images/down_time.gif" alt="<fmt:message key="edlcode.formulaire.couleur_texte.choix.alt"/>" title="<fmt:message key="edlcode.formulaire.couleur_texte.choix.title"/>"/> 
	
	 <!--  partie couleur du fond -->
	
	<img src="${ctx }/images/color-background.png"	class="icone"  alt="couleur fond" onclick="ajoutFond()"/>
	<input	id="couleurFondEdlCode" name="couleurFond" type="hidden" value="#ff0000" />
	<img id="couleurFond"src="${ctx }/images/down_time.gif" alt="<fmt:message key="edlcode.formulaire.couleur_fond.choix.alt"/>" title="<fmt:message key="edlcode.formulaire.couleur_fond.choix.title"/>"  /></div>
	
	
	<textarea id="texteareaEdlCode" name="${nameContenuEDLCode }" rows="10" cols="50">${ valeurContenuEDLCode }</textarea>
	
	&#160;
	<span class="error"><c:out value="${status.errorMessage}" /></span>
	<div id="emoticones">
	<div id="nom_categorie_smiley"><c:forEach var="categorie"
		items="${categoriesSmiley}">
		<c:if test="${categorie.ordre == 1 }">
			<span id="categorie_smiley_${categorie.id }"
				class="categorieSelectionner"
				onClick="changementCategorieSmiley('categorie_smiley_${categorie.id }')">${categorie.nom
			}</span>
		</c:if>
		<c:if test="${categorie.ordre != 1 }">
			<span id="categorie_smiley_${categorie.id }"
				class="categorieNonSelectionner"
				onClick="changementCategorieSmiley('categorie_smiley_${categorie.id }')">${categorie.nom
			}</span>
		</c:if>
	</c:forEach></div>
	
	
		<div id="smiley_categorie_smiley">
			<c:forEach var="categorie" items="${categoriesSmiley}">
				<c:if test="${categorie.ordre == 1 }">
					<div id="smiley_categorie_smiley_${categorie.id }"	class="smiley_de_categorie_visible">
						<c:forEach var="smiley"	items="${categorie.smileys}">
							<img src="${ctx }/images/smiley/${smiley.id}" alt="${smiley.code}"	onClick="ajoutSmiley('${smiley.code}')" />
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${categorie.ordre != 1 }">
					<div id="smiley_categorie_smiley_${categorie.id }" class="smiley_de_categorie_non_visible">
						<c:forEach var="smiley"	items="${categorie.smileys}">
							<img src="${ctx }/images/smiley/${smiley.id}" alt="${smiley.code}" onClick="ajoutSmiley('${smiley.code}')" />
						</c:forEach>
					</div>
				</c:if>
		
			</c:forEach>
		</div>
	</div>
</div>
</fmt:bundle>