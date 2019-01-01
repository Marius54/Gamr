package com.mygdx.sonofrome.Tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.sonofrome.Screens.PlayScreen;
import com.mygdx.sonofrome.Sprites.InteractiveTileObject;

public class WorldContactListener  implements ContactListener {

    private boolean rightContact,leftContact,upContact,downContact;
    private PlayScreen game;
    private InteractiveTileObject rightTile,leftTile,upTile,downTile;
    Fixture player = null , object = null;

    public WorldContactListener(PlayScreen game){
        this.game = game;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        if(fixA.getUserData() != null && fixB.getUserData() != null) {
            if (fixA.getUserData().toString().toLowerCase().contains("sensor")) {
                player = fixA;
                object = fixB;
            } else if (fixB.getUserData().toString().toLowerCase().contains("sensor")) {
                player = fixB;
                object = fixA;
            }
            if (player.getUserData().equals("rightSensor")) {
                System.out.println("right");
                rightContact = true;
                leftContact = false;
            } else if (player.getUserData().equals("leftSensor")) {
                leftContact = true;
                rightContact = false;
            } else if (player.getUserData().equals("upSensor")) {
                upContact = true;
            } else if (player.getUserData().equals("downSensor")) {
                System.out.println("down");
                downContact = true;
            }
            if (player.getUserData().equals("rightSensor")) {
                rightContact = true;
                rightTile = (InteractiveTileObject) object.getUserData();
                leftTile = null;
            } else if (player.getUserData().equals("leftSensor")) {
                leftContact = true;
                leftTile = (InteractiveTileObject) object.getUserData();
                rightTile = null;
            } else if (player.getUserData().equals("upSensor")) {
                upContact = true;
                upTile = null;
                upTile = (InteractiveTileObject) object.getUserData();
            } else if (player.getUserData().equals("downSensor")) {
                System.out.println("downTile");
                downContact = true;
                downTile = null;
                downTile = (InteractiveTileObject) object.getUserData();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
//        if(fixA.getUserData() != null && fixB.getUserData() != null) {
//            if (fixA.getUserData().toString().toLowerCase().contains("sensor")) {
//                player = fixA;
//                object = fixB;
//            } else if (fixB.getUserData().toString().toLowerCase().contains("sensor")) {
//                player = fixB;
//                object = fixA;
//            }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    public boolean isRightContact() {
        return rightContact;
    }

    public InteractiveTileObject getRightTile(){
        return rightTile;
    }

    public boolean isLeftContact() {
        return leftContact;
    }

    public boolean isUpContact() {
        return upContact;
    }

    public boolean isDownContact() {
        return downContact;
    }

    public InteractiveTileObject getLeftTile() {
        return leftTile;
    }

    public InteractiveTileObject getUpTile() {
        return upTile;
    }

    public InteractiveTileObject getDownTile() {
        return downTile;
    }
}
