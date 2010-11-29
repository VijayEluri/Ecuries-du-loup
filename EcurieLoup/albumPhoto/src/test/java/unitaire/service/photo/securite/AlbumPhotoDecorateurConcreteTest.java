package unitaire.service.photo.securite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import service.UtilisateurManager;
import service.photo.AlbumPhotoManager;
import service.photo.securite.AlbumPhotoDecorateurConcrete;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
@Ignore("probleme avec getUtilisateurCourrant dans un autre thread")
public class AlbumPhotoDecorateurConcreteTest {
	private UtilisateurManager utilisateurManager;
	private AlbumPhotoManager albumPhotoManager;
	private AlbumPhotoDecorateurConcrete albumPhotoDecorateurConcrete;

	@Before
	public void setUp() throws Exception {
		this.albumPhotoManager = EasyMock.createMock(AlbumPhotoManager.class);
		this.utilisateurManager = EasyMock.createMock(UtilisateurManager.class);

		this.albumPhotoDecorateurConcrete = new AlbumPhotoDecorateurConcrete();
		this.albumPhotoDecorateurConcrete.setAlbumPhotoManager(this.albumPhotoManager);
		this.albumPhotoDecorateurConcrete.setUtilisateurManager(this.utilisateurManager);
	}

	@After
	public void tearDown() throws Exception {
	}

	private void  placeRetourUtilisateurAvecDroitAlbum () {
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setRole(RoleEnum.ROLE_ADMINISTRATEUR_PHOTO.toString());
		roles.add(role);

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		User utilisateurCourant = new User();
		utilisateurCourant.setLogin("user courant");
		utilisateurCourant.setRoles(roles);

		EasyMock.expect(this.utilisateurManager.getUtilisateurCourant()).andReturn(utilisateurCourant);

	}

	private void  placeRetourUtilisateurSansDroitAlbum () {
		Set<Role> roles = new HashSet<Role>();

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		User utilisateurCourant = new User();
		utilisateurCourant.setLogin("user courant");
		utilisateurCourant.setRoles(roles);

		EasyMock.expect(this.utilisateurManager.getUtilisateurCourant()).andReturn(utilisateurCourant);

	}

	private void  placeRetourUtilisateurSansDroit () {
		Set<Role> roles = new HashSet<Role>();

		User utilisateurCourant = new User();
		utilisateurCourant.setLogin("user courant");
		utilisateurCourant.setRoles(roles);

		EasyMock.expect(this.utilisateurManager.getUtilisateurCourant()).andReturn(utilisateurCourant);

	}

	@Test
	public void testCreerAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		this.albumPhotoManager.creerAlbum(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerAlbum(album);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerAlbum(album);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerAlbumZipAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		File fichierZip = new File("");
		User utilisateur = new User();
		utilisateur.setLogin("loginTest");

		String pathServeur = "pathServeur";

		this.albumPhotoManager.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerAlbumZipSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		File fichierZip = new File("");
		User utilisateur = new User();
		utilisateur.setLogin("loginTest");
		String pathServeur = "pathServeur";


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerPhotoZipAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		File fichierZip = new File("");
		User utilisateur = new User();
		utilisateur.setLogin("loginTest");

		String pathServeur = "pathServeur";

		this.albumPhotoManager.creerZipPhoto(fichierZip, album, utilisateur, pathServeur);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerZipPhoto(fichierZip, album, utilisateur, pathServeur);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerPhotoZipSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		File fichierZip = new File("");
		User utilisateur = new User();
		utilisateur.setLogin("loginTest");
		String pathServeur = "pathServeur";


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerZipPhoto(fichierZip, album, utilisateur, pathServeur);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}



	@Test
	public void testCreerPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);

		File fichierPhoto = new File("");

		this.albumPhotoManager.creerPhoto(photo, fichierPhoto, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerPhoto(photo, fichierPhoto, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);

		File fichierPhoto = new File("");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerPhoto(photo, fichierPhoto, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);

	
		this.albumPhotoManager.creerCommentaire(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		this.albumPhotoManager.creerCommentaire(commentaire);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerCommentaireSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerTagAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);

	
		this.albumPhotoManager.creerTag(tag);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerTag(tag);
		
		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerTagSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);


		this.albumPhotoManager.creerTag(tag);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerTag(tag);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerTagSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.creerTag(tag);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		this.albumPhotoManager.modifierAlbum(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierAlbum(album);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierAlbum(album);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);


		this.albumPhotoManager.modifierPhoto(photo);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierPhoto(photo);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierPhoto(photo);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	
	@Test
	public void testModifierCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		this.albumPhotoManager.modifierCommentaire(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testModifierCommentaireSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	
	@Test
	public void testRecupererAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.expect(this.albumPhotoManager.recupererAlbum(id)).andReturn(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Album albumRecuperer = this.albumPhotoDecorateurConcrete.recupererAlbum(id);

		assertNotNull(albumRecuperer);

		assertEquals(album, albumRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.expect(this.albumPhotoManager.recupererAlbum(id)).andReturn(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Album albumRecuperer = this.albumPhotoDecorateurConcrete.recupererAlbum(id);

		assertNotNull(albumRecuperer);

		assertEquals(album, albumRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	@Test
	public void testRecupererAlbumSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Album albumRecuperer = this.albumPhotoDecorateurConcrete.recupererAlbum(id);

		assertNull(albumRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);

		EasyMock.expect(this.albumPhotoManager.recupererPhoto(id)).andReturn(photo);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Photo photoRecuperer = this.albumPhotoDecorateurConcrete.recupererPhoto(id);

		assertNotNull(photoRecuperer);

		assertEquals(photo, photoRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);

		EasyMock.expect(this.albumPhotoManager.recupererPhoto(id)).andReturn(photo);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Photo photoRecuperer = this.albumPhotoDecorateurConcrete.recupererPhoto(id);

		assertNotNull(photoRecuperer);

		assertEquals(photo, photoRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoSansDroi() {
		this.placeRetourUtilisateurSansDroit();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Photo photoRecuperer = this.albumPhotoDecorateurConcrete.recupererPhoto(id);

		assertNull(photoRecuperer);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}


	@Test
	public void testRecupererTousLesAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();
		List<Album> listAlbum = new ArrayList<Album>();
		for(int i = 0; i < 4; i++){
			Album album = new Album();
			int id = (int) (Math.random()*10000);
			album.setId(id);

			listAlbum.add(album);

		}

		EasyMock.expect(this.albumPhotoManager.recupererTousLesAlbums()).andReturn(listAlbum);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		List<Album> listAlbumRecuperer = this.albumPhotoDecorateurConcrete.recupererTousLesAlbums();

		assertNotNull(listAlbumRecuperer);

		assertEquals(listAlbumRecuperer, listAlbum);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererTousLesAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();
		List<Album> listAlbum = new ArrayList<Album>();
		for(int i = 0; i < 4; i++){
			Album album = new Album();
			int id = (int) (Math.random()*10000);
			album.setId(id);

			listAlbum.add(album);

		}

		EasyMock.expect(this.albumPhotoManager.recupererTousLesAlbums()).andReturn(listAlbum);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		List<Album> listAlbumRecuperer = this.albumPhotoDecorateurConcrete.recupererTousLesAlbums();

		assertNotNull(listAlbumRecuperer);

		assertEquals(listAlbumRecuperer, listAlbum);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererTousLesAlbumSansDroit() {
		this.placeRetourUtilisateurSansDroit();
		List<Album> listAlbum = new ArrayList<Album>();
		for(int i = 0; i < 4; i++){
			Album album = new Album();
			int id = (int) (Math.random()*10000);
			album.setId(id);

			listAlbum.add(album);

		}


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		List<Album> listAlbumRecuperer = this.albumPhotoDecorateurConcrete.recupererTousLesAlbums();

		assertNull(listAlbumRecuperer);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);




		EasyMock.expect(this.albumPhotoManager.recupererCommentaire(id)).andReturn(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Commentaire commentaireRecuperer = this.albumPhotoDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNotNull(commentaireRecuperer);

		assertEquals(commentaireRecuperer, commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testRecupererCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);




		EasyMock.expect(this.albumPhotoManager.recupererCommentaire(id)).andReturn(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Commentaire commentaireRecuperer = this.albumPhotoDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNotNull(commentaireRecuperer);

		assertEquals(commentaireRecuperer, commentaire);

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testRecupererCommentaireSansDroi() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		Commentaire commentaireRecuperer = this.albumPhotoDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNull(commentaireRecuperer);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	
	@Test
	public void testSupprimerAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		this.albumPhotoManager.supprimerAlbum(album, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerAlbum(album, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerAlbum(album, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);


		this.albumPhotoManager.supprimerPhoto(photo, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerPhoto(photo, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerPhoto(photo, "");

		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		this.albumPhotoManager.supprimerCommentaire(commentaire);
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerCommentaire(commentaire);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerCommentaire(commentaire);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerTagAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Tag tag = new Tag();
		long id = (long) (Math.random()*10000);
		tag.setId(id);

		this.albumPhotoManager.supprimerTag(tag);
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerTag(tag);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerTagSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Tag tag = new Tag();
		long id = (long) (Math.random()*10000);
		tag.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.albumPhotoManager);

		this.albumPhotoDecorateurConcrete.supprimerTag(tag);


		EasyMock.verify(this.albumPhotoManager);
		EasyMock.verify(this.utilisateurManager);
	}

}
