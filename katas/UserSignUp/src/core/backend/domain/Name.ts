export class Name {
  private constructor(public name: string) {  }
  
  public static createName(name: string): Name {
    if (!name) { throw new Error("Name cannot be empty.")} 
    return new Name(name)
  }
}