package viewer.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import viewer.data.Image;
import viewer.data.Patient;
import viewer.data.Series;
import viewer.data.Study;

public class PatientTree extends JTree
{
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("patients");
	
	public PatientTree()
	{
		setModel(new DefaultTreeModel(root));
		setCellRenderer(new CellRenderer());
	}
	
	public void setPatients(Collection<Patient> patients)
	{
		root.removeAllChildren();
		for (Patient p : new TreeSet<Patient>(patients))
		{
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(p);
			root.add(child);
			addStudies(p.getStudies(), child);
		}
		setModel(new DefaultTreeModel(root));
	}
	
	public Object getSelectedObject()
	{
		TreePath path = getSelectionPath();
		if (path != null)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
			if (node != null)
				return node.getUserObject();
		}
		return null;
	}

	private void addStudies(Collection<Study> studies,
			DefaultMutableTreeNode node)
	{
		for (Study s : new TreeSet<Study>(studies))
		{
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(s);
			node.add(child);
			addSeries(s.getSeries(), child);
		}
		
	}

	private void addSeries(Collection<Series> series,
			DefaultMutableTreeNode node)
	{
		for (Series s : new TreeSet<Series>(series))
		{
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(s);
			node.add(child);
			addImages(s.getImages(), child);
		}
		
	}

	private void addImages(Collection<Image> images, DefaultMutableTreeNode node)
	{
		for (Image i : new TreeSet<Image>(images))
			node.add(new DefaultMutableTreeNode(i));		
	}
	
	
	
	private class CellRenderer extends DefaultTreeCellRenderer
	{

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
		{
			
			Component c =  super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			Object content = node.getUserObject();
			
			if (content instanceof Patient)
				setText(((Patient)content).getPatientName());
			else if (content instanceof Study)
				setText(((Study)content).getStudyBegin().toString());
			else if (content instanceof Series)
				setText("Series " + ((Series)content).getSeriesNumber());
			else if (content instanceof Image)
				setText("Image " + ((Image)content).getImageNumber());

			
			return c;
		}
		
	}

}
