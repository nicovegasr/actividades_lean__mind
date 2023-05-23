export class UserRequestValidate {
  private constructor(private name: string, private email: string, private password: string, private age: number) {}

  public static create(name: string, email: string, password: string, age: number): UserRequestValidate {
    return new UserRequestValidate(name, email, password, age);
  }
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