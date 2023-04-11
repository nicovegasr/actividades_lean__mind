export class Age {
  private constructor(public age: number) {  }
  
  public static createAge(age: number): Age {
    const ageIsUnder13 = age < 13
    const ageIsNotAnInteger = !Number.isInteger(age) 
    if (ageIsNotAnInteger) { throw new Error("Age must be an integer.") }
    if (ageIsUnder13) { throw new Error("You have to be 13 years old or older to create an Age.") }
    return new Age(age)
  }
}