/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator;

import com.weaved.server.configurator.misc.ConfigNode;
import com.weaved.server.configurator.misc.ConfigPropNode;
import com.weaved.server.configurator.misc.NodeLinks;
import com.weaved.server.configurator.misc.PerceptionConfigNode;
import com.weaved.server.configurator.misc.PerceptionConfigPropNode;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.netbeans.api.visual.action.AcceptProvider;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.action.PopupMenuProvider;
import org.netbeans.api.visual.action.SelectProvider;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.model.ObjectScene;
import org.netbeans.api.visual.model.ObjectSceneEvent;
import org.netbeans.api.visual.model.ObjectSceneEventType;
import org.netbeans.api.visual.model.ObjectSceneListener;
import org.netbeans.api.visual.model.ObjectState;
//import org.netbeans.api.visual.router.CollisionsCollector;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;
//import org.netbeans.modules.visual.router.WidgetsCollisionCollector;
import org.openide.explorer.ExplorerManager;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.NodeOperation;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author BUDDHIMA
 */
public class GraphSceneImpl extends GraphScene<ConfigNode, String> {

    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;
    public ExplorerManager em;
    private final Node root;
    private int nodeCount = 0;
    public static int DIMENTION_ICON_LIMIT = 55;
    public static int FEATURE_ICON_LIMIT = 100;
    private int dimentionCount = 0;
    private int featureCount = 0;
    private int perceptionCount = 0;
    public static HashMap<String, ConfigNode> nodeMap = new HashMap<String, ConfigNode>();
    public static ArrayList<NodeLinks> edgeMap = new ArrayList<NodeLinks>();
//    public static CollisionsCollector widgetCollector = new WidgetsCollisionCollector(connectionLayer);

    public GraphSceneImpl() {
        mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer);
        addChild(connectionLayer);
        addChild(interactionLayer);


        getActions().addAction(ActionFactory.createZoomAction());
        getActions().addAction(ActionFactory.createWheelPanAction());
        
        //
        // the Childfactory creates Nodes for selected Objects 
        final FakeChildFactory childFactory = new FakeChildFactory();

        // A Root Context Node for the ExplorerManager
        root = new AbstractNode(Children.create(childFactory, false));

        // ExplorerManager will create the Proxy Lookups for multiple selected Nodes
        em = new ExplorerManager();
        em.setRootContext(root);

        final ObjectSelectProvider selectProvider = new ObjectSelectProvider(this);
        final WidgetAction selectAction = ActionFactory.createSelectAction(selectProvider);



        // add drag & drop
        getActions().addAction(ActionFactory.createAcceptAction(new AcceptProvider() {
            @Override
            public ConnectorState isAcceptable(Widget widget, Point point, Transferable transferable) {
                Image dragImage = getImageFromTransferable(transferable);
                JComponent view = getView();
                Graphics2D g2 = (Graphics2D) view.getGraphics();
                Rectangle visRect = view.getVisibleRect();
                view.paintImmediately(visRect.x, visRect.y, visRect.width, visRect.height);
                g2.drawImage(dragImage,
                        AffineTransform.getTranslateInstance(point.getLocation().getX(),
                        point.getLocation().getY()),
                        null);
                return ConnectorState.ACCEPT;
            }

            @Override
            public void accept(Widget widget, Point point, Transferable transferable) {
                Image image = getImageFromTransferable(transferable);
//                Widget w = addNode("1node x - " + nodeCount++); // adding nodes dynamically
//                System.out.println(image.getHeight(null));
                int imageReceivedHeight = image.getHeight(null);

                Widget w = null;
                ConfigNode cn = null;

                if (imageReceivedHeight < DIMENTION_ICON_LIMIT) {

                    String key = "L2F" + String.valueOf(dimentionCount++);
                    cn = new ConfigNode(image, key);
                    nodeMap.put(key, cn);
                    w = GraphSceneImpl.this.addNode(cn);
                } else if (imageReceivedHeight < FEATURE_ICON_LIMIT) {

                    String key = "L1F" + String.valueOf(featureCount++);
                    cn = new ConfigNode(image, key);
                    nodeMap.put(key, cn);
                    w = GraphSceneImpl.this.addNode(cn);
                } else {

                    String key = "L0F" + String.valueOf(perceptionCount++);
                    cn = new PerceptionConfigNode(image, key);
                    nodeMap.put(key, cn);
                    w = GraphSceneImpl.this.addNode(cn);
                }

//                Widget w = GraphSceneImpl.this.addNode(new ConfigNode(image, "2"));//

                w.getActions().addAction(selectAction);

                w.setPreferredLocation(widget.convertLocalToScene(point));
            }
        }));



        // Object listener
        addObjectSceneListener(new ObjectSceneListener() {
            @Override
            public void objectAdded(ObjectSceneEvent ose, Object o) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void objectRemoved(ObjectSceneEvent ose, Object o) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void objectStateChanged(ObjectSceneEvent ose, Object o, ObjectState os, ObjectState os1) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void selectionChanged(ObjectSceneEvent event, Set<Object> previousSelection, Set<Object> newSelection) {
//                throw new UnsupportedOperationException("Not supported yet.");
                childFactory.setKeys(newSelection);
                try {
                    em.setSelectedNodes(root.getChildren().getNodes());
                } catch (PropertyVetoException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }

            @Override
            public void highlightingChanged(ObjectSceneEvent ose, Set<Object> set, Set<Object> set1) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void hoverChanged(ObjectSceneEvent ose, Object o, Object o1) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void focusChanged(ObjectSceneEvent ose, Object o, Object o1) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        }, ObjectSceneEventType.OBJECT_SELECTION_CHANGED);

    }

    @Override
    protected Widget attachNodeWidget(ConfigNode arg) {
        IconNodeWidget widget = new IconNodeWidget(this);
        if (arg.getId().startsWith("L2F")) {
            widget.setImage(ImageUtilities.loadImage("com/weaved/server/configurator/images/d.png"));
        } else if (arg.getId().startsWith("L1F")) {
            widget.setImage(ImageUtilities.loadImage("com/weaved/server/configurator/images/f.png"));
        } else {
            widget.setImage(ImageUtilities.loadImage("com/weaved/server/configurator/images/p.png"));
        }

        widget.getActions().addAction(
                ActionFactory.createExtendedConnectAction(
                connectionLayer, new MyConnectProvider()));

        widget.getActions().addAction(
                ActionFactory.createAlignWithMoveAction(
                mainLayer, interactionLayer,
                ActionFactory.createDefaultAlignWithMoveDecorator()));

        widget.getActions().addAction(ActionFactory.createPopupMenuAction(new PopupMenuProvider() {
            @Override
            public JPopupMenu getPopupMenu(final Widget widget, Point localLocation) {
                JPopupMenu popup = new JPopupMenu();

                // Properties 
                JMenuItem propsMenu = new JMenuItem("Properties");
                propsMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object object = findObject(widget);// consider a map "string" => ShapeObj at creation (drop)
                        ConfigNode node =(ConfigNode) object;

                        if(node.getId().startsWith("L0")){
                            PerceptionConfigPropNode propNode = new PerceptionConfigPropNode((PerceptionConfigNode) node);
                            propNode.setDisplayName("Node Settings");
                            propNode.setShortDescription("Click on properties to get a small discription about the property");
                            NodeOperation.getDefault().showProperties(propNode);
                        } else {
                            ConfigPropNode propNode = new ConfigPropNode(node);
                            propNode.setDisplayName("Node Settings");
                            propNode.setShortDescription("Click on properties to get a small discription about the property");
                            NodeOperation.getDefault().showProperties(propNode);
                        }

                        
                    }
                });

                // Delete
                JMenuItem deleteMenu = new JMenuItem("Delete");
                deleteMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ConfigNode cn = (ConfigNode) findObject(widget);

                        List<Widget> connections = connectionLayer.getChildren();


                        for (Widget connection : connections) {
                            ConnectionWidget conn = (ConnectionWidget) connection;


                            if (conn.getSourceAnchor().getRelatedWidget().equals(widget)) {

                                connectionLayer.removeChild(conn);
//                                edgeMap.remove(conn);

                            }

                            if (conn.getTargetAnchor().getRelatedWidget().equals(widget)) {

                                connectionLayer.removeChild(conn);
//                                edgeMap.remove(conn);
                            }


                        }


                        GraphSceneImpl.this.removeNode(cn);
                        nodeMap.remove(cn.getId());

                    }
                });

                popup.add(propsMenu);
                popup.add(deleteMenu);

                return popup;
            }
        }));


        widget.setLabel(arg.getId());
        mainLayer.addChild(widget);
        return widget;
    }

    @Override
    protected Widget attachEdgeWidget(String e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeSourceAnchor(String e, ConfigNode n, ConfigNode n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeTargetAnchor(String e, ConfigNode n, ConfigNode n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Image from transferable
    private Image getImageFromTransferable(Transferable transferable) {
        Object o = null;
        try {
            o = transferable.getTransferData(DataFlavor.imageFlavor);

        } catch (IOException ex) {
        } catch (UnsupportedFlavorException ex) {
        }
        return o instanceof Image ? (Image) o : ImageUtilities.loadImage("com/weaved/server/configurator/images/d.png");
    }

    // Connection Provider
    private class MyConnectProvider implements ConnectProvider {

        public boolean isSourceWidget(Widget source) {
            return source instanceof IconNodeWidget && source != null ? true : false;
        }

        @Override
        public ConnectorState isTargetWidget(Widget src, Widget trg) {
            return src != trg && trg instanceof IconNodeWidget ? ConnectorState.ACCEPT : ConnectorState.REJECT;
        }

        public boolean hasCustomTargetWidgetResolver(Scene arg0) {
            return false;
        }

        public Widget resolveTargetWidget(Scene arg0, Point arg1) {
            return null;
        }

        public void createConnection(Widget source, Widget target) {

            // Select necessary nodes only

            ConfigNode cnSource = (ConfigNode) findObject(source);
            ConfigNode cnTarget = (ConfigNode) findObject(target);

            String cnSourceIdType = cnSource.getId().substring(0, 2);
            String cnTargetIdType = cnTarget.getId().substring(0, 2);
            
            String type = "TEMPORAL";
            

            // filter relavent links only
            if ((cnSourceIdType.equals("L2") && cnTargetIdType.equals("L1"))
                    || (cnSourceIdType.equals("L1") && cnTargetIdType.equals("L0"))
                    || (cnSourceIdType.equals(cnTargetIdType))) {

                ConnectionWidget conn = new ConnectionWidget(GraphSceneImpl.this);
                conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
                                
                // Double arrow head for cross features
                if(cnSourceIdType.equals(cnTargetIdType)){
                    conn.setSourceAnchorShape(AnchorShape.TRIANGLE_FILLED);
                    type = "CROSS";
                }
                
//                conn.setRouter(RouterFactory.createOrthogonalSearchRouter(GraphSceneImpl.widgetCollector));
                conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
                conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
                connectionLayer.addChild(conn);
                edgeMap.add(new NodeLinks(type, cnSource.getId(), cnTarget.getId()));
            }
        }
    }

    // Selection Provider
    private class ObjectSelectProvider implements SelectProvider {

        ObjectScene scene;

        public ObjectSelectProvider(ObjectScene scene) {
            this.scene = scene;
        }

        public boolean isAimingAllowed(Widget widget, Point localLocation, boolean invertSelection) {
            return false;
        }

        public boolean isSelectionAllowed(Widget widget, Point localLocation, boolean invertSelection) {
            return true;
        }

        public void select(Widget widget, Point localLocation, boolean invertSelection) {
            Object object = scene.findObject(widget);// consider a map "string" => ShapeObj at creation (drop)

            if(((ConfigNode)object).getId().startsWith("L0")){
                PerceptionConfigPropNode propNode = new PerceptionConfigPropNode((PerceptionConfigNode) object);
                propNode.setDisplayName("Node Settings");
                propNode.setShortDescription("Short Discription");
                NodeOperation.getDefault().showProperties(propNode);
            }else{
                ConfigPropNode propNode = new ConfigPropNode((ConfigNode) object);
                propNode.setDisplayName("Node Settings");
                propNode.setShortDescription("Short Discription");
                NodeOperation.getDefault().showProperties(propNode);
            }

            


            if (object != null) {
                if (scene.getSelectedObjects().contains(object)) {
                    return;
                }
                scene.userSelectionSuggested(Collections.singleton(object), invertSelection);
            } else {
                scene.userSelectionSuggested(Collections.emptySet(), invertSelection);
            }
        }
    }
}
