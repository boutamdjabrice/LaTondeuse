package com.company.test;

import com.company.src.Orientation;
import com.company.src.Tondeuse;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseTest extends TestCase {


    public void testOriendationInitialAuNord(){
        Tondeuse tondeuse = new Tondeuse();
        tondeuse.setOrientation(Orientation.NORD);
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

}