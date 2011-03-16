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
import service.photo.MediaManager;
import service.photo.securite.MediaDecorateurConcrete;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
@Ignore("probleme avec getUtilisateurCourrant dans un autre thread")
public class AlbumPhotoDecorateurConcreteTest {
	private UtilisateurManager utilisateurManager;
	private MediaManager mediaManager;
	private MediaDecorateurConcrete mediaDecorateurConcrete;

	@Before
	public void setUp() throws Exception {
		this.mediaManager = EasyMock.createMock(MediaManager.class);
		this.utilisateurManager = EasyMock.createMock(UtilisateurManager.class);

		this.mediaDecorateurConcrete = new MediaDecorateurConcrete();
		this.mediaDecorateurConcrete.setAlbumPhotoManager(this.mediaManager);
		this.mediaDecorateurConcrete.setUtilisateurManager(this.utilisateurManager);
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

		this.mediaManager.creerAlbum(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerAlbum(album);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerAlbum(album);

		EasyMock.verify(this.mediaManager);
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

		this.mediaManager.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.verify(this.mediaManager);
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
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerAlbum(fichierZip, utilisateur, pathServeur);

		EasyMock.verify(this.mediaManager);
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

		this.mediaManager.creerZipMedia(fichierZip, album, utilisateur, pathServeur);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerZipMedia(fichierZip, album, utilisateur, pathServeur);

		EasyMock.verify(this.mediaManager);
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
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerZipMedia(fichierZip, album, utilisateur, pathServeur);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}



	@Test
	public void testCreerPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);

		File fichierMedia = new File("");

		this.mediaManager.creerMedia(media, fichierMedia, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerMedia(media, fichierMedia, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);

		File fichierMedia = new File("");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerMedia(media, fichierMedia, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);

	
		this.mediaManager.creerCommentaire(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		this.mediaManager.creerCommentaire(commentaire);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerCommentaireSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerTagAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);

	
		this.mediaManager.creerTag(tag);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerTag(tag);
		
		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerTagSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);


		this.mediaManager.creerTag(tag);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerTag(tag);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerTagSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.creerTag(tag);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		this.mediaManager.modifierAlbum(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierAlbum(album);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierAlbum(album);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);


		this.mediaManager.modifierMedia(media);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierMedia(media);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierMedia(media);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	
	@Test
	public void testModifierCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		this.mediaManager.modifierCommentaire(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testModifierCommentaireSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.modifierCommentaire(commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	
	@Test
	public void testRecupererAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.expect(this.mediaManager.recupererAlbum(id)).andReturn(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Album albumRecuperer = this.mediaDecorateurConcrete.recupererAlbum(id);

		assertNotNull(albumRecuperer);

		assertEquals(album, albumRecuperer);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.expect(this.mediaManager.recupererAlbum(id)).andReturn(album);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Album albumRecuperer = this.mediaDecorateurConcrete.recupererAlbum(id);

		assertNotNull(albumRecuperer);

		assertEquals(album, albumRecuperer);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	@Test
	public void testRecupererAlbumSansDroit() {
		this.placeRetourUtilisateurSansDroit();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Album albumRecuperer = this.mediaDecorateurConcrete.recupererAlbum(id);

		assertNull(albumRecuperer);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);

		EasyMock.expect(this.mediaManager.recupererMedia(id)).andReturn(media);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Media mediaRecuperer = this.mediaDecorateurConcrete.recupererMedia(id);

		assertNotNull(mediaRecuperer);

		assertEquals(media, mediaRecuperer);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);

		EasyMock.expect(this.mediaManager.recupererMedia(id)).andReturn(media);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Media mediaRecuperer = this.mediaDecorateurConcrete.recupererMedia(id);

		assertNotNull(mediaRecuperer);

		assertEquals(media, mediaRecuperer);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererPhotoSansDroi() {
		this.placeRetourUtilisateurSansDroit();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Media photoRecuperer = this.mediaDecorateurConcrete.recupererMedia(id);

		assertNull(photoRecuperer);

		EasyMock.verify(this.mediaManager);
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

		EasyMock.expect(this.mediaManager.recupererTousLesAlbums()).andReturn(listAlbum);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		List<Album> listAlbumRecuperer = this.mediaDecorateurConcrete.recupererTousLesAlbums();

		assertNotNull(listAlbumRecuperer);

		assertEquals(listAlbumRecuperer, listAlbum);

		EasyMock.verify(this.mediaManager);
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

		EasyMock.expect(this.mediaManager.recupererTousLesAlbums()).andReturn(listAlbum);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		List<Album> listAlbumRecuperer = this.mediaDecorateurConcrete.recupererTousLesAlbums();

		assertNotNull(listAlbumRecuperer);

		assertEquals(listAlbumRecuperer, listAlbum);

		EasyMock.verify(this.mediaManager);
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
		EasyMock.replay(this.mediaManager);

		List<Album> listAlbumRecuperer = this.mediaDecorateurConcrete.recupererTousLesAlbums();

		assertNull(listAlbumRecuperer);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);




		EasyMock.expect(this.mediaManager.recupererCommentaire(id)).andReturn(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Commentaire commentaireRecuperer = this.mediaDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNotNull(commentaireRecuperer);

		assertEquals(commentaireRecuperer, commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testRecupererCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);




		EasyMock.expect(this.mediaManager.recupererCommentaire(id)).andReturn(commentaire);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Commentaire commentaireRecuperer = this.mediaDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNotNull(commentaireRecuperer);

		assertEquals(commentaireRecuperer, commentaire);

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testRecupererCommentaireSansDroi() {
		this.placeRetourUtilisateurSansDroit();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		Commentaire commentaireRecuperer = this.mediaDecorateurConcrete.recupererCommentaire(commentaire.getId());

		assertNull(commentaireRecuperer);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	
	@Test
	public void testSupprimerAlbumAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);

		this.mediaManager.supprimerAlbum(album, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerAlbum(album, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerAlbumSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);



		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerAlbum(album, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerPhotoAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);


		this.mediaManager.supprimerMedia(media, "");

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerMedia(media, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testSupprimerPhotoSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);


		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerMedia(media, "");

		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerCommentaireAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		this.mediaManager.supprimerCommentaire(commentaire);
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerCommentaire(commentaire);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerCommentaireSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Commentaire commentaire = new Commentaire();
		long id = (long) (Math.random()*10000);
		commentaire.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerCommentaire(commentaire);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerTagAvecDroitAlbum() {
		this.placeRetourUtilisateurAvecDroitAlbum();

		Tag tag = new Tag();
		long id = (long) (Math.random()*10000);
		tag.setId(id);

		this.mediaManager.supprimerTag(tag);
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerTag(tag);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerTagSansDroitAlbum() {
		this.placeRetourUtilisateurSansDroitAlbum();

		Tag tag = new Tag();
		long id = (long) (Math.random()*10000);
		tag.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.mediaManager);

		this.mediaDecorateurConcrete.supprimerTag(tag);


		EasyMock.verify(this.mediaManager);
		EasyMock.verify(this.utilisateurManager);
	}

}
