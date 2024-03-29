/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weaved.server.configurator;

import com.weaved.server.configurator.palette.PaletteSupport;
import com.weaved.server.xml.ConfigModelWriterFacade;
import com.weaved.server.xml.adapters.FeatureVectorsConfigModelCreator;
import com.weaved.server.xml.adapters.IKASLConfigModelCreator;
import com.weaved.server.xml.adapters.ImportantPercpConfigModelCreator;
import com.weaved.server.xml.adapters.LinkConfigModelCreator;
import com.weaved.server.xml.adapters.PerceptionHierarchyModelCreator;
import com.weaved.server.xml.models.FeatureVectorsConfigModel;
import com.weaved.server.xml.models.IKASLConfigModel;
import com.weaved.server.xml.models.ImportantPercpConfigModel;
import com.weaved.server.xml.models.LinkConfigModel;
import com.weaved.server.xml.models.PerceptionHierarchyModel;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerUtils;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.weaved.server.configurator//configurator//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "configuratorTopComponent",
iconBase = "com/weaved/server/configurator/icon_16.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.weaved.server.configurator.configuratorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_configuratorAction",
preferredID = "configuratorTopComponent")
@Messages({
    "CTL_configuratorAction=configurator",
    "CTL_configuratorTopComponent=Perception Model Builder",
    "HINT_configuratorTopComponent=Perception Model Builder"
})
public final class configuratorTopComponent extends TopComponent {

    public configuratorTopComponent() {
        initComponents();
        setName(Bundle.CTL_configuratorTopComponent());
        setToolTipText(Bundle.HINT_configuratorTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
//        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);

        setLayout(new BorderLayout());
        GraphSceneImpl scene = new GraphSceneImpl();
        JScrollPane shapePane = new JScrollPane();
//        HelpPane = new JEditorPane("text/html", "");
//        HelpPane.setEditable(false);


//        associateLookup(ExplorerUtils.createLookup(scene.em, getActionMap()));
//        associateLookup(Lookups.singleton(PaletteSupport.createPalette()));

        // joint lookup used
        Lookup joint = new ProxyLookup(ExplorerUtils.createLookup(scene.em, getActionMap()), Lookups.singleton(PaletteSupport.createPalette()));
        associateLookup(joint);

        shapePane.setViewportView(scene.createView());



//        HelpPane.setSize(160, 100);
//        HelpPane.setText(getHelpText());

        add(shapePane, BorderLayout.CENTER);
        add(scene.createSatelliteView(), BorderLayout.WEST);
        add(jPanel1, BorderLayout.SOUTH);
//        add(HelpPane, BorderLayout.EAST);



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        helpLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HelpPane = new javax.swing.JEditorPane();

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(configuratorTopComponent.class, "configuratorTopComponent.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(configuratorTopComponent.class, "configuratorTopComponent.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(configuratorTopComponent.class, "configuratorTopComponent.jButton1.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(helpLabel, org.openide.util.NbBundle.getMessage(configuratorTopComponent.class, "configuratorTopComponent.helpLabel.text")); // NOI18N

        HelpPane.setEditable(false);
        HelpPane.setMaximumSize(new java.awt.Dimension(160, 2147483647));
        jScrollPane2.setViewportView(HelpPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(helpLabel)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(helpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TopComponent tc = WindowManager.getDefault().findTopComponent("welcomeTopComponent");

        if (tc != null) {
            tc.open();
            tc.requestActive();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // Save drawn configuration
        LinkConfigModelCreator linkConfigModelCreator = new LinkConfigModelCreator();
        ImportantPercpConfigModelCreator importantPercpConfigModelCreator = new ImportantPercpConfigModelCreator();
        IKASLConfigModelCreator ikaslConfigModelCreator = new IKASLConfigModelCreator();
        FeatureVectorsConfigModelCreator featureVectorsConfigModelCreator = new FeatureVectorsConfigModelCreator();
        PerceptionHierarchyModelCreator perceptionHierarchyModelCreator = new PerceptionHierarchyModelCreator();


        ConfigModelWriterFacade configModelWriterFacade = new ConfigModelWriterFacade();

        configModelWriterFacade.setLinkConfigModel((LinkConfigModel) linkConfigModelCreator.getModel(GraphSceneImpl.nodeMap, GraphSceneImpl.edgeMap));
        configModelWriterFacade.setImportantPercepConfigModel((ImportantPercpConfigModel) importantPercpConfigModelCreator.getModel(GraphSceneImpl.nodeMap, GraphSceneImpl.edgeMap));
        configModelWriterFacade.setiKASLConfigModel((IKASLConfigModel) ikaslConfigModelCreator.getModel(GraphSceneImpl.nodeMap, GraphSceneImpl.edgeMap));
        configModelWriterFacade.setFeatureVectorsConfigModel((FeatureVectorsConfigModel) featureVectorsConfigModelCreator.getModel(GraphSceneImpl.nodeMap, GraphSceneImpl.edgeMap));
        configModelWriterFacade.setPerceptionHierarchy((PerceptionHierarchyModel) perceptionHierarchyModelCreator.getModel(GraphSceneImpl.nodeMap, GraphSceneImpl.edgeMap));

        // write to xml files
        configModelWriterFacade.createConfigXMLs();

        TopComponent tc = WindowManager.getDefault().findTopComponent("controlTopComponent");

        if (tc != null) {
            tc.open();
            tc.requestActive();
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane HelpPane;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private String getHelpText() {
        String help;

        help = "<html>"
                + "<h1>Help Guide for Weave-D  </h1>"
                + "<p> Through interface you can add components <br>and connect them as you wish </p>"
                + "<p><ol>"
                + "<li> Go to <b>Windows -> Palette</b> </li>"
                + "<li> Drag & Drop relavent components<br> in to screen </li>"
                + "<li> Move components by dragging </li>"
                + "<li> Connect components by drawing <br>lines between components while <br>pressing <b>Ctrl</b> key </li>"
                + "<li> Double click on any component <br>to change properties </li>"
                + "</ol></p>"
                + "</html>";

        return help;
    }
}
