package com.company.test;

import com.company.src.Orientation;
import com.company.src.Pelouse;
import com.company.src.Tondeuse;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TondeuseTest extends TestCase {

    Tondeuse tondeuse = new Tondeuse();
    Pelouse pelouse = new Pelouse(5,5);

    public void testOrientationInitialAuNord(){
        tondeuse.setOrientation(Orientation.NORD);
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    public void testOrientationInitialNull(){
        assertNull(tondeuse.getOrientation());
    }

    public void testTournerVersLaGauche(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.tournerVersLaGauche();
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    public void testTournerVersLaDroite(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.tournerVersLaDroite();
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    public void testAvancer(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.setCordX(1);
        tondeuse.setCordY(0);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(1,1),tondeuse.getPosition());
    }

    public void testAvancerSurUnBordInferieurGauche(){
        tondeuse.setOrientation(Orientation.OUEST);
        tondeuse.setCordX(0);
        tondeuse.setCordY(0);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(0,0),tondeuse.getPosition());
    }

    public void testAvancerSurUnBordSuperieurDroit(){
        tondeuse.setOrientation(Orientation.EST);
        tondeuse.setCordX(5);
        tondeuse.setCordY(5);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(5,5),tondeuse.getPosition());
    }

}