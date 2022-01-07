package com.gussoft.utils;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.PropertiesManager;

import javax.swing.*;
import java.awt.*;

public class Nuevo {
    public static void main(String[] args) {
        final String filePath = "C:\\Users\\LENOVO\\Desktop\\businessIT.pdf";//demoS.pdf";//

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // build a component controller
                SwingController controller = new SwingController();
                controller.setIsEmbeddedComponent(true);

                // read stored system font properties.
                //FontPropertiesManager.getInstance().loadOrReadSystemFonts();

                //PropertiesManager properties = PropertiesManager.getInstance();
                //properties.getPreferences().putFloat(PropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, 1.25f);

                SwingViewBuilder factory = new SwingViewBuilder(controller);

                // add interactive mouse link annotation support via callback
                controller.getDocumentViewController().setAnnotationCallback(
                        new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
                JPanel viewerComponentPanel = factory.buildViewerPanel();
                JFrame applicationFrame = new JFrame("Ver documento");
                applicationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                applicationFrame.add(viewerComponentPanel, BorderLayout.CENTER);
                applicationFrame.getContentPane().add(viewerComponentPanel);
                // Now that the GUI is all in place, we can try openning a PDF
                controller.openDocument(filePath);

                // add the window event callback to dispose the controller and
                // currently open document.
                applicationFrame.addWindowListener(controller);

                // show the component
                applicationFrame.pack();
                applicationFrame.setVisible(true);
            }
        });
    }
}
