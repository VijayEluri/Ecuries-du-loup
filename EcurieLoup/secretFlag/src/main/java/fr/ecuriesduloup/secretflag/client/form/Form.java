package fr.ecuriesduloup.secretflag.client.form;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.ecuriesduloup.secretflag.client.CaseNotManageException;
import fr.ecuriesduloup.secretflag.client.CssResources;
import fr.ecuriesduloup.secretflag.client.form.data.Data;
import fr.ecuriesduloup.secretflag.client.form.data.MultipleData;
import fr.ecuriesduloup.secretflag.client.form.data.SimpleData;
import fr.ecuriesduloup.secretflag.client.form.data.TypeMultipleData;
import fr.ecuriesduloup.secretflag.client.form.data.TypeSimpleData;

public class Form extends Composite{

	private List<Field> fields;
	private VerticalPanel verticalPanel; 
	
	public Form(){
		this.fields = new ArrayList<Field>();
		this.verticalPanel = new VerticalPanel();
		
		this.initWidget(this.verticalPanel);
	}
	
	public void add(Data data){
		Field field = null;
		if(data instanceof SimpleData){
			field= this.createField((SimpleData) data);
		}else if(data instanceof MultipleData){
			field= this.createField((MultipleData) data);
		}else{
			throw new CaseNotManageException();
		}
		field.addStyleName(CssResources.R.SecretFlag().field());
		this.fields.add(field);
		this.verticalPanel.add(field);
	}
	
	private Field createField(SimpleData data){
		if(data. getType().equals(TypeSimpleData.Text)){
			return null;
		}else{
			throw new CaseNotManageException();
		}
	}
	
	private Field createField(MultipleData data){
		if(data.getType().equals(TypeMultipleData.List)){
			return null;
		}else if(data.getType().equals(TypeMultipleData.Radio)){
			return new FieldRadioButton(data);
		}else{
			throw new CaseNotManageException();
		}
	}
	
	public List<Data> getDatas(){
		List<Data> datas = new ArrayList<Data>();
		for(Field field : this.fields){
			field.majData();
			datas.add(field.getData());
			
		}
		
		return datas;
	}
}
