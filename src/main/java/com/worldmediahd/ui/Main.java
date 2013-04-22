package com.worldmediahd.ui;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
public class Main extends VerticalSplitPanel {

    public static final String brownFox = "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. ";

    public Main() {
        // First a vertical SplitPanel
        final HorizontalSplitPanel vert = new HorizontalSplitPanel();
        vert.setHeight("450px");
        vert.setWidth("100%");
        vert.setSplitPosition(150, Sizeable.UNITS_PIXELS);
       addComponent(vert);

        // add a label to the upper area
        //vert.addComponent(new Label(brownFox));

        VerticalLayout barraBotones = new VerticalLayout();
        Button login = new Button("Ingresar");
        Button crearCuenta = new Button("Crear cuenta");
        Button acercaDe = new Button("Acerca de");
        barraBotones.addComponent(login);
        barraBotones.addComponent(crearCuenta);
        barraBotones.addComponent(acercaDe);
        // Add a horizontal SplitPanel to the lower area
        final HorizontalSplitPanel horiz = new HorizontalSplitPanel();
        horiz.setSplitPosition(50); // percent
        //vert.addComponent(horiz);

        vert.addComponent(barraBotones);
        
        // left component:
        horiz.addComponent(new Label(brownFox));

        // right component:
        horiz.addComponent(new Label(brownFox));

        vert.setLocked(true);
        horiz.setLocked(true);
        

    }
}
