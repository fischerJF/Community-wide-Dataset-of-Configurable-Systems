
import javax.swing.JPanel; 

import com.mxgraph.layout.mxFastOrganicLayout; 
import com.mxgraph.swing.mxGraphComponent; 
import com.mxgraph.view.mxGraph; 

public   class  GraphPanel  extends JPanel {
	

	private static final long serialVersionUID = -2707712944901661771L;

	
	private mxGraph graph;

	
	private mxGraphComponent graphComponent;

	
	private mxFastOrganicLayout layout;

	
	private Object cell;

	

	public GraphPanel() {

		graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		graph.insertVertex(parent, null, "1", 10, 10, 90, 90);
		graph.getModel().endUpdate();

		layout = new mxFastOrganicLayout(graph);
		graphComponent = new mxGraphComponent(graph);
		
		this.add(graphComponent);
		cell = graphComponent.getGraph().getSelectionCell();
		if (cell == null
				|| graphComponent.getGraph().getModel().getChildCount(cell) == 0) {
			cell = graphComponent.getGraph().getDefaultParent();
		}
		
		layout.execute(cell);
		graphComponent.setEnabled(setEditable());
	}

	
	
	public mxGraphComponent getGraphComponent() {
		return graphComponent;
	}

	

	private boolean setEditable  () {
		return true;
	}

	
	
	public mxGraph getGraph() {
		return graph;
	}

	
	
	public mxFastOrganicLayout getGraphLayout() {
		return layout;
	}

	
	
	public Object getGraphCell() {
		return cell;
	}

	
	
	public void updateSize() {
		graphComponent.setBounds(0,0, this.getParent().getWidth(), this.getParent().getHeight());
	}


}
