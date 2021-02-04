package com.company.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import com.company.model.MapModel;

public class MapView {


    private MapModel map;
    private Pane contenu;
    private Image sol ;
    private Image obstacle ;
    private Image personnage ;


    public MapView(MapModel map, Pane contenu){

        this.map = map;
        sol= new Image("img/rpgTile039.png");
        obstacle=new Image("img/rpgTile157.png");
        personnage=new Image("img/player_stand.png");
        this.contenu=contenu;
    }


    public void initMap(TilePane TilePaneFx) {
        Image im = new Image("RPGpack_sheet.tsx");
        for (int y = 0; y < map.getMap().length; y++) {
            for (int x = 0; x < map.getMap().length; x++) {
                ImageView imw = new ImageView(im);
                //imw.setViewport(new Rectangle2D(map.ge*32, 0, 32, 32));
                TilePaneFx.getChildren().add(imw);
            }
        }
    }
}

