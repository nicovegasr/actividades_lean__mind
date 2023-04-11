export class Name {
  private constructor(private name: string) {  }
  
  public static createName(name: string): Name {
    return new Name(name)
  }
}