export class Age {
  private constructor(private age: number) {  }
  
  public static createAge(age: number): Age {
    return new Age(age)
  }
}