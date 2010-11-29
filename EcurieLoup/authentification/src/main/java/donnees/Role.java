package donnees;

/**
 * Objet de Role
 * @author Krack
 *
 */
public class Role{

   private String role;
   private String image;
   private String description;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString(){
    	return this.role;
    }
    
    @Override
    public boolean equals(Object obj){
    	if( obj instanceof Role){
    		return this.equals((Role)obj);
    	}else{
    		return false;
    	}
    }
    public boolean  equals(Role obj){
    	return this.role.equals(obj.role );
    }
}
