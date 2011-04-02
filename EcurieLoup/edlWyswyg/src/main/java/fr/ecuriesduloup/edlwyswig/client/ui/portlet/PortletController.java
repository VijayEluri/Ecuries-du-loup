/*
 * Copyright 2009 Fred Sauer
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.allen_sauer.gwt.dnd.client.DragEndEvent;
import com.allen_sauer.gwt.dnd.client.DragHandler;
import com.allen_sauer.gwt.dnd.client.DragStartEvent;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.google.gwt.user.client.ui.AbsolutePanel;


public class PortletController {

  private final AbsolutePanel boundaryPanel;

  private PickupDragController pickupDragController;

  private ResizeDragController resizeDragController;

  public PortletController(AbsolutePanel boundaryPanel) {
    this.boundaryPanel = boundaryPanel;

    pickupDragController = new PickupDragController(boundaryPanel, true);
    pickupDragController.addDragHandler(new DragHandler() {
		
		@Override
		public void onPreviewDragStart(DragStartEvent event)
				throws VetoDragException {
			((Portlet)event.getSource()).onPreviewDragStart();
			
		}
		
		@Override
		public void onPreviewDragEnd(DragEndEvent event) throws VetoDragException {
			((Portlet)event.getSource()).onPreviewDragEnd();
			
		}
		
		@Override
		public void onDragStart(DragStartEvent event) {
			((Portlet)event.getSource()).onDragStart();
			
		}
		
		@Override
		public void onDragEnd(DragEndEvent event) {
			((Portlet)event.getSource()).onDragEnd();
			
		}
	});
    pickupDragController.setBehaviorConstrainedToBoundaryPanel(true);
    pickupDragController.setBehaviorMultipleSelection(false);

    resizeDragController = new ResizeDragController(boundaryPanel);
    resizeDragController.setBehaviorConstrainedToBoundaryPanel(true);
    resizeDragController.setBehaviorMultipleSelection(false);
  }

  public AbsolutePanel getBoundaryPanel() {
    return boundaryPanel;
  }

  public PickupDragController getPickupDragController() {
    return pickupDragController;
  }

  public ResizeDragController getResizeDragController() {
    return resizeDragController;
  }
}

