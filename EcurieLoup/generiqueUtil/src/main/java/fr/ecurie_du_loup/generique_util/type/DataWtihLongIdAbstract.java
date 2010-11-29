package fr.ecurie_du_loup.generique_util.type;



public class DataWtihLongIdAbstract<T extends DataWithLongId> implements DataWithLongId {
	protected long id;
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass() != this.getClass())
			return false;
		
		T object = (T) obj;
		return object.getId() == this.getId();
	}
	
	@Override
	public int hashCode() {
		//cf : Java efficace p.36
		int result = 17;
		result = 37 * result + (int)(this.getId() ^ (this.getId() >>> 32));
		
		return result;
	}

}
