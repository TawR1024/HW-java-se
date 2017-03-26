# Collections Task 3

According to this data:
```java
class MedicalStaff {}
class Doctor extends MedicalStaff {}
class Nurse extends MedicalStaff {}
class HeadDoctor extends Doctor {}
```

| Assignment                                              |  Correct| Incorrect|               Explanation                                                                              |             
|:--------------------------------------------------------|:----:|:----:|:-------------------------------------------------------------------------------------------------------------:|
|`Doctor doctor = new Doctor();`                          |  ✔   |      |Direct assigment                                                                                               |
| `Doctor doctor = new MedicalStaff();`                   |      |  ✔   |`Doctor` is subclass of `MedicalStaf`, so we cant assign superclass to subclass                                |
| `Doctor doctor = new HeadDoctor();`                     |  ✔   |      | We can assign objects of subclass to superclass                                                               |
| `Object object = new HeadDoctor();`                     |  ✔   |      |All objects are heirs of `Object`, so we can assign`HeadDoctor` to `Object`                                    |
| `HeadDoctor doctor = new Object();`                     |      | ✔    |`Object` isn\`t subclass of `HeadDoctor`                                                                       |
| `Doctor doctor = new Nurse();`                          |      |  ✔   |`Nurse` isn\`t subclass of `Doctor`                                                                            |
| `Nurse nurse = new Doctor();`                           |      |   ✔  |`Doctor` isn\`t subclass if `Nurse`                                                                            | 
| `Object object = new Nurse();`                          |  ✔   |      |All classes in java extends Object                                                                             |
| `List<Doctor> doctors = new ArrayList<Doctor>();`       |  ✔   |      |Working with `ArrayList<Doctor>` by interface `List<Doctor>`                                                   |
| `List<MedicalStaff> doctors = new ArrayList<Doctor>();` |      | ✔    |`ArrayList<Doctor>` is not a subtype of `List<MedicalStaff>`                                                   |
| `List<Doctor> doctors = new ArrayList<MedicalStaff>();` |      |  ✔   |`ArrayList<MedicalStaff>` is not a subtype of `List<Doctor>`                                                    |
| `List<Object> doctors = new ArrayList<Doctor>();`       |      |  ✔   | `ArrayList<MedicalStaff>` is not a subtype of `List<Doctor>`                                                  |
| `List<Object> doctors = new ArrayList<Object>();`       |  ✔   |      |Working with `ArrayList<Object>` by interface `List<Object>`                                                   |