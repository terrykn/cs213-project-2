package util;
import org.junit.Test;
import static org.junit.Assert.*;
import ruclinic.*;

public class ListTest {
    List<Provider> doctors = new List<>();
    List<Technician> technicians = new List<>();

    @Test
    public void test_addDoctor() {
        Profile profile = new Profile("Bob", "Johnson", "10/10/1995");
        Doctor doctor = new Doctor(profile, Location.PISCATAWAY, Specialty.PEDIATRICIAN, "123");
        doctors.add(doctor);
        assertTrue(doctors.contains(doctor));
    }

    @Test
    public void test_addTechnician() {
        Profile profile = new Profile("Jack", "Johnson", "10/10/1995");
        Technician technician = new Technician(profile, Location.PISCATAWAY, 50);
        technicians.add(technician);
        assertTrue(technicians.contains(technician));
    }

    @Test
    public void test_removeDoctor() {
        Profile profile = new Profile("Bob", "Johnson", "10/10/1995");
        Doctor doctor = new Doctor(profile, Location.PISCATAWAY, Specialty.PEDIATRICIAN, "123");
        doctors.add(doctor);
        doctors.remove(doctor);
        assertFalse(doctors.contains(doctor));
    }

    @Test
    public void test_removeTechnician() {
        Profile profile = new Profile("Jack", "Johnson", "10/10/1995");
        Technician technician = new Technician(profile, Location.PISCATAWAY, 50);
        technicians.add(technician);
        technicians.remove(technician);
        assertFalse(technicians.contains(technician));
    }
}