package org.setup.minecraft;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Renderer extends MapRenderer {


    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {

        try {
            BufferedImage image = ImageIO.read(new URL("https://static.turbosquid.com/Preview/001323/510/3P/64.jpg"));
            mapCanvas.drawImage(20,20,image);
        }catch(IOException e) {

        }

        /*
        mapCanvas.setPixel(10,10, MapPalette.RED);
        mapCanvas.setPixel(50,50,MapPalette.PALE_BLUE);

        for(int x = 25; x < 50; x++) {
            for(int z = 25; z < 50; z++) {
                mapCanvas.setPixel(x,z,MapPalette.PALE_BLUE);
            }
        }
         */

        //mapCanvas.drawText(25,50, MinecraftFont.Font, "Hello world!");
    }
}
