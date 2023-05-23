export class User {
  public constructor(
    private name: string,
    private email: string,
    private password: string,
    private age: number
  ) {}
  public getName(): string {
    return this.name;
  }
  public getEmail(): string {
    return this.email;
  }
  public getPassword(): string {
    return this.password;
  }
  public getAge(): number {
    return this.age;
  }
}