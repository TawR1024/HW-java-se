# Collections Task 3

According to this data:
```java
class MedicalStaff {}
class Doctor extends MedicalStaff {}
class Nurse extends MedicalStaff {}
class HeadDoctor extends Doctor {}
```

| Assignment                                              |  True| False|               Explanation                                                                                      |             
|:--------------------------------------------------------|:----:|:----:|-------------------------------------------------------------------------------------------------------------:|
|`Doctor doctor = new Doctor();`                          |  ✔   |      |                                                                                                |
| `Doctor doctor = new MedicalStaff();`                   |      |  ✔   |                                                  |
| `Doctor doctor = new HeadDoctor();`                     |  ✔   |      |                                                  |
| `Object object = new HeadDoctor();`                     |  ✔   |      |                                                  |
| `HeadDoctor doctor = new Object();`                     |      | ✔    |                                                  |
| `Doctor doctor = new Nurse();`                          |      |      |                                                  |
| `Nurse nurse = new Doctor();`                           |      |      |                                                  |
| `Object object = new Nurse();`                          |  ✔   |      |                                                  |
| `List<Doctor> doctors = new ArrayList<Doctor>();`       |  ✔   |      |                                                  |
| `List<MedicalStaff> doctors = new ArrayList<Doctor>();` |      | ✔    |                                                  |
| `List<Doctor> doctors = new ArrayList<MedicalStaff>();` |      |  ✔   |                                                  |
| `List<Object> doctors = new ArrayList<Doctor>();`       |      |  ✔   |                                                  |
| `List<Object> doctors = new ArrayList<Object>();`       |  ✔   |      |                                                  |