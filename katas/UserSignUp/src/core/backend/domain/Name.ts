export class Name {
  private constructor(private name: string) {  }
  
  public static createName(name: string): Name {
    throw new Error("Not implemented")
  }
}