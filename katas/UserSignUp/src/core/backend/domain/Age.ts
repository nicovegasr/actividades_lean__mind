export class Age {
  private constructor(private age: number) {  }
  
  public static createAge(age: number): Age {
    const ageIsNotUnder13 = age > 13
    if (ageIsNotUnder13) { return new Age(age) }
    throw new Error("You have to be 13 years old or older to create an Age.")
  }
}