package com.company.test;


import com.company.src.main.Orientation;
import com.company.src.main.Pelouse;
import com.company.src.main.Tondeuse;
import junit.framework.TestCase;
import java.util.Arrays;



public class TondeuseTest extends TestCase {

    Tondeuse tondeuse = new Tondeuse();
    Pelouse pelouse = new Pelouse(5, 5);

    public void testOrientationInitialAuNord(){
        tondeuse.setOrientation(Orientation.NORD);
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    public void testOrientationInitialAuOuest(){
        tondeuse.setOrientation(Orientation.OUEST);
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    public void testOrientationInitialAuSud(){
        tondeuse.setOrientation(Orientation.SUD);
        assertEquals(Orientation.SUD, tondeuse.getOrientation());
    }

    public void testOrientationInitialAuEst(){
        tondeuse.setOrientation(Orientation.EST);
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    public void testOrientationInitialNull(){
        assertNull(tondeuse.getOrientation());
    }

    public void testTournerVersLaGaucheOrientationInitialNord(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.tournerVersLaGauche();
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    public void testTournerVersLaGaucheOrientationInitialOuest(){
        tondeuse.setOrientation(Orientation.OUEST);
        tondeuse.tournerVersLaGauche();
        assertEquals(Orientation.SUD, tondeuse.getOrientation());
    }

    public void testTournerVersLaGaucheOrientationInitialSud(){
        tondeuse.setOrientation(Orientation.SUD);
        tondeuse.tournerVersLaGauche();
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    public void testTournerVersLaGaucheOrientationInitialEst(){
        tondeuse.setOrientation(Orientation.EST);
        tondeuse.tournerVersLaGauche();
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    public void testTournerVersLaDroiteOrientationInitialNord(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.tournerVersLaDroite();
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    public void testTournerVersLaDroiteOrientationInitialEst(){
        tondeuse.setOrientation(Orientation.EST);
        tondeuse.tournerVersLaDroite();
        assertEquals(Orientation.SUD, tondeuse.getOrientation());
    }

    public void testTournerVersLaDroiteOrientationInitialSud(){
        tondeuse.setOrientation(Orientation.SUD);
        tondeuse.tournerVersLaDroite();
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    public void testTournerVersLaDroiteOrientationInitialOuest(){
        tondeuse.setOrientation(Orientation.OUEST);
        tondeuse.tournerVersLaDroite();
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    public void testAvancerOrientationNord(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.setCordX(1);
        tondeuse.setCordY(0);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(1,1),tondeuse.getPosition());
    }

    public void testAvancerOrientationEst(){
        tondeuse.setOrientation(Orientation.EST);
        tondeuse.setCordX(1);
        tondeuse.setCordY(1);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(2,1),tondeuse.getPosition());
    }

    public void testAvancerOrientationSud(){
        tondeuse.setOrientation(Orientation.SUD);
        tondeuse.setCordX(1);
        tondeuse.setCordY(1);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(1,0),tondeuse.getPosition());
    }

    public void testAvancerOrientationOuest(){
        tondeuse.setOrientation(Orientation.OUEST);
        tondeuse.setCordX(1);
        tondeuse.setCordY(1);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(0,1),tondeuse.getPosition());
    }

    public void testAvancerSurUnBordInferieurGauche(){
        tondeuse.setOrientation(Orientation.OUEST);
        tondeuse.setCordX(0);
        tondeuse.setCordY(0);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(0,0),tondeuse.getPosition());
    }

    public void testAvancerSurUnBordInferieurBas(){
        tondeuse.setOrientation(Orientation.SUD);
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

    public void testAvancerSurUnBordSuperieurHaut(){
        tondeuse.setOrientation(Orientation.NORD);
        tondeuse.setCordX(5);
        tondeuse.setCordY(5);
        tondeuse.avancer(pelouse);
        assertEquals(Arrays.asList(5,5),tondeuse.getPosition());
    }

}