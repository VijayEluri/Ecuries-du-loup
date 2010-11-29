package fr.ecuriesduloup.ecurieLoup.memo.data;



import java.util.Date;

import donnees.User;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Memo  extends DataWtihLongIdAbstract<Memo>  implements DataWithLongId{
	private User sender;
	private User receiver;
	private String description;
	private long postedDate;
	private long deadLine;
	private boolean privateMemo;
	private boolean memoIsDo;

	private boolean isViewByReceiver;

	
	public void setId(long id) {
		this.id = id;
	}
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(long postedDate) {
		this.postedDate = postedDate;
	}

	public long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
	}

	public boolean isPrivateMemo() {
		return privateMemo;
	}

	public void setPrivateMemo(boolean privateMemo) {
		this.privateMemo = privateMemo;
	}

	public boolean isMemoIsDo() {
		return memoIsDo;
	}

	public void setMemoIsDo(boolean memoIsDo) {
		this.memoIsDo = memoIsDo;
	}

	public String getStatus(){
		long currentDate = new Date().getTime();

		if(this.isExceed(currentDate)){
			return "exceed";
		}
		if(this.isTheNextDay(currentDate)){
			return "day";
		}
		if(this.isTheNext3Day(currentDate)){
			return "near";
		}		
		if(this.isTheNextWeek(currentDate)){
			return "week";
		}		
		return "normal";

	}


	private boolean isExceed(long currentDate){
		return this.deadLine <= currentDate;
	}

	private boolean isTheNextDay(long currentDate) {
		return this.deadLine  <= currentDate + 1* this.getDayTime();
	}

	private boolean isTheNext3Day(long currentDate) {
		return this.deadLine <= currentDate + 3 * this.getDayTime();
	}
	private boolean isTheNextWeek(long currentDate) {
		return this.deadLine  <= currentDate + 7* this.getDayTime();
	}


	private long getDayTime(){
		return 1000*60*60*24;
	}
	public boolean isViewByReceiver() {
		return isViewByReceiver;
	}
	public void setViewByReceiver(boolean isViewByReceiver) {
		this.isViewByReceiver = isViewByReceiver;
	}


	@Override
	public String toString() {
		String toString = "Memo : \t";
		toString+="id : "+this.id+"\t";
		if(this.sender!=null){
			toString+="sender : "+this.sender.getLogin()+"\t";
		}
		if(this.receiver!=null){
			toString+="receiver : "+this.receiver.getLogin()+"\t";
		}
		toString+="description : "+this.description+"\t";
		toString+="postedDate : "+this.postedDate+"\t";
		toString+="deadLine : "+this.deadLine+"\t";
		toString+="memoIsDo : "+this.memoIsDo+"\t";
		toString+="isViewByReceiver : "+this.isViewByReceiver+"\t";
		toString+="status : "+this.getStatus()+"\t";

		return toString;
	}
}
