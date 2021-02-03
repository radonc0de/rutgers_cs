/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Keith Lehman [email:kpl56@scarletmail.rutgers.edu, netid:kpl56]
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        
        //for(int i = 0; i < listOfPatients.length; i++){
            listOfPatients = null;
        //}
        //for(int i = 0; i < survivabilityByAge.length; i++){
            survivabilityByAge = null;
        //}
        //for(int i = 0; i < survivabilityByCause.length; i++){
            survivabilityByAge = null;
        //}
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        int maxIndex = listOfPatients.length - 1;
        if (arrayIndex <= maxIndex){
            listOfPatients[arrayIndex] = p;
            return 0;
        }else{
            return -1;
        }
        
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        listOfPatients = new Person[numberOfLines];
        int peopleRead = 0;
        for(int i = 0; i < numberOfLines; i++){
            Person patient = new Person(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            addPerson(patient, i);
            peopleRead++;
        }
        return peopleRead;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge[numberOfLines]; 
        int rates = 0;
        for(int i = 0; i < numberOfLines; i++){
            SurvivabilityByAge surv = new SurvivabilityByAge(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            survivabilityByAge[i] = surv;
            rates++;
        }
        return rates;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        int rates = 0;
        for(int i = 0; i < numberOfLines; i++){
            SurvivabilityByCause surv = new SurvivabilityByCause(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            survivabilityByCause[i] =  surv;
            rates++;
        }       
        return rates;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        int patientsAgeAbove = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getAge() > age){
                patientsAgeAbove++;
            }
        }
        Person ageAbove[] = new Person[patientsAgeAbove];
        int ageAboveIndex = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getAge() > age){
                ageAbove[ageAboveIndex] = listOfPatients[i];
                ageAboveIndex++;
            }
        }
        if (ageAbove.length > 0){
            return ageAbove;
        }else{
            return null;
        }
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        int patientsHealthAbove = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getStateOfHealth() == state){
                patientsHealthAbove++;
            }
        }
        Person healthAbove[] = new Person[patientsHealthAbove];
        int healthAboveIndex = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getStateOfHealth() == state){
                healthAbove[healthAboveIndex] = listOfPatients[i];
                healthAboveIndex++;
            }
        }
        if (healthAbove.length > 0){
            return healthAbove;
        }else{
            return null;
        }
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        int num = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getCause() == cause){
                num++;
            }
        }
        Person causeArr[] = new Person[num];
        int causeIndex = 0;
        for(int i = 0; i < listOfPatients.length; i++){
            if(listOfPatients[i].getCause() == cause){
                causeArr[causeIndex] = listOfPatients[i];
                causeIndex++;
            }
        }
        if (causeArr.length > 0){
            return causeArr;
        }else{
            return null;
        }

    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {
        int length = 0;
        if (numberOfHearts > listOfPatients.length) {
            length = listOfPatients.length;    
        }else{
            length = numberOfHearts;
        }
        
        Person matches[] = new Person[length];
        int choices[] = new int[length];
        for(int i = 0; i < length; i++){
            choices[i] = -1;
        }
        
        
        for (int i = 0; i < length; i++){
            int index = 574;
            boolean exists = true;
            while (exists) {
                index = StdRandom.uniform(0, listOfPatients.length);
                exists = false;
                for (int j = 0; j < length; j++){
                    if (choices[j] == index){
                        exists = true;
                        if (index == 0){
                        }
                    }
                }
            }
            choices[i] = index;
            matches[i] = listOfPatients[index];

        } 



        /*for(int i = 0; i < matches.length; i++){
            matches[i] = listOfPatients[i];
                
        } */       
        return matches;
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();
        
        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");

        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }
        
        Person matches[] = ht.match(Integer.parseInt(args[0]));

        for(int i = 0; i < matches.length; i++){
            StdOut.println(i + " " + matches[i]);
        
        }
    }
}
