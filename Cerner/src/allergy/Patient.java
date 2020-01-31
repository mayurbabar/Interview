package allergy;

import java.util.List;
import java.util.Set;

import temperature.ITemperature;
import temperature.Temperature;

public class Patient extends Person {
	private Set<Allergy> allergy;
    private Set<Medication> medications;
    private Temperature temperature;
    private Set<Nurse> nurse;

    public Patient(final String firstName, final String lastName, final Integer age, final Gender gender1, final List<Address> addressList, final List<Long> contactNo, final Set<Allergy> allergy, final Set<Medication> medications, final Temperature temperature, final Set<Nurse> nurse) {
        super(firstName, lastName, age, gender1, addressList, contactNo);
        this.allergy = allergy;
        this.medications = medications;
        this.temperature = temperature;
        this.nurse = nurse;
    }

    public Set<Allergy> getAllergy() {
        return allergy;
    }

    public void setAllergy(final Set<Allergy> allergy) {
        this.allergy = allergy;
    }

    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(final Set<Medication> medications) {
        this.medications = medications;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(final Temperature temperature) {
        this.temperature = temperature;
    }

    public boolean hasFever(final Temperature temperature) {
    	final ITemperature temp = new Temperature();
        return temp.getCurrentTemp() >= 38.0;
    }

    public Set<Nurse> getNurse() {
        return nurse;
    }

    public void setNurse(final Set<Nurse> nurse) {
        this.nurse = nurse;
    }
}
