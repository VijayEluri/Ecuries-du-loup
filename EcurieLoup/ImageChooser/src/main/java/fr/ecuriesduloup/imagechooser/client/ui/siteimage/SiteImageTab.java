package fr.ecuriesduloup.imagechooser.client.ui.siteimage;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import fr.ecuriesduloup.imagechooser.client.ImageChooserService;
import fr.ecuriesduloup.imagechooser.client.ImageChooserServiceAsync;
import fr.ecuriesduloup.imagechooser.client.ImageDefine;
import fr.ecuriesduloup.imagechooser.shared.Album;
import fr.ecuriesduloup.imagechooser.shared.Img;
import fr.ecuriesduloup.imagechooser.shared.Photo;

public class SiteImageTab extends Tab {
	private final ImageChooserServiceAsync imageChooserService = GWT.create(ImageChooserService.class);
	private VStack albumsDiplayPanel;

	private final TreeGrid employeeTreeGrid;  
	private ImageDefine imageDefine;
	private String selectedPhoto = "0";
	
	public SiteImageTab(ImageDefine imageDefine) {
		super("Album");

		this.imageDefine = imageDefine;
		this.albumsDiplayPanel = new VStack();

		setPane(albumsDiplayPanel);
		employeeTreeGrid = new TreeGrid();

		employeeTreeGrid.setWidth100();
		employeeTreeGrid.setHeight100();
		employeeTreeGrid.setCanSort(false);
		employeeTreeGrid.setCanResizeFields(false);
		employeeTreeGrid.setCanAutoFitFields(false);
		employeeTreeGrid.setSelectionType(SelectionStyle.SINGLE);

		employeeTreeGrid.addSelectionChangedHandler(new SelectionChangedHandler() {

			@Override
			public void onSelectionChanged(SelectionEvent event) {
				if(event.getSelectedRecord() !=null){
					String id= event.getSelectedRecord().getAttribute("EmployeeId");
					if(id.startsWith("p")){
						String idLong = id.substring(1);
						Img chooseImage = new Img();
						chooseImage.define(Long.parseLong(idLong));
						SiteImageTab.this.imageDefine.defineImage(chooseImage);
					}
				}

			}
		});


		albumsDiplayPanel.addMember(employeeTreeGrid);


	}

	public void define(Img img){
		if(img.isDefine()){
			if(img.isPhotoAlbum()){
				employeeTreeGrid.setSelectedState("p"+img.getPhotoAlbum());
			}
		}
	}

	public void load(){
		imageChooserService.getListAlbum(new AsyncCallback<List<Album>>() {

			@Override
			public void onSuccess(List<Album> result) {

				final Tree tree = new Tree();  
				//tree.setModelType(TreeModelType.PARENT);  
				tree.setNameProperty("Name");  
				tree.setIdField("EmployeeId");  
				tree.setParentIdField("ReportsTo");  
				tree.setRootValue(0);
				tree.setReportCollisions(false);

				List<EmployeeTreeNode> list = new ArrayList<EmployeeTreeNode>();
				for(Album album : result){
					EmployeeTreeNode nodeAlbum = new EmployeeTreeNode("a"+album.getId(), "0", album.getName());
					list.add(nodeAlbum);
					for(int i = 0; i < album.getSizePhotos(); i++){
						Photo photo = album.getPhoto(i);
						EmployeeTreeNode nodePhoto = new EmployeeTreeNode("p"+photo.getId(), nodeAlbum.getEmployeeId(), photo.getId()+"");
						list.add(nodePhoto);
					}

				}
				tree.setData(toArray(list));  
				employeeTreeGrid.setData(tree);  

				employeeTreeGrid.draw();  

				if(!selectedPhoto.equals("0")){
					employeeTreeGrid.setSelectedState(selectedPhoto);
				}

			}

			private TreeNode[] toArray(List<EmployeeTreeNode> list){
				TreeNode[] array = new TreeNode[list.size()];
				int i = 0;
				for(EmployeeTreeNode node : list){
					array[i] = node;
					i++;
				}
				return array;
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("error");				
			}
		});	

	}
	public enum TypeNode{
		PHOTO,
		ALBUM

	}
	public static class EmployeeTreeNode extends TreeNode {  

		public EmployeeTreeNode(String employeeId, String reportsTo, String name) {  
			setEmployeeId(employeeId);  
			setReportsTo(reportsTo);  
			setName(name);  
		} 
		/*	public EmployeeTreeNode(long employeeId, EmployeeTreeNode reportsTo, String name) {  
			setEmployeeId(employeeId, TypeNode.PHOTO);  
			setReportsTo(reportsTo);  
			setName(name);  
		}  
		public EmployeeTreeNode(long employeeId, String reportsTo, String name) {  
			setEmployeeId(employeeId, TypeNode.ALBUM);  
			setReportsTo(reportsTo);  
			setName(name);  
		}  */

		/*public void setEmployeeId(long value, TypeNode typeNode) { 
			if(typeNode.equals(TypeNode.PHOTO)){
				setAttribute("EmployeeId", "p"+value); 
			}else if(typeNode.equals(TypeNode.ALBUM)){
				setAttribute("EmployeeId", "a"+value); 
			}

		}  
		 */
		public void setEmployeeId(String value) { 
			setAttribute("EmployeeId", value); 
		}  
		public String getEmployeeId() {  
			return getAttribute("EmployeeId");  
		}  

		/*	public void setReportsTo(EmployeeTreeNode value) {  
			setAttribute("ReportsTo", value.getEmployeeId());  
		}  */
		public void setReportsTo(String value) {  
			setAttribute("ReportsTo", value);  
		}  

		public void setName(String name) {  
			setAttribute("Name", name);  
		}  
	}  

}
