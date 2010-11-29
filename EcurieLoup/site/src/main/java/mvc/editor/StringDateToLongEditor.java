package mvc.editor;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;

public class StringDateToLongEditor extends PropertyEditorSupport {
	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormatter, true);
		customDateEditor.setAsText(text);
		Date date = (Date) customDateEditor.getValue();
		this.setValue(date.getTime());

	}
}
