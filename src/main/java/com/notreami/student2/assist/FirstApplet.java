package com.notreami.student2.assist;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by notreami on 15/12/30.
 */
public class FirstApplet extends Applet {

    public void paint(Graphics g) {

        //Draw a rectangle width=250, height=100

        g.drawRect(0, 0, 250, 100);

        //Set the color to blue

        g.setColor(Color.blue);

        //Write the message to the web page

        g.drawString("Look at me, I'm a Java Applet!", 10, 50);

    }

}
