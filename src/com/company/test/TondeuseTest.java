package com.company.test;

import com.company.src.Orientation;
import com.company.src.Tondeuse;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TondeuseTest extends TestCase {

    Tondeuse tondeuse = new Tondeuse();

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

}