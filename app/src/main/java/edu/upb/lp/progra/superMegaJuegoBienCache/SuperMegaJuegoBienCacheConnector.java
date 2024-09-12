package edu.upb.lp.progra.superMegaJuegoBienCache;

import edu.upb.lp.progra.adapterFiles.AndroidLibrary;
import edu.upb.lp.progra.adapterFiles.AppConnector;

public class SuperMegaJuegoBienCacheConnector implements AppConnector {
   private AndroidLibrary lib;
   private SuperMegaJuegoBienCacheGame game = new SuperMegaJuegoBienCacheGame(this);


   public SuperMegaJuegoBienCacheConnector(AndroidLibrary lib) {
        this.lib = lib;
    }


    @Override
    public void onButtonPressed(String name) {
        if (name.equals("RESTART")){
             for (int v = 0; v < 3; v++) {
                for (int h = 0; h < 3; h++) {
                lib.setImageOnCell(v,h,"colors_grey");
                }
            }

        }
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        lib.setImageOnCell(vertical, horizontal, "colors_blue");
    }

    @Override
    public void initialiseInterface() {
        lib.configureScreen(3,3,2,2,true,0.3);
        for (int v = 0; v < 3; v++) {
            for (int h = 0; h < 3; h++) {
                lib.setImageOnCell(v,h,"colors_grey");
            }
        }
        lib.addButton("RESTART",20,50);
    }

}
