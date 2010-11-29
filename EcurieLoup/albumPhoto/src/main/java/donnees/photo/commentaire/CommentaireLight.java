package donnees.photo.commentaire;

public class CommentaireLight {
		private long id;
		private long photo;
		private String contenu;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getPhoto() {
			return photo;
		}
		public void setPhoto(long photo) {
			this.photo = photo;
		}
		public String getContenu() {
			return contenu;
		}
		public void setContenu(String contenu) {
			this.contenu = contenu;
		}
}
