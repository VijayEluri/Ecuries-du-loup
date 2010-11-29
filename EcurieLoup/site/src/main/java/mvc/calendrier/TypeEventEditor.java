package mvc.calendrier;

import java.beans.PropertyEditorSupport;

import service.calendrier.CalendrierManager;
import donnees.calendrier.TypeEvenement;

public class TypeEventEditor extends PropertyEditorSupport {
	private CalendrierManager calendrierManager;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long id = 0;
		try {
			id = Long.parseLong(text);
			TypeEvenement typeEvent = this.calendrierManager.getTypeEvent(id);
			this.setValue(typeEvent);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
